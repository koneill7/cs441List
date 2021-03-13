package com.example.cs441list;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.content.Context;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private TableLayout table;
    private ArrayList<TableRow> tableRowList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tableRowList = new ArrayList<>();
        table = (TableLayout) findViewById(R.id.table_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    public void addRow(View view){
        //Context context;
        EditText edit = findViewById(R.id.user_input);
        //View view = this.getWindow().getDecorView();
        final EditText[] userText = new EditText[1];
        TableRow tableRow;
        tableRow = new TableRow(this);
        TextView text = new TextView( this);
        String store = "Nothing entered.";
        userText[0] = (EditText)findViewById(R.id.user_input);
        store = userText[0].getText().toString();
        text.setText(store);
        tableRow.addView(text, 0);


        Button button = new Button(this);
        button.setText("X");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                table.removeView(tableRow);
                tableRowList.remove(tableRow);

            }
        });

        tableRow.addView(button, 1);
        table.addView(tableRow);
        tableRowList.add(tableRow);

    }
    public void removeRow(View view){
        TableRow row = tableRowList.remove(0);
        table.removeView(row);
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
}