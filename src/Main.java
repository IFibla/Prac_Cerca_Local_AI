import IA.Desastres.*;

/**
 * Operadors:
 */

public class Main {
       
    public static void main(String[] args) {
        
        int ncentros = 10;
        int helicopteros = 1;
        int ngrupos = 100; 
        int seed = 1;

        Grupos g = new Grupos(ngrupos, seed);
        Centros c = new Centros(ncentros, helicopteros, seed);

        Estado e = new Estado(g, c, helicopteros, seed);
        System.out.println(e);
    }
}
