
public class Foothill {
   public static void main(String[] args)
   {
      Client c1 = new Client();
      Client c2 = new Client("Brian", 10000, 20);
      Writer w1 = new Writer();
      System.out.println("----- Client 1 -----\n" + c1 + "\n");
      System.out.println("----- Client 2 -----\n" + c2 + "\n");
      System.out.println("----- Writer 1 -----\n" + w1 + "\n");
   }
}
