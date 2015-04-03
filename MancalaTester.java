import java.util.*;
public class MancalaTester
{
   private static MancalaBoard tester;
   private static Scanner scanner =  new Scanner(System.in);
   private static String input;
   
   public static void main(String[] args)
   {
      System.out.println("Enter number of initial stones (3 or 4) : ");
      input = scanner.nextLine();
      
      tester = new MancalaBoard(Integer.parseInt(input));
      
      Pit[] test = tester.getBoard();
      tester.move(3);
      System.out.println("move pit 3");
      for (int i = 0; i < 7; i++)
      {
           System.out.print(Integer.toString(test[i].getStones()));
      }
      System.out.print("\n");
      for (int i = test.length-1; i > 6; i--)
      {
            System.out.print(Integer.toString(test[i].getStones()));
      }
   }
}
   
   
   
   
 
   
   
   
   