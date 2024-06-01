package model;

public class opg5 {
    public static void main(String[] args) {
        Nedboer test = new Nedboer();
        System.out.println(test.bedsteTreFerieUger());
        System.out.println(test.bedsteFerieUgerStart(3));
        System.out.println(test.bedsteFerieUgerStart(5));
        System.out.println("Første uge med samme mængde nedbør: " + test.ensNedboer());
    }
}
