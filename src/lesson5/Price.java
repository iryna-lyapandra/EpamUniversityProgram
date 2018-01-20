package lesson5;

/**
 * Created by a on 1/20/2018.
 */
abstract class Price {
    public abstract double getCharge (int daysRented);
    abstract int getPriceCode();
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
