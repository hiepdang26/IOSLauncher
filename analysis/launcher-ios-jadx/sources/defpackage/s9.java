package defpackage;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class s9 implements ny0 {
    public static final s9 g = new s9();
    public static final s9 h = new s9();

    @Override // defpackage.ny0
    public ly1 n(View view, ly1 ly1Var) {
        if (view != null) {
            ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).topMargin = 0;
        }
        return ly1.b;
    }
}
