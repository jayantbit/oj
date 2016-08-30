import java.util.PriorityQueue;

public class Techgig_1 {

  public static int[] getJoinedPipes(int []input1,int input2)
  {
    PriorityQueue<Integer> queue=new PriorityQueue<Integer>();
    int i,j,k;
    for(i=0;i<input2;i++)
    {
      queue.add(input1[i]);
    }

    if(input2==1)
    {
      int arr[]={0};
      return arr;
    }

    int arr[]=new int[input2-1];
    j=0;
    while(queue.size()>1)
    {
      int ele1=queue.poll();
      int ele2=queue.poll();
      arr[j]=ele1+ele2;
      queue.add(ele1+ele2);
      j++;
    }
    return arr;
  }
  public static void main(String[] args) {

     int arr[]={4,1,1,1,1,6};
     int n=6;
     int arr2[]=getJoinedPipes(arr,n);
     int i;
    for(i=0;i<n-1;i++)
      System.out.println(arr2[i]);

  }
}
