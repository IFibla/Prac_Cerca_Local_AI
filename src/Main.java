import IA.Desastres.*;

/**
 * Operadors:
 */

public class Main {
       
    public static void main(String[] args) {
        
        int ncentros = 5;
        int helicopteros = 10;
        int ngrupos = 230; 
        int seed = 12342412;

        Representacio r = new Representacio(ncentros, helicopteros, ngrupos, seed);
        r.printCentros();
        r.printGrupos();
    }
}
