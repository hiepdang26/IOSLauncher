package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import defpackage.n42;

/* JADX INFO: loaded from: classes.dex */
public final class zzdrv {
    public static Bundle zza(Pair... pairArr) {
        Bundle bundle = new Bundle();
        if (((Boolean) n42.d.c.zza(zzbbw.zzbS)).booleanValue()) {
            for (int i = 0; i < 2; i++) {
                Pair pair = pairArr[i];
                if (!TextUtils.isEmpty((CharSequence) pair.first) && ((Long) pair.second).longValue() > 0) {
                    bundle.putLong((String) pair.first, ((Long) pair.second).longValue());
                }
            }
        }
        return bundle;
    }
}
