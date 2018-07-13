import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by jayant.mukherji on 26/07/16.
 */

class ListNode {
       public int val;
       public ListNode next;
       ListNode(int x) { val = x; next = null; }
   }

public class MergeKLists {
  public ListNode mergeKLists(ArrayList<ListNode> list) {

    int i,j,len=list.size();
    Comparator<ListNode> comparator = new Comparator<ListNode>()
    {
      @Override
      public int compare(ListNode a,ListNode b)
      {
        return a.val - b.val;
      }
    };

    PriorityQueue<ListNode> q =
            new PriorityQueue<ListNode>(len, comparator);


    for(i=0;i<len;i++)
      q.add(list.get(i));

    ListNode dummy = new ListNode(0);
    ListNode tail=dummy;

    while(!q.isEmpty())
    {
      ListNode min=q.poll();
      tail.next=min;
      tail=min;
      if(min.next!=null)q.add(min.next);
    }
    return dummy.next;
  }
}
