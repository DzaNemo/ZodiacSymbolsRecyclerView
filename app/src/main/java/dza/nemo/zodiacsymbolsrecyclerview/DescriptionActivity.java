package dza.nemo.zodiacsymbolsrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DescriptionActivity extends AppCompatActivity {

    TextView nameTvDescription, dateTvDesc,descriptionTv;
    ImageView imageDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        // It is better to use parcelable

        // TODO insert description

        String name = getIntent().getStringExtra("Name");
        String date = getIntent().getStringExtra("Date");
        String description = getIntent().getStringExtra("Description");
        int image = getIntent().getIntExtra("Image",0);


        nameTvDescription = findViewById(R.id.textView_descName);
        dateTvDesc = findViewById(R.id.textView_descDate);
        descriptionTv = findViewById(R.id.textView_description);
        imageDescription =  findViewById(R.id.imageView_description);


        nameTvDescription.setText(name);
        dateTvDesc.setText(date);
        descriptionTv.setText(description);
        imageDescription.setImageResource(image);


    }
}