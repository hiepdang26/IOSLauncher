package com.luutinhit.launcher6.allapps;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.luutinhit.launcher6.t;
import defpackage.kj;
import defpackage.xu;

/* JADX INFO: loaded from: classes.dex */
public class AllAppsRecyclerViewContainerView extends FrameLayout {
    public AllAppsRecyclerViewContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        xu deviceProfile = ((t) context).getDeviceProfile();
        kj kjVar = new kj(context);
        int extraSize = kjVar.getExtraSize() + deviceProfile.X;
        addView(kjVar, extraSize, extraSize);
    }
}
