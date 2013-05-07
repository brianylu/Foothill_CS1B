import java.util.Scanner;

/**
 * Main class that tests the automaton.
 * @author blu
 *
 */
public class Foothill
{
   public static void main(String[] args)
   {
      int rule, k;
      String strUserIn;
      
      Scanner inputStream = new Scanner(System.in);
      Automaton aut;

      // get rule from user
      do
      {
         System.out.print("Enter Rule (0 - 255): ");
         // get the answer in the form of a string:
         strUserIn = inputStream.nextLine();
         // and convert it to a number so we can compute:
         rule = Integer.parseInt(strUserIn);

      } while (rule < 0 || rule > 255);

      // create automaton with this rule and single central dot
      aut = new Automaton(rule);

      // now show it
      System.out.println("   start");
      for (k = 0; k < 100; k++)
      {
         System.out.println( aut.toStringCurrentGen() );
         aut.propagateNewGeneration();
      }
      System.out.println("   end");
      inputStream.close();
   }
}