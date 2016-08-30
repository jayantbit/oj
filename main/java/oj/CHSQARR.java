import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * Created by jayant.mukherji on 12/06/16. SLIDING window RMQ
 * https://www.codechef.com/JUNE16/problems/CHSQARR
 */
class CHSQARR {

  static int arr[][] = new int[1001][1001];
  static long sum[][] = new long[1001][1001];
  static int rmq[][][] = new int[1001][1001][10];
  static int temp[]= new int[1001];
  static int n, m;
  static Deque<Integer> dq = new ArrayDeque<>();


//  static void init(int i, int node, int l, int r) {
//    if (l == r) {
//      rmq[i][node] = arr[i][l];
//      return;
//    }
//
//    init(i, 2 * node + 1, l, (l + r) / 2);
//    init(i, 2 * node + 2, (l + r) / 2 + 1, r);
//
//    rmq[i][node] = Math.max(rmq[i][2 * node + 1], rmq[i][2 * node + 2]);
//  }
//
//  //query for (s,e)
//  static int query(int i, int node, int l, int r, int s, int e) {
//    if (s > r || e < l) return -1;
//
//    if (l >= s && r <= e)
//      return rmq[i][node];
//
//    int p1 = query(i, 2 * node + 1, l, (l + r) / 2, s, e);
//    int p2 = query(i, 2 * node + 2, (l + r) / 2 + 1, r, s, e);
//
//    if (p1 != -1 && p2 != -1)
//      return Math.max(p1, p2);
//
//    if (p1 != -1) return p1;
//    else return p2;
//  }

  static void calc() {
    int i, j;
    for (i = 0; i < n; i++)
      for (j = 0; j < m; j++) {
        sum[i][j] = arr[i][j];
        if (j != 0) sum[i][j] += sum[i][j - 1];
      }

    for (i = 0; i < n; i++)
      for (j = 0; j < m; j++) {
        if (i != 0) sum[i][j] += sum[i-1][j];
      }
  }

  static long val(int a, int b, int c, int d) {
    long ans = sum[c][d];
    if (b > 0) ans -= sum[c][b - 1];
    if (a > 0) ans -= sum[a - 1][d];

    if (a > 0 && b > 0) ans += sum[a - 1][b - 1];
    return ans;
  }


  static void process(int r, int N)
  {
    int i, j;

    //initialize M for the intervals with length 1
    for (i = 0; i < N; i++)
      rmq[r][i][0] = i;
    //compute values from smaller to bigger intervals
    for (j = 1; 1 << j <= N; j++)
      for (i = 0; i + (1 << j) - 1 < N; i++)
        if (arr[r][rmq[r][i][j - 1]] > arr[r][rmq[r][i + (1 << (j - 1))][j - 1]])
          rmq[r][i][j] = rmq[r][i][j - 1];
        else
          rmq[r][i][j] = rmq[r][i + (1 << (j - 1))][j - 1];
  }
  static int log2[]= new int[1005];
  static int pow2[] = new int[30];
  static long rem[][] = new long[1001][1001];
  static double lg=Math.log(2);

  static void fn()
  {

    int i,j;
    for(i=1;i<=1001;i++)
      log2[i]=(int) (Math.log(i)/lg);

    pow2[0]=1;
    for(i=1;i<30;i++)
      pow2[i]=2*pow2[i-1];

    for(i=1;i<=n;i++)
      for(j=1;j<=m;j++)
        rem[i][j]=-1;
  }

  static int query(int r,int i,int j)
  {
    int diff=j-i+1;
    int k=log2[diff];
    int t=pow2[k];

    int a=arr[r][rmq[r][i][k]];
    int b=arr[r][rmq[r][j-t+1][k]];
    if(a>b)
    return a;
    return  b;

  }


  public static void main(String[] args) throws IOException{
    Scanner in = new Scanner(System.in);
    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    int i, j, k,q;


    String str[]=br.readLine().split(" ");
    n=Integer.parseInt(str[0]);
    m=Integer.parseInt(str[1]);

    PrintWriter ps = new PrintWriter(System.out);



    for (i = 0; i < n; i++) {
      str=br.readLine().split(" ");
      for (j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(str[j]);

      }
    }
     fn();
    calc();

    for (i = 0; i < n; i++)
      process(i, m);

    //System.out.println("processed");
    q=Integer.parseInt(br.readLine().split(" ")[0]);

    while(q-->0)
    {
      int a,b;
      str=br.readLine().split(" ");
      a=Integer.parseInt(str[0]);
      b=Integer.parseInt(str[1]);
        if(rem[a][b]!=-1)
        {
          ps.println(rem[a][b]);
          continue;
        }
      long ans=Long.MAX_VALUE;

      for(j=0;j<=m-b;j++) {


        dq.clear();

        int window = a;
        for (i = 0; i < n; i++) {
          temp[i]=   query(i,j,j+b-1);


          if (i >= window) {

            while (!dq.isEmpty() && dq.getFirst() < i - window + 1) {
              dq.removeFirst();
            }
          }

          while (!dq.isEmpty() && temp[dq.getLast()] <= temp[i])
            dq.removeLast();

          dq.addLast(i);

        if(i>=window-1) {
          //calc here
          long maxEle=temp[dq.getFirst()];
          long total=val(i-window+1,j,i,j+b-1);
          long diff= maxEle*a*b -total;
          if(diff<ans)
          ans=diff;
        }
        }

      }
      //rem[a][b]=ans;
      ps.println(ans);
    }


  ps.close();
  }
}
