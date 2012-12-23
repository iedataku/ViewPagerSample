package jp.classmethod.android.sample.viewpager;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

/**
 * ViewPager ��\������T���v��.
 */
public class PagerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // �J�X�^�� PagerAdapter �𐶐�
        CustomPagerAdapter adapter = new CustomPagerAdapter(this);
        adapter.add(Color.BLACK);
        adapter.add(Color.RED);
        adapter.add(Color.GREEN);
        adapter.add(Color.BLUE);
        adapter.add(Color.CYAN);
        adapter.add(Color.MAGENTA);
        adapter.add(Color.YELLOW);

        // ViewPager �𐶐�
        ViewPager viewPager = new ViewPager(this);
        viewPager.setAdapter(adapter);
        
        // ���C�A�E�g�ɃZ�b�g
        setContentView(viewPager);
    }
    
}
