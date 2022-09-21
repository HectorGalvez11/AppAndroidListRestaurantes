package com.android.example.recyclerview1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.android.example.recyclerview1.databinding.FragmentItemBinding;
import com.bumptech.glide.Glide;

import java.util.List;

public class MyRestauranteRecyclerViewAdapter extends RecyclerView.Adapter<MyRestauranteRecyclerViewAdapter.ViewHolder> {
    private Context ctx;
    private final List<Restaurante> mValues;

    public MyRestauranteRecyclerViewAdapter(Context context,List<Restaurante> items) {
        ctx = context;
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.texViewNombreRestaurante.setText(holder.mItem.getNombre());
        holder.texViewDireccionRestaurante.setText(holder.mItem.getDireccion());
        holder.ratingBarValoracionRestaurante.setRating(holder.mItem.getValoracion());

        Glide.with(ctx)
                .load(holder.mItem.getUrlPhoto())
                .centerCrop()
                .into(holder.imagenViewPhotoRestaurante);

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView texViewNombreRestaurante;
        public final TextView texViewDireccionRestaurante;
        public final ImageView imagenViewPhotoRestaurante;
        public final RatingBar ratingBarValoracionRestaurante;
        public Restaurante mItem;

        public ViewHolder(FragmentItemBinding binding) {
            super(binding.getRoot());
            texViewNombreRestaurante = binding.textViewNombre;
            texViewDireccionRestaurante = binding.textViewDireccion;
            imagenViewPhotoRestaurante = binding.imageViewPhoto;
            ratingBarValoracionRestaurante = binding.raitingBarValoracion;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + texViewNombreRestaurante.getText() + "'";
        }
    }
}