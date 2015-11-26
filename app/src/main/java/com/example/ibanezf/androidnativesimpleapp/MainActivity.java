package com.example.ibanezf.androidnativesimpleapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    TextView factLabel;
    Button showfactButton;
    RelativeLayout layout;
    private MainContentActivity cm = new MainContentActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        factLabel = (TextView) findViewById(R.id.txtFactView);
        layout = (RelativeLayout) findViewById(R.id.mainContentId);
        showfactButton = (Button)findViewById(R.id.btnAnotherFact);
        showfactButton.setOnClickListener(handleClick);

        String message = "Oh Yeah, using TAG version!";
        //Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        Log.d(TAG, message);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private OnClickListener handleClick = new OnClickListener() {

        public void onClick(View v) {
            int color = Color.parseColor(cm.getColor());
            layout.setBackgroundColor(color);
            showfactButton.setTextColor(color);
            factLabel.setText(cm.getFact());
        }


    };

}
