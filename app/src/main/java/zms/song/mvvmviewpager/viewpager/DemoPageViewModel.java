package zms.song.mvvmviewpager.viewpager;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.widget.ImageView;

/**
 * Created by song on 2018/3/4.
 */

public class DemoPageViewModel extends BaseObservable {

    public final ObservableField<String> title = new ObservableField<>("");
    public final ObservableField<String> subTitle = new ObservableField<>("");
    public final ObservableInt position = new ObservableInt(-1);
    public final ObservableInt image = new ObservableInt(-1);

    public DemoPageViewModel(@NonNull String title ,
                             @NonNull String subTitle,
                             int position,
                             @DrawableRes int image) {
        this.title .set(title);
        this.subTitle .set(subTitle);
        this.position.set(position);
        this.image.set(image);
    }

    public void init(@NonNull String title ,
                     @NonNull String subTitle,
                     @IntRange(from = 0) int position,
                     @DrawableRes int image) {
        this.title .set(title);
        this.subTitle .set(subTitle);
        this.position.set(position);
        this.image.set(image);
    }

    @BindingAdapter({"url"})
    public static void setImageUrl(ImageView view, int res) {
        view.setImageResource(res);
    }

}
