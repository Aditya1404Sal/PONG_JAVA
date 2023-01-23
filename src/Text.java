import java.awt.*;

public class Text {
    public String text;
    public Font font;
    public double x,y;
    public double width,height;
    public Color color = Color.WHITE;

    public Text(String text, Font font , double x, double y,Color color){
        this.text = text;
        this.font = font;
        this.x = x;
        this.y = y;
        this.width = font.getSize()*text.length();
        this.height = font.getSize();
    }
    public Text(int text, Font font , double x, double y){
        this.text = "" + text;
        this.font = font;
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics2D g){
        g.setColor(color);
        g.setFont(font);
        g.drawString(text,(float)x,(float)y);

    }
}
