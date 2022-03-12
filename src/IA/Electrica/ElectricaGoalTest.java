package IA.Electrica;

import aima.search.framework.GoalTest;

public class ElectricaGoalTest implements GoalTest{

   public boolean isGoalState(Object aState) {
    Electrica board=(Electrica) aState;
    return(board.isGoalState());
  }
}