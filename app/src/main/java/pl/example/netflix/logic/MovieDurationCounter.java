package pl.example.netflix.logic;

import pl.example.netflix.logic.enums.MovieDuration;

public class MovieDurationCounter {

    private int durationLess60, durationBetween60And90, durationMore90;


    public void increaseLess1950() {
        durationLess60++;
    }

    public void increase1950To2000() {
        durationBetween60And90++;
    }

    public void increaseMoreThan2000() {
        durationMore90++;
    }

    public MovieDuration getTopCounter() {
        if (durationLess60 >= durationBetween60And90 && durationLess60 >= durationMore90)
            return MovieDuration.LESS_THAN_60;
        else if (durationBetween60And90 >= durationLess60 && durationBetween60And90 >= durationMore90)
            return MovieDuration.BETWEEN_60_AND_90;
        else
            return MovieDuration.MORE_THAN_90;
    }

    public int getDurationLess60() {
        return durationLess60;
    }

    public int getDurationBetween60And90() {
        return durationBetween60And90;
    }

    public int getDurationMore90() {
        return durationMore90;
    }
}
