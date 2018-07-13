/**
 * Created by jayant.mukherji on 18/07/16.
 */
public class MedianRec {

  public static void main(String[] args) {

    int arr1[] = {2, 2,10,11};
    int arr2[] = {5, 6, 7, 8};

    /*
      2 10
      5 6
      5 6 7 8
      1 2 3 4
      2 2 5 6 7 8 10 11
      handle odd even case separately
    */
    int l1 = 0, l2 = 0, h1 = arr1.length - 1, h2 = arr2.length - 1, m1, m2;

    int f = -1;

    while (l1 < h1 && l2 < h2) {
      m1 = (l1 + h1) /2;
      m2 = (l2 + h2) /2;

      System.out.println(l1 + " " + h1);
      System.out.println(l2 + " " + h2);

      if (arr1[m1] == arr2[m2]) {
        f = arr1[m1];
        break;
      } else if (arr1[m1] < arr2[m2]) {
        l1 = m1;
        h2 = m2;
      } else {
        h1 = m1;
        l2 = m2;
      }

      System.out.println(l1 + " " + h1);
      System.out.println(l2 + " " + h2);
    }
    System.out.println(f);

  }
}
