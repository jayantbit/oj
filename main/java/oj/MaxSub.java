import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jayant.mukherji on 25/05/16.
 */
public class MaxSub {
  public static void main(String[] args) {

    ArrayList<Integer> arr[] = new ArrayList[10000];
    Scanner in =new Scanner(System.in);
    int n,m,i,j,k;
    n=in.nextInt();
    m=in.nextInt();

    System.out.println(n+" "+m);
    for(i=0;i<n;i++)
      for(j=0;j<m;j++)
      {
        k=in.nextInt();
        arr[i].add(k);
      }

    for(i=0;i<n;i++)
      for(j=0;i<arr[i].size();i++)
        System.out.println(arr[i].get(j));

  }
}
