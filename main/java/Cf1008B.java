import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Cf1008B {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int n=in.nextInt(),i,j,k;
    List<Integer> list = new ArrayList<>();


    for(i=0;i<n;i++)
    {
       k=in.nextInt();
       list.add(k);
    }


    Collections.sort(list);


     for(i=0,j=0,k=0;i<n && j<n;)
     {
       if(list.get(j)> list.get(i))
       {
         k++;
         i++;j++;
       }
       else j++;
     }

    System.out.println(k);

  }
}
