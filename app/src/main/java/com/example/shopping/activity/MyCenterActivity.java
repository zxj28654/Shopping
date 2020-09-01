package com.example.shopping.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import com.bigkoo.alertview.AlertView;
import com.bigkoo.alertview.OnItemClickListener;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.shopping.MainActivity;
import com.example.shopping.R;
import com.example.shopping.utils.CameraUtils;
import com.example.shopping.utils.getPhotoFromPhotoAlbum;

import java.io.File;

import retrofit2.http.Url;

public class MyCenterActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView back_mycenter;
    private TextView baocun_mycenter;
    private ImageView mycenter_toux;
    private EditText mycenter_name;
    private TextView mycenter_phone;
    private EditText mycenter_qianming;
    private RadioGroup mRadioGroup;
    private File cameraSavePath;//拍照照片路径
    private Uri uri;//照片uri
    private ImageView iv_tou_mcenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_center);
        initView();
        cameraSavePath = new File(Environment.getExternalStorageDirectory().getPath() + "/" + System.currentTimeMillis() + ".jpg");

    }

    private void initView() {
        back_mycenter = (ImageView) findViewById(R.id.back_mycenter);
        baocun_mycenter = (TextView) findViewById(R.id.baocun_mycenter);
        mycenter_toux = (ImageView) findViewById(R.id.mycenter_toux);
        mycenter_name = (EditText) findViewById(R.id.mycenter_name);
        mycenter_phone = (TextView) findViewById(R.id.mycenter_phone);
        mycenter_qianming = (EditText) findViewById(R.id.mycenter_qianming);
        mRadioGroup = (RadioGroup) findViewById(R.id.radiogr);

        baocun_mycenter.setOnClickListener(this);
        mycenter_toux.setOnClickListener(this);

        back_mycenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        iv_tou_mcenter = (ImageView) findViewById(R.id.iv_tou_mcenter);
        iv_tou_mcenter.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mycenter_toux:
                new AlertView("选择图片", null, "取消", null, new String[]{"拍照", "从相册中选择"}, this, AlertView.Style.ActionSheet,
                        new OnItemClickListener() {
                            @Override
                            public void onItemClick(Object o, int position) {
                                switch (position) {
                                    case 0:
                                       goCamera();
                                        break;
                                    case 1:
                                        goPhotoAlbum();
                                        break;
                                }
                            }
                        }).show();
                break;
            case R.id.baocun_mycenter:
                break;


        }
    }

    //激活相册操作
    private void goPhotoAlbum() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, 2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        String photoPath;
        if (requestCode == 1 && resultCode == RESULT_OK) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                photoPath = String.valueOf(cameraSavePath);
            } else {
                photoPath = uri.getEncodedPath();
            }
            Log.d("998:", photoPath);
            RequestOptions requestOptions = new RequestOptions().circleCrop();
            Glide.with(this).load(photoPath).apply(requestOptions).into(iv_tou_mcenter);
        } else if (requestCode == 2 && resultCode == RESULT_OK) {
            photoPath = getPhotoFromPhotoAlbum.getRealPathFromUri(this, data.getData());
            Log.d("9984:", photoPath);
            RequestOptions requestOptions = new RequestOptions().circleCrop();
            Glide.with(this).load(photoPath).apply(requestOptions).into(iv_tou_mcenter);
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    //激活相机操作
    private void goCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            uri = FileProvider.getUriForFile(this, "com.example.shopping.fileprovider", cameraSavePath);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        } else {
            uri = Uri.fromFile(cameraSavePath);
        }
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        startActivityForResult(intent, 1);
    }
}
