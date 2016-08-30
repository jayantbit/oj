import java.util.Scanner;

/**
 * Created by jayant.mukherji on 30/08/16.
 */
public class RMQ {

  static int arr[] = new int[1001];

  static int rmq[] = new int[1001];


  static void init(int node, int l, int r) {
    if (l == r) {
      rmq[node] = l;
      return;
    }

    init(2 * node + 1, l, (l + r) / 2);
    init(2 * node + 2, (l + r) / 2 + 1, r);

    if(arr[rmq[2 * node + 1]]>arr[rmq[2 * node + 2]])
      rmq[node]=rmq[2 * node + 1];
    else rmq[node]=rmq[2 * node + 2];

  }

  //query for (s,e)
  static int query(int node, int l, int r, int s, int e) {
    if (s > r || e < l) return -1;

    if (l >= s && r <= e)
      return rmq[node];

    int p1 = query(2 * node + 1, l, (l + r) / 2, s, e);
    int p2 = query(2 * node + 2, (l + r) / 2 + 1, r, s, e);

    if (p1 != -1 && p2 != -1)
    {
      if(arr[p1]>arr[p2])return p1;
      return p2;
    }

    if (p1 != -1) return p1;
    else return p2;
  }

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    int i,n;

    n = in.nextInt();

    for (i = 0; i < n; i++) {
      arr[i] = in.nextInt();
    }

    init(0, 0, n - 1);


    int pos = query(0, 0, n - 1, 0, n - 1);
    System.out.println(pos);

  }
}
