package defpackage;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public final class h5 implements Drawable.Callback {
    public final /* synthetic */ int g = 1;
    public Object h;

    public /* synthetic */ h5() {
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        switch (this.g) {
            case 0:
                ((k5) this.h).invalidateSelf();
                break;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        switch (this.g) {
            case 0:
                ((k5) this.h).scheduleSelf(runnable, j);
                break;
            default:
                Drawable.Callback callback = (Drawable.Callback) this.h;
                if (callback != null) {
                    callback.scheduleDrawable(drawable, runnable, j);
                }
                break;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        switch (this.g) {
            case 0:
                ((k5) this.h).unscheduleSelf(runnable);
                break;
            default:
                Drawable.Callback callback = (Drawable.Callback) this.h;
                if (callback != null) {
                    callback.unscheduleDrawable(drawable, runnable);
                }
                break;
        }
    }

    public h5(k5 k5Var) {
        this.h = k5Var;
    }

    private final void a(Drawable drawable) {
    }
}
