package IA.Desastres;

public class Representacio {
    
    private Grupos g;
    private Centros c;
    private int ncentros;
    private int ngrupos;

    public Representacio ( int ncentros, int helicopteros, int ngrupos, int seed ) {
        this.g = new Grupos( ngrupos, seed );
        this.c = new Centros( ncentros, helicopteros, seed );
        this.ncentros = ncentros;
        this.ngrupos = ngrupos;
    }

    public void printGrupos () {
        for ( int i = 0; i < this.ngrupos; ++i ) {
            System.out.println("grupos[index++] = new Grupos(" + ((Grupo)g.get(i)).getCoordX() + 
                "," + ((Grupo)g.get(i)).getCoordY() + "," + ((Grupo)g.get(i)).getNPersonas() + 
                "," + ((Grupo)g.get(i)).getPrioridad() + ");");
        }
    }

    public void printCentros () {
        for( int i = 0; i < this.ncentros; ++i ) {
            System.out.println("centros[index++] = new Centro(" + ((Centro)c.get(i)).getCoordX() + 
                "," + ((Centro)c.get(i)).getCoordY() + "," + ((Centro)c.get(i)).getNHelicopteros() + ");");
        }
    }

}
