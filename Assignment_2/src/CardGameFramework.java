/**
 * CardGameFramework provides a framework for any type of card game, in which
 * the parameters can be well defined. 
 * 
 * @author brlu
 *
 */
public class CardGameFramework {
   
   public static int MAX_PLAYERS = 20; 
   
   private static int defaultNumPacks = 1;
   private static int defaultNumJokersPerPack = 0;
   private static int defaultNumUnusedCardsPerPack = 0;
   private static Card[] defaultUnusedCardsPerPack = null;
   private static int defaultNumPlayers = 4;
   private static int defaultNumCardsPerHand = 13;
   
   private int numPlayers;
   private int numPacks;            // # standard 52-card packs per deck
                                    // ignoring jokers or unused cards 
   private int numJokersPerPack;    // if 2 per pack & 3 packs per deck, get 6 
   private int numUnusedCardsPerPack;  // # cards removed from each pack
   private int numCardsPerHand;        // # cards to deal each player
   private Deck deck;               // holds the initial full deck and gets 
                                    // smaller (usually) during play
   private Hand[] hand;             // one Hand for each player
   private Card[] unusedCardsPerPack;   // an array holding the cards not used 
                                        // in the game.  e.g. pinochle does not 
                                        // use cards 2-8 of any suit
   
   /**
    * Primary constructor for the CardGameFramework Class.
    * @param numPacks
    * @param numJokersPerPack
    * @param numUnusedCardsPerPack
    * @param unusedCardsPerPack
    * @param numPlayers
    * @param numCardsPerHand
    */
   public CardGameFramework( int numPacks, int numJokersPerPack,
         int numUnusedCardsPerPack , Card[] unusedCardsPerPack,
         int numPlayers, int numCardsPerHand)
   {
      //Set Parameters
      this.numPacks = numPacks;
      this.numJokersPerPack = numJokersPerPack;
      this.numUnusedCardsPerPack = numUnusedCardsPerPack;
      this.unusedCardsPerPack = unusedCardsPerPack;
      this.numPlayers = numPlayers; 
      this.numCardsPerHand = numCardsPerHand;
      
      //Create New game
      newGame();
   }
   
   /**
    * Default Constructor
    */
   public CardGameFramework()
   {
      this(defaultNumPacks, defaultNumJokersPerPack, 
            defaultNumUnusedCardsPerPack, defaultUnusedCardsPerPack,
            defaultNumPlayers, defaultNumCardsPerHand);
   }
   
   /**
    * Return an individual's hand based on his position in the Hand Array.
    * @param k
    * @return
    */
   public Hand getHand (int k)
   {  
      return null;
   }
   
   /**
    * Get a card from the deck. Returns and removes the top card in 
    * the deck.
    * @return
    */
   public Card getCardFromDeck()
   {
      return deck.dealCard();
   }
   
   /**
    * Get the number of cards remaining in the deck. 
    * @return
    */
   public int getNumCardsRemainingInDeck()
   {
      return deck.getNumCards();
   }
   
   /**
    * Creates a new game with a new deck and new hands.
    */
   public void newGame()
   {
      //Stock new deck
      deck = new Deck(numPacks);
      
      //Add Jokers
      for (int i = 0; i < numJokersPerPack*numPacks; i++) 
      {
         deck.addCard(new Card('X', Card.Suit.clubs));
      }
      
      //Shuffle Deck
      deck.shuffle();
      
      //Deal hands to all people playing the game.
      deal();
   }
   
   
   
   /**
    * Deals a hand to each of the people playing in the game. 
    * @return
    */
   public boolean deal()
   {
      boolean valid = false;
      
      // Test if there are enough cards in the deck to deal
      if (deck.getNumCards() < numCardsPerHand * numPlayers)
      {
         valid = false;
      }
      else
      {
         for (int i = 0; i < numCardsPerHand; i++)
         {
            for (int j = 0; j < hand.length; j++)
            {
               hand[j].takeCard(getCardFromDeck());
            }
         }
         
         //Set valid to be true; Successfully dealt cards.
         valid = true;
      }
      return valid;
   }  
   

   /*
    * CardGameFramework( int numPacks, int numJokersPerPack,
int numUnusedCardsPerPack , Card[] unusedCardsPerPack,
int numPlayers, int numCardsPerHand) - filters then calls newGame() (see below).  A default constructor should be provided, and for that (and any bad parameters) the default values for the six paraters to this constructor are:
   numPacks = 1
   numJokersPerPack = 0
   numUnusedCardsPerPack = 0
   unusedCardsPerPack = NULL
   numPlayers = 4
   numCardsPerHand = 13
Hand getHand(int k) --  hands start from 0 like arrays
Card getCardFromDeck()  - returns/removes top card from the deck.
int getNumCardsRemainingInDeck() - sef-explanatory
void newGame() -  restocks deck according to all private data and shuffles.  This will reset the hands, initialize the deck, remove and add any jokers or unused cards and shuffle the deck.
boolean deal() - returns false if not enough cards, but deals what it can even so, true, otherwise.  In a loop, it takes a card off the deck (dealCard()) and puts it into a hand until every hand has correct # cards.  The usual convention is to deal each player one card and repeat, not to deal one player his cards, and move to next player.
Note:  we don't need individual mutators for value and suit since it would not be needed for this particular class.
    */

}
