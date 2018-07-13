import java.util.Scanner;
import java.util.Stack;

/**
 * Created by jayant.mukherji on 30/05/16.
 )()()))((()))
Max length of matching bracekts
 */
public class MaxMatch {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String str =in.next();
    int len=str.length(),i,j,k;
    Stack<Integer> st = new Stack<>();
    st.push(-1);
    int ans=0;
    for(i=0;i<len;i++)
    {
      if(str.charAt(i)=='(')st.push(i);
      else
      {
        if(st.empty())st.push(i);
        int pos=st.pop();
        if( pos!=-1 && str.charAt(pos)=='(')
        {
          ans=Math.max(ans,i-st.peek());
        }
        else st.push(i);
      }
    }
    System.out.println(ans);
  }
}
