package exercises1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercises1 {

    public static void main(String[] args) {
        // Liste med tal mellem 1 - 50
        List<Integer> list = List.of(1,2,3,2,1,6,3,4,5,2,3,8,8,9,34,32);
        list.stream().forEach(e-> System.out.println(e+1));

        int maxInt = list.stream().max((i1, i2) -> i1 - i2).get();
        System.out.println("Største element: " + maxInt);
        //	Udskriver det største element i listen

        list.stream().filter(i -> i < 50).forEach(i -> System.out.println(i + " er større end 50."));
        //	Afgør og udskriver om alle tallene i listen er mindre end 50

        int ligeTal = (int) list.stream().filter(i -> !(i % 2 == 0)).count();
        System.out.println("Antal lige tal: " + ligeTal);
        // 	Udskriver antallet af lige tal i listen

        int uligeTal = (int) list.stream().filter(i -> !(i % 2 == 1)).count();
        System.out.println("Antal ulige tal: " + uligeTal);
        //	Udskriver antallet af ulige tal i listen

        IntSummaryStatistics stats = list.stream().mapToInt(Integer::intValue).summaryStatistics();
        System.out.println("Gennemsnittet af tallene i listen: " + stats.getAverage());
        System.out.println("Antallet af tallene i listen: " + stats.getCount());
        System.out.println("Antallet af tallene i listen der er større end gennemsnittet: " +
                list.stream().filter(integer -> integer < stats.getAverage()).count());

        //  Udskriver
        //      Gennemsnittet af tallene i listen
        //      Antallet af tallene i listen
        //      Antallet af tallene i listen der er større end gennemsnittet
        //      Antallet af tallene i listen der er mindre end gennemsnittet

        //  TODO
        //	Udskriver antallet af gange de forskellige tal forekommer i listen

        //  TODO
        //	Udskriver antallet af gange de forskellige tal forekommer i listen i sorteret orden
    }
}
