package yalantis.com.sidemenu.sample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import yalantis.com.sidemenu.sample.fragment.UserFragment;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    Fragment[] fragments=new Fragment[3];
    ViewPager vp;
    FragmentPagerAdapter mAdapter;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Log.v("tag",""+item.getItemId());
            vp.setCurrentItem(item.getItemId(),true);
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        initViewPaper();
    }
    private void  initViewPaper()
    {
        vp=findViewById(R.id.view_paper);
        fragments[0]=new UserFragment();
        fragments[1]=new UserFragment();
        fragments[2]=new UserFragment();
        mAdapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public android.support.v4.app.Fragment getItem(int position) {
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
