
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marco Lorusso
 * @version 04.10.2019
 * Questa classe produrrà i punti per fare il taglio nel frame del triangolo.
 */
public class Polygon implements MouseListener
{
    private List<Point> points = new ArrayList<>();
    private SnowFlake sf;
    
    public Polygon(SnowFlake sf){
        sf.repaint();
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {   
        points.add(e.getPoint());
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    public void paint(Graphics g){
        if(points.size() > 0){
            g.setColor(Color.RED);
            for(int i = 0; i < points.size(); i++){
                g.fillOval(points.get(i).x, points.get(i).y, 5,5);
            }
        }
    }
}
