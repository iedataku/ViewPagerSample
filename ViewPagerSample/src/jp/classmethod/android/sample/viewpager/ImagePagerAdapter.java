package jp.classmethod.android.sample.viewpager;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * �摜��\������ PagerAdapter.
 */
public class ImagePagerAdapter extends PagerAdapter {

    /** �R���e�L�X�g. */
    private Context mContext;

    /** ContentResolver. */
    private ContentResolver mResolver;

    /** ID �̃��X�g. */
    private ArrayList<Long> mList;

    /**
     * �R���X�g���N�^.
     * @param context {@link Context}
     */
    public ImagePagerAdapter(Context context) {
        mContext = context;
        mResolver = mContext.getContentResolver();
        mList = new ArrayList<Long>();
    }

    /**
     * �A�C�e����ǉ�����.
     * @param id ID
     */
    public void add(Long id) {
        mList.add(id);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        // ���X�g����擾
        Long id = mList.get(position);
        Uri uri = Uri.withAppendedPath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, id.toString());
        Bitmap bitmap = null;
        try {
            bitmap = getBitmap(uri);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // View �𐶐�
        ImageView imageView = new ImageView(mContext);
        imageView.setImageBitmap(bitmap);

        // �R���e�i�ɒǉ�
        container.addView(imageView);

        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // �R���e�i���� View ���폜
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }
    
    /**
     * Bitmap ���擾����.
     * @param imageUri �摜�� URI
     * @return Bitmap
     * @throws IOException
     */
    public Bitmap getBitmap(Uri imageUri) throws IOException {  
        BitmapFactory.Options mOptions = new BitmapFactory.Options();  
        mOptions.inSampleSize = 10;  
        Bitmap resizeBitmap = null;  
      
        InputStream is = mResolver.openInputStream(imageUri);  
        resizeBitmap = BitmapFactory.decodeStream(is, null, mOptions);  
        is.close();
      
        return resizeBitmap;  
    }  

}
