package com.gebeya.sewoch.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gebeya.sewoch.R;
import com.gebeya.sewoch.framework.data.addapters.ChatAdapter;
import com.gebeya.sewoch.framework.data.addapters.GroupDataAdapter;

public class ChatList extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View chatList=inflater.inflate(R.layout.fragment_chat_list,null);

        RecyclerView groupRecycler =chatList.findViewById(R.id.chat_recycler);
        ChatAdapter ChatAdapter=new ChatAdapter();
        groupRecycler.setAdapter(ChatAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        groupRecycler.setLayoutManager(manager);
        return chatList;
    }
}
