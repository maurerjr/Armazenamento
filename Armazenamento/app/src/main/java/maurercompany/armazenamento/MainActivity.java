package maurercompany.armazenamento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Selection;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    public static final int CONSTANTE_TELA_1 = 1;
    public static final int CONSTANTE_TELA_2 = 2;
    public static final int CONSTANTE_TELA_3 = 3;
    public static ArrayList<Evento> meusEventos = new ArrayList<Evento>();
    ListView listView;
    Button add;
    EventoAdapter adapter;
    int posicao;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView =(ListView) findViewById(R.id.lst_eventos);
        add = (Button) findViewById(R.id.btn_add);
        registerForContextMenu(listView);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Cadastro.class);

                startActivityForResult(intent, CONSTANTE_TELA_1);
            }
        });

        adapter = new EventoAdapter(this, android.R.layout.simple_list_item_1, meusEventos);
        listView.setAdapter(adapter);





    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        Bundle params = data.getExtras();
        if(params != null) {
            if (requestCode == CONSTANTE_TELA_1) {

                adapter.add((Evento) data.getSerializableExtra("evento"));
                adapter.notifyDataSetChanged();

            } else if (requestCode == CONSTANTE_TELA_3) {

                meusEventos.set(posicao, (Evento) data.getSerializableExtra("update"));
                adapter.notifyDataSetChanged();

            }
        }
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        posicao = info.position;

        menu.setHeaderTitle("Selecione");
        menu.add(0, v.getId(), 0, "Atualizar");
        menu.add(0, v.getId(), 0, "Deletar");
    }


    @Override
    public boolean onContextItemSelected(MenuItem item){
        if(item.getTitle()=="Atualizar"){

            Intent intent = new Intent(MainActivity.this, UpdateEvento.class);
            String nomeEvento = adapter.getItem(posicao).getNomeEvento().toString();



            intent.putExtra("nomeEvento", nomeEvento);



            startActivityForResult(intent, CONSTANTE_TELA_3);

        }

        else if(item.getTitle()=="Deletar"){
            meusEventos.remove(posicao);
            adapter.notifyDataSetChanged();
            Toast.makeText(getApplicationContext(), "Excluido", Toast.LENGTH_LONG).show();
        }else{
            return false;
        }
        return true;
    }



}
