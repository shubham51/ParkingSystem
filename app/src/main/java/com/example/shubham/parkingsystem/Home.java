package com.example.shubham.parkingsystem;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class Home extends AppCompatActivity{
    private ActionBar actionBar;
    private ViewPager viewPager;
    private String[] mDrawerTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        viewPager=(ViewPager)findViewById(R.id.pager);
        HomePagerAdapter adapter=new HomePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        TabLayout tabLayout= (TabLayout)findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Current Status"));
        tabLayout.addTab(tabLayout.newTab().setText("Pending Transactions"));
        tabLayout.setupWithViewPager(viewPager);
        mDrawerTitles=getResources().getStringArray(R.array.drawer_list_options);
        mDrawerLayout=(DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList=(ListView)findViewById(R.id.left_drawer);
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1
                , mDrawerTitles));

    }
}

class HomePagerAdapter extends FragmentPagerAdapter {

     public HomePagerAdapter(FragmentManager fm){
         super(fm);
     }
    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
        if(position==0){
            fragment=new Fragment_A();
        } else if(position==1){
            fragment=new Fragment_B();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title=null;
        if(position==0){
            title="Current status";
        }
        else if(position==1){
            title="Pending Transactions";
        }
        return title;
    }
}
