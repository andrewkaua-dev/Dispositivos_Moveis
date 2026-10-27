package com.example.petapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setTitle(R.string.login);
    }

    public void logar(View view) {

        EditText login = findViewById(R.id.TextViewLogin);
        EditText senha = findViewById(R.id.TextViewSenha);

        String usuario = login.getText().toString();
        String senhaDigitada = senha.getText().toString();

        if (usuario.isEmpty() || senhaDigitada.isEmpty()) {

            Toast.makeText(this,
                    "Preencha usuário e senha",
                    Toast.LENGTH_LONG).show();

        } else if (usuario.equals("admin") && senhaDigitada.equals("123")) {

            Toast.makeText(this,
                    "Sucesso no login",
                    Toast.LENGTH_LONG).show();

        } else {

            Toast.makeText(this,
                    "Usuário ou senha inválido",
                    Toast.LENGTH_LONG).show();
        }
    }
}
