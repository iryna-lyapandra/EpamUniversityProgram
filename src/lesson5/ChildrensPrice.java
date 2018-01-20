package lesson5;

/**
 * Created by a on 1/20/2018.
 */
class ChildrensPrice extends Price {
    int getPriceCode() {
        return Movie.CHILDREN;
    }
    public double getCharge(int daysRented){
        double result = 1.5;
        if (daysRented > 3)
            result += (daysRented - 3) * 1.5;
        return result;
    }

}

