
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JFileChooser;
import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2DIOException;
import org.w3c.dom.Document;
import org.w3c.dom.DOMImplementation;

/**
 * Progetto Fiocco di neve, applicativo che dato un triangolo "di carta", 
 * tramite dei tagli consecutivi possa generare un fiocco di neve, questa è
 * la classe principale dove si gestisce il mouse ecc.
 * @author Marco Lorusso
 * @version 4.10.2019 
 */
public class SnowFlake extends JPanel implements MouseListener, MouseMotionListener {

    /**
     * Lista di poligoni, contiene tutti i poligoni del frame.
     */
    public static List<Poligono> pol = new ArrayList<>();

    /**
     * Cateto del triangolo, rispetto all'orizzontale.
     */
    private int triangleWidth;

    /**
     * Cateto del triangolo, rispetto alla verticale.
     */
    private int triangleHeight;

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

    /**
     * Costante per la posizione di dove e come chiamare il file per salvare
     * i punti.
     */
    private static final Path PATH = Paths.get("./pointsFlake.csv");

    /**
     * Tempo che ci mette a salvare i punti.
     */
    private long time;

    /**
     * File corrente da caricare.
     */
    private File currentFile = null;
    
    /**
     * File contente lo screen del frame, in formato svg.
     */
    private File svgFile = new File("./SnowFlakeScreen.svg");

 
    /**
     * Costruttore che aggiunge un poligono iniziale e aggiungere i listener
     * dei mouse.
     */
    public SnowFlake() {
        super();
        this.pol.add(new Poligono(this));
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    /**
     * Paint che fa un responsive del triangolo in base alle proporzioni, lo
     * disegna e fa un repaint di tutti i poligoni.
     * @param g 
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        triangleHeight = getHeight() / 2;
        triangleWidth = (int) (triangleHeight / Math.sqrt(3));
        Ax = (getWidth() - triangleWidth) / 2;
        Ay = (getHeight() - triangleHeight) / 2;
        Bx = Ax + triangleWidth;
        By = Ay;
        Cx = Bx;
        Cy = Ay + triangleHeight;
        int[] xPoints = {Ax, Bx, Cx};
        int[] yPoints = {Ay, By, Cy};
        g.setColor(Color.WHITE);
        g.fillPolygon(xPoints, yPoints, 3);
        for (int i = 0; i < this.pol.size(); i++) {
            this.pol.get(i).paint(g);
        }
    }

    /**
     * Mouse clicked, quando viene cliccato un punto sul frame, se è chiuso
     * aggiunge un poligono, se no aggiunge o rimuove un punto.
     * @param e 
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (pol.get(pol.size() - 1).isClosed()) {
            pol.add(new Poligono(this));
        } else {
            if (e.getButton() == MouseEvent.BUTTON1) {
                pol.get(pol.size() - 1).addPoint(e.getPoint());
            } else if (e.getButton() == MouseEvent.BUTTON3) {
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

    /**
     * Metodo che serve a salvare i punti in un file csv, stampa a terminale
     * il tempo che ci mette.
     */
    public void savePoint() {
        time = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        try {
            for (int i = 0; i < this.pol.size(); i++) {
                sb = sb.append(this.pol.get(i).printPoint());
                sb = sb.append("\n");
            }
            String finalPoint = sb.toString();
            Files.write(PATH, finalPoint.getBytes());
            System.out.println("POINT SAVED ("
                    + (System.currentTimeMillis() - time) + "ms)");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /**
     * Metodo che serve a caricare i punti sul frame, grazie al file chooser
     * si può scegliere un file csv da aprire per poi caricare i punti sul
     * triangolo.
     * @throws IOException 
     */
    public void uploadPoint() throws IOException {
        JFileChooser chooser = new JFileChooser();
        SnowFrame sf = new SnowFrame();
        int returnVal = chooser.showOpenDialog(sf);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            currentFile = chooser.getSelectedFile();
        } else {
            currentFile = null;
            return;
        }

        if (currentFile != null) {
            List<String> pointFile = Files.readAllLines(currentFile.toPath());
            String[] data = {"", ""};
            this.pol.get(pol.size() - 1).points.clear();
            pol.add(new Poligono(this));
            for (String punts : pointFile) {
                if (!punts.isEmpty()) {
                    data = punts.split(",");
                    this.pol.get(pol.size() - 1).addPoint(new Point(Integer.parseInt(data[0]), Integer.parseInt(data[1])));
                } else {
                    pol.add(new Poligono(this));
                }
            }
        }
        this.repaint();
    }

    /**
     * Quando viene trascinato il mouse controlla che l'ultimo poligono non 
     * sia chiuso e richiama il metodo movePoint.
     * @param e 
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        if (!pol.get(pol.size() - 1).isClosed()) {
            pol.get(pol.size() - 1).movePoint(e.getPoint());
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
    
    /**
     * Metodo che serve a salvare questo panel col triangolo in formato svg,
     * cliccando il bottone save svg.
     */
    public void saveSvg(){
        DOMImplementation dom = GenericDOMImplementation.getDOMImplementation();
        String svgPath = "http://www.w3.org/2000/svg";
        Document doc = dom.createDocument(svgPath, "svg", null);
        SVGGraphics2D svg2D = new SVGGraphics2D(doc);
        this.paintComponent(svg2D);
        try {
            svg2D.stream(this.svgFile.toPath().toString());
        } catch (SVGGraphics2DIOException e) {

        }
    }
}
