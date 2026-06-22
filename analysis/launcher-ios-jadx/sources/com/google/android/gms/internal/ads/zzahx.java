package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
class zzahx {
    public final int zzd;

    public zzahx(int i) {
        this.zzd = i;
    }

    public static int zze(int i) {
        return (i >> 24) & 255;
    }

    public static String zzf(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append((char) ((i >> 24) & 255));
        sb.append((char) ((i >> 16) & 255));
        sb.append((char) ((i >> 8) & 255));
        sb.append((char) (i & 255));
        return sb.toString();
    }

    public String toString() {
        return zzf(this.zzd);
    }
}
