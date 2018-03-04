package zms.song.mvvmviewpager.viewpager;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.util.Pools;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * 参考自(侵删)： http://blog.csdn.net/shelljor/article/details/53728994
 * Created by song on 2018/2/28.
 */

public class DemoAdapter<T> extends PagerAdapter {
    private List<T> mList = new ArrayList<>();
    private int mLayoutResId;
    private int mVariableId;
    private Pools.Pool<View> mPools = new Pools.SimplePool<>(4);

    public DemoAdapter(@NonNull List<T> mList, @LayoutRes int mLayoutResId, int mVariableId) {
        this.mList = mList;
        this.mLayoutResId = mLayoutResId;
        this.mVariableId = mVariableId;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = mPools.acquire();
        if (view == null) {
            view = DataBindingUtil.inflate(LayoutInflater.from(container.getContext()), mLayoutResId, container, false).getRoot();
        }
        ViewDataBinding binding = DataBindingUtil.bind(view);
        binding.setVariable(mVariableId, mList.get(position));
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
        mPools.release(view);
    }
}