package com.example.carparking;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;

public class ImagAdapter extends BaseAdapter {

    ArrayList<Integer>pictures;
    private Context mcont;


    ImagAdapter(Context c){
        pictures= new ArrayList<Integer>();
        mcont=c;

        for(int i=0;i<100;i++){
            pictures.add(R.drawable.ic_launcher_background);
        }

    }



    @Override
    public int getCount() {
        return pictures.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imgview=new ImageView(mcont);
        imgview.setImageResource(pictures.get(i));
        imgview.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imgview.setLayoutParams(new GridView.LayoutParams(170,85));
        return imgview;
    }

    public void update(ArrayList<Integer> upd){
        pictures=upd;
        notifyDataSetChanged();

    }
}
