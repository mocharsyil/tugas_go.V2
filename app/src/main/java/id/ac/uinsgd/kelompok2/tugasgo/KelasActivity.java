package id.ac.uinsgd.kelompok2.tugasgo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import id.ac.uinsgd.kelompok2.tugasgologin.AkhlakActivity;
import id.ac.uinsgd.kelompok2.tugasgologin.BasdatActivity;
import id.ac.uinsgd.kelompok2.tugasgologin.PBO_Activity;
import id.ac.uinsgd.kelompok2.tugasgologin.PrakBasdatActivity;
import id.ac.uinsgd.kelompok2.tugasgologin.PrakPBO_Activity;
import id.ac.uinsgd.kelompok2.tugasgologin.ProbstatActivity;
import id.ac.uinsgd.kelompok2.tugasgologin.R;
import id.ac.uinsgd.kelompok2.tugasgologin.RPL_Activity;
import id.ac.uinsgd.kelompok2.tugasgologin.StratAlgoActivity;

public class KelasActivity extends AppCompatActivity {
    private Button Basdat;
    private Button PrakBasdat;
    private Button RPL;
    private Button Akhlak;
    private Button PBO;
    private Button PrakPBO;
    private Button StratAlgo;
    private Button Probstat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelas);

        Basdat = (Button) findViewById(R.id.Basdat);
        Basdat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BasdatActivity();
            }
        });

        PrakBasdat = (Button) findViewById(R.id.PrakBasdat);
        PrakBasdat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrakBasdatActivity();
            }
        });

        RPL = (Button) findViewById(R.id.RPL);
        RPL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               RPL_Activity();
            }
        });

        Akhlak = (Button) findViewById(R.id.Akhlak);
        Akhlak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AkhlakActivity();
            }
        });

        PBO = (Button) findViewById(R.id.PBO);
        PBO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PBO_Activity();
            }
        });

        PrakPBO = (Button) findViewById(R.id.PrakPBO);
        PrakPBO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrakPBO_Activity();
            }
        });

        StratAlgo = (Button) findViewById(R.id.StratAlgo);
        StratAlgo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StratAlgoActivity();
            }
        });

        Probstat = (Button) findViewById(R.id.Probstat);
        Probstat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProbstatActivity();
            }
        });



    }

    public void BasdatActivity(){
        Intent intent = new Intent(this, BasdatActivity.class);
        startActivity(intent);
    }

    public void PrakBasdatActivity(){
        Intent intent = new Intent(this, PrakBasdatActivity.class);
        startActivity(intent);
    }

    public void RPL_Activity(){
        Intent intent = new Intent(this, RPL_Activity.class);
        startActivity(intent);
    }

    public void AkhlakActivity(){
        Intent intent = new Intent(this, AkhlakActivity.class);
        startActivity(intent);
    }

    public void PBO_Activity(){
        Intent intent = new Intent(this, PBO_Activity.class);
        startActivity(intent);
    }

    public void PrakPBO_Activity(){
        Intent intent = new Intent(this, PrakPBO_Activity.class);
        startActivity(intent);
    }

    public void StratAlgoActivity(){
        Intent intent = new Intent(this, StratAlgoActivity.class);
        startActivity(intent);
    }

    public void ProbstatActivity(){
        Intent intent = new Intent(this, ProbstatActivity.class);
        startActivity(intent);
    }


}