package com.uriel8909.cursoavanzado;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class listAdapter extends ArrayAdapter<usuario> {

    private  Context context;
    private  int layoutId;
    private  ArrayList<usuario> usuarios;

    public listAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<usuario> objects) {
        super(context, resource, textViewResourceId, objects);
        this.context=context;
        this.layoutId=resource;
        this.usuarios= new ArrayList<>(objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layoutId,null);
            holder = new ViewHolder();
            holder.imgIcono = convertView.findViewById(R.id.imgListItem);
            holder.tv_nombre= convertView.findViewById(R.id.txtListItemNombre);
            holder.tv_correo = convertView.findViewById(R.id.txtListItemCorreo);
            holder.tv_id = convertView.findViewById(R.id.txtListId);
            holder.tv_rol= convertView.findViewById(R.id.txtListRol);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }
        usuario usuario = usuarios.get(position);
        if (usuario.getGenero().equals("masculino")){
            holder.imgIcono.setImageResource(R.mipmap.generos);
        }
        holder.tv_nombre.setText(usuario.getNombre());
        holder.tv_correo.setText(usuario.getCorreo());
        holder.tv_id.setText(usuario.getId());
        holder.tv_rol.setText(usuario.getRol());

        return convertView;
    }
    public class ViewHolder{
        ImageView imgIcono;
        TextView tv_nombre, tv_correo, tv_id, tv_rol;

    }
}
