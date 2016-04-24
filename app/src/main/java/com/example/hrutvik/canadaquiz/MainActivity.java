package com.example.hrutvik.canadaquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button TrueBtn; //widgets
    private Button FalseBtn;
    private Button NextQuestionBtn;
    private TextView QuestionTextView;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //class that gets made as the app is made //same name same parameters and inheritance
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        QuestionTextView= (TextView) findViewById(R.id.QuestionTextView);
        TrueBtn= (Button) findViewById(R.id.TrueBtn); //originally it's a view widget so we need to cast it as a btn, reference to btn
        FalseBtn= (Button) findViewById(R.id.FalseBtn);
        NextQuestionBtn= (Button) findViewById(R.id.NextQuestionBtn);

        String Question1= "Canada is the 2nd largest country in the world";
        String Question2= "Canada borders Mexico";

        final String [] Questions= {Question1,Question2};

        TrueBtn.setOnClickListener(new View.OnClickListener() { //wait for button to be clicked
            @Override
            public void onClick(View view) { //interface, passing new view onclicklist as parameter
                if(count==2){
                    Toast.makeText(MainActivity.this,R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show(); //message popup writing
                }
            }
        });

        FalseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count==2){
                    Toast.makeText(MainActivity.this,R.string.correct_toast,Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();

                }
            }
        });

        NextQuestionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count==2){
                    NextQuestionBtn.setEnabled(false);
                    //
                }
                else {
                    QuestionTextView.setText(Questions[count]);
                    count++;
                }
            }
        });


    }

    //other classes made by android studio
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
//gotem
