/**
 * Created by jayant.mukherji on 13/07/16. 1 3 5 3 1
 check pallindrome for linklist
 1 3 5
 1 2 3 4 5

 1 2 3 4 5 6

 1 2 3 6 5 4
 1 6 2 5 4 3


 1 5 2 4 3
 */

public class CheckPallinLL {


  static LNode mid;
  static int cnt;

  static void setMid(LNode head) {
    cnt = 0;
    mid = head;
    while (head != null && head.next != null) {
      cnt += 2;
      mid = mid.next;
      head = head.next.next;
    }
    if (head != null) cnt++;
    if(cnt%2==1 && cnt!=1)mid=mid.next;
  }

  static boolean check(LNode head, int k) {
    if (k >= cnt / 2) return true;
    if (!check(head.next, k + 1)) return false;
    if (head.data != mid.data) return false;
    mid = mid.next;
    return true;
  }

  public static void main(String[] args) {
    LL list = new LL();
    list.add(1);
    list.add(3);
    list.add(5);
    list.add(3);
    list.add(1);
    setMid(list.head);
    System.out.println(cnt);
    System.out.println(mid.data);
    System.out.println(check(list.head,0));
  }
}
