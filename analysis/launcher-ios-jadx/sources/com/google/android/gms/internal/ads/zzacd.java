package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbbc;
import java.lang.reflect.Constructor;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzacd implements zzacp {
    private static final int[] zza = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 16, 15, 14, 17, 18, 19, 20, 21};
    private static final zzacc zzb = new zzacc(new zzacb() { // from class: com.google.android.gms.internal.ads.zzabz
        @Override // com.google.android.gms.internal.ads.zzacb
        public final Constructor zza() {
            if (Boolean.TRUE.equals(Class.forName("androidx.media3.decoder.flac.FlacLibrary").getMethod("isAvailable", null).invoke(null, null))) {
                return Class.forName("androidx.media3.decoder.flac.FlacExtractor").asSubclass(zzack.class).getConstructor(Integer.TYPE);
            }
            return null;
        }
    });
    private static final zzacc zzc = new zzacc(new zzacb() { // from class: com.google.android.gms.internal.ads.zzaca
        @Override // com.google.android.gms.internal.ads.zzacb
        public final Constructor zza() {
            return Class.forName("androidx.media3.decoder.midi.MidiExtractor").asSubclass(zzack.class).getConstructor(null);
        }
    });
    private zzfxr zzd;
    private final zzajy zze = new zzajt();

    private final void zzb(int i, List list) {
        switch (i) {
            case 0:
                list.add(new zzalw());
                break;
            case 1:
                list.add(new zzaly());
                break;
            case 2:
                list.add(new zzama(0));
                break;
            case 3:
                list.add(new zzadw(0));
                break;
            case 4:
                zzack zzackVarZza = zzb.zza(0);
                if (zzackVarZza == null) {
                    list.add(new zzaeo(0));
                } else {
                    list.add(zzackVarZza);
                }
                break;
            case 5:
                list.add(new zzaeq());
                break;
            case 6:
                list.add(new zzahj(this.zze, 0));
                break;
            case 7:
                list.add(new zzahp(0));
                break;
            case 8:
                list.add(new zzail(this.zze, 0, null, null, zzfxr.zzm(), null));
                list.add(new zzaiq(this.zze, 0));
                break;
            case 9:
                list.add(new zzajg());
                break;
            case 10:
                list.add(new zzanf());
                break;
            case 11:
                if (this.zzd == null) {
                    this.zzd = zzfxr.zzm();
                }
                list.add(new zzano(1, 0, this.zze, new zzer(0L), new zzamc(0, this.zzd), 112800));
                break;
            case 12:
                list.add(new zzanz());
                break;
            case 14:
                list.add(new zzaew(0));
                break;
            case 15:
                zzack zzackVarZza2 = zzc.zza(new Object[0]);
                if (zzackVarZza2 != null) {
                    list.add(zzackVarZza2);
                }
                break;
            case 16:
                list.add(new zzaeb(0, this.zze));
                break;
            case 17:
                list.add(new zzajr());
                break;
            case 18:
                list.add(new zzaoe());
                break;
            case 19:
                list.add(new zzaej());
                break;
            case 20:
                list.add(new zzaev());
                break;
            case zzbbc.zzt.zzm /* 21 */:
                list.add(new zzaei());
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0210  */
    @Override // com.google.android.gms.internal.ads.zzacp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized com.google.android.gms.internal.ads.zzack[] zza(android.net.Uri r25, java.util.Map r26) {
        /*
            Method dump skipped, instruction units count: 1256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzacd.zza(android.net.Uri, java.util.Map):com.google.android.gms.internal.ads.zzack[]");
    }
}
