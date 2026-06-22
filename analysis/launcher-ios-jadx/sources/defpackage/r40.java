package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import com.luutinhit.launcher6.BubbleTextView;
import com.luutinhit.launcher6.CellLayout;
import com.luutinhit.launcher6.FolderIcon;
import com.luutinhit.launcher6.util.DeleteCircleView;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class r40 extends AnimatorListenerAdapter {
    public final /* synthetic */ int g;
    public final /* synthetic */ t40 h;

    public /* synthetic */ r40(t40 t40Var, int i) {
        this.g = i;
        this.h = t40Var;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        switch (this.g) {
            case 1:
                t40 t40Var = this.h;
                try {
                    FolderIcon folderIcon = t40Var.e;
                    if (folderIcon != null) {
                        folderIcon.o.getIconView().setVisibility(0);
                    }
                    CellLayout cellLayout = t40Var.c;
                    if (cellLayout != null) {
                        Objects.toString(t40Var);
                        cellLayout.w.remove(t40Var);
                        cellLayout.invalidate();
                        CellLayout cellLayout2 = t40Var.c;
                        t40Var.c.getShortcutsAndWidgets().l(cellLayout2.I.b(t40Var.a, t40Var.b));
                    }
                } catch (Throwable th) {
                    th.getMessage();
                    return;
                }
                break;
            default:
                super.onAnimationEnd(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.g) {
            case 0:
                t40 t40Var = this.h;
                FolderIcon folderIcon = t40Var.e;
                if (folderIcon != null) {
                    folderIcon.o.getIconView().setVisibility(4);
                }
                CellLayout cellLayout = t40Var.c;
                if (cellLayout != null) {
                    View viewB = cellLayout.I.b(t40Var.a, t40Var.b);
                    ng1 shortcutsAndWidgets = t40Var.c.getShortcutsAndWidgets();
                    shortcutsAndWidgets.getClass();
                    if (viewB instanceof BubbleTextView) {
                        ((BubbleTextView) viewB).u.c(8, true);
                    } else if (viewB instanceof pk0) {
                        DeleteCircleView deleteCircleView = ((pk0) viewB).n;
                        Objects.toString(deleteCircleView);
                        if (deleteCircleView != null) {
                            deleteCircleView.c(8, true);
                        }
                    }
                    ((ValueAnimator) shortcutsAndWidgets.s.get(viewB)).end();
                    ((ValueAnimator) shortcutsAndWidgets.t.get(viewB)).start();
                }
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }
}
