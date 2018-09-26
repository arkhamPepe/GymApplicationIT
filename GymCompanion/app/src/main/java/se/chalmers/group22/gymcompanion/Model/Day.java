package se.chalmers.group22.gymcompanion.Model;

import lombok.Getter;

import java.util.Calendar;
import java.util.GregorianCalendar;

@Getter
public class Day {
    private GregorianCalendar calendar = new GregorianCalendar();

    private int dayOfWeek = (calendar.get(Calendar.DAY_OF_WEEK) + 6) % 7;
    private int week = calendar.get(Calendar.WEEK_OF_YEAR);
    private int year = calendar.get(Calendar.YEAR);

    public Day() { }

    public Day(int year, int week, int dayOfWeek){
        this.year = year;
        this.week = week % 53;
        this.dayOfWeek = dayOfWeek % 7;
    }

    public Day(int week, int dayOfWeek){
        this.week = week;
        this.dayOfWeek = dayOfWeek;
    }

    public boolean equals(Day day) {
        if(day != null) {
            return this.dayOfWeek == day.getDayOfWeek() &&
                    this.week == day.getWeek() &&
                    this.year == day.getYear();
        }
        return false;
    }

    @Override
    public String toString() {
        return this.year + "-" + this.week + "-" + this.dayOfWeek;
    }
}
