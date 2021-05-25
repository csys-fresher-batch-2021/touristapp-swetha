package in.swetha.model;

public class Tourist {
	private String touristPlace;
	private Double amount;

	public Tourist(String touristplace, Double rate) {

		this.touristPlace = touristplace;
		this.amount = rate;
	}

	public String getTouristPlace() {
		return touristPlace;
	}

	public void setTouristPlace(String touristPlace) {
		this.touristPlace = touristPlace;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Tourist [touristPlace=" + touristPlace + ", Amount=" + amount + "]";
	}

}
