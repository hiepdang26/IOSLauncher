package defpackage;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Advanceable;

/* JADX INFO: loaded from: classes.dex */
public final class ax implements Runnable {
    public final /* synthetic */ int g;
    public final View h;

    public /* synthetic */ ax(int i, View view) {
        this.g = i;
        this.h = view;
    }

    public void a(String str) {
        View view = this.h;
        view.setContentDescription(str);
        view.removeCallbacks(this);
        view.postDelayed(this, 200L);
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                this.h.sendAccessibilityEvent(4);
                break;
            case 1:
                ((Advanceable) this.h).advance();
                break;
            default:
                View view = this.h;
                ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 1);
                break;
        }
    }
}
