package IA.Desastres;
import aima.search.framework.GoalTest;
import aima.search.*;

public class GoalTest0 implements GoalTest{
    @Override
    public boolean isGoalState ( Object state ) {
        if ( !(state instanceof Estado ) ) 
            return false;
        return false;
    }
}
