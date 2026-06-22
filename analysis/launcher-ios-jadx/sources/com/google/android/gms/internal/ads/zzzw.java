package com.google.android.gms.internal.ads;

import android.view.Surface;

/* JADX INFO: loaded from: classes.dex */
public final class zzzw extends zzse {
    public zzzw(Throwable th, zzsf zzsfVar, Surface surface) {
        super(th, zzsfVar);
        System.identityHashCode(surface);
        if (surface != null) {
            surface.isValid();
        }
    }
}
