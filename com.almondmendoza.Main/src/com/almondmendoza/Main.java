package com.almondmendoza;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.almondmendoza.drawings.DrawingActivity;

public class Main extends Activity
{
    /** Called when the activity is first created. */
    private EditText e ;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.drawBtn:
		e = (EditText)findViewById(R.id.editText1);
                DrawingActivity.serverAddr = new String(e.getText().toString());          
                Intent drawIntent = new Intent(this, DrawingActivity.class);
                startActivity( drawIntent);
                break;
        }
    }
}
