package iam.deprest.pizzapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import iam.deprest.pizzapp.dialogs.ToppingsDialog;

import iam.deprest.pizzapp.dialogs.ToppingsDialog;

public class MainActivity extends AppCompatActivity {

    private Button btnSize, btnToppings;

    private View.OnClickListener toppingsOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ToppingsDialog toppingsDialog = new ToppingsDialog();
            toppingsDialog.setDialogConfirmListener(dialogConfirmListener);
            toppingsDialog.show(getSupportFragmentManager(), "id");
        }
    };

    private ToppingsDialog.DialogConfirmListener dialogConfirmListener = new ToppingsDialog.DialogConfirmListener() {
        @Override
        public void confirm(ArrayList<String> toppings) {
            Toast.makeText(getApplicationContext(), toppings.toString(), Toast.LENGTH_LONG);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnToppings = findViewById(R.id.btn_toppings);
        btnSize = findViewById(R.id.btn_size);
        btnToppings.setOnClickListener(toppingsOnClickListener);
    }
}
