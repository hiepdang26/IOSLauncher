package defpackage;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AnimationUtils;
import android.view.animation.OvershootInterpolator;
import com.luutinhit.launcher6.BlurScreenLayout;
import com.luutinhit.launcher6.Folder;
import com.luutinhit.launcher6.FolderPagedView;
import com.luutinhit.launcher6.t;

/* JADX INFO: loaded from: classes.dex */
public final class zc extends AnimatorListenerAdapter {
    public final /* synthetic */ int g;
    public boolean h;
    public final /* synthetic */ Object i;

    public /* synthetic */ zc(ViewGroup viewGroup, boolean z, int i) {
        this.g = i;
        this.i = viewGroup;
        this.h = z;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.g) {
            case 1:
                this.h = true;
                break;
            case 2:
                this.h = true;
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
                BlurScreenLayout blurScreenLayout = (BlurScreenLayout) this.i;
                blurScreenLayout.getAlpha();
                if (this.h) {
                    blurScreenLayout.o = null;
                    blurScreenLayout.setBackground(null);
                    blurScreenLayout.l.getDragLayer().removeView(blurScreenLayout);
                } else {
                    blurScreenLayout.o = null;
                    blurScreenLayout.setBackground(null);
                }
                break;
            case 1:
                if (this.h) {
                    this.h = false;
                } else {
                    r20 r20Var = (r20) this.i;
                    if (((Float) r20Var.F.getAnimatedValue()).floatValue() == 0.0f) {
                        r20Var.G = 0;
                        r20Var.l(0);
                    } else {
                        r20Var.G = 2;
                        r20Var.y.invalidate();
                    }
                }
                break;
            case 2:
                o30 o30Var = (o30) this.i;
                o30Var.r = 0;
                o30Var.l = null;
                if (!this.h) {
                    o30Var.s.a(4, false);
                }
                break;
            default:
                Folder folder = (Folder) this.i;
                ViewPropertyAnimator viewPropertyAnimatorTranslationX = folder.y.animate().withLayer().setDuration(633L).translationX(0.0f);
                boolean z = ar1.m;
                t tVar = folder.n;
                viewPropertyAnimatorTranslationX.setInterpolator(z ? AnimationUtils.loadInterpolator(tVar, R.interpolator.fast_out_slow_in) : new sp0());
                FolderPagedView folderPagedView = folder.r;
                int childCount = folderPagedView.G0.getChildCount();
                OvershootInterpolator overshootInterpolator = new OvershootInterpolator(4.9f);
                for (int i = 0; i < childCount; i++) {
                    folderPagedView.G0.getChildAt(i).animate().withLayer().scaleX(1.0f).scaleY(1.0f).setInterpolator(overshootInterpolator).setDuration(400L).setStartDelay((((long) i) * 150) + 300);
                }
                if (this.h) {
                    folder.p.h(tVar, 4, true);
                }
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.g) {
            case 2:
                o30 o30Var = (o30) this.i;
                o30Var.s.a(0, false);
                o30Var.r = 1;
                o30Var.l = animator;
                this.h = false;
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }

    public zc(o30 o30Var) {
        this.g = 2;
        this.i = o30Var;
    }

    public zc(r20 r20Var) {
        this.g = 1;
        this.i = r20Var;
        this.h = false;
    }
}
