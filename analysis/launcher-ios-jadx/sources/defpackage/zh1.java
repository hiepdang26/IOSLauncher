package defpackage;

import android.content.Context;
import android.util.DisplayMetrics;

/* JADX INFO: loaded from: classes.dex */
public final class zh1 extends pn0 {
    public final /* synthetic */ int p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ zh1(Context context, int i) {
        super(context);
        this.p = i;
    }

    @Override // defpackage.pn0
    public final float b(DisplayMetrics displayMetrics) {
        switch (this.p) {
            case 0:
                return 100.0f / displayMetrics.densityDpi;
            default:
                return 80.0f / displayMetrics.densityDpi;
        }
    }
}
