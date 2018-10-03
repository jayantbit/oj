import org.w3c.dom.css.Rect;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Code3 {

  static List<Rectangle> list = new ArrayList<>();
  static  long MOD =1000000007;


  static  class Rectangle implements Comparable<Rectangle>
    {
      int x1,y1;
      int x2,y2;

      public Rectangle(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
      }

      @Override
      public int compareTo(Rectangle o) {
        return x1-o.x1;
      }

      long getArea()
      {
        long lenx= x2-x1;
        long leny=y2-y1;

        long area=  (lenx*leny)%MOD;
        return area;
      }

      void print()
      {
        System.out.println(x1+" "+y1+" "+x2+" "+y2);
      }
    }


    static Rectangle overlap(Rectangle rect1,Rectangle rect2)
    {
      if(rect1.x1>rect2.x1)
      {
        Rectangle temp =rect1;
        rect1=rect2;
        rect2=temp;
      }

      if(rect2.x1>rect1.x2)return null;
      if( (rect2.y1 < rect1.y1 || rect2.y1>rect1.y2)  && (rect2.y2 < rect1.y1 || rect2.y2>rect1.y2))
        return null;

      int x1=rect2.x1;
      int x2= Math.min(rect1.x2,rect2.x2);

      int y1=Math.max(rect1.y1,rect2.y1);
      int y2=Math.min(rect1.y2,rect2.y2);

      return new Rectangle(x1,y1,x2,y2);
    }


    static Rectangle overlap(int i,int j)
    {
      Rectangle rect1 =list.get(i);
      Rectangle rect2= list.get(j);

     return  overlap(rect1,rect2);
    }

    static Rectangle overlap(int i,int j,int k)
    {
      Rectangle rect1=overlap(i,j);

      if(rect1!=null)
        return overlap(rect1,list.get(k));
      else return null;
    }


    public static int rectangleArea(int[][] rectangles) {



    for(int i=0;i<rectangles.length;i++)
      {
        list.add(new Rectangle(rectangles[i][0],rectangles[i][1],rectangles[i][2],rectangles[i][3]));
      }

      Collections.sort(list);

      int len=rectangles.length,i,j,k;
      long area=0;

      for(i=0;i<len;i++)
      {
        area= (area+list.get(i).getArea())%MOD;

        for(j=0;j<i;j++)
        {

          Rectangle overlap = overlap(i,j);

          if(overlap==null)continue;

          area= (area- overlap.getArea() +MOD)%MOD;

          for(k=0;k<i;k++)
            if(k!=j)
            {
               Rectangle overlap2=overlap(overlap,list.get(k));
               if(overlap2!=null)
               {
                 //if i j,k not visited yet
                 area= (area+overlap2.getArea())%MOD;
               }
            }
        }
      }

      area%=MOD;
      return (int)area;

    }

  public static void main(String[] args) {
     int rectangles[][]=   {{0,0,2,2},{1,0,2,3},{1,0,3,1}};


    System.out.println(rectangleArea(rectangles));
  }


}
