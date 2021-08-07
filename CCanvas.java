import java.awt.*;

public class CCanvas extends Canvas
{
    boolean nowy=true;
    public int l;

    public CCanvas(int k) {
        setBackground (Color.LIGHT_GRAY);
        setSize(300, 300);
        l=k;
    }
    public void paint(Graphics g)
    {
        if(nowy==true) {
            g.setColor(Color.black);
            g.drawLine(100, 0, 100, 300);
            g.drawLine(200, 0, 200, 300);
            g.drawLine(0, 100, 300, 100);
            g.drawLine(0, 200, 300, 200);
        }
    }


}