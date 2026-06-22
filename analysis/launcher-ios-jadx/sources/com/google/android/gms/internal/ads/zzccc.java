package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.view.Surface;
import android.view.TextureView;
import defpackage.cd2;
import defpackage.hd2;
import defpackage.k92;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzccc extends zzcaq implements TextureView.SurfaceTextureListener, zzcba {
    private final zzcbk zzc;
    private final zzcbl zzd;
    private final zzcbj zze;
    private zzcap zzf;
    private Surface zzg;
    private zzcbb zzh;
    private String zzi;
    private String[] zzj;
    private boolean zzk;
    private int zzl;
    private zzcbi zzm;
    private final boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private int zzq;
    private int zzr;
    private float zzs;

    public zzccc(Context context, zzcbl zzcblVar, zzcbk zzcbkVar, boolean z, boolean z2, zzcbj zzcbjVar) {
        super(context);
        this.zzl = 1;
        this.zzc = zzcbkVar;
        this.zzd = zzcblVar;
        this.zzn = z;
        this.zze = zzcbjVar;
        setSurfaceTextureListener(this);
        zzcblVar.zza(this);
    }

    private static String zzT(String str, Exception exc) {
        return str + "/" + exc.getClass().getCanonicalName() + ":" + exc.getMessage();
    }

    private final void zzU() {
        zzcbb zzcbbVar = this.zzh;
        if (zzcbbVar != null) {
            zzcbbVar.zzQ(true);
        }
    }

    private final void zzV() {
        if (this.zzo) {
            return;
        }
        this.zzo = true;
        cd2.l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzccb
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzI();
            }
        });
        zzn();
        this.zzd.zzb();
        if (this.zzp) {
            zzp();
        }
    }

    private final void zzW(boolean z, Integer num) {
        zzcbb zzcbbVar = this.zzh;
        if (zzcbbVar != null && !z) {
            zzcbbVar.zzP(num);
            return;
        }
        if (this.zzi == null || this.zzg == null) {
            return;
        }
        if (z) {
            if (!zzad()) {
                k92.h("No valid ExoPlayerAdapter exists when switch source.");
                return;
            } else {
                zzcbbVar.zzU();
                zzY();
            }
        }
        if (this.zzi.startsWith("cache:")) {
            zzccv zzccvVarZzp = this.zzc.zzp(this.zzi);
            if (zzccvVarZzp instanceof zzcde) {
                zzcbb zzcbbVarZza = ((zzcde) zzccvVarZzp).zza();
                this.zzh = zzcbbVarZza;
                zzcbbVarZza.zzP(num);
                if (!this.zzh.zzV()) {
                    k92.h("Precached video player has been released.");
                    return;
                }
            } else {
                if (!(zzccvVarZzp instanceof zzcdb)) {
                    k92.h("Stream cache miss: ".concat(String.valueOf(this.zzi)));
                    return;
                }
                zzcdb zzcdbVar = (zzcdb) zzccvVarZzp;
                String strZzF = zzF();
                ByteBuffer byteBufferZzk = zzcdbVar.zzk();
                boolean zZzl = zzcdbVar.zzl();
                String strZzi = zzcdbVar.zzi();
                if (strZzi == null) {
                    k92.h("Stream cache URL is null.");
                    return;
                } else {
                    zzcbb zzcbbVarZzE = zzE(num);
                    this.zzh = zzcbbVarZzE;
                    zzcbbVarZzE.zzG(new Uri[]{Uri.parse(strZzi)}, strZzF, byteBufferZzk, zZzl);
                }
            }
        } else {
            this.zzh = zzE(num);
            String strZzF2 = zzF();
            Uri[] uriArr = new Uri[this.zzj.length];
            int i = 0;
            while (true) {
                String[] strArr = this.zzj;
                if (i >= strArr.length) {
                    break;
                }
                uriArr[i] = Uri.parse(strArr[i]);
                i++;
            }
            this.zzh.zzF(uriArr, strZzF2);
        }
        this.zzh.zzL(this);
        zzZ(this.zzg, false);
        if (this.zzh.zzV()) {
            int iZzt = this.zzh.zzt();
            this.zzl = iZzt;
            if (iZzt == 3) {
                zzV();
            }
        }
    }

    private final void zzX() {
        zzcbb zzcbbVar = this.zzh;
        if (zzcbbVar != null) {
            zzcbbVar.zzQ(false);
        }
    }

    private final void zzY() {
        if (this.zzh != null) {
            zzZ(null, true);
            zzcbb zzcbbVar = this.zzh;
            if (zzcbbVar != null) {
                zzcbbVar.zzL(null);
                this.zzh.zzH();
                this.zzh = null;
            }
            this.zzl = 1;
            this.zzk = false;
            this.zzo = false;
            this.zzp = false;
        }
    }

    private final void zzZ(Surface surface, boolean z) {
        zzcbb zzcbbVar = this.zzh;
        if (zzcbbVar == null) {
            k92.h("Trying to set surface before player is initialized.");
            return;
        }
        try {
            zzcbbVar.zzS(surface, z);
        } catch (IOException unused) {
            k92.j(5);
        }
    }

    private final void zzaa() {
        zzab(this.zzq, this.zzr);
    }

    private final void zzab(int i, int i2) {
        float f = i2 > 0 ? i / i2 : 1.0f;
        if (this.zzs != f) {
            this.zzs = f;
            requestLayout();
        }
    }

    private final boolean zzac() {
        return zzad() && this.zzl != 1;
    }

    private final boolean zzad() {
        zzcbb zzcbbVar = this.zzh;
        return (zzcbbVar == null || !zzcbbVar.zzV() || this.zzk) ? false : true;
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f = this.zzs;
        if (f != 0.0f && this.zzm == null) {
            float f2 = measuredWidth;
            float f3 = f2 / measuredHeight;
            if (f > f3) {
                measuredHeight = (int) (f2 / f);
            }
            if (f < f3) {
                measuredWidth = (int) (measuredHeight * f);
            }
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
        zzcbi zzcbiVar = this.zzm;
        if (zzcbiVar != null) {
            zzcbiVar.zzc(measuredWidth, measuredHeight);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.zzn) {
            zzcbi zzcbiVar = new zzcbi(getContext());
            this.zzm = zzcbiVar;
            zzcbiVar.zzd(surfaceTexture, i, i2);
            this.zzm.start();
            SurfaceTexture surfaceTextureZzb = this.zzm.zzb();
            if (surfaceTextureZzb != null) {
                surfaceTexture = surfaceTextureZzb;
            } else {
                this.zzm.zze();
                this.zzm = null;
            }
        }
        Surface surface = new Surface(surfaceTexture);
        this.zzg = surface;
        if (this.zzh == null) {
            zzW(false, null);
        } else {
            zzZ(surface, true);
            if (!this.zze.zza) {
                zzU();
            }
        }
        if (this.zzq == 0 || this.zzr == 0) {
            zzab(i, i2);
        } else {
            zzaa();
        }
        cd2.l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcby
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzM();
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzo();
        zzcbi zzcbiVar = this.zzm;
        if (zzcbiVar != null) {
            zzcbiVar.zze();
            this.zzm = null;
        }
        if (this.zzh != null) {
            zzX();
            Surface surface = this.zzg;
            if (surface != null) {
                surface.release();
            }
            this.zzg = null;
            zzZ(null, true);
        }
        cd2.l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcbu
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzN();
            }
        });
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, final int i, final int i2) {
        zzcbi zzcbiVar = this.zzm;
        if (zzcbiVar != null) {
            zzcbiVar.zzc(i, i2);
        }
        cd2.l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcbt
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzO(i, i2);
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzd.zzf(this);
        this.zza.zza(surfaceTexture, this.zzf);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(final int i) {
        k92.a("AdExoPlayerView3 window visibility changed to " + i);
        cd2.l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcbs
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzQ(i);
            }
        });
        super.onWindowVisibilityChanged(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final void zzA(int i) {
        zzcbb zzcbbVar = this.zzh;
        if (zzcbbVar != null) {
            zzcbbVar.zzN(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final void zzB(int i) {
        zzcbb zzcbbVar = this.zzh;
        if (zzcbbVar != null) {
            zzcbbVar.zzR(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final void zzC(String str, String[] strArr, Integer num) {
        if (str == null) {
            return;
        }
        if (strArr == null) {
            this.zzj = new String[]{str};
        } else {
            this.zzj = (String[]) Arrays.copyOf(strArr, strArr.length);
        }
        String str2 = this.zzi;
        boolean z = false;
        if (this.zze.zzk && str2 != null && !str.equals(str2) && this.zzl == 4) {
            z = true;
        }
        this.zzi = str;
        zzW(z, num);
    }

    @Override // com.google.android.gms.internal.ads.zzcba
    public final void zzD(int i, int i2) {
        this.zzq = i;
        this.zzr = i2;
        zzaa();
    }

    public final zzcbb zzE(Integer num) {
        zzcbj zzcbjVar = this.zze;
        zzcbk zzcbkVar = this.zzc;
        zzcdw zzcdwVar = new zzcdw(zzcbkVar.getContext(), zzcbjVar, zzcbkVar, num);
        k92.g("ExoPlayerAdapter initialized.");
        return zzcdwVar;
    }

    public final String zzF() {
        zzcbk zzcbkVar = this.zzc;
        return hd2.B.c.w(zzcbkVar.getContext(), zzcbkVar.zzn().g);
    }

    public final /* synthetic */ void zzG(String str) {
        zzcap zzcapVar = this.zzf;
        if (zzcapVar != null) {
            zzcapVar.zzb("ExoPlayerAdapter error", str);
        }
    }

    public final /* synthetic */ void zzH() {
        zzcap zzcapVar = this.zzf;
        if (zzcapVar != null) {
            zzcapVar.zza();
        }
    }

    public final /* synthetic */ void zzI() {
        zzcap zzcapVar = this.zzf;
        if (zzcapVar != null) {
            zzcapVar.zzf();
        }
    }

    public final /* synthetic */ void zzJ(boolean z, long j) {
        this.zzc.zzv(z, j);
    }

    public final /* synthetic */ void zzK(String str) {
        zzcap zzcapVar = this.zzf;
        if (zzcapVar != null) {
            zzcapVar.zzc("ExoPlayerAdapter exception", str);
        }
    }

    public final /* synthetic */ void zzL() {
        zzcap zzcapVar = this.zzf;
        if (zzcapVar != null) {
            zzcapVar.zzg();
        }
    }

    public final /* synthetic */ void zzM() {
        zzcap zzcapVar = this.zzf;
        if (zzcapVar != null) {
            zzcapVar.zzh();
        }
    }

    public final /* synthetic */ void zzN() {
        zzcap zzcapVar = this.zzf;
        if (zzcapVar != null) {
            zzcapVar.zzi();
        }
    }

    public final /* synthetic */ void zzO(int i, int i2) {
        zzcap zzcapVar = this.zzf;
        if (zzcapVar != null) {
            zzcapVar.zzj(i, i2);
        }
    }

    public final void zzP() {
        float fZza = this.zzb.zza();
        zzcbb zzcbbVar = this.zzh;
        if (zzcbbVar == null) {
            k92.h("Trying to set volume before player is initialized.");
            return;
        }
        try {
            zzcbbVar.zzT(fZza, false);
        } catch (IOException unused) {
            k92.j(5);
        }
    }

    public final /* synthetic */ void zzQ(int i) {
        zzcap zzcapVar = this.zzf;
        if (zzcapVar != null) {
            zzcapVar.onWindowVisibilityChanged(i);
        }
    }

    public final /* synthetic */ void zzR() {
        zzcap zzcapVar = this.zzf;
        if (zzcapVar != null) {
            zzcapVar.zzd();
        }
    }

    public final /* synthetic */ void zzS() {
        zzcap zzcapVar = this.zzf;
        if (zzcapVar != null) {
            zzcapVar.zze();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final int zza() {
        if (zzac()) {
            return (int) this.zzh.zzy();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final int zzb() {
        zzcbb zzcbbVar = this.zzh;
        if (zzcbbVar != null) {
            return zzcbbVar.zzr();
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final int zzc() {
        if (zzac()) {
            return (int) this.zzh.zzz();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final int zzd() {
        return this.zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final int zze() {
        return this.zzq;
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final long zzf() {
        zzcbb zzcbbVar = this.zzh;
        if (zzcbbVar != null) {
            return zzcbbVar.zzx();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final long zzg() {
        zzcbb zzcbbVar = this.zzh;
        if (zzcbbVar != null) {
            return zzcbbVar.zzA();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final long zzh() {
        zzcbb zzcbbVar = this.zzh;
        if (zzcbbVar != null) {
            return zzcbbVar.zzB();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzcba
    public final void zzi(final boolean z, final long j) {
        if (this.zzc != null) {
            zzbzo.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcbv
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzJ(z, j);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final String zzj() {
        return "ExoPlayer/2".concat(true != this.zzn ? "" : " spherical");
    }

    @Override // com.google.android.gms.internal.ads.zzcba
    public final void zzk(String str, Exception exc) {
        final String strZzT = zzT(str, exc);
        k92.h("ExoPlayerAdapter error: ".concat(strZzT));
        this.zzk = true;
        if (this.zze.zza) {
            zzX();
        }
        cd2.l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcbz
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzG(strZzT);
            }
        });
        hd2.B.g.zzv(exc, "AdExoPlayerView.onError");
    }

    @Override // com.google.android.gms.internal.ads.zzcba
    public final void zzl(String str, Exception exc) {
        final String strZzT = zzT("onLoadException", exc);
        k92.h("ExoPlayerAdapter exception: ".concat(strZzT));
        hd2.B.g.zzv(exc, "AdExoPlayerView.onException");
        cd2.l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcbw
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzK(strZzT);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcba
    public final void zzm(int i) {
        if (this.zzl != i) {
            this.zzl = i;
            if (i == 3) {
                zzV();
                return;
            }
            if (i != 4) {
                return;
            }
            if (this.zze.zza) {
                zzX();
            }
            this.zzd.zze();
            this.zzb.zzc();
            cd2.l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcca
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzH();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcaq, com.google.android.gms.internal.ads.zzcbn
    public final void zzn() {
        cd2.l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcbr
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzP();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final void zzo() {
        if (zzac()) {
            if (this.zze.zza) {
                zzX();
            }
            this.zzh.zzO(false);
            this.zzd.zze();
            this.zzb.zzc();
            cd2.l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcbx
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzR();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final void zzp() {
        if (!zzac()) {
            this.zzp = true;
            return;
        }
        if (this.zze.zza) {
            zzU();
        }
        this.zzh.zzO(true);
        this.zzd.zzc();
        this.zzb.zzb();
        this.zza.zzb();
        cd2.l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcbq
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzS();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final void zzq(int i) {
        if (zzac()) {
            this.zzh.zzI(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final void zzr(zzcap zzcapVar) {
        this.zzf = zzcapVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final void zzs(String str) {
        if (str != null) {
            zzC(str, null, null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final void zzt() {
        if (zzad()) {
            this.zzh.zzU();
            zzY();
        }
        this.zzd.zze();
        this.zzb.zzc();
        this.zzd.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final void zzu(float f, float f2) {
        zzcbi zzcbiVar = this.zzm;
        if (zzcbiVar != null) {
            zzcbiVar.zzf(f, f2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcba
    public final void zzv() {
        cd2.l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcbp
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzL();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final Integer zzw() {
        zzcbb zzcbbVar = this.zzh;
        if (zzcbbVar != null) {
            return zzcbbVar.zzC();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final void zzx(int i) {
        zzcbb zzcbbVar = this.zzh;
        if (zzcbbVar != null) {
            zzcbbVar.zzJ(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final void zzy(int i) {
        zzcbb zzcbbVar = this.zzh;
        if (zzcbbVar != null) {
            zzcbbVar.zzK(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final void zzz(int i) {
        zzcbb zzcbbVar = this.zzh;
        if (zzcbbVar != null) {
            zzcbbVar.zzM(i);
        }
    }
}
