
import java.util.Scanner;
public class div101 {

  static boolean visited[] = new boolean[1000001];
  static int n;

  static boolean fn(int p) {

    visited[p] = true;

    if (p==0) return true;
    int a = (p * 10) % n;
    if (!visited[a] && fn(a)) {
      System.out.print("0");
      return true;
    }
    int b = (p * 10 + 1) % n;
    if (!visited[b] && fn(b)) {
      System.out.print("1");
      return true;
    }
    return false;
  }

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    n = in.nextInt();
    System.out.print("1");
    fn(1);
  }
}