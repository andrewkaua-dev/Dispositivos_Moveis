package com.example.petapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CadastroActivity extends AppCompatActivity {

    private EditText editNome;
    private EditText editIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        setTitle("Cadastro de Pet");

        editNome = findViewById(R.id.editTextNomePet);
        editIdade = findViewById(R.id.editTextIdadePet);
    }

    public void salvarPet(View view) {
        String nome = editNome.getText().toString().trim();
        String idadeTexto = editIdade.getText().toString().trim();

        if (nome.isEmpty() || idadeTexto.isEmpty()) {
            Toast.makeText(
                    this,
                    "Todos os campos devem ser preenchidos",
                    Toast.LENGTH_LONG
            ).show();
            return;
        }

        int idade = Integer.parseInt(idadeTexto);
        Pet pet = new Pet(nome, idade);
        DadosCompartilhados.listaPets.add(pet);

        Toast.makeText(
                this,
                "Sucesso no cadastro",
                Toast.LENGTH_LONG
        ).show();

        editNome.setText("");
        editIdade.setText("");
        editNome.requestFocus();
    }
}
