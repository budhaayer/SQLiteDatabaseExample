package csitmnr.sqlitedatabaseexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddData extends AppCompatActivity {
    EditText name , phone, email;
    Button save;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        dbHelper = new DBHelper(this);

        name = (EditText) findViewById(R.id.etName);
        phone = (EditText) findViewById(R.id.etPhone);
        email = (EditText) findViewById(R.id.etEmail);
        save = (Button) findViewById(R.id.saveButton);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean result = dbHelper.insertData(name.getText().toString(),phone.getText().toString(),email.getText().toString());
                    if (result){
                        Toast.makeText(AddData.this, "Data is inserted", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(AddData.this, "Data is not inserted", Toast.LENGTH_SHORT).show();
                    }
            }
        });
    }
}
