package defpackage;

import com.luutinhit.launcherios.activity.WallpaperActivity;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class mv1 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ WallpaperActivity h;

    public /* synthetic */ mv1(WallpaperActivity wallpaperActivity, int i) {
        this.g = i;
        this.h = wallpaperActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                WallpaperActivity wallpaperActivity = this.h;
                int i = WallpaperActivity.W;
                yi0 yi0Var = new yi0(new nv1(wallpaperActivity), new nv1(wallpaperActivity));
                ya1 ya1VarK = z71.k(wallpaperActivity);
                yi0Var.m = ya1VarK;
                synchronized (ya1VarK.b) {
                    ya1VarK.b.add(yi0Var);
                    break;
                }
                yi0Var.l = Integer.valueOf(ya1VarK.a.incrementAndGet());
                yi0Var.a("add-to-queue");
                ya1VarK.a();
                if (yi0Var.n) {
                    ya1VarK.c.add(yi0Var);
                    return;
                } else {
                    ya1VarK.d.add(yi0Var);
                    return;
                }
            case 1:
                WallpaperActivity.A(this.h);
                return;
            default:
                this.h.G.setVisibility(8);
                return;
        }
    }
}
