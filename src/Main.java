import IA.Desastres.*;

/**
 * Operadors:
 */

public class Main {

    public void generarSucesores ( Estado e ) {
        int X = e.getSizeX();
        int Y = e.getSizeY();

        for ( int i = 0; i < X; ++i ) {
            for ( int j = 0; j < Y; ++j ) {

                for ( int k = 0; k < X; ++k ) {
                    for ( int l = 0; l < Y; ++l ) {
                        Estado new_e = new Estado ( e, i, j, k, l );
                        if ( new_e != e ) 
                            // Add new_e to priority_queue with pair ( heuristic, new_e ) 
                    }
                } 


            }
        }
    }

    public static void main(String[] args) {
        
        int ncentros = 10;
        int helicopteros = 1;
        int ngrupos = 100; 
        int seed = 1;

        Grupos g = new Grupos(ngrupos, seed);
        Centros c = new Centros(ncentros, helicopteros, seed);

        Estado.c = c;
        Estado.g = g;

        Estado e = new Estado(helicopteros, 49);
        System.out.println(e);

        Estado e2 = new Estado(e, 0, 4);
        System.out.println(e2);

    }
}
