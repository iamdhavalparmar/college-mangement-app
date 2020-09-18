package com.example.dhaval.project.student;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.dhaval.project.R;


@SuppressLint("ValidFragment")
public class fragment_main extends Fragment {

    String day;

    int[] img;
    String[] time;
    String[] sname;
    String[] fname;

    public fragment_main(String day) {
        this.day = day;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        ListView listView = (ListView) rootView.findViewById(R.id.lv);

        if (day.equals("Monday")) {
            img = new int[]{R.drawable.timer, R.drawable.timer, R.drawable.timer, R.drawable.timer, R.drawable.timer};
            time = new String[]{"12:00", "1:00", "2:00", "3:00", "4:00"};
            sname = new String[]{"aaa", "bbb", "ccc", "ddd", "eee"};
            fname = new String[]{"aakash", "dhaval", "meet", "sachin", "jaydeep"};
        }
        else if (day.equals("Tuesday")){
            img = new int[]{R.drawable.timer, R.drawable.timer, R.drawable.timer, R.drawable.timer, R.drawable.timer};
            time = new String[]{"12:00", "1:00", "2:00", "3:00", "4:00"};
            sname = new String[]{"aa", "bb", "cc", "dd", "ee"};
            fname = new String[]{"aakash", "dhaval", "meet", "sachin", "jaydeep"};
        }
        else if (day.equals("Wednesday")){
            img = new int[]{R.drawable.timer, R.drawable.timer, R.drawable.timer, R.drawable.timer, R.drawable.timer};
            time = new String[]{"12:00", "1:00", "2:00", "3:00", "4:00"};
            sname = new String[]{"asd", "fgh", "hjk", "asd", "fgh"};
            fname = new String[]{"aakash", "dhaval", "meet", "sachin", "jaydeep"};
        }
        else if (day.equals("Thursday")){
            img = new int[]{R.drawable.timer, R.drawable.timer, R.drawable.timer, R.drawable.timer, R.drawable.timer};
            time = new String[]{"12:00", "1:00", "2:00", "3:00", "4:00"};
            sname = new String[]{"anjd", "qfefe", "qfef", "wety", "ryjtrh"};
            fname = new String[]{"aakash", "dhaval", "meet", "sachin", "jaydeep"};
        }
        else if (day.equals("Friday")){
            img = new int[]{R.drawable.timer, R.drawable.timer, R.drawable.timer, R.drawable.timer, R.drawable.timer};
            time = new String[]{"12:00", "1:00", "2:00", "3:00", "4:00"};
            sname = new String[]{"anjd", "qfefe", "qfef", "wety", "ryjtrh"};
            fname = new String[]{"aakash", "dhaval", "meet", "sachin", "jaydeep"};
        }
        else if (day.equals("Saturday")){
            img = new int[]{R.drawable.timer, R.drawable.timer, R.drawable.timer, R.drawable.timer, R.drawable.timer};
            time = new String[]{"12:00", "1:00", "2:00", "3:00", "4:00"};
            sname = new String[]{"anjd", "qfefe", "qfef", "wety", "ryjtrh"};
            fname = new String[]{"aakash", "dhaval", "meet", "sachin", "jaydeep"};
        }


        raw a = new raw(getContext(), R.layout.raw, img, time, sname, fname);
        listView.setAdapter(a);


        return rootView;
    }
}


