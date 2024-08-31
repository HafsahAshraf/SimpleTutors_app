package com.example.simpletutors;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ChatWindow extends AppCompatActivity {
    ImageButton sendButton;
    ListView listView;
    EditText textField;
    ArrayList<String> chatArray;
    protected class ChatAdapter extends ArrayAdapter<String>{
        public ChatAdapter(Context ctx) {
            super(ctx, 0);
        }
        public int getCount(){
            return chatArray.size();
        }
        public String getItem(int position){
            return chatArray.get(position);
        }
        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater = ChatWindow.this.getLayoutInflater();
            View result = null ;
            if(position%2 == 0) {
                result = inflater.inflate(R.layout.chat_row_incoming, null);
            }
            else {
                result = inflater.inflate(R.layout.chat_row_outgoing, null);
            }
            TextView message = (TextView)result.findViewById(R.id.sendermessage);
            message.setText(getItem(position)); // get the string at position
            return result;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_window);
        sendButton = findViewById(R.id.imageviewsendmessage);
        listView = findViewById(R.id.listView);
        textField = findViewById(R.id.getmessage);
        chatArray = new ArrayList<String>();
        //chatArray.add("piper");//This proves the add function itself calls getView
        ChatAdapter messageAdapter = new ChatAdapter(this);
        listView.setAdapter((ListAdapter) messageAdapter);
        sendButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.i("ChatWindow.java", "in onClick()");
                if(!String.valueOf(textField.getText()).matches("")) {
                    chatArray.add(textField.getText().toString());
                    messageAdapter.notifyDataSetChanged(); //this restarts the process of getCount()/getView()
                    textField.setText("");
                }
            }
        });
    }
}