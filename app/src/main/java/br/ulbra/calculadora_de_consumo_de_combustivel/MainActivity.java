package br.ulbra.calculadora_de_consumo_de_combustivel;

import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    EditText edNome, edPlaca, edDistanPerco, edConsmoMedio, edPrecoCom;



    Button btCalcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        edNome = findViewById(R.id.edtCarro);
        edPlaca = findViewById(R.id.edtPlaca);
        edDistanPerco = findViewById(R.id.edtDistancia);
        edConsmoMedio = findViewById(R.id.edtConsumo);
        edPrecoCom = findViewById(R.id.edtPreco);
        btCalcular = findViewById(R.id.btnCalcular);
        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double consumoMedio , precoLT, combustivelNeces, custoDaViagem;
                int distanciaPerco;
                String res;

                // Primeiro if para ver se tem algo em branco

                if(edNome.getText().toString().isEmpty() || edPlaca.getText().toString().isEmpty() || edDistanPerco.getText().toString().isEmpty() ||
                edPrecoCom.getText().toString().isEmpty() || edConsmoMedio.getText().toString().isEmpty() ) {
                    Toast.makeText(MainActivity.this, "Não pode Conter campos em branco", Toast.LENGTH_SHORT).show();
                }

                //Segundo if é para ver se tem algun numero menor ou igual a zero

                else if (Double.parseDouble(edConsmoMedio.getText().toString()) <= 0 || Double.parseDouble(edPrecoCom.getText().toString()) <=0
                ||Integer.parseInt(edDistanPerco.getText().toString()) <= 0) {

                    Toast.makeText(MainActivity.this, "Os números tem que ser maior que zero", Toast.LENGTH_SHORT).show();
                }
                //Terceiro if é para comferir se a placa não tem sete characters
                else if(!(edPlaca.getText().toString().length() == 7)) {
                    Toast.makeText(MainActivity.this, "A placa tem que ter sete characteres", Toast.LENGTH_SHORT).show();
                }else{
                    consumoMedio = Double.parseDouble(edConsmoMedio.getText().toString());
                    precoLT = Double.parseDouble(edPrecoCom.getText().toString());
                    distanciaPerco = Integer.parseInt(edDistanPerco.getText().toString());

//Calculos

                    combustivelNeces = distanciaPerco / consumoMedio;
                    custoDaViagem = combustivelNeces * precoLT;
                    DecimalFormat df = new DecimalFormat("0.00");

//Sring para a vizualizar

                    res = "\nVeículo:" + edNome.getText() +
                            "\nPlaca:" + edPlaca.getText() +
                            "\nCombustível necessário:" + df.format(combustivelNeces)+
                            "\nCusto da viagem: R$" + df.format(custoDaViagem);

//Menu pop-pup que mostra o resultado
                    AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
                    dialogo.setTitle("Resultado");
                    dialogo.setMessage(res);
                    dialogo.setNeutralButton("OK", null);
                    dialogo.show();

                }
            }
        });
    }
}