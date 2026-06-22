package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzbyj;
import com.google.android.gms.internal.ads.zzbyq;
import com.google.android.gms.internal.ads.zzfju;
import com.google.android.gms.internal.ads.zzfkf;
import com.google.android.gms.internal.ads.zzgcf;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class ek implements jl0, zzgcf {
    public static final y4 l = new y4(2);
    public Object g;
    public Object h;
    public Object i;
    public Object j;
    public Object k;

    public static void b(int[] iArr, int i, int i2, int i3) {
        if (i == -2) {
            while (i2 <= i3) {
                int i4 = iArr[i2];
                iArr[i2] = (i4 & 31) | (((i4 >> 5) & 31) << 10) | (((i4 >> 10) & 31) << 5);
                i2++;
            }
            return;
        }
        if (i != -1) {
            return;
        }
        while (i2 <= i3) {
            int i5 = iArr[i2];
            iArr[i2] = ((i5 >> 10) & 31) | ((i5 & 31) << 10) | (((i5 >> 5) & 31) << 5);
            i2++;
        }
    }

    public static int c(int i, int i2, int i3) {
        return (i3 > i2 ? i << (i3 - i2) : i >> (i2 - i3)) & ((1 << i3) - 1);
    }

    public void a(v6 v6Var) {
        ArrayList arrayList = (ArrayList) this.g;
        ComponentName componentName = v6Var.A;
        jq1 jq1Var = v6Var.w;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            v6 v6Var2 = (v6) arrayList.get(i);
            if (v6Var2.w.equals(jq1Var) && v6Var2.A.equals(componentName)) {
                return;
            }
        }
        arrayList.add(v6Var);
        ((ArrayList) this.h).add(v6Var);
    }

    public boolean d(float[] fArr) {
        j11[] j11VarArr = (j11[]) this.j;
        if (j11VarArr != null && j11VarArr.length > 0) {
            for (j11 j11Var : j11VarArr) {
                j11Var.getClass();
                float f = fArr[2];
                if (f < 0.95f && f > 0.05f) {
                    float f2 = fArr[0];
                    if (f2 < 10.0f || f2 > 37.0f || fArr[1] > 0.82f) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public void e(HashSet hashSet, jq1 jq1Var, ArrayList arrayList) {
        ArrayList arrayList2 = (ArrayList) this.g;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            v6 v6Var = (v6) obj;
            if (v6Var.w.equals(jq1Var) && hashSet != null && hashSet.contains(v6Var.A.getPackageName())) {
                oe0 oe0Var = (oe0) this.k;
                synchronized (oe0Var) {
                    Objects.toString(v6Var);
                    ke0 ke0VarE = oe0Var.e(v6Var.A, null, v6Var.w, false, v6Var.z);
                    Bitmap bitmap = ke0VarE.a;
                    if (bitmap != null && !oe0Var.x(bitmap, v6Var.w)) {
                        v6Var.u = ar1.B(ke0VarE.b);
                        v6Var.y = ke0VarE.a;
                        v6Var.v = ke0VarE.c;
                        v6Var.z = ke0VarE.d;
                    }
                }
                arrayList.add(v6Var);
            }
        }
    }

    @Override // defpackage.jl0
    public boolean f(w40 w40Var, qh0 qh0Var, ComponentName componentName) {
        ArrayList arrayList;
        boolean zR = uo.r(w40Var);
        jq1 jq1Var = (jq1) this.i;
        HashSet hashSet = (HashSet) this.h;
        if (!zR) {
            if (!hashSet.contains(componentName) || !qh0Var.w.equals(jq1Var)) {
                return false;
            }
            ((ArrayList) this.g).add((View) ((HashMap) this.k).get(qh0Var));
            return true;
        }
        if (!hashSet.contains(componentName) || !qh0Var.w.equals(jq1Var)) {
            return false;
        }
        HashMap map = (HashMap) this.j;
        if (map.containsKey(w40Var)) {
            arrayList = (ArrayList) map.get(w40Var);
        } else {
            ArrayList arrayList2 = new ArrayList();
            map.put(w40Var, arrayList2);
            arrayList = arrayList2;
        }
        arrayList.add((og1) qh0Var);
        return true;
    }

    public void g(Context context, String str, jq1 jq1Var) {
        v6 v6Var;
        List<ek0> listR = qg0.t(context).r(str, jq1Var);
        int size = listR.size();
        ArrayList arrayList = (ArrayList) this.i;
        oe0 oe0Var = (oe0) this.k;
        ArrayList arrayList2 = (ArrayList) this.g;
        if (size <= 0) {
            for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                v6 v6Var2 = (v6) arrayList2.get(size2);
                ComponentName component = v6Var2.x.getComponent();
                if (component != null && jq1Var.equals(v6Var2.w) && str.equals(component.getPackageName())) {
                    arrayList.add(v6Var2);
                    oe0Var.D(component, jq1Var);
                    arrayList2.remove(size2);
                }
            }
            return;
        }
        for (int size3 = arrayList2.size() - 1; size3 >= 0; size3--) {
            v6 v6Var3 = (v6) arrayList2.get(size3);
            ComponentName component2 = v6Var3.x.getComponent();
            if (component2 != null && jq1Var.equals(v6Var3.w) && str.equals(component2.getPackageName())) {
                Iterator it = listR.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((ek0) it.next()).b().equals(component2)) {
                            break;
                        }
                    } else {
                        arrayList.add(v6Var3);
                        arrayList2.remove(size3);
                        break;
                    }
                }
            }
        }
        for (ek0 ek0Var : listR) {
            String packageName = ek0Var.b().getPackageName();
            String className = ek0Var.b().getClassName();
            int size4 = arrayList2.size();
            int i = 0;
            while (true) {
                if (i >= size4) {
                    v6Var = null;
                    break;
                }
                Object obj = arrayList2.get(i);
                i++;
                v6Var = (v6) obj;
                ComponentName component3 = v6Var.x.getComponent();
                if (jq1Var.equals(v6Var.w) && packageName.equals(component3.getPackageName()) && className.equals(component3.getClassName())) {
                    break;
                }
            }
            if (v6Var == null) {
                a(new v6(context, ek0Var, jq1Var, oe0Var));
            } else {
                oe0Var.t(v6Var, ek0Var);
                ((ArrayList) this.j).add(v6Var);
            }
        }
    }

    public void h(az1 az1Var, jq1 jq1Var, h30 h30Var) {
        ArrayList arrayList = (ArrayList) this.g;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            v6 v6Var = (v6) arrayList.get(size);
            ComponentName component = v6Var.x.getComponent();
            if (v6Var.w.equals(jq1Var) && az1Var.B(component.getPackageName())) {
                v6Var.D = h30Var.a(v6Var.D);
                ((ArrayList) this.j).add(v6Var);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public void zza(Throwable th) {
        String message = th.getMessage();
        if (((Boolean) n42.d.c.zza(zzbbw.zzgT)).booleanValue()) {
            hd2.B.g.zzv(th, "SignalGeneratorImpl.generateSignals");
        } else {
            hd2.B.g.zzw(th, "SignalGeneratorImpl.generateSignals");
        }
        zzfkf zzfkfVarX = y22.x((do0) this.h, (zzbyq) this.i);
        if (((Boolean) zzbdl.zze.zze()).booleanValue() && zzfkfVarX != null) {
            zzfju zzfjuVar = (zzfju) this.j;
            zzfjuVar.zzh(th);
            zzfjuVar.zzg(false);
            zzfkfVarX.zza(zzfjuVar);
            zzfkfVarX.zzh();
        }
        try {
            if (!"Unknown format is no longer supported.".equals(message)) {
                message = "Internal error. " + message;
            }
            ((zzbyj) this.g).zzb(message);
        } catch (RemoteException unused) {
            k92.f();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public void zzb(Object obj) {
        v32 v32Var = (v32) obj;
        zzfkf zzfkfVarX = y22.x((do0) this.h, (zzbyq) this.i);
        y22 y22Var = (y22) this.k;
        String str = y22Var.w;
        String str2 = y22Var.x;
        y22Var.H.set(true);
        boolean zBooleanValue = ((Boolean) n42.d.c.zza(zzbbw.zzgO)).booleanValue();
        zzfju zzfjuVar = (zzfju) this.j;
        zzbyj zzbyjVar = (zzbyj) this.g;
        if (!zBooleanValue) {
            try {
                zzbyjVar.zzb("QueryInfo generation has been disabled.");
            } catch (RemoteException e) {
                k92.e("QueryInfo generation has been disabled.".concat(e.toString()));
            }
            if (!((Boolean) zzbdl.zze.zze()).booleanValue() || zzfkfVarX == null) {
                return;
            }
            zzfjuVar.zzc("QueryInfo generation has been disabled.");
            zzfjuVar.zzg(false);
            zzfkfVarX.zza(zzfjuVar);
            zzfkfVarX.zzh();
            return;
        }
        try {
            try {
                if (v32Var == null) {
                    zzbyjVar.zzc(null, null, null);
                    zzfjuVar.zzg(true);
                    if (!((Boolean) zzbdl.zze.zze()).booleanValue() || zzfkfVarX == null) {
                        return;
                    }
                    zzfkfVarX.zza(zzfjuVar);
                    zzfkfVarX.zzh();
                    return;
                }
                try {
                    if (TextUtils.isEmpty(new JSONObject(v32Var.b).optString("request_id", ""))) {
                        k92.h("The request ID is empty in request JSON.");
                        zzbyjVar.zzb("Internal error: request ID is empty in request JSON.");
                        zzfjuVar.zzc("Request ID empty");
                        zzfjuVar.zzg(false);
                        if (!((Boolean) zzbdl.zze.zze()).booleanValue() || zzfkfVarX == null) {
                            return;
                        }
                        zzfkfVarX.zza(zzfjuVar);
                        zzfkfVarX.zzh();
                        return;
                    }
                    Bundle bundle = v32Var.d;
                    if (y22Var.v && bundle != null && bundle.getInt(str2, -1) == -1) {
                        bundle.putInt(str2, y22Var.y.get());
                    }
                    if (y22Var.u && bundle != null && TextUtils.isEmpty(bundle.getString(str))) {
                        if (TextUtils.isEmpty(y22Var.A)) {
                            y22Var.A = hd2.B.c.w(y22Var.h, y22Var.z.g);
                        }
                        bundle.putString(str, y22Var.A);
                    }
                    zzbyjVar.zzc(v32Var.a, v32Var.b, bundle);
                    zzfjuVar.zzg(true);
                    if (!((Boolean) zzbdl.zze.zze()).booleanValue() || zzfkfVarX == null) {
                        return;
                    }
                    zzfkfVarX.zza(zzfjuVar);
                    zzfkfVarX.zzh();
                } catch (JSONException e2) {
                    k92.h("Failed to create JSON object from the request string.");
                    zzbyjVar.zzb("Internal error for request JSON: " + e2.toString());
                    zzfjuVar.zzh(e2);
                    zzfjuVar.zzg(false);
                    hd2.B.g.zzw(e2, "SignalGeneratorImpl.generateSignals.onSuccess");
                    if (!((Boolean) zzbdl.zze.zze()).booleanValue() || zzfkfVarX == null) {
                        return;
                    }
                    zzfkfVarX.zza(zzfjuVar);
                    zzfkfVarX.zzh();
                }
            } catch (RemoteException e3) {
                zzfjuVar.zzh(e3);
                zzfjuVar.zzg(false);
                k92.f();
                hd2.B.g.zzw(e3, "SignalGeneratorImpl.generateSignals.onSuccess");
                if (!((Boolean) zzbdl.zze.zze()).booleanValue() || zzfkfVarX == null) {
                    return;
                }
                zzfkfVarX.zza(zzfjuVar);
                zzfkfVarX.zzh();
            }
        } catch (Throwable th) {
            if (((Boolean) zzbdl.zze.zze()).booleanValue() && zzfkfVarX != null) {
                zzfkfVarX.zza(zzfjuVar);
                zzfkfVarX.zzh();
            }
            throw th;
        }
    }
}
