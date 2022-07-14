package com.upv.pm_2022.iti_27856_u2_equipo_05;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    /**
     *
     */
    DragAndDropView dragAndDropView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         *
         */
        LinearLayout ly = findViewById(R.id.ly);
        dragAndDropView = new DragAndDropView(this);
        ly.addView(dragAndDropView);
        Button add_first,remove_last,add_index;
        add_first = findViewById(R.id.add_first);
        remove_last = findViewById(R.id.add_last);
        add_index = findViewById(R.id.add_index);

        add_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dragAndDropView.figuras.add(
                        new Circulo(
                                dragAndDropView.figuras.size()+1,
                                dragAndDropView.figuras.get(dragAndDropView.figuras.size()-1).getX() + 100,
                                dragAndDropView.figuras.get(dragAndDropView.figuras.size()-1).getY() ,
                                20
                        )
                );
                if (dragAndDropView.figuras.get(dragAndDropView.figuras.size()-1).getX() + 100 > ly.getHeight()){
                    dragAndDropView.figuras.add(
                        new Circulo(
                                dragAndDropView.figuras.size()+1,
                                 100,
                                dragAndDropView.figuras.get(dragAndDropView.figuras.size()-1).getY() + 100,
                                20
                        )
                    );
                }
                ly.invalidate();
            }
        });

        remove_last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dragAndDropView.figuras.size()-1>1)
                    dragAndDropView.figuras.remove(dragAndDropView.figuras.size()-1);
                ly.invalidate();
            }
        });

        add_index.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.Menu_about:
                // Show dialog say our names
                AlertDialog.Builder ADX;
                AlertDialog AD;
                ADX = new AlertDialog.Builder(this);
                AD = ADX.create();
                AD.setMessage(
                    "Adair Eliseo Rojas Oaxaca \n" +
                    "Carlos Jared Ulibarri Ruiz\n" +
                    "Hector Varela Grimaldo \n" +
                    "Josué Eliseo Perales Meléndez Y Alcocer\n" +
                    "Saúl Sánchez de la Fuente"
                );
                AD.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}