package kr.co.tjoeun.intenttest01;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.view.View;

import kr.co.tjoeun.intenttest01.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    ActivitySecondBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_second);

        String name = getIntent().getStringExtra("inputName");
        String phoneNum = getIntent().getStringExtra("inputPhoneNum");

        binding.scName.setText(name);
        binding.scPhoneNum.setText(phoneNum);

        binding.adjustBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivityForResult(intent, 3);
            }
        });
        binding.dialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 3){

            if(resultCode == RESULT_OK){

                String name = data.getStringExtra("completeName");
                String phoneNum = data.getStringExtra("completePhoneNum");
                binding.scName.setText(name);
                binding.scPhoneNum.setText(phoneNum);
            }
        }
    }
}