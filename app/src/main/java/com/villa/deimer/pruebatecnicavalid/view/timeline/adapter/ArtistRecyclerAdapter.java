package com.villa.deimer.pruebatecnicavalid.view.timeline.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.squareup.picasso.Picasso;
import com.villa.deimer.pruebatecnicavalid.R;
import com.villa.deimer.pruebatecnicavalid.model.entities.Artist;
import com.villa.deimer.pruebatecnicavalid.model.entities.ImageItem;
import com.villa.deimer.pruebatecnicavalid.view.details.DetailActivity;

import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

@SuppressLint("SetTextI18n")
public class ArtistRecyclerAdapter extends RecyclerView.Adapter<ArtistRecyclerAdapter.AdapterView> {

    private Context context;
    private List<Artist> artists;

    public ArtistRecyclerAdapter(Context context, List<Artist> artists) {
        this.context = context;
        this.artists = artists;
    }

    @NonNull
    @Override
    public AdapterView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_card_item, parent, false);
        return new AdapterView(layoutView);
    }

    public int getItemCount() {
        return artists.size();
    }

    class AdapterView extends RecyclerView.ViewHolder {
        @BindView(R.id.card_item)
        CardView cardItem;
        @BindView(R.id.img_item)
        ImageView imgItem;
        @BindView(R.id.lbl_name)
        TextView lblName;
        @BindView(R.id.lbl_listeners)
        TextView lbl_listeners;
        AdapterView(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterView holder, int position) {
        Artist artist = artists.get(position);
        setImageItem(holder, artist);
        setLabels(holder, artist);
        animateRecycler(holder);
        clickOpenDetailsItem(holder, artist);
    }

    private void setImageItem(AdapterView holder, Artist artist) {
        String path = pathImageLarge(artist.getImages());
        Picasso.with(context)
                .load(path)
                .placeholder(R.drawable.ic_radio_primary)
                .error(R.drawable.ic_radio_primary)
                .fit()
                .into(holder.imgItem);
    }

    private String pathImageLarge(List<ImageItem> images) {
        String path = "";
        for (int i = 0; i < images.size(); i++) {
            ImageItem image = images.get(i);
            if(image.getSize().equalsIgnoreCase("large")) {
                path = image.getUrl();
                break;
            }
        }
        return path;
    }

    private void setLabels(AdapterView holder, Artist artist) {
        holder.lblName.setText(artist.getName());
        holder.lbl_listeners.setText("Oyentes: " + artist.getListeners());
    }

    private void clickOpenDetailsItem(AdapterView holder, final Artist artist) {
        holder.cardItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("mbid", artist.getMbid());
                intent.putExtra("isArtist", true);
                intent.putExtra("title", artist.getName());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    private void animateRecycler(AdapterView holder) {
        YoYo.with(Techniques.FadeInUp)
                .duration(700)
                .playOn(holder.cardItem);
    }

}
