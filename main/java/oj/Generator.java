/**
 * Created by jayant.mukherji on 12/06/16.
 */
public class Generator {
  public static void main(String[] args) {
    int i, j;
    System.out.println("1000 1000");
    for (i = 0; i < 1000; i++) {
      for (j = 0; j < 1000; j++) {
        if (j > 0) System.out.print(" ");
        System.out.print( (int)(1 + Math.random() * 1000));
      }
      System.out.println();
    }
    System.out.println(50);
    for(i=0;i<50;i++)
    System.out.println("2 2");
  }
}
