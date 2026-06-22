package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import defpackage.do0;
import defpackage.hd2;
import defpackage.hs0;
import defpackage.k92;
import defpackage.n42;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public final class zzcdj extends zzfl {
    private final Context zza;
    private final zzfs zzb;
    private final String zzc;
    private final int zzd;
    private final boolean zze;
    private InputStream zzf;
    private boolean zzg;
    private Uri zzh;
    private volatile zzbah zzi;
    private boolean zzj;
    private boolean zzk;
    private boolean zzl;
    private boolean zzm;
    private long zzn;
    private do0 zzo;
    private final AtomicLong zzp;
    private final zzcdu zzq;

    public zzcdj(Context context, zzfs zzfsVar, String str, int i, zzgu zzguVar, zzcdu zzcduVar) {
        super(false);
        this.zza = context;
        this.zzb = zzfsVar;
        this.zzq = zzcduVar;
        this.zzc = str;
        this.zzd = i;
        this.zzj = false;
        this.zzk = false;
        this.zzl = false;
        this.zzm = false;
        this.zzn = 0L;
        this.zzp = new AtomicLong(-1L);
        this.zzo = null;
        this.zze = ((Boolean) n42.d.c.zza(zzbbw.zzbG)).booleanValue();
        zzf(zzguVar);
    }

    private final boolean zzr() {
        if (!this.zze) {
            return false;
        }
        zzbbn zzbbnVar = zzbbw.zzdT;
        n42 n42Var = n42.d;
        if (!((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue() || this.zzl) {
            return ((Boolean) n42Var.c.zza(zzbbw.zzdU)).booleanValue() && !this.zzm;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzp
    public final int zza(byte[] bArr, int i, int i2) throws IOException {
        if (!this.zzg) {
            throw new IOException("Attempt to read closed GcacheDataSource.");
        }
        InputStream inputStream = this.zzf;
        int iZza = inputStream != null ? inputStream.read(bArr, i, i2) : this.zzb.zza(bArr, i, i2);
        if (this.zze && this.zzf == null) {
            return iZza;
        }
        zzg(iZza);
        return iZza;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.util.concurrent.Future] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v20, types: [long] */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v45 */
    /* JADX WARN: Type inference failed for: r3v46 */
    /* JADX WARN: Type inference failed for: r5v3, types: [com.google.android.gms.internal.ads.zzcdw] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.ads.zzfs
    public final long zzb(zzfy zzfyVar) throws Throwable {
        zzbae zzbaeVarZzb;
        Long l;
        boolean z;
        boolean z2;
        long jElapsedRealtime;
        StringBuilder sb;
        zzbat zzbatVar;
        if (this.zzg) {
            throw new IOException("Attempt to open an already open GcacheDataSource.");
        }
        ?? r2 = 1;
        this.zzg = true;
        this.zzh = zzfyVar.zza;
        if (!this.zze) {
            zzj(zzfyVar);
        }
        this.zzi = zzbah.zza(zzfyVar.zza);
        zzbbn zzbbnVar = zzbbw.zzdQ;
        n42 n42Var = n42.d;
        if (!((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
            if (this.zzi != null) {
                this.zzi.zzh = zzfyVar.zze;
                this.zzi.zzi = zzfvj.zzc(this.zzc);
                this.zzi.zzj = this.zzd;
                zzbaeVarZzb = hd2.B.i.zzb(this.zzi);
            } else {
                zzbaeVarZzb = null;
            }
            if (zzbaeVarZzb != null && zzbaeVarZzb.zze()) {
                this.zzj = zzbaeVarZzb.zzd();
                this.zzl = zzbaeVarZzb.zzg();
                this.zzm = zzbaeVarZzb.zzf();
                this.zzn = zzbaeVarZzb.zza();
                this.zzk = true;
                if (!zzr()) {
                    this.zzf = zzbaeVarZzb.zzc();
                    if (this.zze) {
                        zzj(zzfyVar);
                    }
                    return -1L;
                }
            }
        } else if (this.zzi != null) {
            this.zzi.zzh = zzfyVar.zze;
            this.zzi.zzi = zzfvj.zzc(this.zzc);
            this.zzi.zzj = this.zzd;
            if (this.zzi.zzg) {
                l = (Long) n42Var.c.zza(zzbbw.zzdS);
            } else {
                l = (Long) n42Var.c.zza(zzbbw.zzdR);
            }
            ?? LongValue = l.longValue();
            hd2 hd2Var = hd2.B;
            hd2Var.j.getClass();
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            ?? Zza = zzbas.zza(this.zza, this.zzi);
            try {
                try {
                    zzbatVar = (zzbat) Zza.get(LongValue, TimeUnit.MILLISECONDS);
                } catch (Throwable th) {
                    th = th;
                    r2 = LongValue;
                }
                try {
                    this.zzj = zzbatVar.zzd();
                    this.zzl = zzbatVar.zzf();
                    this.zzm = zzbatVar.zze();
                    this.zzn = zzbatVar.zza();
                    if (!zzr()) {
                        this.zzf = zzbatVar.zzc();
                        if (this.zze) {
                            zzj(zzfyVar);
                        }
                        hd2Var.j.getClass();
                        long jElapsedRealtime3 = SystemClock.elapsedRealtime() - jElapsedRealtime2;
                        this.zzq.zza.zzab(true, jElapsedRealtime3);
                        this.zzk = true;
                        k92.a("Cache connection took " + jElapsedRealtime3 + "ms");
                        return -1L;
                    }
                    hd2Var.j.getClass();
                    long jElapsedRealtime4 = SystemClock.elapsedRealtime() - jElapsedRealtime2;
                    this.zzq.zza.zzab(true, jElapsedRealtime4);
                    this.zzk = true;
                    sb = new StringBuilder("Cache connection took ");
                    sb.append(jElapsedRealtime4);
                } catch (InterruptedException unused) {
                    z2 = true;
                    Zza.cancel(true);
                    Thread.currentThread().interrupt();
                    hd2.B.j.getClass();
                    jElapsedRealtime = SystemClock.elapsedRealtime() - jElapsedRealtime2;
                    this.zzq.zza.zzab(z2, jElapsedRealtime);
                    this.zzk = z2;
                    sb = new StringBuilder("Cache connection took ");
                    LongValue = z2;
                    sb.append(jElapsedRealtime);
                } catch (ExecutionException | TimeoutException unused2) {
                    z = true;
                    Zza.cancel(true);
                    hd2.B.j.getClass();
                    jElapsedRealtime = SystemClock.elapsedRealtime() - jElapsedRealtime2;
                    this.zzq.zza.zzab(z, jElapsedRealtime);
                    this.zzk = z;
                    sb = new StringBuilder("Cache connection took ");
                    LongValue = z;
                    sb.append(jElapsedRealtime);
                } catch (Throwable th2) {
                    th = th2;
                    hd2.B.j.getClass();
                    long jElapsedRealtime5 = SystemClock.elapsedRealtime() - jElapsedRealtime2;
                    this.zzq.zza.zzab(r2, jElapsedRealtime5);
                    this.zzk = r2;
                    k92.a("Cache connection took " + jElapsedRealtime5 + "ms");
                    throw th;
                }
            } catch (InterruptedException unused3) {
                z2 = false;
            } catch (ExecutionException | TimeoutException unused4) {
                z = false;
            } catch (Throwable th3) {
                th = th3;
                r2 = 0;
            }
            sb.append("ms");
            k92.a(sb.toString());
        }
        this.zzk = false;
        if (this.zzi != null) {
            zzfw zzfwVarZza = zzfyVar.zza();
            zzfwVarZza.zzd(Uri.parse(this.zzi.zza));
            zzfyVar = zzfwVarZza.zze();
        }
        return this.zzb.zzb(zzfyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final Uri zzc() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final void zzd() throws IOException {
        if (!this.zzg) {
            throw new IOException("Attempt to close an already closed GcacheDataSource.");
        }
        this.zzg = false;
        this.zzh = null;
        boolean z = (this.zze && this.zzf == null) ? false : true;
        InputStream inputStream = this.zzf;
        if (inputStream != null) {
            hs0.h(inputStream);
            this.zzf = null;
        } else {
            this.zzb.zzd();
        }
        if (z) {
            zzh();
        }
    }

    public final long zzk() {
        return this.zzn;
    }

    public final long zzl() {
        if (this.zzi != null) {
            if (this.zzp.get() != -1) {
                return this.zzp.get();
            }
            synchronized (this) {
                try {
                    if (this.zzo == null) {
                        this.zzo = zzbzo.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzcdi
                            @Override // java.util.concurrent.Callable
                            public final Object call() {
                                return this.zza.zzm();
                            }
                        });
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.zzo.isDone()) {
                try {
                    this.zzp.compareAndSet(-1L, ((Long) this.zzo.get()).longValue());
                    return this.zzp.get();
                } catch (InterruptedException | ExecutionException unused) {
                }
            }
        }
        return -1L;
    }

    public final Long zzm() {
        return Long.valueOf(hd2.B.i.zza(this.zzi));
    }

    public final boolean zzn() {
        return this.zzj;
    }

    public final boolean zzo() {
        return this.zzm;
    }

    public final boolean zzp() {
        return this.zzl;
    }

    public final boolean zzq() {
        return this.zzk;
    }
}
