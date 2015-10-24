package es.upm.miw.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ActividadPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Identificar el recurso en la vista
        final ListView listView=(ListView)findViewById(R.id.lvlistadoElementos);
        //Crear adaptador a partir del recurso
        ArrayAdapter adaptador=ArrayAdapter.createFromResource(
                this,
                R.array.datos,
                android.R.layout.simple_list_item_1
        );
        //Asignar el adaptador al recursos
        listView.setAdapter(adaptador);

        //Asignamos un listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Recuperamos el texto de la opcion elegida
                String opcionElegida=listView.getItemAtPosition(position).toString();

                Log.i("Posicion elegida", opcionElegida);

                //Mostrar un cartel negro
                //Toast.makeText(getApplicationContext(),opcionElegida,Toast.LENGTH_SHORT).show();

                Intent intend=new Intent(ActividadPrincipal.this,MuestraDetalle.class);

                /* Otra forma de hacerlo para quitar el bundle
                intend.putExtra("OPCION_ELEGIDA",opcionElegida);
                intend.putExtra("NUMERO_OPCION",position);
                 */

                Bundle bundle=new Bundle();
                bundle.putString("OPCION_ELEGIDA", opcionElegida);
                bundle.putInt("NUMERO_OPCION",position);
                intend.putExtras(bundle);
                startActivity(intend);
            }
        });
    }
}
