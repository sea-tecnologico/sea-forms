package cr.co.sea.seaforms.Controller.Fragments;

import android.app.Fragment;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.List;

import cr.co.sea.seaforms.DAO.ContratoDao;
import cr.co.sea.seaforms.DAO.DaoMaster;
import cr.co.sea.seaforms.DAO.DaoSession;
import cr.co.sea.seaforms.Model.Contrato;
import cr.co.sea.seaforms.R;
import de.greenrobot.dao.query.QueryBuilder;

/**
 * Created by asanchezo on 14/10/2016.
 */

public class SelectFormFragment extends Fragment {
    private Spinner spinner_formularios;
    private ImageView iVFoto;
    public DaoMaster.DevOpenHelper helper;
    public DaoMaster daoMaster;
    public DaoSession daoSession;
    public ContratoDao contratoDao;
    private static String sql_contratos = "SELECT  " + ContratoDao.Properties.Foto1 + " FROM " + ContratoDao.TABLENAME + " ORDER BY 1 ASC";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_selecciona_form, container, false);
        iVFoto = (ImageView) rootView.findViewById(R.id.iVFoto);
        helper = new DaoMaster.DevOpenHelper(rootView.getContext(), "eForms_db", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
        contratoDao = daoSession.getContratoDao();
        List contratoList = listContratos();
        ArrayAdapter<String> adapter2;
        adapter2 = new ArrayAdapter<String>(rootView.getContext(), android.R.layout.simple_list_item_1, contratoList);
        spinner_formularios = (Spinner) rootView.findViewById(R.id.spinnerFormulario);
        spinner_formularios.setAdapter(adapter2);
        Contrato contrato = new Contrato();
        contrato = (Contrato) contratoList.get(0);
        //byte[] data = contrato.getConFoto1().getBytes();
        Bitmap bmp = BitmapFactory.decodeByteArray(contrato.getFoto1(), 0, contrato.getFoto1().length);
        iVFoto.setImageBitmap(bmp);
        return rootView;
    }

    public List<Contrato> listContratos() {
        QueryBuilder qb = contratoDao.queryBuilder();
        qb.where(ContratoDao.Properties.Id.eq(1));
        List query = qb.list();
        return query;
    }

}
