import java.awt.Color;
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
    }
    
    public void paint(Graphics g){
        super.paint(g);
        int larghezza = this.getWidth() / 3;
        int altezza = this.getHeight() / 9;
        int lato;

        if (larghezza > altezza){
                 lato = altezza;
        }else{
                lato = larghezza;
        }

        int xPartenza = (this.getWidth() - lato * 3) / 2;
        int yPartenza = (this.getHeight() -lato * 9) / 2;
    }
}
