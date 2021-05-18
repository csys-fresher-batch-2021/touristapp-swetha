package in.swetha.model;

public class Tourist {
	private String touristPlace;
	private Integer amount;

	public Tourist(String touristplace, Integer amount) {

		this.touristPlace = touristplace;
		this.amount = amount;
	}

	public String getTouristPlace() {
		return touristPlace;
	}

	public void setTouristPlace(String touristPlace) {
		this.touristPlace = touristPlace;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Tourist [touristPlace=" + touristPlace + ", Amount=" + amount + "]";
	}

}
