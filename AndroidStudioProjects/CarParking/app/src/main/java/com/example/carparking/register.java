package com.example.carparking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);


        //show layout
        ImageView simply_show_layout=(ImageView) findViewById(R.id.showlayout);

        simply_show_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n4=new Intent(getApplicationContext(),showlayout.class);
                startActivity(n4);
            }
        });

        Spinner sp=(Spinner)  findViewById(R.id.institue);
        String [] institutions={"City centre mall","Forum Mall","Big Bazaar"};
        ArrayAdapter adap=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,institutions);
        adap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adap);
        Button book=(Button)findViewById(R.id.book_lots);
        EditText vehicleno=(EditText)findViewById(R.id.vehicle_no);



        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isValidVehicleNumberPlate(String.valueOf(vehicleno.getText()).toUpperCase())){
                    Intent n1=new Intent(getApplicationContext(),MainActivity.class);
                    n1.putExtra("Vehicleno",String.valueOf(vehicleno.getText()));
                    startActivity(n1);

                }
                else{
                    Toast.makeText(register.this, "Invalid Vehicle No!!!", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    public boolean isValidVehicleNumberPlate(String NUMBERPLATE)
    {


        String regex = "^[A-Z]{2}[\\ -]{0,1}[0-9]{2}[\\ -]{0,1}[A-Z]{1,2}[\\ -]{0,1}[0-9]{4}$";
        Pattern p = Pattern.compile(regex);
        if (NUMBERPLATE == null) {
            return false;
        }
        Matcher m = p.matcher(NUMBERPLATE);
        return m.matches();
    }

}