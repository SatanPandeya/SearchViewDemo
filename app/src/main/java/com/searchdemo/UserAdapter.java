package com.searchdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wolfmatrix on 5/22/17.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolderClass> {
    private Context context;
    private List<User> userList = new ArrayList<>();
    ArrayList<User> userArrayList;


    public UserAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
        userArrayList = new ArrayList<>();
        userArrayList.addAll(userList);
    }

    @Override
    public UserAdapter.MyViewHolderClass onCreateViewHolder(ViewGroup parent, int viewType) {
        View container = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new MyViewHolderClass(container);
    }

    @Override
    public void onBindViewHolder(UserAdapter.MyViewHolderClass holder, int position) {
        holder.firstName.setText(userList.get(position).getfName());
        holder.lastName.setText(userList.get(position).getlName());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public void filter(String charText) {

        charText = charText.toLowerCase(Locale.getDefault());

        userList.clear();
        if (charText.length() == 0) {
            userList.addAll(userArrayList);

        } else {
            for (User user : userArrayList) {
                if (charText.length() != 0 && user.getfName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    userList.add(user);
                }

                else if (charText.length() != 0 && user.getlName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    userList.add(user);
                }
            }
        }
        notifyDataSetChanged();
    }

    public class MyViewHolderClass extends RecyclerView.ViewHolder {
        @BindView(R.id.firstNameId)
        TextView firstName;
        @BindView(R.id.lastNameId)
        TextView lastName;

        public MyViewHolderClass(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
