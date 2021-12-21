package com.example.mitp_penktas;

import static com.example.mitp_penktas.R.layout.activity_main;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    public void btnGetRateOnClick(View v)
    {
        new DataLoader(this){
            @Override
            public void onPostExecute(String result)
            {
                StringArrayToListView(String.valueOf(result));
            }
        }.execute("EUR");
    }

    private void StringArrayToListView(String str)
    {
        ListView listView1 = findViewById(R.id.listView);
        String[] data = stringToStringArray(str);
        ArrayAdapter<String> adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, data);
        listView1.setAdapter(adapter);
    }

    private String[] stringToStringArray(String str)
    {
        return str.split("\n");
    }


}