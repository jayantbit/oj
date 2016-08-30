package test;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.Set;

/**
 * Created by jayant.mukherji on 27/08/16.
 */

class Node
{
  int val;
  Node left,right;
}

class Element
{
  Node node;
  int dis;
  int lev;
  Element(Node node,int dis,int lev)
  {
    node=node;
    dis=dis;
    lev=lev;
  }
}


public class Light {

  static HashMap<Integer,Set<Element>> vmap= new HashMap<>();
  static HashMap<Integer,Set<Element>> hmap= new HashMap<>();

  int bfs(Node root,int dis)
  {
    Queue<Element> q= new ArrayDeque<>();
    q.add(new Element(root,0,0));

    while(!q.isEmpty())
    {
      Element temp=q.peek();q.remove();

      vmap.get(temp.dis).add(temp);
      hmap.get(temp.lev).add(temp);



      q.add(new Element(temp.node.left,dis-1,temp.lev+1));
      q.add(new Element(temp.node.right,dis+1,temp.lev+1));
    }
    return 0;
  }



  public static void main(String[] args) {

    for(Integer vlev : vmap.keySet())
    {
      for (Element ele: vmap.get(vlev) )
      {
        int hlev=ele.lev;
        Set<Element> elements=hmap.get(hlev);

        int pos=0;
        for(Element ele2 : elements)
        {
          if(ele2==ele)break;
          pos++;
        }
        if(pos!=0 || pos!=elements.size()-1)
        {
          System.out.println(ele.node.val);
        }
      }
    }


  }
}
