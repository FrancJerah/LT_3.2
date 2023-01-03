package com.example.lt_32;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context context = this;

        InputStream inputStream = context.getResources().openRawResource(R.raw.manual);
        String jsonResponse = new Scanner(inputStream).useDelimiter("\\A").next();

        final ListView list = findViewById(R.id.content_list);
        ArrayList<SubjectData> arrayList = new ArrayList<SubjectData>();

        try {
            JSONObject jsonobject = new JSONObject(jsonResponse);
            JSONArray jarray = jsonobject.optJSONArray("jewelry");

            for (int i = 0; i < jarray.length(); i++) {
                JSONObject jsonChildNode = jarray.getJSONObject(i);
                String name = jsonChildNode.optString("jewelry_name");
                String prices = jsonChildNode.optString("jewelry_prices");
                String image = jsonChildNode.optString("jewelry_img");
                //String outPut = number + " " + name;
                arrayList.add(new SubjectData(name, prices, image));
            }
        }catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Error"+e.toString(), Toast.LENGTH_LONG).show();
        }

        CustomAdapter customAdapter = new CustomAdapter(this, arrayList);
        list.setAdapter(customAdapter);
    }
}
/* this demo picasso library implementation  */
/* https://www.tutorialspoint.com/how-to-display-a-list-of-images-and-text-in-a-listview-in-android */