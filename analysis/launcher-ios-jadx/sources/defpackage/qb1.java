package defpackage;

import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public abstract class qb1 {
    public static Handler getHandler(Handler handler) {
        return handler == null ? new Handler(Looper.getMainLooper()) : handler;
    }

    public final void callbackFailAsync(int i, Handler handler) {
        getHandler(handler).post(new xv1(this, i, 3));
    }

    public final void callbackSuccessAsync(Typeface typeface, Handler handler) {
        getHandler(handler).post(new wc(this, typeface, 16));
    }

    public abstract void onFontRetrievalFailed(int i);

    public abstract void onFontRetrieved(Typeface typeface);
}
