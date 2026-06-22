package defpackage;

import android.util.SparseBooleanArray;
import androidx.appcompat.widget.RtlSpacingHelper;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class m11 {
    public static final j11 e = new j11();
    public final ArrayList a;
    public final l11 d;
    public final SparseBooleanArray c = new SparseBooleanArray();
    public final e9 b = new e9(0);

    public m11(ArrayList arrayList, ArrayList arrayList2) {
        this.a = arrayList;
        int size = arrayList.size();
        int i = RtlSpacingHelper.UNDEFINED;
        l11 l11Var = null;
        for (int i2 = 0; i2 < size; i2++) {
            l11 l11Var2 = (l11) arrayList.get(i2);
            int i3 = l11Var2.e;
            if (i3 > i) {
                l11Var = l11Var2;
                i = i3;
            }
        }
        this.d = l11Var;
    }
}
