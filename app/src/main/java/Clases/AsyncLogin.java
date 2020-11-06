package Clases;

import android.os.AsyncTask;

import com.w.evaluacion2_mateo_lopez.Home_act;

public class AsyncLogin extends AsyncTask<Object, Void, Boolean> {

    private IComunicacion com;

    public AsyncLogin(IComunicacion com){ this.com = com; }

    /**
     * @deprecated
     */
    @Override
    protected void onPreExecute() {
        com.toggleProgressBar(true);
    }

    /**
     * @param objects
     * @deprecated
     */
    @Override
    protected Boolean doInBackground(Object[] objects) {
        try {
            Thread.sleep((int) objects[2]);
            String user = (String) objects[0];
            String pass = (String) objects[1];
            if (user.equalsIgnoreCase("android") && pass.equals("123")){
                return true;
            }else{
                return false;
            }
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }
        return false;
    }

    /**
     * @param aBoolean
     * @deprecated
     */
    @Override
    protected void onPostExecute(Boolean aBoolean) {
        if (aBoolean){
            this.com.lanzarActividad(Home_act.class);
            this.com.showMessage("Logeado correctamente");
            this.com.toggleProgressBar(false);
        }else{
            this.com.showMessage("Datos Incorrectos");
        }
    }
}
