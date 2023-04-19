package com.example.carparking;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class showlayout extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("parkings");
        GridView gridview=findViewById(R.id.simpleGridView);
        ImagAdapter adapter=new ImagAdapter(this);
        gridview.setAdapter(adapter);

        SimpleDateFormat sdf = new SimpleDateFormat("dd 'th' - MMM - y '|' E");
        String currentDate = sdf.format(new Date());
        TextView t=(TextView)findViewById(R.id.dates);
        t.setText(currentDate);


        ArrayList<Integer> upd=new ArrayList<Integer>();
        for(int i=0;i<100;i++){
            upd.add(R.drawable.ic_launcher_background);
        }

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot snap:snapshot.getChildren()){
                    upd.set(Integer.parseInt(snap.getKey()),R.drawable.green);
                }
                adapter.update(upd);
                gridview.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}
