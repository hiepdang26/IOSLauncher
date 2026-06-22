package androidx.databinding.library.baseAdapters;

import android.util.SparseIntArray;
import android.view.View;
import defpackage.lh0;
import defpackage.xr;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DataBinderMapperImpl extends xr {
    public static final SparseIntArray a = new SparseIntArray(0);

    @Override // defpackage.xr
    public final List a() {
        return new ArrayList(0);
    }

    @Override // defpackage.xr
    public final lh0 b(int i, View view) {
        if (a.get(i) <= 0 || view.getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
