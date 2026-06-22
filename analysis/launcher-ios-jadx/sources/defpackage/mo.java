package defpackage;

import android.graphics.Rect;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: classes.dex */
public abstract class mo {
    public boolean a(View view, Rect rect) {
        return false;
    }

    public boolean b(View view, View view2) {
        return false;
    }

    public boolean d(View view, View view2) {
        return false;
    }

    public boolean f(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        return false;
    }

    public boolean g(CoordinatorLayout coordinatorLayout, View view, int i) {
        return false;
    }

    public boolean h(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
        return false;
    }

    public boolean i(View view, View view2, float f) {
        return false;
    }

    public void l(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        iArr[0] = iArr[0] + i3;
        iArr[1] = iArr[1] + i4;
        k(i4, view2);
    }

    public Parcelable o(View view) {
        return View.BaseSavedState.EMPTY_STATE;
    }

    public boolean p(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
        return false;
    }

    public boolean r(View view, MotionEvent motionEvent) {
        return false;
    }

    public void e() {
    }

    public void c(po poVar) {
    }

    public void k(int i, View view) {
    }

    public void m(CoordinatorLayout coordinatorLayout, View view) {
    }

    public void n(View view, Parcelable parcelable) {
    }

    public void q(CoordinatorLayout coordinatorLayout, View view, View view2, int i) {
    }

    public void j(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int[] iArr, int i3) {
    }
}
