package com.google.android.gms.internal.ads;

import defpackage.uo;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzyw extends IOException {
    public zzyw(Throwable th) {
        super(uo.t("Unexpected ", th.getClass().getSimpleName(), th.getMessage() != null ? ": ".concat(String.valueOf(th.getMessage())) : ""), th);
    }
}
