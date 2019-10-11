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
import com.gebeya.sewoch.model.Group;

import java.util.ArrayList;
import java.util.List;

public class GroupDataAdapter extends RecyclerView.Adapter<GroupDataAdapter.ViewHandler> {
    List<Group> groupList=new ArrayList<>();

    public GroupDataAdapter() {

        this.groupList=new ArrayList<>();
        groupList.add(new Group().setName("Gebeya Student").setDetail("Gebeya 5th Batch Student "));
        groupList.add(new Group().setName("UX/UI fifth Batch").setDetail("Gebeya 5th Batch Student UI/UX"));
        groupList.add(new Group().setName("Adobe AX").setDetail("OPen discussion On Adobe XD "));
        groupList.add(new Group().setName("Photography").setDetail("Photography is the art, application and practice of creating durable images by recording light or other electromagnetic radiation, either electronically by means of ..."));
        groupList.add(new Group().setName("Tourism").setDetail("Travel for pleasure or business; also the theory and practice of touring, the business of attracting, accommodating, and entertaining tourists,"));
        groupList.add(new Group().setName("Modeling").setDetail("One of the first places that an aspiring model comes is to a reputable modeling agency. To be an agent you will have to have experience in the modeling world,"));

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

        Group group=groupList.get(position);
        TextView name=holder.name;
        name.setText(group.getName());
        TextView detail=holder.detail;
        detail.setText(group.getDetail());


    }

    @Override
    public int getItemCount() {
        return groupList.size();
    }

    public class ViewHandler extends RecyclerView.ViewHolder {
        TextView name;
        TextView detail;
        public ViewHandler(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.group_name);
            detail=itemView.findViewById(R.id.group_detail);

        }
    }
}
