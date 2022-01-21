package entity;

public class Flight {
	private int idFlight;
	private String departureCity;
	private String arrivalCity;
	
	public Flight() {}
	
	public Flight(int idFlight, String departure, String arrival) {
		this.idFlight = idFlight;
		this.departureCity = departure;
		this.arrivalCity = arrival;
	}
	
	public int getIdFlight() {
		return idFlight;
	}
	public void setIdFlight(int idFlight) {
		this.idFlight = idFlight;
	}
	public String getArrivalCity() {
		return arrivalCity;
	}
	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}
	public String getDepartureCity() {
		return departureCity;
	}
	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

}
