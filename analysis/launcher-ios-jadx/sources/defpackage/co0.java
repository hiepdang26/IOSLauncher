package defpackage;

import android.view.View;
import android.widget.ImageView;
import androidx.viewpager.widget.ViewPager;
import com.bumptech.glide.a;
import com.luutinhit.launcherios.activity.WallpaperActivity;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class co0 extends d11 {
    public final /* synthetic */ int c = 1;
    public final Object d;

    public co0(ArrayList arrayList) {
        this.d = arrayList;
    }

    @Override // defpackage.d11
    public final void a(ViewPager viewPager, Object obj) {
        switch (this.c) {
            case 0:
                viewPager.removeView((View) obj);
                break;
            default:
                viewPager.removeView((View) obj);
                break;
        }
    }

    @Override // defpackage.d11
    public final int c() {
        switch (this.c) {
            case 0:
                ArrayList arrayList = (ArrayList) this.d;
                arrayList.size();
                return arrayList.size();
            default:
                return ((WallpaperActivity) this.d).P.size() + 3;
        }
    }

    @Override // defpackage.d11
    public int d() {
        switch (this.c) {
            case 0:
                return -2;
            default:
                return super.d();
        }
    }

    @Override // defpackage.d11
    public final Object e(ViewPager viewPager, int i) {
        switch (this.c) {
            case 0:
                View view = (zw1) ((ArrayList) this.d).get(i);
                viewPager.addView(view);
                return view;
            default:
                WallpaperActivity wallpaperActivity = (WallpaperActivity) this.d;
                ImageView imageView = new ImageView(wallpaperActivity.B);
                if (i >= 3) {
                    ((na1) a.e(wallpaperActivity.B).s(((qv1) wallpaperActivity.P.get(i - 3)).a).U().c()).L(imageView);
                } else if (i == 0 || i == 1) {
                    ((na1) a.e(wallpaperActivity.B).r(Integer.valueOf(q61.wallpaper_default_1)).U().c()).L(imageView);
                } else if (i == 2) {
                    ((na1) a.e(wallpaperActivity.B).r(Integer.valueOf(q61.wallpaper_default_3)).U().c()).L(imageView);
                }
                viewPager.addView(imageView);
                return imageView;
        }
    }

    @Override // defpackage.d11
    public final boolean f(View view, Object obj) {
        switch (this.c) {
            case 0:
                if (view == obj) {
                }
                break;
            default:
                if (view == obj) {
                }
                break;
        }
        return false;
    }

    public co0(WallpaperActivity wallpaperActivity) {
        this.d = wallpaperActivity;
    }
}
