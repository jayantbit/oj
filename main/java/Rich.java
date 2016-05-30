import java.util.Arrays;
import java.util.Scanner;


//https://www.hackerrank.com/contests/may-world-codesprint/challenges/richie-rich
public class Rich {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int k = in.nextInt(),j=0,len,i;
    String number = in.next();
    len=number.length();
    StringBuilder str= new StringBuilder(number);

    int rem[]=new int[len];
    Arrays.fill(rem,0);
    //abcd

    for(i=0;i<len/2;i++)
      if(str.charAt(i)!=str.charAt(len-1-i))
      {
        j++;
        rem[i]=1;
        char ch=(char)Math.max(str.charAt(i),str.charAt(len-1-i));
        str.setCharAt(i,ch);
        str.setCharAt(len-1-i,ch);
      }

    if(k<j)System.out.println(-1);
    else
    {
      k-=j;
      i=0;
      while(k>0 && i<len/2)
      {
        if(str.charAt(i)=='9'){i++;continue;}

        if(rem[i]==1)
        {
          str.setCharAt(i,'9');
          str.setCharAt(len-1-i,'9');
          k--;
        }
        else if(k>=2)
        {
          str.setCharAt(i,'9');
          str.setCharAt(len-1-i,'9');
          k-=2;
        }
        i++;
      }
      if(k>0 && len%2==1)str.setCharAt(len/2,'9');
      System.out.println(str);
    }

  }
}

