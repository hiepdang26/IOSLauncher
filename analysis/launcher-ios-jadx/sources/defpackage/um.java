package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.Choreographer;
import android.view.View;
import com.luutinhit.launcher6.Folder;
import com.luutinhit.launcher6.FolderIcon;
import com.luutinhit.launcher6.SearchDropTargetBar;
import com.luutinhit.launcher6.Workspace;

/* JADX INFO: loaded from: classes.dex */
public final class um extends AnimatorListenerAdapter {
    public final /* synthetic */ int g;
    public final Object h;
    public final /* synthetic */ Object i;

    public /* synthetic */ um(Object obj, Object obj2, int i) {
        this.g = i;
        this.i = obj;
        this.h = obj2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.g) {
            case 7:
                ((cu1) this.i).onAnimationCancel((View) this.h);
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
                super.onAnimationEnd(animator);
                int i = ((vm) this.i).j;
                View view = (View) this.h;
                if (i != 0) {
                    view.setAlpha(1.0f);
                } else {
                    view.setVisibility(8);
                    view.setAlpha(0.0f);
                }
                break;
            case 1:
                ((ky) this.h).run();
                break;
            case 2:
                ((r30) this.h).run();
                break;
            case 3:
                Folder folder = (Folder) this.i;
                if (folder.b0 != null) {
                    Choreographer.getInstance().removeFrameCallback(folder.b0);
                }
                folder.b0 = null;
                folder.C = 2;
                ((Runnable) this.h).run();
                View viewB = folder.r.getCurrentCellLayout().I.b(0, 0);
                if (viewB != null) {
                    viewB.requestFocus();
                }
                break;
            case 4:
                ((FolderIcon) this.i).t = false;
                k40 k40Var = (k40) this.h;
                if (k40Var != null) {
                    k40Var.run();
                }
                break;
            case 5:
                f4.a((View) this.h, ((SearchDropTargetBar) this.i).l);
                break;
            case 6:
                ((e9) this.h).remove(animator);
                ((xo1) this.i).s.remove(animator);
                break;
            case 7:
                ((cu1) this.i).onAnimationEnd((View) this.h);
                break;
            default:
                dl0 dl0Var = ((Workspace) this.i).B0;
                if (dl0Var != null) {
                    dl0Var.run();
                }
                Runnable runnable = (Runnable) this.h;
                if (runnable != null) {
                    runnable.run();
                }
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.g) {
            case 1:
                ((my) this.i).getChildCount();
                break;
            case 2:
                ((z30) this.i).getChildCount();
                break;
            case 3:
                Choreographer choreographer = Choreographer.getInstance();
                Folder folder = (Folder) this.i;
                choreographer.postFrameCallback(folder.b0);
                folder.J(folder.r.getAccessibilityDescription());
                folder.C = 1;
                break;
            case 4:
                ((FolderIcon) this.i).t = true;
                break;
            case 5:
                ((View) this.h).setVisibility(0);
                break;
            case 6:
                ((xo1) this.i).s.add(animator);
                break;
            case 7:
                ((cu1) this.i).onAnimationStart((View) this.h);
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }

    public um(SearchDropTargetBar searchDropTargetBar, View view) {
        this.g = 5;
        this.i = searchDropTargetBar;
        this.h = view;
    }
}
