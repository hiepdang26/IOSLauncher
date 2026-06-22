package com.google.android.gms.internal.ads;

import defpackage.do0;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes.dex */
abstract class zzgbi extends zzgbo {
    private static final zzgct zza = new zzgct(zzgbi.class);
    private zzfxm zzb;
    private final boolean zzc;
    private final boolean zzf;

    public zzgbi(zzfxm zzfxmVar, boolean z, boolean z2) {
        super(zzfxmVar.size());
        this.zzb = zzfxmVar;
        this.zzc = z;
        this.zzf = z2;
    }

    private final void zzG(int i, Future future) {
        try {
            zzf(i, zzgcj.zzp(future));
        } catch (ExecutionException e) {
            zzI(e.getCause());
        } catch (Throwable th) {
            zzI(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzH, reason: merged with bridge method [inline-methods] */
    public final void zzx(zzfxm zzfxmVar) {
        int iZzA = zzA();
        int i = 0;
        zzfuu.zzk(iZzA >= 0, "Less than 0 remaining futures");
        if (iZzA == 0) {
            if (zzfxmVar != null) {
                zzfzx it = zzfxmVar.iterator();
                while (it.hasNext()) {
                    Future future = (Future) it.next();
                    if (!future.isCancelled()) {
                        zzG(i, future);
                    }
                    i++;
                }
            }
            zzF();
            zzu();
            zzy(2);
        }
    }

    private final void zzI(Throwable th) {
        th.getClass();
        if (this.zzc && !zzd(th) && zzK(zzC(), th)) {
            zzJ(th);
        } else if (th instanceof Error) {
            zzJ(th);
        }
    }

    private static void zzJ(Throwable th) {
        zza.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFuture", "log", true != (th instanceof Error) ? "Got more than one input Future failure. Logging failures after the first" : "Input Future failed with Error", th);
    }

    private static boolean zzK(Set set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzgax
    public final String zza() {
        zzfxm zzfxmVar = this.zzb;
        return zzfxmVar != null ? "futures=".concat(zzfxmVar.toString()) : super.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzgax
    public final void zzb() {
        zzfxm zzfxmVar = this.zzb;
        zzy(1);
        if ((zzfxmVar != null) && isCancelled()) {
            boolean zZzt = zzt();
            zzfzx it = zzfxmVar.iterator();
            while (it.hasNext()) {
                ((Future) it.next()).cancel(zZzt);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final void zze(Set set) {
        set.getClass();
        if (isCancelled()) {
            return;
        }
        Throwable thZzl = zzl();
        Objects.requireNonNull(thZzl);
        zzK(set, thZzl);
    }

    public abstract void zzf(int i, Object obj);

    public abstract void zzu();

    public final void zzv() {
        Objects.requireNonNull(this.zzb);
        if (this.zzb.isEmpty()) {
            zzu();
            return;
        }
        if (!this.zzc) {
            final zzfxm zzfxmVar = this.zzf ? this.zzb : null;
            Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzgbh
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzx(zzfxmVar);
                }
            };
            zzfzx it = this.zzb.iterator();
            while (it.hasNext()) {
                ((do0) it.next()).addListener(runnable, zzgbx.INSTANCE);
            }
            return;
        }
        zzfzx it2 = this.zzb.iterator();
        final int i = 0;
        while (it2.hasNext()) {
            final do0 do0Var = (do0) it2.next();
            do0Var.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzgbg
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzw(do0Var, i);
                }
            }, zzgbx.INSTANCE);
            i++;
        }
    }

    public final /* synthetic */ void zzw(do0 do0Var, int i) {
        try {
            if (do0Var.isCancelled()) {
                this.zzb = null;
                cancel(false);
            } else {
                zzG(i, do0Var);
            }
            zzx(null);
        } catch (Throwable th) {
            zzx(null);
            throw th;
        }
    }

    public void zzy(int i) {
        this.zzb = null;
    }
}
