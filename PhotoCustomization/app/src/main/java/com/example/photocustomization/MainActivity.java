package com.example.photocustomization;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


import com.example.photocustomization.databinding.ActivityMainBinding;
import com.github.dhaval2404.imagepicker.ImagePicker;


public class MainActivity extends AppCompatActivity {
    int select_Image=1;
    ImageView imageView2;

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                //startActivityForResult(Intent.createChooser(intent,"Title"),selectImage);
                startActivityForResult(Intent.createChooser(intent,"Title"),select_Image);



            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1)
        {
            Uri uri=data.getData();
            //data.getData();
            startActivity(new Intent(MainActivity.this,FinalAcitivity.class));
        }
    }
}