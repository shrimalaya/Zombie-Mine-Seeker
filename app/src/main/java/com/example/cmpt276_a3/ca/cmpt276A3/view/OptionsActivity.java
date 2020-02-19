package com.example.cmpt276_a3.ca.cmpt276A3.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.cmpt276_a3.ca.cmpt276A3.model.Mine;
import com.example.cmpt276_a3.ca.cmpt276A3.model.MineManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

import com.example.cmpt276_a3.R;

public class OptionsActivity extends AppCompatActivity {

    private MineManager manager = MineManager.getInstance();

    private static final String EXTRA_MESSAGE = "Extra";

    public static Intent makeLaunchIntent(Context c, String message) {
        Intent intent = new Intent(c, OptionsActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recordPreferences();
    }

    private void recordPreferences() {
        Button radioSize;
        Button radioMines;

    }

}
