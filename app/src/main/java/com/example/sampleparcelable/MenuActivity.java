package com.example.sampleparcelable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {
    public static final String KEY_SIMPLE_DATA = "data";
    private TextView textView;
    private Button back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        textView = (TextView) findViewById(R.id.menu_text);
        back_btn = (Button) findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 인텐트 객체 생성
                Intent intent = new Intent();
                intent.putExtra("name", "mike");

                // 응답 전달 후 액티비티 종료
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        // 메인 액티비티로부터 전달받은 인텐트 확인
        Intent intent = getIntent();
        processIntent(intent);
    }

    private void processIntent(Intent intent) {
        if (intent != null) {
            // 인텐트 안의 번들 객체 참조
            Bundle bundle = intent.getExtras();

            // 번들 객체 안의 SimpleData 객체 참조
            SimpleData data = (SimpleData) bundle.getParcelable(KEY_SIMPLE_DATA);

            // 텍스트뷰에 값 설정
            textView.setText("전달받은 데이터\nNumber : " + data.getNum() + "\nMessage : " + data.getMessage());
        }
    }
}
