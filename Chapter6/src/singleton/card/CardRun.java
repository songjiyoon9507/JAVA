package singleton.card;

public class CardRun {
	public static void main(String[] args) {
		
		CardCompany cardCompany = CardCompany.getInstance();
		
		Card c1 = cardCompany.createCard();
		Card c2 = cardCompany.createCard();
		
		System.out.println(c1.getCardNum());
		System.out.println(c2.getCardNum());
	}
}
