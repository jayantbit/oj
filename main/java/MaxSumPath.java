import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by jayant.mukherji on 27/07/16.
 */


/*
Max sum path in tree
*/

public class MaxSumPath {
  static int ans = Integer.MIN_VALUE;

  static int max4(int a, int b, int c, int d) {
    return Integer.max(Integer.max(a, b), Integer.max(c, d));
  }

  static int mxsum(TNode root) {
    if (root == null) return 0;
    int l = mxsum(root.left);
    int r = mxsum(root.right);
    int a1 = Integer.max(l, r);
    int a2 = root.data + Integer.max(a1, 0);
    int a3 = root.data + l + r;
    ans = max4(ans, a1, a2, a3);
    return a2;
  }

  public static void main(String[] args) {
    BST bst = new BST();

    Deque<Integer> dq= new ArrayDeque<>();


    bst.insert(3);
    bst.insert(2);
    bst.insert(-1);
    bst.insert(11);
    bst.insert(10);
    mxsum(bst.root);
    System.out.println(ans);
  }
}
