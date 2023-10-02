import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
 
public class DrawTriangleApp extends JPanel {
    Triangle triangle;
    
    public DrawTriangleApp(Triangle t) {
    setBackground(Color.lightGray);
    triangle = t;
  }
    public void paint(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    g2d.setPaint(Color.red);
    g2d.draw(new Line2D.Double(triangle.getLineSegmentP1P2().getP1().getX(),triangle.getLineSegmentP1P2().getP1().getY(),
                                triangle.getLineSegmentP1P2().getP2().getX(),triangle.getLineSegmentP1P2().getP2().getY() ));
  g2d.draw(new Line2D.Double(triangle.getLineSegmentP2P3().getP1().getX(),triangle.getLineSegmentP2P3().getP1().getY(),
                                triangle.getLineSegmentP2P3().getP2().getX(),triangle.getLineSegmentP2P3().getP2().getY() ));
  g2d.draw(new Line2D.Double(triangle.getLineSegmentP3P1().getP1().getX(),triangle.getLineSegmentP3P1().getP1().getY(),
                                triangle.getLineSegmentP3P1().getP2().getX(),triangle.getLineSegmentP3P1().getP2().getY() ));
    }
    public static void main(String s[]) {
    JFrame frame = new JFrame("Show Triangle");
    //////////////////
    Triangle t = new Triangle(new Point(1010,1010),new Point(10,10),new Point(10,1010));//This line of code will have to be edited
    //////////////////
    JPanel panel = new DrawTriangleApp(t);

    frame.getContentPane().add("Center", panel);
    frame.setSize(1100, 1100);
    frame.setVisible(true);
    System.out.println(t.toString());
  }
}