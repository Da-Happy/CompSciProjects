public class Triangle
{
    //instance data should be three LineSegment objects.
    private Point p1;
    private Point p2;
    private Point p3;

    public Triangle(Point p1, Point p2, Point p3)
    {
        // initialise instance variables
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        //construct the three LineSegment objects out of the 3 points provided.

    }
    public LineSegment getLineSegmentP1P2()
    {
        return new LineSegment(p1,p2);
    }
    public LineSegment getLineSegmentP2P3()
    {
        return new LineSegment(p2,p3);
    }
    public LineSegment getLineSegmentP3P1()
    {
        return new LineSegment(p3,p1);
    }

    public String toString()
    {
        return "Triangle: "+ "P1: " + p1 + " P2: " + p2 + " P3: " + p3+
                "\nLine Segment P1P2: "+getLineSegmentP1P2().toString()+
                "\nLine Segment P2P3: " + getLineSegmentP2P3() +
                "\nLine Segment P3P1: " + getLineSegmentP3P1() +
                "\nArea: " + area() +
                "\nPerimeter: " + perimeter();
    }

    public double perimeter()
    {
        Double perimeter = getLineSegmentP1P2().length()+ getLineSegmentP2P3().length() + getLineSegmentP3P1().length();
        return perimeter;
    }

    public double area()
    {
        double s = perimeter()/2;
        double a = getLineSegmentP1P2().length();
        double b = getLineSegmentP2P3().length();
        double c = getLineSegmentP3P1().length();
        double area = Math.sqrt(s * (s -a) * (s - b) * (s - c));
        return area;
    }
}