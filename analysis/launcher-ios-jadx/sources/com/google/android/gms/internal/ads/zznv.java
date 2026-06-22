package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackSession;
import android.media.metrics.TrackChangeEvent;
import android.os.SystemClock;
import android.util.Pair;
import defpackage.hc2;
import defpackage.ic2;
import java.io.IOException;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zznv implements zzlq, zznw {
    private final Context zza;
    private final zznx zzb;
    private final PlaybackSession zzc;
    private String zzi;
    private PlaybackMetrics.Builder zzj;
    private int zzk;
    private zzbp zzn;
    private zznu zzo;
    private zznu zzp;
    private zznu zzq;
    private zzaf zzr;
    private zzaf zzs;
    private zzaf zzt;
    private boolean zzu;
    private boolean zzv;
    private int zzw;
    private int zzx;
    private int zzy;
    private boolean zzz;
    private final zzcb zze = new zzcb();
    private final zzca zzf = new zzca();
    private final HashMap zzh = new HashMap();
    private final HashMap zzg = new HashMap();
    private final long zzd = SystemClock.elapsedRealtime();
    private int zzl = 0;
    private int zzm = 0;

    private zznv(Context context, PlaybackSession playbackSession) {
        this.zza = context.getApplicationContext();
        this.zzc = playbackSession;
        zznt zzntVar = new zznt(zznt.zza);
        this.zzb = zzntVar;
        zzntVar.zzh(this);
    }

    public static zznv zzb(Context context) {
        MediaMetricsManager mediaMetricsManagerA = hc2.a(context.getSystemService("media_metrics"));
        if (mediaMetricsManagerA == null) {
            return null;
        }
        return new zznv(context, mediaMetricsManagerA.createPlaybackSession());
    }

    private static int zzr(int i) {
        switch (zzet.zzj(i)) {
            case 6002:
                return 24;
            case 6003:
                return 28;
            case 6004:
                return 25;
            case 6005:
                return 26;
            default:
                return 27;
        }
    }

    private final void zzs() {
        PlaybackMetrics.Builder builder = this.zzj;
        if (builder != null && this.zzz) {
            builder.setAudioUnderrunCount(this.zzy);
            this.zzj.setVideoFramesDropped(this.zzw);
            this.zzj.setVideoFramesPlayed(this.zzx);
            Long l = (Long) this.zzg.get(this.zzi);
            this.zzj.setNetworkTransferDurationMillis(l == null ? 0L : l.longValue());
            Long l2 = (Long) this.zzh.get(this.zzi);
            this.zzj.setNetworkBytesRead(l2 == null ? 0L : l2.longValue());
            this.zzj.setStreamSource((l2 == null || l2.longValue() <= 0) ? 0 : 1);
            this.zzc.reportPlaybackMetrics(this.zzj.build());
        }
        this.zzj = null;
        this.zzi = null;
        this.zzy = 0;
        this.zzw = 0;
        this.zzx = 0;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzz = false;
    }

    private final void zzt(long j, zzaf zzafVar, int i) {
        if (zzet.zzG(this.zzs, zzafVar)) {
            return;
        }
        int i2 = this.zzs == null ? 1 : 0;
        this.zzs = zzafVar;
        zzx(0, j, zzafVar, i2);
    }

    private final void zzu(long j, zzaf zzafVar, int i) {
        if (zzet.zzG(this.zzt, zzafVar)) {
            return;
        }
        int i2 = this.zzt == null ? 1 : 0;
        this.zzt = zzafVar;
        zzx(2, j, zzafVar, i2);
    }

    private final void zzv(zzcc zzccVar, zzui zzuiVar) {
        int iZza;
        PlaybackMetrics.Builder builder = this.zzj;
        if (zzuiVar == null || (iZza = zzccVar.zza(zzuiVar.zza)) == -1) {
            return;
        }
        int i = 0;
        zzccVar.zzd(iZza, this.zzf, false);
        zzccVar.zze(this.zzf.zzc, this.zze, 0L);
        zzax zzaxVar = this.zze.zzd.zzb;
        if (zzaxVar != null) {
            int iZzn = zzet.zzn(zzaxVar.zza);
            i = iZzn != 0 ? iZzn != 1 ? iZzn != 2 ? 1 : 4 : 5 : 3;
        }
        builder.setStreamType(i);
        zzcb zzcbVar = this.zze;
        long j = zzcbVar.zzm;
        if (j != -9223372036854775807L && !zzcbVar.zzk && !zzcbVar.zzi && !zzcbVar.zzb()) {
            builder.setMediaDurationMillis(zzet.zzu(j));
        }
        builder.setPlaybackType(true != this.zze.zzb() ? 1 : 2);
        this.zzz = true;
    }

    private final void zzw(long j, zzaf zzafVar, int i) {
        if (zzet.zzG(this.zzr, zzafVar)) {
            return;
        }
        int i2 = this.zzr == null ? 1 : 0;
        this.zzr = zzafVar;
        zzx(1, j, zzafVar, i2);
    }

    private final void zzx(int i, long j, zzaf zzafVar, int i2) {
        TrackChangeEvent.Builder timeSinceCreatedMillis = ic2.j(i).setTimeSinceCreatedMillis(j - this.zzd);
        if (zzafVar != null) {
            timeSinceCreatedMillis.setTrackState(1);
            timeSinceCreatedMillis.setTrackChangeReason(i2 != 1 ? 1 : 2);
            String str = zzafVar.zzl;
            if (str != null) {
                timeSinceCreatedMillis.setContainerMimeType(str);
            }
            String str2 = zzafVar.zzm;
            if (str2 != null) {
                timeSinceCreatedMillis.setSampleMimeType(str2);
            }
            String str3 = zzafVar.zzj;
            if (str3 != null) {
                timeSinceCreatedMillis.setCodecName(str3);
            }
            int i3 = zzafVar.zzi;
            if (i3 != -1) {
                timeSinceCreatedMillis.setBitrate(i3);
            }
            int i4 = zzafVar.zzr;
            if (i4 != -1) {
                timeSinceCreatedMillis.setWidth(i4);
            }
            int i5 = zzafVar.zzs;
            if (i5 != -1) {
                timeSinceCreatedMillis.setHeight(i5);
            }
            int i6 = zzafVar.zzz;
            if (i6 != -1) {
                timeSinceCreatedMillis.setChannelCount(i6);
            }
            int i7 = zzafVar.zzA;
            if (i7 != -1) {
                timeSinceCreatedMillis.setAudioSampleRate(i7);
            }
            String str4 = zzafVar.zzd;
            if (str4 != null) {
                int i8 = zzet.zza;
                String[] strArrSplit = str4.split("-", -1);
                Pair pairCreate = Pair.create(strArrSplit[0], strArrSplit.length >= 2 ? strArrSplit[1] : null);
                timeSinceCreatedMillis.setLanguage((String) pairCreate.first);
                Object obj = pairCreate.second;
                if (obj != null) {
                    timeSinceCreatedMillis.setLanguageRegion((String) obj);
                }
            }
            float f = zzafVar.zzt;
            if (f != -1.0f) {
                timeSinceCreatedMillis.setVideoFrameRate(f);
            }
        } else {
            timeSinceCreatedMillis.setTrackState(0);
        }
        this.zzz = true;
        this.zzc.reportTrackChangeEvent(timeSinceCreatedMillis.build());
    }

    private final boolean zzy(zznu zznuVar) {
        if (zznuVar != null) {
            return zznuVar.zzc.equals(this.zzb.zze());
        }
        return false;
    }

    public final LogSessionId zza() {
        return this.zzc.getSessionId();
    }

    @Override // com.google.android.gms.internal.ads.zznw
    public final void zzc(zzlo zzloVar, String str) {
        zzui zzuiVar = zzloVar.zzd;
        if (zzuiVar == null || !zzuiVar.zzb()) {
            zzs();
            this.zzi = str;
            this.zzj = ic2.h().setPlayerName("AndroidXMedia3").setPlayerVersion("1.4.0-alpha02");
            zzv(zzloVar.zzb, zzloVar.zzd);
        }
    }

    @Override // com.google.android.gms.internal.ads.zznw
    public final void zzd(zzlo zzloVar, String str, boolean z) {
        zzui zzuiVar = zzloVar.zzd;
        if ((zzuiVar == null || !zzuiVar.zzb()) && str.equals(this.zzi)) {
            zzs();
        }
        this.zzg.remove(str);
        this.zzh.remove(str);
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final /* synthetic */ void zze(zzlo zzloVar, zzaf zzafVar, zzho zzhoVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final void zzf(zzlo zzloVar, int i, long j, long j2) {
        zzui zzuiVar = zzloVar.zzd;
        if (zzuiVar != null) {
            zznx zznxVar = this.zzb;
            zzcc zzccVar = zzloVar.zzb;
            HashMap map = this.zzh;
            String strZzf = zznxVar.zzf(zzccVar, zzuiVar);
            Long l = (Long) map.get(strZzf);
            Long l2 = (Long) this.zzg.get(strZzf);
            this.zzh.put(strZzf, Long.valueOf((l == null ? 0L : l.longValue()) + j));
            this.zzg.put(strZzf, Long.valueOf((l2 != null ? l2.longValue() : 0L) + ((long) i)));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final void zzg(zzlo zzloVar, zzue zzueVar) {
        zzui zzuiVar = zzloVar.zzd;
        if (zzuiVar == null) {
            return;
        }
        zzaf zzafVar = zzueVar.zzb;
        zzafVar.getClass();
        zznu zznuVar = new zznu(zzafVar, 0, this.zzb.zzf(zzloVar.zzb, zzuiVar));
        int i = zzueVar.zza;
        if (i != 0) {
            if (i == 1) {
                this.zzp = zznuVar;
                return;
            } else if (i != 2) {
                if (i != 3) {
                    return;
                }
                this.zzq = zznuVar;
                return;
            }
        }
        this.zzo = zznuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final /* synthetic */ void zzh(zzlo zzloVar, int i, long j) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x029e  */
    @Override // com.google.android.gms.internal.ads.zzlq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzi(com.google.android.gms.internal.ads.zzbw r19, com.google.android.gms.internal.ads.zzlp r20) {
        /*
            Method dump skipped, instruction units count: 990
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zznv.zzi(com.google.android.gms.internal.ads.zzbw, com.google.android.gms.internal.ads.zzlp):void");
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final void zzj(zzlo zzloVar, zztz zztzVar, zzue zzueVar, IOException iOException, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final /* synthetic */ void zzk(zzlo zzloVar, int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final void zzl(zzlo zzloVar, zzbp zzbpVar) {
        this.zzn = zzbpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final void zzm(zzlo zzloVar, zzbv zzbvVar, zzbv zzbvVar2, int i) {
        if (i == 1) {
            this.zzu = true;
            i = 1;
        }
        this.zzk = i;
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final /* synthetic */ void zzn(zzlo zzloVar, Object obj, long j) {
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final void zzo(zzlo zzloVar, zzhn zzhnVar) {
        this.zzw += zzhnVar.zzg;
        this.zzx += zzhnVar.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final /* synthetic */ void zzp(zzlo zzloVar, zzaf zzafVar, zzho zzhoVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final void zzq(zzlo zzloVar, zzcp zzcpVar) {
        zznu zznuVar = this.zzo;
        if (zznuVar != null) {
            zzaf zzafVar = zznuVar.zza;
            if (zzafVar.zzs == -1) {
                zzad zzadVarZzb = zzafVar.zzb();
                zzadVarZzb.zzac(zzcpVar.zzb);
                zzadVarZzb.zzI(zzcpVar.zzc);
                this.zzo = new zznu(zzadVarZzb.zzad(), 0, zznuVar.zzc);
            }
        }
    }
}
