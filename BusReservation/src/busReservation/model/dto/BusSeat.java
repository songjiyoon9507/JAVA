package busReservation.model.dto;

import java.util.List;
import java.util.Map;

public class BusSeat {
	private int busNo; // 버스 번호
	private int seatNo; // 좌석 번호
	private Map<Integer, Integer> leftSeatList; // 버스별 남은 좌석
	private List<Integer> remainSeat; // 버스에 남은 좌석
	
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

	public Map<Integer, Integer> getLeftSeatList() {
		return leftSeatList;
	}

	public void setLeftSeatList(Map<Integer, Integer> leftSeatList) {
		this.leftSeatList = leftSeatList;
	}

	public List<Integer> getRemainSeat() {
		return remainSeat;
	}

	public void setRemainSeat(List<Integer> remainSeat) {
		this.remainSeat = remainSeat;
	}
	
}
