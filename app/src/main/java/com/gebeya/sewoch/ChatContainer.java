package com.gebeya.sewoch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;




public class ChatContainer extends AppCompatActivity {

    LayoutInflater inflate;

    LinearLayout chatContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_container);

        inflate=getLayoutInflater();
        chatContainer=findViewById(R.id.chatContainer);
    }

   // @OnClick(R.id.sendMessage)
    public void sendMeasge(View v){
        View root2=inflate.inflate(R.layout.chat_out,chatContainer,false);
        TextView message=root2.findViewById(R.id.chat_out);
       // message.setText("This is the Message");
        chatContainer.addView(root2);
        root2=inflate.inflate(R.layout.chat_in,chatContainer,false);
        //TextView mmm=root2.findViewById(R.id.chat_out);
        // message.setText("This is the Message");
        chatContainer.addView(root2);

    }
}
