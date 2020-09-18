package com.example.dhaval.project.student;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
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

    private android.app.ActionBar actionBar;
    private ViewPager mViewPager;
    TabLayout tabLayout;
    private String[] tabs = {"Monday", "Tuesday", "wednesday", "thursday", "friday", "saturday"};


    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_timetable);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tab);


        Adapter adapter = new Adapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(mViewPager);


    }

    public class Adapter extends FragmentStatePagerAdapter {
        public Adapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                    return new fragment_main("Monday");
                case 1:
                    return new fragment_main("Tuesday");
                case 2:
                    return new fragment_main("Wednesday");
                case 3:
                    return new fragment_main("Thursday");
                case 4:
                    return new fragment_main("Friday");
                case 5:
                    return new fragment_main("Saturday");
            }

            return null;
        }

        @Override
        public int getCount() {
            return 6;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {

            switch (position) {
                case 0:
                    return "Monday";
                case 1:
                    return "Tuesday";
                case 2:
                    return "Wednesday";
                case 3:
                    return "Thursday";
                case 4:
                    return "Friday";
                case 5:
                    return "Saturday";
                default:
                    return "Sunday";
            }
        }
    }

}
