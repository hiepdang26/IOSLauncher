package defpackage;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: loaded from: classes.dex */
public final class om {
    public final ConstraintLayout a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public final /* synthetic */ ConstraintLayout h;

    public om(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2) {
        this.h = constraintLayout;
        this.a = constraintLayout2;
    }

    public static boolean a(int i, int i2, int i3) {
        if (i == i2) {
            return true;
        }
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode2 == 1073741824) {
            return (mode == Integer.MIN_VALUE || mode == 0) && i3 == size;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01d1 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0121  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(defpackage.jn r19, defpackage.ub r20) {
        /*
            Method dump skipped, instruction units count: 697
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.om.b(jn, ub):void");
    }
}
