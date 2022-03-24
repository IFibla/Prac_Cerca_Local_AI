package IA.Desastres;
import aima.search.framework.HeuristicFunction;

public class HeuristicFunction0 implements HeuristicFunction {

    public boolean equals ( Object obj ) {
        boolean retValue;
        retValue = super.equals(obj);
        return retValue;
    }
  
    public double getHeuristicValue ( Object state ) {
        if ( !(state instanceof Estado ) ) 
            throw new IllegalArgumentException( "Please, only pass an Estado Instance.");
        Estado actual = (Estado) state;
        return actual.getHeuristicValue();
    }

}
