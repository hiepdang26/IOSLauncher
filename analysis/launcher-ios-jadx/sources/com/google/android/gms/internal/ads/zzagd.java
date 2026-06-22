package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzagd implements zzbj {
    public final String zzf;

    public zzagd(String str) {
        this.zzf = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzbj
    public /* synthetic */ void zza(zzbf zzbfVar) {
    }
}
