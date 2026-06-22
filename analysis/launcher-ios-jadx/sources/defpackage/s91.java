package defpackage;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewpager.widget.ViewPager;
import com.luutinhit.launcherios.activity.WallpaperActivity;

/* JADX INFO: loaded from: classes.dex */
public final class s91 extends m91 implements View.OnClickListener {
    public final AppCompatImageView A;
    public final /* synthetic */ b8 B;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s91(b8 b8Var, View view) {
        super(view);
        this.B = b8Var;
        this.A = (AppCompatImageView) view.findViewById(v51.imageview_wallpaper_item);
        view.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WallpaperActivity wallpaperActivity = (WallpaperActivity) this.B.n;
        if (wallpaperActivity != null) {
            int iE = e();
            if (iE == 1) {
                wallpaperActivity.V.F(n90.n(wallpaperActivity, wallpaperActivity.getString(w61.pick_image)));
                return;
            }
            ViewPager viewPager = wallpaperActivity.D;
            viewPager.A = false;
            viewPager.u(iE - 1, 0, false, false);
            wallpaperActivity.E.setAlpha(0.0f);
            wallpaperActivity.E.setVisibility(0);
            wallpaperActivity.E.animate().withLayer().alpha(1.0f).setDuration(268L).start();
        }
    }
}
