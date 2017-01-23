package edu.upc.eetac.dsa.lista_customizada;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by pauli on 19/12/2016.
 */
public class MuntanyaActivity extends AppCompatActivity {
    TextView muntanyaTitol;
    TextView muntanyaInfo;
    ImageView muntanyaImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muntanya);

        muntanyaTitol = (TextView) findViewById(R.id.muntanyaTitol);
        muntanyaInfo = (TextView) findViewById(R.id.muntanyaInfo);
        muntanyaImage = (ImageView) findViewById(R.id.muntanyaImage);

        Bundle intentData = getIntent().getExtras();

        String titol = intentData.getString("muntanyaTitol");
        String info = intentData.getString("muntanyaInfo");
        muntanyaTitol.setText(titol);
        muntanyaInfo.setText(info);
        setMuntanyaImage(titol, muntanyaImage);
    }

    public void setMuntanyaImage(String nom, ImageView muntanyaImage) {
        switch (nom) {
            case "Montseny":
                muntanyaImage.setImageResource(R.drawable.monseny_turo_home_150p);
                muntanyaInfo.setText(this.muntanyaInfo.getText());
                break;
            case "Mont Perdut":
                muntanyaImage.setImageResource(R.drawable.montperdut_150p);
                break;
            case "Dôme de Neige":
                muntanyaImage.setImageResource(R.drawable.dome_de_neige_150p);
                break;
            case "Pica d'Estats":
                muntanyaImage.setImageResource(R.drawable.pica_destats_150p);
                break;
            case "Pedraforca":
                muntanyaImage.setImageResource(R.drawable.pedradorca_150p);
                break;
            case "Montardo":
                muntanyaImage.setImageResource(R.drawable.montardo_150p);
                break;
            default:
                break;
        }
    }
}
