package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbzo;
import com.google.android.gms.internal.ads.zzcej;
import com.google.android.gms.internal.ads.zzfta;
import com.google.android.gms.internal.ads.zzftb;
import com.google.android.gms.internal.ads.zzftk;
import com.google.android.gms.internal.ads.zzfto;
import com.google.android.gms.internal.ads.zzftp;
import com.google.android.gms.internal.ads.zzfuc;
import java.lang.reflect.Method;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class wc0 implements cb {
    public boolean g;
    public Object h;
    public Object i;
    public Object j;
    public Object k;
    public Object l;

    public boolean a(Method method, Class cls) {
        StringBuilder sb = (StringBuilder) this.k;
        sb.setLength(0);
        sb.append(method.getName());
        sb.append('>');
        sb.append(cls.getName());
        String string = sb.toString();
        Class<?> declaringClass = method.getDeclaringClass();
        HashMap map = (HashMap) this.j;
        Class cls2 = (Class) map.put(string, declaringClass);
        if (cls2 == null || cls2.isAssignableFrom(declaringClass)) {
            return true;
        }
        map.put(string, cls2);
        return false;
    }

    public void b(vl vlVar) {
        v02 v02Var = (v02) ((ha0) this.l).p.get((b6) this.i);
        if (v02Var != null) {
            hg0.f(v02Var.s.t);
            s5 s5Var = v02Var.h;
            String name = s5Var.getClass().getName();
            String strValueOf = String.valueOf(vlVar);
            StringBuilder sb = new StringBuilder(name.length() + 25 + strValueOf.length());
            sb.append("onSignInFailed for ");
            sb.append(name);
            sb.append(" with ");
            sb.append(strValueOf);
            s5Var.disconnect(sb.toString());
            v02Var.m(vlVar, null);
        }
    }

    public void c(String str, String str2) {
        k92.a(str);
        if (((zzcej) this.j) != null) {
            HashMap map = new HashMap();
            map.put("message", str);
            map.put("action", str2);
            zzbzo.zze.execute(new xm(this, "onError", map, 18));
        }
    }

    public void d(zzcej zzcejVar, zzftk zzftkVar) {
        if (zzcejVar == null) {
            c("adWebview missing", "onLMDShow");
            return;
        }
        this.j = zzcejVar;
        if (!this.g && !e(zzcejVar.getContext())) {
            c("LMDOverlay not bound", "on_play_store_bind");
            return;
        }
        if (((Boolean) n42.d.c.zza(zzbbw.zzkC)).booleanValue()) {
            this.h = zzftkVar.zzh();
        }
        if (((ew1) this.l) == null) {
            this.l = new ew1(this, 8);
        }
        zzfta zzftaVar = (zzfta) this.k;
        if (zzftaVar != null) {
            zzftaVar.zzd(zzftkVar, (ew1) this.l);
        }
    }

    public synchronized boolean e(Context context) {
        if (!zzfuc.zza(context)) {
            return false;
        }
        try {
            this.k = zzftb.zza(context);
        } catch (NullPointerException e) {
            k92.a("Error connecting LMD Overlay service");
            hd2.B.g.zzw(e, "LastMileDeliveryOverlay.bindLastMileDeliveryService");
        }
        if (((zzfta) this.k) == null) {
            this.g = false;
            return false;
        }
        if (((ew1) this.l) == null) {
            this.l = new ew1(this, 8);
        }
        this.g = true;
        return true;
    }

    public zzftp f() {
        zzfto zzftoVarZzc = zzftp.zzc();
        if (!((Boolean) n42.d.c.zza(zzbbw.zzkC)).booleanValue() || TextUtils.isEmpty((String) this.h)) {
            String str = (String) this.i;
            if (str != null) {
                zzftoVarZzc.zzb(str);
            } else {
                c("Missing session token and/or appId", "onLMDupdate");
            }
        } else {
            zzftoVarZzc.zza((String) this.h);
        }
        return zzftoVarZzc.zzc();
    }

    @Override // defpackage.cb
    public void o(vl vlVar) {
        ((ha0) this.l).t.post(new el0(this, vlVar, 20));
    }
}
