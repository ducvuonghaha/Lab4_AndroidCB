package com.dcvg.lab4_androidcb.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dcvg.lab4_androidcb.DetailUserActivity;
import com.dcvg.lab4_androidcb.R;
import com.dcvg.lab4_androidcb.model.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.Holder> {

    private Context context;
    private List<User> userList;


    public UserAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.user = userList.get(position);
        holder.tvFullnameUser.setText(holder.user.getFullname());
        holder.tvPhoneUser.setText(holder.user.getPhone());

        holder.tvFullnameUser.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(context, DetailUserActivity.class);
                intent.putExtra("fullname_user", holder.tvFullnameUser.getText().toString().trim());
                intent.putExtra("phone_user", holder.tvPhoneUser.getText().toString().trim());
                context.startActivity(intent);
                return true;
            }
        });

        holder.tvPhoneUser.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", holder.tvPhoneUser.getText().toString().trim(), null));
                context.startActivity(intent);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }


    public class Holder extends RecyclerView.ViewHolder {

        private TextView tvUser;
        private TextView tvFullnameUser;
        private TextView tvPhoneUser;
        private User user;

        public Holder(@NonNull View itemView) {
            super(itemView);
            tvUser = (TextView) itemView.findViewById(R.id.tvUser);
            tvFullnameUser = (TextView) itemView.findViewById(R.id.tvFullnameUser);
            tvPhoneUser = (TextView) itemView.findViewById(R.id.tvPhoneUser);
        }
    }
}
