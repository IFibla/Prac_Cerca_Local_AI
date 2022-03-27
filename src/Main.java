import IA.Desastres.*;

public class Main {    

    public static void main (String[] args) {
        Controller c = new Controller(10, 1, 100, 1234);
        //c.executeHillClimbing(20, 1234);
        c.executeSimulatedAnnealing(20, 1234, 200, 10, 5, 0.9);
    }
}
