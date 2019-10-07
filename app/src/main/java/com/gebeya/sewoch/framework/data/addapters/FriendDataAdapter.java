package com.gebeya.sewoch.framework.data.addapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gebeya.sewoch.R;
import com.gebeya.sewoch.model.Friend;

import java.util.ArrayList;
import java.util.List;

public class FriendDataAdapter extends RecyclerView.Adapter<FriendDataAdapter.HandleDiscover> {

    List<Friend> friendList;

    public FriendDataAdapter() {
        //this.friendList = friendList;

        this.friendList=new ArrayList<>();
        for( int i=0;i<20;i++){
            friendList.add(new Friend());
        }
    }
    @NonNull
    @Override
    public HandleDiscover onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View runningView=inflater.inflate(R.layout.horizontal_people,parent,false);
        HandleDiscover handleDiscover=new HandleDiscover(runningView);
        return handleDiscover;

    }

    @Override
    public void onBindViewHolder(@NonNull HandleDiscover holder, int position) {
       Friend friend=friendList.get(position);
        TextView name=holder.name;
        name.setText(friend.getName());
    }
    @Override
    public int getItemCount() {
        return friendList.size();
    }

    public class HandleDiscover extends RecyclerView.ViewHolder {
        TextView name;

        public HandleDiscover(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.friend_name);
        }
    }
}
