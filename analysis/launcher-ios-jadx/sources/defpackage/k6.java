package defpackage;

import android.os.Build;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class k6 implements Window.Callback {
    public final Window.Callback g;
    public final /* synthetic */ q6 h;

    public k6(q6 q6Var, Window.Callback callback) {
        this.h = q6Var;
        if (callback == null) {
            throw new IllegalArgumentException("Window callback may not be null");
        }
        this.g = callback;
    }

    public final boolean a(int i, Menu menu) {
        return this.g.onMenuOpened(i, menu);
    }

    public final void b(int i, Menu menu) {
        this.g.onPanelClosed(i, menu);
    }

    public final void c(List list, Menu menu, int i) {
        this.g.onProvideKeyboardShortcuts(list, menu, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.pk1 d(android.view.ActionMode.Callback r11) {
        /*
            Method dump skipped, instruction units count: 480
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.k6.d(android.view.ActionMode$Callback):pk1");
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.g.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.h.n(keyEvent) || this.g.dispatchKeyEvent(keyEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006e A[RETURN] */
    @Override // android.view.Window.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean dispatchKeyShortcutEvent(android.view.KeyEvent r7) {
        /*
            r6 = this;
            android.view.Window$Callback r0 = r6.g
            boolean r0 = r0.dispatchKeyShortcutEvent(r7)
            r1 = 1
            if (r0 != 0) goto L6f
            int r0 = r7.getKeyCode()
            q6 r2 = r6.h
            r2.t()
            ux1 r3 = r2.n
            r4 = 0
            if (r3 == 0) goto L3d
            tx1 r3 = r3.D
            if (r3 != 0) goto L1d
        L1b:
            r0 = 0
            goto L39
        L1d:
            gt0 r3 = r3.j
            if (r3 == 0) goto L1b
            int r5 = r7.getDeviceId()
            android.view.KeyCharacterMap r5 = android.view.KeyCharacterMap.load(r5)
            int r5 = r5.getKeyboardType()
            if (r5 == r1) goto L31
            r5 = 1
            goto L32
        L31:
            r5 = 0
        L32:
            r3.setQwertyMode(r5)
            boolean r0 = r3.performShortcut(r0, r7, r4)
        L39:
            if (r0 == 0) goto L3d
        L3b:
            r7 = 1
            goto L6b
        L3d:
            p6 r0 = r2.L
            if (r0 == 0) goto L52
            int r3 = r7.getKeyCode()
            boolean r0 = r2.x(r0, r3, r7)
            if (r0 == 0) goto L52
            p6 r7 = r2.L
            if (r7 == 0) goto L3b
            r7.l = r1
            goto L3b
        L52:
            p6 r0 = r2.L
            if (r0 != 0) goto L6a
            p6 r0 = r2.s(r4)
            r2.y(r0, r7)
            int r3 = r7.getKeyCode()
            boolean r7 = r2.x(r0, r3, r7)
            r0.k = r4
            if (r7 == 0) goto L6a
            goto L3b
        L6a:
            r7 = 0
        L6b:
            if (r7 == 0) goto L6e
            goto L6f
        L6e:
            return r4
        L6f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.k6.dispatchKeyShortcutEvent(android.view.KeyEvent):boolean");
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.g.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.g.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.g.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeFinished(ActionMode actionMode) {
        this.g.onActionModeFinished(actionMode);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeStarted(ActionMode actionMode) {
        this.g.onActionModeStarted(actionMode);
    }

    @Override // android.view.Window.Callback
    public final void onAttachedToWindow() {
        this.g.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0 || (menu instanceof gt0)) {
            return this.g.onCreatePanelMenu(i, menu);
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public final View onCreatePanelView(int i) {
        return this.g.onCreatePanelView(i);
    }

    @Override // android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.g.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return this.g.onMenuItemSelected(i, menuItem);
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuOpened(int i, Menu menu) {
        a(i, menu);
        q6 q6Var = this.h;
        if (i != 108) {
            q6Var.getClass();
            return true;
        }
        q6Var.t();
        ux1 ux1Var = q6Var.n;
        if (ux1Var != null && true != ux1Var.G) {
            ux1Var.G = true;
            ArrayList arrayList = ux1Var.H;
            if (arrayList.size() > 0) {
                arrayList.get(0).getClass();
                throw new ClassCastException();
            }
        }
        return true;
    }

    @Override // android.view.Window.Callback
    public final void onPanelClosed(int i, Menu menu) {
        b(i, menu);
        q6 q6Var = this.h;
        if (i != 108) {
            if (i != 0) {
                q6Var.getClass();
                return;
            }
            p6 p6VarS = q6Var.s(i);
            if (p6VarS.m) {
                q6Var.l(p6VarS, false);
                return;
            }
            return;
        }
        q6Var.t();
        ux1 ux1Var = q6Var.n;
        if (ux1Var == null || !ux1Var.G) {
            return;
        }
        ux1Var.G = false;
        ArrayList arrayList = ux1Var.H;
        if (arrayList.size() <= 0) {
            return;
        }
        arrayList.get(0).getClass();
        throw new ClassCastException();
    }

    @Override // android.view.Window.Callback
    public final void onPointerCaptureChanged(boolean z) {
        this.g.onPointerCaptureChanged(z);
    }

    @Override // android.view.Window.Callback
    public final boolean onPreparePanel(int i, View view, Menu menu) {
        gt0 gt0Var = menu instanceof gt0 ? (gt0) menu : null;
        if (i == 0 && gt0Var == null) {
            return false;
        }
        if (gt0Var != null) {
            gt0Var.D = true;
        }
        boolean zOnPreparePanel = this.g.onPreparePanel(i, view, menu);
        if (gt0Var != null) {
            gt0Var.D = false;
        }
        return zOnPreparePanel;
    }

    @Override // android.view.Window.Callback
    public final void onProvideKeyboardShortcuts(List list, Menu menu, int i) {
        gt0 gt0Var = this.h.s(0).h;
        if (gt0Var != null) {
            c(list, gt0Var, i);
        } else {
            c(list, menu, i);
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested(SearchEvent searchEvent) {
        return this.g.onSearchRequested(searchEvent);
    }

    @Override // android.view.Window.Callback
    public final void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.g.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z) {
        this.g.onWindowFocusChanged(z);
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        this.h.getClass();
        return i != 0 ? this.g.onWindowStartingActionMode(callback, i) : d(callback);
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested() {
        return this.g.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        if (Build.VERSION.SDK_INT >= 23) {
            return null;
        }
        this.h.getClass();
        return d(callback);
    }

    @Override // android.view.Window.Callback
    public final void onContentChanged() {
    }
}
