import java.util.Scanner;

/**
 * Created by jayant.mukherji on 30/05/16.
 */
public class LPS {

  static void fn(String str)
  {
    int len,i,j,k,l=str.length();
    int lps[] = new int[l];
    lps[0]=0;
    i=1;len=0;
    while(i<l)
    {
      if(str.charAt(i)==str.charAt(len))
      {
        len++;
        lps[i]=len;
        i++;
      }
      else
      {
        if(len!=0)
        {
          len=lps[len-1];
        }
        else
        {
          lps[i]=0;
          i++;
        }
      }
    }

    for(i=0;i<l;i++)
      System.out.print(lps[i]+" ");
    System.out.println();
  }

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    String str = in.next();
    fn(str);
  }
}
