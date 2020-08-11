package com.uriel8909.cursoavanzado;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.Manifest.permission.CAMERA;
import static com.uriel8909.cursoavanzado.variablesGlobales.passwordTemp;
import static com.uriel8909.cursoavanzado.variablesGlobales.usuarioTemp;

public class LoadActivity extends AppCompatActivity {

    EditText et_user, et_pass;
    Button btn_accesar;
    Context context;
    Button btn_permisos;
    boolean permisoCamara = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        btn_permisos = findViewById(R.id.btn_permisps);
        configuracionesIniciales();
        revisarPermisos();
        btn_permisos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                revisarPermisos();
            }
        });
    }



    private void revisarPermisos(){
        permisoCamara = checkSelfPermission(CAMERA) == PackageManager.PERMISSION_GRANTED;
        if (permisoCamara){
            //setPrimerTimer(3000)
        }else {
            requestPermissions(new String[]{CAMERA},25);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 25) {
            permisoCamara = checkSelfPermission(CAMERA) == PackageManager.PERMISSION_GRANTED;
            if (permisoCamara) {
                //setPrimerTimer(3000)
            } else {
                btn_permisos.setVisibility(View.VISIBLE);
            }
        }
    }
    /*private void setSegundoTimer

    */
    @Override
    protected void onResume() {
        super.onResume();

       btn_permisos.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               revisarPermisos();
               btn_permisos.setVisibility(View.INVISIBLE);
           }
       });
        btn_accesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario= et_user.getText().toString();
                String password= et_pass.getText().toString();
                if (usuario.isEmpty()){
                    Toast.makeText(context,"Flta usuario",Toast.LENGTH_SHORT).show();
                } else if (password.isEmpty()){
                    Toast.makeText(context,"Flta password",Toast.LENGTH_SHORT).show();
                }
                else {
                    if (usuario.equals(usuarioTemp)){
                        if (password.equals(passwordTemp)){
                            Toast.makeText(context,"Correcto",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(context,MainActivity.class));
                        myData myData = new myData(context);
                        myData.guardarUsuario(usuario);
                        myData.setLogeo(true);
                        }
                         else { Toast.makeText(context,"incorrecto",Toast.LENGTH_SHORT).show();
            }}}}
        });
    }

    private void configuracionesIniciales(){
        et_user = findViewById(R.id.et_user);
        et_pass = findViewById(R.id.et_pass);
        btn_accesar = findViewById(R.id.btn_accesar);
        context = LoadActivity.this;
    }
}