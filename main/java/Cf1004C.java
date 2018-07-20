import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Cf1004C {

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);

    int n= in.nextInt(),i,j,k;


    Map<Integer,Integer> first= new HashMap<>();
    Map<Integer,Integer> last= new HashMap<>();

    int distNum [] = new int[n];

    for(i=0;i<n;i++)
    {
      int num = in.nextInt();
      last.put(num,i);

      if(!first.containsKey(num))
        first.put(num,i);

      distNum[i]=first.size();
    }


    long ans=0;

    for(Map.Entry<Integer,Integer> entry: last.entrySet())
    {
        int pos1=entry.getValue();   //last occ
        int pos2=last.get(entry.getKey());  //first occ

       if(pos1!=pos2) ans+= (long)distNum[pos2];
       else if(pos1>0)ans+=(long)distNum[pos1-1];
    }

    System.out.println(ans);
  }
}
