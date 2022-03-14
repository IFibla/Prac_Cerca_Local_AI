//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package IA.Desastres;

import java.io.Serial;
import java.util.ArrayList;
import java.util.Random;

public class Centros extends ArrayList<Centro> {
    @Serial
    private static final long serialVersionUID = 1L;
    private Random myRandom;

    public Centros(int ncentros, int helicopteros, int seed) {
        int x = 0;
        int y = 0;
        this.myRandom = new Random((long)seed);

        for(int j = 0; j < ncentros; ++j) {
            int l = this.myRandom.nextInt(4);
            int p = this.myRandom.nextInt(50);
            switch(l) {
                case 0:
                    x = 0;
                    y = p;
                    break;
                case 1:
                    x = 49;
                    y = p;
                    break;
                case 2:
                    x = p;
                    y = 0;
                    break;
                case 3:
                    x = p;
                    y = 49;
            }

            Centro c = new Centro(x, y, helicopteros);
            this.add(c);
        }
    }
}
