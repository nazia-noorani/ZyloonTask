package nazianoorani.zyloontask.adapter;

/**
 * Created by nazianoorani on 26/03/16.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import nazianoorani.zyloontask.DetailsActivity;
import nazianoorani.zyloontask.R;
import nazianoorani.zyloontask.dto.ItemDetailDto;


/**
 ** Created by nazianoorani on 23/12/15.
 */
public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    ArrayList<ItemDetailDto> itemList = new ArrayList<>();
    Context context;
    public CardAdapter(Context context) {
        this.context = context;
        ItemDetailDto itemDetailDto = new ItemDetailDto();
        itemDetailDto.setItemName("Mac Satin Lipstick");
        itemDetailDto.setItemImage(R.drawable.img_1);
        itemDetailDto.setItemRating(1.0);
        itemList.add(itemDetailDto);

        itemDetailDto = new ItemDetailDto();
        itemDetailDto.setItemName("Mac Cherry Red Lipstick");
        itemDetailDto.setItemImage(R.drawable.img_2);
        itemDetailDto.setItemRating(2.4);
        itemList.add(itemDetailDto);

        itemDetailDto = new ItemDetailDto();
        itemDetailDto.setItemName("Mac Crimson Red Lipstick");
        itemDetailDto.setItemImage(R.drawable.img_3);
        itemDetailDto.setItemRating(3.2);
        itemList.add(itemDetailDto);

        itemDetailDto = new ItemDetailDto();
        itemDetailDto.setItemName("Mac Mauve Lipstick");
        itemDetailDto.setItemImage(R.drawable.img_4);
        itemDetailDto.setItemRating(4.4);
        itemList.add(itemDetailDto);

        itemDetailDto = new ItemDetailDto();
        itemDetailDto.setItemName("Mac Orange Lipstick");
        itemDetailDto.setItemImage(R.drawable.img_5jpg);
        itemDetailDto.setItemRating(5.0);
        itemList.add(itemDetailDto);


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ItemDetailDto itemDetailDto = itemList.get(position);
        holder.itemNameTextView.setText(itemDetailDto.getItemName());
        holder.itemImgView.setImageResource(itemDetailDto.getItemImage());
        holder.itemRatingTextView.setText(String.valueOf(itemDetailDto.getItemRating()));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.txt_item_name)
        TextView itemNameTextView;
        @InjectView(R.id.txt_item_rating)
        TextView itemRatingTextView;
        @InjectView(R.id.img)
        ImageView itemImgView;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this,itemView);
        }
        @OnClick(R.id.ll)
        void transfer(){
            Intent intent = new Intent(context, DetailsActivity.class);
            intent.putExtra("itemDto",itemList.get(getLayoutPosition()));
            context.startActivity(intent);
        }

    }


}