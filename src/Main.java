import IA.Desastres.*;

public class Main {    

    public static void main (String[] args) {
        Controller c = new Controller(5, 1, 100, 1234);
        //c.executeHillClimbing(1, 1234);
        c.executeSimulatedAnnealing(20, 1234, 150000, 1000, 80, 0.00006);
    }
}
