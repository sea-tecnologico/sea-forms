package cr.co.sea.seaforms.Controller.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.telerik.widget.dataform.engine.DataFormMetadata;
import com.telerik.widget.dataform.visualization.DataFormGroupLayoutManager;
import com.telerik.widget.dataform.visualization.RadDataForm;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

import cr.co.sea.seaforms.Model.Cliente;
import cr.co.sea.seaforms.R;

/**
 * Created by asanchezo on 14/10/2016.
 */

public class ClienteFormFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /*Creando el form dinamicamente con TELERIC*/
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_cliente_form,container,false);
        /*Esta sección despliega el formulario con telerik formado desde la clase*/
        /****************/
        RadDataForm form = new RadDataForm(this.getActivity().getBaseContext());
        form.setEntity(new Cliente());
        form.setLayoutManager(new DataFormGroupLayoutManager(this.getActivity().getBaseContext()));
        rootView.addView(form);

        /****************/

        // The files person_extended.json and person_schema.json are
// in the res/raw folder of the project
       /* RadDataForm form = new RadDataForm(this.getActivity().getBaseContext());
        String json = loadJSONFromAsset(R.raw.person);

        try {
            JSONObject jsonObject = new JSONObject(json);
            form.setEntity(jsonObject);

            String schema = loadJSONFromAsset(R.raw.person);
            JSONObject jsonSchema = new JSONObject(schema);
            DataFormMetadata metadata = new DataFormMetadata(jsonSchema);
            form.setMetadata(metadata);
        } catch (JSONException e) {
            Log.e("json", "error parsing json", e);
        }
        rootView.addView(form);*/
        return  rootView;
    }
    private String loadJSONFromAsset(int asset) {
        String json;
        try {
            InputStream is = getResources().openRawResource(asset);
            Writer writer = new StringWriter();
            char[] buffer = new char[1024];
            try {
                Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                int n;
                while ((n = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, n);
                }
            } finally {
                is.close();
            }

            json = writer.toString();
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
