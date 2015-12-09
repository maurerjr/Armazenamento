package maurercompany.armazenamento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class Cadastro extends AppCompatActivity {
    EditText edtNome,edtPrioridade;
    DatePicker dpData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        edtNome = (EditText) findViewById(R.id.edt_nome);
        edtPrioridade = (EditText) findViewById(R.id.edt_prioridade);
        dpData = (DatePicker) findViewById(R.id.datePicker);


    }


    public void salvar (View view){

        if(edtNome.getText().toString().isEmpty()) {

            Toast.makeText(getApplicationContext(), "Preencha todos os Campos", Toast.LENGTH_LONG).show();
        }else {
            Evento evento = new Evento(edtNome.getText().toString(),
                    dpData.getDayOfMonth(),dpData.getMonth(),dpData.getYear()
            );

            Date date = new Date(dpData.getDayOfMonth(),dpData.getMonth(),dpData.getYear());



            Intent intent = new Intent();
            intent.putExtra("evento", evento);
            setResult(1, intent);
            finish();
        }

    }

    public  void cancelar (View view){

        Intent intent = new Intent();
        setResult(2, intent);

        finish();
    }

}