package edu.upc.eetac.dsa.lista_customizada;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by pauli on 18/12/2016.
 */
public class ElmeuArrayAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final String[] values;
    protected List<Muntanyes> listResultados;


    public ElmeuArrayAdapter(Context context, String[] values) {
        super(context, R.layout.listamcost, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.listamcost, parent, false);

        TextView textView = (TextView) rowView.findViewById(R.id.label);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.logo);
        //llamando al switch
        setTextAndLogoOfRow(values[position], textView, imageView);

        return rowView;
    }

    public void setTextAndLogoOfRow(String rowText, TextView textView, ImageView imageView) {
        textView.setText(rowText);
        switch (rowText) {
            case "Montseny":
                imageView.setImageResource(R.drawable.monseny_turo_home_150p);
                break;
            case "Mont Perdut":
                imageView.setImageResource(R.drawable.montperdut_150p);
                break;
            case "Dôme de Neige":
                imageView.setImageResource(R.drawable.dome_de_neige_150p);
                break;
            case "Pica d'Estats":
                imageView.setImageResource(R.drawable.pica_destats_150p);
                break;
            case "Pedraforca":
                imageView.setImageResource(R.drawable.pedradorca_150p);
                break;
            case "Montardo":
                imageView.setImageResource(R.drawable.montardo_150p);
                break;
            default:
                break;
        }
    }

/*
        textView.setText(values[position]);
        // assigna icona
        imageView.setImageResource(R.drawable.muntanya_logo);
        //    Per mostrar un missage per consola
        String s = values[position];
        System.out.println(s);

            if (s.equals("Montseny")) {
            imageView.setImageResource(R.drawable.monseny_turo_home_150p);
            } else if (s.equals("Mont Perdut")) {
            imageView.setImageResource(R.drawable.montperdut_150p);
            } else if (s.equals("Dôme de Neige")) {
            imageView.setImageResource(R.drawable.dome_de_neige_150p);
            } else if (s.equals("Pica d'Estats")) {
            imageView.setImageResource(R.drawable.pica_destats_150p);
            } else if (s.equals("Pedraforca")) {
            imageView.setImageResource(R.drawable.pedradorca_150p);
            } else {   //Montardo
            imageView.setImageResource(R.drawable.montardo_150p);
            }
*/



}
