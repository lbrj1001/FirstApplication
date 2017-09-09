package test.lifeng.liang;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import static android.R.id.list;

public class SignActivity extends AppCompatActivity {
    EditText edit_operator_id,edit_operator_pwd;
    Button btn_login,btn_reSign;
    AbstractSingleTask task;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        Log.e("SignActivity","onCreate");
        edit_operator_id = (EditText) findViewById(R.id.operator_id);
        edit_operator_pwd = (EditText) findViewById(R.id.operator_pwd);
        btn_login= (Button) findViewById(R.id.btn_login);
        btn_reSign= (Button) findViewById(R.id.btn_reinit);
        btn_reSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignActivity.this.finish();
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                task=new AbstractSingleTask(SignActivity.this) {
                    @Override
                    String queryAction(String... params) {
                        HashMap<String, String> map = new HashMap<>();
                        map.put("LICENSE","5858439748636331");
                        map.put("DEVICETYPE","P2000");
                        map.put("DEVICEID","yp610000000241");
                        map.put("REQUEST_TIME",System.currentTimeMillis()+"");
                        map.put("TYPE","activate");
                        try {
                    return getMD5(sortMap(map));
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
                return "";
                        //此处为socket请求测试
//                        return HttpProtocolWithURL.TcpSend("");
//此处为http请求测试
//                        HashMap<String, Object> map = new HashMap<>();
//                        map.put("hello","1234");
//                        return HttpProtocolWithURL.doHttpPost(map);
                    }

                };
                task.setTaskCallback(new ITaskCallback() {
                    @Override
                    public void succeed(Object... params) {
                        showNormalDialog((String)params[0]);
                    }

                    @Override
                    public void failed(Object... params) {

                    }
                });
                task.execute("1");
            }
        });
    }

    private void showNormalDialog(String message){
        /* @setIcon 设置对话框图标
         * @setTitle 设置对话框标题
         * @setMessage 设置对话框消息提示
         * setXXX方法返回Dialog对象，因此可以链式设置属性
         */
        final AlertDialog.Builder normalDialog =
                new AlertDialog.Builder(SignActivity.this);
        normalDialog.setTitle("返回结果");
        normalDialog.setMessage(message);
        normalDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //...To-do
                    }
                });
        normalDialog.setNegativeButton("关闭",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //...To-do
                    }
                });
        // 显示
        normalDialog.show();
    }
    public static String sortMap(HashMap<String,String> hash)
    {
        StringBuilder sortMessage=new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        Set<String> keys = hash.keySet();
        for (String key:keys) {
            list.add(key);
        }
        Collections.sort(list);
        for (String key:list) {
//            sortMessage.append(key+"="+hash.get(key)+"&");
                sortMessage.append(key+hash.get(key));
        }
//        if(sortMessage.length()>0)
//        {
//            sortMessage.deleteCharAt(sortMessage.length()-1);
//        }
        sortMessage.append("KEY");
        return sortMessage.toString();
    }
    public static String getMD5(String val) throws NoSuchAlgorithmException {
        byte[] hash;
        try {
            hash = MessageDigest.getInstance("MD5").digest(val.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("NoSuchAlgorithmException",e);
        }

        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10){
                hex.append("0");
            }
            hex.append(Integer.toHexString(b & 0xFF));
        }
        return hex.toString();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("SignActivity","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("SignActivity","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("SignActivity","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("SignActivity","onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("SignActivity","onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("SignActivity","onDestroy");
    }

}
