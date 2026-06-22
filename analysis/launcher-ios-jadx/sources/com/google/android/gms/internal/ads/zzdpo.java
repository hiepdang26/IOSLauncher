package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import defpackage.o32;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzdpo extends FrameLayout {
    private final o32 zza;

    public zzdpo(Context context, View view, o32 o32Var) {
        super(context);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(view);
        this.zza = o32Var;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.zza.a(motionEvent);
        return false;
    }

    @Override // android.view.ViewGroup
    public final void removeAllViews() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < getChildCount(); i++) {
            KeyEvent.Callback childAt = getChildAt(i);
            if (childAt != null && (childAt instanceof zzcej)) {
                arrayList.add((zzcej) childAt);
            }
        }
        super.removeAllViews();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((zzcej) arrayList.get(i2)).destroy();
        }
    }
}
