package defpackage;

import android.content.ClipDescription;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.gms.internal.ads.zzbbc;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.luutinhit.launcher6.appslibrary.AppsLibraryItemFull;
import com.luutinhit.launcher6.t;
import com.luutinhit.launcher6.util.RealTimeBlurView;
import com.luutinhit.launcher6.util.recyclerviewbouncy.BouncyRecyclerView;
import com.luutinhit.launcher6.widget.CalendarWidget;
import com.luutinhit.launcher6.widget.FavoriteContactWidget;
import com.luutinhit.launcherios.activity.UtilitiesActivity;
import com.luutinhit.launcherios.searchview.SearchViewLayout;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import org.chromium.support_lib_boundary.WebMessageListenerBoundaryInterface;

/* JADX INFO: loaded from: classes.dex */
public class ow1 implements WebMessageListenerBoundaryInterface, ut0, xj0, mu0, k9, wr0, zp, b1, h20, e20, yq0, dl1, d01 {
    public final /* synthetic */ int g;
    public Object h;

    public /* synthetic */ ow1(Object obj, int i) {
        this.g = i;
        this.h = obj;
    }

    @Override // defpackage.wr0
    public void a(Object obj) {
        switch (this.g) {
            case 6:
                Integer num = (Integer) obj;
                Thread.currentThread().getName();
                if (num.intValue() > 0) {
                    ((CalendarWidget) this.h).postDelayed(new wc(this, num, 1), 1000L);
                }
                break;
            case 13:
                ((FavoriteContactWidget) this.h).postDelayed(new w1(this, (Integer) obj, 14, false), 1000L);
                break;
            default:
                ArrayList arrayList = (ArrayList) obj;
                int i = SearchViewLayout.C;
                arrayList.size();
                ((SearchViewLayout) this.h).setAdapter(arrayList);
                break;
        }
    }

    public r0 b(int i) {
        return null;
    }

    @Override // defpackage.wr0
    public void c(cw cwVar) {
        switch (this.g) {
            case 6:
                ((CalendarWidget) this.h).A = cwVar;
                break;
            case 13:
                ((FavoriteContactWidget) this.h).A = cwVar;
                break;
            default:
                ((SearchViewLayout) this.h).A = cwVar;
                break;
        }
    }

    @Override // defpackage.h20
    public Object create() {
        xk xkVar = (xk) this.h;
        return new ss((zn) xkVar.c, (wb2) xkVar.d);
    }

    @Override // defpackage.wr0
    public void d() {
        int i = this.g;
    }

    @Override // defpackage.dl1
    public void e(boolean z) {
        UtilitiesActivity utilitiesActivity = (UtilitiesActivity) this.h;
        UtilitiesActivity.A(utilitiesActivity, "marginHotseat", z);
        ar1.z(utilitiesActivity);
    }

    @Override // defpackage.b1
    public boolean f(View view) {
        switch (this.g) {
            case 11:
                DrawerLayout drawerLayout = (DrawerLayout) this.h;
                if (drawerLayout.isDrawerOpen(view) && drawerLayout.getDrawerLockMode(view) != 2) {
                    drawerLayout.closeDrawer(view);
                    break;
                }
                break;
            default:
                SwipeDismissBehavior swipeDismissBehavior = (SwipeDismissBehavior) this.h;
                if (swipeDismissBehavior.s(view)) {
                    WeakHashMap weakHashMap = qs1.a;
                    boolean z = view.getLayoutDirection() == 1;
                    int i = swipeDismissBehavior.c;
                    qs1.i((!(i == 0 && z) && (i != 1 || z)) ? view.getWidth() : -view.getWidth(), view);
                    view.setAlpha(0.0f);
                }
                break;
        }
        return true;
    }

    @Override // defpackage.d01
    public void g(byte[] bArr, Object obj, MessageDigest messageDigest) {
        Integer num = (Integer) obj;
        if (num == null) {
            return;
        }
        messageDigest.update(bArr);
        synchronized (((ByteBuffer) this.h)) {
            ((ByteBuffer) this.h).position(0);
            messageDigest.update(((ByteBuffer) this.h).putInt(num.intValue()).array());
        }
    }

