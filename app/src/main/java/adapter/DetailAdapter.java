package adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import iterator.WeatherDetail;
import models.DetailModels.ExtraDeail;

public class DetailAdapter extends
        RecyclerView.Adapter<DetailAdapter.ViewHolder>{

    private List<ExtraDeail> details;
    private Context context;
    //private void clickListener(ListModel listModel);
    //private Context context;


    public DetailAdapter(List<ExtraDeail> taskList){
        this.details = taskList;
    }

    /*public void setOnClickDeleteItem((ItemModel -> Unit) callback) {
        this.onClickDeleteItem = callback;
    } */

    protected class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView identification;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            identification = (TextView) itemView.findViewById(R.id.itemTitle);


        }

        public void selectedItem(int pos){

        }
    }

    @NonNull
    @Override
    public DetailAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.detail_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DetailAdapter.ViewHolder holder, int position) {

        ExtraDeail extraDeail = details.get(position);

        //Cart model = listModelList.get(position);


        holder.identification.setText(extraDeail.getDetailName());
    }

    @Override
    public int getItemCount() {
        return details.size();
    }
}
