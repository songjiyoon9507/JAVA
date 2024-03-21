package busReservation.model.dto;

import java.util.List;

public class Bus {
	private int busNo; // 버스 번호
	private String departures; // 출발지
	private String arrivals; // 도착지
	private String departureTime; // 출발 시간
	private String arrivalTime; // 도착 시간
	private int remainSeat; // 남은 좌석 개수
	private List<BusSeat> busSeatList; // 좌석 목록
	
	private List<Bus> busList; // 버스 번호
	
	public Bus() {}
	
	public Bus(int busNo, String departures, String arrivals, String departureTime, String arrivalTime) {
		this.busNo = busNo;
		this.departures = departures;
		this.arrivals = arrivals;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
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

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getRemainSeat() {
		return remainSeat;
	}

	public void setRemainSeat(int remainSeat) {
		this.remainSeat = remainSeat;
	}

	public List<BusSeat> getBusSeatList() {
		return busSeatList;
	}

	public void setBusSeatList(List<BusSeat> busSeatList) {
		this.busSeatList = busSeatList;
	}

	public List<Bus> getBusList() {
		return busList;
	}

	public void setBusList(List<Bus> busList) {
		this.busList = busList;
	}
	
}
