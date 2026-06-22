package defpackage;

import android.R;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes.dex */
public final class dg0 implements View.OnTouchListener {
    public final Dialog g;
    public final int h;
    public final int i;
    public final int j;

    public dg0(Dialog dialog, Rect rect) {
        this.g = dialog;
        this.h = rect.left;
        this.i = rect.top;
        this.j = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        View viewFindViewById = view.findViewById(R.id.content);
        int left = viewFindViewById.getLeft() + this.h;
        int width = viewFindViewById.getWidth() + left;
        if (new RectF(left, viewFindViewById.getTop() + this.i, width, viewFindViewById.getHeight() + r4).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            motionEventObtain.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            motionEventObtain.setAction(0);
            int i = this.j;
            motionEventObtain.setLocation((-i) - 1, (-i) - 1);
        }
        view.performClick();
        return this.g.onTouchEvent(motionEventObtain);
    }
}
