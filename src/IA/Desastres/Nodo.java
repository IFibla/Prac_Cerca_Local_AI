package IA.Desastres;

public class Nodo {
    
    private static final boolean CENTRO = false;
    private static final boolean GRUPO = true;

    private boolean type;
    private int id;

    public Nodo ( boolean type, int id ) {
        this.type = type;
        this.id = id;
    }

    public boolean getType () {
        return this.type;
    }
    
    public int getId () {
        return this.id;
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
        return "(" + type + id + ")";
    }

}
