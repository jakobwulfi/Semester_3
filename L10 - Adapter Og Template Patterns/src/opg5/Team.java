package opg5;

import java.time.DayOfWeek;

public class Team implements Comparable<Team>{
    private String name;
    private DayOfWeek weekday;

    public Team(String name, DayOfWeek weekday) {
        this.name = name;
        this.weekday = weekday;
    }

    public String getName() {
        return name;
    }

    public DayOfWeek getWeekday() {
        return weekday;
    }

    public String toString(){
        return weekday +  " - " + name;
    }

    @Override
    public int compareTo(Team o) {
        int comp = weekday.compareTo(o.getWeekday());
        if (comp==0){
            comp = name.compareTo(name);
        }
        return comp;
    }
}
