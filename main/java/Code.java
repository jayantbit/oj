
import java.util.ArrayList;
import java.util.HashMap;


import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;


public class Code {


  //0   5   10
  //0 1

  Map<Integer, Segment> startIndexMap = new HashMap<>();
  Map<Integer, Segment> endIndexMap = new HashMap<>();

  static class Segment {
    public int start;
    public int end;
    boolean startOccupied;
    boolean endOccupied;


    public Segment(int start, int end) {
      this.start = start;
      this.end = end;
      startOccupied = endOccupied = false;
    }

    public int getMid() {
      return (start + end) / 2;
    }
  }

  Queue<Segment> queue;


  int n;

  public Code(int N) {
    queue = new PriorityQueue<Segment>((Segment a, Segment b) ->
    {
      int len1 = a.end - a.start;
      int len2 = b.end - b.start;
      if (len1 != len2) {
        return len2 - len1;
      } else return (a.getMid() - b.getMid());

    });

    this.n = N;
  }

  private void add(Segment segment) {
    startIndexMap.put(segment.start, segment);
    endIndexMap.put(segment.end, segment);

    queue.offer(segment);
  }

  private void remove(Segment segment) {
    startIndexMap.remove(segment.start);
    endIndexMap.remove(segment.end);

    queue.remove(segment);
  }

  public int seat() {


    if (queue.isEmpty()) {

      Segment segment = new Segment(0, n - 1);
      segment.startOccupied = true;
      add(segment);
      return 0;
    } else {
      Segment segment = queue.poll();

      if (segment.endOccupied == false) {
        segment.endOccupied = true;
        queue.offer(segment);
        return segment.end;
      } else if (segment.startOccupied == false) {
        segment.startOccupied = true;
        queue.offer(segment);
        return segment.start;
      } else {
        //placing in mid
        remove(segment);

        if (segment.end != segment.start) {

          Segment newSeg1 = new Segment(segment.start, segment.getMid());

          Segment newSeg2 = new Segment(segment.getMid() + 1, segment.end);

          add(newSeg1);
          add(newSeg2);
        }
        return segment.getMid();
      }


    }
  }


    public void leave( int p){

      if (endIndexMap.containsKey(p)) {
        Segment segment = endIndexMap.get(p);

        Segment nextSegment = startIndexMap.get(p + 1);

        Segment newSegment = new Segment(segment.start, nextSegment.end);

        remove(segment);
        add(newSegment);
      } else if (startIndexMap.containsKey(p)) {
        Segment segment = startIndexMap.get(p);

        Segment prevSegment = endIndexMap.get(p - 1);

        Segment newSegment = new Segment(prevSegment.start, segment.end);

        remove(segment);
        add(newSegment);
      }
    }
  }

