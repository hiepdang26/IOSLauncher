package defpackage;

import androidx.core.widget.NestedScrollView;

/* JADX INFO: loaded from: classes.dex */
public abstract class sw0 {
    public static void a(NestedScrollView nestedScrollView, float f) {
        try {
            nestedScrollView.setFrameContentVelocity(f);
        } catch (LinkageError unused) {
        }
    }
}
