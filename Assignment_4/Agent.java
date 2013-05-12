
public class Agent {
   private String name; //the Agent's name. (private)
   private Client[] myClients; //an array of Client references.  Don't instantiate individual Clients ... we allow this array to point to the caller's Client objects. (private)
   private int numClients; //the current number of Clients this Agent has. (private)
   private static final int MAX_CLIENTS = 10;
   private static final int MIN_NAME_LEN = 2;
   private static final int MAX_NAME_LEN = 20; 
   
   public Agent()
   {
      this("Agent X", new Client[10], 0);
   }
   
   public Agent(String name, Client[] clients, int numClients)
   {
      setName(name);
      setClients(clients);
   }
   
   public boolean setName(String name)
   {
      if (!checkName(name))
      {
         this.name = "Default Agent";
         return false;
      }
      
      this.name = name;
      return true;
   }
   
   public boolean setClients(Client[] clients)
   {
      for (int i = 0; i < clients.length; i++)
      {
         myClients[i] = clients[i];
      }
      return false;
   }
      
   /**
    * Helper function to check if name is correct
    * @param name
    * @return
    */
   protected boolean checkName(String name)
   {
      return name.length() >= MIN_NAME_LEN && name.length() <= MAX_NAME_LEN;
   }
   
   public boolean addClient(Client client)
   {
      if (numClients >= MAX_CLIENTS)
      {
         return false;
      }
      //else
      myClients[numClients] = client;
      numClients++;
      return true;
   }
   
   public boolean removeClient(Client client)
   {
      
      //find client
      boolean shift = false;
      
      for (int i = 0; i < numClients; i++)
      {
         if (shift)
         {
            myClients[i-1] = myClients[i];
         } //else do nothing
         
         if (myClients[i].equals(client))
         {
            shift = true;
         } //else do nothing
         
      }
      return shift;
   }
   
   public String toStringClientsShort()
   {
      String clientNames = "";
      
      for (int i = 0; i < numClients; i++)
      {
         clientNames = clientNames + myClients[i].getName() + "\n";
      }
      return "";
   }
   
   public String toStringClientsLong()
   {
      String clientNames = "";
      
      for (int i = 0; i < numClients; i++)
      {
         clientNames = clientNames + myClients[i].getName() + "\n";
      }
      return "";
   }
   
   /*
    * boolean addClient(Client client) - puts client into the Agent's list.
boolean removeClient(Client client) - removes client by squeezing him out of the list (move the clients above down one), not by setting the array location to null.
String toStringClientsShort() - returns a list of all this Agent's Clients' names (only names).
String toStringClientsLong() - returns  a list of all the Clients, using the Client display method.
double getIncome() - Returns the dollar amount collectable from all Clients so far this year (based on each client's income and percent cut to the agent).
    */
}
