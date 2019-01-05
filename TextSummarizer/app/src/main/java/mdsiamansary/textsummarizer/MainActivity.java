package mdsiamansary.textsummarizer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button aboutButton, clearButton, summaButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aboutButton = (Button)findViewById(R.id.button03);
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getApplicationContext(), About_Activity.class);
                startActivity(intent);
            }
        });

        summaButton = (Button)findViewById(R.id.button01);
        summaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edit = (EditText)findViewById(R.id.article);
                TextView tview = (TextView)findViewById(R.id.article2);

                String result = edit.getText().toString();
                String result1 = null;
                try {

                    Summarizer obj = new Summarizer();

                    result1 = obj.Summarize(result,5);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                tview.setText(result1);
            }
        });

        clearButton = (Button)findViewById(R.id.button02);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edit = (EditText)findViewById(R.id.article);
                TextView tview = (TextView)findViewById(R.id.article2);
                edit.getText().clear();
                tview.setText("");

            }
        });
    }


    public void onBackPressed(){
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }
}
