import IA.Desastres.*;

public class Main {    

    public static void main (String[] args) {
        Controller c = new Controller(10, 1, 100, 3123);
        c.executeHillClimbing(2, 86);
        c.executeSimulatedAnnealing(2, 86, 200, 10, 5, 0.9);
    }
}
