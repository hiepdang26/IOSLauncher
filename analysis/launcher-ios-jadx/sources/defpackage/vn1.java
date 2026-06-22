package defpackage;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import com.google.android.gms.internal.ads.zzauo;

/* JADX INFO: loaded from: classes.dex */
public final class vn1 implements View.OnTouchListener {
    public final /* synthetic */ int g;
    public final /* synthetic */ Object h;

    public /* synthetic */ vn1(Object obj, int i) {
        this.g = i;
        this.h = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.g) {
            case 0:
                if (((Checkable) view).isChecked()) {
                    return ((GestureDetector) this.h).onTouchEvent(motionEvent);
                }
                return false;
            default:
                zzauo zzauoVar = ((dd2) this.h).n;
                if (zzauoVar == null) {
                    return false;
                }
                zzauoVar.zzd(motionEvent);
                return false;
        }
    }
}
