package sjy.busReservation.bus.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class BusSeat {
	private int busNo; // 버스 번호
	private int seatNo; // 좌석 번호
}
