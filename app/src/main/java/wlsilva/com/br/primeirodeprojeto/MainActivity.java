package wlsilva.com.br.primeirodeprojeto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickItem(View view){
        Button mButton = (Button) view;
        String texto = mButton.getText().toString();
        Toast.makeText(MainActivity.this, "This button will launch my "+texto+" app!", Toast.LENGTH_SHORT).show();
    }
}
