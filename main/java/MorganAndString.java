import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by jayant.mukherji on 24/05/16. ab abc
 https://www.hackerrank.com/challenges/morgan-and-a-string
 */

public class MorganAndString {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int tc = in.nextInt();
    HashMap<Integer, Integer> mp = new HashMap<>();

    while (tc-- > 0) {
      String a = in.next(), b = in.next();

      int len1 = a.length(), len2 = b.length(), i, j, flag = 0, lim1 = 0,lim2=0;

      for (i = 0, j = 0; i < len1 && j < len2; ) {
        if (a.charAt(i) < b.charAt(j)) {
          System.out.print(a.charAt(i++));
        } else if (a.charAt(i) > b.charAt(j)) {
          System.out.print(b.charAt(j++));
        } else if (mp.containsKey(i - j)) {

          flag = mp.get((i - j));
          if (flag == -1) System.out.print(a.charAt(i++));
          else if (flag == 1) System.out.print(b.charAt(j++));
        } else {
          int k = 0;
          while (i + k < len1 && j + k < len2 && a.charAt(i + k) == b.charAt(j + k)) k++;

          if (i + k >= len1) flag = 1;
          else if (j + k >= len2) flag = -1;
          else if (a.charAt(i + k) < b.charAt(j + k)) flag = -1;
          else flag = 1;

          mp.put(i - j, flag);
          lim1=Math.min(len1-1,i+k);
          lim2=Math.min(len2-1,j+k);
        }

        if(i>lim1 || j>lim2)mp.clear();
      }

      while (i < len1) System.out.print(a.charAt(i++));
      while (j < len2) System.out.print(b.charAt(j++));


      System.out.println();

    }
  }
}
