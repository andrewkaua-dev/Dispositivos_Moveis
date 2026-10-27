package com.example.petapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void cadastrar(View view) {
        Intent intent = new Intent(this,CadastroActivity.class);
        startActivity(intent);
    }

    public void listagem(View view) {
        Intent intent = new Intent(this,ListagemActivity.class);
        startActivity(intent);
    }

    public void remover(View view) {
        Intent intent = new Intent(this,RemoverActivity.class);
        startActivity(intent);
    }

    public void atualizar(View view) {
        Intent intent = new Intent(this,AtualizarActivity.class);
        startActivity(intent);
    }
}