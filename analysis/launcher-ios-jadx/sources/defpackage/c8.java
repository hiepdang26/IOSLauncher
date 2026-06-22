package defpackage;

import android.view.KeyEvent;
import androidx.recyclerview.widget.GridLayoutManager;
import com.luutinhit.launcherios.activity.WallpaperActivity;

/* JADX INFO: loaded from: classes.dex */
public final class c8 extends pa0 {
    public final /* synthetic */ int d;
    public final /* synthetic */ GridLayoutManager e;
    public final /* synthetic */ KeyEvent.Callback f;

    public /* synthetic */ c8(KeyEvent.Callback callback, GridLayoutManager gridLayoutManager, int i) {
        this.d = i;
        this.f = callback;
        this.e = gridLayoutManager;
    }

    @Override // defpackage.pa0
    public final int d(int i) {
        switch (this.d) {
            case 0:
                ((e8) this.f).m.getClass();
                if (i == 0) {
                }
                break;
            default:
                ((WallpaperActivity) this.f).L.getClass();
                if (i == 0) {
                }
                break;
        }
        return this.e.F;
    }
}
