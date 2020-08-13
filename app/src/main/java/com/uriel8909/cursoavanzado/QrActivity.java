package com.uriel8909.cursoavanzado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

import static com.uriel8909.cursoavanzado.variablesGlobales.codigosqr;

public class QrActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    ZXingScannerView scannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);
        scannerView = findViewById(R.id.zxingScanner);
        scannerView.setResultHandler(QrActivity.this);
        scannerView.startCamera();
    }

    @Override
    public void handleResult(Result result) {
        codigosqr = result.getText();
        scannerView.stopCamera();
        startActivity(new Intent(QrActivity.this,MainActivity.class));
    }
}