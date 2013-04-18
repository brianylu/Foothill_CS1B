/**
 * 
 * @author brlu
 * 
 * Card class which defines a certain card from A to K, and 4 different suits. 
 */
public class Card 
{   
   /** 
    * Enums for suit and state variables
    */
   public enum Suit { clubs, diamonds, hearts, spades };
   public enum State { deleted, active };

   private char value;
   private Suit suit;
   private State state;
   private boolean errorFlag;

   /**
    * Default constructor
    */
   public Card()
   {
      errorFlag = false;
      this.value = 'A';
      this.suit = Suit.spades;      
   }
   
   /**
    * Primary constructor for the Card class. 
    * @param value
    * @param suit
    */
   public Card(char value, Suit suit)
   {
      errorFlag = true; // default as true
      char upVal = Character.toUpperCase(value);
      if (testValue(upVal)) //tests if the value is a valid card.
      {
         errorFlag = false;
         this.value = upVal;
         this.suit = suit;
      }  
      else
      {
         errorFlag = false;
      }
   }


   /**
    * Sets a value for a card. If values are invalid, does not change values. 
    * 
    * @param value
    * @param suit
    * @return
    */
   public boolean set (char value, Suit suit)
   {
      errorFlag = true;
      //check logic for whether value or suit is valid.
      this.value = value;
      this.suit = suit;
      return errorFlag;
   }

   /**
    * Accessor and Mutator for the card state.
    * @return
    */
   public State getState()
   {
      return state;
   }
   
   /**
    * Mutator for the card state;
    * @param state
    */
   public void setState(State state)
   {
      this.state = state;
   }

   /**
    * Accessor for Suit.
    * @return
    */
   public Suit getSuit()
   {
      return suit;
   }

   /**
    * Accessor for Card Value
    * @return
    */
   public char getValue()
   {
      return value;
   }

   /**
    * Accessor for errorFlag
    * @return
    */
   public boolean getErrorFlag()
   {
      return errorFlag;
   }
   
   /**
    * Tests if two cards are equal.
    * @param card
    * @return
    */
   public boolean equals(Card card)
   {
      return ( card.getState() == state &&
            card.getSuit() == suit &&
            card.getValue() == value);
   }
   
   
   /**
    * Helper function to test if the value assigned to a card is valid.
    * @param value
    * @return
    */
   private boolean testValue(char upVal)
   {
      return (upVal == 'A' || 
            upVal == 'K' || 
            upVal == 'Q' || 
            upVal == 'J' || 
            upVal == 'T' || 
            upVal == 'X' || 
            (upVal >= '2' && upVal <= '9'));
   }
   
   
   /**
    * toString method for the Card Class.
    * 
    * Displays the value and suit of the card. 
    */
   public String toString()
   {
      //todo finish;
      return "";
   }
}
