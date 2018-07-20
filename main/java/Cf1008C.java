import java.util.Scanner;

public class Cf1008C {



  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);

    //4 10
    // 12 15

    int n=in.nextInt(),i;
    int last=Integer.MAX_VALUE;
    boolean  flag=true;

    for(i=0;i<n;i++)
    {
       int w=in.nextInt();
       int h=in.nextInt();

        int mx=Math.max(w,h);
        int mn=Math.min(w,h);

        if(mx<=last)
        {
          last=mx;
        }
        else if(mn<=last)
        {
          last=mn;
        }
        else flag=false;
    }

    if(flag)System.out.println("YES");
    else System.out.println("NO");
    }
}
