//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package IA.Desastres;

public class Test {
    public Test() {
    }

    public static void main(String[] args) {
        Centros c = new Centros(5, 1, 123456);
        Grupos g = new Grupos(100, 123456);
        System.out.println("Centros:");

        int i;
        for(i = 0; i < 5; ++i) {
            System.out.println("Centro: " + i);
            System.out.println("Coord x: " + ((Centro)c.get(i)).getCoordX());
            System.out.println("Coord y: " + ((Centro)c.get(i)).getCoordY());
            System.out.println("Helicopteros: " + ((Centro)c.get(i)).getNHelicopteros());
        }

        System.out.println();
        System.out.println("Grupos:");

        for(i = 0; i < 100; ++i) {
            System.out.println("Grupo: " + i + " X: " + ((Grupo)g.get(i)).getCoordX() + " Y: " + ((Grupo)g.get(i)).getCoordY() + " Pr: " + ((Grupo)g.get(i)).getPrioridad() + " Pers: " + ((Grupo)g.get(i)).getNPersonas());
        }
    }
}
