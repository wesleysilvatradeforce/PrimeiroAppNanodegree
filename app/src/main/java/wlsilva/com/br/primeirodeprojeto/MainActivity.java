package wlsilva.com.br.primeirodeprojeto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import wlsilva.com.br.primeirodeprojeto.movies.MovieActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickItem(View view){
        Button mButton = (Button) view;

        switch (mButton.getId()){
            case R.id.filmes_popular:
                Intent intent = new Intent(MainActivity.this, MovieActivity.class);
                startActivity(intent);
                break;

            default:
                String texto = mButton.getText().toString();
                Toast.makeText(MainActivity.this, "This button will launch my "+texto+" app!", Toast.LENGTH_SHORT).show();
                break;
        }


    }
}
