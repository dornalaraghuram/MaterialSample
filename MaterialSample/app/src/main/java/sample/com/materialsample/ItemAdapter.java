package sample.com.materialsample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Raghuram on 17/04/2015.
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder>{

    private final LayoutInflater mInflater;
    private List<Information> items = Collections.EMPTY_LIST;
//    private ItemClickListneter itemClickListneter;

    public ItemAdapter(Context context, List<Information> items) {
        mInflater = LayoutInflater.from(context);
        this.items = items;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.custom_row, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Information current = items.get(position);
        holder.txtView.setText(current.getTitle());
        holder.image.setImageResource(current.getId());

    }



    @Override
    public int getItemCount() {
        return items.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView image;
        TextView txtView;

        public MyViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.img_view);
            txtView = (TextView) itemView.findViewById(R.id.my_title);
//            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
//            delete(getPosition());
//            if(itemClickListneter!=null) {
//                itemClickListneter.itemClicked(v, getPosition());
//            }
        }
    }

    private void delete(int position) {
        items.remove(position);
        notifyItemRemoved(position);
    }


}
