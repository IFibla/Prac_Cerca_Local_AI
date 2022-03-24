import java.util.List;

import IA.Desastres.*;
import aima.*;
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

        Estado.c = c;
        Estado.g = g;
        SuccessorFunction0.DEBUG = 1;

        Estado e = new Estado(helicopteros, 49);
        
        SuccessorFunction0 s = new SuccessorFunction0();
        List<Object> list = s.getSuccessors(e);
        System.out.println(list.size());

    }
}
