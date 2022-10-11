package dza.nemo.zodiacsymbolsrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface{

    // created models are stored in the array
    ArrayList<ZodiacModel> zodiacModels = new ArrayList<>();

    // array list for the images that are used in the app (12 images for zodiacs put in array in correct order like a names in name array)
    int[] zodiacImages = {R.drawable.ic_capricorn,R.drawable.ic_aquarius,R.drawable.ic_pisces,
            R.drawable.ic_aries,R.drawable.ic_taurus,R.drawable.ic_gemini,R.drawable.ic_cancer,
            R.drawable.ic_leo,R.drawable.ic_virgo,R.drawable.ic_libra,R.drawable.ic_scorpio,
            R.drawable.ic_sagittarius

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // recycler view generate enough items to fit on user screen, when user scrolling views are recycled and used again with new data
        RecyclerView recyclerView = findViewById(R.id.zodiac_RecyclerView);

        setUpZodiacModels();

        // CREATE THE ADAPTER AFTER SETUP MODELS (setting up adapter before creating models , empty array list is passing and nothing will show up)

        // creating adapter
        ZodiacRecyclerViewAdapter adapter = new ZodiacRecyclerViewAdapter(this, zodiacModels, this);
        // attach adapter to recycler view
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }


    // create models for each item
    private void setUpZodiacModels(){
        // pull names from string array
        String[] zodiacNames = getResources().getStringArray(R.array.zodiac_name);
        // pull dates from string array
        String[] zodiacDates = getResources().getStringArray(R.array.zodiac_dates);

        String[] zodiacDescription = getResources().getStringArray(R.array.zodiac_description);


        // loop through the each arrays and create model class and store them in array list
        for (int i = 0; i < zodiacNames.length; i++){
            zodiacModels.add(new ZodiacModel(zodiacNames[i], zodiacDates[i],
                    zodiacDescription[i],zodiacImages[i]));
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MainActivity.this, DescriptionActivity.class);

        intent.putExtra("Name",zodiacModels.get(position).getZodiacName());
        intent.putExtra("Date",zodiacModels.get(position).getZodiacDate());
        intent.putExtra("Description", zodiacModels.get(position).getZodiacDescription());
        intent.putExtra("Image",zodiacModels.get(position).getImage());

        startActivity(intent);
    }
}