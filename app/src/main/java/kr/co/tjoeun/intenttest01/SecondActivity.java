package kr.co.tjoeun.intenttest01;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

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

    }


}