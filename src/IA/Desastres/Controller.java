package IA.Desastres;

import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SearchAgent;
import aima.search.informed.HillClimbingSearch;
import aima.search.informed.SimulatedAnnealingSearch;

import java.io.*;

import java.util.List;
import java.util.Iterator;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

public class Controller {

    SuccessorFunction0 sf;
    HeuristicFunction0 h;
    int nhelicopters;

    public Controller ( int ncentros, int nhelicopters, int ngrupos, int seed ) {
        Estado.g = new Grupos ( ngrupos, seed );
        Estado.c = new Centros ( ncentros, nhelicopters, seed );
        this.h = new HeuristicFunction0();
        this.sf = new SuccessorFunction0();
        this.nhelicopters = nhelicopters;
    }

    private void setAccions(List actions, Estado e, long temps) 
    {
        System.out.println(e);
        System.out.println("Temps total: " + e.getOperativeTime());
        System.out.println("Valor del heuristic: " + e.getHeuristicValue());
        String accions = new String();
        for (int i = 0; i < actions.size(); i++) {
            String action = (String) actions.get(i);
            String [] op = action.split(" ");
            if ( op[0].equals("Swap")) {
                e.swapOperation(Integer.parseInt(op[1]), Integer.parseInt(op[2]),
                    Integer.parseInt(op[3]), Integer.parseInt(op[4]));
                System.out.println("Swap between (" + op[1] + ", " + op[2] + ") and (" + op[3] + ", " + op[4] + ")");
            }
            else {
                e.deleteOperation(Integer.parseInt(op[1]), Integer.parseInt(op[2]));
                System.out.println("Delete (" + op[1] + ", " + op[2] + ")");
            }

            accions += action+"\n";
        }
        System.out.println("\n");
        System.out.println(e);
        e.calculateHeuristicCost1();
        System.out.println("Temps total: " + e.getOperativeTime());
        System.out.println("Valor del heuristic: " + e.getHeuristicValue());

    }

	private static void printActions(List actions, Estado e) {
		for (int i = 0; i < actions.size(); i++) {
			String action = (String) actions.get(i).toString();
			//System.out.println(action);
            //System.out.println("Temps total: " + ((Estado) actions.get(i)).getOperativeTime());
            //System.out.println(e.getOperativeTime() + " " + ((Estado) actions.get(i)).getOperativeTime());
		}
	}

    private void setInstrumentation(Properties properties, long temps) 
	{
        //for ( int i = 0; i < 20; ++i ) System.out.print("-");
        //System.out.println();
        //for ( int i = 0; i < 20; ++i ) System.out.print("-");
        //System.out.println();
        String propietats = new String();
        propietats += "Temps de cerca: "+temps+" ms\n";
        Iterator keys = properties.keySet().iterator();
        if (keys.hasNext()) {
            String key = (String) keys.next();
            String property = properties.getProperty(key);
            propietats += "Nodes expandits: "+property+"\n";
        }
        System.out.print(propietats);
	}

    public void executeHillClimbing ( int repetitions, int seed ) {
        for ( int i = 0; i < 20; ++i ) System.out.print("-");
        System.out.println();
        for ( int i = 0; i < 20; ++i ) System.out.print("-");
        System.out.println();
        System.out.println("Execution with Hill Climbing Search");
        for ( int i = 0; i < 20; ++i ) System.out.print("-");
        System.out.println();
        for ( int i = 0; i < 20; ++i ) System.out.print("-");
        System.out.println();
        Random myRandom = new Random((long)seed);
        for ( int i = 0; i < repetitions; ++i ) {
            int randNum = myRandom.nextInt();

            Estado e = new Estado ( this.nhelicopters, 1234 );

            Problem p = new Problem ( e, sf, new GoalTest0(), h);
            Search s = new HillClimbingSearch();
            SearchAgent agent;
            
            try {
                Date d1,d2;
                Calendar a,b;

                d1 = new Date();
                agent = new SearchAgent ( p, s );
                d2 = new Date();

                a= Calendar.getInstance();
                b= Calendar.getInstance();
                a.setTime(d1);
                b.setTime(d2);

                long temps = b.getTimeInMillis()-a.getTimeInMillis();
                setInstrumentation(agent.getInstrumentation(), temps);
                setAccions(agent.getActions(), e, temps);
            }
            catch ( Exception error ) {
                error.printStackTrace();
            }
        }
    }

    public void executeSimulatedAnnealing ( int repetitions, int seed, int it, int pit, int k, double lbd ) {
        for ( int i = 0; i < 20; ++i ) System.out.print("-");
        System.out.println();
        for ( int i = 0; i < 20; ++i ) System.out.print("-");
        System.out.println();
        System.out.println("Execution with Simulated Annealing Search");
        for ( int i = 0; i < 20; ++i ) System.out.print("-");
        System.out.println();
        for ( int i = 0; i < 20; ++i ) System.out.print("-");
        System.out.println();
        Random myRandom = new Random((long)seed);
        for ( int i = 0; i < repetitions; ++i ) {
            int randNum = myRandom.nextInt();

            Estado e = new Estado ( this.nhelicopters, randNum );

            Problem p = new Problem ( e, sf, new GoalTest0(), h);
            Search s = new SimulatedAnnealingSearch(it, pit, k, lbd);
            SearchAgent agent;
            
            try {
                Date d1,d2;
                Calendar a,b;

                d1 = new Date();
                agent = new SearchAgent ( p, s );
                d2 = new Date();

                a= Calendar.getInstance();
                b= Calendar.getInstance();
                a.setTime(d1);
                b.setTime(d2);

                long temps = b.getTimeInMillis()-a.getTimeInMillis();
                setInstrumentation(agent.getInstrumentation(), temps);
                printActions(agent.getActions(), e);
            }
            catch ( Exception error ) {
                error.printStackTrace();
            }
        }
    }

}
