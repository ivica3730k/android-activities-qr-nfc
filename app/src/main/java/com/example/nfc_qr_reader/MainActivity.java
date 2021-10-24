package com.example.nfc_qr_reader;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView infoText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.infoText = (TextView) findViewById(R.id.infoText);
    }

    public void on_scanNfcButton_clicked(View view) {
        Intent nfcReadIntent = new Intent(this, NfcReader.class);
        startActivityForResult(nfcReadIntent, 100);
        //startActivity(this.nfcReadIntent);
        //this.infoText.setText(nfcReadIntent.getStringExtra("ID_HEX"));
    }

    public void on_scanQrCodeButton_clicked(View view) {
        Intent nfcReadIntent = new Intent(this, QrReader.class);
        startActivityForResult(nfcReadIntent, 101);
        //startActivity(this.nfcReadIntent);
        //this.infoText.setText(nfcReadIntent.getStringExtra("ID_HEX"));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // check that it is the SecondActivity with an OK result
        if (requestCode == 100) {
            if (resultCode == RESULT_OK) {

                // get String data from Intent
                //String returnString = data.getStringExtra(Intent.EXTRA_TEXT);

                // set text view with string
                //TextView textView = (TextView) findViewById(R.id.textView);
                //textView.setText(returnString);
                this.infoText.setText(data.getStringExtra("ID_HEX"));
            }
        }
        if (requestCode == 101) {
            if (resultCode == RESULT_OK) {

                // get String data from Intent
                //String returnString = data.getStringExtra(Intent.EXTRA_TEXT);

                // set text view with string
                //TextView textView = (TextView) findViewById(R.id.textView);
                //textView.setText(returnString);
                this.infoText.setText(data.getStringExtra("QR_TEXT"));
            }
        }
    }
}