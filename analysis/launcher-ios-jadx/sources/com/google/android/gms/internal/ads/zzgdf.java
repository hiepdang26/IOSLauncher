package com.google.android.gms.internal.ads;

import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
final class zzgdf extends TimeoutException {
    public /* synthetic */ zzgdf(String str, zzgde zzgdeVar) {
        super(str);
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
