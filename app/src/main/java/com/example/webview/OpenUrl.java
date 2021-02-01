package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OpenUrl extends AppCompatActivity {

    private EditText input;
    private Button load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_url);
        input=findViewById(R.id.input);
        load=findViewById(R.id.load);
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String URL=input.getText().toString();

                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(URL));
                Intent chooser=Intent.createChooser(intent, "choose one");
                if (intent.resolveActivity(getPackageManager())!=null) {
                    startActivity(chooser);
                }
                }
        });
    }
}