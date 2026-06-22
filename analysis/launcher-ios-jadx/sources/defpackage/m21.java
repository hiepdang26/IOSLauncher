package defpackage;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.internal.ads.zzbbn;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzdeq;
import java.io.InputStream;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class m21 implements me1, mu0, cz0, xo, fr, zx {
    public static m21 g;

    public static final void f(Context context, AdOverlayInfoParcel adOverlayInfoParcel, boolean z) {
        if (adOverlayInfoParcel.q != 4 || adOverlayInfoParcel.i != null) {
            Intent intent = new Intent();
            intent.setClassName(context, "com.google.android.gms.ads.AdActivity");
            intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", adOverlayInfoParcel.s.j);
            intent.putExtra("shouldCallOnOverlayOpened", z);
            Bundle bundle = new Bundle(1);
            bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", adOverlayInfoParcel);
            intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            cd2 cd2Var = hd2.B.c;
            cd2.p(context, intent);
            return;
        }
        b22 b22Var = adOverlayInfoParcel.h;
        if (b22Var != null) {
            b22Var.onAdClicked();
        }
        zzdeq zzdeqVar = adOverlayInfoParcel.A;
        if (zzdeqVar != null) {
            zzdeqVar.zzdG();
        }
        Activity activityZzi = adOverlayInfoParcel.j.zzi();
        m62 m62Var = adOverlayInfoParcel.g;
        if (m62Var != null && m62Var.p && activityZzi != null) {
            context = activityZzi;
        }
        m21 m21Var = hd2.B.a;
        h(context, m62Var, adOverlayInfoParcel.o, m62Var != null ? m62Var.o : null);
    }

    public static final boolean g(Context context, Intent intent, e22 e22Var, sd2 sd2Var, boolean z) {
        int iB;
        if (z) {
            Uri data = intent.getData();
            try {
                hd2.B.c.getClass();
                iB = cd2.B(data, context);
                if (e22Var != null) {
                    e22Var.zzg();
                }
            } catch (ActivityNotFoundException e) {
                k92.h(e.getMessage());
                iB = 6;
            }
            if (sd2Var != null) {
                sd2Var.zzb(iB);
            }
            return iB == 5;
        }
        try {
            k92.a("Launching an intent: " + intent.toURI());
            cd2 cd2Var = hd2.B.c;
            cd2.p(context, intent);
            if (e22Var != null) {
                e22Var.zzg();
            }
            if (sd2Var != null) {
                sd2Var.zza(true);
            }
            return true;
        } catch (ActivityNotFoundException e2) {
            k92.h(e2.getMessage());
            if (sd2Var != null) {
                sd2Var.zza(false);
            }
            return false;
        }
    }

    public static final boolean h(Context context, m62 m62Var, e22 e22Var, sd2 sd2Var) {
        int i = 0;
        if (m62Var == null) {
            k92.h("No intent data for launcher overlay.");
            return false;
        }
        zzbbw.zza(context);
        boolean z = m62Var.p;
        Intent intent = m62Var.n;
        if (intent != null) {
            return g(context, intent, e22Var, sd2Var, z);
        }
        Intent intent2 = new Intent();
        String str = m62Var.h;
        if (TextUtils.isEmpty(str)) {
            k92.h("Open GMSG did not contain a URL.");
            return false;
        }
        String str2 = m62Var.i;
        if (TextUtils.isEmpty(str2)) {
            intent2.setData(Uri.parse(str));
        } else {
            intent2.setDataAndType(Uri.parse(str), str2);
        }
        intent2.setAction("android.intent.action.VIEW");
        String str3 = m62Var.j;
        if (!TextUtils.isEmpty(str3)) {
            intent2.setPackage(str3);
        }
        String str4 = m62Var.k;
        if (!TextUtils.isEmpty(str4)) {
            String[] strArrSplit = str4.split("/", 2);
            if (strArrSplit.length < 2) {
                k92.h("Could not parse component name from open GMSG: ".concat(String.valueOf(str4)));
                return false;
            }
            intent2.setClassName(strArrSplit[0], strArrSplit[1]);
        }
        String str5 = m62Var.l;
        if (!TextUtils.isEmpty(str5)) {
            try {
                i = Integer.parseInt(str5);
            } catch (NumberFormatException unused) {
                k92.h("Could not parse intent flags.");
            }
            intent2.addFlags(i);
        }
        zzbbn zzbbnVar = zzbbw.zzea;
        n42 n42Var = n42.d;
        if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
            intent2.addFlags(268435456);
            intent2.putExtra("android.support.customtabs.extra.user_opt_out", true);
        } else {
            if (((Boolean) n42Var.c.zza(zzbbw.zzdZ)).booleanValue()) {
                cd2 cd2Var = hd2.B.c;
                cd2.D(context, intent2);
            }
        }
        return g(context, intent2, e22Var, sd2Var, z);
    }

    @Override // defpackage.cz0
    public void a(Object obj) {
        Objects.toString((ip0) obj);
    }

    @Override // defpackage.zx
    public int b(Context context, String str) {
        return dy.a(context, str);
    }

    @Override // defpackage.zx
    public int e(Context context, String str, boolean z) {
        return dy.d(context, str, z);
    }

    @Override // defpackage.mu0
    public lu0 s(qm0 qm0Var) {
        return new ak1(qm0Var.b(Uri.class, InputStream.class), 0);
    }

    @Override // defpackage.me1
    public void c(boolean z, int i, int i2, int i3) {
    }

    @Override // defpackage.me1
    public void d(int i, int i2, int i3, int i4) {
    }
}
