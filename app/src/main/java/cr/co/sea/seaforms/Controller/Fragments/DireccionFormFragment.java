package cr.co.sea.seaforms.Controller.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.telerik.widget.dataform.engine.DataFormMetadata;
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
import java.util.HashMap;
import java.util.Iterator;

import cr.co.sea.seaforms.R;

import static cr.co.sea.seaforms.Controller.ePestanas.METODOS_PAGO;
import static cr.co.sea.seaforms.Model.Contrato.getContratoSingleton;

/**
 * Created by asanchezo on 10/11/2016.
 */

public class DireccionFormFragment extends Fragment {
    Button guardar;
    RadDataForm form;
    TabLayout tabhost;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {
          /*Creando el form dinamicamente con TELERIC leyendo archivo json*/
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_custom_form, container, false);
        form = new RadDataForm(this.getActivity());
        tabhost = (TabLayout) getActivity().findViewById(R.id.tab_layout);
        // form = (RadDataForm) rootView.findViewById(R.id.RadDataFormCustomForm);
        Button guardar = new Button(this.getActivity());
        guardar.setText("Guardar sección");
        String json = loadJSONFromAsset(R.raw.direccion_extended);

        try {
            JSONObject jsonObject = new JSONObject(json);
            form.setEntity(jsonObject);

            String schema = loadJSONFromAsset(R.raw.direccion_schema);
            JSONObject jsonSchema = new JSONObject(schema);
            DataFormMetadata metadata = new DataFormMetadata(jsonSchema);
            form.setMetadata(metadata);
        } catch (JSONException e) {
            Log.e("json", "error parsing json", e);
        }

        /*obtiene los campos del formulario desde el archivo json*/

        rootView.addView(form, 1050, 1400);
        rootView.addView(guardar);

        // btnSiguiente=(Button)rootView.findViewById (R.id.btn_customForm);
        guardar.setOnClickListener(new View.OnClickListener() {
            String bandera = "";
            String campos = "";

            @Override
            public void onClick(View v) {
                String json = form.getEntity().getSourceObject().toString();
                try {
                    HashMap<String, Object> map = getHashMapFromJson(json);
                    getContratoSingleton().setProvincia(String.valueOf(map.get("Provincia")));
                    getContratoSingleton().setCanton(String.valueOf(map.get("Canton")));
                    getContratoSingleton().setDistrito(String.valueOf(map.get("Distrito")));
                    getContratoSingleton().setDireccion(String.valueOf(map.get("Direccion")));
                    getContratoSingleton().setOtrasSenas(String.valueOf(map.get("OtrasSenas")));
                    tabhost.getTabAt(METODOS_PAGO.getValue()).select(); // Avanza al siguiente formulario
                } catch (JSONException e) {
                    Log.e("JsonTelerik", "Failed parsing " + json, e);
                }

            }
        });
        return rootView;
    }

    private HashMap<String, Object> getHashMapFromJson(String json) throws JSONException {
        HashMap<String, Object> map = new HashMap<String, Object>();
        JSONObject jsonObject = new JSONObject(json);
        for (Iterator<String> it = jsonObject.keys(); it.hasNext(); ) {
            String key = it.next();
            map.put(key, jsonObject.get(key));
        }
        return map;
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
