package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: loaded from: classes.dex */
public final class ht extends AnimatorListenerAdapter {
    public final /* synthetic */ int g;
    public final /* synthetic */ jt h;
    public final /* synthetic */ ViewPropertyAnimator i;
    public final /* synthetic */ View j;
    public final /* synthetic */ lt k;

    public /* synthetic */ ht(lt ltVar, jt jtVar, ViewPropertyAnimator viewPropertyAnimator, View view, int i) {
        this.g = i;
        this.k = ltVar;
        this.h = jtVar;
        this.i = viewPropertyAnimator;
        this.j = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.g) {
            case 0:
                this.i.setListener(null);
                View view = this.j;
                view.setAlpha(1.0f);
                view.setTranslationX(0.0f);
                view.setTranslationY(0.0f);
                jt jtVar = this.h;
                m91 m91Var = jtVar.a;
                lt ltVar = this.k;
                ltVar.c(m91Var);
                ltVar.r.remove(jtVar.a);
                ltVar.i();
                break;
            default:
                this.i.setListener(null);
                View view2 = this.j;
                view2.setAlpha(1.0f);
                view2.setTranslationX(0.0f);
                view2.setTranslationY(0.0f);
                jt jtVar2 = this.h;
                m91 m91Var2 = jtVar2.b;
                lt ltVar2 = this.k;
                ltVar2.c(m91Var2);
                ltVar2.r.remove(jtVar2.b);
                ltVar2.i();
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.g) {
            case 0:
                m91 m91Var = this.h.a;
                this.k.getClass();
                break;
            default:
                m91 m91Var2 = this.h.b;
                this.k.getClass();
                break;
        }
    }
}
