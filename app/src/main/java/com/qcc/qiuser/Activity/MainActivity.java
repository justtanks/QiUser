package com.qcc.qiuser.Activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.qcc.qiuser.Adapter.CommonAdapter;
import com.qcc.qiuser.Base.BaseActivity;
import com.qcc.qiuser.R;

import java.io.File;
import java.io.IOException;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
//        File file=new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC),"文件夹名称");
//        File file2=new File(this.getExternalFilesDir(Environment.DIRECTORY_PICTURES),"wenjianjiamingcheng");
//        file.getFreeSpace();//获取所有剩余空间
//        file.getTotalSpace();//获取所有可用空间
//        setResult(Activity.RESULT_OK,getIntent());

        findViewById(R.id.buttons).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPermission();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
          if(resultCode==RESULT_OK){

          }
    }
    //获取到相应的permission
    public static final int GET_PERMISSION_VALUE=2;
    private void getPermission(){
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_CONTACTS)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                Toast.makeText(this, "需要获取到联系人的东西", Toast.LENGTH_SHORT).show();

            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_CONTACTS},
                     GET_PERMISSION_VALUE );

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }

    }
    //对请求的权限的返回形式进行处理
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case GET_PERMISSION_VALUE:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.

                }
                return;

        }
    }

}
