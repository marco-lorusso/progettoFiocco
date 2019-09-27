import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;


/**
 *
 * @author Marco Lorusso
 * @version 4.10.2019
 * Progetto  Fiocco di neve, applicativo che dato un triangolo "di carta", 
 * tramite dei tagli consecutivi possa generare un fiocco di neve.
 */
public class SnowFlake extends JFrame{
    public SnowFlake(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1024, 768);
        Dimension dimensione = new Dimension(1024, 768);
        this.setMinimumSize(dimensione);
    }
    
    public void paint(Graphics g){
        super.paint(g);
        double larghezza = this.getWidth();
        double altezza = this.getHeight() / Math.sqrt(3);
        double lato;


        if (larghezza > altezza){
                 lato = altezza;
        }else{
                lato = larghezza;
        }

        double xPartenza = (this.getWidth() - lato ) / 2;
        double yPartenza = (this.getHeight()-lato * Math.sqrt(3)) / 2;
        int[] xPoints = {
            
        };
        g.setColor(Color.BLUE);
        g.fillRect(0,0,getWidth(),getHeight());
        g.setColor(Color.WHITE);
        //prova
        g.drawLine((int)xPartenza, (int)yPartenza, (int)xPartenza + (int)lato, (int)yPartenza + (int)lato);
        //g.fillPolygon(xPoints, yPoints, WIDTH);
        
        
    }
    
    	public static void main(String[] args) {
            SnowFlake sf = new SnowFlake("SnowFlake");
            sf.setVisible(true);
	}
}
