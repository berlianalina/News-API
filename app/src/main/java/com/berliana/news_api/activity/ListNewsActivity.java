package com.berliana.news_api.activity;

import android.app.Dialog;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.berliana.news_api.R;
import com.berliana.news_api.config.Constant;
import com.berliana.news_api.fragment.NewsFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by berlianalina on 5/14/18.
 */

public class ListNewsActivity extends AppCompatActivity {

    @BindView(R.id.img_menu)
    ImageView img_menu;
    @BindView(R.id.img_search)
    ImageView img_search;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.tv_news)
    TextView tv_news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_news);
        setUI();
    }

    private void setUI() {
        ButterKnife.bind(this);
        setupViewPager(viewpager);
        tabLayout.setupWithViewPager(viewpager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tv_news.setText(tab.getText().toString());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        for (String s: Constant.CATEGORY) {
            adapter.addFragment(NewsFragment.newInstance(s), s.toUpperCase());
        }

        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @OnClick(R.id.img_menu)
    public void info() {
        dialogInfo();
    }

    private void dialogInfo() {
        Dialog d = new Dialog(this);
        d.setContentView(R.layout.dialog_info);
        d.show();
    }
}
