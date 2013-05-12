
public class Client {

   private static final int MIN_name_length = 3;
   private static final int MAX_name_length = 60;
   private static final long MIN_incomeThisYear = 0;
   private static final long MAX_incomeThisYear = 1000000000;
   private static final double MIN_percentCut = 0; 
   private static final double MAX_percentCut = 99.99;
   
   
   private String name; //The name of the Client.
   private long incomeThisYear; //how much the Client made so far this year.
   private double percentCut; //usually 10, but you can always make a deal 
                              //for less if you are in demand and easy to 
                              //market.  Legal values between 0 and 99.99.
   
   public Client(String name, long incomeThisYear, double percentCut)
   {
      setName(name);
      setIncomeThisYear(incomeThisYear);
      setPercentCut(percentCut);
   }
   
   public Client()
   {
      this("Default", MIN_incomeThisYear, 10);
   }
   
   /**
    * Accessor method for name
    * @return
    */
   public String getName()
   {
      return name;
   }
   
   /**
    * Accessor method for incomeThisYear
    * @return
    */
   public long getIncomeThisYear()
   {
      return incomeThisYear;
   }
   
   /**
    * Accessor method for percentCut
    * @return
    */
   public double getPercentCut()
   {
      return percentCut;
   }
   
   /**
    * Setter method for name
    * @param newName
    * @return
    */
   public boolean setName(String newVal)
   {
      if (!checkName(newVal))
      {
         name = "Default";
         return false;
      }
      else
      {
         name = newVal;
      }
      return true;
   }
   
   /**
    * Setter method for incomeThisYear
    * @param newVal
    * @return
    */
   public boolean setIncomeThisYear(long newVal)
   {
      if (!checkIncomeThisYear(newVal))
      {
         incomeThisYear = 0;
         return false;
      }
      else
      {
         incomeThisYear = newVal;
      }
      return true;
   }
   
   /**
    * Setter method for percentCut
    * @param newVal
    * @return
    */
   public boolean setPercentCut(double newVal)
   {
      
      if (!checkPercentCut(newVal))
      {
         percentCut = 0;
         return false;
      }
      else
      {
         percentCut = newVal;
      }
      return true;
   }
   
   /**
    * Protected helper methods for validating name, income, and cut rate.
    * @param newVal
    * @return
    */
   protected static boolean checkName(String newVal)
   {
      return (newVal.length() >= MIN_name_length && 
            newVal.length() <= MAX_name_length);
   }
   
   protected static boolean checkIncomeThisYear(long newVal)
   {
      return (newVal >= MIN_incomeThisYear && newVal <= MAX_incomeThisYear);
   }
   
   protected static boolean checkPercentCut(double newVal)
   {
      return (newVal >= MIN_percentCut && newVal <= MAX_percentCut);
   }
   
   /**
    * toString method for the Client Class
    */
   public String toString()
   {
      return "Name = " + name + 
            "\nIncome = " + incomeThisYear + 
            "\nPercent Cut = " + percentCut;
   }
}

/*
Create a base class called Client that has the following private members:

String name - The name of the Client.  Must be between 3 and 60 characters.
long incomeThisYear - how much the Client made so far this year.  Legal values between 0 and $1 billion.
double percentCut - usually 10, but you can always make a deal for less if you are in demand and easy to market.  Legal values between 0 and 99.99.
MIN_xxx and MAX_xxx - six static finals that define limits for all three private members.  Used by mutators.
*/