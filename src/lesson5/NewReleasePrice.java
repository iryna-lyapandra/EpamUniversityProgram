package lesson5;

/**
 * Created by a on 1/20/2018.
 */
class NewReleasePrice extends Price {
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }
    public double getCharge(int daysRented) {
        return daysRented * 3;
    }
    public int getFrequentRenterPoints(int daysRented) {
        return (daysRented > 1) ? 2: 1;
    }

}

