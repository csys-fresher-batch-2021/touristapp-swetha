package in.swetha.model;

public class Tourist {
	private String touristPlace;
	private Integer Amount;
	public Tourist(String touristplace, Integer amount) {
	
		this.touristPlace = touristplace;
		this.Amount = amount;
	}
	public String getTouristPlace() {
		return touristPlace;
	}
	public void setTouristPlace(String touristPlace) {
		this.touristPlace = touristPlace;
	}
	public Integer getAmount() {
		return Amount;
	}
	public void setAmount(Integer amount) {
		Amount = amount;
	}
	@Override
	public String toString() {
		return "Tourist [touristPlace=" + touristPlace + ", Amount=" + Amount + "]";
	}
	

}



