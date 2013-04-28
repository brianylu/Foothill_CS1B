import java.util.Arrays;

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
   public static char[] VALID_VALUES = {'2','3','4','5','6','7','8','9',
      'T','J','Q','K','A','X'};

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
      set(value, suit);
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
      errorFlag = true; // default as true until make sure valies 
      char upVal = Character.toUpperCase(value);
      
      if (testValue(upVal)) //tests if the value is a valid card.
      {
         errorFlag = false;
         this.value = upVal;
         this.suit = suit;
      }  
      else { } //keep errorflag true
      return !errorFlag;
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
      this.state = state; //don't need checking since state is enum  
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
    * 
    * @param value
    * @return true if valid
    */
   private boolean testValue(char upVal)
   {
      for (char c : VALID_VALUES)
      {
         if (upVal == c) { return true; }
      }
      return false;
      //return Arrays.asList(VALID_VALUES).contains(upVal);
   }
   
   
   /**
    * toString method for the Card Class.
    * 
    * Displays the value and suit of the card. 
    */
   public String toString()
   {
      String str;
      if (errorFlag == true) //if errorFlag is true, type as true;
      { 
         str = "** invalid **"; 
      }
      else if (state == State.deleted) //if state is deleted, write "deleted"
      {
         str = "( deleted )";
      }
      else
      {
         if (value == 'X')
         {
            str = "Joker " + (suit.ordinal() + 1); 
         }
         else 
         { 
            str = value + " of " + suit;
         }
      }
      return str;
   }
}
