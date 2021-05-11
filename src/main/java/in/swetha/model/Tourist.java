package in.swetha.model;

public class Tourist {
	public String touristPlace;
	public Integer Amount;
	public Tourist(String touristplace, Integer amount) {
	
		this.touristPlace = touristplace;
		this.Amount = amount;
	}
	@Override
	public String toString() {
		return "Tourist [touristPlace=" + touristPlace + ", Amount=" + Amount + "]";
	}
	

}
