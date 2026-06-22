package com.google.android.gms.internal.ads;

import defpackage.j92;
import defpackage.m82;
import defpackage.mc2;
import defpackage.xc2;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzfaj implements zzcwt, zzcyp, zzfbz, mc2, zzczb, zzcxg, zzdeq {
    private final zzfgq zza;
    private final AtomicReference zzb = new AtomicReference();
    private final AtomicReference zzc = new AtomicReference();
    private final AtomicReference zzd = new AtomicReference();
    private final AtomicReference zze = new AtomicReference();
    private final AtomicReference zzf = new AtomicReference();
    private final AtomicReference zzg = new AtomicReference();
    private zzfaj zzh = null;

    public zzfaj(zzfgq zzfgqVar) {
        this.zza = zzfgqVar;
    }

    public static zzfaj zzi(zzfaj zzfajVar) {
        zzfaj zzfajVar2 = new zzfaj(zzfajVar.zza);
        zzfajVar2.zzh = zzfajVar;
        return zzfajVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzcwt
    public final void zzdB(final j92 j92Var) {
        zzfaj zzfajVar = this.zzh;
        if (zzfajVar != null) {
            zzfajVar.zzdB(j92Var);
        } else {
            zzfbq.zza(this.zzb, new zzfbp() { // from class: com.google.android.gms.internal.ads.zzfae
                @Override // com.google.android.gms.internal.ads.zzfbp
                public final void zza(Object obj) {
                    ((zzazs) obj).zzc(j92Var);
                }
            });
            zzfbq.zza(this.zzb, new zzfbp() { // from class: com.google.android.gms.internal.ads.zzfaf
                @Override // com.google.android.gms.internal.ads.zzfbp
                public final void zza(Object obj) {
                    ((zzazs) obj).zzb(j92Var.g);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdeq
    public final void zzdG() {
        zzfaj zzfajVar = this.zzh;
        if (zzfajVar != null) {
            zzfajVar.zzdG();
        } else {
            zzfbq.zza(this.zzd, new zzfbp() { // from class: com.google.android.gms.internal.ads.zzfaa
                @Override // com.google.android.gms.internal.ads.zzfbp
                public final void zza(Object obj) {
                    ((zzazw) obj).zzb();
                }
            });
        }
    }

    @Override // defpackage.mc2
    public final void zzdH() {
    }

    @Override // com.google.android.gms.internal.ads.zzdeq
    public final void zzdf() {
    }

    @Override // defpackage.mc2
    public final void zzdk() {
    }

    @Override // defpackage.mc2
    public final void zzdq() {
        zzfaj zzfajVar = this.zzh;
        if (zzfajVar != null) {
            zzfajVar.zzdq();
        } else {
            zzfbq.zza(this.zzf, new zzfbp() { // from class: com.google.android.gms.internal.ads.zzezx
                @Override // com.google.android.gms.internal.ads.zzfbp
                public final void zza(Object obj) {
                    ((mc2) obj).zzdq();
                }
            });
        }
    }

    @Override // defpackage.mc2
    public final void zzdr() {
        zzfaj zzfajVar = this.zzh;
        if (zzfajVar != null) {
            zzfajVar.zzdr();
            return;
        }
        zzfbq.zza(this.zzf, new zzfbp() { // from class: com.google.android.gms.internal.ads.zzfai
            @Override // com.google.android.gms.internal.ads.zzfbp
            public final void zza(Object obj) {
                ((mc2) obj).zzdr();
            }
        });
        zzfbq.zza(this.zzd, new zzfbp() { // from class: com.google.android.gms.internal.ads.zzezv
            @Override // com.google.android.gms.internal.ads.zzfbp
            public final void zza(Object obj) {
                ((zzazw) obj).zzf();
            }
        });
        zzfbq.zza(this.zzd, new zzfbp() { // from class: com.google.android.gms.internal.ads.zzezw
            @Override // com.google.android.gms.internal.ads.zzfbp
            public final void zza(Object obj) {
                ((zzazw) obj).zze();
            }
        });
    }

    @Override // defpackage.mc2
    public final void zzdt() {
        zzfaj zzfajVar = this.zzh;
        if (zzfajVar != null) {
            zzfajVar.zzdt();
        } else {
            zzfbq.zza(this.zzf, new zzfbp() { // from class: com.google.android.gms.internal.ads.zzfah
                @Override // com.google.android.gms.internal.ads.zzfbp
                public final void zza(Object obj) {
                    ((mc2) obj).zzdt();
                }
            });
        }
    }

    @Override // defpackage.mc2
    public final void zzdu(final int i) {
        zzfaj zzfajVar = this.zzh;
        if (zzfajVar != null) {
            zzfajVar.zzdu(i);
        } else {
            zzfbq.zza(this.zzf, new zzfbp() { // from class: com.google.android.gms.internal.ads.zzfad
                @Override // com.google.android.gms.internal.ads.zzfbp
                public final void zza(Object obj) {
                    ((mc2) obj).zzdu(i);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcyp
    public final void zzg() {
        zzfaj zzfajVar = this.zzh;
        if (zzfajVar != null) {
            zzfajVar.zzg();
        } else {
            zzfbq.zza(this.zze, new zzfbp() { // from class: com.google.android.gms.internal.ads.zzfag
                @Override // com.google.android.gms.internal.ads.zzfbp
                public final void zza(Object obj) {
                    ((zzcyp) obj).zzg();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzczb
    public final void zzh(final xc2 xc2Var) {
        zzfaj zzfajVar = this.zzh;
        if (zzfajVar != null) {
            zzfajVar.zzh(xc2Var);
        } else {
            zzfbq.zza(this.zzg, new zzfbp() { // from class: com.google.android.gms.internal.ads.zzezu
                @Override // com.google.android.gms.internal.ads.zzfbp
                public final void zza(Object obj) {
                    ((m82) obj).b(xc2Var);
                }
            });
        }
    }

    public final void zzj() {
        zzfaj zzfajVar = this.zzh;
        if (zzfajVar != null) {
            zzfajVar.zzj();
            return;
        }
        this.zza.zza();
        zzfbq.zza(this.zzc, new zzfbp() { // from class: com.google.android.gms.internal.ads.zzfab
            @Override // com.google.android.gms.internal.ads.zzfbp
            public final void zza(Object obj) {
                ((zzazt) obj).zza();
            }
        });
        zzfbq.zza(this.zzd, new zzfbp() { // from class: com.google.android.gms.internal.ads.zzfac
            @Override // com.google.android.gms.internal.ads.zzfbp
            public final void zza(Object obj) {
                ((zzazw) obj).zzc();
            }
        });
    }

    public final void zzk(final zzazp zzazpVar) {
        zzfaj zzfajVar = this.zzh;
        if (zzfajVar != null) {
            zzfajVar.zzk(zzazpVar);
        } else {
            zzfbq.zza(this.zzb, new zzfbp() { // from class: com.google.android.gms.internal.ads.zzezz
                @Override // com.google.android.gms.internal.ads.zzfbp
                public final void zza(Object obj) {
                    ((zzazs) obj).zzd(zzazpVar);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfbz
    public final void zzl(zzfbz zzfbzVar) {
        this.zzh = (zzfaj) zzfbzVar;
    }

    public final void zzm(mc2 mc2Var) {
        this.zzf.set(mc2Var);
    }

    public final void zzn(m82 m82Var) {
        this.zzg.set(m82Var);
    }

    public final void zzo(zzazs zzazsVar) {
        this.zzb.set(zzazsVar);
    }

    public final void zzp(zzazw zzazwVar) {
        this.zzd.set(zzazwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcxg
    public final void zzq(final j92 j92Var) {
        zzfaj zzfajVar = this.zzh;
        if (zzfajVar != null) {
            zzfajVar.zzq(j92Var);
        } else {
            zzfbq.zza(this.zzd, new zzfbp() { // from class: com.google.android.gms.internal.ads.zzezy
                @Override // com.google.android.gms.internal.ads.zzfbp
                public final void zza(Object obj) {
                    ((zzazw) obj).zzd(j92Var);
                }
            });
        }
    }
}
