package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public final class yt extends AnimatorListenerAdapter {
    public final /* synthetic */ ViewGroup g;
    public final /* synthetic */ View h;
    public final /* synthetic */ boolean i;
    public final /* synthetic */ li1 j;
    public final /* synthetic */ au k;

    public yt(ViewGroup viewGroup, View view, boolean z, li1 li1Var, au auVar) {
        this.g = viewGroup;
        this.h = view;
        this.i = z;
        this.j = li1Var;
        this.k = auVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        ViewGroup viewGroup = this.g;
        View view = this.h;
        viewGroup.endViewTransition(view);
        if (this.i) {
            k31.a(this.j.a, view);
        }
        this.k.d();
    }
}
