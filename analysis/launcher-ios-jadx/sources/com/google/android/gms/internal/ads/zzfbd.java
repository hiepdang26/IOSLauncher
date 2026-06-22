package com.google.android.gms.internal.ads;

import defpackage.do0;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzfbd implements zzfcc {
    private zzcvx zza;
    private final Executor zzb = zzgda.zzb();

    public final zzcvx zza() {
        return this.zza;
    }

    public final do0 zzb(zzfcd zzfcdVar, zzfcb zzfcbVar, zzcvx zzcvxVar) {
        zzcvw zzcvwVarZza = zzfcbVar.zza(zzfcdVar.zzb);
        zzcvwVarZza.zzb(new zzfcg(true));
        zzcvx zzcvxVar2 = (zzcvx) zzcvwVarZza.zzh();
        this.zza = zzcvxVar2;
        final zzctc zzctcVarZzb = zzcvxVar2.zzb();
        final zzfhd zzfhdVar = new zzfhd();
        return zzgcj.zzm(zzgcj.zzn(zzgca.zzu(zzctcVarZzb.zzj()), new zzgbq(this) { // from class: com.google.android.gms.internal.ads.zzfbb
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) {
                zzfex zzfexVar = (zzfex) obj;
                zzfhdVar.zzb = zzfexVar;
                Iterator it = zzfexVar.zzb.zza.iterator();
                boolean z = false;
                loop0: while (true) {
                    if (it.hasNext()) {
                        Iterator it2 = ((zzfel) it.next()).zza.iterator();
                        while (it2.hasNext()) {
                            if (!((String) it2.next()).contains("FirstPartyRenderer")) {
                                break loop0;
                            }
                            z = true;
                        }
                    } else if (z) {
                        return zzctcVarZzb.zzi(zzgcj.zzh(zzfexVar));
                    }
                }
                return zzgcj.zzh(null);
            }
        }, this.zzb), new zzful() { // from class: com.google.android.gms.internal.ads.zzfbc
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                zzfhd zzfhdVar2 = zzfhdVar;
                zzfhdVar2.zzc = (zzcru) obj;
                return zzfhdVar2;
            }
        }, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzfcc
    public final /* bridge */ /* synthetic */ do0 zzc(zzfcd zzfcdVar, zzfcb zzfcbVar, Object obj) {
        return zzb(zzfcdVar, zzfcbVar, null);
    }

    @Override // com.google.android.gms.internal.ads.zzfcc
    public final /* synthetic */ Object zzd() {
        return this.zza;
    }
}
