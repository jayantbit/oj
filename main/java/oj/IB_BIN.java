/*
1 3 5
001
011
101

001 011 101 010

 1 0 1

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IB_BIN {
  static int count[]= new int[32];

   static void update(int num)
  {
    for(int j=0;j<32;j++)
    {
      if((num&(1<<j))!=0)
      {
        count[j]++;
      }
    }
  }

  public static  void main(String[] args) {

    List<Integer> list = Arrays.asList(1,3,5);

    int i,j,len=list.size();
    long f=0;
    ArrayList<ArrayList<Integer>> l =new ArrayList<>();



    Arrays.fill(count, 0);

    update(list.get(len - 1));
    for(i=len-2;i>=0;i--)
    {
      int val=list.get(i);


      for(j=0;j<32;j++)
       {
         if( (val&(1<<j))!=0)
         {
            f+=len-i-1-count[j];

         }
         else  {
           f+=count[j];
         }
       }
      update(val);
    }
    System.out.println(2*f);
}
}
