package defpackage;

import android.R;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.opengl.EGL14;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Trace;
import android.view.Surface;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.a;
import androidx.profileinstaller.ProfileVersion;
import androidx.work.CoroutineWorker;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import com.google.android.gms.internal.ads.zzbbc;
import com.luutinhit.launcher6.CellLayout;
import com.luutinhit.launcher6.Folder;
import com.luutinhit.launcher6.FolderIcon;
import com.luutinhit.launcher6.Hotseat;
import com.luutinhit.launcher6.PageIndicatorMarker;
import com.luutinhit.launcher6.PageIndicatorSpotlight;
import com.luutinhit.launcher6.t;
import com.luutinhit.launcher6.u;
import com.luutinhit.launcher6.util.CustomIconView;
import com.luutinhit.launcher6.util.TextViewCustomFont;
import com.luutinhit.launcher6.widget.AppSuggestionsWidget;
import com.luutinhit.launcherios.MainActivity;
import com.luutinhit.launcherios.activity.SplashActivity;
import com.luutinhit.launcherios.activity.WallpaperActivity;
import com.luutinhit.launcherios.searchview.SearchViewLayout;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class r1 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ Object h;

    public /* synthetic */ r1(Object obj, int i) {
        this.g = i;
        this.h = obj;
    }

    private final void a() {
        c50 c50Var = (c50) this.h;
        synchronized (c50Var.d) {
            try {
                if (c50Var.h == null) {
                    return;
                }
                try {
                    m50 m50VarD = c50Var.d();
                    int i = m50VarD.e;
                    if (i == 2) {
                        synchronized (c50Var.d) {
                        }
                    }
                    if (i != 0) {
                        throw new RuntimeException("fetchFonts result is not OK. (" + i + ")");
                    }
                    try {
                        int i2 = no1.a;
                        Trace.beginSection("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                        ka0 ka0Var = c50Var.c;
                        Context context = c50Var.a;
                        ka0Var.getClass();
                        m50[] m50VarArr = {m50VarD};
                        az1 az1Var = op1.a;
                        z71.c("TypefaceCompat.createFromFontInfo");
                        try {
                            Typeface typefaceH = op1.a.h(context, m50VarArr, 0);
                            Trace.endSection();
                            MappedByteBuffer mappedByteBufferP = p02.p(m50VarD.a, c50Var.a);
                            if (mappedByteBufferP == null || typefaceH == null) {
                                throw new RuntimeException("Unable to open file.");
                            }
                            try {
                                Trace.beginSection("EmojiCompat.MetadataRepo.create");
                                hz1 hz1Var = new hz1(typefaceH, m90.o(mappedByteBufferP));
                                Trace.endSection();
                                synchronized (c50Var.d) {
                                    try {
                                        os osVar = c50Var.h;
                                        if (osVar != null) {
                                            osVar.o(hz1Var);
                                        }
                                    } finally {
                                    }
                                }
                                c50Var.b();
                            } finally {
                                int i3 = no1.a;
                            }
                        } finally {
                            Trace.endSection();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                } catch (Throwable th2) {
                    synchronized (c50Var.d) {
                        try {
                            os osVar2 = c50Var.h;
                            if (osVar2 != null) {
                                osVar2.n(th2);
                            }
                            c50Var.b();
                        } finally {
                        }
                    }
                }
            } finally {
            }
        }
    }

    private final void b() {
        u uVar = (u) this.h;
        if (uVar.i) {
            uVar.d();
            return;
        }
        uVar.f();
        if (jk0.a().e.b) {
            rl0 rl0Var = uVar.k;
            boolean z = rl0Var.p;
            if (!rl0Var.o) {
                uVar.f();
            }
            if (!uVar.k.p) {
                ArrayList arrayList = new ArrayList();
                synchronized (rl0.A) {
                    try {
                        ArrayList arrayList2 = (ArrayList) uVar.k.r.g;
                        int size = arrayList2.size();
                        int i = 0;
                        while (i < size) {
                            Object obj = arrayList2.get(i);
                            i++;
                            v6 v6Var = (v6) obj;
                            rl0 rl0Var2 = uVar.k;
                            ComponentName componentName = v6Var.A;
                            jq1 jq1Var = v6Var.w;
                            rl0Var2.getClass();
                            Objects.toString(componentName);
                            Objects.toString(jq1Var);
                            if (rl0.h(rl0.B, new q11(componentName, jq1Var, 14)).isEmpty()) {
                                arrayList.add(v6Var);
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (!arrayList.isEmpty()) {
                    uVar.k.a(uVar.g, arrayList);
                    uVar.k.p = true;
                }
            }
        }
        uVar.d();
    }

    private final void c() {
        f81 f81Var = (f81) this.h;
        f81Var.getClass();
        while (true) {
            long jA = f81Var.a(System.nanoTime());
            if (jA == -1) {
                return;
            }
            if (jA > 0) {
                long j = jA / 1000000;
                long j2 = jA - (1000000 * j);
                synchronized (f81Var) {
                    try {
                        f81Var.wait(j, (int) j2);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        int i = 4;
        int i2 = 7;
        int i3 = 1;
        int i4 = 0;
        switch (this.g) {
            case 0:
                Activity activity = (Activity) this.h;
                if (activity.isFinishing()) {
                    return;
                }
                int i5 = Build.VERSION.SDK_INT;
                if (i5 >= 28) {
                    Class cls = y1.a;
                    activity.recreate();
                    return;
                }
                Class cls2 = y1.a;
                boolean z = i5 == 26 || i5 == 27;
                Method method = y1.f;
                if ((!z || method != null) && (y1.e != null || y1.d != null)) {
                    try {
                        Object obj2 = y1.c.get(activity);
                        if (obj2 != null && (obj = y1.b.get(activity)) != null) {
                            Application application = activity.getApplication();
                            x1 x1Var = new x1(activity);
                            application.registerActivityLifecycleCallbacks(x1Var);
                            Handler handler = y1.g;
                            handler.post(new w1(x1Var, obj2, i4));
                            try {
                                if (i5 == 26 || i5 == 27) {
                                    Boolean bool = Boolean.FALSE;
                                    method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                                } else {
                                    activity.recreate();
                                }
                                handler.post(new w1(application, x1Var, i3, null == true ? 1 : 0));
                                return;
                            } catch (Throwable th) {
                                handler.post(new w1(application, x1Var, i3, null == true ? 1 : 0));
                                throw th;
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
                activity.recreate();
                return;
            case 1:
                ((AppSuggestionsWidget) this.h).getAppSuggestions();
                return;
            case 2:
                ((d8) this.h).h.setLayerType(0, null);
                return;
            case 3:
                ((l8) this.h).o();
                return;
            case 4:
                Paint paint = CellLayout.V;
                CellLayout cellLayout = (CellLayout) this.h;
                if (cellLayout.isAttachedToWindow()) {
                    cellLayout.I.buildLayer();
                    return;
                }
                return;
            case 5:
                ((e6) this.h).invalidateOptionsMenu();
                return;
            case 6:
                ConstraintTrackingWorker constraintTrackingWorker = (ConstraintTrackingWorker) this.h;
                qg0.l(constraintTrackingWorker, "this$0");
                if (constraintTrackingWorker.n.g instanceof h) {
                    return;
                }
                String strB = constraintTrackingWorker.getInputData().b("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
                qg0.k(ka0.j(), "get()");
                if (strB == null || strB.length() == 0) {
                    int i6 = hn.a;
                    nf1 nf1Var = constraintTrackingWorker.n;
                    qg0.k(nf1Var, "future");
                    nf1Var.i(new eo0());
                    return;
                }
                io0 io0VarA = constraintTrackingWorker.getWorkerFactory().a(constraintTrackingWorker.getApplicationContext(), strB, constraintTrackingWorker.k);
                constraintTrackingWorker.o = io0VarA;
                if (io0VarA == null) {
                    int i7 = hn.a;
                    nf1 nf1Var2 = constraintTrackingWorker.n;
                    qg0.k(nf1Var2, "future");
                    nf1Var2.i(new eo0());
                    return;
                }
                cz1 cz1VarO = cz1.O(constraintTrackingWorker.getApplicationContext());
                mz1 mz1VarU = cz1VarO.j.u();
                String string = constraintTrackingWorker.getId().toString();
                qg0.k(string, "id.toString()");
                lz1 lz1VarI = mz1VarU.i(string);
                if (lz1VarI == null) {
                    nf1 nf1Var3 = constraintTrackingWorker.n;
                    qg0.k(nf1Var3, "future");
                    int i8 = hn.a;
                    nf1Var3.i(new eo0());
                    return;
                }
                hz1 hz1Var = cz1VarO.q;
                qg0.k(hz1Var, "workManagerImpl.trackers");
                pw1 pw1Var = new pw1(hz1Var);
                j10 j10Var = (j10) ((qm0) cz1VarO.k).b;
                qg0.k(j10Var, "workManagerImpl.workTask…r.taskCoroutineDispatcher");
                constraintTrackingWorker.n.addListener(new r1(ty1.a(pw1Var, lz1VarI, j10Var, constraintTrackingWorker), i2), new l10(2));
                if (!pw1Var.a(lz1VarI)) {
                    int i9 = hn.a;
                    nf1 nf1Var4 = constraintTrackingWorker.n;
                    qg0.k(nf1Var4, "future");
                    nf1Var4.i(new fo0());
                    return;
                }
                int i10 = hn.a;
                try {
                    io0 io0Var = constraintTrackingWorker.o;
                    qg0.h(io0Var);
                    do0 do0VarStartWork = io0Var.startWork();
                    qg0.k(do0VarStartWork, "delegate!!.startWork()");
                    do0VarStartWork.addListener(new wc(constraintTrackingWorker, do0VarStartWork, i), constraintTrackingWorker.getBackgroundExecutor());
                    return;
                } catch (Throwable unused2) {
                    int i11 = hn.a;
                    synchronized (constraintTrackingWorker.l) {
                        try {
                            if (constraintTrackingWorker.m) {
                                nf1 nf1Var5 = constraintTrackingWorker.n;
                                qg0.k(nf1Var5, "future");
                                nf1Var5.i(new fo0());
                                return;
                            } else {
                                nf1 nf1Var6 = constraintTrackingWorker.n;
                                qg0.k(nf1Var6, "future");
                                nf1Var6.i(new eo0());
                                return;
                            }
                        } finally {
                        }
                    }
                }
            case 7:
                ((ii0) this.h).b(null);
                return;
            case 8:
                CoroutineWorker coroutineWorker = (CoroutineWorker) this.h;
                if (coroutineWorker.l.g instanceof h) {
                    coroutineWorker.k.b(null);
                    return;
                }
                return;
            case 9:
                zq zqVar = (zq) this.h;
                ViewGroup viewGroup = (ViewGroup) zqVar.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(zqVar);
                    return;
                }
                return;
            case 10:
                ((CustomIconView) this.h).invalidate();
                return;
            case 11:
                ((my) ((be) this.h).h).setLayerType(0, null);
                return;
            case 12:
                ((z30) ((be) this.h).h).setLayerType(0, null);
                return;
            case 13:
                ((Folder) ((be) this.h).h).setLayerType(0, null);
                return;
            case 14:
                FolderIcon folderIcon = (FolderIcon) this.h;
                y80 y80Var = folderIcon.l;
                if (y80Var != null) {
                    y80Var.setFullBitmap(folderIcon.getBlurGlassWallpaper());
                    return;
                }
                h90 h90Var = folderIcon.m;
                if (h90Var != null) {
                    h90Var.setFullBitmap(folderIcon.getBlurGlassWallpaper());
                    return;
                }
                return;
            case 15:
                a();
                return;
            case 16:
                b90 b90Var = (b90) this.h;
                b90Var.getClass();
                try {
                    if (b90Var.c != EGL14.EGL_NO_SURFACE) {
                        EGL14.eglDestroySurface(EGL14.eglGetDisplay(0), b90Var.c);
                    }
                    break;
                } catch (Throwable unused3) {
                }
                b90Var.c = EGL14.EGL_NO_SURFACE;
                Surface surface = b90Var.b;
                if (surface != null) {
                    try {
                        surface.release();
                        break;
                    } catch (Throwable unused4) {
                    }
                    b90Var.b = null;
                    return;
                }
                return;
            case 17:
                l90 l90Var = (l90) this.h;
                l90Var.n = l90Var.h(l90Var.p, l90Var.n, false);
                l90Var.O.set(true);
                l90Var.P.set(true);
                return;
            case 18:
                Hotseat hotseat = (Hotseat) this.h;
                y80 y80Var2 = hotseat.r;
                if (y80Var2 != null) {
                    y80Var2.setFullBitmap(hotseat.getBlurGlassWallpaper());
                    return;
                }
                h90 h90Var2 = hotseat.s;
                if (h90Var2 != null) {
                    h90Var2.setFullBitmap(hotseat.getBlurGlassWallpaper());
                    return;
                }
                return;
            case 19:
                ((t) ((be) this.h).h).appsLibraryLayout.setLayerType(0, null);
                return;
            case 20:
                Looper.myQueue().addIdleHandler(new il0((r1) this.h, 1));
                return;
            case zzbbc.zzt.zzm /* 21 */:
                b();
                return;
            case 22:
                int i12 = PageIndicatorSpotlight.D;
                PageIndicatorSpotlight pageIndicatorSpotlight = (PageIndicatorSpotlight) this.h;
                pageIndicatorSpotlight.getClass();
                try {
                    ArrayList arrayList = pageIndicatorSpotlight.y;
                    int size = arrayList.size();
                    int i13 = 0;
                    while (i13 < size) {
                        Object obj3 = arrayList.get(i13);
                        i13++;
                        PageIndicatorMarker pageIndicatorMarker = (PageIndicatorMarker) obj3;
                        if (pageIndicatorMarker != null) {
                            pageIndicatorMarker.setVisibility(8);
                        }
                    }
                    TextViewCustomFont textViewCustomFont = pageIndicatorSpotlight.w;
                    if (textViewCustomFont != null) {
                        textViewCustomFont.setVisibility(0);
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    th2.getMessage();
                    return;
                }
            case 23:
                o31 o31Var = (o31) this.h;
                qg0.l(o31Var, "this$0");
                int i14 = o31Var.h;
                a aVar = o31Var.l;
                if (i14 == 0) {
                    o31Var.i = true;
                    aVar.d(um0.ON_PAUSE);
                }
                if (o31Var.g == 0 && o31Var.i) {
                    aVar.d(um0.ON_STOP);
                    o31Var.j = true;
                    return;
                }
                return;
            case ProfileVersion.MIN_SUPPORTED_SDK /* 24 */:
                c();
                return;
            case 25:
                SearchViewLayout searchViewLayout = (SearchViewLayout) this.h;
                h90 h90Var3 = searchViewLayout.p;
                if (h90Var3 != null) {
                    h90Var3.setFullBitmap(searchViewLayout.i.getBlurWallpaperProvider().e);
                    return;
                }
                return;
            case 26:
                int i15 = SplashActivity.B;
                SplashActivity splashActivity = (SplashActivity) this.h;
                splashActivity.getClass();
                splashActivity.startActivity(new Intent(splashActivity, (Class<?>) MainActivity.class));
                splashActivity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                splashActivity.finish();
                return;
            case 27:
                ((Toolbar) this.h).invalidateMenu();
                return;
            case 28:
                int i16 = WallpaperActivity.W;
                ((ConstraintLayout) this.h).setVisibility(8);
                return;
            default:
                ((ValueAnimator) this.h).start();
                return;
        }
    }
}
