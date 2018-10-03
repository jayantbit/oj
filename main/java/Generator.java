import java.util.Random;

/**
 * Created by jayant.mukherji on 12/06/16.
 */
public class Generator {
  public static void main(String[] args) {
    int i, j,limit=200000;
    System.out.println(limit);


    Random random = new Random();
    for(i=0;i<limit;i++)
    {
      int num=-1000000+ random.nextInt(2000000);
      if (i > 0) {
        System.out.print(" ");
      }
      System.out.print(num);
    }

    System.out.println();

    System.out.println(limit);

    for(i=0;i<limit;i++)
    {
      int a= random.nextInt(limit);
      int b= a+random.nextInt(limit-a);
      System.out.print(a +" " +b);

      int c= random.nextInt(2);
      if(c==1)
      {
        int num=-1000000+ random.nextInt(2000000);
        System.out.print(" " +num);
      }

      System.out.println();
    }
  }
}
