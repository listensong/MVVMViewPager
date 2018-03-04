package zms.song.mvvmviewpager;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import zms.song.mvvmviewpager.databinding.ActivityMainBinding;
import zms.song.mvvmviewpager.viewpager.DemoAdapter;
import zms.song.mvvmviewpager.viewpager.DemoPageViewModel;
import zms.song.mvvmviewpager.viewpager.DemoViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        DemoViewModel viewModel = new DemoViewModel();
        mBinding.setDemoViewModel(viewModel);
        mBinding.getDemoViewModel().init(null);
    }

    @BindingAdapter({"dataList", "item", "br"})
    public static void setDataList(ViewPager viewPager, List<DemoPageViewModel> list, int layout, int br) {
        viewPager.setAdapter(new DemoAdapter<>(list, layout, br));
    }

    @BindingAdapter("pageListener")
    public static void setPageListener(ViewPager viewPager, ViewPager.OnPageChangeListener listener) {
        viewPager.addOnPageChangeListener(listener);
    }
}
