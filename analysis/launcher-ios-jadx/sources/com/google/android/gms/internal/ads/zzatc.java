package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
final class zzatc implements Runnable {
    private zzatc() {
        throw null;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CountDownLatch countDownLatch;
        try {
            zzatd.zzd = MessageDigest.getInstance("MD5");
            countDownLatch = zzatd.zzb;
        } catch (NoSuchAlgorithmException unused) {
            countDownLatch = zzatd.zzb;
        } catch (Throwable th) {
            zzatd.zzb.countDown();
            throw th;
        }
        countDownLatch.countDown();
    }

    public /* synthetic */ zzatc(zzatb zzatbVar) {
    }
}
