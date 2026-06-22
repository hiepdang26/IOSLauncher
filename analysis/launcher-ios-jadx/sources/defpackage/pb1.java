package defpackage;

import android.content.res.Resources;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class pb1 {
    public final Resources a;
    public final Resources.Theme b;

    public pb1(Resources resources, Resources.Theme theme) {
        this.a = resources;
        this.b = theme;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && pb1.class == obj.getClass()) {
            pb1 pb1Var = (pb1) obj;
            if (this.a.equals(pb1Var.a) && Objects.equals(this.b, pb1Var.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.a, this.b);
    }
}
