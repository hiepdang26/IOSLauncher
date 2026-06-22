package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import defpackage.hd2;
import defpackage.k92;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzcck implements zzbix {
    @Override // com.google.android.gms.internal.ads.zzbix
    public final void zza(Object obj, Map map) {
        zzcbk zzcbkVar = (zzcbk) obj;
        zzcfl zzcflVarZzq = zzcbkVar.zzq();
        if (zzcflVarZzq == null) {
            try {
                zzcfl zzcflVar = new zzcfl(zzcbkVar, Float.parseFloat((String) map.get("duration")), "1".equals(map.get("customControlsAllowed")), "1".equals(map.get("clickToExpandAllowed")));
                zzcbkVar.zzC(zzcflVar);
                zzcflVarZzq = zzcflVar;
            } catch (NullPointerException e) {
                e = e;
                Throwable th = e;
                k92.f();
                hd2.B.g.zzw(th, "VideoMetaGmsgHandler.onGmsg");
                return;
            } catch (NumberFormatException e2) {
                e = e2;
                Throwable th2 = e;
                k92.f();
                hd2.B.g.zzw(th2, "VideoMetaGmsgHandler.onGmsg");
                return;
            }
        }
        float f = Float.parseFloat((String) map.get("duration"));
        boolean zEquals = "1".equals(map.get("muted"));
        float f2 = Float.parseFloat((String) map.get("currentTime"));
        int i = Integer.parseInt((String) map.get("playbackState"));
        if (i < 0 || i > 3) {
            i = 0;
        }
        String str = (String) map.get("aspectRatio");
        float f3 = TextUtils.isEmpty(str) ? 0.0f : Float.parseFloat(str);
        if (k92.j(3)) {
            k92.d("Video Meta GMSG: currentTime : " + f2 + " , duration : " + f + " , isMuted : " + zEquals + " , playbackState : " + i + " , aspectRatio : " + str);
        }
        zzcflVarZzq.zzc(f2, f, i, zEquals, f3);
    }
}
