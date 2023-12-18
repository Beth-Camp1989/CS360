package com.example.weighttracking_beth_campbell;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;

public class DataDisplayActivity extends AppCompatActivity {

    private GridView gridViewData;
    private Button btnAddData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_display);

        gridViewData = findViewById(R.id.gridViewData);
        btnAddData = findViewById(R.id.btnAddData);

        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Implement add data logic in Project Three
            }
        });
    }
}
