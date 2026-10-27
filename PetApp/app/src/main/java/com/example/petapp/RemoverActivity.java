package com.example.petapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RemoverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Remover Pet");
        setContentView(R.layout.activity_remover);
    }

    public void removerPet(View view) {
        EditText caixaNome = findViewById(R.id.editTextNomeRemover);
        String nome = caixaNome.getText().toString().trim();

        if(nome.isEmpty()){
            Toast.makeText(this, "Informe o nome do pet", Toast.LENGTH_LONG).show();
            return;
        }

        boolean resultado = DadosCompartilhados.removerPet(nome);

        if(resultado){
            Toast.makeText(this, "Pet removido com sucesso", Toast.LENGTH_LONG).show();
            caixaNome.setText("");
        } else {
            Toast.makeText(this, "Pet não encontrado", Toast.LENGTH_LONG).show();
        }
    }
}
