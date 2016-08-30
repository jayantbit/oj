/**
 * Created by jayant.mukherji on 12/07/16.
 Heap sort
 */
public class HeapSort {

  static int arr[] = {100, 7, 6, 3, 4, 2, 1};
  static int len;

  static void swap(int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }

  static void makeHeap(int n) {
    int l = 2 * n + 1, r = 2 * n + 2;
    int lv = -1, rv = -1;
    if (l < len) lv = arr[l];
    if (r < len) rv = arr[r];

    if (lv > rv && lv > arr[n]) {
      swap(n, l);
      makeHeap(l);
    }
    else if(rv>lv && rv>arr[n])
    {
      swap(n,r);
      makeHeap(r);
    }
  }

  public static void main(String[] args) {

    int i,j,k;
    len=arr.length;
    for(i=len-1;i>=0;i--)
      makeHeap(i);

    int l=len;
    len--;
    while(len>0)
    {
      swap(len, 0);
      len--;
      makeHeap(0);
    }

    for(i=0;i<l;i++)
      System.out.print(arr[i]+" ");
    System.out.println();
  }
}
