package kibs.mcm.edu.ph.bsaub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn1);
        button.setOnClickListener(this);

    }
    @Override
    public void onClick(View arg0) {

        // Start NewActivity.class
        Intent myIntent = new Intent(this, QrCodeScannerActivity.class);
        startActivity(myIntent);


    }

}
