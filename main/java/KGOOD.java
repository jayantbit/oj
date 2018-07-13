import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jayant.mukherji on 29/05/16.
 https://www.codechef.com/SNCKQL16/problems/KGOOD
 */
class KGOOD {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t, k, i, j, len;
    t = in.nextInt();
    while (t-- > 0) {
      String s = in.next();
      k = in.nextInt();
      len = s.length();
      int cnt[] = new int[26];

      Arrays.fill(cnt, 0);


      for (i = 0; i < len; i++) {
        cnt[  s.charAt(i)-'a' ]++;
      }


      Arrays.sort(cnt);

//      for(i=0;i<26;i++)
//        System.out.print(cnt[i]+" ");
//
//      System.out.println();

      for (i = 0; i < 26; i++)
        if (cnt[i] != 0) break;

      long ans = Integer.MAX_VALUE,rem=0;
      for(;i<26;i++) {

        int temp=0;
        for (j = 25; j > i; j--)
        {
          if(cnt[j]-cnt[i]>k)
            temp+=cnt[j]-cnt[i]-k;
          else break;
        }
        ans=Math.min(ans,rem+temp);
        rem+=cnt[i];
      }
      System.out.println(ans);
    }
  }
}
