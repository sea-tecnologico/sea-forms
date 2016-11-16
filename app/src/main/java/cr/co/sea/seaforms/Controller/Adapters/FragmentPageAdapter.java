package cr.co.sea.seaforms.Controller.Adapters;


import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.v13.app.FragmentPagerAdapter;

import cr.co.sea.seaforms.Controller.Fragments.AnexosFormFragment;
import cr.co.sea.seaforms.Controller.Fragments.DatosPersonalesFormFragment;
import cr.co.sea.seaforms.Controller.Fragments.DireccionFormFragment;
import cr.co.sea.seaforms.Controller.Fragments.GenericosFormFragment;
import cr.co.sea.seaforms.Controller.Fragments.MetodosPagoFormFragment;
import cr.co.sea.seaforms.Controller.ePestanas;


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
    private Context context;
    private  int pageCount = 5;
    public FragmentPageAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;

    }

    @Override
    public Fragment getItem(int position) {
        ePestanas pestanas = ePestanas.values()[position]; // Para usar enum,
        switch (pestanas){

            case DATOS_PERSONALES:
                return new DatosPersonalesFormFragment();
            case DIRECCION:
                return new DireccionFormFragment();
            case METODOS_PAGO:
                return new MetodosPagoFormFragment();
            case ANEXOS:
                return new AnexosFormFragment();
            case DATOS_GENERICOS:
                return new GenericosFormFragment();
            default:
                return new DatosPersonalesFormFragment();

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
