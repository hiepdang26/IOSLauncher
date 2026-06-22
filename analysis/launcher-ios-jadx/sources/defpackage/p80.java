package defpackage;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public final class p80 extends pr {
    public final Handler j;
    public final int k;
    public final long l;
    public Bitmap m;

    public p80(Handler handler, int i, long j) {
        this.j = handler;
        this.k = i;
        this.l = j;
    }

    @Override // defpackage.lm1
    public final void e(Object obj, wo1 wo1Var) {
        this.m = (Bitmap) obj;
        Handler handler = this.j;
        handler.sendMessageAtTime(handler.obtainMessage(1, this), this.l);
    }

    @Override // defpackage.lm1
    public final void i(Drawable drawable) {
        this.m = null;
    }
}
