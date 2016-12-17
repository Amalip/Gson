package amalip.gson.Controllers;

import android.os.AsyncTask;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

/**
 * Created by Amalip on 12/17/2016.
 */

public class CustomerController extends AsyncTask<Void ,Void, String> {

    @Override
    protected String doInBackground(Void... params) {
        //Creamos el objeto cliente
        HttpClient client = new DefaultHttpClient();
        //Creamos un contexto
        HttpContext localContext = new BasicHttpContext();
        HttpGet httpGet = new HttpGet("http://heraclioayalaalba.com/restserv/service1.svc/getcustomers");
        String texto = null;
        try{
            //Llamar al servicio REST
            HttpResponse response = client.execute(httpGet, localContext);
            //Creamos una entidad temporal para guardar el resultado
            HttpEntity entity = response.getEntity();
            //Convertimos en texto la entidad
            GetResults getResults = new GetResults();
            texto = getResults.getContenido(entity);
        }
        catch (Exception ex){
            return ex.getLocalizedMessage();
        }
        return texto;
    }

    public interface CustomerControllerListener {
        void onPostExecuteConcluded(String result);
    }

    public CustomerController.CustomerControllerListener mListener;

    @Override
    final protected void onPostExecute(String resultado) {
        if (mListener != null)
            mListener.onPostExecuteConcluded(resultado);
    }
}
