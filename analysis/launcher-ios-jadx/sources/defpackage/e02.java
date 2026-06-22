package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.luutinhit.launcher6.CellLayout;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class e02 extends kw {
    public static String B(Context context, View view) {
        qh0 qh0Var = (qh0) view.getTag();
        if (qh0Var instanceof og1) {
            return context.getString(w61.create_folder_with, qh0Var.u);
        }
        if (!(qh0Var instanceof w40)) {
            return "";
        }
        if (TextUtils.isEmpty(qh0Var.u)) {
            ArrayList arrayList = ((w40) qh0Var).x;
            int size = arrayList.size();
            og1 og1Var = null;
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                og1 og1Var2 = (og1) obj;
                if (og1Var == null || og1Var.q > og1Var2.q) {
                    og1Var = og1Var2;
                }
            }
            if (og1Var != null) {
                return context.getString(w61.add_to_folder_with_app, og1Var.u);
            }
        }
        return context.getString(w61.add_to_folder, qh0Var.u);
    }

    @Override // defpackage.kw
    public final int A(int i) {
        CellLayout cellLayout = this.w;
        int countX = cellLayout.getCountX();
        int countY = cellLayout.getCountY();
        int i2 = i % countX;
        int i3 = i / countX;
        xk xkVar = this.y.i;
        int i4 = xkVar.b;
        if (i4 == 3 && cellLayout.J) {
            return -1;
        }
        if (i4 != 3) {
            View viewB = cellLayout.I.b(i2, i3);
            if (viewB != null && viewB != ((View) xkVar.d)) {
                if (xkVar.b == 2) {
                    return -1;
                }
                qh0 qh0Var = (qh0) viewB.getTag();
                if (!(qh0Var instanceof v6) && !(qh0Var instanceof w40) && !(qh0Var instanceof og1)) {
                    return -1;
                }
            }
            return i;
        }
        qh0 qh0Var2 = (qh0) xkVar.c;
        int i5 = qh0Var2.m;
        int i6 = qh0Var2.n;
        for (int i7 = 0; i7 < i5; i7++) {
            for (int i8 = 0; i8 < i6; i8++) {
                int i9 = i2 - i7;
                int i10 = i3 - i8;
                if (i9 >= 0 && i10 >= 0) {
                    boolean z = true;
                    for (int i11 = i9; i11 < i9 + i5 && z; i11++) {
                        for (int i12 = i10; i12 < i10 + i6; i12++) {
                            if (i11 < countX && i12 < countY) {
                                if (i11 >= cellLayout.l || i12 >= cellLayout.m) {
                                    throw new RuntimeException("Position exceeds the bound of this CellLayout");
                                }
                                if (!cellLayout.s[i11][i12]) {
                                }
                            }
                            z = false;
                        }
                    }
                    if (z) {
                        return (countX * i10) + i9;
                    }
                }
            }
        }
        return -1;
    }

    @Override // defpackage.kw
    public final String x(int i) {
        CellLayout cellLayout = this.w;
        int countX = i % cellLayout.getCountX();
        int countX2 = i / cellLayout.getCountX();
        xk xkVar = this.y.i;
        View viewB = cellLayout.I.b(countX, countX2);
        Context context = this.x;
        if (viewB == null || viewB == ((View) xkVar.d)) {
            return context.getString(w61.item_moved);
        }
        qh0 qh0Var = (qh0) viewB.getTag();
        return ((qh0Var instanceof v6) || (qh0Var instanceof og1)) ? context.getString(w61.folder_created) : qh0Var instanceof w40 ? context.getString(w61.added_to_folder) : "";
    }

    @Override // defpackage.kw
    public final String z(int i) {
        CellLayout cellLayout = this.w;
        int countX = i % cellLayout.getCountX();
        int countX2 = i / cellLayout.getCountX();
        xk xkVar = this.y.i;
        View viewB = cellLayout.I.b(countX, countX2);
        Context context = this.x;
        return (viewB == null || viewB == ((View) xkVar.d)) ? cellLayout.J ? context.getString(w61.move_to_hotseat_position, String.valueOf(i + 1)) : context.getString(w61.move_to_empty_cell, String.valueOf(countX2 + 1), String.valueOf(countX + 1)) : B(context, viewB);
    }
}
