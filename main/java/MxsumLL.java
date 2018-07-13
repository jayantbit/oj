/**
 * Created by jayant.mukherji on 12/07/16.
 */

/*
 1->3->30->90->120->240->511
 0->3->12->32->90->125->240->249


*/
public class MxsumLL {


  static LNode mxsum(LNode a, LNode b) {
    int sum1 = 0, sum2 = 0;
    LNode pre1 = a, pre2 = b;
    LNode cur1 = a, cur2 = b;
    LNode result = null;
    LNode rTail = null;

    do {

      if (cur1 == null && cur2 == null) break;

      if (cur1 == null) {
        if (rTail != null)
          rTail.next = cur2;
        break;
      } else if (cur2 == null) {
        if (rTail != null)
          rTail.next = cur1;
        break;
      }

      while (cur1 != null && cur2 != null && cur1.data != cur2.data) {
        if (cur1.data < cur2.data) {
          sum1 += cur1.data;
          //System.out.println(cur1.data);
          cur1 = cur1.next;
        } else {
          sum2 += cur2.data;
          //System.out.println(cur2.data);
          cur2 = cur2.next;
        }
      }

      if (cur1 == null) {
        while (cur2 != null) {
          sum2 += cur2.data;
          cur2 = cur2.next;
        }
      }

      if (cur2 == null) {
        while (cur1 != null) {
          sum1 += cur1.data;
          cur1 = cur1.next;
        }
      }


      if (result == null) {
        if (sum1 > sum2) {
          result = pre1;
          rTail = cur1;
        } else {
          result = pre2;
          rTail = cur2;
        }
      } else {
        if (sum1 > sum2) {
          rTail.next = pre1;
          rTail = cur1;
        } else {
          rTail.next = pre2;
          rTail = cur2;
        }
      }


      if (cur1 != null)
        cur1 = cur1.next;

      if (cur2 != null)
        cur2 = cur2.next;

      pre1 = cur1;
      pre2 = cur2;

      sum1 = sum2 = 0;
    } while (true);
    return result;
  }


  public static void main(String[] args) {
    LL l1 = new LL();
    LL l2 = new LL();
    /*
    1->3->30->90->120->240->511
    0->3->12->32->90->125->240->249
     */

    int arr[] = {1, 3, 30, 90, 120, 240, 511, 512, 513, 600}, i, j, k;
    int arr2[] = {0, 3, 12, 32, 90, 125, 240, 249, 250, 513, 700};

    for (i = arr.length - 1; i >= 0; i--)
      l1.add(arr[i]);

    for (i = arr2.length - 1; i >= 0; i--)
      l2.add(arr2[i]);

    l1.print();
    l2.print();

    LNode node = mxsum(l1.head, l2.head);

    while (node != null) {
      System.out.println(node.data + " ");
      node = node.next;
    }
  }
}
