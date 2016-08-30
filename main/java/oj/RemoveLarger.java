/**
 * Created by jayant.mukherji on 26/07/16.
 */


public class RemoveLarger {

  /*
  1 4 2 3 3 3 2 1 2
  4 3 3 3 2 2
  2 1 2
  5 4 3 2 4 2 0 1 2
  remove nodes which have
  larger nodes on right side
  */


  static int mx = 0;

  static LNode fn(LNode curr) {
    if (curr.next == null) {
      mx = curr.data;
      return curr;
    }
    LNode next = fn(curr.next);
    if (mx > curr.data) {
      return next;
    } else {
      mx = curr.data;
      curr.next = next;
      return curr;
    }
  }

  public static void main(String[] args) {

    LL list = new LL();
    int arr[] = {5, 4, 3, 2, 4, 2, 0, 1, 2};
    int i;
    for (i = arr.length - 1; i >= 0; i--)
      list.add(arr[i]);

    LNode ans = fn(list.head);
    while (ans != null) {
      System.out.print(ans.data + " ");
      ans = ans.next;
    }
    System.out.println();
  }
}
