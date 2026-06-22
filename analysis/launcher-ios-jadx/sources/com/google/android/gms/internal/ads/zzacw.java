package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.InterruptedIOException;

/* JADX INFO: loaded from: classes.dex */
public class zzacw implements zzacl {
    private final zzacl zza;

    public zzacw(zzacl zzaclVar) {
        this.zza = zzaclVar;
    }

    @Override // com.google.android.gms.internal.ads.zzacl, com.google.android.gms.internal.ads.zzp
    public final int zza(byte[] bArr, int i, int i2) {
        return this.zza.zza(bArr, i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzacl
    public final int zzb(byte[] bArr, int i, int i2) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzacl
    public final int zzc(int i) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzacl
    public long zzd() {
        return this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzacl
    public long zze() {
        return this.zza.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzacl
    public long zzf() {
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzacl
    public final void zzg(int i) throws EOFException, InterruptedIOException {
        ((zzaby) this.zza).zzl(i, false);
    }

    @Override // com.google.android.gms.internal.ads.zzacl
    public final void zzh(byte[] bArr, int i, int i2) {
        ((zzaby) this.zza).zzm(bArr, i, i2, false);
    }

    @Override // com.google.android.gms.internal.ads.zzacl
    public final void zzi(byte[] bArr, int i, int i2) throws EOFException, InterruptedIOException {
        ((zzaby) this.zza).zzn(bArr, i, i2, false);
    }

    @Override // com.google.android.gms.internal.ads.zzacl
    public final void zzj() {
        this.zza.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzacl
    public final void zzk(int i) throws EOFException, InterruptedIOException {
        ((zzaby) this.zza).zzo(i, false);
    }

    @Override // com.google.android.gms.internal.ads.zzacl
    public final boolean zzm(byte[] bArr, int i, int i2, boolean z) {
        return this.zza.zzm(bArr, 0, 8, true);
    }

    @Override // com.google.android.gms.internal.ads.zzacl
    public final boolean zzn(byte[] bArr, int i, int i2, boolean z) {
        return this.zza.zzn(bArr, 0, 8, true);
    }
}
