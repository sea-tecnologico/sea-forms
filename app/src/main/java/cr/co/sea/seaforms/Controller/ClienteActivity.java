package cr.co.sea.seaforms.Controller;

import android.os.Bundle;
import android.app.Activity;
import android.text.Layout;

import com.telerik.widget.dataform.visualization.RadDataForm;

import cr.co.sea.seaforms.Model.Cliente;
import cr.co.sea.seaforms.R;

public class ClienteActivity extends Activity {
    private Layout mlayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Layout mainLayout = (Layout) findViewById(R.id.activity_cliente);
        //addView(form);
        RadDataForm form = new RadDataForm(this.getBaseContext());
        form.setEntity(new Cliente());
        setContentView(R.layout.activity_cliente);

    }

}
