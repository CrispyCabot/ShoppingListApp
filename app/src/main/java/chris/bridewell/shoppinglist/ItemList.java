package chris.bridewell.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ItemList extends AppCompatActivity {

    public static final String EXTRA_TEXT = "chris.bridewell.shoppinglist.extra.Text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
    }

    public void returnItem(View view) {
        String text = "";
        Button btn = (Button)view;
        text = btn.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_TEXT, text);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}