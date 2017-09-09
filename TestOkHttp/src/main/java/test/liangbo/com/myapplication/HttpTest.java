package test.liangbo.com.myapplication;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by Administrator on 2017/8/31.
 */

public class HttpTest {
    static OkHttpClient client = new OkHttpClient();
    public static String doGet(String url) throws IOException {
        Request build = new Request.Builder().url(url).build();
        Response response = client.newCall(build).execute();
        if(response.isSuccessful())
        {
            return response.body().string();
        }
        else {
            throw new IOException("Unexpected code" + response);
        }
    }
}
