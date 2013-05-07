class Automaton
{
   // class constants
   public final static int MAX_DISPLAY_WIDTH = 121;
   
   // private members
   private boolean rules[];  // allocate rules[8] in constructor!
   private String thisGen;   // same here
   String extremeBit; // bit, "*" or " ", implied everywhere "outside"
   int displayWidth;  // an odd number so it can be perfectly centered
   
   // public constructors, mutators, etc. (need to be written)
   /**
    * Automaton constructor. 
    * @param new_rule
    */
   public Automaton(int new_rule)
   {
      rules = new boolean[8];
      thisGen = " * ";
      extremeBit = " ";
      setDisplayWidth(MAX_DISPLAY_WIDTH);
      SetRule(new_rule);
   }
   
   public Automaton()
   {
      this(0); //default as rule 0;
   }
   
   public void resetFirstGen()
   {
      
   }
   
   public boolean SetRule(int new_rule)
   {
      if(new_rule > 255 || new_rule < 0)
      {
         //does not pass sanitation check.
         return false;
      } 
      else //if within 8-bit
      {
         for (int i = 0; i < rules.length; i++)
         {
            if (new_rule % 2 == 1)
            {
               rules[i] = true; 
            }
            else
            {
               rules[i] = false;
            }
            
            new_rule = new_rule / 2; //divide by 2, rounded?
         }
      }
      
      for (int i = 0; i < rules.length; i++)
      {
         System.out.println(rules[i]);
      }
      return true;
   }
   
   public boolean setDisplayWidth(int width)
   {
      if (width > MAX_DISPLAY_WIDTH)
      {
         return false;
      }
      displayWidth = width;
      return true;
   }
   
   public String toStringCurrentGen()
   {
      int blanks = (displayWidth - thisGen.length())/2;
      String buffer = "";
      for (int i = 0; i < blanks; i++)
      {
         buffer = buffer + ' ';
      }
      return buffer + thisGen + buffer;
   }
   
   public void propagateNewGeneration()
   {  
      String newGen = "";
      
      thisGen = extremeBit + extremeBit + thisGen + extremeBit + extremeBit;
      
      //System.out.println("thisGen length = " + thisGen.length());
      for(int i = 1; i < thisGen.length()-1; i++)
      {
         int bin = 0; //binary value of index number
         int pow = 4;
         for (int j = 0; j < 3; j++)
         {
            if (thisGen.charAt(i-1+j) == '*')
            {
               bin += pow;
            }
            pow = pow / 2; // 4, 2, 1;
         }
         
         if(rules[bin])
         {
            newGen = newGen + '*';
         } else { newGen = newGen + ' '; }
         
      }
      
      thisGen = newGen;
      //
   }
}