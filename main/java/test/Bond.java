package test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Bond   {

  public static void main(String[] args) {

    int n=5;

    int  list[]= IntStream.range(0,n).toArray();

    int pos=0;
    Random random = new Random();
    //random.setSeed(new Date().getTime());

    for(int i=0;i<n;i++)
    {
      int randPos= i+(int)random.nextInt(n-i);

      int temp=list[pos];
      list[pos]=list[randPos];
      list[randPos]=temp;

    }



    for (Integer num : list) {
      System.out.print(num+ " ,");
    }
    System.out.println();
  }


}
