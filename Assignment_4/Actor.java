
public class Actor extends Client{
   private char gender; //('M' or 'F')
   private int age; //0 to 120;
   
   /**
    * Default constructor
    */
   public Actor()
   {
      setGender('M');
      setAge(20);
   }
   
   /**
    * Primary constructor
    */
   public Actor(String name, long incomeThisYear, double percentCut,
         char gender, int age)
   {
      super(name, incomeThisYear, percentCut);
      setGender(gender);
      setAge(age);
   }
   
   
   /**
    * Setter method for gender
    * @param gender
    */
   public void setGender(char gender)
   {
      if(!isGender(gender))
      {
         this.gender = 'M';
      }
      else
      {
         this.gender = gender;
      }
   }
   
   public void setAge(int age)
   {
      if(!isAge(age))
      {
         this.age = 20;
      }
      else 
      {
         this.age = age;
      }
   }
   
   /**
    * Getter method for gender
    * @return
    */
   public char getGender()
   {
      return gender;
   }
   
   /**
    * Getter method for Age
    * @return
    */
   public int getAge()
   {
      return age;
   }
   /**
    * Helper function to check age and gender
    * @param gender
    * @return
    */
   protected boolean isGender(char gender)
   {
      return gender == 'M' || gender == 'F';
   }
   
   protected boolean isAge(int age)
   {
      return age >= 0 && age <= 120;
   }
   
   /**
    * toString that is derived from super class.
    */
   public String toString()
   {
      return super.toString()+
            "\nGender = " + gender + 
            "\nAge = " + age;
   }
   
}
