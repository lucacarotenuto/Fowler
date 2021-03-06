class Rental {
    private Movie movie;
    private int daysRented;
    public Rental(Movie newmovie, int newdaysRented) {
        movie = newmovie;
        daysRented = newdaysRented;
    }
    
    public int getDaysRented() {
        return daysRented;
    }
    
    public Movie getMovie() {
        return movie;
    }
    
    public double amountFor(Rental each) {
        double thisAmount = 0;
        switch (each.getMovie().getPriceCode()) {
            case Price.REGULAR:
                thisAmount += 2;
                if (each.getDaysRented() > 2)
                    thisAmount += (each.getDaysRented() - 2) * 1.5;
                break;
            case Price.NEW_RELEASE:
                thisAmount += each.getDaysRented() * 3;
                break;
            case Price.CHILDRENS:
                thisAmount += 1.5;
                if (each.getDaysRented() > 3)
                    thisAmount += (each.getDaysRented() - 3) * 1.5;
                break;
        }
        return thisAmount;
    }
    
    public int getFrequentRenterPoints()
	{
		if ((getMovie().getPriceCode() == Price.NEW_RELEASE) && getDaysRented() > 1) {
			return 2;
		}
		else {
			return 1;
		}
	}
}