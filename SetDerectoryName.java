package com.gunu.blackbox;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.util.ArrayList;

public class SetDerectoryName extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setdirectoryname);

        ListView directoryView;
        final ArrayList<String> midList = new ArrayList<String>();
        final ArrayList<String> midListRe = new ArrayList<String>();
        directoryView = (ListView) findViewById(R.id.directoryView);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, midList);
        directoryView.setAdapter(adapter);


        Intent inIntent = getIntent();

        String sysDir = (inIntent.getStringExtra("Name"));

        if( TextUtils.isEmpty(sysDir)) {
            Log.d("test", "Empty");
            finish();
        } else Log.d("test", sysDir);

        File[] sysFiles = (new File(sysDir).listFiles());
        String strFname;
        String strTemp;
        String strTmpA[];
        int strLeng;

        for (int i = 0; i < sysFiles.length; i++) {
            if (sysFiles[i].isDirectory() == true) {

                strFname = sysFiles[i].toString();
                strTmpA = strFname.split("/");
                strLeng = strTmpA.length;
                strTemp = strTmpA[strLeng-1];
                Log.d("test", strTemp);
                midList.add(strTemp.toString());
                midListRe.add(strFname.toString());
                adapter.notifyDataSetChanged();
            }
        }

        directoryView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("test", "결과" + midListRe.get(position));
                Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);
                outIntent.putExtra("Directory", midList.get(position));
                //setResult(RESULT_OK, outIntent);
                //finish();

                String test;
                test = midList.get(position);
                if(test == null){
                    outIntent.putExtra("Directory", midList.get(position));
                    setResult(RESULT_OK, outIntent);
                    finish();
                } else {
                    Intent intent = new Intent(getApplicationContext(), SetDerectoryName.class);
                    intent.putExtra("Name", test);
                    startActivityForResult(intent,0);
                }


            }
        });
    }
}