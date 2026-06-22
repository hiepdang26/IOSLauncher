package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: loaded from: classes.dex */
public final class ft extends AnimatorListenerAdapter {
    public final /* synthetic */ int g = 1;
    public final /* synthetic */ m91 h;
    public final /* synthetic */ View i;
    public final /* synthetic */ ViewPropertyAnimator j;
    public final /* synthetic */ lt k;

    public ft(lt ltVar, m91 m91Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.k = ltVar;
        this.h = m91Var;
        this.j = viewPropertyAnimator;
        this.i = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.g) {
            case 1:
                this.i.setAlpha(1.0f);
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.g) {
            case 0:
                this.j.setListener(null);
                this.i.setAlpha(1.0f);
                lt ltVar = this.k;
                m91 m91Var = this.h;
                ltVar.c(m91Var);
                ltVar.q.remove(m91Var);
                ltVar.i();
                break;
            default:
                this.j.setListener(null);
                lt ltVar2 = this.k;
                m91 m91Var2 = this.h;
                ltVar2.c(m91Var2);
                ltVar2.o.remove(m91Var2);
                ltVar2.i();
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.g) {
            case 0:
                this.k.getClass();
                break;
            default:
                this.k.getClass();
                break;
        }
    }

    public ft(lt ltVar, m91 m91Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
        this.k = ltVar;
        this.h = m91Var;
        this.i = view;
        this.j = viewPropertyAnimator;
    }
}
