package busReservation.model.dto;

public class BusSeat {
	private int busNo; // 버스 번호
	private int seatNo; // 좌석 번호

	public BusSeat() {}

	public int getBusNo() {
		return busNo;
	}

	public void setBusNo(int busNo) {
		this.busNo = busNo;
	}

	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	
}
