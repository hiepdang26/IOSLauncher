package defpackage;

import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public final class g91 {
    public int a;
    public int b;
    public int c;
    public int d;
    public Interpolator e;
    public boolean f;

    public final void a(RecyclerView recyclerView) {
        int i = this.d;
        if (i >= 0) {
            this.d = -1;
            recyclerView.U(i);
            this.f = false;
        } else if (this.f) {
            Interpolator interpolator = this.e;
            if (interpolator != null && this.c < 1) {
                throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
            }
            int i2 = this.c;
            if (i2 < 1) {
                throw new IllegalStateException("Scroll duration must be a positive number");
            }
            recyclerView.k0.c(this.a, this.b, i2, interpolator);
            this.f = false;
        }
    }
}
