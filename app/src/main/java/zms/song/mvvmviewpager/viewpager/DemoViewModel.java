package zms.song.mvvmviewpager.viewpager;

import android.databinding.BaseObservable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import zms.song.mvvmviewpager.BR;
import zms.song.mvvmviewpager.R;

/**
 *
 * Created by song on 2018/2/28.
 */

public class DemoViewModel extends BaseObservable {
    public DemoViewModel() {

    }

    public void init(Bundle bundle) {
        initPageList(bundle);
    }

    public final ObservableInt mItemLayout = new ObservableInt(R.layout.item_demo);
    public final ObservableInt mBR = new ObservableInt(BR.demoPageViewModel);
    public final ObservableInt mCurrentPageIndex = new ObservableInt(1);
    public final ObservableField<String> mIndicator = new ObservableField<>("1/1");
    public final ObservableArrayList<DemoPageViewModel> mDemoPageViewModels = new ObservableArrayList<>();

    public final ViewPager.OnPageChangeListener mPageListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            mCurrentPageIndex.set(position + 1);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            mIndicator.set(mCurrentPageIndex.get() + "/" + mDemoPageViewModels.size());
        }
    };

    private void initPageList(Bundle bundle) {

        mDemoPageViewModels.clear();
        for (int i = 1; i < 21; i ++) {
            mDemoPageViewModels.add(new DemoPageViewModel("title " + i, "subTitle " + i, i, R.mipmap.ic_launcher));
        }

        mIndicator.set(mCurrentPageIndex.get() + "/" + mDemoPageViewModels.size());
    }

}
