package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import defpackage.hd2;
import defpackage.ib2;
import defpackage.n42;
import defpackage.za2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzdsu {
    private final String zze;
    private final zzdsp zzf;
    private final List zzb = new ArrayList();
    private boolean zzc = false;
    private boolean zzd = false;
    private final za2 zza = hd2.B.g.zzi();

    public zzdsu(String str, zzdsp zzdspVar) {
        this.zze = str;
        this.zzf = zzdspVar;
    }

    private final Map zzg() {
        Map mapZza = this.zzf.zza();
        hd2.B.j.getClass();
        mapZza.put("tms", Long.toString(SystemClock.elapsedRealtime(), 10));
        mapZza.put("tid", ((ib2) this.zza).q() ? "" : this.zze);
        return mapZza;
    }

    public final synchronized void zza(String str) {
        if (((Boolean) n42.d.c.zza(zzbbw.zzbP)).booleanValue()) {
            Map mapZzg = zzg();
            mapZzg.put("action", "aaia");
            mapZzg.put("aair", "MalformedJson");
            this.zzb.add(mapZzg);
        }
    }

    public final synchronized void zzb(String str, String str2) {
        if (((Boolean) n42.d.c.zza(zzbbw.zzbP)).booleanValue()) {
            Map mapZzg = zzg();
            mapZzg.put("action", "adapter_init_finished");
            mapZzg.put("ancn", str);
            mapZzg.put("rqe", str2);
            this.zzb.add(mapZzg);
        }
    }

    public final synchronized void zzc(String str) {
        if (((Boolean) n42.d.c.zza(zzbbw.zzbP)).booleanValue()) {
            Map mapZzg = zzg();
            mapZzg.put("action", "adapter_init_started");
            mapZzg.put("ancn", str);
            this.zzb.add(mapZzg);
        }
    }

    public final synchronized void zzd(String str) {
        if (((Boolean) n42.d.c.zza(zzbbw.zzbP)).booleanValue()) {
            Map mapZzg = zzg();
            mapZzg.put("action", "adapter_init_finished");
            mapZzg.put("ancn", str);
            this.zzb.add(mapZzg);
        }
    }

    public final synchronized void zze() {
        try {
            if (((Boolean) n42.d.c.zza(zzbbw.zzbP)).booleanValue() && !this.zzd) {
                Map mapZzg = zzg();
                mapZzg.put("action", "init_finished");
                this.zzb.add(mapZzg);
                Iterator it = this.zzb.iterator();
                while (it.hasNext()) {
                    this.zzf.zzf((Map) it.next());
                }
                this.zzd = true;
            }
        } finally {
        }
    }

    public final synchronized void zzf() {
        if (((Boolean) n42.d.c.zza(zzbbw.zzbP)).booleanValue() && !this.zzc) {
            Map mapZzg = zzg();
            mapZzg.put("action", "init_started");
            this.zzb.add(mapZzg);
            this.zzc = true;
        }
    }
}
