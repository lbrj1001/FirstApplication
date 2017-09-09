package test.lifeng.liang;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InitActivity extends AppCompatActivity {
    EditText init_addr, init_no;
    Button btn_init;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);
        Log.e("InitActivity","onCreate");
        init_addr = (EditText) findViewById(R.id.init_addr);
        init_no = (EditText) findViewById(R.id.init_no);
        btn_init = (Button) findViewById(R.id.btn_init);
        btn_init.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(InitActivity.this,SignActivity.class);
                InitActivity.this.startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("InitActivity","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("InitActivity","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("InitActivity","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("InitActivity","onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("InitActivity","onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("InitActivity","onDestroy");
    }
}
