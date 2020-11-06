package Clases;

public interface IComunicacion {
    void toggleProgressBar(boolean status); //visible o invisible progress
    void lanzarActividad(Class<?> tipoActividad);
    void showMessage(String msg);

}
