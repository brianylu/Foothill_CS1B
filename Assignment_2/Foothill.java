/**
 * Test method for the CardsGameFramework class as well as other helper
 * functions for the cards.
 * @author brlu
 *
 */

public class Foothill {
   public static void main(String args[])
   {
      /*
       * this.numPacks = numPacks;

      this.numJokersPerPack = numJokersPerPack;
      this.numUnusedCardsPerPack = numUnusedCardsPerPack;
      this.unusedCardsPerPack = unusedCardsPerPack;
      this.numPlayers = numPlayers; 
      this.numCardsPerHand = numCardsPerHand;
      */
      System.out.println("==================Bridge Game==================\n");
      testGame(new CardGameFramework(), 4);
      
      
      //Testing Pinochle
      Card[] unusedCardsPinochle = new Card[28];
      for (int i = 0; i < 7; i++) //dont use first 7 cards
      {
         for (int j = 0; j < Card.Suit.values().length; j++)
         {
            unusedCardsPinochle[(i+1)*j] = 
                  new Card(Card.VALID_VALUES[i], Card.Suit.values()[j]);
         }
      }
      
      System.out.println("=================Pinochle Game==================\n");
      testGame(new CardGameFramework(2, 0, 28, unusedCardsPinochle, 4, 12), 4);
   }
   
   private static void testGame(CardGameFramework cardGame, int numPlayers)
   {      
      for (int i = 0; i < numPlayers; i++)
      {
         System.out.println("Player #" + i + 
               " ---------------------------------------\n" + 
               cardGame.getHand(i) + "\n");
      }
      
      boolean valid = true;
      System.out.println("Remaining Cards in Deck:\n");
      while (valid)
      {
         Card c = cardGame.getCardFromDeck();
         if (c == null)
         {
            valid = false;
         }
         else { System.out.println(c + "\n"); }
      }
   }
}
