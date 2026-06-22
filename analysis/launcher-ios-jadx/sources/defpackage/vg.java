package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.luutinhit.launcher6.CellLayout;

/* JADX INFO: loaded from: classes.dex */
public final class vg extends AnimatorListenerAdapter {
    public final /* synthetic */ int g;
    public boolean h = false;
    public final /* synthetic */ zg i;
    public final /* synthetic */ View j;
    public final /* synthetic */ CellLayout k;

    public /* synthetic */ vg(CellLayout cellLayout, zg zgVar, View view, int i) {
        this.g = i;
        this.k = cellLayout;
        this.i = zgVar;
        this.j = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        switch (this.g) {
            case 0:
                this.h = true;
                break;
            default:
                this.h = true;
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.g) {
            case 0:
                boolean z = this.h;
                zg zgVar = this.i;
                if (!z) {
                    zgVar.h = true;
                    this.j.requestLayout();
                }
                this.k.D.remove(zgVar);
                break;
            default:
                boolean z2 = this.h;
                zg zgVar2 = this.i;
                if (!z2) {
                    zgVar2.h = true;
                    this.j.requestLayout();
                }
                this.k.D.remove(zgVar2);
                break;
        }
    }
}
