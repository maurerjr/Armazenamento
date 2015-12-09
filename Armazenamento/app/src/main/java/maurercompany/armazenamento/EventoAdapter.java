package maurercompany.armazenamento;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class EventoAdapter extends ArrayAdapter<Evento> {

    public EventoAdapter(Context context, int resource, List<Evento> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        View linha = LayoutInflater.from(getContext()).inflate(R.layout.adapter_eventos,null);

        TextView txtNome=(TextView) linha.findViewById(R.id.txtNome);
        TextView txtdata=(TextView) linha.findViewById(R.id.txtData);


        Evento p = getItem(position);
        txtNome.setText(p.getNomeEvento());
        txtdata.setText(p.getDia()+"/"+p.getMes()+"/"+p.getAno());

        return linha;

    }
}
