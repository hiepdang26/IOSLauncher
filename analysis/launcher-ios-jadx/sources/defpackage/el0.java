package defpackage;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.appwidget.AppWidgetHostView;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.os.SystemClock;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ProgressBar;
import androidx.profileinstaller.ProfileVersion;
import androidx.work.Worker;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.internal.ads.zzaup;
import com.google.android.gms.internal.ads.zzbbc;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbtq;
import com.google.android.gms.internal.ads.zzdsk;
import com.google.android.gms.internal.ads.zzffk;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.luutinhit.launcher6.Workspace;
import com.luutinhit.launcher6.t;
import com.luutinhit.launcher6.u;
import com.luutinhit.launcher6.v;
import com.luutinhit.launcher6.widget.WidgetsContainerView;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class el0 implements Runnable {
    public final /* synthetic */ int g;
    public Object h;
    public final Object i;

    public /* synthetic */ el0(Object obj, Object obj2, int i) {
        this.g = i;
        this.i = obj;
        this.h = obj2;
    }

    private final void a() {
        if (!((u) this.i).h) {
            rl0.y((el0) this.h);
            return;
        }
        ArrayList arrayList = rl0.z;
        synchronized (arrayList) {
            arrayList.add((el0) this.h);
        }
    }

    private final void b() {
        try {
            ((Runnable) this.i).run();
            synchronized (((jf1) this.h).j) {
                ((jf1) this.h).b();
            }
        } catch (Throwable th) {
            synchronized (((jf1) this.h).j) {
                ((jf1) this.h).b();
                throw th;
            }
        }
    }

    private final void c() {
        lz1 lz1VarC = ((kl1) this.i).g.m.c((String) this.h);
        if (lz1VarC == null || !lz1VarC.b()) {
            return;
        }
        synchronized (((kl1) this.i).i) {
            ((kl1) this.i).l.put(m90.i(lz1VarC), lz1VarC);
            kl1 kl1Var = (kl1) this.i;
            ((kl1) this.i).m.put(m90.i(lz1VarC), ty1.a(kl1Var.n, lz1VarC, (j10) ((qm0) kl1Var.h).b, kl1Var));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6, types: [bn0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v7, types: [bn0, java.lang.Object] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final void d() {
        if (((t02) this.i).h) {
            vl vlVar = ((q12) this.h).b;
            if ((vlVar.h == 0 || vlVar.i == null) ? false : true) {
                t02 t02Var = (t02) this.i;
                ?? r4 = t02Var.g;
                Activity activityA = t02Var.a();
                PendingIntent pendingIntent = vlVar.i;
                hg0.i(pendingIntent);
                int i = ((q12) this.h).a;
                int i2 = GoogleApiActivity.h;
                Intent intent = new Intent(activityA, (Class<?>) GoogleApiActivity.class);
                intent.putExtra("pending_intent", pendingIntent);
                intent.putExtra("failing_client_id", i);
                intent.putExtra("notify_manager", false);
                r4.startActivityForResult(intent, 1);
                return;
            }
            t02 t02Var2 = (t02) this.i;
            if (t02Var2.k.b(t02Var2.a(), null, vlVar.h) != null) {
                t02 t02Var3 = (t02) this.i;
                da0 da0Var = t02Var3.k;
                Activity activityA2 = t02Var3.a();
                t02 t02Var4 = (t02) this.i;
                da0Var.h(activityA2, t02Var4.g, vlVar.h, t02Var4);
                return;
            }
            if (vlVar.h != 18) {
                t02 t02Var5 = (t02) this.i;
                int i3 = ((q12) this.h).a;
                t02Var5.i.set(null);
                t02Var5.m.g(vlVar, i3);
                return;
            }
            t02 t02Var6 = (t02) this.i;
            da0 da0Var2 = t02Var6.k;
            Activity activityA3 = t02Var6.a();
            t02 t02Var7 = (t02) this.i;
            da0Var2.getClass();
            ProgressBar progressBar = new ProgressBar(activityA3, null, R.attr.progressBarStyleLarge);
            progressBar.setIndeterminate(true);
            progressBar.setVisibility(0);
            AlertDialog.Builder builder = new AlertDialog.Builder(activityA3);
            builder.setView(progressBar);
            builder.setMessage(z02.b(activityA3, 18));
            builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
            AlertDialog alertDialogCreate = builder.create();
            da0.f(activityA3, alertDialogCreate, "GooglePlayServicesUpdatingDialog", t02Var7);
            t02 t02Var8 = (t02) this.i;
            da0 da0Var3 = t02Var8.k;
            Context applicationContext = t02Var8.a().getApplicationContext();
            tu tuVar = new tu(this, alertDialogCreate, 10);
            da0Var3.getClass();
            IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
            intentFilter.addDataScheme("package");
            ro0 ro0Var = new ro0(tuVar);
            applicationContext.registerReceiver(ro0Var, intentFilter);
            ro0Var.b = applicationContext;
            if (ja0.a(applicationContext)) {
                return;
            }
            t02 t02Var9 = (t02) this.i;
            t02Var9.i.set(null);
            t12 t12Var = t02Var9.m.t;
            t12Var.sendMessage(t12Var.obtainMessage(3));
            if (alertDialogCreate.isShowing()) {
                alertDialogCreate.dismiss();
            }
            synchronized (ro0Var) {
                try {
                    Context context = (Context) ro0Var.b;
                    if (context != null) {
                        context.unregisterReceiver(ro0Var);
                    }
                    ro0Var.b = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalAccessException, InvocationTargetException {
        jn0 jn0Var;
        boolean z;
        sd0 sd0Var;
        Set set;
        zzffk zzffkVar;
        sd0 nd2Var = null;
        switch (this.g) {
            case 0:
                synchronized (rl0.A) {
                    try {
                        ArrayList arrayList = new ArrayList();
                        jq1 jq1VarB = jq1.b();
                        wp0 wp0Var = rl0.B;
                        wp0Var.getClass();
                        int i = 0;
                        while (i < wp0Var.size()) {
                            int i2 = i + 1;
                            qh0 qh0Var = (qh0) wp0Var.valueAt(i);
                            if (qh0Var instanceof og1) {
                                og1 og1Var = (og1) qh0Var;
                                ComponentName componentNameG = og1Var.g();
                                if (og1Var.h(3) && componentNameG != null && ((String) this.h).equals(componentNameG.getPackageName())) {
                                    if (og1Var.h(2)) {
                                        ((rl0) this.i).t.v(og1Var, og1Var.H, jq1VarB, og1Var.A && og1Var.i >= 0 && og1Var.q >= 9);
                                    } else {
                                        og1Var.i(((rl0) this.i).t);
                                    }
                                    arrayList.add(og1Var);
                                }
                            }
                            i = i2;
                        }
                        if (!arrayList.isEmpty()) {
                            ((rl0) this.i).j.K(new xm(this, arrayList, jq1VarB, 6, false));
                        }
                    } finally {
                    }
                    break;
                }
                return;
            case 1:
                nq0 nq0Var = (nq0) this.h;
                nq0Var.h = new ArrayList();
                nq0Var.i = new ArrayList();
                nq0Var.j = new HashMap();
                HashSet hashSet = new HashSet();
                SharedPreferences sharedPreferences = nq0Var.d;
                String str = nq0Var.g;
                Set<String> stringSet = sharedPreferences.getStringSet(str, null);
                if (stringSet == null) {
                    z = false;
                } else {
                    hashSet.addAll(stringSet);
                    z = true;
                }
                for (ek0 ek0Var : (List) this.i) {
                    String packageName = ek0Var.b().getPackageName();
                    if (!hashSet.contains(packageName)) {
                        hashSet.add(packageName);
                        nq0Var.d(ek0Var, ek0Var.c());
                        i = 1;
                    }
                }
                if (i != 0) {
                    sharedPreferences.edit().putStringSet(str, hashSet).apply();
                    nq0Var.a(z);
                    return;
                }
                return;
            case 2:
                a();
                return;
            case 3:
                break;
            case 4:
                ArrayList arrayList2 = (ArrayList) this.h;
                int size = arrayList2.size();
                while (i < size) {
                    Object obj = arrayList2.get(i);
                    i++;
                    ((w40) this.i).f((og1) obj);
                }
                return;
            case 5:
                ((p02) this.i).z((zr0) this.h);
                return;
            case 6:
                ((fl0) this.h).run();
                ((v) this.i).y();
                return;
            case 7:
                ((EditText) this.h).removeTextChangedListener(((s11) ((fj) this.i).b).e);
                return;
            case 8:
                ((f50) this.h).a(this.i);
                return;
            case 9:
                b();
                return;
            case 10:
                vs1 vs1Var = ((SwipeDismissBehavior) this.i).a;
                if (vs1Var == null || !vs1Var.g()) {
                    return;
                }
                WeakHashMap weakHashMap = qs1.a;
                ((View) this.h).postOnAnimation(this);
                return;
            case 11:
                c();
                return;
            case 12:
                bx1 bx1Var = (bx1) this.i;
                w11 w11Var = bx1Var.l;
                try {
                    if (bx1Var.m == -1) {
                        return;
                    }
                    lk0 appWidgetHost = bx1Var.i.getAppWidgetHost();
                    t tVar = bx1Var.i;
                    int i3 = bx1Var.m;
                    rk0 rk0Var = (rk0) this.h;
                    appWidgetHost.getClass();
                    rk0Var.getClass();
                    AppWidgetHostView appWidgetHostViewCreateView = appWidgetHost.createView(tVar, i3, rk0Var);
                    w11Var.A = appWidgetHostViewCreateView;
                    bx1Var.m = -1;
                    appWidgetHostViewCreateView.setVisibility(4);
                    int[] iArrX0 = bx1Var.i.getWorkspace().x0(w11Var, false);
                    pw pwVar = new pw(iArrX0[0], iArrX0[1]);
                    pwVar.c = 0;
                    pwVar.b = 0;
                    pwVar.d = true;
                    appWidgetHostViewCreateView.setLayoutParams(pwVar);
                    bx1Var.i.getDragLayer().addView(appWidgetHostViewCreateView);
                    bx1Var.k.setTag(w11Var);
                    return;
                } catch (Throwable th) {
                    th.getMessage();
                    return;
                }
            case 13:
                int i4 = WidgetsContainerView.i0;
                InputMethodManager inputMethodManager = ((WidgetsContainerView) this.i).e0;
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(((View) this.h).getWindowToken(), 0);
                    return;
                }
                return;
            case 14:
                if (((xy1) this.i).g.g instanceof h) {
                    return;
                }
                try {
                    o50 o50Var = (o50) ((nf1) this.h).get();
                    if (o50Var == null) {
                        throw new IllegalStateException("Worker was marked important (" + ((xy1) this.i).i.c + ") but did not provide ForegroundInfo");
                    }
                    ka0 ka0VarJ = ka0.j();
                    int i5 = xy1.m;
                    String str2 = ((xy1) this.i).i.c;
                    ka0VarJ.getClass();
                    xy1 xy1Var = (xy1) this.i;
                    nf1 nf1Var = xy1Var.g;
                    yy1 yy1Var = xy1Var.k;
                    Context context = xy1Var.h;
                    UUID id = xy1Var.j.getId();
                    yy1Var.getClass();
                    nf1 nf1Var2 = new nf1();
                    yy1Var.a.e(new sj0(yy1Var, nf1Var2, id, o50Var, context, 2));
                    nf1Var.k(nf1Var2);
                    return;
                } catch (Throwable th2) {
                    ((xy1) this.i).g.j(th2);
                    return;
                }
            case 15:
                nf1 nf1Var3 = (nf1) this.h;
                try {
                    nf1Var3.i(((Worker) this.i).getForegroundInfo());
                    return;
                } catch (Throwable th3) {
                    nf1Var3.j(th3);
                    return;
                }
            case 16:
                if (((uz1) this.i).w.g instanceof h) {
                    return;
                }
                try {
                    ((nf1) this.h).get();
                    ka0 ka0VarJ2 = ka0.j();
                    int i6 = uz1.y;
                    String str3 = ((uz1) this.i).j.c;
                    ka0VarJ2.getClass();
                    uz1 uz1Var = (uz1) this.i;
                    uz1Var.w.k(uz1Var.k.startWork());
                    return;
                } catch (Throwable th4) {
                    ((uz1) this.i).w.j(th4);
                    return;
                }
            case 17:
                AppWidgetHostView appWidgetHostView = (AppWidgetHostView) this.h;
                if (appWidgetHostView != null) {
                    appWidgetHostView.setVisibility(0);
                }
                Runnable runnable = (Runnable) this.i;
                if (runnable != null) {
                    runnable.run();
                    return;
                }
                return;
            case 18:
                Workspace workspace = (Workspace) this.i;
                boolean z2 = workspace.U;
                ng ngVar = (ng) this.h;
                if (z2) {
                    workspace.n1 = ngVar;
                    return;
                } else {
                    ngVar.run();
                    return;
                }
            case 19:
                Workspace workspace2 = (Workspace) this.i;
                workspace2.f1 = false;
                workspace2.d1(false);
                el0 el0Var = (el0) this.h;
                if (el0Var != null) {
                    el0Var.run();
                    return;
                }
                return;
            case 20:
                wc0 wc0Var = (wc0) this.i;
                v02 v02Var = (v02) ((ha0) wc0Var.l).p.get((b6) wc0Var.i);
                if (v02Var == null) {
                    return;
                }
                vl vlVar = (vl) this.h;
                if ((vlVar.h == 0 ? 1 : 0) == 0) {
                    v02Var.m(vlVar, null);
                    return;
                }
                wc0Var.g = true;
                s5 s5Var = (s5) wc0Var.h;
                if (s5Var.requiresSignIn()) {
                    if (!wc0Var.g || (sd0Var = (sd0) wc0Var.j) == null) {
                        return;
                    }
                    s5Var.getRemoteService(sd0Var, (Set) wc0Var.k);
                    return;
                }
                try {
                    s5Var.getRemoteService(null, s5Var.a());
                    return;
                } catch (SecurityException unused) {
                    s5Var.disconnect("Failed to get service from broker.");
                    v02Var.m(new vl(10), null);
                    return;
                }
            case zzbbc.zzt.zzm /* 21 */:
                o12 o12Var = (o12) this.h;
                vl vlVar2 = o12Var.h;
                i = vlVar2.h == 0 ? 1 : 0;
                g12 g12Var = (g12) this.i;
                if (i != 0) {
                    v12 v12Var = o12Var.i;
                    hg0.i(v12Var);
                    vl vlVar3 = v12Var.i;
                    if (vlVar3.h != 0) {
                        String strValueOf = String.valueOf(vlVar3);
                        new Exception();
                        "Sign-in succeeded with resolve account failure: ".concat(strValueOf);
                        g12Var.n.b(vlVar3);
                        g12Var.m.disconnect();
                        return;
                    }
                    wc0 wc0Var2 = g12Var.n;
                    IBinder iBinder = v12Var.h;
                    if (iBinder != null) {
                        int i7 = c1.h;
                        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                        nd2Var = iInterfaceQueryLocalInterface instanceof sd0 ? (sd0) iInterfaceQueryLocalInterface : new nd2(iBinder, "com.google.android.gms.common.internal.IAccountAccessor", 1);
                    }
                    wc0Var2.getClass();
                    if (nd2Var == null || (set = g12Var.k) == null) {
                        new Exception();
                        wc0Var2.b(new vl(4));
                    } else {
                        wc0Var2.j = nd2Var;
                        wc0Var2.k = set;
                        if (wc0Var2.g) {
                            ((s5) wc0Var2.h).getRemoteService(nd2Var, set);
                        }
                    }
                } else {
                    g12Var.n.b(vlVar2);
                }
                g12Var.m.disconnect();
                return;
            case 22:
                d();
                return;
            case 23:
                e92 e92Var = (e92) this.i;
                m2 m2Var = (m2) this.h;
                m2Var.getClass();
                try {
                    m2Var.b.zzg(lc2.a(m2Var.a, e92Var));
                    return;
                } catch (RemoteException unused2) {
                    k92.f();
                    return;
                }
            case ProfileVersion.MIN_SUPPORTED_SDK /* 24 */:
                km1 km1Var = (km1) this.i;
                km1Var.getClass();
                Uri uriZza = Uri.parse((String) this.h);
                try {
                    boolean zBooleanValue = ((Boolean) n42.d.c.zza(zzbbw.zzla)).booleanValue();
                    WebView webView = km1Var.b;
                    Context context2 = km1Var.a;
                    uriZza = (!zBooleanValue || (zzffkVar = km1Var.d) == null) ? km1Var.c.zza(uriZza, context2, webView, null) : zzffkVar.zza(uriZza, context2, webView, null);
                    break;
                } catch (zzaup e) {
                    k92.j(3);
                    hd2.B.g.zzw(e, "TaggingLibraryJsInterface.recordClick");
                }
                km1Var.i.zzc(uriZza.toString(), null);
                return;
            case 25:
                if (((od2) ((pm1) this.h)).d) {
                    ((od2) ((b82) this.i).h).i();
                    return;
                }
                try {
                    ((od2) ((b82) this.i).h).h(((fo) ((b82) this.i).j).then((pm1) this.h));
                    return;
                } catch (zc1 e2) {
                    if (e2.getCause() instanceof Exception) {
                        ((od2) ((b82) this.i).h).g((Exception) e2.getCause());
                        return;
                    } else {
                        ((od2) ((b82) this.i).h).g(e2);
                        return;
                    }
                } catch (Exception e3) {
                    ((od2) ((b82) this.i).h).g(e3);
                    return;
                }
            case 26:
                o92 o92Var = (o92) this.h;
                o92Var.getClass();
                o92Var.l.addView((View) gy0.r((he0) this.i));
                return;
            case 27:
                b82 b82Var = (b82) this.i;
                try {
                    pm1 pm1Var = (pm1) ((pw1) b82Var.j).then((pm1) this.h);
                    if (pm1Var == null) {
                        b82Var.onFailure(new NullPointerException("Continuation returned null"));
                        return;
                    }
                    l10 l10Var = sm1.b;
                    od2 od2Var = (od2) pm1Var;
                    b82 b82Var2 = new b82((Executor) l10Var, (cz0) b82Var);
                    hh1 hh1Var = od2Var.b;
                    hh1Var.f(b82Var2);
                    od2Var.k();
                    hh1Var.f(new b82((Executor) l10Var, (ty0) b82Var));
                    od2Var.k();
                    hh1Var.f(new b82(l10Var, b82Var));
                    od2Var.k();
                    return;
                } catch (zc1 e4) {
                    if (e4.getCause() instanceof Exception) {
                        ((od2) b82Var.h).g((Exception) e4.getCause());
                        return;
                    } else {
                        ((od2) b82Var.h).g(e4);
                        return;
                    }
                } catch (Exception e5) {
                    ((od2) b82Var.h).g(e5);
                    return;
                }
            case 28:
                hd2.B.j.getClass();
                di.j((zzdsk) this.h, "cld_r", SystemClock.elapsedRealtime() - ((Long) this.i).longValue());
                return;
            default:
                va vaVar = (va) this.h;
                try {
                    vaVar.g.b(((s2) this.i).a);
                    return;
                } catch (IllegalStateException e6) {
                    zzbtq.zza(vaVar.getContext()).zzh(e6, "BaseAdView.loadAd");
                    return;
                }
        }
        do {
            try {
                ((Runnable) this.h).run();
            } catch (Throwable th5) {
                os.h(sz.g, th5);
            }
            jn0Var = (jn0) this.i;
            Runnable runnableC = jn0Var.C();
            if (runnableC == null) {
                return;
            }
            this.h = runnableC;
            i++;
        } while (i < 16);
        cq1 cq1Var = jn0Var.i;
        cq1Var.getClass();
        cq1Var.z(jn0Var, this);
    }

    public /* synthetic */ el0(Object obj, Object obj2, int i, boolean z) {
        this.g = i;
        this.h = obj;
        this.i = obj2;
    }

    public el0(SwipeDismissBehavior swipeDismissBehavior, View view, boolean z) {
        this.g = 10;
        this.i = swipeDismissBehavior;
        this.h = view;
    }
}
