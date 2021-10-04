package com.example.anaraadmin;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    private Context context;
    ArrayList<recipes> list = new ArrayList<>();
    public RVAdapter (Context ctx)
    {
        this.context = ctx;
    }
    public void setItems (ArrayList<recipes> rcp)
    {
        list.addAll(rcp);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item,parent, false);
        return new recipesVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position)
    {
        recipesVH vh = (recipesVH) holder;
        recipes rcp = list.get(position);
        vh.txt_desc.setText(rcp.getDescription());
        vh.txt_ing.setText(rcp.getIngredients());
        vh.txt_name.setText(rcp.getUsername());
        vh.txt_option.setOnClickListener(v ->
        {
            PopupMenu popupMenu = new PopupMenu(context,vh.txt_option);
            popupMenu.inflate(R.menu.option_menu);
            popupMenu.setOnMenuItemClickListener(item ->
            {
                switch (item.getItemId())
                {
                    case R.id.menu_edit:
                        Intent intent = new Intent(context,RVActivity.class);
                        intent.putExtra("EDIT", (Parcelable) rcp);
                        context.startActivity(intent);
                        break;
                    case R.id.menu_remove:
                        DAOEmployee dao = new DAOEmployee();
                            dao.remove(rcp.getKey()).addOnSuccessListener(suc ->
                            {
                                Toast.makeText(context, "Recipes is removed", Toast.LENGTH_SHORT).show();
                                notifyItemRemoved(position);
                            }).addOnFailureListener(er ->
                            {
                                Toast.makeText(context, "" +er.getMessage(), Toast.LENGTH_SHORT).show();
                            });
                        break;
                }
                return false;
            });
            popupMenu.show();
        });
    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }

    public void stopListening() {

    }

    public void startListening() {

    }
}
