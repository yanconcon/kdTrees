import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;

import java.util.Iterator;

/**
 * Created by 聪聪 on 2017/12/26 0026.
 *
 *
 public         PointSET()                               // construct an empty set of points
 public           boolean isEmpty()                      // is the set empty?
 public               int size()                         // number of points in the set
 public              void insert(Point2D p)              // add the point to the set (if it is not already in the set)
 public           boolean contains(Point2D p)            // does the set contain point p?
 public              void draw()                         // draw all points to standard draw
 public Iterable<Point2D> range(RectHV rect)             // all points that are inside the rectangle (or on the boundary)
 public           Point2D nearest(Point2D p)             // a nearest neighbor in the set to point p; null if the set is empty

 public static void main(String[] args)                  // unit testing of the methods (optional)
 */
public class PointSET {
    private SET<Point2D> pointsSet;

    public PointSET() {
        pointsSet = new SET<>();

    }
    public boolean isEmpty() {
        return pointsSet.size() == 0;
    }
    public int size() {
        return pointsSet.size();
    }
    public void insert(Point2D point2D) {
        if (point2D == null) throw new IllegalArgumentException("输入为空");
        pointsSet.add(point2D);
    }
    public boolean contains(Point2D p) {
        if (p == null) throw new IllegalArgumentException("contains输入为空");
        return pointsSet.contains(p);
    }
    public void draw() {
        for (Point2D p :
             pointsSet) {
            p.draw();
        }
    }
    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) throw new IllegalArgumentException("输入为空");
        return new MyRange(rect);
    }

    private class MyRange implements Iterable<Point2D> {
        private SET set;
        public MyRange(RectHV rect) {
            for (Point2D p :
                    pointsSet) {
                if (rect.contains(p)) {
                    set.add(p);
                }
            }
        }

        @Override
        public Iterator<Point2D> iterator() {
            return set.iterator();
        }
    }

    public  Point2D nearest(Point2D p) {
        if (p == null) throw new IllegalArgumentException("输入为空");
        Point2D nearP = null;
        double distance = Double.MAX_VALUE;
        for (Point2D p1 :
                pointsSet) {
            if (p1.distanceSquaredTo(p) < distance)
                distance = p1.distanceSquaredTo(p);
                nearP = p1;
        }
        return nearP;
    }

}
