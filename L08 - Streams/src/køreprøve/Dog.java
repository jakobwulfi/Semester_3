package køreprøve;
/**
 * Lav en beskrivelse af klassen Dog her.
 * 
 * @forfatter (Jakob Wolf, 202206631)
 * @dato (??/??/??)
 */
public class Dog implements Comparable<Dog>
{
    // instansvariabler - erstat eksemplet herunder med dine egne variabler
    private String name;
    private int age;
    private int weight;
    /**
     * Konstruktør for objekter af klassen Dog
     */
    public Dog(String name, int weight, int age)
    {
        this.name = name;
        this.weight = weight;
        this.age = age;
    }
    
    public String toString() {
        return name + ": " + age + " years and " + weight + " kg";
    }
    
    public String getName() {
        return name;
    }
    
    public int getWeight() {
        return weight;
    }
    
    public int getAge() {
        return age;
    }
    
    public int compareTo(Dog other) {
        if(!name.equals(other.name)) {
            return name.compareTo(other.name);
        }
        return other.age - age;
    }
}