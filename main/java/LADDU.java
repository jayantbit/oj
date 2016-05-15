import java.util.Scanner;

/**
 * Created by jayant.mukherji on 07/05/16.
 */
public class LADDU {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int tc = in.nextInt();
    while (tc-- > 0) {
      int n = in.nextInt();
      String nation = in.next();
      int points = 0, score = 0;
      while (n-- > 0) {
        String type = in.next();

        switch (type) {
          case "CONTEST_WON":
            score = in.nextInt();
            points += 300 + Integer.max(0,20 - score);
            break;
          case "TOP_CONTRIBUTOR":
            points += 300;
            break;
          case "BUG_FOUND":
            score = in.nextInt();
            points += score;
            break;
          case "CONTEST_HOSTED":
            points += 50;
        }
      }

      if(nation.equals("INDIAN"))
      {
        System.out.println(points/200);
      }
      else System.out.println(points/400);
    }
  }
}
