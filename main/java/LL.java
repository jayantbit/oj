import java.util.Scanner;

/**
 * Created by jayant.mukherji on 06/07/16.
 */
class LNode
{
  int data;
  LNode next;
  LNode(int data)
  {
    this.data=data;
    next=null;
  }
}
class LL {
 LNode head=null;

 public void add(int data)
 {
   LNode temp= new LNode(data);
   if(head==null)head=temp;
   else
   {
     temp.next=head;
     head=temp;
   }
 }

  public void print()
  {
    LNode temp =head;
    while(temp!=null)
    {
      System.out.print(temp.data+" ");
      temp=temp.next;
    }
    System.out.println();
  }

  public void rev()
  {
    LNode prev=null,curr=head,next;
    while(curr!=null)
    {
      next=curr.next;
      curr.next=prev;
      prev=curr;
      curr=next;
    }
    head=prev;
  }

  public LNode rev(LNode node)
  {
    if(node==null)return node;
    if(node.next==null)
    {
      head=node;
      return node;
    }
    LNode next=rev(node.next);
    node.next=null;
    next.next=node;
    return node;
  }
}

class LLDriver
{
  public static void main(String[] args) {
    LL list = new LL();
    Scanner in = new Scanner(System.in);
    while(in.hasNext())
    {
      int k=in.nextInt();
      if(k==-1)break;
      list.add(k);
    }
    list.print();

    list.rev();
    list.print();

    list.rev(list.head);
    list.print();
  }

}


