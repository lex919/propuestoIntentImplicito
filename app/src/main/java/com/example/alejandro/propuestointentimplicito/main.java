package com.example.alejandro.propuestointentimplicito;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

/**
 * Created by Jonh Doe on 06/10/2015.
 */
public class main extends Activity implements View.OnClickListener{
    Intent web, telf, foto, correo;
    Button btn1, btn2, btn3, btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);

        //blue hola
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                web = new Intent();
                web.setAction(Intent.ACTION_VIEW);
                web.setData(Uri.parse("http://www.iesdoctorbalmis.com"));
                startActivity(web);

                break;
            case R.id.btn2:
                telf = new Intent();
                telf.setAction(Intent.ACTION_CALL);
                telf.setData(Uri.parse("tel:11223344"));
                startActivity(telf);
                break;
            case R.id.btn3:
                foto = new Intent();
                foto.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                File f = new File("/storage/sdcard0/DCIM/Camera/mia.jpg");

                foto.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
                startActivityForResult(foto,1);
                break;
            case R.id.btn4:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //if (requestCode == 1 && resultCode == RESULT_OK) {
            //Bitmap thumbnail = data.getParcelableExtra("data");

            //http://www.maestrosdelweb.com/curso-android-trabajando-con-imagenes/
            Toast.makeText(this, "foo varr", Toast.LENGTH_LONG).show();
            Toast.makeText(this, "hola mundo", Toast.LENGTH_LONG).show();
        //}

    }
}
