package yalantis.com.sidemenu.sample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import android.view.MenuItem;
import android.widget.TextView;

import yalantis.com.sidemenu.sample.fragment.QuestFragment;
import yalantis.com.sidemenu.sample.fragment.RouteSelectFragment;
import yalantis.com.sidemenu.sample.fragment.UserFragment;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    Fragment[] fragments=new Fragment[3];
    ViewPager vp;
    FragmentPagerAdapter mAdapter;
    BottomNavigationView navigation;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId())
            {
                case R.id.navigation_user:
                    vp.setCurrentItem(0,true);
                    break;
                case R.id.navigation_selector:
                    vp.setCurrentItem(1,true);
                    break;
                case R.id.navigation_ground:
                    vp.setCurrentItem(2,true);
                    break;
            }
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        initViewPaper();

    }
    private void  initViewPaper()
    {
        vp=findViewById(R.id.view_paper);
        fragments[0]=new UserFragment();
        fragments[1]=new RouteSelectFragment();
        fragments[2]=new QuestFragment();
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position)
                {
                    case 0:
                        navigation.setSelectedItemId(R.id.navigation_user);
                        break;
                    case 1:
                        navigation.setSelectedItemId(R.id.navigation_selector);
                        break;
                    case 2:
                        navigation.setSelectedItemId(R.id.navigation_ground);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mAdapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments[position];
            }
            @Override
            public int getCount() {
                return fragments.length;
            }
        };
        vp.setAdapter(mAdapter);
    }
}
