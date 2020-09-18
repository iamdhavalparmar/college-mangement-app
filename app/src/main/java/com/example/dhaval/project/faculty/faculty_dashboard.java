package com.example.dhaval.project.faculty;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.dhaval.project.R;
import com.example.dhaval.project.general.MyNotification;
import com.example.dhaval.project.logout;
import com.example.dhaval.project.student.s_timetable;

public class faculty_dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, dashboardraw.ItemClickListener {

    private Integer[] pics = {R.drawable.attendance, R.drawable.assignment, R.drawable.exam,
            /*R.drawable.placement,*/ R.drawable.syllabus, R.drawable.leave, R.drawable.complaint,
            R.drawable.progress, R.drawable.managetimetable, R.drawable.approveleave, R.drawable.attendance};
    private String[] name = {"Take Attendance", "Assignment", "Exam Details", /*"Placement",*/ "Syllabus", "Leave", "Complaint",
            "Progress", "Time Table", "Approve Leave", "Attendnace"};
    dashboardraw adp;
    private TextView headerTitleView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        TextView headerTitleView = navigationView.getHeaderView(0).findViewById(R.id.headerText);
        headerTitleView.setText("Welcome Faculty");

        RecyclerView recyclerView = findViewById(R.id.facgrid);
        int numberOfColumns = 3;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        adp = new dashboardraw(this, name, pics);
        adp.setClickListener(this);
        recyclerView.setAdapter(adp);

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
        getMenuInflater().inflate(R.menu.activity_f_navigation_drawer, menu);
        return true;
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.mp) {
            Intent it = new Intent(this, f_manage_profile.class);
            startActivity(it);
        } else if (id == R.id.au) {
            Intent it = new Intent(this, f_about_us.class);
            startActivity(it);

        } else if (id == R.id.cu) {
            Intent it = new Intent(this, f_contact_us.class);
            startActivity(it);

        } else if (id == R.id.lg) {
            Intent it = new Intent(this, logout.class);
            startActivity(it);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onItemClick(View view, int position) {

        if (position == 0) {
            Intent it = new Intent(faculty_dashboard.this, f_StudentAttendanceActivity.class);
            startActivity(it);
        } else if (position == 1) {
            Intent it = new Intent(faculty_dashboard.this, f_assignment.class);
            startActivity(it);
        } else if (position == 2) {
            Intent it = new Intent(faculty_dashboard.this, f_examdetails.class);
            startActivity(it);
        } /*else if (position == 3) {
            Intent it = new Intent(faculty_dashboard.this, f_manage_profile.class);
            startActivity(it);
        } */ else if (position == 3) {
            Intent it = new Intent(faculty_dashboard.this, f_sylllabus.class);
            startActivity(it);
        } else if (position == 4) {
            Intent it = new Intent(faculty_dashboard.this, f_leave.class);
            startActivity(it);
        } else if (position == 5) {
            Intent it = new Intent(faculty_dashboard.this, f_complaint.class);
            startActivity(it);
        } else if (position == 6) {
            Intent it = new Intent(faculty_dashboard.this, f_progress.class);
            startActivity(it);
        } else if (position == 7) {
            Intent it = new Intent(faculty_dashboard.this, s_timetable.class);
            startActivity(it);
        } else if (position == 8) {
            Intent it = new Intent(faculty_dashboard.this, f_approveleave.class);
            startActivity(it);
        } else if (position == 9) {
            MyNotification.sendNotification(this, "Attendance", "Are You Present Today ?");
        }
    }


}