package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzawx extends zzaxd {
    private final zzavw zzh;
    private long zzi;

    public zzawx(zzavp zzavpVar, String str, String str2, zzaro zzaroVar, int i, int i2, zzavw zzavwVar) {
        super(zzavpVar, "1LUIVO6lhWmBJfHw9DMAIriIU/Yodc7yYpCjENKu6ENqSuhgH3MJrJCpj/jKq6Pa", "V8P78mWO+MxnWR283vMX+BSDXEvrm8XlQCYXMpvUe5w=", zzaroVar, i, 53);
        this.zzh = zzavwVar;
        if (zzavwVar != null) {
            this.zzi = zzavwVar.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxd
    public final void zza() {
        if (this.zzh != null) {
            this.zzd.zzP(((Long) this.zze.invoke(null, Long.valueOf(this.zzi))).longValue());
        }
    }
}
