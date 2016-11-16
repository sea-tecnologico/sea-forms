package cr.co.sea.seaforms.Controller.Fragments;

import android.app.Fragment;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

import cr.co.sea.seaforms.DAO.ContratoDao;
import cr.co.sea.seaforms.DAO.DaoMaster;
import cr.co.sea.seaforms.DAO.DaoSession;
import cr.co.sea.seaforms.R;

import static android.app.Activity.RESULT_OK;
import static cr.co.sea.seaforms.Model.Contrato.getContratoSingleton;

/**
 * Created by asanchezo on 18/10/2016.
 */

public class AnexosFormFragment extends Fragment {
    ImageView foto1;
    ImageView foto2;
    ImageView foto3;
    ImageView foto4;
    ImageView ivGuargar;
    int numFoto = 0;
    public DaoMaster.DevOpenHelper helper;
    public SQLiteDatabase db;
    public DaoMaster daoMaster;
    public DaoSession daoSession;
    public ContratoDao contratoDao;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_fotos,container,false);
        ivGuargar = (ImageView)rootView.findViewById(R.id.imgvGuardaFotos);
         /*Prueba de base de datos local*/
        helper = new DaoMaster.DevOpenHelper(rootView.getContext(), "eForms_db", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
        contratoDao = daoSession.getContratoDao();
        /*********************************/
        foto1=(ImageView)rootView.findViewById(R.id.imvFoto1);
        foto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numFoto = 1;
                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });
        foto2=(ImageView)rootView.findViewById(R.id.imvFoto2);
        foto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numFoto = 2;
                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });
        foto3=(ImageView)rootView.findViewById(R.id.imvFoto3);
        foto3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numFoto = 3;
                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });
        foto4=(ImageView)rootView.findViewById(R.id.imvFoto4);
        foto4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numFoto = 4;
                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });
        ivGuargar.setOnClickListener(new View.OnClickListener() {
            String bandera = "";
            String campos = "";
            @Override
            public void onClick(View v) {

                contratoDao.insertOrReplace(getContratoSingleton());

                }
        });
        return  rootView;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK) {
            Bitmap bp = (Bitmap) data.getExtras().get("data");
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            byte[] byteArray;
            switch (numFoto) {
                case 1:
                    foto1.setBackgroundResource(0);
                    foto1.setImageBitmap(bp);
                    bp.compress(Bitmap.CompressFormat.PNG, 100, stream);
                    byteArray = stream.toByteArray(); // Este es el objeto que debo guardar en la base de datos local
                    getContratoSingleton().setFoto1(byteArray);
                    break;
                case 2:
                    foto2.setBackgroundResource(0);
                    foto2.setImageBitmap(bp);
                    bp.compress(Bitmap.CompressFormat.PNG, 100, stream);
                    byteArray = stream.toByteArray(); // Este es el objeto que debo guardar en la base de datos local
                    getContratoSingleton().setFoto2(byteArray);
                    break;
                case 3:
                    foto3.setBackgroundResource(0);
                    foto3.setImageBitmap(bp);
                    bp.compress(Bitmap.CompressFormat.PNG, 100, stream);
                    byteArray = stream.toByteArray(); // Este es el objeto que debo guardar en la base de datos local
                    getContratoSingleton().setFoto3(byteArray);
                    break;
                case 4:
                    foto4.setBackgroundResource(0);
                    foto4.setImageBitmap(bp);
                    bp.compress(Bitmap.CompressFormat.PNG, 100, stream);
                    byteArray = stream.toByteArray(); // Este es el objeto que debo guardar en la base de datos local
                    getContratoSingleton().setFoto4(byteArray);
                    break;
                default:
                    break;
            }
        }




    }
}
