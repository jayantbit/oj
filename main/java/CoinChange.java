import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jayant.mukherji on 01/08/16.
 */
public class CoinChange {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int c = in.nextInt();
    int i, j;
    List<Integer> coins = new ArrayList<>();
    for (i = 0; i < c; i++) {
      int val = in.nextInt();
      coins.add(val);
    }
    long dp[] = new long[n + 1];
    Arrays.fill(dp, 0);
    dp[0] = 1;
    for (j = 0; j < c; j++)
      for (i = coins.get(j); i <= n; i++)
        dp[i] += dp[i - coins.get(j)];

    System.out.println(dp[n]);
  }
}
