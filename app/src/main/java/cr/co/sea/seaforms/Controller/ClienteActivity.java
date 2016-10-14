package cr.co.sea.seaforms.Controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;

import com.telerik.widget.dataform.visualization.RadDataForm;

import cr.co.sea.seaforms.Model.Cliente;
import cr.co.sea.seaforms.R;

public class ClienteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);
        ViewGroup rootView = (ViewGroup) findViewById(R.id.activity_cliente);
        RadDataForm form = new RadDataForm(this.getBaseContext());
        form.setEntity(new Cliente());
        rootView.addView(form);
    }
}
