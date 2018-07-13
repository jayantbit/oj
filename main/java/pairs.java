import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



public class pairs{
  public static void main(String args[])
  {
    Scanner in = new Scanner(System.in);
    int n=in.nextInt(),k=in.nextInt(),i,j;
    ArrayList arr = new ArrayList<Integer>();
    for(i=0;i<n;i++)
    {
      j=in.nextInt();
      arr.add(j);
    }
    Collections.sort(arr);
    long ans=0;
    for(i=0;i<n;i++)
    {
      int target=(k+(int)arr.get(i));
      int pos=Collections.binarySearch(arr,target);
      //System.out.println(i+" "+pos);
      if(pos>0)ans++;
    }
    System.out.println(ans);
  }
}
