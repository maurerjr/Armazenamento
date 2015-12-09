package maurercompany.armazenamento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateEvento extends AppCompatActivity {
    EditText edtNome;
    DatePicker dpData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento_update);


        Bundle intent = getIntent().getExtras();
        String nome = intent.getString("nomeEvento");




        edtNome = (EditText) findViewById(R.id.edt_nome);
        dpData = (DatePicker) findViewById(R.id.datePicker);

        edtNome.setText(nome);


    }


    public void salvar (View view){

        if(edtNome.getText().toString().isEmpty()) {

            Toast.makeText(getApplicationContext(), "Preencha todos os Campos", Toast.LENGTH_LONG).show();
        }else {
            Evento update = new Evento(edtNome.getText().toString(),
                    dpData.getDayOfMonth(),dpData.getMonth(),dpData.getYear()
            );

            Intent intent = new Intent();
            intent.putExtra("update", update);
            setResult(3, intent);
            finish();
        }

    }

    public  void cancelar (View view){

        Intent intent = new Intent();
        setResult(2, intent);

        finish();
    }

}
