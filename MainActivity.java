package com.gunu.blackbox;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {
    int versionCode = BuildConfig.VERSION_CODE;
    String versionName = BuildConfig.VERSION_NAME;

    String test;
    String DirectoryName;
    Button btnNewActivity1;
    Button btnNewActivity2;
    Button btnNewActivity3;
    Button btnSetup;
    Button btnExit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Black Box 동영상 플레이어 v" + versionName);
        Log.d("test", "Black Box 동영상 플레이어 시작");

        ActivityCompat.requestPermissions(this, new String[] {
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_PRIVATE);

        btnNewActivity1 = (Button) findViewById(R.id.btnNewActivity1);
        btnNewActivity2 = (Button) findViewById(R.id.btnNewActivity2);
        btnNewActivity3 = (Button) findViewById(R.id.btnNewActivity3);
        btnSetup = (Button)findViewById(R.id.btnSetup);
        btnExit = (Button)findViewById(R.id.btnExit);

        btnNewActivity1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                test = SDCard.getExternalSDCardPath();
                if(test == null){
                    Toast.makeText(MainActivity.this, "외장형 SD카드가 장착되지 않았습니다.",
                            Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), SetDerectoryName.class);
                    intent.putExtra("Name", test);
                    startActivityForResult(intent, 0);
                }
            }
        });

        btnNewActivity2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                test = Environment.getExternalStorageDirectory().getAbsolutePath();
                Intent intent = new Intent(getApplicationContext(), SetDerectoryName.class);
                intent.putExtra("Name", test);
                startActivityForResult(intent, 0);
            }
        });

        btnNewActivity3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(DirectoryName != null){
                    Intent intent = new Intent(getApplicationContext(), FileListView.class);
                    intent.putExtra("Name", DirectoryName);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "SD카드 디렉토리를 먼저 설정해 주세요.",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        btnSetup.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Setup.class);
                startActivity(intent);
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                finish();
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String strTemp;
        String strTempA[];
        int strLeng;
        if (resultCode == RESULT_OK) {
            DirectoryName = data.getStringExtra("Directory");
            strTemp = DirectoryName;
            strTempA = strTemp.split("/");
            strLeng = strTempA.length;
            strTemp = strTempA[strLeng-1];
            Log.d("test", strTemp);
            btnNewActivity3.setText("Directory Name : " + strTemp);
        }
    }
}
