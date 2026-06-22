package com.google.android.material.timepicker;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes.dex */
public final class b implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ ClockFaceView g;

    public b(ClockFaceView clockFaceView) {
        this.g = clockFaceView;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        ClockFaceView clockFaceView = this.g;
        if (!clockFaceView.isShown()) {
            return true;
        }
        clockFaceView.getViewTreeObserver().removeOnPreDrawListener(this);
        int height = ((clockFaceView.getHeight() / 2) - clockFaceView.j.h) - clockFaceView.q;
        if (height != clockFaceView.h) {
            clockFaceView.h = height;
            clockFaceView.l();
            int i = clockFaceView.h;
            ClockHandView clockHandView = clockFaceView.j;
            clockHandView.p = i;
            clockHandView.invalidate();
        }
        return true;
    }
}
