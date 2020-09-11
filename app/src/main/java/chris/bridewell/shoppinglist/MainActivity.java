package chris.bridewell.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int TEXT_REQUEST = 1;
    private int currTextView = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            LinearLayout layout = findViewById(R.id.linearLayout);
            for (int i=0; i<10; i++) {
                TextView v = (TextView)layout.getChildAt(i);
                v.setText(savedInstanceState.getString("text_"+i));
            }
        }
    }

    public void launchSecondActivity(View view) {
        Intent intent = new Intent(this, ItemList.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        LinearLayout layout = findViewById(R.id.linearLayout);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String item = data.getStringExtra(ItemList.EXTRA_TEXT);
                TextView view = (TextView)layout.getChildAt(currTextView);
                currTextView++;
                view.setText(item);
            }
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        LinearLayout layout = findViewById(R.id.linearLayout);
        for (int i=0; i<10; i++) {
            TextView v = (TextView)layout.getChildAt(i);
            outState.putString("text_"+i, v.getText().toString());
        }
    }
}