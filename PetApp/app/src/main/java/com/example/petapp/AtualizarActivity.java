package com.example.petapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AtualizarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Atualizar Pet");
        setContentView(R.layout.activity_atualizar);
    }

    public void atualizarPet(View view) {
        EditText caixaNome = findViewById(R.id.editTextNomeAtualizar);
        EditText caixaIdade = findViewById(R.id.editTextNovaIdade);

        String nome = caixaNome.getText().toString().trim();
        String novaIdade = caixaIdade.getText().toString().trim();

        if(nome.isEmpty() || novaIdade.isEmpty()){
            Toast.makeText(this, "Todos os campos devem ser preenchidos", Toast.LENGTH_LONG).show();
            return;
        }

        try {
            int idade = Integer.parseInt(novaIdade);
            if(idade < 0){
                Toast.makeText(this, "A idade deve ser válida", Toast.LENGTH_LONG).show();
                return;
            }
        } catch (NumberFormatException e){
            Toast.makeText(this, "Digite uma idade válida", Toast.LENGTH_LONG).show();
            return;
        }

        boolean resultado = DadosCompartilhados.atualizarIdadePet(nome, novaIdade);

        if(resultado){
            Toast.makeText(this, "Idade do pet atualizada com sucesso", Toast.LENGTH_LONG).show();
            caixaNome.setText("");
            caixaIdade.setText("");
        } else {
            Toast.makeText(this, "Pet não encontrado", Toast.LENGTH_LONG).show();
        }
    }
}
