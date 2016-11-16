package cr.co.sea.seaforms.Controller.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toolbar;

import cr.co.sea.seaforms.Controller.Adapters.FragmentPageAdapter;
import cr.co.sea.seaforms.Controller.TabLayoutUtils;
import cr.co.sea.seaforms.R;

/**
 * Created by asanchezo on 25/10/2016.
 */

public class TabFormActivity extends AppCompatActivity{
    Toolbar toolbar;
    TabLayout tabLayout;
    boolean mPaginEnabled = false;
    int tabActual;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_form);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setActionBar(toolbar);
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(new FragmentPageAdapter(getFragmentManager(),this));
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
        TabLayoutUtils.enableTabs( tabLayout, false );


    }
}
