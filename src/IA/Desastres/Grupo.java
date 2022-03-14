//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package IA.Desastres;

public class Grupo {
    private final int CoordX;
    private final int CoordY;
    private final int Prioridad;
    private final int NPersonas;

    public Grupo(int cx, int cy, int pr, int np) {
        this.CoordX = cx;
        this.CoordY = cy;
        this.Prioridad = pr;
        this.NPersonas = np;
    }

    public int getCoordX() {
        return this.CoordX;
    }

    public int getCoordY() {
        return this.CoordY;
    }

    public int getPrioridad() {
        return this.Prioridad;
    }

    public int getNPersonas() {
        return this.NPersonas;
    }
}
