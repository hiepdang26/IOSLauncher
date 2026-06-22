package defpackage;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PointF;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbzo;
import com.google.android.gms.internal.ads.zzdve;
import com.google.android.gms.internal.ads.zzdvi;
import com.google.android.gms.internal.ads.zzfru;
import com.google.android.gms.internal.ads.zzgcu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class o32 {
    public final Context a;
    public final zzdvi b;
    public String c;
    public String d;
    public String e;
    public String f;
    public final int h;
    public PointF i;
    public PointF j;
    public final zzfru k;
    public int g = 0;
    public final p22 l = new p22(this, 2);

    public o32(Context context) {
        this.a = context;
        this.h = ViewConfiguration.get(context).getScaledTouchSlop();
        hd2 hd2Var = hd2.B;
        hd2Var.r.a();
        this.k = (zzfru) hd2Var.r.c;
        this.b = (zzdvi) hd2Var.m.g;
    }

    public static final int e(ArrayList arrayList, String str, boolean z) {
        if (!z) {
            return -1;
        }
        arrayList.add(str);
        return arrayList.size() - 1;
    }

    public final void a(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        int historySize = motionEvent.getHistorySize();
        int pointerCount = motionEvent.getPointerCount();
        if (actionMasked == 0) {
            this.g = 0;
            this.i = new PointF(motionEvent.getX(0), motionEvent.getY(0));
            return;
        }
        int i = this.g;
        if (i == -1) {
            return;
        }
        p22 p22Var = this.l;
        zzfru zzfruVar = this.k;
        if (i == 0) {
            if (actionMasked == 5) {
                this.g = 5;
                this.j = new PointF(motionEvent.getX(1), motionEvent.getY(1));
                zzfruVar.postDelayed(p22Var, ((Long) n42.d.c.zza(zzbbw.zzeg)).longValue());
                return;
            }
            return;
        }
        if (i == 5) {
            if (pointerCount == 2) {
                if (actionMasked != 2) {
                    return;
                }
                boolean z = false;
                for (int i2 = 0; i2 < historySize; i2++) {
                    z |= !d(motionEvent.getHistoricalX(0, i2), motionEvent.getHistoricalY(0, i2), motionEvent.getHistoricalX(1, i2), motionEvent.getHistoricalY(1, i2));
                }
                if (d(motionEvent.getX(), motionEvent.getY(), motionEvent.getX(1), motionEvent.getY(1)) && !z) {
                    return;
                }
            }
            this.g = -1;
            zzfruVar.removeCallbacks(p22Var);
        }
    }

    public final void b() {
        String str;
        Context context = this.a;
        try {
            if (!(context instanceof Activity)) {
                k92.g("Can not create dialog without Activity Context");
                return;
            }
            hd2 hd2Var = hd2.B;
            t92 t92Var = hd2Var.m;
            synchronized (t92Var.a) {
                str = (String) t92Var.e;
            }
            String str2 = "Creative preview (enabled)";
            if (true == TextUtils.isEmpty(str)) {
                str2 = "Creative preview";
            }
            String str3 = true != hd2Var.m.k() ? "Troubleshooting" : "Troubleshooting (enabled)";
            ArrayList arrayList = new ArrayList();
            final int iE = e(arrayList, "Ad information", true);
            final int iE2 = e(arrayList, str2, true);
            final int iE3 = e(arrayList, str3, true);
            boolean zBooleanValue = ((Boolean) n42.d.c.zza(zzbbw.zzip)).booleanValue();
            final int iE4 = e(arrayList, "Open ad inspector", zBooleanValue);
            final int iE5 = e(arrayList, "Ad inspector settings", zBooleanValue);
            AlertDialog.Builder builderI = cd2.i(context);
            builderI.setTitle("Select a debug mode").setItems((CharSequence[]) arrayList.toArray(new String[0]), new DialogInterface.OnClickListener() { // from class: e32
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    final o32 o32Var = this.g;
                    o32Var.getClass();
                    if (i != iE) {
                        if (i == iE2) {
                            k92.d("Debug mode [Creative Preview] selected.");
                            zzbzo.zza.execute(new p22(o32Var, 3));
                            return;
                        }
                        if (i == iE3) {
                            k92.d("Debug mode [Troubleshooting] selected.");
                            zzbzo.zza.execute(new p22(o32Var, 1));
                            return;
                        }
                        int i2 = iE4;
                        zzdvi zzdviVar = o32Var.b;
                        if (i == i2) {
                            final zzgcu zzgcuVar = zzbzo.zze;
                            zzgcu zzgcuVar2 = zzbzo.zza;
                            if (zzdviVar.zzq()) {
                                zzgcuVar.execute(new p22(o32Var, 6));
                                return;
                            } else {
                                final int i3 = 0;
                                zzgcuVar2.execute(new Runnable() { // from class: r22
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        switch (i3) {
                                            case 0:
                                                o32 o32Var2 = o32Var;
                                                o32Var2.getClass();
                                                hd2 hd2Var2 = hd2.B;
                                                t92 t92Var2 = hd2Var2.m;
                                                String str4 = o32Var2.d;
                                                String str5 = o32Var2.e;
                                                Context context2 = o32Var2.a;
                                                if (!t92Var2.i(context2, str4, str5)) {
                                                    hd2Var2.m.c(context2, o32Var2.d, o32Var2.e);
                                                } else {
                                                    zzgcuVar.execute(new p22(o32Var2, 4));
                                                }
                                                break;
                                            default:
                                                o32 o32Var3 = o32Var;
                                                o32Var3.getClass();
                                                hd2 hd2Var3 = hd2.B;
                                                t92 t92Var3 = hd2Var3.m;
                                                String str6 = o32Var3.d;
                                                String str7 = o32Var3.e;
                                                Context context3 = o32Var3.a;
                                                if (!t92Var3.i(context3, str6, str7)) {
                                                    hd2Var3.m.c(context3, o32Var3.d, o32Var3.e);
                                                } else {
                                                    zzgcuVar.execute(new p22(o32Var3, 5));
                                                }
                                                break;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        if (i == iE5) {
                            final zzgcu zzgcuVar3 = zzbzo.zze;
                            zzgcu zzgcuVar4 = zzbzo.zza;
                            if (zzdviVar.zzq()) {
                                zzgcuVar3.execute(new p22(o32Var, 0));
                                return;
                            } else {
                                final int i4 = 1;
                                zzgcuVar4.execute(new Runnable() { // from class: r22
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        switch (i4) {
                                            case 0:
                                                o32 o32Var2 = o32Var;
                                                o32Var2.getClass();
                                                hd2 hd2Var2 = hd2.B;
                                                t92 t92Var2 = hd2Var2.m;
                                                String str4 = o32Var2.d;
                                                String str5 = o32Var2.e;
                                                Context context2 = o32Var2.a;
                                                if (!t92Var2.i(context2, str4, str5)) {
                                                    hd2Var2.m.c(context2, o32Var2.d, o32Var2.e);
                                                } else {
                                                    zzgcuVar3.execute(new p22(o32Var2, 4));
                                                }
                                                break;
                                            default:
                                                o32 o32Var3 = o32Var;
                                                o32Var3.getClass();
                                                hd2 hd2Var3 = hd2.B;
                                                t92 t92Var3 = hd2Var3.m;
                                                String str6 = o32Var3.d;
                                                String str7 = o32Var3.e;
                                                Context context3 = o32Var3.a;
                                                if (!t92Var3.i(context3, str6, str7)) {
                                                    hd2Var3.m.c(context3, o32Var3.d, o32Var3.e);
                                                } else {
                                                    zzgcuVar3.execute(new p22(o32Var3, 5));
                                                }
                                                break;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        return;
                    }
                    Context context2 = o32Var.a;
                    if (!(context2 instanceof Activity)) {
                        k92.g("Can not create dialog without Activity Context");
                        return;
                    }
                    String str4 = o32Var.c;
                    String str5 = "No debug information";
                    if (!TextUtils.isEmpty(str4)) {
                        Uri uriBuild = new Uri.Builder().encodedQuery(str4.replaceAll("\\+", "%20")).build();
                        StringBuilder sb = new StringBuilder();
                        cd2 cd2Var = hd2.B.c;
                        HashMap mapL = cd2.l(uriBuild);
                        for (String str6 : mapL.keySet()) {
                            sb.append(str6);
                            sb.append(" = ");
                            sb.append((String) mapL.get(str6));
                            sb.append("\n\n");
                        }
                        String strTrim = sb.toString().trim();
                        if (!TextUtils.isEmpty(strTrim)) {
                            str5 = strTrim;
                        }
                    }
                    cd2 cd2Var2 = hd2.B.c;
                    AlertDialog.Builder builderI2 = cd2.i(context2);
                    builderI2.setMessage(str5);
                    builderI2.setTitle("Ad Information");
                    builderI2.setPositiveButton("Share", new rj0(o32Var, str5));
                    builderI2.setNegativeButton("Close", new jq0(2));
                    builderI2.create().show();
                }
            });
            builderI.create().show();
        } catch (WindowManager.BadTokenException unused) {
            k92.b();
        }
    }

    public final void c(Context context) {
        ArrayList arrayList = new ArrayList();
        int iE = e(arrayList, "None", true);
        final int iE2 = e(arrayList, "Shake", true);
        final int iE3 = e(arrayList, "Flick", true);
        int iOrdinal = this.b.zza().ordinal();
        final int i = iOrdinal != 1 ? iOrdinal != 2 ? iE : iE3 : iE2;
        cd2 cd2Var = hd2.B.c;
        AlertDialog.Builder builderI = cd2.i(context);
        final AtomicInteger atomicInteger = new AtomicInteger(i);
        builderI.setTitle("Setup gesture");
        builderI.setSingleChoiceItems((CharSequence[]) arrayList.toArray(new String[0]), i, new yn0(atomicInteger, 2));
        builderI.setNegativeButton("Dismiss", new yn0(this, 3));
        builderI.setPositiveButton("Save", new DialogInterface.OnClickListener() { // from class: k32
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                o32 o32Var = this.g;
                o32Var.getClass();
                AtomicInteger atomicInteger2 = atomicInteger;
                if (atomicInteger2.get() != i) {
                    int i3 = atomicInteger2.get();
                    int i4 = iE2;
                    zzdvi zzdviVar = o32Var.b;
                    if (i3 == i4) {
                        zzdviVar.zzm(zzdve.SHAKE);
                    } else if (atomicInteger2.get() == iE3) {
                        zzdviVar.zzm(zzdve.FLICK);
                    } else {
                        zzdviVar.zzm(zzdve.NONE);
                    }
                }
                o32Var.b();
            }
        });
        builderI.setOnCancelListener(new bv(this, 1));
        builderI.create().show();
    }

    public final boolean d(float f, float f2, float f3, float f4) {
        float fAbs = Math.abs(this.i.x - f);
        int i = this.h;
        return fAbs < ((float) i) && Math.abs(this.i.y - f2) < ((float) i) && Math.abs(this.j.x - f3) < ((float) i) && Math.abs(this.j.y - f4) < ((float) i);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(100);
        sb.append("{Dialog: ");
        sb.append(this.c);
        sb.append(",DebugSignal: ");
        sb.append(this.f);
        sb.append(",AFMA Version: ");
        sb.append(this.e);
        sb.append(",Ad Unit ID: ");
        return uo.k(sb, this.d, "}");
    }
}
