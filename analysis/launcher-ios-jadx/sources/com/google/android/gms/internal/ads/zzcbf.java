package com.google.android.gms.internal.ads;

import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
final class zzcbf implements Runnable {
    public zzcbf(zzcbh zzcbhVar) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        Looper.myLooper().quit();
    }
}
