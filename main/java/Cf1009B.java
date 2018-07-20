import java.util.Arrays;
import java.util.Scanner;

public class Cf1009B {



  public static String sortString(String inputString)
  {
    // convert input string to char array
    char tempArray[] = inputString.toCharArray();

    // sort tempArray
    Arrays.sort(tempArray);

    // return new sorted string
    return new String(tempArray);
  }

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    String s= in.nextLine();
    int len=s.length();
    int i,j,k;
    StringBuilder sb= new StringBuilder();

    for(i=0;i<len;i++)
    {
      if(s.charAt(i)=='2')
        break;
    }

    if(i>0)
    {
      String temp=s.substring(0,i);

      sb.append(sortString(temp));
    }

    j=i;
    for(;i<len;i++)
    {
      if(s.charAt(i)=='1')sb.append(s.charAt(i));
    }

    for(i=j;i<len;i++)
    {
      if(s.charAt(i)!='1')sb.append(s.charAt(i));
    }

    System.out.println(sb.toString());



  }
}
