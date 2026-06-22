package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public final class rv1 extends BroadcastReceiver {
    public final /* synthetic */ int a;

    public /* synthetic */ rv1(int i) {
        this.a = i;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        switch (this.a) {
            case 0:
                try {
                    jk0 jk0VarA = jk0.a();
                    jk0VarA.d = true;
                    fd blurWallpaperProvider = jk0VarA.g.getBlurWallpaperProvider();
                    blurWallpaperProvider.getClass();
                    ar1.q.execute(blurWallpaperProvider.p);
                    return;
                } catch (Throwable th) {
                    th.getMessage();
                    return;
                }
            default:
                synchronized (ub2.b) {
                    ub2.c = false;
                    ub2.d = false;
                    k92.h("Ad debug logging enablement is out of date.");
                    break;
                }
                np1.J(context);
                return;
        }
    }
}
