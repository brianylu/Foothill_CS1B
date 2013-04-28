/**
 * Class representing a hand of cards.
 * @author brlu
 *
 */
public class Hand {
   
   public static int MAX_CARDS = 50;
   
   private Card[] myCards;
   private int numCards;
   
   /**
    * Default constructor for a hand of cards.
    */
   public Hand()
   {
      myCards = new Card[MAX_CARDS];
      numCards = 0;
   }
   
   /**
    * Resets the hand to a new array and sets cards back to zero.
    */
   public void resetHand()
   {
      myCards = new Card[MAX_CARDS];
      numCards = 0;
   }
   
   /**
    * Takes a card and adds it to the hand. If hand is full, returns error.
    * @param card
    * @return
    */
   public boolean takeCard(Card card)
   {
      boolean valid;
      if (numCards >= MAX_CARDS)
      {
         valid = false;
      }
      else
      {
         myCards[numCards] = card;
         numCards++;
         valid = true;
      }
      return valid;
   }
   
   /**
    * Play most recently added card in the hand. Decrease numCards. 
    * @return
    */
   public Card playCard()
   {
      Card card = myCards[numCards - 1];
      myCards[numCards - 1] = null;      
      return card;  
   }
   
   /**
    * toString gives comma delimited array of Cards.
    */
   public String toString()
   {
      String str = "Hand = ( "; //initialize empty string.
      if (numCards == 0) 
      {
         str = str + ")";
      }
      else
      {
         for (int i = 0; i < numCards - 1; i++)
         {
            str = str + myCards[i] + ", ";
         }
         str = str + myCards[numCards - 1] + " )";
      }
      return str;
   }
   
   /**
    * Get number of cards in the deck.
    * @return number of cards in deck
    */
   public int getNumCards()
   {
      return numCards;
   }
   
   /**
    * Inspect a specfic card in the hand. Returns a card with 
    * errorFlag = true if the card does not exist;
    * 
    * @param k
    * @return
    */
   public Card inspectCard(int k)
   {
      Card card;
      if (k <= numCards)
      {
         card = new Card('Z', Card.Suit.spades); //create a card that wont work
         //card.setState()
      }
      else
      {
         card = myCards[k - 1];
      }
      return card;
   }
}

