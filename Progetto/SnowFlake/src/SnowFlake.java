
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author Marco Lorusso
 * @version 4.10.2019 Progetto Fiocco di neve, applicativo che dato un triangolo
 * "di carta", tramite dei tagli consecutivi possa generare un fiocco di neve.
 */
public class SnowFlake extends JFrame implements MouseListener {

    private List<Polygon> pol = new ArrayList<>();

    /**
     * Cateto del triangolo, rispetto all'orizzontale.
     */
    private int larghezza;

    /**
     * Cateto del triangolo, rispetto alla verticale.
     */
    private int altezza;

    /**
     * Punto x dell'angolo in alto a sinistra del triangolo.
     */
    private int Ax;

    /**
     * Punto y dell'angolo in alto a sinistra del triangolo.
     */
    private int Ay;

    /**
     * Punto x dell'angolo in alto a destra del triangolo.
     */
    private int Bx;

    /**
     * Punto y dell'angolo in alto a destra del triangolo.
     */
    private int By;

    /**
     * Punto x dell'angolo in basso a destra del triangolo.
     */
    private int Cx;

    /**
     * Punto y dell'angolo in basso a destra del triangolo.
     */
    private int Cy;

    public SnowFlake(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1024, 768);
        Dimension dimensione = new Dimension(1024, 768);
        this.setMinimumSize(dimensione);
        this.pol.add(new Polygon(this));
        this.addMouseListener(this.pol.get(0));
    }
    

    public void paint(Graphics g) {
        super.paint(g);

        /**
         * Non c'è il responsive quindi le posizioni del triangolo sono fisse.
         */
        altezza = 768 / 2;
        larghezza = (int) (altezza / Math.sqrt(3));

        /**
         * Ho tolto la larghezza alla grandezza della finestra e ho tolto i due
         * bordi dividendo.
         */
        Ax = (1024 - larghezza) / 2;

        /**
         * Ho fatto la stessa cosa per l'altezza.
         */
        Ay = (768 - altezza) / 2;

        /**
         * Per il punto x del punto B ho aggiunto la larghezza al punto Ax.
         */
        Bx = Ax + larghezza;

        /**
         * Il punto y del punto B è uguale al punto Ay, visto che sono alla
         * stessa orizzontale.
         */
        By = Ay;

        /**
         * Il punto Cx è uguale al punto Bx perchè sono sulla stessa verticale.
         */
        Cx = Bx;

        /**
         * Il punto y del punto C è uguale ad Ay più l'altezza.
         */
        Cy = Ay + altezza;

        /**
         * Array di punti x del triangolo.
         */
        int[] xPoints = {Ax, Bx, Cx};

        /**
         * Array di punti y del triangolo.
         */
        int[] yPoints = {Ay, By, Cy};
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.WHITE);

        /**
         * Disegna il triangolo.
         */
        g.fillPolygon(xPoints, yPoints, 3);
        for (int i = 0; i < this.pol.size(); i++) {
            this.pol.get(i).paint(g);
        }
    }

    public static void main(String[] args) {
        SnowFlake sf = new SnowFlake("SnowFlake");
        sf.setVisible(true);
        
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
}
