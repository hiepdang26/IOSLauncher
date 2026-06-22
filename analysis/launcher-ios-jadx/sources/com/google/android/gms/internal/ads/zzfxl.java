package com.google.android.gms.internal.ads;

import androidx.appcompat.widget.ActivityChooserView;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzfxl {
    public static int zze(int i, int i2) {
        int i3 = i + (i >> 1) + 1;
        if (i3 < i2) {
            int iHighestOneBit = Integer.highestOneBit(i2 - 1);
            i3 = iHighestOneBit + iHighestOneBit;
        }
        return i3 < 0 ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : i3;
    }

    public abstract zzfxl zzb(Object obj);
}
