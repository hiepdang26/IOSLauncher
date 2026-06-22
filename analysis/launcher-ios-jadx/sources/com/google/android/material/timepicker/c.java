package com.google.android.material.timepicker;

import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import defpackage.e0;
import defpackage.n0;
import defpackage.nx0;
import defpackage.r0;
import defpackage.u51;

/* JADX INFO: loaded from: classes.dex */
public final class c extends e0 {
    public final /* synthetic */ ClockFaceView j;

    public c(ClockFaceView clockFaceView) {
        this.j = clockFaceView;
    }

    @Override // defpackage.e0
    public final void d(View view, r0 r0Var) {
        View.AccessibilityDelegate accessibilityDelegate = this.g;
        AccessibilityNodeInfo accessibilityNodeInfo = r0Var.a;
        accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        int iIntValue = ((Integer) view.getTag(u51.material_value_index)).intValue();
        if (iIntValue > 0) {
            View view2 = (View) this.j.m.get(iIntValue - 1);
            if (Build.VERSION.SDK_INT >= 22) {
                accessibilityNodeInfo.setTraversalAfter(view2);
            }
        }
        r0Var.j(nx0.v(0, 1, iIntValue, 1, false, view.isSelected()));
        accessibilityNodeInfo.setClickable(true);
        r0Var.b(n0.g);
    }

    @Override // defpackage.e0
    public final boolean g(View view, int i, Bundle bundle) {
        if (i != 16) {
            return super.g(view, i, bundle);
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        float width = (view.getWidth() / 2.0f) + view.getX();
        float height = (view.getHeight() / 2.0f) + view.getY();
        ClockFaceView clockFaceView = this.j;
        clockFaceView.j.onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, width, height, 0));
        clockFaceView.j.onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 1, width, height, 0));
        return true;
    }
}
