package opg5;

import java.time.DayOfWeek;
import java.util.List;

public class app {
    public static void main(String[] args) {
        ListSequence<Team> agf = new ListSequence<>();
        agf.add(new Team("basketball", DayOfWeek.TUESDAY));
        agf.add(new Team("volleyball", DayOfWeek.TUESDAY));
        agf.add(new Team("fodbold", DayOfWeek.THURSDAY));
        agf.add(new Team("håndbold", DayOfWeek.THURSDAY));

        ListSequence<Team> aia = new ListSequence<>();
        aia.add(new Team("basketball", DayOfWeek.TUESDAY));
        aia.add(new Team("floorball", DayOfWeek.WEDNESDAY));
        aia.add(new Team("fodbold", DayOfWeek.THURSDAY));

        System.out.println("AGF:");
        while (!agf.isEmpty()) {
            System.out.println(agf.head().toString());
            agf.tail();
        }

        System.out.println("\nAIA:");
        while (!aia.isEmpty()) {
            System.out.println(aia.head().toString());
            aia.tail();
        }
    }
}
