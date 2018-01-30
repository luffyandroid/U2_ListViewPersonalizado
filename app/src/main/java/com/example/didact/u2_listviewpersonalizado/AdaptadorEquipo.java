package com.example.didact.u2_listviewpersonalizado;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by DIDACT on 30/01/2018.
 */

public class AdaptadorEquipo extends ArrayAdapter<Equipo>{

    ArrayList<Equipo> equipos;
    Context c;

    public AdaptadorEquipo(Context c, ArrayList<Equipo> equipos){
        super(c, R.layout.item_equipo, equipos);
        this.c = c;
        this.equipos = equipos;



    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.item_equipo, null);

        //TextView Nombre
        TextView tv_nombre=(TextView)item.findViewById(R.id.item_nombre);
        tv_nombre.setText(equipos.get(position).getNombre());

        //TextView Estadio
        TextView tv_estadio=(TextView)item.findViewById(R.id.item_estadio);
        tv_estadio.setText(equipos.get(position).getEstadio());

        //ImageView
        String logo = equipos.get(position).getLogo();

        int idImagen = c.getResources().getIdentifier(logo, "drawable",c.getPackageName());
        ImageView iv_logo = (ImageView)item.findViewById(R.id.item_logo);
        iv_logo.setImageResource(idImagen);


        return item;
    }
}
