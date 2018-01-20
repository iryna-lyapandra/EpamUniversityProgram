package lesson5;

/**
 * Created by a on 1/20/2018.
 */
class RegularPrice extends Price {

    public double getCharge(int daysRented) {
        double result = 2;
        if (daysRented > 2)
            result += (daysRented - 2) * 1.5;
        return result;
    }
    int getPriceCode() {
        return Movie.REGULAR;
    }
}