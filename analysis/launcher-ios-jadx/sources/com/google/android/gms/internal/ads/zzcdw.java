package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.view.Surface;
import defpackage.cd2;
import defpackage.k92;
import defpackage.n42;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzcdw extends zzcbb implements zzgu, zzlq {
    public static final /* synthetic */ int zza = 0;
    private final Context zzb;
    private final zzcdh zzc;
    private final zzxt zzd;
    private final zzcbj zze;
    private final WeakReference zzf;
    private final zzvm zzg;
    private zzih zzh;
    private ByteBuffer zzi;
    private boolean zzj;
    private zzcba zzk;
    private int zzl;
    private int zzm;
    private long zzn;
    private final String zzo;
    private final int zzp;
    private Integer zzr;
    private final ArrayList zzs;
    private volatile zzcdj zzt;
    private final Object zzq = new Object();
    private final Set zzu = new HashSet();

    /* JADX WARN: Removed duplicated region for block: B:22:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzcdw(android.content.Context r4, com.google.android.gms.internal.ads.zzcbj r5, com.google.android.gms.internal.ads.zzcbk r6, java.lang.Integer r7) {
        /*
            Method dump skipped, instruction units count: 341
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcdw.<init>(android.content.Context, com.google.android.gms.internal.ads.zzcbj, com.google.android.gms.internal.ads.zzcbk, java.lang.Integer):void");
    }

    private final boolean zzad() {
        return this.zzt != null && this.zzt.zzq();
    }

    public final void finalize() {
        zzcbb.zzD().decrementAndGet();
        if (k92.b()) {
            k92.a("SimpleExoPlayerAdapter finalize ".concat(toString()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final long zzA() {
        if (zzad()) {
            return 0L;
        }
        return this.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final long zzB() {
        if (zzad()) {
            return this.zzt.zzl();
        }
        synchronized (this.zzq) {
            while (!this.zzs.isEmpty()) {
                long j = this.zzn;
                Map mapZze = ((zzgp) this.zzs.remove(0)).zze();
                long j2 = 0;
                if (mapZze != null) {
                    Iterator it = mapZze.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Map.Entry entry = (Map.Entry) it.next();
                        if (entry != null) {
                            try {
                                if (entry.getKey() != null && zzfuf.zzc("content-length", (CharSequence) entry.getKey()) && entry.getValue() != null && ((List) entry.getValue()).get(0) != null) {
                                    j2 = Long.parseLong((String) ((List) entry.getValue()).get(0));
                                    break;
                                }
                            } catch (NumberFormatException unused) {
                                continue;
                            }
                        }
                    }
                }
                this.zzn = j + j2;
            }
        }
        return this.zzn;
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final Integer zzC() {
        return this.zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final void zzF(Uri[] uriArr, String str) {
        zzG(uriArr, str, ByteBuffer.allocate(0), false);
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final void zzG(Uri[] uriArr, String str, ByteBuffer byteBuffer, boolean z) {
        zzuk zzuxVar;
        if (this.zzh != null) {
            this.zzi = byteBuffer;
            this.zzj = z;
            int length = uriArr.length;
            if (length == 1) {
                zzuxVar = zzaa(uriArr[0]);
            } else {
                zzuk[] zzukVarArr = new zzuk[length];
                for (int i = 0; i < uriArr.length; i++) {
                    zzukVarArr[i] = zzaa(uriArr[i]);
                }
                zzuxVar = new zzux(false, false, new zztt(), zzukVarArr);
            }
            this.zzh.zzB(zzuxVar);
            this.zzh.zzp();
            zzcbb.zzE().incrementAndGet();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final void zzH() {
        zzih zzihVar = this.zzh;
        if (zzihVar != null) {
            zzihVar.zzA(this);
            this.zzh.zzz();
            this.zzh = null;
            zzcbb.zzE().decrementAndGet();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final void zzI(long j) {
        zzj zzjVar = (zzj) this.zzh;
        zzjVar.zza(zzjVar.zzd(), j, 5, false);
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final void zzJ(int i) {
        this.zzc.zzk(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final void zzK(int i) {
        this.zzc.zzl(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final void zzL(zzcba zzcbaVar) {
        this.zzk = zzcbaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final void zzM(int i) {
        this.zzc.zzm(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final void zzN(int i) {
        this.zzc.zzn(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final void zzO(boolean z) {
        this.zzh.zzq(z);
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final void zzP(Integer num) {
        this.zzr = num;
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final void zzQ(boolean z) {
        if (this.zzh == null) {
            return;
        }
        int i = 0;
        while (true) {
            this.zzh.zzx();
            if (i >= 2) {
                return;
            }
            zzxt zzxtVar = this.zzd;
            zzxg zzxgVarZzc = zzxtVar.zzf().zzc();
            zzxgVarZzc.zzp(i, !z);
            zzxtVar.zzl(zzxgVarZzc);
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final void zzR(int i) {
        Iterator it = this.zzu.iterator();
        while (it.hasNext()) {
            zzcdg zzcdgVar = (zzcdg) ((WeakReference) it.next()).get();
            if (zzcdgVar != null) {
                zzcdgVar.zzm(i);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final void zzS(Surface surface, boolean z) {
        zzih zzihVar = this.zzh;
        if (zzihVar != null) {
            zzihVar.zzr(surface);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final void zzT(float f, boolean z) {
        zzih zzihVar = this.zzh;
        if (zzihVar != null) {
            zzihVar.zzs(f);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final void zzU() {
        this.zzh.zzt();
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final boolean zzV() {
        return this.zzh != null;
    }

    public final /* synthetic */ zzfs zzW(String str, boolean z) {
        zzcdw zzcdwVar = true != z ? null : this;
        zzcbj zzcbjVar = this.zze;
        return new zzcdz(str, zzcdwVar, zzcbjVar.zzd, zzcbjVar.zze, zzcbjVar.zzm, zzcbjVar.zzn);
    }

    public final /* synthetic */ zzfs zzX(String str, boolean z) {
        zzcdw zzcdwVar = true != z ? null : this;
        zzcbj zzcbjVar = this.zze;
        zzcdg zzcdgVar = new zzcdg(str, zzcdwVar, zzcbjVar.zzd, zzcbjVar.zze, zzcbjVar.zzh);
        this.zzu.add(new WeakReference(zzcdgVar));
        return zzcdgVar;
    }

    public final /* synthetic */ zzfs zzY(String str, boolean z) {
        zzgb zzgbVar = new zzgb();
        zzgbVar.zzf(str);
        zzgbVar.zze(true != z ? null : this);
        zzgbVar.zzc(this.zze.zzd);
        zzgbVar.zzd(this.zze.zze);
        zzgbVar.zzb(true);
        return zzgbVar.zza();
    }

    public final /* synthetic */ zzfs zzZ(zzfr zzfrVar) {
        zzfs zzfsVarZza = zzfrVar.zza();
        zzcdu zzcduVar = new zzcdu(this);
        return new zzcdj(this.zzb, zzfsVarZza, this.zzo, this.zzp, this, zzcduVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgu
    public final void zza(zzfs zzfsVar, zzfy zzfyVar, boolean z, int i) {
        this.zzl += i;
    }

    public final zzuk zzaa(Uri uri) {
        zzam zzamVar = new zzam();
        zzamVar.zzb(uri);
        zzbc zzbcVarZzc = zzamVar.zzc();
        zzvm zzvmVar = this.zzg;
        zzvmVar.zza(this.zze.zzf);
        return zzvmVar.zzb(zzbcVarZzc);
    }

    public final /* synthetic */ void zzab(boolean z, long j) {
        zzcba zzcbaVar = this.zzk;
        if (zzcbaVar != null) {
            zzcbaVar.zzi(z, j);
        }
    }

    public final /* synthetic */ zzle[] zzac(Handler handler, zzaay zzaayVar, zzpe zzpeVar, zzwl zzwlVar, zztg zztgVar) {
        zzsq zzsqVar = zzsq.zza;
        Context context = this.zzb;
        zzqv zzqvVar = new zzqv(context, new zzry(context), zzsqVar, false, handler, zzpeVar, new zzqb(context).zzc());
        Context context2 = this.zzb;
        return new zzle[]{zzqvVar, new zzaaa(context2, new zzry(context2), zzsqVar, 0L, false, handler, zzaayVar, -1, 30.0f)};
    }

    @Override // com.google.android.gms.internal.ads.zzgu
    public final void zzb(zzfs zzfsVar, zzfy zzfyVar, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzgu
    public final void zzc(zzfs zzfsVar, zzfy zzfyVar, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzgu
    public final void zzd(zzfs zzfsVar, zzfy zzfyVar, boolean z) {
        if (zzfsVar instanceof zzgp) {
            synchronized (this.zzq) {
                this.zzs.add((zzgp) zzfsVar);
            }
        } else if (zzfsVar instanceof zzcdj) {
            this.zzt = (zzcdj) zzfsVar;
            final zzcbk zzcbkVar = (zzcbk) this.zzf.get();
            if (((Boolean) n42.d.c.zza(zzbbw.zzbG)).booleanValue() && zzcbkVar != null && this.zzt.zzn()) {
                final HashMap map = new HashMap();
                map.put("gcacheHit", String.valueOf(this.zzt.zzp()));
                map.put("gcacheDownloaded", String.valueOf(this.zzt.zzo()));
                cd2.l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcds
                    @Override // java.lang.Runnable
                    public final void run() {
                        int i = zzcdw.zza;
                        zzcbkVar.zzd("onGcacheInfoEvent", map);
                    }
                });
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final void zze(zzlo zzloVar, zzaf zzafVar, zzho zzhoVar) {
        zzcbk zzcbkVar = (zzcbk) this.zzf.get();
        if (!((Boolean) n42.d.c.zza(zzbbw.zzbG)).booleanValue() || zzcbkVar == null) {
            return;
        }
        HashMap map = new HashMap();
        String str = zzafVar.zzl;
        if (str != null) {
            map.put("audioMime", str);
        }
        String str2 = zzafVar.zzm;
        if (str2 != null) {
            map.put("audioSampleMime", str2);
        }
        String str3 = zzafVar.zzj;
        if (str3 != null) {
            map.put("audioCodec", str3);
        }
        zzcbkVar.zzd("onMetadataEvent", map);
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final /* synthetic */ void zzf(zzlo zzloVar, int i, long j, long j2) {
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final /* synthetic */ void zzg(zzlo zzloVar, zzue zzueVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final void zzh(zzlo zzloVar, int i, long j) {
        this.zzm += i;
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final /* synthetic */ void zzi(zzbw zzbwVar, zzlp zzlpVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final void zzj(zzlo zzloVar, zztz zztzVar, zzue zzueVar, IOException iOException, boolean z) {
        zzcba zzcbaVar = this.zzk;
        if (zzcbaVar != null) {
            if (this.zze.zzj) {
                zzcbaVar.zzl("onLoadException", iOException);
            } else {
                zzcbaVar.zzk("onLoadError", iOException);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final void zzk(zzlo zzloVar, int i) {
        zzcba zzcbaVar = this.zzk;
        if (zzcbaVar != null) {
            zzcbaVar.zzm(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final void zzl(zzlo zzloVar, zzbp zzbpVar) {
        zzcba zzcbaVar = this.zzk;
        if (zzcbaVar != null) {
            zzcbaVar.zzk("onPlayerError", zzbpVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final /* synthetic */ void zzm(zzlo zzloVar, zzbv zzbvVar, zzbv zzbvVar2, int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final void zzn(zzlo zzloVar, Object obj, long j) {
        zzcba zzcbaVar = this.zzk;
        if (zzcbaVar != null) {
            zzcbaVar.zzv();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final /* synthetic */ void zzo(zzlo zzloVar, zzhn zzhnVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final void zzp(zzlo zzloVar, zzaf zzafVar, zzho zzhoVar) {
        zzcbk zzcbkVar = (zzcbk) this.zzf.get();
        if (!((Boolean) n42.d.c.zza(zzbbw.zzbG)).booleanValue() || zzcbkVar == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("frameRate", String.valueOf(zzafVar.zzt));
        map.put("bitRate", String.valueOf(zzafVar.zzi));
        map.put("resolution", zzafVar.zzr + "x" + zzafVar.zzs);
        String str = zzafVar.zzl;
        if (str != null) {
            map.put("videoMime", str);
        }
        String str2 = zzafVar.zzm;
        if (str2 != null) {
            map.put("videoSampleMime", str2);
        }
        String str3 = zzafVar.zzj;
        if (str3 != null) {
            map.put("videoCodec", str3);
        }
        zzcbkVar.zzd("onMetadataEvent", map);
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final void zzq(zzlo zzloVar, zzcp zzcpVar) {
        zzcba zzcbaVar = this.zzk;
        if (zzcbaVar != null) {
            zzcbaVar.zzD(zzcpVar.zzb, zzcpVar.zzc);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final int zzr() {
        return this.zzm;
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final int zzt() {
        return this.zzh.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final long zzv() {
        return this.zzh.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final long zzw() {
        return this.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final long zzx() {
        if (zzad() && this.zzt.zzp()) {
            return Math.min(this.zzl, this.zzt.zzk());
        }
        return 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final long zzy() {
        return this.zzh.zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final long zzz() {
        return this.zzh.zzl();
    }
}
