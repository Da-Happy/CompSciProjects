public class LineSegment
{
    /**
     * Constructor for objects of class LineSegment
     */
    private Point p1;
    private Point p2;
    public LineSegment(Point p1, Point p2)
    {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Point getP1()
    {
        return p1;
    }

    public Point getP2()
    {
        return p2;
    }

    public double length()
    {
        Point subbed = p2.sub(p1);
        double length = Math.sqrt(Math.pow(subbed.getX(), 2) + Math.pow(subbed.getY(), 2));
        return length;
    }
    public String toString()
    {
        return "("+p1+", "+p2+")";
    }
}
