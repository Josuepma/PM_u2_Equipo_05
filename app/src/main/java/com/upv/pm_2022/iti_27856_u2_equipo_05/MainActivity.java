package com.upv.pm_2022.iti_27856_u2_equipo_05;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

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
}