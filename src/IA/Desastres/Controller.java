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

    private void setAccions(List actions) 
    {
        for (int i = actions.size()-1; i < actions.size(); i++) {
            System.out.println((String) actions.get(i));
        }
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
        Random myRandom = new Random((long)seed);
        for ( int i = 0; i < repetitions; ++i ) {
            int randNum = myRandom.nextInt();
            for ( int heu = 1; heu <= 3; ++heu ) {
                for ( int ALPHA = 1; ALPHA <= 3 ; ++ALPHA ) {
                    for ( int BETA = 1; BETA <= 3; ++BETA ) {
                        for ( int OMEGA = 1; OMEGA <= 3; ++OMEGA ) {
                            Estado.ALPHA = ALPHA;
                            Estado.BETA = BETA;
                            Estado.OMEGA = OMEGA;
                            Estado.heuristico = heu;
                            System.out.println("(" + ALPHA + "," + BETA + "," + OMEGA + "," + heu + ")");

                            Estado e = new Estado ( this.nhelicopters, randNum);
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
                                System.out.println("Seed: " + randNum);
                                setInstrumentation(agent.getInstrumentation(), temps);
                                setAccions(agent.getActions());
                                System.out.println("\n");
                            }
                            catch ( Exception error ) {
                                error.printStackTrace();
                            }
                        }
                    }
                }
            } 
        }
    }

    public void executeSimulatedAnnealing ( int repetitions, int seed, int it, int pit, int k, double lbd ) {
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
