import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Code {






  public static void main(String[] args) throws Exception {

    String list1[]= {"()()()()","(()())()","(()(()))","()()(())","(((())))","(())()()","()((()))","()(())()","()(()())","(()()())","((()()))","((()))()","((())())"};

    String list2[]={"(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"};


    Map<String,Integer> map = new HashMap<>();


    for(String item1: list1)
    if(!map.containsKey(item1))
      map.put(item1,1);
    else map.put(item1,map.get(item1)+1);






    

    for(String item1: list2)
    {

      boolean flag=false;
      for(String item2: list1)
      {
        if(item2.equals(item1))
        { flag=true; break;}
      }

      if (!flag) {
        System.out.println(item1);
      }
    }

    System.out.println(map);
    }
}