package defpackage;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class y91 implements to {
    public final float a;

    public y91(float f) {
        this.a = f;
    }

    @Override // defpackage.to
    public final float a(RectF rectF) {
        return rectF.height() * this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof y91) && this.a == ((y91) obj).a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.a)});
    }
}
