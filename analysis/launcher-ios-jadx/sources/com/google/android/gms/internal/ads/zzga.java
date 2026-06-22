package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzga implements zzfs {
    private final Context zza;
    private final List zzb = new ArrayList();
    private final zzfs zzc;
    private zzfs zzd;
    private zzfs zze;
    private zzfs zzf;
    private zzfs zzg;
    private zzfs zzh;
    private zzfs zzi;
    private zzfs zzj;
    private zzfs zzk;

    public zzga(Context context, zzfs zzfsVar) {
        this.zza = context.getApplicationContext();
        this.zzc = zzfsVar;
    }

    private final zzfs zzg() {
        if (this.zze == null) {
            zzfk zzfkVar = new zzfk(this.zza);
            this.zze = zzfkVar;
            zzh(zzfkVar);
        }
        return this.zze;
    }

    private final void zzh(zzfs zzfsVar) {
        for (int i = 0; i < this.zzb.size(); i++) {
            zzfsVar.zzf((zzgu) this.zzb.get(i));
        }
    }

    private static final void zzi(zzfs zzfsVar, zzgu zzguVar) {
        if (zzfsVar != null) {
            zzfsVar.zzf(zzguVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzp
    public final int zza(byte[] bArr, int i, int i2) {
        zzfs zzfsVar = this.zzk;
        zzfsVar.getClass();
        return zzfsVar.zza(bArr, i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final long zzb(zzfy zzfyVar) {
        zzfs zzfsVar;
        zzdi.zzf(this.zzk == null);
        String scheme = zzfyVar.zza.getScheme();
        Uri uri = zzfyVar.zza;
        int i = zzet.zza;
        String scheme2 = uri.getScheme();
        if (TextUtils.isEmpty(scheme2) || "file".equals(scheme2)) {
            String path = zzfyVar.zza.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                if (this.zzd == null) {
                    zzgj zzgjVar = new zzgj();
                    this.zzd = zzgjVar;
                    zzh(zzgjVar);
                }
                this.zzk = this.zzd;
            } else {
                this.zzk = zzg();
            }
        } else if ("asset".equals(scheme)) {
            this.zzk = zzg();
        } else if ("content".equals(scheme)) {
            if (this.zzf == null) {
                zzfp zzfpVar = new zzfp(this.zza);
                this.zzf = zzfpVar;
                zzh(zzfpVar);
            }
            this.zzk = this.zzf;
        } else if ("rtmp".equals(scheme)) {
            if (this.zzg == null) {
                try {
                    zzfs zzfsVar2 = (zzfs) Class.forName("androidx.media3.datasource.rtmp.RtmpDataSource").getConstructor(null).newInstance(null);
                    this.zzg = zzfsVar2;
                    zzh(zzfsVar2);
                } catch (ClassNotFoundException unused) {
                    zzea.zzf("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
                } catch (Exception e) {
                    throw new RuntimeException("Error instantiating RTMP extension", e);
                }
                if (this.zzg == null) {
                    this.zzg = this.zzc;
                }
            }
            this.zzk = this.zzg;
        } else if ("udp".equals(scheme)) {
            if (this.zzh == null) {
                zzgw zzgwVar = new zzgw(2000);
                this.zzh = zzgwVar;
                zzh(zzgwVar);
            }
            this.zzk = this.zzh;
        } else if ("data".equals(scheme)) {
            if (this.zzi == null) {
                zzfq zzfqVar = new zzfq();
                this.zzi = zzfqVar;
                zzh(zzfqVar);
            }
            this.zzk = this.zzi;
        } else {
            if ("rawresource".equals(scheme) || "android.resource".equals(scheme)) {
                if (this.zzj == null) {
                    zzgs zzgsVar = new zzgs(this.zza);
                    this.zzj = zzgsVar;
                    zzh(zzgsVar);
                }
                zzfsVar = this.zzj;
            } else {
                zzfsVar = this.zzc;
            }
            this.zzk = zzfsVar;
        }
        return this.zzk.zzb(zzfyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final Uri zzc() {
        zzfs zzfsVar = this.zzk;
        if (zzfsVar == null) {
            return null;
        }
        return zzfsVar.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final void zzd() {
        zzfs zzfsVar = this.zzk;
        if (zzfsVar != null) {
            try {
                zzfsVar.zzd();
            } finally {
                this.zzk = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final Map zze() {
        zzfs zzfsVar = this.zzk;
        return zzfsVar == null ? Collections.EMPTY_MAP : zzfsVar.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final void zzf(zzgu zzguVar) {
        zzguVar.getClass();
        this.zzc.zzf(zzguVar);
        this.zzb.add(zzguVar);
        zzi(this.zzd, zzguVar);
        zzi(this.zze, zzguVar);
        zzi(this.zzf, zzguVar);
        zzi(this.zzg, zzguVar);
        zzi(this.zzh, zzguVar);
        zzi(this.zzi, zzguVar);
        zzi(this.zzj, zzguVar);
    }
}
