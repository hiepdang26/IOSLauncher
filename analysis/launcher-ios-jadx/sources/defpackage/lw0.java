package defpackage;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.internal.NavigationMenuView;

/* JADX INFO: loaded from: classes.dex */
public final class lw0 extends o91 {
    public final /* synthetic */ ow0 l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lw0(ow0 ow0Var, NavigationMenuView navigationMenuView) {
        super(navigationMenuView);
        this.l = ow0Var;
    }

    @Override // defpackage.o91, defpackage.e0
    public final void d(View view, r0 r0Var) {
        super.d(view, r0Var);
        ow0 ow0Var = this.l.k.m;
        int i = ow0Var.h.getChildCount() == 0 ? 0 : 1;
        for (int i2 = 0; i2 < ow0Var.k.j.size(); i2++) {
            if (ow0Var.k.e(i2) == 0) {
                i++;
            }
        }
        r0Var.a.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(i, 0, false));
    }
}
