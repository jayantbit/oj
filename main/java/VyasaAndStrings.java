import java.util.Scanner;

/**
 * Created by jayant.mukherji on 27/05/16.
 codeforces.com/contest/676/problem/C
 */
public class VyasaAndStrings {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n,k,i,j,a,b;
    n=in.nextInt();
    k=in.nextInt();
    String str=in.next();
    int ans=0;
    for(i=j=a=b=0;j<n && i<=j;)
    {
      if(Math.min(a,b)<=k)
      {
        //System.out.println(i+" "+j+" "+a+" "+b);
        ans=Math.max(ans,j-i);
        if(str.charAt(j)=='a')a++;
        else b++;
        j++;
      }
      else {
        while(Math.min(a,b)>k) {
          if (str.charAt(i) == 'a') a--;
          else b--;
          i++;
        }
      }
    }

    if(Math.min(a,b)<=k) {
      ans = Math.max(ans, j - i);
    }
    System.out.println(ans);
  }
}

