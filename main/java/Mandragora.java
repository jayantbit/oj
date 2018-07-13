import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/*
https://www.hackerrank.com/challenges/mandragora
 */

public class Mandragora {

  public static void main(String[] args) {

    int t, n, i, j, k;
    Scanner in = new Scanner(System.in);
    t = in.nextInt();
    while (t-- > 0) {
      n = in.nextInt();
      List<Integer> list = new ArrayList<>();
      for (i = 0; i < n; i++) {
        int val = in.nextInt();
        list.add(val);
      }
      Collections.sort(list, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
          return o2 - o1;
        }
      });
      long sum = 0;
      long ans = 0;
      for (i = 0; i < n; i++) {
        sum += list.get(i);
        ans = Math.max(ans, sum * (n  - i));
      }
      System.out.println(ans);
    }


  }
}
