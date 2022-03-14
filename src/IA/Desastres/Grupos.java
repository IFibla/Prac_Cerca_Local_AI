//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package IA.Desastres;

import java.util.ArrayList;
import java.util.Random;

public class Grupos extends ArrayList<Grupo> {
    private static final long serialVersionUID = 1L;
    private Random myRandom;

    public Grupos(int ngrupos, int seed) {
        this.myRandom = new Random((long)seed);

        for(int j = 0; j < ngrupos; ++j) {
            Grupo g = new Grupo(this.myRandom.nextInt(50), this.myRandom.nextInt(50), this.myRandom.nextInt(2) + 1, this.myRandom.nextInt(12) + 1);
            this.add(g);
        }

    }
}
