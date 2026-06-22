package com.google.android.gms.internal.ads;

import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
final class zzve implements zzyt, zztx {
    final /* synthetic */ zzvj zza;
    private final Uri zzc;
    private final zzgt zzd;
    private final zzuy zze;
    private final zzacn zzf;
    private final zzdm zzg;
    private volatile boolean zzi;
    private long zzk;
    private zzadp zzm;
    private boolean zzn;
    private final zzadf zzh = new zzadf();
    private boolean zzj = true;
    private final long zzb = zztz.zza();
    private zzfy zzl = zzi(0);

    public zzve(zzvj zzvjVar, Uri uri, zzfs zzfsVar, zzuy zzuyVar, zzacn zzacnVar, zzdm zzdmVar) {
        this.zza = zzvjVar;
        this.zzc = uri;
        this.zzd = new zzgt(zzfsVar);
        this.zze = zzuyVar;
        this.zzf = zzacnVar;
        this.zzg = zzdmVar;
    }

    public static /* bridge */ /* synthetic */ void zzf(zzve zzveVar, long j, long j2) {
        zzveVar.zzh.zza = j;
        zzveVar.zzk = j2;
        zzveVar.zzj = true;
        zzveVar.zzn = false;
    }

    private final zzfy zzi(long j) {
        zzfw zzfwVar = new zzfw();
        zzfwVar.zzd(this.zzc);
        zzfwVar.zzc(j);
        zzfwVar.zza(6);
        zzfwVar.zzb(zzvj.zzb);
        return zzfwVar.zze();
    }

    @Override // com.google.android.gms.internal.ads.zztx
    public final void zza(zzek zzekVar) {
        long jMax = !this.zzn ? this.zzk : Math.max(zzvj.zzr(this.zza, true), this.zzk);
        int iZzb = zzekVar.zzb();
        zzadp zzadpVar = this.zzm;
        zzadpVar.getClass();
        zzadn.zzb(zzadpVar, zzekVar, iZzb);
        zzadpVar.zzs(jMax, 1, iZzb, 0, null);
        this.zzn = true;
    }

