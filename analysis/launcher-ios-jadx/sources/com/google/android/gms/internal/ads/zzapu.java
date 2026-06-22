package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes.dex */
final class zzapu implements zzapg {
    private final Map zza = new HashMap();
    private final zzaot zzb;
    private final BlockingQueue zzc;
    private final zzaoy zzd;

    public zzapu(zzaot zzaotVar, BlockingQueue blockingQueue, zzaoy zzaoyVar) {
        this.zzd = zzaoyVar;
        this.zzb = zzaotVar;
        this.zzc = blockingQueue;
    }

    @Override // com.google.android.gms.internal.ads.zzapg
    public final synchronized void zza(zzaph zzaphVar) {
        try {
            Map map = this.zza;
            String strZzj = zzaphVar.zzj();
            List list = (List) map.remove(strZzj);
            if (list == null || list.isEmpty()) {
                return;
            }
            if (zzapt.zzb) {
                zzapt.zzd("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(list.size()), strZzj);
            }
            zzaph zzaphVar2 = (zzaph) list.remove(0);
            this.zza.put(strZzj, list);
            zzaphVar2.zzu(this);
            try {
                this.zzc.put(zzaphVar2);
            } catch (InterruptedException e) {
                zzapt.zzb("Couldn't add request to queue. %s", e.toString());
                Thread.currentThread().interrupt();
                this.zzb.zzb();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapg
    public final void zzb(zzaph zzaphVar, zzapn zzapnVar) {
        List list;
        zzaoq zzaoqVar = zzapnVar.zzb;
        if (zzaoqVar == null || zzaoqVar.zza(System.currentTimeMillis())) {
            zza(zzaphVar);
            return;
        }
        String strZzj = zzaphVar.zzj();
        synchronized (this) {
            list = (List) this.zza.remove(strZzj);
        }
        if (list != null) {
            if (zzapt.zzb) {
                zzapt.zzd("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(list.size()), strZzj);
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.zzd.zzb((zzaph) it.next(), zzapnVar, null);
            }
        }
    }

    public final synchronized boolean zzc(zzaph zzaphVar) {
        try {
            Map map = this.zza;
            String strZzj = zzaphVar.zzj();
            if (!map.containsKey(strZzj)) {
                this.zza.put(strZzj, null);
                zzaphVar.zzu(this);
                if (zzapt.zzb) {
                    zzapt.zza("new request, sending to network %s", strZzj);
                }
                return false;
            }
            List arrayList = (List) this.zza.get(strZzj);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            zzaphVar.zzm("waiting-for-response");
            arrayList.add(zzaphVar);
            this.zza.put(strZzj, arrayList);
            if (zzapt.zzb) {
                zzapt.zza("Request for cacheKey=%s is in flight, putting on hold.", strZzj);
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }
}
