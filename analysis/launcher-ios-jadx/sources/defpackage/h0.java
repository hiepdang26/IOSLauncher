package defpackage;

import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.webkit.TracingConfig;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class h0 {
    public static /* bridge */ /* synthetic */ ImageDecoder.Source d(Object obj) {
        return (ImageDecoder.Source) obj;
    }

    public static /* bridge */ /* synthetic */ AnimatedImageDrawable g(Drawable drawable) {
        return (AnimatedImageDrawable) drawable;
    }

    public static /* synthetic */ void o() {
        new TracingConfig.Builder();
    }

    public static /* bridge */ /* synthetic */ void u(Object obj) {
    }

    public static /* bridge */ /* synthetic */ boolean w(Drawable drawable) {
        return drawable instanceof AnimatedImageDrawable;
    }
}
