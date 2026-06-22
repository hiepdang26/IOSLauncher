package defpackage;

import android.view.MotionEvent;
import android.view.View;
import android.widget.AutoCompleteTextView;

/* JADX INFO: loaded from: classes.dex */
public final class tx implements View.OnTouchListener {
    public final /* synthetic */ int g;
    public final /* synthetic */ Object h;
    public final /* synthetic */ Object i;

    public /* synthetic */ tx(Object obj, Object obj2, int i) {
        this.g = i;
        this.i = obj;
        this.h = obj2;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.g) {
            case 0:
                if (motionEvent.getAction() == 1) {
                    ux uxVar = (ux) this.i;
                    uxVar.getClass();
                    long jCurrentTimeMillis = System.currentTimeMillis() - uxVar.n;
                    if (jCurrentTimeMillis < 0 || jCurrentTimeMillis > 300) {
                        uxVar.l = false;
                    }
                    ux.d(uxVar, (AutoCompleteTextView) this.h);
                    uxVar.l = true;
                    uxVar.n = System.currentTimeMillis();
                }
                return false;
            default:
                y00 y00Var = (y00) this.i;
                Object obj = y00Var.k;
                motionEvent.getActionMasked();
                if (motionEvent.getActionMasked() != 0) {
                    return true;
                }
                ((bz0) y00Var.l).g((oh0) this.h);
                return true;
        }
    }
}
