package com.uriel8909.cursoavanzado;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import static com.uriel8909.cursoavanzado.variablesGlobales.codigosqr;


public class MainActivity extends AppCompatActivity {

    //vistas
    Toolbar mainToolbar;
    Menu menuActivity;
    Context context;
    Button btn_qr;
    TextView tv_codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    configuracionesIniciales();

    }

    @Override
    protected void onResume() {
        super.onResume();
        btn_qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context,QrActivity.class));
            }
        });
        if (!codigosqr.isEmpty()){
            tv_codigo.setText(codigosqr + "es tu codigo");
        }
    }

    private void configuracionesIniciales(){
        mainToolbar = findViewById(R.id.toolbarMain);
        btn_qr = findViewById(R.id.btn_qr);
        tv_codigo= findViewById(R.id.tv_codigo);
        setSupportActionBar(mainToolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
    }
//infla la vista del menu que diseñamos, ademas de igula el menu activit al menu de la vista ampliada

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        this.menuActivity=menu;
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.mainMenu_logout:
                myData myData = new myData(context);
                myData.setLogeo(false);
                startActivity(new Intent(context,MainActivity.class));
                break;
            case R.id.mainMenu_about:
                Toast.makeText(this, "About presionado!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.mainMenu_AgregaruSUARIO:
                startActivity(new Intent(context,AgregarUsuarioActivity.class));
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}