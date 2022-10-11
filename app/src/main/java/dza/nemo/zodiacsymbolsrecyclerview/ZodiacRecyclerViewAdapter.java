package dza.nemo.zodiacsymbolsrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// need to create adapter class for recycler view

public class ZodiacRecyclerViewAdapter extends RecyclerView.Adapter<ZodiacRecyclerViewAdapter.MyViewHolder> {

    // variable that hold recyclerview interface
    private final RecyclerViewInterface recyclerViewInterface;

    // variables
    Context context; // need for inflating layout
    ArrayList<ZodiacModel> zodiacModels; // array list that hold models

    // constructor to get values for the variables
    public ZodiacRecyclerViewAdapter(Context context,
                                     ArrayList<ZodiacModel> zodiacModels, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.zodiacModels = zodiacModels;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public ZodiacRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // this is where we inflate the layout (giving a look to out rows)

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.zodiac_row,parent,false);


        return new ZodiacRecyclerViewAdapter.MyViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull ZodiacRecyclerViewAdapter.MyViewHolder holder, int position) {
        // assigning values to the views we created in the zodiac_row layout file
        // based on the position of the recycler view

        holder.tvName.setText(zodiacModels.get(position).getZodiacName());
        holder.tvDate.setText(zodiacModels.get(position).getZodiacDate());
        holder.imageView.setImageResource(zodiacModels.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        // number of displayed items
        return zodiacModels.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // grabbing the views from zodiac_row layout file and assigned them to the variables (imageView, tvName, tvDate)

        ImageView imageView;
        TextView tvName, tvDate;

        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            tvName = itemView.findViewById(R.id.textView);
            tvDate = itemView.findViewById(R.id.textView2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewInterface != null){
                        int position = getAdapterPosition();

                        if (position != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
