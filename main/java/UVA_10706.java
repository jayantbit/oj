import java.util.Scanner;

/**
 * Created by jayant.mukherji on 20/05/16.
 UVA 10706
 public class Main
 */
class UVA_10706 {


  static int dig(long i) {
    if (i == 0) return 0;
    return 1 + dig(i / 10);
  }

  static long store[] = new long[100000];
  static int len;

  static int upperBound(long num) {
    int low = 0, high = len - 1, mid;

    while (high - low > 1) {
      mid = (low + high) >>> 1;
      long midVal = store[mid];
      if (midVal < num)
        low = mid;
      else
        high = mid;
    }
    return low;
  }


  public static void main(String[] args) {

    long curr = 0, ans = 0;
    int i;
    Scanner in = new Scanner(System.in);
    len = 0;
    long limit = 2147483647;

    for (i = 1; ans <= limit; i++) {
      curr += (long) dig(i);
      ans += curr;
      store[i] = ans;
    }
    in.nextInt();
    len = i;

    while (in.hasNext()) {
      long num = in.nextLong();

      int pos = upperBound(num);
      long req = num;
      if(pos>0)
        req-=store[pos];

      for (i = 1; i <= pos+1; i++) {
        int d = dig(i);
        if (req > d) req -= d;
        else {
          int temp = (int) (i / Math.pow(10, d - req));
          System.out.println(temp % 10);
          break;
        }
      }
    }
  }
}
