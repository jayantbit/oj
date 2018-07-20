import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cf1009A {

  public static void main(String[] args) {
    //http://codeforces.com/contest/1009/problem/A

    Scanner in = new Scanner(System.in);

    int n=in.nextInt();
    int m = in.nextInt();

    List<Integer> toys= new ArrayList<>();
    List<Integer> bills= new ArrayList<>();

    int i,j,k;
    for(i=0;i<n;i++)
    {
      k=in.nextInt();
      toys.add(k);
    }

    for(i=0;i<m;i++)
    {
      k=in.nextInt();
      bills.add(k);
    }

    j=0;
    int total=0;
    for(i=0;i<n;i++)
    {
      if(j<m && toys.get(i)<=bills.get(j))
      {
        total++;
        j++;
      }
    }

    System.out.println(total);

  }

}

