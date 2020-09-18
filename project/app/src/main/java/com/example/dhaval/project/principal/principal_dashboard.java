package com.example.dhaval.project.principal;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.example.dhaval.project.R;
import com.example.dhaval.project.admin.a_exammangement;
import com.example.dhaval.project.admin.a_faclist;
import com.example.dhaval.project.admin.a_manageplacement;
import com.example.dhaval.project.admin.a_managestaff;
import com.example.dhaval.project.admin.a_managestudent;
import com.example.dhaval.project.admin.a_solvecomplaint;
import com.example.dhaval.project.admin.a_staffattendance;
import com.example.dhaval.project.admin.a_timetable;
import com.example.dhaval.project.admin.admin_dashboard;
import com.example.dhaval.project.faculty.f_about_us;
import com.example.dhaval.project.faculty.f_contact_us;
import com.example.dhaval.project.faculty.f_manage_profile;
import com.example.dhaval.project.login;
import com.example.dhaval.project.student.s_holiday;


public class principal_dashboard extends AppCompatActivity implements dashboardraw.ItemClickListener , NavigationView.OnNavigationItemSelectedListener{


    private Integer[] pics = {R.drawable.attendance, R.drawable.progress, R.drawable.result,
            R.drawable.complaint, R.drawable.feedback, R.drawable.leave, R.drawable.exam,R.drawable.holiday};
    private String[] name = {"Attendnace", "Progress", "Result", "Complaint", "Feedback", "Leaves", "Exam","Holiday"};
    dashboardraw adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_dashboard);
        RecyclerView recyclerView = findViewById(R.id.facgrid);
        int numberOfColumns = 3;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        adp = new dashboardraw(this, name, pics);
        adp.setClickListener(this);
        recyclerView.setAdapter(adp);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onItemClick (View view,int position){
        if(position==0){
            Intent it = new Intent(principal_dashboard.this,p_atd.class);
            startActivity(it);
        }
        else if(position==1){
            Intent it = new Intent(principal_dashboard.this,p_progress.class);
            startActivity(it);
        }
        else if(position==2){
            Intent it = new Intent(principal_dashboard.this,p_result.class);
            startActivity(it);
        }
        else if(position==3){
            Intent it = new Intent(principal_dashboard.this,p_complaint.class);
            startActivity(it);
        }
        else if(position==4){
            Intent it = new Intent(principal_dashboard.this,p_feedback.class);
            startActivity(it);
        }
        else if(position==5){
            Intent it = new Intent(principal_dashboard.this,p_leave.class);
            startActivity(it);
        }
        else if(position==6){
            Intent it = new Intent(principal_dashboard.this,p_exam.class);
            startActivity(it);
        }
        else if(position==7){
            Intent it = new Intent(principal_dashboard.this,s_holiday.class);
            startActivity(it);
        }

    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.f_navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.au) {
            Intent it = new Intent(this,f_about_us.class);
            startActivity(it);
        } else if (id == R.id.mp) {
            Intent it = new Intent(this,f_manage_profile.class);
            startActivity(it);

        } else if (id == R.id.cu) {
            Intent it = new Intent(this,f_contact_us.class);
            startActivity(it);

        } else if (id == R.id.lg) {
            Intent it = new Intent(this,login.class);
            startActivity(it);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
