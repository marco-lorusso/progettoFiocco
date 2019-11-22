import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/** 
 *
 * @author Marco Lorusso
 * @version 4.10.2019 
 * Progetto Fiocco di neve, applicativo che dato un triangolo
 * "di carta", tramite dei tagli consecutivi possa generare un fiocco di neve.
 */
public class SnowFlake extends JPanel implements MouseListener, MouseMotionListener {

    public static List<Poligono> pol = new ArrayList<>();

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

    private static final Path PATH = Paths.get("./puntiFlake.csv");
    
    private long time;
    
    public SnowFlake() {
        super();
        this.pol.add(new Poligono(this));
        this.addMouseListener(this.pol.get(0));
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }
    

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        /**
         * Non c'è il responsive quindi le posizioni del triangolo sono fisse.
         */
        altezza = getHeight() / 2;
        larghezza = (int) (altezza / Math.sqrt(3));

        /**
         * Ho tolto la larghezza alla grandezza della finestra e ho tolto i due
         * bordi dividendo.
         */
        Ax = (getWidth() - larghezza) / 2;

        /**
         * Ho fatto la stessa cosa per l'altezza.
         */
        Ay = (getHeight() - altezza) / 2;

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


    @Override
    public void mouseClicked(MouseEvent e) {
        if(pol.get(pol.size() - 1).isClosed()){
            pol.add(new Poligono(this));
            this.addMouseListener(this.pol.get(pol.size() - 1));
        }else{
            if(e.getButton() == MouseEvent.BUTTON1){
                pol.get(pol.size() - 1).addPoint(e.getPoint());
            }else if(e.getButton() == MouseEvent.BUTTON3){
                pol.get(pol.size() - 1).removePoint(e.getPoint());
            }
        }  
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
    
    public void savePoint(){
        time = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        try{
            for(int i = 0; i < this.pol.size(); i++){
                sb = sb.append(this.pol.get(i).printPoint());
                sb = sb.append("\n");
            }
            String puntiFinali = sb.toString();
            Files.write(PATH, puntiFinali.getBytes());
            System.out.println("POINT SAVED (" 
                    + (System.currentTimeMillis() - time) + "ms)");
        } catch (IOException e){
            System.out.println(e); 
        }
    }
    
    public void downloadPoint(){
        try{
            if(Files.exists(PATH)){
                if(Files.notExists(PATH)){
                    System.out.printf("Il file è sconosciuto");
                }else{
                    List<String> puntiPol = Files.readAllLines(PATH);
                    pol.add(new Poligono(this));
                    this.addMouseListener(this.pol.get(pol.size() - 1));
                    for(String line : puntiPol){
                        if(line.isEmpty()){
                            Point newPoint = new Point();
                            newPoint.setLocation(1,1);
                            pol.get(pol.size() - 1).addPoint(newPoint);
                        }else{
                            for(int i = 0; i < line.length(); i++){
                                
                            }
                        }
                    }
                }
            }
        }catch(IOException ex){
            System.out.println("Errore nella lettura del file!");
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(!pol.get(pol.size() - 1).isClosed()){
            pol.get(pol.size() - 1).movePoint(e.getPoint());
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {}
}
