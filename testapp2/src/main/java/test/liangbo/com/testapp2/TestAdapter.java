package test.liangbo.com.testapp2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/8/16.
 */

public class TestAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<String> data;

    public TestAdapter(Context context,List<String> list) {
        this.inflater=LayoutInflater.from(context);
        this.data=list;
    }

    @Override
    public int getCount() {
        return data.size();
    }

//    该方法是在点击回调事件中作为参数传送回去的
    @Override
    public Object getItem(int position) {
        return data.get(position);
    }
//同上
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if(convertView==null)
        {
            holder=new ViewHolder();
            convertView=inflater.inflate(android.R.layout.simple_list_item_2,null);
            holder.text1= (TextView) convertView.findViewById(android.R.id.text1);
            holder.text2= (TextView) convertView.findViewById(android.R.id.text2);
            convertView.setTag(holder);
        }
        else
        {
            holder= (ViewHolder) convertView.getTag();
        }
        holder.text1.setText("hello");
        holder.text2.setText("hello1");
        return convertView;
    }
    class ViewHolder
    {
        public TextView text1;
        public TextView text2;
    }
}
