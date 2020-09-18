package com.example.dhaval.project;


import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class slideradapter extends PagerAdapter {
    Context con;
    LayoutInflater ly;
    public slideradapter(Context con){
        this.con = con;
    }
    int[] img = {R.drawable.principal,R.drawable.admin,R.drawable.facultyyy,R.drawable.student};

    String[] str = {"Principal","Admin","Faculty","Student"};

    String[] str2 = { "Princiapl will view all the progress and track everything from the single app  No need to rush to see whats going on in college",
                        "Admin will manage the whole application with built in features and its very easy to do all this stuff",
                           "Faculty will pass the importants notes and other things to the student can track the student progress",
                        "Student will get all the information and updated eveyrday"
                            };

    @Override
    public int getCount() {
        return str.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == (RelativeLayout)o;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ly = (LayoutInflater) con.getSystemService(con.LAYOUT_INFLATER_SERVICE);
        View view = ly.inflate(R.layout.slide_layout,container,false);


        ImageView iv = (ImageView) view.findViewById(R.id.iv);
        TextView tv1 = (TextView) view.findViewById(R.id.tv1);
        TextView tv2 = (TextView) view.findViewById(R.id.tv2);

        iv.setImageResource(img[position]);
        tv1.setText(str[position]);
        tv2.setText(str2[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(((RelativeLayout)object));

    }
}
