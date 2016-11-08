package cr.co.sea.seaforms.Controller.Fragments;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.telerik.widget.dataform.engine.DataFormMetadata;
import com.telerik.widget.dataform.visualization.RadDataForm;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import cr.co.sea.seaforms.R;

/**
 * Created by asanchezo on 18/10/2016.
 */

public class AnexosFormFragment extends Fragment {
    ImageView foto1;
    ImageView foto2;
    ImageView foto3;
    ImageView foto4;
    int numFoto = 0;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_fotos,container,false);
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
        return  rootView;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bp = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        byte[] byteArray;
        switch (numFoto){
            case 1:
                foto1.setBackgroundResource(0);
                foto1.setImageBitmap(bp);
                bp.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byteArray = stream.toByteArray(); // Este es el objeto que debo guardar en la base de datos local
                break;
            case 2:
                foto2.setBackgroundResource(0);
                foto2.setImageBitmap(bp);
                bp.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byteArray = stream.toByteArray(); // Este es el objeto que debo guardar en la base de datos local
                break;
            case 3:
                foto3.setBackgroundResource(0);
                foto3.setImageBitmap(bp);
                bp.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byteArray = stream.toByteArray(); // Este es el objeto que debo guardar en la base de datos local
                break;
            case 4:
                foto4.setBackgroundResource(0);
                foto4.setImageBitmap(bp);
                bp.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byteArray = stream.toByteArray(); // Este es el objeto que debo guardar en la base de datos local
                break;
            default:
                break;
        }




    }
}
