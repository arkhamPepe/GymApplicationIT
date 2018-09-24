package se.chalmers.group22.gymcompanion.Model;

import java.util.Calendar;

public class Day {
    private int dayOfWeek;
    private int week;
    private int year = Calendar.getInstance().get(Calendar.YEAR);

    public Day(int year, int week, int dayOfWeek){
        this.year = year;
        this.week = week;
        this.dayOfWeek = dayOfWeek;
    }

    public Day(int week, int dayOfWeek){
        this.week = week;
        this.dayOfWeek = dayOfWeek;
    }
}
