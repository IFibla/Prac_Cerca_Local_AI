package IA.Desastres;

import java.util.ArrayList;
import java.util.Random;

public class Estado {
    
    public static final int SPEED = 100; 
    public static final double ALPHA = 1; 
    public static final double BETA = 1; 
    public static final double OMEGA = 1; 

    public static Grupos g;
    public static Centros c;

    private ArrayList < ArrayList < Nodo > > Schedule;
    // Es el scheduler de helicopteros, por ejemplo, sale del C1, va a buscar el grupo G2 y vuelve al centro C2.
    // Cada fila de la matriz representa un helicoptero.

    private double heuristic;

    public Estado ( Estado e, int h, int p ) {
        this.Schedule = e.Schedule;
        this.deleteOperation(h, p);
        this.calculateHeuristicCost1();
    }

    public Estado ( Estado e, int h1, int p1, int h2, int p2 ) {
        this.Schedule = e.Schedule;
        this.swapOperation(h1, h2, p1, p2);
        this.calculateHeuristicCost1();
    }

    public Estado ( int numHelicopteros ) {
        
        Schedule = new ArrayList < ArrayList < Nodo > > ();

        int it = 0;
        for ( int i = 0; i < c.size(); ++i ) {
            int cNumHelicopteros = ((Centro)c.get(i)).getNHelicopteros() + it;
            while ( cNumHelicopteros > it ) {
                Nodo n = new Nodo(Nodo.CENTRO, i, ((Centro)c.get(i)).getCoordX(), ((Centro)c.get(i)).getCoordY());
                ArrayList<Nodo> a = new ArrayList<Nodo>();
                a.add(n);
                Schedule.add(a);
                ++it;
            }
        }

        for ( int i = 0; i < g.size(); i += numHelicopteros * c.size()) {
            addGrupos(i);
            addCentros();
        }

        calculateHeuristicCost1();
    }

    public Estado ( int numHelicopters, int seed ) {
        
        Random myRandom = new Random((long)seed);
        Schedule = new ArrayList < ArrayList < Nodo > > (numHelicopters);

        int numeroGrupos = g.size();
        int counter = 0;
        int actualHelicopter = 0;
        boolean [] checkList = new boolean[ numeroGrupos ];

        int it = 0;
        for ( int i = 0; i < c.size(); ++i ) {
            int cNumHelicopteros = ((Centro)c.get(i)).getNHelicopteros() + it;
            while ( cNumHelicopteros > it ) {
                Nodo n = new Nodo(Nodo.CENTRO, i, ((Centro)c.get(i)).getCoordX(), ((Centro)c.get(i)).getCoordY());
                ArrayList<Nodo> a = new ArrayList<Nodo>();
                a.add(n);
                Schedule.add(a);
                ++it;
            }
        }

        while ( counter < numeroGrupos) {
            int randNum = myRandom.nextInt(numeroGrupos);
            if ( checkList[randNum] == false ) {
                ++counter;
                checkList[randNum] = true;
                Nodo n = new Nodo(Nodo.GRUPO, randNum, ((Grupo)g.get(randNum)).getCoordX(), ((Grupo)g.get(randNum)).getCoordY());;
                Schedule.get(actualHelicopter).add(n);
                if ( ++actualHelicopter >= ( numHelicopters * c.size() ) ) {
                    addCentros();
                    actualHelicopter = 0;
                }
            }
        }
        addCentros();

        calculateHeuristicCost1();
    }

    private void addCentros ( ) {
        int it = 0;
        for ( int i = 0; i < c.size(); ++i ) {
            int cNumHelicopteros = ((Centro)c.get(i)).getNHelicopteros() + it;
            while ( cNumHelicopteros > it ) {
                Nodo n = new Nodo(Nodo.CENTRO, i, ((Centro)c.get(i)).getCoordX(), ((Centro)c.get(i)).getCoordY());
                if ( Schedule.get(it).get(Schedule.get(it).size()-1).getType() == true )
                    Schedule.get(it).add(n);
                ++it;
            }
        }
    } 

    private void addGrupos ( int startIndex ) {
        for ( int i = startIndex; i < g.size() && i < startIndex + Schedule.size(); ++i ) {
            Nodo n = new Nodo(Nodo.GRUPO, i, ((Grupo)g.get(i)).getCoordX(), ((Grupo)g.get(i)).getCoordY());
            Schedule.get(i-startIndex).add(n);
        }
    }

    private double getMovingTime ( Nodo a, Nodo b ) {
        return Math.sqrt( Math.pow((a.getCoordX() - b.getCoordX()), 2) + Math.pow((a.getCoordY() - b.getCoordY()), 2));
    }

    private void calculateHeuristicCost1 ( ) {
        double travelToGroup1 = 0.0;
        double travelToGroup2 = 0.0;
        double travelToGroup12 = 0.0;
        for ( int i = 0; i < Schedule.size(); ++i ) {
            int helicopterMove = 1;
            while ( helicopterMove < Schedule.get(i).size() ) {
                double movTime = 0.0;
                boolean [] checkList = new boolean [2];
                while ( Schedule.get(i).get(helicopterMove).getType() != Nodo.CENTRO ) {
                    int groupNum = ((Nodo) Schedule.get(i).get(helicopterMove)).getId();
                    checkList[((Grupo)g.get(groupNum)).getPrioridad()-1] = true;
                    movTime += getMovingTime( ((Nodo)Schedule.get(i).get(helicopterMove-1)), ((Nodo) Schedule.get(i).get(helicopterMove)) );
                    ++helicopterMove;
                }
                movTime += getMovingTime( ((Nodo)Schedule.get(i).get(helicopterMove-1)), ((Nodo) Schedule.get(i).get(helicopterMove)) );
                if ( checkList[0] && checkList[1] ) travelToGroup12 += movTime;
                else if ( checkList[0] ) travelToGroup1 += movTime;
                else if ( checkList[1] ) travelToGroup2 += movTime;
                ++helicopterMove;
            }
        }

        this.heuristic = ALPHA * travelToGroup1 + BETA * travelToGroup2 + OMEGA * travelToGroup12;
    }

    @Override
    public String toString () {
        String result = "";
        for ( int i = 0; i < Schedule.size(); ++i ) {
            for ( int j = 0; j < Schedule.get(i).size(); ++j ) 
                result = result.concat(Schedule.get(i).get(j).toString());
            result = result.concat("\n");
        } 
        return result;
    }

    public void swapOperation ( int h1, int h2, int p1, int p2 ) {
        Nodo aux = Schedule.get(h1).get(p1);
        Schedule.get(h1).set(p1, Schedule.get(h2).get(p2));
        Schedule.get(h2).set(p2, aux);
    }

    public void deleteOperation ( int h, int p ) {
        if ( Schedule.get(h).get(p).getType() == Nodo.CENTRO && p != 0 && p != Schedule.get(h).size() )
            Schedule.get(h).remove(p);
    }

    public double getHeuristicValue () {
        return this.heuristic;
    }

    public int getSizeX () {
        return Schedule.size();
    }
    
    public int getSizeY () {
        return Schedule.get(0).size();
    }
}
