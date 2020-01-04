package com.example.bmi_application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class BmiActivity extends AppCompatActivity {

    private EditText mETh;                //宣告全域變數
    private EditText mETw;
    private Button msub;
    private Button mcan;
    private RadioButton mrbt_male;
    private RadioButton mrbt_female;
    private Button mbt_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        mETh = findViewById(R.id.et_h);                           // 取得身高物件
        mETw = findViewById(R.id.et_w);                           // 取得體重物件
        msub = findViewById(R.id.bt_sub);                       // 取得按鈕物件 如果ID有誤請回到res->Layout查看預設Button是多少
        mcan = findViewById(R.id.bt_can);
        mrbt_male = findViewById(R.id.rbt_male);
        mrbt_female = findViewById(R.id.rbt_female);
        mbt_back = findViewById(R.id.bt_back);

        // 按下按鈕 觸發事件
        msub.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                //判斷條件 身高 跟 體重 都有輸入值才執行

                if (!("".equals(mETh.getText().toString()) || "".equals(mETw.getText().toString()))) {
                    float fh = Float.parseFloat(mETh.getEditableText().toString());      // 取得 身高輸入值
                    float fw = Float.parseFloat(mETw.getEditableText().toString());     // 取得 體重輸入值
                    float fresult;                                     // BMI值 計算結果
                    TextView result = findViewById(R.id.tv_3);// 取得 顯示結果 物件
                    fh = fh / 100; // 計算BMI
                    fh = fh * fh;  // 計算BMI

                    NumberFormat nf = NumberFormat.getInstance();   // 數字格式
                    nf.setMaximumFractionDigits(2);                 // 限制小數第二位
                    fresult = fw / fh;                                // 計算BMI
                    result.setText(nf.format(fw / fh) + "");           // 顯示BMI計算結果
                    TextView mtv_4 = findViewById(R.id.tv_4);// 取得 顯示診斷 物件

                    // 診斷結果 顯示
                    if (fresult < 18.5)
                        mtv_4.setText("體重過輕");
                    else if (18.5 <= fresult && fresult < 24)
                        mtv_4.setText("正常範圍");
                    else if (24 <= fresult && fresult < 27)
                        mtv_4.setText("過    重");
                    else if (27 <= fresult && fresult < 30)
                        mtv_4.setText("輕度肥胖");
                    else if (30 <= fresult && fresult < 35)
                        mtv_4.setText("中度肥胖");
                    else if (fresult >= 35)
                        mtv_4.setText("重度肥胖");


                }
                else
                {
                    Toast.makeText(BmiActivity.this, "Check your input plz!!", Toast.LENGTH_SHORT).show();
                }

            }
        });
        mcan.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                mETh.setText("");
                mETw.setText("");


            }
        });

        mbt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BmiActivity.this.finish();
            }
        });



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 設置要用哪個menu檔做為選單
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // 取得點選項目的id
        int id = item.getItemId();

        // 依照id判斷點了哪個項目並做相應事件
        if (id == R.id.action_setting) {
            // 按下「設定」要做的事
            Toast.makeText(this, "設定", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (id == R.id.action_about) {
            // 按下「關於」要做的事
            Toast.makeText(this, "使用說明", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (id == R.id.action_close) {
            // 按下「關閉」要做的事
//            Toast.makeText(this, "關於", Toast.LENGTH_SHORT).show();
//            return true;
            finish();

        }

        return super.onOptionsItemSelected(item);
    }
}
