package IA.Desastres;

public class Centro {
        private final int CoordX;
        private final int CoordY;
        private final int NHelicopteros;

        public Centro(int cx, int cy, int nh) {
            this.CoordX = cx;
            this.CoordY = cy;
            this.NHelicopteros = nh;
        }

        public int getCoordX() {
            return this.CoordX;
        }

        public int getCoordY() {
            return this.CoordY;
        }

        public int getNHelicopteros() {
            return this.NHelicopteros;
        }
}
