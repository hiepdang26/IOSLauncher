package defpackage;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
public final class kh1 implements g21 {
    public final bq0 a;
    public int b;
    public Bitmap.Config c;

    public kh1(bq0 bq0Var) {
        this.a = bq0Var;
    }

    @Override // defpackage.g21
    public final void a() {
        this.a.c(this);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof kh1) {
            kh1 kh1Var = (kh1) obj;
            if (this.b == kh1Var.b && vq1.b(this.c, kh1Var.c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.b * 31;
        Bitmap.Config config = this.c;
        return i + (config != null ? config.hashCode() : 0);
    }

    public final String toString() {
        return lh1.c(this.b, this.c);
    }
}
