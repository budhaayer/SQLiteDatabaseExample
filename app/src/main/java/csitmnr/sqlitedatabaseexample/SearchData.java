package csitmnr.sqlitedatabaseexample;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SearchData extends AppCompatActivity {
    EditText ph_search;
    Button btnSearch;
    TextView name,email;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_data);

        dbHelper = new DBHelper(this);
        ph_search = (EditText) findViewById(R.id.search_data);
        btnSearch = (Button) findViewById(R.id.search_button);
        name = (TextView) findViewById(R.id.tv_name);
        email = (TextView) findViewById(R.id.tv_email);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor cursor = dbHelper.searchData(ph_search.getText().toString());

                while (cursor.moveToNext()){
                    name.setText(cursor.getString(1));
                    email.setText(cursor.getString(3));
                }
            }
        });
    }
}
