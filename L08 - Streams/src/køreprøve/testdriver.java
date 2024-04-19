package køreprøve;

/**
 * Lav en beskrivelse af klassen testdriver her.
 * 
 * @forfatter (Jakob Wolf, 202206631)
 * @dato (??/??/??)
 */
public class testdriver
{
    public static void main(String[] args) {
        Dog d1 = new Dog("Micco", 6, 22);
        Dog d2 = new Dog("Fido", 3, 15);
        Dog d3 = new Dog("Fido", 5, 17);
        Dog d4 = new Dog("Maica", 3, 12);
        Dog d5 = new Dog("Hans", 5, 12);
        
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);
        System.out.println(d4);
        System.out.println(d5);
        
        System.out.println();
        Kennel kennel = new Kennel("Bob");
        kennel.addDog(d1);
        kennel.addDog(d2);
        kennel.addDog(d3);
        kennel.addDog(d4);
        kennel.addDog(d5);
        
        System.out.println("Returns a dog with the age of 12:");
        System.out.println(kennel.findDog(12));
        
        System.out.println();
        System.out.println("Returns the youngest dog called Fido:");
        System.out.println(kennel.youngDog("Fido"));
        
        System.out.println();
        System.out.println("Prints list of dogs in kennel:");
        kennel.printKennel();
        
        System.out.println();
        System.out.println("Returns a dog name Fido:");
        System.out.println(kennel.findName("Fido"));
        
        System.out.println();
        System.out.println("Returns sum of weight of dogs aged 5:");
        System.out.println(kennel.totalAge(5));
    }
}