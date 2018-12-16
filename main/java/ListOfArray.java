import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListOfArray {


  public static int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> dq = new ArrayDeque<>();

        int i,j,len=nums.length;

        int  ans[]= new int[len-k+1];
        int pos=0;

        for(i=0;i<len;i++)
        {
            while(!dq.isEmpty() &&  nums[i] >nums[dq.peekLast()])
            {

            int num=dq.removeLast();
            System.out.println(" Pop index" +num);
            }

            dq.offerLast(i);

            if(i>= k-1)
            {
                ans[pos++]=nums[dq.peekFirst()];
            }

            if(!dq.isEmpty() && i>=k-1 &&  dq.peekFirst()==i)
                dq.removeFirst();


        }

        return ans;
    }

    static class State
     {
         int x1,y1;
         int x2,y2;
         int diamonds;

       public State(int x1, int y1, int x2, int y2, int diamonds) {
         this.x1 = x1;
         this.y1 = y1;
         this.x2 = x2;
         this.y2 = y2;
         this.diamonds = diamonds;
       }
     }


  public static void main(String[] args) {

  int arr[]={1,3,-1,-3,5,3,6,7};

    System.out.println("zz".compareTo("zzzaa"));

    Stack<Integer> st= new Stack<>();
    List<Integer> list = new ArrayList<>();
    Queue<Integer> queue = new LinkedList<>();

    //maxSlidingWindow(arr,3);

  }
}
