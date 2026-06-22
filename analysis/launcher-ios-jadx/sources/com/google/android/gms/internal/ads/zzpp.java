package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.SystemClock;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
final class zzpp {
    private long zzA;
    private long zzB;
    private long zzC;
    private boolean zzD;
    private long zzE;
    private long zzF;
    private boolean zzG;
    private long zzH;
    private final zzpo zza;
    private final long[] zzb;
    private AudioTrack zzc;
    private int zzd;
    private zzpn zze;
    private int zzf;
    private boolean zzg;
    private long zzh;
    private float zzi;
    private boolean zzj;
    private long zzk;
    private long zzl;
    private Method zzm;
    private long zzn;
    private boolean zzo;
    private boolean zzp;
    private long zzq;
    private long zzr;
    private long zzs;
    private long zzt;
    private long zzu;
    private int zzv;
    private int zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    public zzpp(zzpo zzpoVar) {
        this.zza = zzpoVar;
        try {
            this.zzm = AudioTrack.class.getMethod("getLatency", null);
        } catch (NoSuchMethodException unused) {
        }
        this.zzb = new long[10];
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final long zzk() {
        /*
            r11 = this;
            long r0 = android.os.SystemClock.elapsedRealtime()
            long r2 = r11.zzx
            r4 = 2
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r7 == 0) goto L3b
            android.media.AudioTrack r2 = r11.zzc
            r2.getClass()
            int r2 = r2.getPlayState()
            if (r2 != r4) goto L1e
            long r0 = r11.zzz
            return r0
        L1e:
            long r0 = com.google.android.gms.internal.ads.zzet.zzr(r0)
            long r2 = r11.zzx
            long r0 = r0 - r2
            float r2 = r11.zzi
            long r0 = com.google.android.gms.internal.ads.zzet.zzp(r0, r2)
            int r2 = r11.zzf
            long r0 = com.google.android.gms.internal.ads.zzet.zzo(r0, r2)
            long r2 = r11.zzA
            long r4 = r11.zzz
            long r4 = r4 + r0
            long r0 = java.lang.Math.min(r2, r4)
            return r0
        L3b:
            long r2 = r11.zzr
            long r2 = r0 - r2
            r7 = 5
            int r9 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r9 < 0) goto La4
            android.media.AudioTrack r2 = r11.zzc
            r2.getClass()
            int r3 = r2.getPlayState()
            r7 = 1
            if (r3 != r7) goto L52
            goto La2
        L52:
            int r2 = r2.getPlaybackHeadPosition()
            long r7 = (long) r2
            boolean r2 = r11.zzg
            r9 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r7 = r7 & r9
            r9 = 0
            if (r2 == 0) goto L73
            if (r3 != r4) goto L6e
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 != 0) goto L6f
            long r2 = r11.zzs
            r11.zzu = r2
            goto L6f
        L6e:
            r4 = r3
        L6f:
            long r2 = r11.zzu
            long r7 = r7 + r2
            r3 = r4
        L73:
            int r2 = com.google.android.gms.internal.ads.zzet.zza
            r4 = 29
            if (r2 > r4) goto L93
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 != 0) goto L8f
            long r7 = r11.zzs
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 <= 0) goto L90
            r2 = 3
            if (r3 != r2) goto L90
            long r2 = r11.zzy
            int r4 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r4 != 0) goto La2
            r11.zzy = r0
            goto La2
        L8f:
            r9 = r7
        L90:
            r11.zzy = r5
            r7 = r9
        L93:
            long r2 = r11.zzs
            int r4 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r4 <= 0) goto La0
            long r2 = r11.zzt
            r4 = 1
            long r2 = r2 + r4
            r11.zzt = r2
        La0:
            r11.zzs = r7
        La2:
            r11.zzr = r0
        La4:
            long r0 = r11.zzs
            long r2 = r11.zzH
            long r0 = r0 + r2
            long r2 = r11.zzt
            r4 = 32
            long r2 = r2 << r4
            long r0 = r0 + r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpp.zzk():long");
    }

    private final long zzl() {
        return zzet.zzs(zzk(), this.zzf);
    }

    private final void zzm() {
        this.zzk = 0L;
        this.zzw = 0;
        this.zzv = 0;
        this.zzl = 0L;
        this.zzC = 0L;
        this.zzF = 0L;
        this.zzj = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long zza(boolean r25) {
        /*
            Method dump skipped, instruction units count: 584
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpp.zza(boolean):long");
    }

    public final void zzb(long j) {
        this.zzz = zzk();
        this.zzx = zzet.zzr(SystemClock.elapsedRealtime());
        this.zzA = j;
    }

    public final void zzc() {
        zzm();
        this.zzc = null;
        this.zze = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzd(android.media.AudioTrack r3, boolean r4, int r5, int r6, int r7) {
        /*
            r2 = this;
            r2.zzc = r3
            r2.zzd = r7
            com.google.android.gms.internal.ads.zzpn r0 = new com.google.android.gms.internal.ads.zzpn
            r0.<init>(r3)
            r2.zze = r0
            int r3 = r3.getSampleRate()
            r2.zzf = r3
            r3 = 0
            if (r4 == 0) goto L23
            int r4 = com.google.android.gms.internal.ads.zzet.zza
            r0 = 23
            if (r4 >= r0) goto L23
            r4 = 5
            r0 = 1
            if (r5 == r4) goto L24
            r4 = 6
            if (r5 != r4) goto L23
            r5 = 6
            goto L24
        L23:
            r0 = 0
        L24:
            r2.zzg = r0
            boolean r4 = com.google.android.gms.internal.ads.zzet.zzK(r5)
            r2.zzp = r4
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 == 0) goto L3c
            int r7 = r7 / r6
            long r4 = (long) r7
            int r6 = r2.zzf
            long r4 = com.google.android.gms.internal.ads.zzet.zzs(r4, r6)
            goto L3d
        L3c:
            r4 = r0
        L3d:
            r2.zzh = r4
            r4 = 0
            r2.zzs = r4
            r2.zzt = r4
            r2.zzG = r3
            r2.zzH = r4
            r2.zzu = r4
            r2.zzo = r3
            r2.zzx = r0
            r2.zzy = r0
            r2.zzq = r4
            r2.zzn = r4
            r3 = 1065353216(0x3f800000, float:1.0)
            r2.zzi = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpp.zzd(android.media.AudioTrack, boolean, int, int, int):void");
    }

    public final void zze() {
        if (this.zzx != -9223372036854775807L) {
            this.zzx = zzet.zzr(SystemClock.elapsedRealtime());
        }
        zzpn zzpnVar = this.zze;
        zzpnVar.getClass();
        zzpnVar.zze();
    }

    public final boolean zzf(long j) {
        if (j > zzet.zzo(zza(false), this.zzf)) {
            return true;
        }
        if (this.zzg) {
            AudioTrack audioTrack = this.zzc;
            audioTrack.getClass();
            if (audioTrack.getPlayState() == 2 && zzk() == 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean zzg() {
        AudioTrack audioTrack = this.zzc;
        audioTrack.getClass();
        return audioTrack.getPlayState() == 3;
    }

    public final boolean zzh(long j) {
        return this.zzy != -9223372036854775807L && j > 0 && SystemClock.elapsedRealtime() - this.zzy >= 200;
    }

    public final boolean zzi(long j) {
        AudioTrack audioTrack = this.zzc;
        audioTrack.getClass();
        int playState = audioTrack.getPlayState();
        if (this.zzg) {
            if (playState == 2) {
                this.zzo = false;
                return false;
            }
            if (playState == 1) {
                if (zzk() == 0) {
                    return false;
                }
                playState = 1;
            }
        }
        boolean z = this.zzo;
        boolean zZzf = zzf(j);
        this.zzo = zZzf;
        if (z && !zZzf && playState != 1) {
            zzpo zzpoVar = this.zza;
            int i = this.zzd;
            long jZzu = zzet.zzu(this.zzh);
            zzqk zzqkVar = (zzqk) zzpoVar;
            zzqp zzqpVar = zzqkVar.zza;
            if (zzqpVar.zzp != null) {
                ((zzqu) zzqkVar.zza.zzp).zza.zzc.zzx(i, jZzu, SystemClock.elapsedRealtime() - zzqpVar.zzV);
            }
        }
        return true;
    }

    public final boolean zzj() {
        zzm();
        if (this.zzx != -9223372036854775807L) {
            this.zzz = zzk();
            return false;
        }
        zzpn zzpnVar = this.zze;
        zzpnVar.getClass();
        zzpnVar.zze();
        return true;
    }
}
