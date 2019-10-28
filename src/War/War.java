package War;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 * War class: play a card game called "WAR".
 * @author Aimi Ross
 * @version 1.0.0
 * @since 09/22/2019
 * **/

public class War {
	
	/**
	 * main: play a card game called "WAR".
	 * @param args argument of type String array
	 */
	public static void main(String[] args) {
		ArrayList<Card> cards = new ArrayList<Card>();
		ArrayList<Card> deckOfUserTable = new ArrayList<Card>();
		ArrayList<Card> deckOfCompTable = new ArrayList<Card>();
		Scanner in = new Scanner(System.in);
		int countRound = 1;
		// create a deck of cards 
		for (int s = 0; s < 4; s++) { // suit: 0 = "Spades", 1 = "Hearts", 2 = "Clubs", 3 = "Diamonds"
			for (int r = 0; r < 13; r++) { // rank: 1 - 13
				cards.add(new Card(s,r));}	
		}
		
		// shuffled the deck
		Collections.shuffle(cards);
		
		// divide the shuffled deck into two deck, one for the user and another for computer
		ArrayList<Card> userDeck = new ArrayList<>(cards.subList(0, 26));
		ArrayList<Card> compDeck = new ArrayList<>(cards.subList(26, 52));
		
		/**
		 * plays the card game "WAR" until one of the player's card left down to 0
		 */
		while(true) {
			System.out.println("Round: " + countRound);
			deckOfUserTable.add(userDeck.get(0));
			deckOfCompTable.add(compDeck.get(0));
			Card userCard = userDeck.get(0);
			Card compCard = compDeck.get(0);
			userDeck.remove(0);
			compDeck.remove(0);
			System.out.println("Your card" + "\t\t\tMy card");
			System.out.println(deckOfUserTable.get(0) + "\t\t\t" + deckOfCompTable.get(0));
			
			/**
			 * compare played card value and user wins if userCardValue > computerCardValue
			 */
			if(userCard.getCard() > compCard.getCard()) 
			{
				userDeck.add(deckOfUserTable.get(0));
				userDeck.add(deckOfCompTable.get(0));
				deckOfUserTable.remove(0);
				deckOfCompTable.remove(0);
				System.out.println("Winner!");
				System.out.println("You have" + "\t\t\tI have");
				System.out.println(userDeck.size() + "card(s) left" + "\t\t\t" + compDeck.size() + " card(s) left\n");
				}
			
			/**
			 * if userCardValue < computerCardValue, user gets to choose play another card or not.
			 * the user wins if the total of first and second card is still lower than the computer's.
			 */
			else if(userCard.getCard() < compCard.getCard())
			{
				System.out.print("Would you want to take another card? Press 1(Yes) or 0(No): ");
				int pickedNum = in.nextInt();
				//int pickedNum = 1;
				
				/**
				 * computer wins if the user doesn't want to hit another card
				 */
				if (pickedNum == 0) 
				{
					compDeck.add(deckOfUserTable.get(0));
					compDeck.add(deckOfCompTable.get(0));
					deckOfUserTable.remove(0);
					deckOfCompTable.remove(0);
					System.out.println("\n\t\t\t\tWinner!!!");
					System.out.println("You have" + "\t\t\tI have");
					System.out.println(userDeck.size() + "card(s) left" + "\t\t\t" + compDeck.size() + " card(s) left\n");
					}
				
				/**
				 * deal another card if the user wish to play
				 */
				else if(pickedNum == 1) 
				{
					deckOfUserTable.add(userDeck.get(0));
					userDeck.remove(0);
					int x = deckOfUserTable.get(0).getCard();
					int y = deckOfUserTable.get(1).getCard();
					System.out.println("Your next card is " + deckOfUserTable.get(1));
					System.out.println("Your total value" + "\t\tMy value");
					System.out.println((x + y) + "\t\t\t\t" + deckOfCompTable.get(0));
					if( x + y <= deckOfCompTable.get(0).getCard()) 
					{
						userDeck.add(deckOfUserTable.get(0));
						userDeck.add(deckOfUserTable.get(1));
						userDeck.add(deckOfCompTable.get(0));
						deckOfUserTable.remove(0);
						deckOfUserTable.remove(0);
						deckOfCompTable.remove(0);
						System.out.println("\nWinner!!!");
						System.out.println("You have" + "\t\t\tI have");
						System.out.println(userDeck.size() + "card(s) left" + "\t\t\t" + compDeck.size() + " card(s) left\n");
						}
					
					/**
					 * computer wins if the user's total is higher than the computer
					 */
					else {
						compDeck.add(deckOfUserTable.get(0));
						compDeck.add(deckOfUserTable.get(1));
						compDeck.add(deckOfCompTable.get(0));
						deckOfUserTable.remove(0);
						deckOfUserTable.remove(0);
						deckOfCompTable.remove(0);
						System.out.println("\n\t\t\tWinner!!!");
						System.out.println("You have" + "\t\t\tI have");
						System.out.println(userDeck.size() + "card(s) left" + "\t\t\t" + compDeck.size() + " card(s) left\n");
						}
					}
			}

			/**
			 * War starts when the user and computer's card values are the same
			 */
			else
					while ((userCard.getCard() == compCard.getCard()))
					{
						System.out.println("Tie! \"WAR\" starts!+++++++++++++++++++++++++++++++++++++++++++++");
						
						/**
						 * if the card left is lower than 4, then lose automatically
						 * */
						if (userDeck.size()<4 || compDeck.size()<4) 
						{
							if(userDeck.size()<4)
								System.out.println("\t\t\t\t\tWinner!!!");
							else
								System.out.println("\nWinner!!!");
							}
						
						/**
						 *  check if the 4th card value for the WAR
						 */
						else
						{ // playing the war
							for (int z = 0; z <3; z++) 
							{
								deckOfUserTable.add(userDeck.get(0));  // since it's in a war, both player discards their 3 cards
								deckOfCompTable.add(compDeck.get(0));
								userDeck.remove(0);
								compDeck.remove(0);
								}
							userCard = userDeck.get(0); // stores the 4th card in a Card
							compCard = compDeck.get(0);
							userDeck.remove(0);
							compDeck.remove(0);
							deckOfUserTable.add(userCard); // stores the Card in the table deck.
							deckOfCompTable.add(compCard);
							System.out.println("Your value" + "\t\t\tMy value");
							System.out.println(userCard + "\t\t\t" + compCard);
							/**
							 * if user wins, user gets own discarded cards and the computer's
							 */
							if(userCard.getCard() > compCard.getCard()) 
							{
								while(deckOfUserTable.size() > 0) 
								{
									userDeck.add(deckOfUserTable.get(0));
									deckOfUserTable.remove(0);
								}
								while(deckOfCompTable.size() > 0) 
								{
									userDeck.add(deckOfCompTable.get(0));
									deckOfCompTable.remove(0);
								}
								System.out.println("Winner!!!");
								System.out.println("You have" + "\t\t\tI have");
								System.out.println(userDeck.size() + "card(s) left" + "\t\t\t" + compDeck.size() + " card(s) left\n");
								//break;
							}
							
							/**
							 * if computer wins, the computer gets own discarded cards and the user's
							 */
							else if(userCard.getCard() < compCard.getCard()) 
							{
								while(deckOfUserTable.size() > 0) 
								{
									compDeck.add(deckOfUserTable.get(0));
									deckOfUserTable.remove(0);
								}
								while(deckOfCompTable.size() > 0) 
								{
									compDeck.add(deckOfCompTable.get(0));
									deckOfCompTable.remove(0);
								}
								System.out.println("\t\t\t\tWinner!!!");
								System.out.println("You have" + "\t\t\tI have");
								System.out.println(userDeck.size() + "card(s) left" + "\t\t\t" + compDeck.size() + " card(s) left\n");
								//break;
								}
							}
						//
						//
						
					}countRound++;
				
				/**
				 * if user card left gets 0, then computer wins.
				 */
			if (userDeck.size() == 0) 
			{
				System.out.println("I won this \"WAR\"game in " + (countRound-1) + " rounds!!!!!");
				break;
			}
			
			/**
			 * if computer's card left gets 0, then the user wins.
			 */
			else if(compDeck.size() == 0) {
				System.out.println("Congratulations! You won this \"WAR\"game in "  + (countRound-1) + " rounds!!!!!");
				break;
			}
			}
		in.close();
		}
	}
