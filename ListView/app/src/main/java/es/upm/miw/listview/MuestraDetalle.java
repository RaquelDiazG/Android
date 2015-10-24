package es.upm.miw.listview;

import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MuestraDetalle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muestra_detalle);

        //Recuperar el recurso asociado a la vista
        TextView tvElementoElegido=(TextView)findViewById(R.id.vistaDetalleElemento);

        //Recuperar el bundle con los datos
        Bundle bundle=this.getIntent().getExtras();

        //Añadimos el texto a la vista
        String elementoElegido=bundle.getString("OPCION_ELEGIDA");
        tvElementoElegido.setText(elementoElegido);

        //Mostrar el boton volver
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        setResult(RESULT_OK);
    }
}
