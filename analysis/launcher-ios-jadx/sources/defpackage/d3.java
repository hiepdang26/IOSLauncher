package defpackage;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class d3 implements to {
    public final to a;
    public final float b;

    public d3(float f, to toVar) {
        while (toVar instanceof d3) {
            toVar = ((d3) toVar).a;
            f += ((d3) toVar).b;
        }
        this.a = toVar;
        this.b = f;
    }

    @Override // defpackage.to
    public final float a(RectF rectF) {
        return Math.max(0.0f, this.a.a(rectF) + this.b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d3)) {
            return false;
        }
        d3 d3Var = (d3) obj;
        return this.a.equals(d3Var.a) && this.b == d3Var.b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, Float.valueOf(this.b)});
    }
}
