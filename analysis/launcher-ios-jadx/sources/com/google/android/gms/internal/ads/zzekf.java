package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import defpackage.do0;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class zzekf implements zzeet {
    private final zzeev zza;
    private final zzeez zzb;
    private final zzfjl zzc;
    private final zzgcu zzd;

    public zzekf(zzfjl zzfjlVar, zzgcu zzgcuVar, zzeev zzeevVar, zzeez zzeezVar) {
        this.zzc = zzfjlVar;
        this.zzd = zzgcuVar;
        this.zzb = zzeezVar;
        this.zza = zzeevVar;
    }

    public static final String zze(String str, int i) {
        return "Error from: " + str + ", code: " + i;
    }

    @Override // com.google.android.gms.internal.ads.zzeet
    public final do0 zza(final zzfex zzfexVar, final zzfel zzfelVar) {
        final zzeew zzeewVarZza;
        Iterator it = zzfelVar.zzt.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzeewVarZza = null;
                break;
            }
            try {
                zzeewVarZza = this.zza.zza((String) it.next(), zzfelVar.zzv);
                break;
            } catch (zzffn unused) {
            }
        }
        if (zzeewVarZza == null) {
            return zzgcj.zzg(new zzehv("Unable to instantiate mediation adapter class."));
        }
        zzbzt zzbztVar = new zzbzt();
        zzeewVarZza.zzc.zza(new zzeke(this, zzeewVarZza, zzbztVar));
        if (zzfelVar.zzM) {
            Bundle bundle = zzfexVar.zza.zza.zzd.s;
            Bundle bundle2 = bundle.getBundle(AdMobAdapter.class.getName());
            if (bundle2 == null) {
                bundle2 = new Bundle();
                bundle.putBundle(AdMobAdapter.class.getName(), bundle2);
            }
            bundle2.putBoolean("render_test_ad_label", true);
        }
        zzfjl zzfjlVar = this.zzc;
        return zzfiv.zzd(new zzfip() { // from class: com.google.android.gms.internal.ads.zzekc
            @Override // com.google.android.gms.internal.ads.zzfip
            public final void zza() {
                this.zza.zzd(zzfexVar, zzfelVar, zzeewVarZza);
            }
        }, this.zzd, zzfjf.ADAPTER_LOAD_AD_SYN, zzfjlVar).zzb(zzfjf.ADAPTER_LOAD_AD_ACK).zzd(zzbztVar).zzb(zzfjf.ADAPTER_WRAP_ADAPTER).zze(new zzfio() { // from class: com.google.android.gms.internal.ads.zzekd
            @Override // com.google.android.gms.internal.ads.zzfio
            public final Object zza(Object obj) {
                return this.zza.zzc(zzfexVar, zzfelVar, zzeewVarZza, (Void) obj);
            }
        }).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzeet
    public final boolean zzb(zzfex zzfexVar, zzfel zzfelVar) {
        return !zzfelVar.zzt.isEmpty();
    }

    public final /* synthetic */ Object zzc(zzfex zzfexVar, zzfel zzfelVar, zzeew zzeewVar, Void r4) {
        return this.zzb.zza(zzfexVar, zzfelVar, zzeewVar);
    }

    public final /* synthetic */ void zzd(zzfex zzfexVar, zzfel zzfelVar, zzeew zzeewVar) {
        this.zzb.zzb(zzfexVar, zzfelVar, zzeewVar);
    }
}
