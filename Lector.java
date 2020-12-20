package codigo;

import javax.swing.JLabel;

public class Lector extends Thread {

    private Libro libro;
    private boolean seguirLeyendo = true;
    private int cantPalabrasLeidas = 0;

    private JLabel luzImg, numTxt;

    public Lector(Libro libro, JLabel luzImg, JLabel numTxt) {
        this.libro = libro;
        this.luzImg = luzImg;
        this.numTxt = numTxt;
    }

    @Override
    public void run() {

        Utilidades.labelSetImg(luzImg, ImgNombres.SEMAFORO_ROJO);

        while (true) {
            seguirLeyendo = libro.leer(this, luzImg, numTxt);
            if (!seguirLeyendo) {
                break;
            }

        }

        Utilidades.labelSetImg(luzImg, ImgNombres.SEMAFORO_GRIS);
    }

    public int getPalabrasLeidas() {
        return cantPalabrasLeidas;
    }

    public int incrementarPalabrasLeidas() {
        return ++cantPalabrasLeidas;
    }
}
