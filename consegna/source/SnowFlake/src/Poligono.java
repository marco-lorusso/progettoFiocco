
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * Questa è la classe poligono che contenente la lista di punti crea dei poligoni.
 * @author Marco Lorusso
 * @version 04.10.2019 
 */
public class Poligono {

    /**
     * Lista di punti del poligono.
     */
    public List<Point> points = new ArrayList<>();
    
    /**
     * Classe snowflake.
     */
    private SnowFlake sf;
    
    /**
     * Booleano che controlla se il poligono corrente è chiuso o meno.
     */
    private boolean closed = false;

    /**
     * Costrutto che istanzia un poligono per il frame, e fa il repaint.
     * @param sf 
     */
    public Poligono(SnowFlake sf) {
        this.sf = sf;
        sf.repaint();
    }

    /**
     * Paint che disegna ogni punto e il poligono quando viene chiuso.
     * @param g 
     */
    public void paint(Graphics g) {
        if (points.size() > 0) {
            int[] xPoints = new int[points.size()];
            int[] yPoints = new int[points.size()];
            for (int i = 0; i < points.size(); i++) {
                xPoints[i] = points.get(i).x;
                yPoints[i] = points.get(i).y;
            }
            g.setColor(Color.RED);
            if (isClosed()) {
                g.setColor(new Color(102,204,255));
                g.fillPolygon(xPoints, yPoints, points.size());
            } else {
                for (int i = 0; i < points.size(); i++) {
                    g.fillOval(points.get(i).x - 4, points.get(i).y - 4, 8, 8);
                    g.drawPolygon(xPoints, yPoints, points.size());
                }
            }
        }
    }

    /**
     * Metodo che controlla se un poligono è chiuso.
     * @return 
     */
    public boolean isClosed() {
        return closed;
    }

    /**
     * Metodo che aggiunge in punti e nel momento in cui si clicca ad una 
     * distanza di 8 pixel dal primo punto il poligono si chiude.
     * @param point 
     */
    public void addPoint(Point point) {
        if (points.isEmpty()) {
            points.add(point);
        } else {
            if (points.get(0).distance(point) < 8) {
                closed = true;
            } else {
                points.add(point);
                closed = false;
            }
        }
        sf.repaint();
    }

    /**
     * Metodo che quando si clicca il tasto destro su un determinato punto si 
     * cancella.
     * @param point 
     */
    public void removePoint(Point point) {
        if (!points.isEmpty()) {
            for (int i = 0; i < points.size(); i++) {
                if (points.get(i).distance(point) < 8) {
                    points.remove(points.get(i));
                }
            }
        }
        sf.repaint();
    }

    /**
     * Metodo che muove il punto che si vuole, trascinandolo.
     * @param point 
     */
    public void movePoint(Point point) {
        int xp = point.x;
        int yp = point.y;
        if (!points.isEmpty()) {
            for (int i = 0; i < points.size(); i++) {
                if (points.get(i).distance(point) < 4) {
                    points.get(i).x = xp;
                    points.get(i).y = yp;
                }
            }
        }
        sf.repaint();
    }

    /**
     * Metodo che serve ad aggiungere ad uno stringBuilder le coordinate dei
     * punti da salvare.
     * @return 
     */
    public StringBuilder printPoint() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.points.size(); i++) {
            sb = sb.append(this.points.get(i).x).append(",").append(this.points.get(i).y).append("\n");
        }
        return sb;
    }
}
