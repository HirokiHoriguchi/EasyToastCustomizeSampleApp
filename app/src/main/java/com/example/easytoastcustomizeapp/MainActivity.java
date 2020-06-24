package com.example.easytoastcustomizeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    //目的
    //タップすると、画像をトースト表示するアプリを作成すること
    //方針
    //defaultのトーストを拡張して作成する。
    //方法
    //・TextViewとImageViewをのせたViewを作成し、customize_toastと言うレイアウトファイルにする
    //・customize_toastをinflateを使ってactivity_mainに挿入
    //・TextViewは背景をshapeを使って色付け、角を丸く補正する

    private Context context;
    private String toastMessage;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();
        toastMessage = "OK";
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                if (toastMessage != null) {
                    toastMake(toastMessage, context);
                }
                break;
            default:
                break;
        }
    }

    private void toastMake(String toastMessage, Context context){
        Toast toast = new Toast(context);

        LayoutInflater layoutInflater = getLayoutInflater();

        ViewGroup viewGroup = findViewById(R.id.relative_layout);

        View view = layoutInflater.inflate(R.layout.custom_toast, viewGroup);

        TextView textView = view.findViewById(R.id.message);
        textView.setText(toastMessage);

        toast.setView(view);

        toast.setDuration(Toast.LENGTH_SHORT);

        toast.setGravity(Gravity.CENTER, 0, -100);

        toast.show();
    }

}
