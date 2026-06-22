package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzawo extends zzaxd {
    private final zzaus zzh;
    private final long zzi;
    private final long zzj;

    public zzawo(zzavp zzavpVar, String str, String str2, zzaro zzaroVar, int i, int i2, zzaus zzausVar, long j, long j2) {
        super(zzavpVar, "gAg/p/cQzJRjYz9LhE8cRk72DVV1Cpozf/TbzvACqLcTgM3sRjMEb3DCmwYhMmhP", "avDZD6/xoSbFYvWCy23XLncB75oD5DxKdrTKFY2O0hY=", zzaroVar, i, 11);
        this.zzh = zzausVar;
        this.zzi = j;
        this.zzj = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzaxd
    public final void zza() {
        zzaus zzausVar = this.zzh;
        if (zzausVar != null) {
            zzauq zzauqVar = new zzauq((String) this.zze.invoke(null, zzausVar.zzb(), Long.valueOf(this.zzi), Long.valueOf(this.zzj)));
            synchronized (this.zzd) {
                try {
                    this.zzd.zzz(zzauqVar.zza.longValue());
                    if (zzauqVar.zzb.longValue() >= 0) {
                        this.zzd.zzQ(zzauqVar.zzb.longValue());
                    }
                    if (zzauqVar.zzc.longValue() >= 0) {
                        this.zzd.zzf(zzauqVar.zzc.longValue());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
