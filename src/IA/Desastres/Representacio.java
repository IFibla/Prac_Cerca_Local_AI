package IA.Desastres;
import java.lang.Math;

public class Representacio {
    
    private Grupos g;
    private Centros c;

    public Representacio ( int ncentros, int helicopteros, int ngrupos, int seed ) {
        this.g = new Grupos( ngrupos, seed );
        this.c = new Centros( ncentros, helicopteros, seed );
    }

    private double getDistance ( int coordX1, int coordX2, int coordY1, int coordY2 ) {
        return Math.sqrt( Math.pow((coordX1 - coordX2), 2) + Math.pow((coordY1 - coordY2), 2) );
    }

    public void printGrupos () {
        for ( int i = 0; i < this.g.size(); ++i ) {
            System.out.println("grupos[index++] = new Grupos(" + ((Grupo)g.get(i)).getCoordX() + 
                "," + ((Grupo)g.get(i)).getCoordY() + "," + ((Grupo)g.get(i)).getNPersonas() + 
                "," + ((Grupo)g.get(i)).getPrioridad() + ");");
        }
    }

    public void printCentros () {
        for ( int i = 0; i < this.c.size(); ++i ) {
            System.out.println("centros[index++] = new Centro(" + ((Centro)c.get(i)).getCoordX() + 
                "," + ((Centro)c.get(i)).getCoordY() + "," + ((Centro)c.get(i)).getNHelicopteros() + ");");
        }
    }

    public void possibleEstatInicial () {
        double startTime = System.nanoTime();
        double time = 0;
        Centro start = (Centro)c.get(0);

        for ( int i = 0; i < g.size(); ++i ) {
            Grupo grupo = (Grupo)g.get(i);
            
            System.out.println("At instant " + time + " we are going to pick up a group of " + grupo.getNPersonas() + " people of priority " + grupo.getPrioridad() + " at coord " + grupo.getCoordX() + ", " + grupo.getCoordY());

            double distance = getDistance(start.getCoordX(), start.getCoordY(), grupo.getCoordX(), grupo.getCoordY());
            double tripTime = (1.0f/3.6f) * distance;
            double pickUpTime = 0;
            
            if (grupo.getPrioridad() == 2) {
                pickUpTime = 60 * grupo.getNPersonas();
            }
            else {
                pickUpTime = 60 * 2 * grupo.getNPersonas();
            }

            time += pickUpTime + ( 2 * tripTime ) + 600;
        }

        double endTime = System.nanoTime();
        double exTime = (endTime - startTime) / Math.pow(10, 9);

        System.out.println("Execution time: " + exTime);
        System.out.println("Time to get people ( /s ): " + time);
        System.out.println("Time to get people ( /h ): " + time/3600);
    }

}
