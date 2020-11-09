package Clases;

public class Credito {
    // Declaración de datos.

    private int cHipotecario;
    private int cAutomotriz;

    // Constructor

    public Credito() {
        cHipotecario = 1000000;
        cAutomotriz = 500000;
    }

    // Accesadores
    public int getHipotecario() {
        return cHipotecario;
    }

    public int getAutomotriz() {
        return cAutomotriz;
    }

}
