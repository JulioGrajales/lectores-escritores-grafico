package codigo;

import javax.swing.JLabel;

public class Escritor extends Thread {

    private Libro libro;
    private boolean seguirEscribiendo = true;
    private JLabel luzImg, numTxt;

    public Escritor(Libro libro, JLabel luzImg, JLabel numTxt) {

        this.libro = libro;
        this.luzImg = luzImg;
        this.numTxt = numTxt;

    }

    @Override
    public void run() {

        Utilidades.labelSetImg(luzImg, ImgNombres.SEMAFORO_ROJO);
        while (true) {
            seguirEscribiendo = libro.escribir(luzImg, numTxt);
            if (!seguirEscribiendo) {
                break;
            }
        }

        Utilidades.labelSetImg(luzImg, ImgNombres.SEMAFORO_GRIS);
    }

}
