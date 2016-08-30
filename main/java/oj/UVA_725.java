import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;



 class UVA_725 {

  static int cnt[]=new int[10];
  static boolean fn(int n)
  {
    if(n < 10000 && cnt[0]>0)
      return false;
    if(n < 10000)
      cnt[0] = 1;
    while(n>0)
    {
      int x=n%10;
      cnt[x]++;
      if(cnt[x]>1)return false;
      n/=10;
    }
    return true;
  }

  public static void main(String[] args) throws Exception{
    int i, j, k;
    Scanner in = new Scanner(System.in);
    int n;
    boolean first=true;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while ((n = Integer.parseInt(br.readLine())) != 0) {

      if(n==0)break;
      if(!first)
      {
        System.out.println();

      }
      else first=false;
      boolean found = false;
      for (i = 1234; i <= 98765/n; i++) {
        Arrays.fill(cnt,0);


        if (fn(i) && fn(i*n)) {

          System.out.println(String.format("%05d / %05d = %d", i * n, i, n));
          found=true;
        }
      }
      if(!found)
        System.out.println(String.format("There are no solutions for %d.",n));
    }
  }
}
