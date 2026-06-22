package defpackage;

import android.os.Build;
import androidx.appcompat.widget.ActivityChooserView;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class rl {
    public final ExecutorService a = z71.a(false);
    public final ExecutorService b = z71.a(true);
    public final jl1 c = new jl1(0);
    public final sz1 d;
    public final iy e;
    public final ow1 f;
    public final int g;
    public final int h;
    public final int i;

    public rl(jl1 jl1Var) {
        int i = tz1.a;
        this.d = new sz1();
        this.e = iy.j;
        this.f = new ow1(10);
        this.g = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.i = Build.VERSION.SDK_INT != 23 ? 20 : 10;
        this.h = 8;
    }
}
