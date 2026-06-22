package defpackage;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes.dex */
public final class eb2 extends RelativeLayout {
    public final o32 g;
    public boolean h;

    public eb2(Context context, String str, String str2, String str3) {
        super(context);
        o32 o32Var = new o32(context);
        o32Var.c = str;
        this.g = o32Var;
        o32Var.e = str2;
        o32Var.d = str3;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.h) {
            return false;
        }
        this.g.a(motionEvent);
        return false;
    }
}
