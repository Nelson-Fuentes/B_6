package com.example.nelson.women;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

public class Index extends AppCompatActivity {
VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        //videoView= (VideoView) findViewById(R.id.videoView3);
        //Uri uri= Uri.parse(R.drawable.vi);

    }
    public void login (View view){
        Intent i= new Intent(this,LoginActivity.class);
        startActivity(i);
    }
    public void Registrarse(View view){
        Intent i= new Intent(this,Registrarse.class);
        startActivity(i);
    }
}
