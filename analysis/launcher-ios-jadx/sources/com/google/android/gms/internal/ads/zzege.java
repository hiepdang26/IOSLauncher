package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import defpackage.do0;
import defpackage.gy0;
import defpackage.n42;
import defpackage.x82;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes.dex */
public final class zzege implements zzeez {
    private final Context zza;
    private final zzcql zzb;
    private View zzc;
    private zzbov zzd;

    public zzege(Context context, zzcql zzcqlVar) {
        this.zza = context;
        this.zzb = zzcqlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeez
    public final Object zza(zzfex zzfexVar, final zzfel zzfelVar, final zzeew zzeewVar) throws zzffn {
        final View view;
        if (((Boolean) n42.d.c.zza(zzbbw.zzgZ)).booleanValue() && zzfelVar.zzag) {
            try {
                view = (View) gy0.r(this.zzd.zze());
                boolean zZzf = this.zzd.zzf();
                if (view == null) {
                    throw new zzffn(new Exception("BannerRtbAdapterWrapper interscrollerView should not be null"));
                }
                if (zZzf) {
                    try {
                        view = (View) zzgcj.zzn(zzgcj.zzh(null), new zzgbq() { // from class: com.google.android.gms.internal.ads.zzegb
                            @Override // com.google.android.gms.internal.ads.zzgbq
                            public final do0 zza(Object obj) {
                                return this.zza.zzc(view, zzfelVar, obj);
                            }
                        }, zzbzo.zze).get();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new zzffn(e);
                    }
                }
            } catch (RemoteException e2) {
                throw new zzffn(e2);
            }
        } else {
            view = this.zzc;
        }
        zzcpl zzcplVarZza = this.zzb.zza(new zzcsk(zzfexVar, zzfelVar, zzeewVar.zza), new zzcpr(view, null, new zzcrs() { // from class: com.google.android.gms.internal.ads.zzega
            @Override // com.google.android.gms.internal.ads.zzcrs
            public final x82 zza() throws zzffn {
                try {
                    return ((zzbql) zzeewVar.zzb).zze();
                } catch (RemoteException e3) {
                    throw new zzffn(e3);
                }
            }
        }, (zzfem) zzfelVar.zzu.get(0)));
        zzcplVarZza.zzg().zza(view);
        ((zzegp) zzeewVar.zzc).zzc(zzcplVarZza.zzj());
        return zzcplVarZza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzeez
    public final void zzb(zzfex zzfexVar, zzfel zzfelVar, zzeew zzeewVar) throws zzffn {
        try {
            ((zzbql) zzeewVar.zzb).zzq(zzfelVar.zzZ);
            zzegc zzegcVar = null;
            if (((Boolean) n42.d.c.zza(zzbbw.zzgZ)).booleanValue() && zzfelVar.zzag) {
                ((zzbql) zzeewVar.zzb).zzk(zzfelVar.zzU, zzfelVar.zzv.toString(), zzfexVar.zza.zza.zzd, new gy0(this.zza), new zzegd(this, zzeewVar, zzegcVar), (zzbos) zzeewVar.zzc, zzfexVar.zza.zza.zze);
            } else {
                ((zzbql) zzeewVar.zzb).zzj(zzfelVar.zzU, zzfelVar.zzv.toString(), zzfexVar.zza.zza.zzd, new gy0(this.zza), new zzegd(this, zzeewVar, zzegcVar), (zzbos) zzeewVar.zzc, zzfexVar.zza.zza.zze);
            }
        } catch (RemoteException e) {
            throw new zzffn(e);
        }
    }

    public final /* synthetic */ do0 zzc(View view, zzfel zzfelVar, Object obj) {
        return zzgcj.zzh(zzcrg.zza(this.zza, view, zzfelVar));
    }
}
