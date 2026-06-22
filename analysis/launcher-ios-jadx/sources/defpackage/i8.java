package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i8 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ float h;
    public final /* synthetic */ xj0 i;

    public /* synthetic */ i8(xj0 xj0Var, float f, int i) {
        this.g = i;
        this.i = xj0Var;
        this.h = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                ow1 ow1Var = (ow1) this.i;
                ow1Var.getClass();
                float fAbs = Math.abs(this.h);
                l8 l8Var = (l8) ow1Var.h;
                float interpolation = fAbs / l8Var.g.screenWidth;
                try {
                    interpolation = l8Var.w.getInterpolation(interpolation);
                } catch (Throwable th) {
                    th.getMessage();
                }
                l8Var.g.showBlurWallpaperBackground(interpolation);
                break;
            default:
                fz1 fz1Var = (fz1) this.i;
                fz1Var.getClass();
                float fAbs2 = Math.abs(this.h);
                wq wqVar = (wq) fz1Var.h;
                float interpolation2 = fAbs2 / wqVar.g.screenWidth;
                try {
                    interpolation2 = wqVar.v.getInterpolation(interpolation2);
                } catch (Throwable th2) {
                    th2.getMessage();
                }
                wqVar.g.showBlurWallpaperBackground(interpolation2);
                break;
        }
    }
}
