package IA.Desastres;

public class Nodo {
    
    public static final boolean CENTRO = false;
    public static final boolean GRUPO = true;

    private boolean type;
    private int id;
    private int coordX, coordY;

    public Nodo ( boolean type, int id, int coordX, int coordY ) {
        this.type = type;
        this.id = id;
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public boolean getType () {
        return this.type;
    }
    
    public int getId () {
        return this.id;
    }

    public int getCoordX () {
        return this.coordX;
    }
    
    public int getCoordY () {
        return this.coordY;
    }

    @Override
    public boolean equals ( Object obj ) {
        if ( !(obj instanceof Nodo ) ) 
            return false;
        
        Nodo other = (Nodo)obj;
        return type == other.getType() && id == other.getId();
    }

    @Override
    public String toString () {
        if ( type ) return "(G" + id + ")";
        else return "(C" + id + ")";
    }

}
