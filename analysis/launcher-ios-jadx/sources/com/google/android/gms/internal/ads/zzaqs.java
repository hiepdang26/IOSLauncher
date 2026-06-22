package com.google.android.gms.internal.ads;

import java.io.Closeable;

/* JADX INFO: loaded from: classes.dex */
public final class zzaqs extends zzhen implements Closeable, AutoCloseable {
    static {
        zzheu.zzb(zzaqs.class);
    }

    public zzaqs(zzheo zzheoVar, zzaqr zzaqrVar) {
        zze(zzheoVar, zzheoVar.zzc(), zzaqrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhen, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // com.google.android.gms.internal.ads.zzhen
    public final String toString() {
        String string = this.zzc.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 7);
        sb.append("model(");
        sb.append(string);
        sb.append(")");
        return sb.toString();
    }
}
