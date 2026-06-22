package defpackage;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.lifecycle.b;
import androidx.profileinstaller.ProfileVersion;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager.widget.ViewPager;
import androidx.work.Worker;
import com.google.android.gms.internal.ads.zzbbc;
import com.luutinhit.launcher6.PageIndicator;
import com.luutinhit.launcher6.PageIndicatorMarker;
import com.luutinhit.launcher6.t;
import com.luutinhit.launcher6.util.TextViewCustomFont;
import com.luutinhit.launcher6.v;
import com.luutinhit.launcher6.widget.WidgetsContainerView;
import com.luutinhit.launcherios.customui.SpinView;
import com.luutinhit.launcherios.searchview.SearchViewLayout;
import com.luutinhit.wallpaper.livewallpaper.LiveWallpaperRenderer;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes.dex */
public final class fl0 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ Object h;

    public /* synthetic */ fl0(Object obj, int i) {
        this.g = i;
        this.h = obj;
    }

    private final void a() {
        synchronized (this) {
            ((lh0) this.h).w = false;
        }
        while (lh0.H.poll() != null) {
        }
        if (((lh0) this.h).x.isAttachedToWindow()) {
            ((lh0) this.h).F();
            return;
        }
        View view = ((lh0) this.h).x;
        ss1 ss1Var = lh0.I;
        view.removeOnAttachStateChangeListener(ss1Var);
        ((lh0) this.h).x.addOnAttachStateChangeListener(ss1Var);
    }

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
    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        InputMethodManager inputMethodManager;
        int i = 0;
        switch (this.g) {
            case 0:
                cl0 cl0Var = (cl0) this.h;
                hl0 hl0VarL = cl0Var.j.l();
                hl0 hl0Var = cl0Var.h;
                if (hl0Var != hl0VarL || hl0VarL == null) {
                    return;
                }
                hl0Var.bindAppsAdded(null, null, null, cl0Var.i);
                return;
            case 1:
                ArrayList arrayList = (ArrayList) this.h;
                int size = arrayList.size();
                while (i < size) {
                    Object obj2 = arrayList.get(i);
                    i++;
                    ((qh0) obj2).e();
                }
                return;
            case 2:
                t tVar = ((sl0) this.h).k;
                if (tVar != null) {
                    tVar.onAppWidgetHostReset();
                    return;
                }
                return;
            case 3:
                synchronized (((b) this.h).a) {
                    obj = ((b) this.h).f;
                    ((b) this.h).f = b.k;
                    break;
                }
                ((b) this.h).e(obj);
                return;
            case 4:
                ((LiveWallpaperRenderer) this.h).transitionCal();
                return;
            case 5:
                PageIndicator pageIndicator = (PageIndicator) this.h;
                try {
                    ArrayList arrayList2 = pageIndicator.m;
                    int size2 = arrayList2.size();
                    int i2 = 0;
                    while (i2 < size2) {
                        Object obj3 = arrayList2.get(i2);
                        i2++;
                        PageIndicatorMarker pageIndicatorMarker = (PageIndicatorMarker) obj3;
                        if (pageIndicatorMarker != null) {
                            pageIndicatorMarker.setVisibility(8);
                        }
                    }
                    TextViewCustomFont textViewCustomFont = pageIndicator.w;
                    if (textViewCustomFont != null) {
                        textViewCustomFont.setVisibility(0);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    th.getMessage();
                    return;
                }
            case 6:
                ((v) this.h).L();
                return;
            case 7:
                RecyclerView recyclerView = ((z21) this.h).b0;
                recyclerView.focusableViewAvailable(recyclerView);
                return;
            case 8:
                ((c31) this.h).s();
                return;
            case 9:
                ((s71) this.h).l();
                return;
            case 10:
                sa1 sa1Var = (sa1) this.h;
                sa1Var.i.h(sa1Var);
                return;
            case 11:
                int i3 = SearchViewLayout.C;
                SearchViewLayout searchViewLayout = (SearchViewLayout) ((v3) this.h).h;
                EditText editText = searchViewLayout.m;
                editText.requestFocus();
                if (searchViewLayout.h.getResources().getConfiguration().keyboard == 1 && (inputMethodManager = searchViewLayout.z) != null) {
                    inputMethodManager.showSoftInput(editText, 0);
                    return;
                }
                return;
            case 12:
                ((SearchViewLayout) this.h).clearFocus();
                return;
            case 13:
                WeakHashMap weakHashMap = qs1.a;
                SpinView spinView = (SpinView) this.h;
                if (spinView.isAttachedToWindow()) {
                    spinView.v = (spinView.v + 1) % ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                    spinView.postInvalidate();
                    Handler handler = spinView.x;
                    int i4 = SpinView.z;
                    handler.postDelayed(this, 20);
                    return;
                }
                try {
                    spinView.w.quit();
                    return;
                } catch (Exception e) {
                    int i5 = SpinView.z;
                    e.getMessage();
                    return;
                }
            case 14:
                ((StaggeredGridLayoutManager) this.h).E0();
                return;
            case 15:
                Context context = (Context) this.h;
                try {
                    Thread.sleep(250L);
                    break;
                } catch (Throwable unused) {
                }
                try {
                    PendingIntent activity = PendingIntent.getActivity(context, 0, new Intent("android.intent.action.MAIN").addCategory("android.intent.category.HOME").setPackage(context.getPackageName()).addFlags(268435456), 1409286144);
                    AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
                    if (alarmManager != null) {
                        alarmManager.set(3, SystemClock.elapsedRealtime() + 50, activity);
                    }
                    Process.killProcess(Process.myPid());
                    return;
                } catch (Throwable unused2) {
                    return;
                }
            case 16:
                a();
                return;
            case 17:
                ((us1) this.h).l(0);
                return;
            case 18:
                ((vs1) this.h).p(0);
                return;
            case 19:
                ViewPager viewPager = (ViewPager) this.h;
                viewPager.setScrollState(0);
                viewPager.p();
                return;
            case 20:
                WidgetsContainerView widgetsContainerView = (WidgetsContainerView) this.h;
                Rect rect = new Rect(0, 0, 0, 0);
                Rect rect2 = widgetsContainerView.S;
                if (rect.equals(rect2)) {
                    return;
                }
                rect2.set(rect);
                widgetsContainerView.setPadding(0, rect.top, 0, rect.bottom);
                widgetsContainerView.setPadding(0, 0, 0, 0);
                return;
            case zzbbc.zzt.zzm /* 21 */:
                Worker worker = (Worker) this.h;
                try {
                    worker.k.i(worker.doWork());
                    return;
                } catch (Throwable th2) {
                    worker.k.j(th2);
                    return;
                }
            case 22:
                uz1 uz1Var = (uz1) this.h;
                try {
                    try {
                        try {
                            ho0 ho0Var = (ho0) uz1Var.w.get();
                            if (ho0Var == null) {
                                ka0 ka0VarJ = ka0.j();
                                int i6 = uz1.y;
                                String str = uz1Var.j.c;
                                ka0VarJ.getClass();
                            } else {
                                ka0 ka0VarJ2 = ka0.j();
                                int i7 = uz1.y;
                                String str2 = uz1Var.j.c;
                                ho0Var.toString();
                                ka0VarJ2.getClass();
                                uz1Var.m = ho0Var;
                            }
                        } catch (InterruptedException | ExecutionException unused3) {
                            ka0 ka0VarJ3 = ka0.j();
                            int i8 = uz1.y;
                            ka0VarJ3.getClass();
                        }
                        break;
                    } catch (CancellationException unused4) {
                        ka0 ka0VarJ4 = ka0.j();
                        int i9 = uz1.y;
                        ka0VarJ4.getClass();
                    }
                    uz1Var.b();
                    return;
                } catch (Throwable th3) {
                    uz1Var.b();
                    throw th3;
                }
            case 23:
                ((v02) this.h).e();
                return;
            case ProfileVersion.MIN_SUPPORTED_SDK /* 24 */:
                s5 s5Var = ((v02) ((xz1) this.h).g).h;
                s5Var.disconnect(s5Var.getClass().getName().concat(" disconnecting because it was signed out."));
                return;
            case 25:
                ((g12) this.h).n.b(new vl(4));
                return;
            case 26:
                Thread threadCurrentThread = Thread.currentThread();
                j42 j42Var = (j42) this.h;
                j42Var.zzb = threadCurrentThread;
                j42Var.zza();
                return;
            case 27:
                ((yb2) this.h).zzc();
                return;
            case 28:
                a52 a52Var = ((z92) this.h).g.g;
                if (a52Var != null) {
                    try {
                        a52Var.zze(1);
                        return;
                    } catch (RemoteException unused5) {
                        k92.j(5);
                        return;
                    }
                }
                return;
            default:
                a52 a52Var2 = ((ca2) this.h).g;
                if (a52Var2 != null) {
                    try {
                        a52Var2.zze(1);
                        return;
                    } catch (RemoteException unused6) {
                        k92.j(5);
                        return;
                    }
                }
                return;
        }
    }

    public fl0(uz1 uz1Var, String str) {
        this.g = 22;
        this.h = uz1Var;
    }
}
