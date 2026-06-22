package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class zzhek extends zzhen implements zzaqu {
    protected final String zza = "moov";

    public zzhek(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzaqu
    public final String zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzaqu
    public final void zzb(zzheo zzheoVar, ByteBuffer byteBuffer, long j, zzaqr zzaqrVar) {
        zzheoVar.zzb();
        byteBuffer.remaining();
        byteBuffer.remaining();
        this.zzc = zzheoVar;
        this.zze = zzheoVar.zzb();
        zzheoVar.zze(zzheoVar.zzb() + j);
        this.zzf = zzheoVar.zzb();
        this.zzb = zzaqrVar;
    }
}
