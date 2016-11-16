package cr.co.sea.seaforms.Controller.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cr.co.sea.seaforms.R;

/**
 * Created by asanchezo on 14/10/2016.
 */

public class  ClienteFormFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /*Creando el form dinamicamente con TELERIC*/
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_cliente_form,container,false);
        /*Esta sección despliega el formulario con telerik formado desde la clase*/
        /****************/
        //RadDataForm form = new RadDataForm(this.getActivity().getBaseContext());
        /*form.setEntity(new Cliente());
        form.setLayoutManager(new DataFormGroupLayoutManager(this.getActivity().getBaseContext()));
        rootView.addView(form);*/
        return  rootView;
    }

}
