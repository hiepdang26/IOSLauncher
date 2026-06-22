package defpackage;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a90 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ c90 h;
    public final /* synthetic */ Bitmap i;

    public /* synthetic */ a90(c90 c90Var, Bitmap bitmap, int i) {
        this.g = i;
        this.h = c90Var;
        this.i = bitmap;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                c90 c90Var = this.h;
                int i = c90Var.h;
                Bitmap bitmap = this.i;
                c90Var.h = c90Var.d(i, bitmap);
                try {
                    bitmap.recycle();
                } catch (Throwable unused) {
                    return;
                }
                break;
            default:
                c90 c90Var2 = this.h;
                c90Var2.g = c90Var2.d(c90Var2.g, this.i);
                break;
        }
    }
}
