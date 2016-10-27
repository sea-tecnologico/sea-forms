package cr.co.sea.seaforms.Controller.Adapters;


import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.v13.app.FragmentPagerAdapter;
import android.widget.Switch;

import cr.co.sea.seaforms.Controller.Fragments.ClienteFormFragment;
import cr.co.sea.seaforms.Controller.Fragments.CustomFormFragment;

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
    private String[] tabTitle = new String[]{"Datos Personales","Datos Genericos"};
    Context context;
    private  int pageCount = 2;
    public FragmentPageAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;

    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                ClienteFormFragment clienteFormFragment= new ClienteFormFragment();
                return clienteFormFragment;
            case 1:
                CustomFormFragment customFormFragment= new CustomFormFragment();
                return customFormFragment;
            default:
                ClienteFormFragment clienteFormFragmentDefault= new ClienteFormFragment();
                return clienteFormFragmentDefault;

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
