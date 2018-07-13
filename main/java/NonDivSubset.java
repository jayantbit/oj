import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jayant.mukherji on 24/05/16.
 https://www.hackerrank.com/contests/w20/challenges/non-divisible-subset
 */
public class NonDivSubset {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n=in.nextInt(),k=in.nextInt(),i,j;
    int cnt[]=new int[k];
    Arrays.fill(cnt, 0);
    for(i=0;i<n;i++)
    {
      j=in.nextInt();
      cnt[j%k]++;
    }

    int ans=0;
    for(i=1;i<=k/2;i++)
      if(i!=k-i)
        ans+=Math.max(cnt[i],cnt[k-i]);
      else if(cnt[i]!=0)ans++;

    if(cnt[0]!=0)ans++;
    System.out.println(ans);
  }
}
