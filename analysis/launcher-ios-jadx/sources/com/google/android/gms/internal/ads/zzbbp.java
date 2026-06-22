package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import defpackage.k92;

/* JADX INFO: loaded from: classes.dex */
public final class zzbbp {
    public static final SharedPreferences zza(Context context) {
        try {
            return context.getSharedPreferences("google_ads_flags", 0);
        } catch (IllegalStateException unused) {
            k92.j(5);
            return null;
        }
    }
}
