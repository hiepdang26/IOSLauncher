package com.luutinhit.launcherios.fragment;

import android.R;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.r71;
import defpackage.z21;

/* JADX INFO: loaded from: classes.dex */
public class BlurConfigFragment extends z21 {
    @Override // defpackage.w50
    public final void F() {
        this.J = true;
    }

    @Override // defpackage.z21
    public final void V() {
        U(r71.blur_config);
    }

    @Override // defpackage.w50
    public final void v() {
        RecyclerView recyclerView;
        this.J = true;
        try {
            View view = this.L;
            if (view == null || (recyclerView = (RecyclerView) view.findViewById(R.id.list)) == null) {
                return;
            }
            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.setFocusableInTouchMode(false);
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
