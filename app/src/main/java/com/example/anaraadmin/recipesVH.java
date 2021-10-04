package com.example.anaraadmin;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class recipesVH extends RecyclerView.ViewHolder
{
    public TextView txt_desc,txt_ing,txt_name,txt_option;
    public recipesVH(@NonNull View itemView)
    {
        super(itemView);
        txt_desc = itemView.findViewById(R.id.txt_desc);
        txt_ing = itemView.findViewById(R.id.txt_ing);
        txt_name = itemView.findViewById(R.id.txt_name);
        txt_option = itemView.findViewById(R.id.txt_option);
    }
}
