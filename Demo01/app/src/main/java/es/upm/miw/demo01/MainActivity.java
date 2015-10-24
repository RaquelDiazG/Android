package es.upm.miw.demo01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int contador=0;
    Button pulsador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Generamos un boton al que le pasamos el contexto
        pulsador=new Button(this);
        //Añadimos el texto al boton
        pulsador.setText(getString(R.string.texto_pulsador));
        //Añadimos un click listener
        pulsador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Incrementamos el contador
                contador++;
                //Concatenamos al texto del boton el valor del contador
                String str=getString(R.string.texto_pulsador)+String.format("%d", contador);
                pulsador.setText(str);
            }
        });

        setContentView(pulsador);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Añadimos una opcion al menu
        menu.add(Menu.NONE,1,100,getString(R.string.option_reiniciar));
        //Creamos el menu
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                contador=0;
                pulsador.setText(getString(R.string.texto_pulsador));
                break;
            default:break;
        }

        return super.onOptionsItemSelected(item);
    }
}
