package defpackage;

import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.DecorContentParent;

/* JADX INFO: loaded from: classes.dex */
public final class i6 implements ContentFrameLayout.OnAttachListener {
    public final /* synthetic */ q6 a;

    public i6(q6 q6Var) {
        this.a = q6Var;
    }

    @Override // androidx.appcompat.widget.ContentFrameLayout.OnAttachListener
    public final void onDetachedFromWindow() {
        q6 q6Var = this.a;
        DecorContentParent decorContentParent = q6Var.q;
        if (decorContentParent != null) {
            decorContentParent.dismissPopups();
        }
        if (q6Var.v != null) {
            q6Var.k.getDecorView().removeCallbacks(q6Var.w);
            if (q6Var.v.isShowing()) {
                try {
                    q6Var.v.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            q6Var.v = null;
        }
        zt1 zt1Var = q6Var.x;
        if (zt1Var != null) {
            zt1Var.b();
        }
        gt0 gt0Var = q6Var.s(0).h;
        if (gt0Var != null) {
            gt0Var.c(true);
        }
    }

    @Override // androidx.appcompat.widget.ContentFrameLayout.OnAttachListener
    public final void onAttachedFromWindow() {
    }
}
