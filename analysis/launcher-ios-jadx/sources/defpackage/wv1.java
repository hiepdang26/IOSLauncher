package defpackage;

import android.widget.ImageView;
import com.luutinhit.weather.WeatherActivity;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class wv1 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ ImageView h;

    public /* synthetic */ wv1(ImageView imageView, int i) {
        this.g = i;
        this.h = imageView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ImageView imageView = this.h;
        switch (this.g) {
            case 0:
                int i = WeatherActivity.V;
                imageView.animate().withLayer().alpha(0.26f).setDuration(10L).setStartDelay(0L).withEndAction(new wv1(imageView, 1)).start();
                break;
            case 1:
                int i2 = WeatherActivity.V;
                imageView.animate().withLayer().alpha(0.0f).setDuration(500L).setStartDelay(300L).withEndAction(new wv1(imageView, 3)).start();
                break;
            case 2:
                int i3 = WeatherActivity.V;
                imageView.animate().withLayer().alpha(0.05f).setDuration(50L).setStartDelay(50L).withEndAction(new wv1(imageView, 4)).start();
                break;
            case 3:
                int i4 = WeatherActivity.V;
                imageView.setVisibility(8);
                break;
            case 4:
                int i5 = WeatherActivity.V;
                imageView.animate().withLayer().alpha(0.0f).setDuration(500L).setStartDelay(300L).withEndAction(new wv1(imageView, 5)).start();
                break;
            case 5:
                int i6 = WeatherActivity.V;
                imageView.setVisibility(8);
                break;
            default:
                int i7 = WeatherActivity.V;
                imageView.animate().withLayer().alpha(0.26f).setDuration(10L).setStartDelay(0L).withEndAction(new wv1(imageView, 2)).start();
                break;
        }
    }
}
