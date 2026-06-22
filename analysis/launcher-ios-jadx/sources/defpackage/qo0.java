package defpackage;

import android.animation.ValueAnimator;
import android.graphics.drawable.ClipDrawable;
import android.os.Build;
import com.luutinhit.launcherios.searchview.SearchViewLayout;
import com.luutinhit.wallpaper.livewallpaper.LiveWallpaperRenderer;
import com.luutinhit.weather.WeatherActivity;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class qo0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ int g;
    public final /* synthetic */ Object h;

    public /* synthetic */ qo0(Object obj, int i) {
        this.g = i;
        this.h = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Object obj = this.h;
        switch (this.g) {
            case 0:
                so0 so0Var = (so0) obj;
                so0Var.getClass();
                valueAnimator.getAnimatedValue();
                LiveWallpaperRenderer liveWallpaperRenderer = so0Var.m;
                if (liveWallpaperRenderer != null) {
                    liveWallpaperRenderer.setBiasRange(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
                break;
            case 1:
                int i = SearchViewLayout.C;
                SearchViewLayout searchViewLayout = (SearchViewLayout) obj;
                searchViewLayout.getClass();
                if (Build.VERSION.SDK_INT >= 31) {
                    searchViewLayout.i.pullDetector.d(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
                break;
            default:
                int i2 = WeatherActivity.V;
                ((ClipDrawable) obj).setLevel(((Integer) valueAnimator.getAnimatedValue()).intValue());
                break;
        }
    }
}
