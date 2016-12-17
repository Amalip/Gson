package amalip.gson.Controllers;

import org.apache.http.HttpEntity;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Amalip on 12/17/2016.
 */

public class GetResults {
    public String getContenido(HttpEntity pEntidad)
            throws IllegalStateException, IOException
    {
        InputStream in =pEntidad.getContent();
        StringBuffer out = new StringBuffer();
        int n = 1;
        while (n > 0)
        {
            byte[] b = new byte[4096];
            n = in.read(b);
            if(n>0) out.append(new String(b,0,n));
        }
        return out.toString();
    }
}
