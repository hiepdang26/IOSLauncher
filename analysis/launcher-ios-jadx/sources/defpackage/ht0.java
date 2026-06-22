package defpackage;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;

/* JADX INFO: loaded from: classes.dex */
public final class ht0 implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, ut0 {
    public ik1 g;
    public u3 h;
    public wn0 i;

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        wn0 wn0Var = this.i;
        if (wn0Var.m == null) {
            wn0Var.m = new vn0(wn0Var);
        }
        this.g.q(wn0Var.m.getItem(i), null, 0);
    }

    @Override // defpackage.ut0
    public final void onCloseMenu(gt0 gt0Var, boolean z) {
        u3 u3Var;
        if ((z || gt0Var == this.g) && (u3Var = this.h) != null) {
            u3Var.dismiss();
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.i.onCloseMenu(this.g, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        ik1 ik1Var = this.g;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.h.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.h.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                ik1Var.c(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return ik1Var.performShortcut(i, keyEvent, 0);
    }

    @Override // defpackage.ut0
    public final boolean onOpenSubMenu(gt0 gt0Var) {
        return false;
    }
}
