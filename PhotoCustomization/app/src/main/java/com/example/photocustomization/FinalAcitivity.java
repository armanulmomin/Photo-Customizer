package com.example.photocustomization;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.dsphotoeditor.sdk.activity.DsPhotoEditorActivity;
import com.dsphotoeditor.sdk.utils.DsPhotoEditorConstants;
import com.example.photocustomization.databinding.ActivityFinalAcitivityBinding;

public class FinalAcitivity extends AppCompatActivity {
    ActivityFinalAcitivityBinding binding;
    public static Uri imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityFinalAcitivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent dsPhotoEditorIntent = new Intent(this, DsPhotoEditorActivity.class);


        dsPhotoEditorIntent.setData(imageView2);

        dsPhotoEditorIntent.putExtra(DsPhotoEditorConstants.DS_PHOTO_EDITOR_OUTPUT_DIRECTORY, "YOUR_Customize_Photo");

      //  int[] toolsToHide = {DsPhotoEditorActivity.TOOL_ORIENTATION, DsPhotoEditorActivity.TOOL_CROP};

      //  dsPhotoEditorIntent.putExtra(DsPhotoEditorConstants.DS_PHOTO_EDITOR_TOOLS_TO_HIDE, toolsToHide);



        startActivityForResult(dsPhotoEditorIntent, 200);

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {

            switch (requestCode) {

                case 200:

                    Uri outputUri = data.getData();

                    // handle the result uri as you want, such as display it in an imageView;

                   // image.setImageURI(outputUri);

                    binding.imageviewfinal.setImageURI(outputUri);
                    break;

            }

        }

    }
}