package defpackage;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes.dex */
public final class uw extends GestureDetector.SimpleOnGestureListener {
    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return Math.abs(f2) <= Math.abs(f);
    }
}
