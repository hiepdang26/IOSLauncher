package defpackage;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class pb implements View.OnTouchListener {
    public final /* synthetic */ int g;

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.g) {
            case 0:
                return true;
            default:
                if ((motionEvent.getAction() & 255) != 0) {
                    return false;
                }
                view.performHapticFeedback(1);
                return false;
        }
    }
}
