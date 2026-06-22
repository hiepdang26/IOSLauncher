package defpackage;

import androidx.constraintlayout.utils.widget.ImageFilterView;
import com.luutinhit.weather.WeatherActivity;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class vv1 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ WeatherActivity h;
    public final /* synthetic */ ImageFilterView i;

    public /* synthetic */ vv1(WeatherActivity weatherActivity, ImageFilterView imageFilterView, int i) {
        this.g = i;
        this.h = weatherActivity;
        this.i = imageFilterView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ImageFilterView imageFilterView = this.i;
        WeatherActivity weatherActivity = this.h;
        switch (this.g) {
            case 0:
                int i = WeatherActivity.V;
                weatherActivity.getClass();
                imageFilterView.animate().withLayer().alpha(1.0f).setDuration(10L).setStartDelay(0L).withEndAction(new vv1(weatherActivity, imageFilterView, 2)).start();
                break;
            case 1:
                int i2 = WeatherActivity.V;
                weatherActivity.getClass();
                imageFilterView.animate().withLayer().alpha(1.0f).setDuration(10L).setStartDelay(0L).withEndAction(new vv1(weatherActivity, imageFilterView, 3)).start();
                break;
            case 2:
                int i3 = WeatherActivity.V;
                weatherActivity.getClass();
                imageFilterView.animate().withLayer().alpha(0.5f).setDuration(50L).setStartDelay(50L).withEndAction(new vv1(weatherActivity, imageFilterView, 5)).start();
                break;
            case 3:
                int i4 = WeatherActivity.V;
                weatherActivity.getClass();
                imageFilterView.animate().withLayer().alpha(0.0f).setDuration(500L).setStartDelay(300L).withEndAction(new vv1(weatherActivity, imageFilterView, 4)).start();
                break;
            case 4:
                weatherActivity.E.removeView(imageFilterView);
                break;
            case 5:
                int i5 = WeatherActivity.V;
                weatherActivity.getClass();
                imageFilterView.animate().withLayer().alpha(0.0f).setDuration(500L).setStartDelay(300L).withEndAction(new vv1(weatherActivity, imageFilterView, 6)).start();
                break;
            default:
                weatherActivity.E.removeView(imageFilterView);
                break;
        }
    }
}
