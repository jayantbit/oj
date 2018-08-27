import java.util.Scanner;

public class Code2 {

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);

    int n=in.nextInt(),i;

    if(n<=4)
    {
      for(i=1;i<=n;i++)
      {
        if (i > 1) {
          System.out.print(" ");
        }
        System.out.print(i);
      }
    }

    else
    {


      boolean first=true;

      for(i=n/2+1;i<=n;i++)
      {
        if (!first) {
          System.out.print(" ");
        }
        System.out.print(i);
        first=false;
      }

      for(i=1;i<=n/2;i++)
      {
        System.out.print(" "+i);
      }
    }



  }
}
