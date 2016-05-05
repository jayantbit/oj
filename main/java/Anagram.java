import java.lang.Integer;
import java.util.*;

public class Anagram {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t, i, j, k, x, y;
    t = in.nextInt();
    for (i = 0; i < t; i++) {
      String s = in.next();
      HashMap<String, Integer> mp = new HashMap<>();
      int l = s.length();

      for (x = 0; x < l; x++)
        for (y = x; y < l; y++) {
          String sub = s.substring(x, y + 1);
          char chr[]=sub.toCharArray();
          Arrays.sort(chr);
          sub = String.valueOf(chr);
          if (mp.containsKey(sub)) {
            int cnt = mp.get(sub);
            mp.put(sub, cnt + 1);
          } else mp.put(sub, 1);
        }
      int ans=0;
      for(String st:mp.keySet())
      {
        int cnt=mp.get(st);
        ans+=cnt*(cnt-1)/2;
        //System.out.println(st+" "+cnt);
      }

      System.out.println(ans);
    }

  }
}