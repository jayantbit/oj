
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by jayant.mukherji on 27/08/16.
 */
public class Dict {

  static HashSet<String> hs = new HashSet<>();
  static String str;
  static int len;

  static HashMap<Integer, Boolean> memo = new HashMap<>();

  static boolean check(int start) {
    if (start > len) return true;

    if (hs.contains(str.substring(start, len))) return true;
    if (memo.containsKey(start)) return memo.get(start);

    int i;
    for (i = start + 1; i < len; i++) {
      String temp = str.substring(start, i);
      if (hs.contains(temp)) {
        if (check(i)) {
          memo.put(start, true);
          return true;
        }
      }
    }
    memo.put(start, false);
    return false;
  }

  public static void main(String[] args) {


    Scanner in = new Scanner(System.in);
    int n = in.nextInt(), i, j, k;

    for (i = 0; i < n; i++) {
      String s = in.next();
      hs.add(s);
    }

    str = in.next();
    len = str.length();
    System.out.println(check(0));

  }
}
