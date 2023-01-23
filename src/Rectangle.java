import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Rectangle {
    public double x, y, Height_Rect, Width_Rect;
    public Color color;

    public Rectangle(double x, double y, double Height_Rect, double Width_Rect, Color color) {
        this.x = x;
        this.y = y;
        this.Height_Rect = Height_Rect;
        this.Width_Rect = Width_Rect;
        this.color = color;
    }

    public void Draw(Graphics2D g2) {
        g2.setColor(color);
        g2.fill(new Rectangle2D.Double(x, y, Width_Rect, Height_Rect));
    }
}
