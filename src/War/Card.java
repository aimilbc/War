package War;
/**
 * Card class: create, show and get a card.
 * @author Aimi Ross
 * @version 1.0.0
 * @since 09/22/2019
 * **/

public class Card {
	int suit;
	int rank;
	
	/**
	 * constructor. create accesses to suit and rank in private
	 * @param s suit
	 * @param r rank
	 */
	public Card(int s, int r) {
		this.suit = s;
		this.rank = r;
	}
	
	/**
	 * return rank of the card
	 * @return rank
	 */
	public int getCard() {
		return rank+1;
	}
	
	/**
	 * set a card's value into rank
	 * @param r rank
	 */
	public void setCard(int r) {
		this.rank = r;
	}
	
	public void resetCard() {
		this.rank = 15;
		this.suit = 15;
	}
	
	/**
	 * translating suit and rank integer to "Spades", "Hearts", "Clubs", "Diamonds", "A", "J", "Q", "K"
	 */
	public String toString() {
		String s = "";
		String r = "";
		
		if (suit == 0)
			s = "Spade";
		else if(suit == 1)
			s = "Heart";
		else if(suit == 2)
			s = "Club";
		else
			s = "Diamond";
		
		if(rank == 0)
			r = "A";
		else if(rank == 10)
			r = "J";
		else if(rank == 11)
			r = "Q";
		else if (rank == 12)
			r = "K";
		else
			r = String.valueOf(rank+1);
		
		return r + " of " + s;
	}

}
