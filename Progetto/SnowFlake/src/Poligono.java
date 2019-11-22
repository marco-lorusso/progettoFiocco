
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
public class Poligono implements MouseListener
{
    private List<Point> punti = new ArrayList<>();
    private SnowFlake sf;
    boolean chiuso = false;
    
    public Poligono(SnowFlake sf){
        this.sf = sf;
        sf.repaint();
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {   
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
        if(punti.size() > 0){
            int[] xPunti = new int[punti.size()];
            int[] yPunti = new int[punti.size()];
            for(int i = 0; i < punti.size(); i++){
                    xPunti[i] = punti.get(i).x + 4;
                    yPunti[i] = punti.get(i).y + 4;
            }
            g.setColor(Color.RED);
            if(isClosed()){
                g.setColor(Color.BLUE);
                g.fillPolygon(xPunti, yPunti, punti.size()); 
            }else{
                for(int i = 0; i < punti.size(); i++){
                    g.fillOval(punti.get(i).x, punti.get(i).y, 8,8);
                    if(i >= 1){
                        g.drawLine(punti.get(i - 1).x + 4, punti.get(i - 1).y + 4, punti.get(i).x + 4, punti.get(i).y + 4);
                    }
                }
            }
        }
    }
    public boolean isClosed(){
        return chiuso;
    }
    
    public void addPoint(Point point){
        if(punti.isEmpty()){
            punti.add(point);
        }else{
            if(punti.get(0).distance(point) < 8){
                chiuso = true;
            }else{
                punti.add(point);
                chiuso = false;
            }
        }  
        sf.repaint();
    }
    
    public void removePoint(Point point){
        if(!punti.isEmpty()){
            for(int i = 0; i < punti.size(); i++){
                if(punti.get(i).distance(point) < 8){
                    punti.remove(punti.get(i));
                }
            }
        }  
        sf.repaint();
    }
    
    public void movePoint(Point point){
        int xp = point.x;
        int yp = point.y;
        if(!punti.isEmpty()){
            for(int i = 0; i < punti.size(); i++){
                if(punti.get(i).distance(point) < 10){
                    punti.get(i).x = xp; 
                    punti.get(i).y = yp;
                }
            }
        }  
        sf.repaint();
    }
    
    public StringBuilder printPoint(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < this.punti.size(); i++){
            sb = sb.append(this.punti.get(i).x).append(",").append(this.punti.get(i).y).append("\n");
        }
        return sb;
    }
}