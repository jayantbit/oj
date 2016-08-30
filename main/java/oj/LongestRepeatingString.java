import java.util.Arrays;

/**
 * Created by jayant.mukherji on 29/07/16.
 */
public class LongestRepeatingString {

  public static void main(String[] args) {
    String s = "xxxx";

    int arr[][] = new int[101][101];
    int i, j;
    for (i = 0; i < s.length(); i++)
      Arrays.fill(arr[i], 0);

    int mxans = -1, mxpos = -1;
    for (i = s.length() - 1; i >= 0; i--)
      for (j = s.length() - 1; j > i; j--) {
        if (s.charAt(i) == s.charAt(j))
          arr[i][j] = 1 + arr[i + 1][j + 1];
        else arr[i][j] = 0;

        if (arr[i][j] > mxans) {
          mxans = arr[i][j];
          mxpos = i;
        }
      }
    System.out.println(s.substring(mxpos, mxpos + mxans));

  }
}
