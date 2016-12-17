package amalip.gson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.w3c.dom.Text;

import amalip.gson.Controllers.CustomerController;
import amalip.gson.Models.Customer;

public class MainActivity extends AppCompatActivity implements CustomerController.CustomerControllerListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomerController customerController = new CustomerController();
        customerController.mListener = this;
        customerController.execute();
    }

    @Override
    public void onPostExecuteConcluded(String result) {
        //Deserializa json usando Gson
        Gson gsonB = new GsonBuilder().create();
        //Creamos el objeto que vamos a utilizar donde se van a guardar los elementos
        Customer.CustomerHelper customer = gsonB.fromJson(result, Customer.CustomerHelper.class);
        System.out.println(customer.ListCustomer.elementAt(0).getFirstName());

        //Serializar un objeto usando Gson
        String json = gsonB.toJson(customer.ListCustomer.firstElement());
        String json1= gsonB.toJson(customer.ListCustomer);
        TextView _txv = (TextView) findViewById(R.id.txvRes);
        _txv.setText(json);
    }
}
