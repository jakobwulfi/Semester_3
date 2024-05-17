package Adapter.spiritusadapter;

public class Test {
    public static void main(String[] args) {
        Vare sprit = new SpiritusAdapter(new Spiritus(150, "Sprit"));
        Vare øl = new SpiritusAdapter(new Spiritus(10,"Carlsberg"));

        System.out.println("Sprit test:");
        System.out.println("Navn: " + sprit.getNavn() + ", pris: " + sprit.getPris() + ", moms: " + sprit.beregnMoms());
        System.out.println("Øl test:");
        System.out.println("Navn: " + øl.getNavn() + ", pris: " + øl.getPris() + ", moms: " + øl.beregnMoms());
    }
}
