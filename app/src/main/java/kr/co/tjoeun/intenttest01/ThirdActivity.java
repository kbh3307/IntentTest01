package kr.co.tjoeun.intenttest01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import kr.co.tjoeun.intenttest01.databinding.ActivityThirdBinding;

public class ThirdActivity extends AppCompatActivity {

    ActivityThirdBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_third);

        binding.completeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("completeName", binding.trName.getText().toString());
                intent.putExtra("completePhoneNum", binding.trPhoneNum.getText().toString());

                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
