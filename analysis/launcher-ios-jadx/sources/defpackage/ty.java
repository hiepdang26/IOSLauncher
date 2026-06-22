package defpackage;

import android.content.Context;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes.dex */
public final class ty {
    public static final int f = (int) Math.round(5.1000000000000005d);
    public final boolean a;
    public final int b;
    public final int c;
    public final int d;
    public final float e;

    public ty(Context context) {
        TypedValue typedValueN = z71.n(context, q41.elevationOverlayEnabled);
        boolean z = (typedValueN == null || typedValueN.type != 18 || typedValueN.data == 0) ? false : true;
        int iF = bf1.f(context, q41.elevationOverlayColor, 0);
        int iF2 = bf1.f(context, q41.elevationOverlayAccentColor, 0);
        int iF3 = bf1.f(context, q41.colorSurface, 0);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.a = z;
        this.b = iF;
        this.c = iF2;
        this.d = iF3;
        this.e = f2;
    }
}
