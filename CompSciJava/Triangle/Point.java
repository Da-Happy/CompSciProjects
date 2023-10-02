public class Point
{
    /**
     * Constructor for objects of class Point
     */
    private int x;
    private int y;

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public String toString()
    {
        return("(" +x+", "+y+")");
    }
    public Point sub(Point minus)
    {
        return new Point(this.x-minus.getX(),this.y-minus.getY());
    }

}
