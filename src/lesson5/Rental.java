package lesson5;

class Rental {

	private Movie _movie;
	private int _daysRented;

	public Rental(Movie movie, int daysRented) {
		_movie = movie;
		set_daysRented(daysRented);
	}
    public double getCharge() {
	    return _movie.getCharge(get_daysRented());
    }
    public int getFrequentRenterPoints() {
        return _movie.getFrequentRenterPoints(get_daysRented());
    }

	public int getDaysRented() {
		return get_daysRented();
	}

	public Movie getMovie() {
		return _movie;
	}

    public int get_daysRented() {
        return _daysRented;
    }

    public void set_daysRented(int _daysRented) {
        this._daysRented = _daysRented;
    }
}