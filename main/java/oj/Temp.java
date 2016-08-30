import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


class Temp {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static Scanner in = new Scanner(System.in);

  static int readInt() throws Exception {
    return in.nextInt();
  }


  public static void main(String[] args) throws Exception {

    int t = readInt();
    long arr[] = new long[100001];

    while (t-- > 0) {
      int n = readInt(), i;

      for (i = 0; i < n; i++)
        arr[i] = in.nextInt();

      int st = readInt() - 1;
      int en = readInt() - 1;
      long ans;
      int pos = (st - 1 + n) % n;
      long ft = arr[st], bt = arr[pos], fm = arr[st], bm = arr[pos];


      for (i = (st + 1) % n; i != en; i = (i + 1) % n) {
        ft += arr[i];
        fm = Math.min(fm, ft);
      }

      if (pos != en)
        for (i = (pos - 1 + n) % n; ; i = (i - 1 + n) % n) {
          bt += arr[i];
          if (i == en) break;
          bm = Math.min(bm, bt);
        }
      //System.out.println(ft+" "+fm);
      //System.out.println(bt+" "+bm);

      long p1 = 2 * bm + ft;
      long p2 = 2 * fm + bt;
      ans = Math.min(Math.min(p1, p2), Math.min(ft, bt));
      System.out.println(ans);
    }


  }
}
