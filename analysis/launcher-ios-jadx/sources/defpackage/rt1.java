package defpackage;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public final class rt1 implements w81 {
    @Override // defpackage.w81
    public final void a(View view) {
        v81 v81Var = (v81) view.getLayoutParams();
        if (((ViewGroup.MarginLayoutParams) v81Var).width != -1 || ((ViewGroup.MarginLayoutParams) v81Var).height != -1) {
            throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
        }
    }

    @Override // defpackage.w81
    public final void d(View view) {
    }
}
