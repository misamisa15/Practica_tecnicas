package com.example.reloj_digital;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView txtH;
    TextView txtM;
    TextView txtS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtH = findViewById(R.id.hora);
        txtM = findViewById(R.id.minuto);
        txtS = findViewById(R.id.segundo);

        relojInicio();
    }

    /*HOLA ESTO ES UN COMENTARIO*/
    /*VERSION 1 PRACTICA DE TECNICAS*/
    private void relojInicio() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int hora = 0;
                int minuto = 0;
                int segundo = 0;

                while (hora < 24) {
                    while (minuto < 60) {
                        while (segundo < 60) {
                            int finalHora = hora;
                            int finalMinuto = minuto;
                            int finalSegundo = segundo;
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    txtH.setText(String.format("%02d", finalHora));
                                    txtM.setText(String.format("%02d", finalMinuto));
                                    txtS.setText(String.format("%02d", finalSegundo));
                                }
                            });

                            segundo++;
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        segundo = 0;
                        minuto++;
                    }
                    minuto = 0;
                    hora++;
                }
            }
        });
        thread.start();
    }
}