    @Override // org.chromium.support_lib_boundary.FeatureFlagHolderBoundaryInterface
    public String[] getSupportedFeatures() {
        return new String[]{"WEB_MESSAGE_LISTENER", "WEB_MESSAGE_ARRAY_BUFFER"};
    }

    @Override // defpackage.xj0
    public void h(boolean z) {
        RealTimeBlurView realTimeBlurView;
        l8 l8Var = (l8) this.h;
        t tVar = l8Var.g;
        if (tVar == null || (realTimeBlurView = l8Var.n) == null || tVar.getBlurGlassWallpaper() == null) {
            return;
        }
        realTimeBlurView.setBitmapBackground(l8Var.g.getBlurGlassWallpaper());
    }

    public r0 i(int i) {
        return null;
    }

    public void j() {
        ((x50) this.h).E.J();
    }

    @Override // defpackage.k9
    public cs m(AssetManager assetManager, String str) {
        return new x20(assetManager, str, 1);
    }

    @Override // defpackage.ut0
    public void onCloseMenu(gt0 gt0Var, boolean z) {
        ((q6) this.h).k(gt0Var);
    }

    @Override // defpackage.wr0
    public void onError(Throwable th) {
        switch (this.g) {
            case 6:
            case 13:
                break;
            default:
                int i = SearchViewLayout.C;
                Objects.toString(th);
                break;
        }
    }

