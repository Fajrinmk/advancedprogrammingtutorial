class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

	double lineAmount(double thisAmount) {
		switch (getMovie().getPriceCode()) {
		    case Movie.REGULAR:
		        thisAmount += 2;
		        if (getDaysRented() > 2)
		            thisAmount += (getDaysRented() - 2) * 1.5;
		        break;
		    case Movie.NEW_RELEASE:
		        thisAmount += getDaysRented() * 3;
		        break;
		    case Movie.CHILDREN:
		        thisAmount += 1.5;
		        if (getDaysRented() > 3)
		            thisAmount += (getDaysRented() - 3) * 1.5;
		        break;
		}
		return thisAmount;
	}

	int addRenterPoints(int frequentRenterPoints) {
		frequentRenterPoints++;
	
		// Add bonus for a two day new release rental
		if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
		        getDaysRented() > 1)
		    frequentRenterPoints++;
		return frequentRenterPoints;
	}
}