import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * Created by jayant.mukherji on 07/05/16.
 */

//https://www.hackerrank.com/challenges/java-dequeue


public class Dequeue {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Deque deque = new ArrayDeque<>();
    int n = in.nextInt();
    int m = in.nextInt();
    int ans = 0;
    int dis = 0;
    int cnt[] = new int[10000001];
    for (int i = 0; i < n; i++) {
      int num = in.nextInt();
      deque.addLast(num);
      cnt[num]++;
      if (cnt[num] == 1) {
        dis++;
      }

      if (i >= m) {
        int front = (int) deque.pop();
        cnt[front]--;
        if (cnt[front] == 0)
          dis--;
      }
      ans = Integer.max(ans, dis);
    }
    System.out.println(ans);
  }
}
