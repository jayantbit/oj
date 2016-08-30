/**
 * Created by jayant.mukherji on 19/07/16.
 */
public class Merge {


  public static LNode merge(LNode a, LNode b) {

    if (a == null) return b;
    if (b == null) return a;
    LNode newNode = null;
    if (a.data < b.data) {
      newNode = new LNode(a.data);
      newNode.next = merge(a.next, b);
    } else {
      newNode = new LNode(b.data);
      newNode.next = merge(a, b.next);
    }
    return newNode;
  }

  public static void main(String[] args) {

    LL l1 = new LL();

    l1.add(30);
    l1.add(20);
    l1.add(10);

    l1.print();

    LL l2 = new LL();

    l2.add(35);
    l2.add(25);
    l2.add(15);

    l2.print();

    LNode l3 = merge(l1.head, l2.head);

    LNode temp = l3;
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }


  }
}
