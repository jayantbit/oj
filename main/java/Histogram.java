import java.util.Scanner;
import java.util.Stack;

import javafx.util.Pair;

/**
 * Created by jayant.mukherji on 30/05/16.
 */
public class Histogram {

  public static void main(String[] args) {
  Scanner in = new Scanner(System.in);

   int n,i,j,k;
   n=in.nextInt();
   int arr[] =new int[n];
    int l[]= new int[n];
    int r[]=new int[n];

    for(i=0;i<n;i++)
     arr[i]=in.nextInt();

    Stack<Pair<Integer,Integer>> st = new Stack<>();

    for(i=0;i<n;i++)
    {
      k=0;
      while(!st.empty() && st.peek().getKey()>=arr[i])
      {
        k+=st.peek().getValue();
        st.pop();
      }
      st.push(new Pair(arr[i],k+1));
      l[i]=k+1;
    }
     st.clear();
    for(i=0;i<n;i++)
      System.out.print(l[i]+ " ");
    System.out.println();

    for(i=n-1;i>=0;i--)
    {
      k=0;
      while(!st.empty() && st.peek().getKey()>=arr[i])
      {
        k+=st.peek().getValue();
        st.pop();
      }
      st.push(new Pair(arr[i],k+1));
      r[i]=k+1;
    }

    for(i=0;i<n;i++)
      System.out.print(r[i]+ " ");
    System.out.println();

    int ans=0;
    for(i=0;i<n;i++)
    {
      ans=Math.max(ans,arr[i]*(l[i])+r[i]-1);
    }
    System.out.println(ans);
  }
}
