package defpackage;

import android.view.ViewGroup;
import android.view.WindowId;

/* JADX INFO: loaded from: classes.dex */
public final class vx1 {
    public final WindowId a;

    public vx1(ViewGroup viewGroup) {
        this.a = viewGroup.getWindowId();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof vx1) && ((vx1) obj).a.equals(this.a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
