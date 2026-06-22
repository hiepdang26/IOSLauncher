package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbbc;
import java.util.ArrayList;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes.dex */
public final class zzakp implements zzaka {
    private final zzek zza = new zzek();
    private final zzek zzb = new zzek();
    private final zzako zzc = new zzako();
    private Inflater zzd;

    @Override // com.google.android.gms.internal.ads.zzaka
    public final void zza(byte[] bArr, int i, int i2, zzajz zzajzVar, zzdn zzdnVar) {
        this.zza.zzI(bArr, i2 + i);
        this.zza.zzK(i);
        zzek zzekVar = this.zza;
        if (zzekVar.zzb() > 0 && zzekVar.zzf() == 120) {
            if (this.zzd == null) {
                this.zzd = new Inflater();
            }
            if (zzet.zzI(zzekVar, this.zzb, this.zzd)) {
                zzek zzekVar2 = this.zzb;
                zzekVar.zzI(zzekVar2.zzM(), zzekVar2.zze());
            }
        }
        this.zzc.zze();
        ArrayList arrayList = new ArrayList();
        while (true) {
            zzek zzekVar3 = this.zza;
            if (zzekVar3.zzb() < 3) {
                zzdnVar.zza(new zzajs(arrayList, -9223372036854775807L, -9223372036854775807L));
                return;
            }
            zzako zzakoVar = this.zzc;
            int iZze = zzekVar3.zze();
            int iZzm = zzekVar3.zzm();
            int iZzq = zzekVar3.zzq();
            int iZzd = zzekVar3.zzd() + iZzq;
            zzdb zzdbVarZza = null;
            if (iZzd > iZze) {
                zzekVar3.zzK(iZze);
            } else {
                if (iZzm != 128) {
                    switch (iZzm) {
                        case 20:
                            zzako.zzd(zzakoVar, zzekVar3, iZzq);
                            break;
                        case zzbbc.zzt.zzm /* 21 */:
                            zzako.zzb(zzakoVar, zzekVar3, iZzq);
                            break;
                        case 22:
                            zzako.zzc(zzakoVar, zzekVar3, iZzq);
                            break;
                    }
                } else {
                    zzdbVarZza = zzakoVar.zza();
                    zzakoVar.zze();
                }
                zzekVar3.zzK(iZzd);
            }
            if (zzdbVarZza != null) {
                arrayList.add(zzdbVarZza);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaka
    public final /* synthetic */ void zzb() {
    }
}
