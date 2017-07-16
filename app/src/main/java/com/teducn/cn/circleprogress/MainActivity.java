package com.teducn.cn.circleprogress;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CircleProgress mCircleProgress;
    private Button button_loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_loading = (Button) findViewById(R.id.btn_loading);
        button_loading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCircleProgress = (CircleProgress) findViewById(R.id.circle_view);

                // 进度条从0到100
                ValueAnimator animator = ValueAnimator.ofFloat(0, 100);
                animator.setDuration(10000);
                animator.setInterpolator(new LinearInterpolator());
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float current = (float) animation.getAnimatedValue();
                        mCircleProgress.setmCurrent((int) current);
                    }
                });
                animator.start();

                mCircleProgress.setOnLoadingComleteListener(new CircleProgress.OnLoadingCompleteListener() {
                    @Override
                    public void complete() {
                        Toast.makeText(MainActivity.this, "加载成功", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
