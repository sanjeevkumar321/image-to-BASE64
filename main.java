package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {
    String drawble;
    private Button btn1;
    private ImageView imageView1,imageView2;
    private TextView tx1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn1 = (Button) findViewById(R.id.btn) ;
        imageView1=(ImageView)findViewById(R.id.img1);
        imageView2=(ImageView)findViewById(R.id.img2);

        tx1=(TextView)findViewById(R.id.text1);
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                BitmapDrawable drawable = (BitmapDrawable) imageView1.getDrawable();
                Bitmap bitmap = drawable.getBitmap();
//                imageView2.setImageBitmap(bitmap);

                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream .toByteArray();
                String encoded = Base64.encodeToString(byteArray, Base64.DEFAULT);
tx1.setText(encoded);



//decode base64 string to image
                byteArray = Base64.decode(encoded, Base64.DEFAULT);
                Bitmap decodedImage = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                imageView2.setImageBitmap(decodedImage);
            }
        });



    }


}
