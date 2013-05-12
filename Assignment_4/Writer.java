
public class Writer extends Client{
   private boolean technical; //true if the writer has background in technology.
   private boolean government; //true if the writer has background in government/politics.
   private boolean international; //true if the writer has a great deal of travel experience.
   private String rank;   //one of the following:  "staff writer", "story editor", 
                  //"co-producer", "producer", "co-executive producer", 
                  //"executive producer". These are the common ranks that 
                  //determine the level that the writer is placed on a show 
                  //or film.
   
   public static String[] ranking = {"staff writer", "story editor", 
                                     "co-producer", "producer", 
                                     "co-executive producer", 
                                     "executive producer"};
   
   /**
    * Primary constructor for the Writer class
    * @param techincal
    * @param government
    * @param international
    * @param rank
    */
   public Writer(String name, long incomeThisYear, double percentCut, 
         boolean technical, boolean government,
         boolean international, String rank)
   {
      super(name, incomeThisYear, percentCut);
      setTechnical(technical); // no validation necessary
      setGovernment(government);
      setInternational(international);
      if(!setRank(rank))
      {
         this.rank = "staff writer";
      }
      
   }
   
   /**
    * Default constructor
    */
   public Writer()
   {
      super();
      
      //set default values
      technical = false;
      government = false;
      international = false;
      rank = "staff writer";
   }
   
   public void setTechnical(boolean technical)
   {
      //nothing to validate since boolean
      this.technical = technical; 
   }
   
   public void setGovernment(boolean government)
   {
      this.government = government;
   }
   
   public void setInternational(boolean international)
   {
      this.international = international;
   }
   
   public boolean setRank(String rank)
   {
      if(!checkRank(rank))
      {
         return false;
      }
      
      this.rank = rank.toLowerCase();
      return true;
   }
   /**
    * Accessor methods
    */
   
   public boolean getTechnical()
   {
      return technical;
   }
   
   public boolean getGovernment()
   {
      return government;
   }
   
   public boolean getInternational()
   {
      return international;
   }
      
   /**
    * Checks if the rank is valid. 
    * @return
    */
   private boolean checkRank(String r)
   {
      boolean valid = false;
      
      for (int i = 0; i < ranking.length; i++)
      {
         if (r.toLowerCase().equals(ranking[i]))
         {
            valid = true;
         }
      }
      
      return valid;
   }
   
   public String toString()
   {
      return super.toString() + 
            "\nTechnical? " + technical +
            "\nGovernment Skills? " + government +
            "\nInternational Skills? " + international + 
            "\nRank: " + rank;
   }
   
}
