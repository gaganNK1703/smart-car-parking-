package com.example.carparking;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String vehicle_user;
    Chronometer chrono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Intent n2=getIntent();
        vehicle_user=n2.getStringExtra("Vehicleno");
        GridView gridview=findViewById(R.id.simpleGridView);
        ImagAdapter adapter=new ImagAdapter(this);
        gridview.setAdapter(adapter);

        chrono=(Chronometer)findViewById(R.id.chronometer);
        SimpleDateFormat sdf = new SimpleDateFormat("dd 'th' - MMM - y '|' E");
        String currentDate = sdf.format(new Date());

        TextView t=(TextView)findViewById(R.id.dates);
        TextView user=(TextView)findViewById(R.id.noplate);
        TextView book_time=(TextView)findViewById(R.id.bookedtime);

        t.setText(currentDate);

        user.setText(vehicle_user);



        final int[] curpos = new int[1];
        curpos[0]=-1;
        ArrayList<Integer> upd=new ArrayList<Integer>();
        for(int i=0;i<100;i++){
            upd.add(R.drawable.ic_launcher_background);
        }

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

        String searchKey = vehicle_user;

        Query searchQuery = databaseReference.orderByKey().equalTo(searchKey);

        searchQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Check if the key is found in the database
                if (dataSnapshot.exists()) {

                    DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child(vehicle_user);
                    ValueEventListener valueEventListener = reference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String [] prev_upd=new String[3];
                            int i=0;
                            for (DataSnapshot snap : snapshot.getChildren()) {
                                prev_upd[i]=snap.getValue().toString();
                                i++;
                            }
                            //setting dashboard
                            chrono.setBase(SystemClock.elapsedRealtime()-Integer.parseInt(prev_upd[0]));
                            chrono.start();

                            book_time.setText("Entry Time:"+prev_upd[1]);
                            curpos[0]=Integer.parseInt(prev_upd[2]);

                            user.setText("");
                            user.setText(vehicle_user+" at lot-"+String.valueOf(curpos[0]+1));


                            upd.set(curpos[0],R.drawable.red);

                            adapter.update(upd);
                            gridview.setAdapter(adapter);


                            //for opening the ticket
                            LayoutInflater inflater=getLayoutInflater();
                            LinearLayout lr=(LinearLayout) findViewById(R.id.tickets);
                            inflater.inflate(R.layout.tickets,lr);
                            TextView tr=(TextView) findViewById(R.id.openticket);
                            tr.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent i=new Intent(getApplicationContext(),qrcode.class);
                                    i.putExtra("pos",String.valueOf(curpos[0]));
                                    i.putExtra("user",vehicle_user);
                                    i.putExtra("book_time",prev_upd[1]);
                                    startActivity(i);
                                }
                            });

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });




                } else {

                    gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            AlertDialog.Builder alert=new AlertDialog.Builder(MainActivity.this);
                            alert.setTitle("Parking slot Booking");
                            alert.setMessage("Do you want to book?(Timer will start)");
                            alert.setCancelable(false);

                            alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    FirebaseDatabase.getInstance().getReference().child("parkings").child(String.valueOf(position)).setValue(vehicle_user);


                                    SimpleDateFormat sdf_time = new SimpleDateFormat("HH:mm:ss a");

                                    String bookedTime=sdf_time.format(new Date());


                                    book_time.setText("Entry Time:"+bookedTime);

                                    user.setText(user.getText().toString()+" at lot-"+String.valueOf(position+1));

                                    gridview.setOnItemClickListener(null);
                                    curpos[0]=position;
                                    upd.set(curpos[0],R.drawable.red);
                                    chrono.setBase(SystemClock.elapsedRealtime());
                                    chrono.start();

                                    //for opening the ticket
                                    LayoutInflater inflater=getLayoutInflater();
                                    LinearLayout lr=(LinearLayout) findViewById(R.id.tickets);
                                    inflater.inflate(R.layout.tickets,lr);

                                    TextView tr=(TextView) findViewById(R.id.openticket);
                                    tr.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent i=new Intent(getApplicationContext(),qrcode.class);
                                            i.putExtra("pos",String.valueOf(position));
                                            i.putExtra("user",vehicle_user);
                                            i.putExtra("book_time",bookedTime);
                                            startActivity(i);
                                        }
                                    });
                                    FirebaseDatabase.getInstance().getReference().child(vehicle_user).child("Entrytime").setValue(bookedTime);
                                    FirebaseDatabase.getInstance().getReference().child(vehicle_user).child("Position").setValue(position);
                                }
                            });

                            alert.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(getApplicationContext(),"Slot not booked",Toast.LENGTH_SHORT).show();

                                }
                            });

                            AlertDialog ad=alert.create();
                            ad.show();

                        }
                    });

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("SEARCH_ERROR", databaseError.getMessage());
            }
        });

        //end search

        DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("parkings");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                  for(DataSnapshot snap:snapshot.getChildren()){

                      if(Integer.parseInt(snap.getKey())!=curpos[0])
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

    @Override
    public void onPause(){
        super.onPause();
        FirebaseDatabase.getInstance().getReference().child(vehicle_user).child("Chronometre_closed").setValue(SystemClock.elapsedRealtime()-chrono.getBase());

    }



}