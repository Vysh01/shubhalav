package com.example.shubhalav;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shubhalav.model.SurveyDetail;
import com.example.shubhalav.remote.RetrofitClient;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@RequiresApi(api = Build.VERSION_CODES.O)
public class ShopDetailsActivity extends AppCompatActivity {
    private static final int PERMISSION_CODE = 1000;
    private static final int IMAGE_CAPTURE_CODE = 1001;
    ImageView mImageView1, mImageView2;
    int imageViewNumber;
    String imagePath1, imagePath2;
    Button savebutton;
    Uri image_uri;
    EditText ShopNumber, ShopAddress, ShopName;
    CheckBox check1, check2, check3, check4;
    Button yes1, no1, yes2, no2;
    String visibility;
    Boolean ctdBox;
    Boolean cleanCTD;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_details);
        mImageView1 = findViewById(R.id.img_1);

        ShopNumber = findViewById(R.id.shop_number);
        ShopName = findViewById(R.id.shop_name);
        ShopAddress = findViewById(R.id.shopaddress);

        check1 = findViewById(R.id.c1);
        check1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    visibility = buttonView.getText().toString();
            }
        });
        check2 = findViewById(R.id.c2);
        check2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    visibility = buttonView.getText().toString();
            }
        });
        check3 = findViewById(R.id.c3);
        check3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    visibility = buttonView.getText().toString();
            }
        });

        check4 = findViewById(R.id.c4);
        check4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    visibility = buttonView.getText().toString();
            }
        });

        savebutton = findViewById(R.id.save_btn);

        yes1 = findViewById(R.id.yes_btn1);
        no1 = findViewById(R.id.no_btn1);
        yes2 = findViewById(R.id.yes_btn2);
        no2 = findViewById(R.id.no_btn2);

        mImageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.CAMERA) ==
                            PackageManager.PERMISSION_DENIED ||
                            checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                                    PackageManager.PERMISSION_DENIED) {

                        String[] permission = {Manifest.permission.CAMERA,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE};
                        requestPermissions(permission, PERMISSION_CODE);

                    } else {
                        imageViewNumber = 1;
                        openCamera();
                    }
                } else {
                    imageViewNumber = 1;
                    openCamera();
                }
            }
        });
        mImageView2 = findViewById(R.id.img_2);
        mImageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.CAMERA) ==
                            PackageManager.PERMISSION_DENIED ||
                            checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                                    PackageManager.PERMISSION_DENIED) {

                        String[] permission = {Manifest.permission.CAMERA,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE};
                        requestPermissions(permission, PERMISSION_CODE);

                    } else {
                        imageViewNumber = 2;
                        openCamera();
                    }
                } else {
                    imageViewNumber = 2;
                    openCamera();
                }
            }
        });


        yes1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yes1.setBackground(getDrawable(R.drawable.bg_yes));
                no1.setBackground(getDrawable(R.drawable.yes_no_));
                ctdBox = true;
            }
        });

        no1.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                no1.setBackground(getDrawable(R.drawable.bg_no));
                yes1.setBackground(getDrawable(R.drawable.yes_no_));
                ctdBox = false;
            }
        });

        yes2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yes2.setBackground(getDrawable(R.drawable.bg_yes));
                no2.setBackground(getDrawable(R.drawable.yes_no_));

                ctdBox = true;
            }
        });

        no2.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                no2.setBackground(getDrawable(R.drawable.bg_no));
                yes2.setBackground(getDrawable(R.drawable.yes_no_));

                ctdBox = false;
            }
        });

        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSave();

            }
        });


    }

    private void openCamera() {
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE, "New Picture");
        values.put(MediaStore.Images.Media.DESCRIPTION, "From The Camera");
        image_uri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);

        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, image_uri);
        startActivityForResult(cameraIntent, IMAGE_CAPTURE_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_CODE: {
                if (grantResults.length > 0 && grantResults[0] ==
                        PackageManager.PERMISSION_GRANTED) {
                    openCamera();
                } else {
                    Toast.makeText(this, "Permission denied baby. . ", Toast.LENGTH_SHORT).show();
                }
            }
        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK) {
            if (imageViewNumber == 1) {
                imagePath1 = image_uri.getPath();
                Log.d("mylog", "Image URL: " + image_uri);
                mImageView1.setImageURI(image_uri);
            } else {
                Log.d("mylog", "Image URL for 2: " + image_uri);
                imagePath2 = image_uri.getPath();
                mImageView2.setImageURI(image_uri);
            }
        }
    }


    public void onSave() {


        String shopNumber = ShopNumber.getText().toString();
        String shopName = ShopName.getText().toString();
        String shopAddress = ShopAddress.getText().toString();

        MultipartBody.Part multipartBody = null;
        if (imagePath1 != null || !imagePath1.isEmpty()) {
            File file1 = new File(imagePath1);
            RequestBody fileReqBody1 = RequestBody.create(MediaType.parse("image/*"), file1);
            multipartBody = MultipartBody.Part.createFormData("image", file1.getName(), fileReqBody1);
        }


        MultipartBody.Part multipartBody2 = null;
        if (imagePath2 != null || !imagePath2.isEmpty()) {
            File file2 = new File(imagePath2);
            RequestBody fileReqBody2 = RequestBody.create(MediaType.parse("image/*"), file2);
            multipartBody2 = MultipartBody.Part.createFormData("image2", file2.getName(), fileReqBody2);
        }
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("shop_number", shopNumber)
                .addFormDataPart("shop_name", shopName)
                .addFormDataPart("shop_address", shopAddress)
                .addFormDataPart("ctd_box", ctdBox + "")
                .addFormDataPart("clean_ctd", cleanCTD + "")
                .addFormDataPart("visibility", visibility)
                .addPart(multipartBody)
                .addPart(multipartBody2)
                .build();

        Call<SurveyDetail> call = RetrofitClient.getInstance().getApi().surveyDetail(requestBody);
        call.enqueue(new Callback<SurveyDetail>() {
            @Override
            public void onResponse(Call<SurveyDetail> call, Response<SurveyDetail> response) {
//                SurveyDetail surveyDetail = response.body();
                Toast.makeText(ShopDetailsActivity.this, "Data saved", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<SurveyDetail> call, Throwable t) {
                Toast.makeText(ShopDetailsActivity.this, "Data did not saved", Toast.LENGTH_SHORT).show();

            }
        });

    }


}
