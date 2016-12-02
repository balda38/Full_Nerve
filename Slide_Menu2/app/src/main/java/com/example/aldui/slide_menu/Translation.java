package com.example.aldui.slide_menu;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.TextureView;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Translation extends AppCompatActivity {

    EditText msgText;
    Button sendbtn;
    ListView msgList;
    TextureView strmView;
    String nickname;
    String sqlconn;
    String ipconn;
    String login;
    String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getSupportActionBar().hide();
        }

        setContentView(R.layout.activity_translation);

        msgText = (EditText)findViewById(R.id.msgText);
        sendbtn = (Button)findViewById(R.id.sendbtn);
        msgList = (ListView)findViewById(R.id.msgList);
        strmView = (TextureView)findViewById(R.id.strmView);

        nickname = "usernick";

        final ArrayList<String> msgs = new ArrayList<String>();
        final ArrayAdapter<String> msgadapter = new ArrayAdapter<String>(this, android.R.layout.test_list_item, msgs);

        sendbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                msgs.add(nickname + ": " + msgText.getText().toString());
                msgList.setAdapter(msgadapter);
                msgText.setText("");
            }
        });

        msgText.setOnEditorActionListener(new EditText.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                    msgs.add(nickname + ": " + msgText.getText().toString());
                    msgList.setAdapter(msgadapter);
                    msgText.setText("");
                }
                return false;
            }
        });
    }
}
