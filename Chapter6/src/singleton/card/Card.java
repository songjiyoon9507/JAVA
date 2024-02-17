package singleton.card;

public class Card {
	
	private static int serialNum = 1000;
	
	private int cardNum;
	
	public int getCardNum() {
		return cardNum;
	}

	public void setCardNum(int cardNum) {
		this.cardNum = cardNum;
	}

	public Card() {
		serialNum++;
		cardNum = serialNum;
	}
}
