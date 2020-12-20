package codigo;

import java.awt.Color;
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class Utilidades {

    private static final ImageIcon lectoresImgSource = new ImageIcon(Interfaz.class.getResource("/codigo/img/lector.png"));
    private static final ImageIcon escritoresImgSource = new ImageIcon(Interfaz.class.getResource("/codigo/img/escritor.png"));
    private static final ImageIcon luzVerdeImgSource = new ImageIcon(Interfaz.class.getResource("/codigo/img/verde.png"));
    private static final ImageIcon luzRojaImgSource = new ImageIcon(Interfaz.class.getResource("/codigo/img/rojo.png"));
    private static final ImageIcon luzGrisImgSource = new ImageIcon(Interfaz.class.getResource("/codigo/img/gris.png"));

    public static void labelSetTexto(JLabel label, String txt) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                label.setText(txt);
                label.paintImmediately(label.getVisibleRect());
            }

        });

        //label.setText(txt);
        //label.paintImmediately(label.getVisibleRect());
    }

    public static void labelSetImg(JLabel label, ImgNombres imgNombre) {
        switch (imgNombre) {
            case ESCRITOR:
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        ImageIcon escritoresImgResized = new ImageIcon(escritoresImgSource.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
                        label.setIcon(escritoresImgResized);
                    }

                });
                //ImageIcon escritoresImgResized = new ImageIcon(escritoresImgSource.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
                //label.setIcon(escritoresImgResized);
                break;
            case LECTOR:
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        ImageIcon lectoresImgResized = new ImageIcon(lectoresImgSource.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
                        label.setIcon(lectoresImgResized);
                    }

                });

                //ImageIcon lectoresImgResized = new ImageIcon(lectoresImgSource.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
                //label.setIcon(lectoresImgResized);
                break;
            case SEMAFORO_VERDE:

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        ImageIcon luzVerdeImgResized = new ImageIcon(luzVerdeImgSource.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
                        label.setIcon(luzVerdeImgResized);
                    }

                });

                //ImageIcon luzVerdeImgResized = new ImageIcon(luzVerdeImgSource.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
                //label.setIcon(luzVerdeImgResized);
                break;
            case SEMAFORO_GRIS:

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        ImageIcon luzGrisImgResized = new ImageIcon(luzGrisImgSource.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
                        label.setIcon(luzGrisImgResized);
                    }

                });

                //ImageIcon luzGrisImgResized = new ImageIcon(luzGrisImgSource.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
                //label.setIcon(luzGrisImgResized);
                break;
            case SEMAFORO_ROJO:

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        ImageIcon luzRojaImgResized = new ImageIcon(luzRojaImgSource.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
                        label.setIcon(luzRojaImgResized);
                    }

                });

                //ImageIcon luzRojaImgResized = new ImageIcon(luzRojaImgSource.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
                //label.setIcon(luzRojaImgResized);
                break;
        }
    }

    public static void labelSetImgFast(JLabel label, ImgNombres imgNombre) {
        switch (imgNombre) {
            case ESCRITOR:
                ImageIcon escritoresImgResized = new ImageIcon(escritoresImgSource.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
                label.setIcon(escritoresImgResized);
                break;
            case LECTOR:
                ImageIcon lectoresImgResized = new ImageIcon(lectoresImgSource.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
                label.setIcon(lectoresImgResized);
                break;
            case SEMAFORO_VERDE:
                ImageIcon luzVerdeImgResized = new ImageIcon(luzVerdeImgSource.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
                label.setIcon(luzVerdeImgResized);
                break;
            case SEMAFORO_GRIS:
                ImageIcon luzGrisImgResized = new ImageIcon(luzGrisImgSource.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
                label.setIcon(luzGrisImgResized);
                break;
            case SEMAFORO_ROJO:
                ImageIcon luzRojaImgResized = new ImageIcon(luzRojaImgSource.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
                label.setIcon(luzRojaImgResized);
                break;
        }
    }

    public static void labelSetTextoFast(JLabel label, String txt) {

        label.setText(txt);
        label.paintImmediately(label.getVisibleRect());
    }

    public static void paneSetTexto(JTextPane pane, String txt) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                pane.setText(pane.getText() + txt);
            }

        });
    }

    public static void setColorParrafo(JTextPane libro, Color color, int pos) {

        SimpleAttributeSet set = new SimpleAttributeSet();
        StyleConstants.setBackground(set, color);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                libro.getStyledDocument().setCharacterAttributes(0, pos, set, true);
            }

        });
    }

    public static int numeroAleatorio(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }
}
