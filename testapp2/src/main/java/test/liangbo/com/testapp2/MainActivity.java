package test.liangbo.com.testapp2;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.lv_list);
//        arrayAdapter
//        lv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,getData()));
//        Cursor Adapter
        Cursor query = getContentResolver().query(Uri.parse("content://contacts/people"), null, null, null,null);
        startManagingCursor(query);
        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_expandable_list_item_1, query, new String[]{Contacts.People.NAME}, new int[]{android.R.id.text1});
        lv.setAdapter(simpleCursorAdapter);
        lv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private List<String> getData() {
        List<String> lv=new ArrayList<String>();
        lv.add("Test1");
        lv.add("Test2");
        lv.add("Test3");
        lv.add("Test4");
        lv.add("Test5");
        lv.add("Test6");
        return lv;
    }
}
