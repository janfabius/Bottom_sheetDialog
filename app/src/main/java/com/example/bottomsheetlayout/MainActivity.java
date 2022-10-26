package com.example.bottomsheetlayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button_1, button_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //button che richiama la dialog
        button_1 = findViewById(R.id.button1);
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog_promo("2021","2022",10,"394,56 pz\n~ 2 ct","565,78 pz\n~ 5 ct","0.98","0.99");
            }
        });

        button_2 = findViewById(R.id.button2);
        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog_artLegati();
            }
        });



    }

    private void showDialog_artLegati() {

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottomsheetlayout_art_legati);

        ImageView image_close = dialog.findViewById(R.id.sh_close);

        image_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }

    private void showDialog_promo(String annoPrecedente, String annoCorrente, int mediaGG, String resMediaGG1, String resMediaGG2, String PrezzoMedio1, String PrezzoMedio2) {

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottomsheetlayout);

        ImageView image_close = dialog.findViewById(R.id.sh_close);
        TextView anno1 =  dialog.findViewById(R.id.textView_anno1);
        TextView anno2 =  dialog.findViewById(R.id.textView_anno2);
        TextView media_ris1 =  dialog.findViewById(R.id.textView_risMediaAnno1);
        TextView media_ris2 =  dialog.findViewById(R.id.textView_risMediaAnno2);
        TextView mediaGG1 =  dialog.findViewById(R.id.textView_mediaAnno1);
        TextView mediaGG2 =  dialog.findViewById(R.id.textView_mediaAnno2);
        TextView prezzoMedio1 =  dialog.findViewById(R.id.textView_prezzoMedioAnno1);
        TextView prezzoMedio2 =  dialog.findViewById(R.id.textView_prezzoMedioAnno2);

        TextView incremento =  dialog.findViewById(R.id.textView_incremento);

        anno1.setText(annoPrecedente);
        anno2.setText(annoCorrente);
        media_ris1.setText(resMediaGG1);
        media_ris2.setText(resMediaGG2);
        mediaGG1.setText("Media "+String.valueOf(mediaGG)+" giorni");
        mediaGG2.setText("Media "+String.valueOf(mediaGG)+" giorni");
        prezzoMedio1.setText("Prezzo medio: "+PrezzoMedio1);
        prezzoMedio2.setText("Prezzo medio: "+PrezzoMedio2);


        if(false){
            incremento.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_keyboard_double_arrow_up_24, 0, 0, 0);
        }else{
            incremento.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_keyboard_double_arrow_down_24, 0, 0, 0);
        }
        incremento.setText("- 15,32 %");


        image_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

    }
}