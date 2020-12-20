package codigo;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class Libro {

    private final int MAX_PALABRAS = 50;
    private int cantPalabrasActual = 0;
    private final int tiempoEscrituraLectura = 500;
    private JTextPane txtLibro;
    private JLabel libroTotalPalabras;

    public Libro(JTextPane txtLibro, JLabel libroTotalPalabras) {
        this.txtLibro = txtLibro;
        this.libroTotalPalabras = libroTotalPalabras;
    }

    public synchronized boolean escribir(JLabel luzImg, JLabel numTxt) {
        notifyAll();

        if (cantPalabrasActual == MAX_PALABRAS) {
            return false;
        }

        Utilidades.labelSetImg(luzImg, ImgNombres.SEMAFORO_VERDE);

        int cantPalabrasNuevas = Utilidades.numeroAleatorio(1, 10);

        if (cantPalabrasNuevas + cantPalabrasActual > MAX_PALABRAS) {
            cantPalabrasNuevas = MAX_PALABRAS - cantPalabrasActual;
        }
        int mostrarNum = cantPalabrasNuevas;

        Utilidades.setColorParrafo(txtLibro, Color.WHITE, cantPalabrasActual);

        for (int i = 0; i < cantPalabrasNuevas; i++) {

            try {
                Thread.sleep(tiempoEscrituraLectura);
            } catch (InterruptedException ex) {
            }

            Utilidades.paneSetTexto(txtLibro, Character.toString((char) Utilidades.numeroAleatorio(97, 122)));

            Utilidades.labelSetTexto(numTxt, Integer.toString(--mostrarNum));
            Utilidades.labelSetTexto(libroTotalPalabras, "Letras totales: " + (++cantPalabrasActual));
        }

        try {
            Thread.sleep(tiempoEscrituraLectura);
        } catch (InterruptedException ex) {
        }

        Utilidades.labelSetTexto(numTxt, "");
        Utilidades.labelSetImg(luzImg, ImgNombres.SEMAFORO_ROJO);

        try {
            wait();
        } catch (InterruptedException ex) {
        }
        return true;
    }

    public synchronized boolean leer(Lector lector, JLabel luzImg, JLabel numTxt) {
        if (lector.getPalabrasLeidas() == MAX_PALABRAS) {
            return false;
        }
        if (lector.getPalabrasLeidas() == cantPalabrasActual) {
            return true;
        }
        Utilidades.labelSetImg(luzImg, ImgNombres.SEMAFORO_VERDE);

        int palabrasRestantes = cantPalabrasActual - lector.getPalabrasLeidas();
        for (int i = 0; i < palabrasRestantes; i++) {
            try {
                Thread.sleep(tiempoEscrituraLectura);
            } catch (InterruptedException ex) {
            }

            Utilidades.labelSetTexto(numTxt, Integer.toString(lector.incrementarPalabrasLeidas()));
            Utilidades.setColorParrafo(txtLibro, Color.YELLOW, lector.getPalabrasLeidas());
        }

        try {
            Thread.sleep(tiempoEscrituraLectura);
        } catch (InterruptedException ex) {
        }

        Utilidades.setColorParrafo(txtLibro, Color.WHITE, cantPalabrasActual);
        Utilidades.labelSetImg(luzImg, ImgNombres.SEMAFORO_ROJO);
        return true;
    }
}
