package IA.Desastres;

public class Representacio {
    
    private Grupos g;
    private Centros c;

    public Representacio ( int ncentros, int helicopteros, int ngrupos, int seed ) {

        g = new Grupos( ngrupos, seed );
        c = new Centros( ncentros, helicopteros, seed );

    }

}
