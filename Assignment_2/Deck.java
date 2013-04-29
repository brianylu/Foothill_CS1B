import java.util.Random;

/**
 * A deck object that represents a 52 card deck of cards, with no jokers.
 * @author brlu
 *
 */
public class Deck {
   
   public static int MAX_CARDS = 52;

   public static Card[] MASTER_DECK = new Card[MAX_CARDS];
   private Card[] cards;
   private int topCard;
   private int numPacks;
   
   

   /**
    * Constructor which takes number of packs as input.
    * @param numPacks
    */
   public Deck(int numPacks)
   {
      populateMaster();
      this.numPacks = numPacks;
      init(this.numPacks);
   }
   
   /**
    * Default constructor for a deck.
    */
   public Deck()
   {
      this(1); //utilize constructor where numPacks = 1;
   }
   
   /**
    * Initiates a deck of cards from the MasterDeck based on specified number
    * of decks.
    * @param numPacks
    */
   public void init(int numPacks)
   {
      cards = new Card[numPacks * MAX_CARDS];
      for (int i = 0; i < numPacks; i++)
      {
         for (int j = 0; j < MAX_CARDS; j++)
         {
            cards[i*MAX_CARDS+j] = MASTER_DECK[j];
         }
      }
      topCard = numPacks * MAX_CARDS - 1;
   }
   
   public String toString()
   {
      String str = "";
      for (int i = 0; i < topCard + 1; i++)
      {
         str = str + cards[i] + " / ";
      }
      return str + "\n";
   }
   /**
    * Shuffles the deck of cards. Iterates through each card and switches
    * it with a random card in the deck.
    */
   public void shuffle()
   {
      Random r = new Random();
      for (int i = 0; i <= topCard; i++)
      {
         int rPos = r.nextInt(topCard);
         Card temp = cards[i];
         cards[i] = cards[rPos];
         cards[rPos] = temp;
      }
   }
   
   /**
    * Deals a card from the top of the pile. 
    * @return
    */
   public Card dealCard()
   {
      Card card;
      if(topCard >= 0)
      {
         card = cards[topCard];
         topCard--;
      }
      else
      {
         card = null;
      }
      return card;
   }
   
   /**
    * Removes every instance of a specific card from the deck. 
    * @param card
    * @return
    */
   public boolean removeCard(Card card)
   {
      int shift = 0; //initally no shift.
      
      for (int i = 0; i < cards.length; i++)
      {
         
         if (cards[i].equals(card))
         {
            System.out.println(cards[i]);   
            shift++; //if the card exists, use shift.
         }
         
         else if (shift != 0)
         {
            cards[i-shift] = cards[i];
         }
      }
      topCard = topCard - shift;
      return (shift != 0);
   }
   
   /**
    * Adds a card to the top of the deck. 
    * @param card
    * @return
    */
   public boolean addCard(Card card)
   {
      int cardCount = 0;
      for (int i = 0; i < topCard + 1; i++)
      {
         if (cards[i].equals(card))
         {
            cardCount++;
         }
      }
      
      if (cardCount < numPacks){
         topCard++;
         cards[topCard] = card;
         return true;
      }
      else{ return false; }
   }  
   
   /**
    * Accesor method for the number of cards, which is the same
    * as the index o the top card.  
    * @return
    */
   public int getNumCards()
   {
      return topCard + 1;
   }
   
   /**
    * Inspects a particular card. If it is out of range, then return a 
    * card with errorFlag = true;
    * @param k
    * @return
    */
   public Card inspectCard(int k)
   {
      Card card;
      if (k > topCard)
      {
         card = new Card('Z',Card.Suit.spades);
      }
      else
      {
         card = cards[k];
      }
      return card;
   }
   
   /**
    * Populates the master deck with a sample deck that will be used for 
    * initializing other decks. 
    */
   private static void populateMaster()
   {
      //add first 52 cards
      for (int i = 0; i < Card.VALID_VALUES.length-1; i++)
      {
         for (int j = 0; j < Card.Suit.values().length; j++)
         {
            MASTER_DECK[j * (Card.VALID_VALUES.length - 1) + i] = 
                  new Card(Card.VALID_VALUES[i], Card.Suit.values()[j]);
         }
      }
   }

}