    @Override // defpackage.ut0
    public boolean onOpenSubMenu(gt0 gt0Var) {
        Window.Callback callback = ((q6) this.h).k.getCallback();
        if (callback == null) {
            return true;
        }
        callback.onMenuOpened(108, gt0Var);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    @Override // org.chromium.support_lib_boundary.WebMessageListenerBoundaryInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onPostMessage(android.webkit.WebView r8, java.lang.reflect.InvocationHandler r9, android.net.Uri r10, boolean r11, java.lang.reflect.InvocationHandler r12) {
        /*
            r7 = this;
            java.lang.Class<org.chromium.support_lib_boundary.WebMessageBoundaryInterface> r0 = org.chromium.support_lib_boundary.WebMessageBoundaryInterface.class
            java.lang.Object r9 = defpackage.wd.e(r0, r9)
            org.chromium.support_lib_boundary.WebMessageBoundaryInterface r9 = (org.chromium.support_lib_boundary.WebMessageBoundaryInterface) r9
            java.lang.reflect.InvocationHandler[] r0 = r9.getPorts()
            int r1 = r0.length
            pw1[] r1 = new defpackage.pw1[r1]
            r2 = 0
        L10:
            int r3 = r0.length
            if (r2 >= r3) goto L29
            pw1 r3 = new pw1
            r4 = r0[r2]
            r3.<init>()
            java.lang.Class<org.chromium.support_lib_boundary.WebMessagePortBoundaryInterface> r5 = org.chromium.support_lib_boundary.WebMessagePortBoundaryInterface.class
            java.lang.Object r4 = defpackage.wd.e(r5, r4)
            org.chromium.support_lib_boundary.WebMessagePortBoundaryInterface r4 = (org.chromium.support_lib_boundary.WebMessagePortBoundaryInterface) r4
            r3.g = r4
            r1[r2] = r3
            int r2 = r2 + 1
            goto L10
        L29:
            x5 r0 = defpackage.ww1.a
            boolean r0 = r0.b()
            if (r0 == 0) goto L5e
            java.lang.Class<org.chromium.support_lib_boundary.WebMessagePayloadBoundaryInterface> r0 = org.chromium.support_lib_boundary.WebMessagePayloadBoundaryInterface.class
            java.lang.reflect.InvocationHandler r9 = r9.getMessagePayload()
            java.lang.Object r9 = defpackage.wd.e(r0, r9)
            org.chromium.support_lib_boundary.WebMessagePayloadBoundaryInterface r9 = (org.chromium.support_lib_boundary.WebMessagePayloadBoundaryInterface) r9
            int r0 = r9.getType()
            if (r0 == 0) goto L54
            r1 = 1
            if (r0 == r1) goto L49
            r9 = 0
            r3 = r9
            goto L68
        L49:
            nw1 r0 = new nw1
            byte[] r9 = r9.getAsArrayBuffer()
            r0.<init>(r9)
        L52:
            r3 = r0
            goto L68
        L54:
            nw1 r0 = new nw1
            java.lang.String r9 = r9.getAsString()
            r0.<init>(r9)
            goto L52
        L5e:
            nw1 r0 = new nw1
            java.lang.String r9 = r9.getData()
            r0.<init>(r9)
            goto L52
        L68:
            if (r3 == 0) goto L8a
            java.lang.Class<org.chromium.support_lib_boundary.JsReplyProxyBoundaryInterface> r9 = org.chromium.support_lib_boundary.JsReplyProxyBoundaryInterface.class
            java.lang.Object r9 = defpackage.wd.e(r9, r12)
            org.chromium.support_lib_boundary.JsReplyProxyBoundaryInterface r9 = (org.chromium.support_lib_boundary.JsReplyProxyBoundaryInterface) r9
            sv r12 = new sv
            r0 = 1
            r12.<init>(r9, r0)
            java.lang.Object r9 = r9.getOrCreatePeer(r12)
            r6 = r9
            bi0 r6 = (defpackage.bi0) r6
            java.lang.Object r9 = r7.h
            r1 = r9
            sw1 r1 = (defpackage.sw1) r1
            r2 = r8
            r4 = r10
            r5 = r11
            r1.onPostMessage(r2, r3, r4, r5, r6)
        L8a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ow1.onPostMessage(android.webkit.WebView, java.lang.reflect.InvocationHandler, android.net.Uri, boolean, java.lang.reflect.InvocationHandler):void");
    }

    @Override // defpackage.xj0
    public void q(float f) {
        BouncyRecyclerView bouncyRecyclerView;
        float f2;
        int i;
        l8 l8Var = (l8) this.h;
        if (l8Var.g != null) {
            float f3 = l8Var.isRtl() ? f - l8Var.g.screenWidth : l8Var.g.screenWidth + f;
            l8Var.isRtl();
            RealTimeBlurView realTimeBlurView = l8Var.n;
            realTimeBlurView.v = f3;
            realTimeBlurView.invalidate();
            l8Var.post(new i8(this, f, 0));
            if (!l8Var.g.isRuntimeRenderSupport || (bouncyRecyclerView = l8Var.h) == null) {
                return;
            }
            for (int i2 = 0; i2 < bouncyRecyclerView.getChildCount(); i2++) {
                AppsLibraryItemFull appsLibraryItemFull = (AppsLibraryItemFull) bouncyRecyclerView.getChildAt(i2);
                h90 h90Var = appsLibraryItemFull.p;
                if (h90Var != null) {
                    if (appsLibraryItemFull.n.getWorkspace().o0) {
                        f2 = (-r5.screenWidth) + f;
                        i = appsLibraryItemFull.r;
                    } else {
                        f2 = r5.screenWidth + f;
                        i = appsLibraryItemFull.r;
                    }
                    h90Var.f((int) (f2 + i));
                }
            }
            if (l8Var.p != null) {
                l8Var.p.f((int) ((l8Var.g.getWorkspace().o0 ? -l8Var.g.screenWidth : l8Var.g.screenWidth) + f + (l8Var.s * 2)));
            }
        }
    }

    @Override // defpackage.mu0
    public lu0 s(qm0 qm0Var) {
        switch (this.g) {
            case 5:
                return new l9((AssetManager) this.h, this, 0);
            default:
                return new ld0((ow1) this.h);
        }
    }

    public void t(int i, View view) {
        Objects.toString(view);
        sh1 sh1Var = (sh1) this.h;
        rh1 rh1Var = sh1Var.x;
        rh1 rh1Var2 = rh1.k;
        if (rh1Var != rh1Var2) {
            sh1Var.y = rh1Var;
        }
        sh1Var.setPanelStateInternal(rh1Var2);
        sh1Var.z = sh1Var.c(i);
        if (sh1Var.m > 0) {
            sh1Var.w.setTranslationY(sh1Var.getCurrentParallaxOffset());
        }
        View view2 = sh1Var.v;
        Objects.toString(view2);
        synchronized (sh1Var.J) {
            try {
                Iterator it = sh1Var.J.iterator();
                while (it.hasNext()) {
                    ((qh1) it.next()).a(view2, sh1Var.z);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        ph1 ph1Var = (ph1) sh1Var.w.getLayoutParams();
        int height = ((sh1Var.getHeight() - sh1Var.getPaddingBottom()) - sh1Var.getPaddingTop()) - sh1Var.k;
        if (sh1Var.z <= 0.0f && !sh1Var.o) {
            int paddingBottom = sh1Var.n ? i - sh1Var.getPaddingBottom() : ((sh1Var.getHeight() - sh1Var.getPaddingBottom()) - sh1Var.v.getMeasuredHeight()) - i;
            ((ViewGroup.MarginLayoutParams) ph1Var).height = paddingBottom;
            if (paddingBottom == height) {
                ((ViewGroup.MarginLayoutParams) ph1Var).height = -1;
            }
            sh1Var.w.requestLayout();
        } else if (((ViewGroup.MarginLayoutParams) ph1Var).height != -1 && !sh1Var.o) {
            ((ViewGroup.MarginLayoutParams) ph1Var).height = -1;
            sh1Var.w.requestLayout();
        }
        ((sh1) this.h).invalidate();
    }

    public boolean u(int i, int i2, Bundle bundle) {
        return false;
    }

    @Override // defpackage.xj0
    public void x() {
        l8 l8Var = (l8) this.h;
        t tVar = l8Var.g;
        if (tVar == null || !tVar.isShaking()) {
            return;
        }
        l8Var.g.cancelShakingAnimation();
    }

    public ow1(int i) {
        Handler handler;
        Handler handlerB;
        this.g = i;
        switch (i) {
            case 1:
                if (Build.VERSION.SDK_INT >= 26) {
                    this.h = new t0(this);
                    return;
                } else {
                    this.h = new s0(this);
                    return;
                }
            case 8:
                TimeUnit timeUnit = TimeUnit.MINUTES;
                this.h = new f81();
                return;
            case 10:
                Looper mainLooper = Looper.getMainLooper();
                if (Build.VERSION.SDK_INT < 28) {
                    try {
                        handler = (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(mainLooper, null, Boolean.TRUE);
                    } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
                        handler = new Handler(mainLooper);
                    } catch (InvocationTargetException e) {
                        Throwable cause = e.getCause();
                        if (cause instanceof RuntimeException) {
                            throw ((RuntimeException) cause);
                        }
                        if (!(cause instanceof Error)) {
                            throw new RuntimeException(cause);
                        }
                        throw ((Error) cause);
                    }
                    handlerB = handler;
                    break;
                } else {
                    handlerB = eu.b(mainLooper);
                }
                this.h = handlerB;
                return;
            case 16:
                this.h = null;
                return;
            case 17:
                this.h = new ow1(21);
                return;
            case 19:
                this.h = new HashMap();
                new HashMap();
                return;
            case zzbbc.zzt.zzm /* 21 */:
                this.h = new iu0(500L);
                return;
            case 29:
                this.h = ByteBuffer.allocate(4);
                return;
            default:
                return;
        }
    }

    private final void k() {
    }

    private final void n() {
    }

    private final void o() {
    }

    @Override // defpackage.xj0
    public void l() {
    }

    private final void p(Throwable th) {
    }

    private final void r(Throwable th) {
    }

    public ow1(Uri uri, ClipDescription clipDescription, Uri uri2) {
        this.g = 18;
        if (Build.VERSION.SDK_INT >= 25) {
            this.h = new sf0(uri, clipDescription, uri2);
        } else {
            this.h = new wb2(uri, clipDescription, uri2, 18);
        }
    }
}
