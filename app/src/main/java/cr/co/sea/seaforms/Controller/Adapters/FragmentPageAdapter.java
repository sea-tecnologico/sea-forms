package cr.co.sea.seaforms.Controller.Adapters;


import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.v13.app.FragmentPagerAdapter;

import cr.co.sea.seaforms.Controller.Fragments.AnexosFormFragment;
import cr.co.sea.seaforms.Controller.Fragments.ClienteFormFragment;
import cr.co.sea.seaforms.Controller.Fragments.DatosPersonalesFormFragment;
import cr.co.sea.seaforms.Controller.Fragments.DireccionFormFragment;
import cr.co.sea.seaforms.Controller.Fragments.MetodosPagoFormFragment;

/**
 * Created by asanchezo on 25/10/2016.
 */
/*
* Adapter: An Adapter object acts as a bridge between an AdapterView and the underlying data for that view.
 * The Adapter provides access to the data items.
 * The Adapter is als
 * o responsible for making a View for each item in the data set.
* */
public class FragmentPageAdapter extends FragmentPagerAdapter {
    private String[] tabTitle = new String[]{"Datos Personales","Dirección","Métodos de pago","Anexos","Datos Genericos"};
    Context context;
    private  int pageCount = 5;
    public FragmentPageAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;

    }

    @Override
    public Fragment getItem(int position) {
        switch (position){

            case 0:
                DatosPersonalesFormFragment datosPersonalesFormFragment= new DatosPersonalesFormFragment();
                return datosPersonalesFormFragment;
            case 1:
                DireccionFormFragment direccionFormFragment= new DireccionFormFragment();
                return direccionFormFragment;
            case 2:
                MetodosPagoFormFragment metodosPagoFormFragment= new MetodosPagoFormFragment();
                return metodosPagoFormFragment;

            case 3:
                AnexosFormFragment anexosFormFragment= new AnexosFormFragment();
                return anexosFormFragment;

            case 4:
                ClienteFormFragment clienteFormFragmentDefault= new ClienteFormFragment();
                return clienteFormFragmentDefault;
            default:
                DatosPersonalesFormFragment datosPersonalesFormFragment_default= new DatosPersonalesFormFragment();
                return datosPersonalesFormFragment_default ;

        }

    }

    @Override
    public int getCount() {

        return pageCount;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return tabTitle[position];
    }
}
