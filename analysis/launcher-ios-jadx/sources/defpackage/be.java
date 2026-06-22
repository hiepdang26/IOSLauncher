package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.transformation.ExpandableTransformationBehavior;
import com.luutinhit.launcher6.BubbleTextView;
import com.luutinhit.launcher6.Folder;
import com.luutinhit.launcher6.Hotseat;
import com.luutinhit.launcher6.ioslauncher.IOSLauncher;
import com.luutinhit.launcher6.t;
import com.luutinhit.launcher6.v;
import com.luutinhit.launcherios.searchview.SearchViewLayout;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public final class be extends AnimatorListenerAdapter {
    public final /* synthetic */ int g;
    public final /* synthetic */ Object h;

    public /* synthetic */ be(Object obj, int i) {
        this.g = i;
        this.h = obj;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.g) {
            case 10:
                ((IOSLauncher) this.h).resumeNormalHomeState();
                break;
            case 13:
                try {
                    zl0 zl0Var = (zl0) this.h;
                    int[] iArr = zl0Var.c;
                    iArr[0] = 0;
                    iArr[1] = 0;
                    zl0Var.b.setVisibility(4);
                } catch (Throwable th) {
                    th.getMessage();
                    return;
                }
                break;
            case 19:
                yc2 yc2Var = (yc2) this.h;
                yc2Var.setEnabled(true);
                yc2Var.g.setEnabled(true);
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) throws IllegalAccessException, InvocationTargetException {
        Object obj = this.h;
        switch (this.g) {
            case 2:
                ux uxVar = (ux) obj;
                uxVar.c.setChecked(uxVar.m);
                uxVar.s.start();
                break;
            case 3:
                my myVar = (my) obj;
                myVar.post(new r1(this, 11));
                try {
                    myVar.x.getDragLayer().removeView(myVar);
                } catch (Throwable th) {
                    th.getMessage();
                    return;
                }
                break;
            case 4:
                ((ExpandableTransformationBehavior) obj).b = null;
                break;
            case 5:
                o30 o30Var = (o30) obj;
                o30Var.r = 0;
                o30Var.l = null;
                break;
            case 6:
                z30 z30Var = (z30) obj;
                z30Var.post(new r1(this, 12));
                try {
                    try {
                        z30Var.removeAllViews();
                        z30Var.c();
                    } catch (Throwable th2) {
                        th2.getMessage();
                    }
                    z30Var.x.getDragLayer().removeView(z30Var);
                } catch (Throwable th3) {
                    th3.getMessage();
                    return;
                }
                break;
            case 7:
                Folder folder = (Folder) obj;
                folder.post(new r1(this, 13));
                folder.z(true);
                break;
            case 8:
                ((HideBottomViewOnScrollBehavior) obj).c = null;
                break;
            case 9:
                ((Hotseat) obj).l = false;
                break;
            case 10:
                ((IOSLauncher) obj).resumeNormalHomeState();
                break;
            case 11:
                ((t) obj).appsLibraryLayout.postOnAnimation(new r1(this, 19));
                break;
            case 12:
            default:
                super.onAnimationEnd(animator);
                break;
            case 13:
                onAnimationCancel(animator);
                break;
            case 14:
                v vVar = (v) obj;
                int i = vVar.l0 - 1;
                vVar.l0 = i;
                el0 el0Var = vVar.m0;
                if (el0Var != null && i == 0) {
                    el0Var.run();
                    vVar.m0 = null;
                    break;
                }
                break;
            case 15:
                SearchViewLayout searchViewLayout = (SearchViewLayout) obj;
                searchViewLayout.setVisibility(8);
                int i2 = SearchViewLayout.C;
                ue1 ue1Var = searchViewLayout.w;
                if (ue1Var != null) {
                    ue1Var.n.filter(null);
                }
                searchViewLayout.setDrawingCacheEnabled(false);
                searchViewLayout.clearFocus();
                if (Build.VERSION.SDK_INT >= 31) {
                    searchViewLayout.i.pullDetector.k.getDragLayer().setRenderEffect(null);
                }
                break;
            case 16:
                ((ng1) obj).r = false;
                break;
            case 17:
                wb2 wb2Var = (wb2) obj;
                if (((ValueAnimator) wb2Var.i) == animator) {
                    wb2Var.i = null;
                }
                break;
            case 18:
                ((xo1) obj).l();
                animator.removeListener(this);
                break;
            case 19:
                yc2 yc2Var = (yc2) obj;
                yc2Var.setEnabled(true);
                yc2Var.g.setEnabled(true);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        switch (this.g) {
            case 1:
                ah ahVar = (ah) this.h;
                ahVar.d = 0.0f;
                ahVar.e = 0.0f;
                ahVar.g = ahVar.k.getChildrenScale();
                ahVar.i = true;
                break;
            default:
                super.onAnimationRepeat(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.g) {
            case 0:
                BubbleTextView bubbleTextView = (BubbleTextView) this.h;
                bubbleTextView.z = true;
                bubbleTextView.s.getLeft();
                bubbleTextView.s.getTop();
                bubbleTextView.setPivotX((bubbleTextView.n / 2.0f) + bubbleTextView.s.getLeft());
                bubbleTextView.setPivotY((bubbleTextView.n / 2.0f) + bubbleTextView.s.getTop());
                super.onAnimationStart(animator);
                break;
            case 5:
                o30 o30Var = (o30) this.h;
                o30Var.s.a(0, false);
                o30Var.r = 2;
                o30Var.l = animator;
                break;
            case 7:
                Folder folder = (Folder) this.h;
                folder.J(folder.getContext().getString(w61.folder_closed));
                folder.C = 1;
                break;
            case 11:
                break;
            case 12:
                pk0 pk0Var = (pk0) this.h;
                pk0Var.y = true;
                pk0Var.getWidth();
                pk0Var.getHeight();
                pk0Var.setPivotX(pk0Var.getWidth() / 2.0f);
                pk0Var.setPivotY(pk0Var.getHeight() / 2.0f);
                super.onAnimationStart(animator);
                break;
            case 13:
                ((zl0) this.h).b.setVisibility(0);
                break;
            case 15:
                ((SearchViewLayout) this.h).setDrawingCacheEnabled(true);
                break;
            case 19:
                yc2 yc2Var = (yc2) this.h;
                yc2Var.setEnabled(false);
                yc2Var.g.setEnabled(false);
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }

    private final void a(Animator animator) {
    }
}
