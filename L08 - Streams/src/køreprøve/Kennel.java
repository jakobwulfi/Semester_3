package køreprøve;

import java.util.*;
/**
 * Lav en beskrivelse af klassen Kennel her.
 * 
 * @forfatter (Jakob Wolf, 202206631)
 * @dato (??/??/??)
 */
public class Kennel
{
    // instansvariabler - erstat eksemplet herunder med dine egne variabler
    private String owner;
    private ArrayList<Dog> dogs;
    /**
     * Konstruktør for objekter af klassen Kennel
     */
    public Kennel(String owner)
    {
        this.owner = owner;
        dogs = new ArrayList<>();
    }
    
    public void addDog(Dog d) {
        dogs.add(d);
    }
    
    public Dog findDog(int age) {
        for(Dog d : dogs) {
            if(d.getAge() == age) {
                return d;
            }
        }
        return null;
    }
    
    public Dog youngDog(String name) {
        Dog result = null;
        for(Dog d : dogs) {
            if(d.getName().equals(name)) {
                if(result == null || d.getAge() < result.getAge()) {
                    result = d;
                }
            }
        }
        return result;
    }
    
    public void printKennel() {
        System.out.println(owner);
        Collections.sort(dogs);
        for(Dog d : dogs) {
            System.out.println(d);
        }
    }
    
    public Dog findName(String name) {
        return dogs.stream()
        .filter(d -> d.getName().equals(name))
        .findFirst()
        .orElse(null);
    }
    
    public int totalAge(int weight) {
        return dogs.stream()
        .filter(d -> d.getWeight() == weight)
        .mapToInt(d -> d.getAge())
        .sum();
    }
}