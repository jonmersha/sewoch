package com.gebeya.sewoch.framework.data.addapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gebeya.sewoch.R;
import com.gebeya.sewoch.model.Group;

import java.util.ArrayList;
import java.util.List;

public class GroupDataAdapter extends RecyclerView.Adapter<GroupDataAdapter.ViewHandler> {
    List<Group> groupList=new ArrayList<>();

    public GroupDataAdapter() {

        this.groupList=new ArrayList<>();
        for( int i=0;i<20;i++){
            groupList.add(new Group());
        }
    }

    @NonNull
    @Override
    public ViewHandler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View runningView=inflater.inflate(R.layout.group_list,parent,false);
        ViewHandler handleDiscover=new ViewHandler(runningView);
        return handleDiscover;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHandler holder, int position) {


    }

    @Override
    public int getItemCount() {
        return groupList.size();
    }

    public class ViewHandler extends RecyclerView.ViewHolder {
        TextView name;
        public ViewHandler(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.friend_name);

        }
    }
}
