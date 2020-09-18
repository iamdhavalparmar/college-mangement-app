package com.example.dhaval.project.student;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.dhaval.project.R;

import org.w3c.dom.Text;

import java.util.zip.CheckedOutputStream;

public class s_timetable extends AppCompatActivity {

    private Toolbar tool;
    private ListView lv;
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_timetable);
        setupviews();
        initToolbar();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setupviews(){
        tool=(Toolbar) findViewById(R.id.Toolbarmain);
        lv=(ListView)findViewById(R.id.lvmain);
    }

    private void initToolbar(){
       //setSupportActionBar(tool);
        getSupportActionBar().setTitle("Time Table App");

    }
    public class simpleadapter extends BaseAdapter
    {

        Context con;
        LayoutInflater ly;
        TextView title,description;
        String[] titlearray;
        String[] descriptionarray;
        ImageView imageView;

        public simpleadapter(Context context,String[] title,String[] description){
            con=context;
            titlearray=title;
            descriptionarray=description;
            ly = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return titlearray.length;
        }

        @Override
        public Object getItem(int i) {
            return titlearray[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup parent) {
            if(view==null){
                view=ly.inflate(R.layout.s_timeraw,null);

            }
            title=(TextView)view.findViewById(R.id.tvmain);
            description= (TextView)view.findViewById(R.id.description);
            imageView =(ImageView)view.findViewById(R.id.ivmain);
            title.setText(titlearray[i]);
            description.setText(descriptionarray[i]);
            return null;
        }
    }
}
