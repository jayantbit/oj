import java.util.Scanner;
import java.util.Stack;

/**
  Created by jayant.mukherji on 04/07/16.
  Tree construction
  inorder iterative
 */



public class BST {
  TNode root = null;

  void insert(int d) {
    root = insert(root, d);
  }

  TNode insert(TNode root, int d) {
    if (root == null) {
      return new TNode(d);
    }
    if (d <= root.data)
      root.left = insert(root.left, d);
    else root.right = insert(root.right, d);
    return root;
  }

  void inorder(TNode root) {
    if (root == null) return;
    inorder(root.left);
    System.out.print(root.data + " ");
    inorder(root.right);
  }

}

class Driver {
  static BST bst = new BST();

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    while (in.hasNext()) {
      int t = in.nextInt();
      if (t == -1) break;
      bst.insert(t);
    }
    bst.inorder(bst.root);
    System.out.println();

    Stack<TNode> st = new Stack<>();
    TNode root = bst.root;

    do {

      do {
        st.push(root);
        root = root.left;
      } while (root != null);

      while (!st.empty()) {
        TNode top = st.pop();
        System.out.print(top.data + " ");
        if (top.right != null) {
          root = top.right;
          break;
        }
      }
    }while(root!=null);


  }


}



