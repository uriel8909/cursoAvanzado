package com.uriel8909.cursoavanzado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

import static com.uriel8909.cursoavanzado.variablesGlobales.usuariosApp;

public class AgregarUsuarioActivity extends AppCompatActivity {

   //vistas
    EditText edtNombre, edtPassword, edtCorreo;
    RadioGroup radioSexo, radioRol;
    Button btnAgregar;
    //Utilidades
    Context context;
    //variables
    private String sexo = "";
    private String rol = "";
    private int id = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_usuario);
        configuracionesIniciales();
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = edtNombre.getText().toString();
                String password = edtPassword.getText().toString();
                String correo = edtCorreo.getText().toString();
                if (!nombre.isEmpty()){
                    if (!password.isEmpty()){
                        if (!correo.isEmpty()){
                            if (correo.contains("@")){
                                if (!sexo.isEmpty()){
                                    if (!rol.isEmpty()){

                                        agregarUsuario(nombre,password,correo,sexo,rol);
                                    }else{
                                        mostrarToast("Seleccione el rol para continuar");
                                    }
                                }else{
                                    mostrarToast("Seleccione el genero para continuar");
                                }
                            }else{
                                mostrarToast("Ingrese un correo valido!");
                            }
                        }else{
                            mostrarToast("Favor de ingresar un correo para continuar!");
                        }
                    }else{
                        mostrarToast("Favor ingrese password para continuar");
                    }
                }else{
                    mostrarToast("Favor de ingresar nombre para continuar");
                }
            }
        });
        radioSexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb_m){
                    sexo = "masculino";
                }
                if (checkedId == R.id.rb_f){
                    sexo = "femenino";
                }
                if (checkedId == R.id.rb_i){
                    sexo = "desconocido";
                }
            }
        });
        radioRol.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb_admin){
                    rol = "administrador";
                }
                if (checkedId == R.id.rb_user){
                    rol = "usuario normal";
                }
            }
        });
    }

    private void agregarUsuario(String nombre, String password, String correo, String sexo,String rol){
        if (usuariosApp==null){
            usuariosApp = new ArrayList<>();
            usuariosApp.add(new usuario(id,nombre,password,sexo,rol,correo));
            id++;
            mostrarToast("Usuario agregado correctamente!!!");
            startActivity(new Intent(context,MainActivity.class));
        }

    }
    private void configuracionesIniciales(){
        context = AgregarUsuarioActivity.this;
        edtNombre = findViewById(R.id.et_user);
        edtPassword = findViewById(R.id.et_pass);
        edtCorreo = findViewById(R.id.et_email);
        radioSexo = findViewById(R.id.radioSexo);
        radioRol = findViewById(R.id.radioRol);
        btnAgregar = findViewById(R.id.btn_guardar);
    }

    private void mostrarToast(String mensaje){
        Toast.makeText(context,mensaje,Toast.LENGTH_SHORT).show();
    }
}