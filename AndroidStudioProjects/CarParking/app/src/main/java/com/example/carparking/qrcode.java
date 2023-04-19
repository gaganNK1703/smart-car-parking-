package com.example.carparking;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class qrcode extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qrcode);
        Intent n3=getIntent();
        ImageView im=(ImageView) findViewById(R.id.qrimage);
        String s=n3.getStringExtra("pos")+" "+n3.getStringExtra("user")+" "+n3.getStringExtra("book_time");


        MultiFormatWriter writer=new MultiFormatWriter();
        BitMatrix matrix= null;
        try {
            matrix = writer.encode(s, BarcodeFormat.QR_CODE, 300, 300);
            BarcodeEncoder en=new BarcodeEncoder();
            Bitmap bm=en.createBitmap(matrix);
            im.setImageBitmap(bm);
        } catch (WriterException e) {
            e.printStackTrace();
        }

    }

}
