import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SegTree {

  List<Long> list;

  long min[];
  long delta[];

  int len=-1;

  SegTree(List<Long> list)
  {
    this.list= list;
    len=list.size();

    min=new long[4*len+1];
    delta= new long[4*len+1];

    Arrays.fill(delta,0);

    init(0,0,len-1);
  }

  void update(int node)
  {
    min[node]=Math.min(min[2*node+1]+delta[2*node+1],min[2*node+2]+delta[2*node+2]);
  }

  public void init(int node, int left,int right)
  {
    if(left==right)
    {
      min[node]=list.get(left);
      return;
    }

    int mid= (left+right)/2;

    init(2*node+1,left,mid);
    init(2*node+2,mid+1,right);

    update(node);
  }

  public void propogate(int node)
  {
    delta[2*node+1] += delta[node];
    delta[2*node+2] += delta[node];
    delta[node]=0;
  }

  public void update(int node,int left,int right,int qleft ,int qright,int value)
  {
    if(left>=qleft && right<=qright)
    {
      delta[node]+=value;
      return;
    }

    if(qright<left ||  qleft>right)return;

    propogate(node);

    int mid=(left+right)/2;

    update(2*node+1,left,mid,qleft,qright,value);
    update(2*node+2,mid+1,right,qleft,qright,value);

    update(node);
    }


    public void updateHelper(int left,int right,int val)
    {
      update(0,0,len-1,left,right,val);
    }

  public long getMin(int node,int left,int right,int qleft,int qright)
  {
     if(qright<left ||  qleft>right) return Integer.MAX_VALUE;

     if(left>=qleft && right<=qright) return min[node]+delta[node];

     int mid= (left+right)/2;

     propogate(node);

     long leftMin= getMin(2*node+1,left,mid,qleft,qright);
     long rightMin=getMin(2*node+2,mid+1,right,qleft,qright);

     update(node);

     return Math.min(leftMin,rightMin);
  }




  public long getMinHelper(int left,int right)
  {
    return  getMin(0,0,len-1,left,right);
  }

  public long getMinCircular(int left,int right)
  {
    if(left<=right)
      return getMinHelper(left,right);

    else {
      long a= getMinHelper(left,len-1);
      long b= getMinHelper(0,right);
      return Math.min(a,b);
    }
  }

  public void updateCircular(int left,int right,int val)
  {
    if(left<=right)
      updateHelper(left,right,val);
    else
    {
      updateHelper(left,len-1,val);
      updateHelper(0,right,val);
    }
  }


  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine()), i, m;

    List<Long> list = new ArrayList<>();

    String input[] = br.readLine().split(" ");
    for (i = 0; i < n; i++) {
      long num = Integer.parseInt(input[i]);
      list.add(num);
    }

    SegTree segTree = new SegTree(list);

    OutputStream out = new BufferedOutputStream( System.out );



    {
      m = Integer.parseInt(br.readLine());

      for (i = 0; i < m; i++) {
        String s = br.readLine();

        String arr[] = s.split(" ");

        if (arr.length == 2) {
          long ans=segTree.getMinCircular(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));

          out.write((ans+"\n").getBytes());
        } else {
          segTree.updateCircular(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
        }
      }

    }
    out.flush();
  }

}
