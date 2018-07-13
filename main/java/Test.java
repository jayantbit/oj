package oj;

import java.util.Scanner;

/**
 * Created by jayant.mukherji on 12/06/16. SLIDING window RMQ
 * https://www.codechef.com/JUNE16/problems/CHSQARR
 */
class Test {

  static int arr[] = new int[1001];

  static int rmq[] = new int[1001];


  static void init(int node, int l, int r) {
    if (l == r) {
      rmq[node] = arr[l];
      return;
    }

    init(2 * node + 1, l, (l + r) / 2);
    init(2 * node + 2, (l + r) / 2 + 1, r);

    rmq[node] = Math.max(rmq[2 * node + 1], rmq[2 * node + 2]);
  }

  //query for (s,e)
  static int query(int node, int l, int r, int s, int e) {
    if (s > r || e < l) return -1;

    if (l >= s && r <= e)
      return rmq[node];

    int p1 = query(2 * node + 1, l, (l + r) / 2, s, e);
    int p2 = query(2 * node + 2, (l + r) / 2 + 1, r, s, e);

    if (p1 != -1 && p2 != -1)
      return Math.max(p1, p2);

    if (p1 != -1) return p1;
    else return p2;
  }

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
   int i,n;

    n = in.nextInt();

    System.out.println(n);

    for (i = 0; i < n; i++) {
      arr[i] = in.nextInt();
    }

    for(i=0;i<n;i++)
      System.out.println(arr[i]);

    init(0, 0, n - 1);
    System.out.println(rmq[0]);

    int pos = query(0, 0, n - 1, 0, n - 1);
    System.out.println(pos);

  }
}

