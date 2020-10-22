package com.suxw.dbcode;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.suxw.dbcode.activity.AnimationRotateCase;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private String[] transNames = {"动画-自转", "消费", "退货", "重打印", "重打印任意一笔", "结算"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                R.layout.lession_list_item, R.id.tvLessionTitle, transNames);
        ListView lvTransNames = (ListView)findViewById(R.id.lvLession);
        lvTransNames.setAdapter(adapter);
        lvTransNames.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    onLessionItemClick(position);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void onLessionItemClick(int position) throws JSONException {
        Bundle bundle = new Bundle();
        Log.i(TAG, "#onLessionItemClick | position = " + position + "#");
        JSONObject jsonObject;
        switch (position)
        {
            //动画-自动旋转
            case 0:
                Intent i = new Intent(MainActivity.this, AnimationRotateCase.class);
                startActivityForResult(i, 1);
                break;
            default:
                break;
        }
    }
}