    @Override // com.google.android.gms.internal.ads.zzyt
    public final void zzg() {
        this.zzi = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x00b1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0221 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:126:? A[LOOP:0: B:3:0x0004->B:126:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01e9 A[EDGE_INSN: B:128:0x01e9->B:89:0x01e9 BREAK  A[LOOP:1: B:77:0x01a7->B:130:0x01a7], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c7 A[Catch: all -> 0x008c, TryCatch #6 {all -> 0x008c, blocks: (B:36:0x00a6, B:38:0x00b1, B:40:0x00bd, B:42:0x00c7, B:44:0x00d3, B:46:0x00dd, B:48:0x00e9, B:50:0x00f3, B:52:0x0105, B:54:0x010f, B:55:0x0115, B:63:0x0144, B:64:0x014b, B:66:0x0158, B:68:0x0160, B:70:0x017d, B:72:0x0194, B:73:0x0199, B:75:0x019d, B:58:0x011f, B:61:0x0135, B:29:0x0074, B:34:0x0092), top: B:119:0x00b1 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00dd A[Catch: all -> 0x008c, TryCatch #6 {all -> 0x008c, blocks: (B:36:0x00a6, B:38:0x00b1, B:40:0x00bd, B:42:0x00c7, B:44:0x00d3, B:46:0x00dd, B:48:0x00e9, B:50:0x00f3, B:52:0x0105, B:54:0x010f, B:55:0x0115, B:63:0x0144, B:64:0x014b, B:66:0x0158, B:68:0x0160, B:70:0x017d, B:72:0x0194, B:73:0x0199, B:75:0x019d, B:58:0x011f, B:61:0x0135, B:29:0x0074, B:34:0x0092), top: B:119:0x00b1 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f3 A[Catch: all -> 0x008c, TryCatch #6 {all -> 0x008c, blocks: (B:36:0x00a6, B:38:0x00b1, B:40:0x00bd, B:42:0x00c7, B:44:0x00d3, B:46:0x00dd, B:48:0x00e9, B:50:0x00f3, B:52:0x0105, B:54:0x010f, B:55:0x0115, B:63:0x0144, B:64:0x014b, B:66:0x0158, B:68:0x0160, B:70:0x017d, B:72:0x0194, B:73:0x0199, B:75:0x019d, B:58:0x011f, B:61:0x0135, B:29:0x0074, B:34:0x0092), top: B:119:0x00b1 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x010f A[Catch: all -> 0x008c, TRY_LEAVE, TryCatch #6 {all -> 0x008c, blocks: (B:36:0x00a6, B:38:0x00b1, B:40:0x00bd, B:42:0x00c7, B:44:0x00d3, B:46:0x00dd, B:48:0x00e9, B:50:0x00f3, B:52:0x0105, B:54:0x010f, B:55:0x0115, B:63:0x0144, B:64:0x014b, B:66:0x0158, B:68:0x0160, B:70:0x017d, B:72:0x0194, B:73:0x0199, B:75:0x019d, B:58:0x011f, B:61:0x0135, B:29:0x0074, B:34:0x0092), top: B:119:0x00b1 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0144 A[Catch: all -> 0x008c, TryCatch #6 {all -> 0x008c, blocks: (B:36:0x00a6, B:38:0x00b1, B:40:0x00bd, B:42:0x00c7, B:44:0x00d3, B:46:0x00dd, B:48:0x00e9, B:50:0x00f3, B:52:0x0105, B:54:0x010f, B:55:0x0115, B:63:0x0144, B:64:0x014b, B:66:0x0158, B:68:0x0160, B:70:0x017d, B:72:0x0194, B:73:0x0199, B:75:0x019d, B:58:0x011f, B:61:0x0135, B:29:0x0074, B:34:0x0092), top: B:119:0x00b1 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0158 A[Catch: all -> 0x008c, TryCatch #6 {all -> 0x008c, blocks: (B:36:0x00a6, B:38:0x00b1, B:40:0x00bd, B:42:0x00c7, B:44:0x00d3, B:46:0x00dd, B:48:0x00e9, B:50:0x00f3, B:52:0x0105, B:54:0x010f, B:55:0x0115, B:63:0x0144, B:64:0x014b, B:66:0x0158, B:68:0x0160, B:70:0x017d, B:72:0x0194, B:73:0x0199, B:75:0x019d, B:58:0x011f, B:61:0x0135, B:29:0x0074, B:34:0x0092), top: B:119:0x00b1 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0194 A[Catch: all -> 0x008c, TryCatch #6 {all -> 0x008c, blocks: (B:36:0x00a6, B:38:0x00b1, B:40:0x00bd, B:42:0x00c7, B:44:0x00d3, B:46:0x00dd, B:48:0x00e9, B:50:0x00f3, B:52:0x0105, B:54:0x010f, B:55:0x0115, B:63:0x0144, B:64:0x014b, B:66:0x0158, B:68:0x0160, B:70:0x017d, B:72:0x0194, B:73:0x0199, B:75:0x019d, B:58:0x011f, B:61:0x0135, B:29:0x0074, B:34:0x0092), top: B:119:0x00b1 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x019d A[Catch: all -> 0x008c, TRY_LEAVE, TryCatch #6 {all -> 0x008c, blocks: (B:36:0x00a6, B:38:0x00b1, B:40:0x00bd, B:42:0x00c7, B:44:0x00d3, B:46:0x00dd, B:48:0x00e9, B:50:0x00f3, B:52:0x0105, B:54:0x010f, B:55:0x0115, B:63:0x0144, B:64:0x014b, B:66:0x0158, B:68:0x0160, B:70:0x017d, B:72:0x0194, B:73:0x0199, B:75:0x019d, B:58:0x011f, B:61:0x0135, B:29:0x0074, B:34:0x0092), top: B:119:0x00b1 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0209  */
    @Override // com.google.android.gms.internal.ads.zzyt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzh() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 546
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzve.zzh():void");
    }
}
