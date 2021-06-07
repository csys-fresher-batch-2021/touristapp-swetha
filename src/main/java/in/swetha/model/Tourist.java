package in.swetha.model;

public class Tourist {
	private String touristPlace;
	private double amount;
	private String imageURL;

	public Tourist(String touristPlace, double amount, String imageURL) {
		super();
		this.touristPlace = touristPlace;
		this.amount = amount;
		this.imageURL = imageURL;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getTouristPlace() {
		return touristPlace;
	}

	public void setTouristPlace(String touristPlace) {
		this.touristPlace = touristPlace;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Tourist [touristPlace=" + touristPlace + ", Amount=" + amount + "]";
	}

}
