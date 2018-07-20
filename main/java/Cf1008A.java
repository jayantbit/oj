import java.util.Scanner;

public class Cf1008A {


  static boolean isVowel(char ch)
  {
    return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u';
  }


  static boolean isAlpha(char ch)
  {
    return  (ch>='a' && ch<='z');
  }

  public static void main(String[] args) {
    Scanner in =  new Scanner(System.in);
    String s= in.nextLine();
    int  len=s.length(),i,j,k;

    boolean flag=true;
    for(i=0;i<len;)
    {

      if(isVowel(s.charAt(i)))
      {
        i++;
        while(i<len &&  !isAlpha(s.charAt(i)) )
          i++;
       continue;
      }

      //consonent

      if(s.charAt(i)=='n')
      {
        i++;
        while(i<len &&  !isAlpha(s.charAt(i)) )
          i++;
        continue;

      }

      if(i+1>=len ||  !isVowel(s.charAt(i+1)))
      {
        flag=false;
        break;
      }
      i++;
    }
    if (flag) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }

  }
}
