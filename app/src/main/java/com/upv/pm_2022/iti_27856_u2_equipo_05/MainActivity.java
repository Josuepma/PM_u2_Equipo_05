package com.upv.pm_2022.iti_27856_u2_equipo_05;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    /**
     *
     */
    DragAndDropView dragAndDropView;
    Context context = this;

    DisplayMetrics displayMetrics = new DisplayMetrics();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         *
         */


        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        LinearLayout ly = findViewById(R.id.ly);
        dragAndDropView = new DragAndDropView(this);
        ly.addView(dragAndDropView);
        Button add_first,remove_last,add_index;
        add_first = findViewById(R.id.add_first);
        remove_last = findViewById(R.id.add_last);
        add_index = findViewById(R.id.add_index);

        float radio = (width) / 12;

        add_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dragAndDropView.figuras.add(
                        new Circulo(
                                dragAndDropView.figuras.size()+1,
                                dragAndDropView.figuras.get(dragAndDropView.figuras.size()-1).getX() + ((int)radio + 200),
                                dragAndDropView.figuras.get(dragAndDropView.figuras.size()-1).getY() ,
                                radio
                        )
                );
                if (dragAndDropView.figuras.get(dragAndDropView.figuras.size()-1).getX() + ((int)radio + 200) > ly.getHeight()){
                    dragAndDropView.figuras.add(
                        new Circulo(
                                dragAndDropView.figuras.size()+1,
                                 100,
                                dragAndDropView.figuras.get(dragAndDropView.figuras.size()-1).getY() + ((int)radio + 100),
                                radio
                        )
                    );
                }
                ly.invalidate();
            }
        });

        remove_last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dragAndDropView.figuras.size()-1>0)
                    dragAndDropView.figuras.remove(dragAndDropView.figuras.size()-1);
                ly.invalidate();
            }
        });

        add_index.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.custom);

                Button dialog_add = dialog.findViewById(R.id.dialogButtonAdd);
                dialog_add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        EditText number = dialog.findViewById(R.id.ETDialog1);
                        int numberInt = Integer.parseInt(number.getText().toString());
                        dragAndDropView.figuras.set(numberInt - 1,
                                new Circulo(
                                        dragAndDropView.figuras.size()+1,
                                        dragAndDropView.figuras.get(numberInt - 2).getX() + 100,
                                        dragAndDropView.figuras.get(numberInt - 2).getY() ,
                                        ((int)radio + 200)
                                )
                        );

                        if (dragAndDropView.figuras.get(numberInt - 1).getX() + ((int)radio + 200) > ly.getHeight()){
                            dragAndDropView.figuras.set(numberInt - 1,
                                    new Circulo(
                                            dragAndDropView.figuras.size()+1,
                                            100,
                                            dragAndDropView.figuras.get(numberInt - 2).getY() + 100,
                                            ((int)radio + 200)
                                    )
                            );
                        }
                        dialog.dismiss();
                        ly.invalidate();
                    }
                });
                dialog.show();
                ly.invalidate();
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