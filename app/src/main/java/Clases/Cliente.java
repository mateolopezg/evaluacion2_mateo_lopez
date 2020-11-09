package Clases;

public class Cliente {
// Declaración de datos.

    private String nombre;
    private int saldo;

    // Constructor

    public Cliente() {
        nombre = "";
        saldo = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSaldo() {
        return saldo;
    }

}
