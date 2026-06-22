package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class zzake implements zzadp {
    private final zzadp zza;
    private final zzajy zzb;
    private zzaka zzg;
    private zzaf zzh;
    private int zzd = 0;
    private int zze = 0;
    private byte[] zzf = zzet.zzf;
    private final zzek zzc = new zzek();

    public zzake(zzadp zzadpVar, zzajy zzajyVar) {
        this.zza = zzadpVar;
        this.zzb = zzajyVar;
    }

    private final void zzc(int i) {
        int length = this.zzf.length;
        int i2 = this.zze;
        if (length - i2 >= i) {
            return;
        }
        int i3 = i2 - this.zzd;
        int iMax = Math.max(i3 + i3, i + i3);
        byte[] bArr = this.zzf;
        byte[] bArr2 = iMax <= bArr.length ? bArr : new byte[iMax];
        System.arraycopy(bArr, this.zzd, bArr2, 0, i3);
        this.zzd = 0;
        this.zze = i3;
        this.zzf = bArr2;
    }

    public final /* synthetic */ void zza(long j, int i, zzajs zzajsVar) {
        zzdi.zzb(this.zzh);
        zzfxr zzfxrVar = zzajsVar.zza;
        long j2 = zzajsVar.zzc;
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(zzfxrVar.size());
        Iterator<E> it = zzfxrVar.iterator();
        while (it.hasNext()) {
            arrayList.add(((zzdb) it.next()).zza());
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("c", arrayList);
        bundle.putLong("d", j2);
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeBundle(bundle);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        zzek zzekVar = this.zzc;
        int length = bArrMarshall.length;
        zzekVar.zzI(bArrMarshall, length);
        this.zza.zzq(this.zzc, length);
        long j3 = zzajsVar.zzb;
        if (j3 == -9223372036854775807L) {
            zzdi.zzf(this.zzh.zzq == Long.MAX_VALUE);
        } else {
            long j4 = this.zzh.zzq;
            j = j4 == Long.MAX_VALUE ? j + j3 : j3 + j4;
        }
        this.zza.zzs(j, i, length, 0, null);
    }

    public final void zzb() {
        zzaka zzakaVar = this.zzg;
        if (zzakaVar != null) {
            zzakaVar.zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadp
    public final /* synthetic */ int zzf(zzp zzpVar, int i, boolean z) {
        return zzadn.zza(this, zzpVar, i, z);
    }

    @Override // com.google.android.gms.internal.ads.zzadp
    public final int zzg(zzp zzpVar, int i, boolean z, int i2) throws EOFException {
        if (this.zzg == null) {
            return this.zza.zzg(zzpVar, i, z, 0);
        }
        zzc(i);
        int iZza = zzpVar.zza(this.zzf, this.zze, i);
        if (iZza != -1) {
            this.zze += iZza;
            return iZza;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.google.android.gms.internal.ads.zzadp
    public final void zzl(zzaf zzafVar) {
        String str = zzafVar.zzm;
        str.getClass();
        zzdi.zzd(zzbn.zzb(str) == 3);
        if (!zzafVar.equals(this.zzh)) {
            this.zzh = zzafVar;
            this.zzg = this.zzb.zzc(zzafVar) ? this.zzb.zzb(zzafVar) : null;
        }
        if (this.zzg == null) {
            this.zza.zzl(zzafVar);
            return;
        }
        zzadp zzadpVar = this.zza;
        zzad zzadVarZzb = zzafVar.zzb();
        zzadVarZzb.zzX("application/x-media3-cues");
        zzadVarZzb.zzz(zzafVar.zzm);
        zzadVarZzb.zzab(Long.MAX_VALUE);
        zzadVarZzb.zzD(this.zzb.zza(zzafVar));
        zzadpVar.zzl(zzadVarZzb.zzad());
    }

    @Override // com.google.android.gms.internal.ads.zzadp
    public final /* synthetic */ void zzq(zzek zzekVar, int i) {
        zzadn.zzb(this, zzekVar, i);
    }

    @Override // com.google.android.gms.internal.ads.zzadp
    public final void zzr(zzek zzekVar, int i, int i2) {
        if (this.zzg == null) {
            this.zza.zzr(zzekVar, i, i2);
            return;
        }
        zzc(i);
        zzekVar.zzG(this.zzf, this.zze, i);
        this.zze += i;
    }

    @Override // com.google.android.gms.internal.ads.zzadp
    public final void zzs(final long j, final int i, int i2, int i3, zzado zzadoVar) {
        if (this.zzg == null) {
            this.zza.zzs(j, i, i2, i3, zzadoVar);
            return;
        }
        zzdi.zze(zzadoVar == null, "DRM on subtitles is not supported");
        int i4 = (this.zze - i3) - i2;
        this.zzg.zza(this.zzf, i4, i2, zzajz.zza(), new zzdn() { // from class: com.google.android.gms.internal.ads.zzakd
            @Override // com.google.android.gms.internal.ads.zzdn
            public final void zza(Object obj) {
                this.zza.zza(j, i, (zzajs) obj);
            }
        });
        int i5 = i4 + i2;
        this.zzd = i5;
        if (i5 == this.zze) {
            this.zzd = 0;
            this.zze = 0;
        }
    }
}
