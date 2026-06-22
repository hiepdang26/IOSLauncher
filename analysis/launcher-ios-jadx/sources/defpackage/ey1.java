package defpackage;

import android.view.DisplayCutout;
import android.view.WindowInsets;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class ey1 extends dy1 {
    public ey1(ly1 ly1Var, WindowInsets windowInsets) {
        super(ly1Var, windowInsets);
    }

    @Override // defpackage.iy1
    public ly1 a() {
        return ly1.h(this.c.consumeDisplayCutout(), null);
    }

    @Override // defpackage.iy1
    public bw e() {
        DisplayCutout displayCutout = this.c.getDisplayCutout();
        if (displayCutout == null) {
            return null;
        }
        return new bw(displayCutout);
    }

    @Override // defpackage.cy1, defpackage.iy1
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ey1)) {
            return false;
        }
        ey1 ey1Var = (ey1) obj;
        return Objects.equals(this.c, ey1Var.c) && Objects.equals(this.g, ey1Var.g) && cy1.y(this.h, ey1Var.h);
    }

    @Override // defpackage.iy1
    public int hashCode() {
        return this.c.hashCode();
    }
}
