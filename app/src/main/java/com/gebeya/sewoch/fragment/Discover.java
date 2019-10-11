package com.gebeya.sewoch.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.gebeya.sewoch.R;
import com.gebeya.sewoch.framework.data.addapters.FriendDataAdapter;
import com.gebeya.sewoch.framework.data.addapters.GroupDataAdapter;

public class Discover extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View discoverVeiw=inflater.inflate(R.layout.discover_list,null);

        RecyclerView friendRecyclerView =discoverVeiw.findViewById(R.id.frien_list);
        SnapHelper snapHelper = new LinearSnapHelper();

        snapHelper.attachToRecyclerView(friendRecyclerView);

        FriendDataAdapter friendDataAdapter=new FriendDataAdapter();
        friendRecyclerView.setAdapter(friendDataAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        friendRecyclerView.setLayoutManager(layoutManager);



        RecyclerView groupRecycler =discoverVeiw.findViewById(R.id.group_recycler);
        GroupDataAdapter groupAdapter=new GroupDataAdapter();
        groupRecycler.setAdapter(groupAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        groupRecycler.setLayoutManager(manager);

        return discoverVeiw;
    }
}
