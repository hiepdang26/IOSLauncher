package defpackage;

import android.view.View;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class ss1 implements View.OnAttachStateChangeListener {
    public final /* synthetic */ int g;

    public /* synthetic */ ss1(int i) {
        this.g = i;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        switch (this.g) {
            case 0:
                (view != null ? (lh0) view.getTag(a61.dataBinding) : null).v.run();
                view.removeOnAttachStateChangeListener(this);
                break;
            default:
                view.removeOnAttachStateChangeListener(this);
                WeakHashMap weakHashMap = qs1.a;
                fs1.c(view);
                break;
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        int i = this.g;
    }

    private final void a(View view) {
    }

    private final void b(View view) {
    }
}
