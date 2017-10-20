package csitmnr.sqlitedatabaseexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button search,add,delete,update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        search = (Button) findViewById(R.id.btnSearch);
        add = (Button) findViewById(R.id.btnAdd);
        delete = (Button) findViewById(R.id.btnDelete);
        update = (Button) findViewById(R.id.btnUpdate);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AddData.class);
                startActivity(intent);
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SearchData.class);
                startActivity(intent);
            }
        });
    }
}
