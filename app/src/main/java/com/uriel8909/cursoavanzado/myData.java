package com.uriel8909.cursoavanzado;

import android.content.Context;
import android.content.SharedPreferences;

public class myData {

    private SharedPreferences preferences;

    public myData(Context context) {
        //SE CREA ARCHIVO LLAMADA SHARED DE MODO PRIVADO.
        preferences = context.getSharedPreferences("sharedCursoAvanzado",Context.MODE_PRIVATE);
    }

    public void guardarUsuario(String usuario){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("nombreUsuario", usuario);
        editor.apply();
    }

    public void setLogeo(Boolean access){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("login",access);
        editor.apply();

    }

    public String obtenerUsuario(){

        return preferences.getString("nombredUsuario", "");
//dededede
    }
    public boolean getLogeo(){
        return preferences.getBoolean("login",false);
    }
}

