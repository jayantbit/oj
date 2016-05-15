import java.util.Scanner;
import java.util.Stack;

/**
 * Created by jayant.mukherji on 05/05/16.
 */

/*
0 2 3 5 6 7
8 1 2 1 1 3 7 0
*/
public class Brackets {

  public static char reverse(char ch)
  {
    if(ch==')')return '(';
    else if(ch=='}')return '{';
    else return '[';
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t,tc,i,j,k,l;
    Stack<Character> st = new Stack<Character>();
    while(in.hasNext())
    {
      String s=in.nextLine();
      l=s.length();

      boolean flag=true;
      for(i=0;i<l;i++)
      {
        char ch=s.charAt(i);
        if(ch=='(' || ch=='{' || ch=='[')
        {
          st.push(ch);
        }
        else if(st.empty() || st.peek()!=reverse(ch))
        {
          flag=false;
          break;
        }
        else st.pop();
      }
      flag&=st.empty();
      System.out.println(flag);
      st.clear();
    }
  }
}
