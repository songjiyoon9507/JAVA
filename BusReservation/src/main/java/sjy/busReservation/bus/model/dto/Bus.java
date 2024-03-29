package sjy.busReservation.bus.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Bus {
	private int busNo; // 버스 번호
	private String departures; // 출발지
	private String arrivals; // 도착지
	private String departureTime; // 출발 시간
	private String arrivalTime; // 도착 시간
	private int remainSeat; // 남은 좌석 개수
}
