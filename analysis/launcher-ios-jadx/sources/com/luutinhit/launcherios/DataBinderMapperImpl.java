package com.luutinhit.launcherios;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import com.luutinhit.launcher6.util.TextViewCustomFont;
import defpackage.a61;
import defpackage.lh0;
import defpackage.m61;
import defpackage.xr;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DataBinderMapperImpl extends xr {
    public static final SparseIntArray a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(1);
        a = sparseIntArray;
        sparseIntArray.put(m61.item_battery, 1);
    }

    @Override // defpackage.xr
    public final List a() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // defpackage.xr
    public final lh0 b(int i, View view) {
        int i2 = a.get(i);
        if (i2 > 0) {
            Object tag = view.getTag();
            if (tag == null) {
                throw new RuntimeException("view must have a tag");
            }
            if (i2 == 1) {
                if (!"layout/item_battery_0".equals(tag)) {
                    throw new IllegalArgumentException("The tag for item_battery is invalid. Received: " + tag);
                }
                Object[] objArr = new Object[3];
                lh0.G(view, objArr, true);
                lh0 lh0Var = new lh0(view, (TextViewCustomFont) objArr[1], (TextViewCustomFont) objArr[2]);
                lh0Var.F = -1L;
                lh0Var.C.setTag(null);
                lh0Var.D.setTag(null);
                ((LinearLayout) objArr[0]).setTag(null);
                view.setTag(a61.dataBinding, lh0Var);
                synchronized (lh0Var) {
                    lh0Var.F = 2L;
                }
                lh0Var.H();
                return lh0Var;
            }
        }
        return null;
    }
}
