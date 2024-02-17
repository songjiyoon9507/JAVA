package singleton.card;

public class CardCompany {
	private CardCompany() {}
	
	private static CardCompany instance = new CardCompany();
	
	public static CardCompany getInstance() {
		if(instance != null) {
			instance = new CardCompany();
		}
		return instance;
	}
	
	public Card createCard() {
		Card card = new Card();
		return card;
	}
}
