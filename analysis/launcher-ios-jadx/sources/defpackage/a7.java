package defpackage;

import android.graphics.Rect;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public final class a7 implements Comparator {
    public final /* synthetic */ int g;
    public final /* synthetic */ Object h;

    public /* synthetic */ a7(Object obj, int i) {
        this.g = i;
        this.h = obj;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        Object obj3 = this.h;
        switch (this.g) {
            case 0:
                return ((wb2) obj3).m((String) obj, (String) obj2);
            case 1:
                qh0 qh0Var = (qh0) obj;
                qh0 qh0Var2 = (qh0) obj2;
                xg0 xg0Var = (xg0) obj3;
                int i = xg0Var.d;
                int i2 = xg0Var.c * i;
                long j = i2 * 6;
                long j2 = i2;
                long j3 = i;
                long j4 = (((long) qh0Var.l) * j3) + (qh0Var.j * j2) + (qh0Var.i * j) + ((long) qh0Var.k);
                long j5 = (((long) qh0Var2.l) * j3) + (qh0Var2.j * j2) + (qh0Var2.i * j) + ((long) qh0Var2.k);
                Rect rect = ar1.a;
                if (j4 < j5) {
                    return -1;
                }
                return j4 == j5 ? 0 : 1;
            case 2:
                nq0 nq0Var = (nq0) obj3;
                Long l = (Long) nq0Var.j.get((og1) obj);
                Long l2 = (Long) nq0Var.j.get((og1) obj2);
                long jLongValue = l == null ? 0L : l.longValue();
                long jLongValue2 = l2 != null ? l2.longValue() : 0L;
                Rect rect2 = ar1.a;
                if (jLongValue < jLongValue2) {
                    return -1;
                }
                return jLongValue == jLongValue2 ? 0 : 1;
            default:
                MaterialButton materialButton = (MaterialButton) obj;
                MaterialButton materialButton2 = (MaterialButton) obj2;
                int iCompareTo = Boolean.valueOf(materialButton.q).compareTo(Boolean.valueOf(materialButton2.q));
                if (iCompareTo != 0) {
                    return iCompareTo;
                }
                int iCompareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
                if (iCompareTo2 != 0) {
                    return iCompareTo2;
                }
                MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) obj3;
                return Integer.valueOf(materialButtonToggleGroup.indexOfChild(materialButton)).compareTo(Integer.valueOf(materialButtonToggleGroup.indexOfChild(materialButton2)));
        }
    }
}
