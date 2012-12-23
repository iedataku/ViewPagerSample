package jp.classmethod.android.sample.viewpager;

import java.util.ArrayList;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * �J�X�^�� PagerAdapter �N���X.
 */
public class CustomPagerAdapter extends PagerAdapter {

    /** �R���e�L�X�g. */
    private Context mContext;
    
    /** ���X�g. */
    private ArrayList<Integer> mList;

    /**
     * �R���X�g���N�^.
     */
    public CustomPagerAdapter(Context context) {
        mContext = context;
        mList = new ArrayList<Integer>();
    }

    /**
     * ���X�g�ɃA�C�e����ǉ�����.
     * @param item �A�C�e��
     */
    public void add(Integer item) {
        mList.add(item);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        // ���X�g����擾
        Integer item = mList.get(position);

        // View �𐶐�
        TextView textView = new TextView(mContext);
        textView.setText("Page:" + position);
        textView.setTextSize(30);
        textView.setTextColor(item);
        textView.setGravity(Gravity.CENTER);

        // �R���e�i�ɒǉ�
        container.addView(textView);

        return textView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // �R���e�i���� View ���폜
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        // ���X�g�̃A�C�e������Ԃ�
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        // Object ���� View �����݂��邩���肷��
        return view == (TextView) object;
    }

}
