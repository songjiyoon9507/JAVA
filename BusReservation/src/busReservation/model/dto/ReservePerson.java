package busReservation.model.dto;

public class ReservePerson {
	private String name; // 이름
	private String phoneNum; // 전화번호
	private int busNo; // 버스 번호
	private String departures; // 출발지
	private String arrivals; // 도착지
	private String departureTime; // 출발 시간
	private int reserveSeatNo; // 예약한 좌석
	
	public ReservePerson() {}

	public ReservePerson(String name, int busNo, String departures, String arrivals, String departureTime, 
			int reserveSeatNo, String phoneNum) {
		super();
		this.name = name;
		this.busNo = busNo;
		this.departures = departures;
		this.arrivals = arrivals;
		this.departureTime = departureTime;
		this.reserveSeatNo = reserveSeatNo;
		this.phoneNum = phoneNum;
	}

	public int getBusNo() {
		return busNo;
	}

	public void setBusNo(int busNo) {
		this.busNo = busNo;
	}

	public String getDepartures() {
		return departures;
	}

	public void setDepartures(String departures) {
		this.departures = departures;
	}

	public String getArrivals() {
		return arrivals;
	}

	public void setArrivals(String arrivals) {
		this.arrivals = arrivals;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public int getReserveSeatNo() {
		return reserveSeatNo;
	}

	public void setReserveSeatNo(int reserveSeatNo) {
		this.reserveSeatNo = reserveSeatNo;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
