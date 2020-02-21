package com.example.cmpt276_a3;

import android.content.Intent;
import android.os.Bundle;

import com.example.cmpt276_a3.ca.cmpt276A3.model.Mine;
import com.example.cmpt276_a3.ca.cmpt276A3.model.MineManager;
import com.example.cmpt276_a3.ca.cmpt276A3.view.GameActivity;
import com.example.cmpt276_a3.ca.cmpt276A3.view.HelpActivity;
import com.example.cmpt276_a3.ca.cmpt276A3.view.OptionsActivity;
import com.example.cmpt276_a3.ca.cmpt276A3.view.WelcomeActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        launchWelcomeActivity();
        playGame();

        ImageView image = findViewById(R.id.imgMainMenu);
        image.setImageResource(R.drawable.main_logo);

        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    private void launchWelcomeActivity() {
        Intent intent = WelcomeActivity.makeLaunchIntent(MainActivity.this, "Welcome");
        startActivity(intent);
    }

    private void playGame() {
        Button button  = findViewById(R.id.btnStart);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = GameActivity.makeLaunchIntent(MainActivity.this, "Game");
                startActivity(intent);
            }
        });
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
        switch(item.getItemId()) {
            case(R.id.main_Options):
                Intent i1 = OptionsActivity.makeLaunchIntent(MainActivity.this, "Options");
                startActivityForResult(i1, 31);
                return true;
            case(R.id.main_Help):
                Intent i2 = HelpActivity.makeLaunchIntent(MainActivity.this, "Help");
                startActivityForResult(i2, 33);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
