package com.qcc.qiuser.Activity;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.qcc.qiuser.R;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
        File file=new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC),"文件夹名称");
        File file2=new File(this.getExternalFilesDir(Environment.DIRECTORY_PICTURES),"wenjianjiamingcheng");
        file.getFreeSpace();//获取所有剩余空间
        file.getTotalSpace();//获取所有可用空间

    }
}
