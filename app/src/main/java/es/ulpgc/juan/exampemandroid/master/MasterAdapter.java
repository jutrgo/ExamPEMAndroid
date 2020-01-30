package es.ulpgc.juan.exampemandroid.master;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import es.ulpgc.juan.exampemandroid.R;
import es.ulpgc.juan.exampemandroid.model.Usuario;

public class MasterAdapter extends RecyclerView.Adapter<MasterAdapter.ViewHolder> {

  private List<Usuario> usuarioList;
  private final View.OnClickListener listener;

  public MasterAdapter(View.OnClickListener listener) {
    this.usuarioList = new ArrayList<>();
    this.listener = listener;
  }

  public void addItem(Usuario usuario) {
    usuarioList.add(usuario);
    notifyDataSetChanged();
  }

  public void addItems(List<Usuario> usuarioList) {
    this.usuarioList.addAll(usuarioList);
    notifyDataSetChanged();
  }

  public void setItems(List<Usuario> usuarioList) {
    this.usuarioList = usuarioList;
    notifyDataSetChanged();
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int position) {
    View view = LayoutInflater.from(parent.getContext()).
        inflate(R.layout.person_item, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, final int position) {
    // Setting a tag and a listener in order to know who was clicked
    holder.itemView.setTag(usuarioList.get(position));
    holder.itemView.setOnClickListener(listener);

    // Each item of the list or cell, has these attributes
    holder.personFullnameView.setText(usuarioList.get(position).getNombre() + " " + usuarioList.get(position).getApellidos() );
    holder.personAgeView.setText(String.valueOf(usuarioList.get(position).getEdad()));

    /*
    String stars = "";
    int nStars = usuarioList.get(position).getRating();
    for(int i = 0; i < nStars; i++) {
      stars += "*";
    }
   */

    holder.personRatingView.setText(String.valueOf(usuarioList.get(position).getValoracion())); // : CAMBIO A RATING

    // Each item has a default image that is downloaded from the internet by url
   // loadImageFromURL(holder.imageView, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQJcKgk5kFmglQsOLKNrkp1oEC0e33KjNSaG_njjfk1NvhpyG0r&s"); // TODO: poner el de cada uno
  }

  @Override
  public int getItemCount() {
    return usuarioList.size();
  }

  class ViewHolder extends RecyclerView.ViewHolder {

    final TextView personFullnameView, personAgeView, personRatingView;
    // final ImageView imageView;

    public ViewHolder(View view) {
      super(view);
      personFullnameView = view.findViewById(R.id.fullName);
      personAgeView = view.findViewById(R.id.edad);
      personRatingView = view.findViewById(R.id.valoracion); // NO LO HE CAMBIADO POR PROBLEMAS CON EL IDE
    //  imageView = view.findViewById(R.id.image);
    }
  }

  /**
   * Load an image from an URL
   *
   * @param imageView image where it is saved
   * @param imageUrl  image's URL
   */
  private void loadImageFromURL(ImageView imageView, String imageUrl) {
    RequestManager reqManager = Glide.with(imageView.getContext());
    RequestBuilder reqBuilder = reqManager.load(imageUrl);
    RequestOptions reqOptions = new RequestOptions();
    reqBuilder.into(imageView);
  }
}
