package pl.example.netflix.logic;

import pl.example.netflix.logic.enums.MovieReleaseYear;

public class MovieReleaseCounter {

    private int releaseDateLess1950, releaseDate1950To2000, releaseDateMoreThan2000;


    public void increaseLess1950() {
        releaseDateLess1950++;
    }

    public void increase1950To2000() {
        releaseDate1950To2000++;
    }

    public void increaseMoreThan2000() {
        releaseDateMoreThan2000++;
    }

    public MovieReleaseYear getTopCounter() {
        System.out.println("1950: " + releaseDateLess1950);
        System.out.println("1950-2000: " + releaseDate1950To2000);
        System.out.println("2000: " + releaseDateMoreThan2000);
        if (releaseDateLess1950 >= releaseDate1950To2000 && releaseDateLess1950 >= releaseDateMoreThan2000)
            return MovieReleaseYear.LESS_THAN_1950;
        else if (releaseDate1950To2000 >= releaseDateLess1950 && releaseDate1950To2000 >= releaseDateMoreThan2000)
            return MovieReleaseYear.BETWEEN_1950_AND_2000;
        else
            return MovieReleaseYear.MORE_THAN_2000;
    }

    public int getReleaseDateLess1950() {
        return releaseDateLess1950;
    }

    public int getReleaseDate1950To2000() {
        return releaseDate1950To2000;
    }

    public int getReleaseDateMoreThan2000() {
        return releaseDateMoreThan2000;
    }
}
