package defpackage;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ViewUtils;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.preference.Preference;
import androidx.recyclerview.widget.RecyclerView;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.material.internal.NavigationMenuView;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;
import com.luutinhit.launcher6.Folder;
import com.luutinhit.launcher6.ioslauncher.IOSLauncher;
import com.luutinhit.launcher6.leftpage.widgets.BatteryWidget;
import com.luutinhit.launcherios.MainActivity;
import com.luutinhit.launcherios.activity.AppsLibraryCategoryActivity;
import com.luutinhit.launcherios.activity.UtilitiesActivity;
import com.luutinhit.weather.model.openweathermodel.DailyResponse;
import com.luutinhit.weather.model.visualcrossing.VisualCrossingWeatherResponse;
import com.luutinhit.weather.network.OpenWeather;
import com.luutinhit.weather.network.visualcrossing.VisualCrossingWeather;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import org.chromium.support_lib_boundary.StaticsBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes.dex */
public final class nx0 implements ny0, wr0, mu0, k9, kr0, bt, my0, y40, b2, nd, l1, zz, dl1, Callback, yw1 {
    public final /* synthetic */ int g;
    public Object h;

    public /* synthetic */ nx0(Object obj, int i) {
        this.g = i;
        this.h = obj;
    }

    public static nx0 v(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        return new nx0(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z, z2), 1);
    }

    public void A(int i, boolean z, boolean z2) {
        if ((!z || z2) && (z || !z2)) {
            return;
        }
        MainActivity mainActivity = (MainActivity) this.h;
        float measuredHeight = (i / mainActivity.F.getMeasuredHeight()) + 1.0f;
        mainActivity.F.setScaleX(measuredHeight);
        mainActivity.F.setScaleY(measuredHeight);
    }

    @Override // defpackage.wr0
    public void a(Object obj) {
        switch (this.g) {
            case 4:
                Thread.currentThread().getName();
                AppsLibraryCategoryActivity appsLibraryCategoryActivity = (AppsLibraryCategoryActivity) this.h;
                sg sgVar = appsLibraryCategoryActivity.H;
                sgVar.k = (ArrayList) obj;
                sgVar.f();
                appsLibraryCategoryActivity.C.setVisibility(8);
                break;
            default:
                List list = (List) obj;
                Thread.currentThread().getName();
                q91 q91Var = ((BatteryWidget) this.h).n;
                if (q91Var != null) {
                    if (list == null || list.isEmpty()) {
                        List list2 = q91Var.j;
                        if (list2 != null) {
                            list2.clear();
                            q91Var.f();
                        }
                    } else {
                        q91Var.j = list;
                        q91Var.f();
                    }
                }
                break;
        }
    }

    @Override // defpackage.bt
    public long b(long j) throws IOException {
        if (j < 0) {
            return 0L;
        }
        long j2 = j;
        while (j2 > 0) {
            InputStream inputStream = (InputStream) this.h;
            long jSkip = inputStream.skip(j2);
            if (jSkip > 0) {
                j2 -= jSkip;
            } else {
                if (inputStream.read() == -1) {
                    break;
                }
                j2--;
            }
        }
        return j - j2;
    }

    @Override // defpackage.wr0
    public void c(cw cwVar) {
        switch (this.g) {
            case 4:
                ((AppsLibraryCategoryActivity) this.h).G = cwVar;
                break;
            default:
                ((BatteryWidget) this.h).p = cwVar;
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.y40
    public void close() throws Exception {
        ContentProviderClient contentProviderClient = (ContentProviderClient) this.h;
        if (contentProviderClient != 0) {
            if (contentProviderClient instanceof AutoCloseable) {
                contentProviderClient.close();
            } else if (contentProviderClient instanceof ExecutorService) {
                e.y((ExecutorService) contentProviderClient);
            } else {
                contentProviderClient.release();
            }
        }
    }

    @Override // defpackage.yw1
    public WebViewProviderBoundaryInterface createWebView(WebView webView) {
        return (WebViewProviderBoundaryInterface) wd.e(WebViewProviderBoundaryInterface.class, ((WebViewProviderFactoryBoundaryInterface) this.h).createWebView(webView));
    }

    @Override // defpackage.wr0
    public void d() {
        switch (this.g) {
            case 4:
                int i = w61.start_ios_launcher_firstly;
                AppsLibraryCategoryActivity appsLibraryCategoryActivity = (AppsLibraryCategoryActivity) this.h;
                Toast.makeText(appsLibraryCategoryActivity, i, 1).show();
                appsLibraryCategoryActivity.C.setVisibility(8);
                break;
        }
    }

    @Override // defpackage.dl1
    public void e(boolean z) {
        UtilitiesActivity utilitiesActivity = (UtilitiesActivity) this.h;
        UtilitiesActivity.A(utilitiesActivity, "dark_mode", z);
        ar1.z(utilitiesActivity);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:0|2|29|3|(5:38|4|(1:6)(1:40)|28|19)|10|36|11|12|28|19|(1:(0))) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v9 */
    @Override // defpackage.zz
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean f(java.lang.Object r5, java.io.File r6, defpackage.g01 r7) throws java.lang.Throwable {
        /*
            r4 = this;
            java.io.InputStream r5 = (java.io.InputStream) r5
            r7 = 65536(0x10000, float:9.1835E-41)
            java.lang.Class<byte[]> r0 = byte[].class
            java.lang.Object r1 = r4.h
            cq0 r1 = (defpackage.cq0) r1
            java.lang.Object r7 = r1.d(r7, r0)
            byte[] r7 = (byte[]) r7
            r0 = 0
            r2 = 0
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L34
            r3.<init>(r6)     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L34
        L17:
            int r6 = r5.read(r7)     // Catch: java.lang.Throwable -> L22 java.io.IOException -> L25
            r2 = -1
            if (r6 == r2) goto L27
            r3.write(r7, r0, r6)     // Catch: java.lang.Throwable -> L22 java.io.IOException -> L25
            goto L17
        L22:
            r5 = move-exception
            r2 = r3
            goto L43
        L25:
            r2 = r3
            goto L34
        L27:
            r3.close()     // Catch: java.lang.Throwable -> L22 java.io.IOException -> L25
            r3.close()     // Catch: java.io.IOException -> L2d
        L2d:
            r1.h(r7)
            r0 = 1
            goto L42
        L32:
            r5 = move-exception
            goto L43
        L34:
            java.lang.String r5 = "StreamEncoder"
            r6 = 3
            android.util.Log.isLoggable(r5, r6)     // Catch: java.lang.Throwable -> L32
            if (r2 == 0) goto L3f
            r2.close()     // Catch: java.io.IOException -> L3f
        L3f:
            r1.h(r7)
        L42:
            return r0
        L43:
            if (r2 == 0) goto L48
            r2.close()     // Catch: java.io.IOException -> L48
        L48:
            r1.h(r7)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.nx0.f(java.lang.Object, java.io.File, g01):boolean");
    }

    @Override // defpackage.y40
    public Cursor g(Uri uri, String[] strArr, String[] strArr2) {
        ContentProviderClient contentProviderClient = (ContentProviderClient) this.h;
        if (contentProviderClient == null) {
            return null;
        }
        try {
            return contentProviderClient.query(uri, strArr, "query = ?", strArr2, null, null);
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // defpackage.yw1
    public StaticsBoundaryInterface getStatics() {
        return (StaticsBoundaryInterface) wd.e(StaticsBoundaryInterface.class, ((WebViewProviderFactoryBoundaryInterface) this.h).getStatics());
    }

    @Override // defpackage.yw1
    public String[] h() {
        return ((WebViewProviderFactoryBoundaryInterface) this.h).getSupportedFeatures();
    }

    @Override // defpackage.b2
    public void i(Object obj) {
        a2 a2Var = (a2) obj;
        h60 h60Var = (h60) this.h;
        e60 e60Var = (e60) h60Var.y.pollFirst();
        if (e60Var == null) {
            return;
        }
        w50 w50VarR = h60Var.c.r(e60Var.g);
        if (w50VarR == null) {
            return;
        }
        w50VarR.w(e60Var.h, a2Var.g, a2Var.h);
    }

    @Override // defpackage.bt
    public short j() throws IOException {
        int i = ((InputStream) this.h).read();
        if (i != -1) {
            return (short) i;
        }
        throw new at();
    }

    @Override // defpackage.bt
    public int l() {
        return (j() << 8) | j();
    }

    @Override // defpackage.k9
    public cs m(AssetManager assetManager, String str) {
        return new x20(assetManager, str, 0);
    }

    @Override // defpackage.ny0
    public ly1 n(View view, ly1 ly1Var) {
        boolean z;
        boolean z2;
        boolean z3;
        ly1 ly1VarF = ly1Var;
        switch (this.g) {
            case 3:
                int iD = ly1VarF.d();
                q6 q6Var = (q6) this.h;
                q6Var.getClass();
                int iD2 = ly1VarF.d();
                ActionBarContextView actionBarContextView = q6Var.u;
                if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                    z = false;
                } else {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) q6Var.u.getLayoutParams();
                    if (q6Var.u.isShown()) {
                        if (q6Var.b0 == null) {
                            q6Var.b0 = new Rect();
                            q6Var.c0 = new Rect();
                        }
                        Rect rect = q6Var.b0;
                        Rect rect2 = q6Var.c0;
                        rect.set(ly1VarF.b(), ly1VarF.d(), ly1VarF.c(), ly1VarF.a());
                        ViewUtils.computeFitSystemWindows(q6Var.z, rect, rect2);
                        int i = rect.top;
                        int i2 = rect.left;
                        int i3 = rect.right;
                        ViewGroup viewGroup = q6Var.z;
                        WeakHashMap weakHashMap = qs1.a;
                        ly1 ly1VarA = Build.VERSION.SDK_INT >= 23 ? is1.a(viewGroup) : hs1.f(viewGroup);
                        int iB = ly1VarA == null ? 0 : ly1VarA.b();
                        int iC = ly1VarA == null ? 0 : ly1VarA.c();
                        if (marginLayoutParams.topMargin == i && marginLayoutParams.leftMargin == i2 && marginLayoutParams.rightMargin == i3) {
                            z3 = false;
                        } else {
                            marginLayoutParams.topMargin = i;
                            marginLayoutParams.leftMargin = i2;
                            marginLayoutParams.rightMargin = i3;
                            z3 = true;
                        }
                        Context context = q6Var.j;
                        if (i <= 0 || q6Var.B != null) {
                            View view2 = q6Var.B;
                            if (view2 != null) {
                                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
                                int i4 = marginLayoutParams2.height;
                                int i5 = marginLayoutParams.topMargin;
                                if (i4 != i5 || marginLayoutParams2.leftMargin != iB || marginLayoutParams2.rightMargin != iC) {
                                    marginLayoutParams2.height = i5;
                                    marginLayoutParams2.leftMargin = iB;
                                    marginLayoutParams2.rightMargin = iC;
                                    q6Var.B.setLayoutParams(marginLayoutParams2);
                                }
                            }
                        } else {
                            View view3 = new View(context);
                            q6Var.B = view3;
                            view3.setVisibility(8);
                            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                            layoutParams.leftMargin = iB;
                            layoutParams.rightMargin = iC;
                            q6Var.z.addView(q6Var.B, -1, layoutParams);
                        }
                        View view4 = q6Var.B;
                        z = view4 != null;
                        if (z && view4.getVisibility() != 0) {
                            View view5 = q6Var.B;
                            view5.setBackgroundColor((view5.getWindowSystemUiVisibility() & 8192) != 0 ? np1.k(context, y41.abc_decor_view_status_guard_light) : np1.k(context, y41.abc_decor_view_status_guard));
                        }
                        if (!q6Var.G && z) {
                            iD2 = 0;
                        }
                        z2 = z3;
                    } else {
                        if (marginLayoutParams.topMargin != 0) {
                            marginLayoutParams.topMargin = 0;
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        z = false;
                    }
                    if (z2) {
                        q6Var.u.setLayoutParams(marginLayoutParams);
                    }
                }
                View view6 = q6Var.B;
                if (view6 != null) {
                    view6.setVisibility(z ? 0 : 8);
                }
                if (iD != iD2) {
                    ly1VarF = ly1VarF.f(ly1VarF.b(), iD2, ly1VarF.c(), ly1VarF.a());
                }
                return qs1.k(view, ly1VarF);
            case 9:
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.h;
                if (!Objects.equals(coordinatorLayout.t, ly1VarF)) {
                    coordinatorLayout.t = ly1VarF;
                    boolean z4 = ly1VarF.d() > 0;
                    coordinatorLayout.u = z4;
                    coordinatorLayout.setWillNotDraw(!z4 && coordinatorLayout.getBackground() == null);
                    iy1 iy1Var = ly1VarF.a;
                    if (!iy1Var.m()) {
                        int childCount = coordinatorLayout.getChildCount();
                        for (int i6 = 0; i6 < childCount; i6++) {
                            View childAt = coordinatorLayout.getChildAt(i6);
                            WeakHashMap weakHashMap2 = qs1.a;
                            if (!childAt.getFitsSystemWindows() || ((po) childAt.getLayoutParams()).a == null || !iy1Var.m()) {
                            }
                        }
                    }
                    coordinatorLayout.requestLayout();
                }
                return ly1VarF;
            default:
                NavigationView navigationView = (NavigationView) this.h;
                if (navigationView.h == null) {
                    navigationView.h = new Rect();
                }
                navigationView.h.set(ly1VarF.b(), ly1VarF.d(), ly1VarF.c(), ly1VarF.a());
                ow0 ow0Var = navigationView.m;
                ow0Var.getClass();
                int iD3 = ly1VarF.d();
                if (ow0Var.D != iD3) {
                    ow0Var.D = iD3;
                    int i7 = (ow0Var.h.getChildCount() == 0 && ow0Var.B) ? ow0Var.D : 0;
                    NavigationMenuView navigationMenuView = ow0Var.g;
                    navigationMenuView.setPadding(0, i7, 0, navigationMenuView.getPaddingBottom());
                }
                NavigationMenuView navigationMenuView2 = ow0Var.g;
                navigationMenuView2.setPadding(0, navigationMenuView2.getPaddingTop(), 0, ly1VarF.a());
                qs1.b(ow0Var.h, ly1VarF);
                iy1 iy1Var2 = ly1VarF.a;
                navigationView.setWillNotDraw(iy1Var2.j().equals(eg0.e) || navigationView.g == null);
                navigationView.postInvalidateOnAnimation();
                return iy1Var2.c();
        }
    }

    @Override // defpackage.bt
    public int o(int i, byte[] bArr) throws at {
        int i2 = 0;
        int i3 = 0;
        while (i2 < i && (i3 = ((InputStream) this.h).read(bArr, i2, i - i2)) != -1) {
            i2 += i3;
        }
        if (i2 == 0 && i3 == -1) {
            throw new at();
        }
        return i2;
    }

    @Override // defpackage.wr0
    public void onError(Throwable th) {
        switch (this.g) {
            case 4:
                int i = AppsLibraryCategoryActivity.J;
                AppsLibraryCategoryActivity appsLibraryCategoryActivity = (AppsLibraryCategoryActivity) this.h;
                appsLibraryCategoryActivity.getClass();
                Intent intent = new Intent(appsLibraryCategoryActivity, (Class<?>) IOSLauncher.class);
                intent.addCategory("android.intent.category.HOME");
                appsLibraryCategoryActivity.startActivity(intent);
                Toast.makeText(appsLibraryCategoryActivity, w61.start_ios_launcher_firstly, 1).show();
                appsLibraryCategoryActivity.finish();
                break;
        }
    }

    @Override // retrofit2.Callback
    public void onFailure(Call call, Throwable th) {
        switch (this.g) {
            case 27:
                th.getMessage();
                ((av1) this.h).a.onError(th);
                break;
            default:
                th.getMessage();
                ((jw1) this.h).c.a(th);
                break;
        }
    }

    @Override // retrofit2.Callback
    public void onResponse(Call call, Response response) {
        switch (this.g) {
            case 27:
                Objects.toString(response);
                boolean zIsSuccessful = response.isSuccessful();
                av1 av1Var = (av1) this.h;
                if (!zIsSuccessful) {
                    av1Var.a.onError(new Throwable(response.message()));
                    break;
                } else {
                    VisualCrossingWeatherResponse visualCrossingWeatherResponse = (VisualCrossingWeatherResponse) response.body();
                    q11 q11Var = av1Var.a;
                    Objects.toString(visualCrossingWeatherResponse);
                    if (visualCrossingWeatherResponse != null && visualCrossingWeatherResponse.days != null && visualCrossingWeatherResponse.currentConditions != null) {
                        String json = new Gson().toJson(visualCrossingWeatherResponse);
                        VisualCrossingWeather visualCrossingWeather = (VisualCrossingWeather) q11Var.i;
                        ((fw1) visualCrossingWeather.mWeatherInfoResult).V((String) q11Var.h, visualCrossingWeatherResponse, null);
                        visualCrossingWeather.write(visualCrossingWeather.mContext, "current_visual_crossing_weather.json", json);
                        break;
                    }
                }
                break;
            default:
                Objects.toString(response);
                boolean zIsSuccessful2 = response.isSuccessful();
                jw1 jw1Var = (jw1) this.h;
                if (!zIsSuccessful2) {
                    jw1Var.c.a(new Throwable(response.message()));
                    break;
                } else {
                    DailyResponse dailyResponse = (DailyResponse) response.body();
                    vz0 vz0Var = jw1Var.c;
                    vz0Var.getClass();
                    Objects.toString(dailyResponse);
                    if (dailyResponse != null && dailyResponse.getList() != null) {
                        String json2 = new Gson().toJson(dailyResponse);
                        new Handler(Looper.getMainLooper()).post(new wz0(vz0Var, vz0Var.b, dailyResponse, 1));
                        OpenWeather openWeather = vz0Var.d;
                        openWeather.write(openWeather.mContext, vz0Var.c, json2);
                        break;
                    }
                }
                break;
        }
    }

    @Override // defpackage.my0
    public void p(g3 g3Var) {
        ((Folder) this.h).A();
    }

    public void q(Bundle bundle) {
        c92 c92Var = (c92) this.h;
        c92Var.getClass();
        c92Var.b.putBundle(AdMobAdapter.class.getName(), bundle);
        if (AdMobAdapter.class.equals(AdMobAdapter.class) && bundle.getBoolean("_emulatorLiveAds")) {
            c92Var.d.remove("B3EEABB8EE11C2BE770B684D95219ECB");
        }
    }

    public void r(x2 x2Var) {
        int i = x2Var.a;
        RecyclerView recyclerView = (RecyclerView) this.h;
        if (i == 1) {
            recyclerView.t.Z(x2Var.b, x2Var.d);
            return;
        }
        if (i == 2) {
            recyclerView.t.c0(x2Var.b, x2Var.d);
        } else if (i == 4) {
            recyclerView.t.d0(x2Var.b, x2Var.d);
        } else {
            if (i != 8) {
                return;
            }
            recyclerView.t.b0(x2Var.b, x2Var.d);
        }
    }

    @Override // defpackage.mu0
    public lu0 s(qm0 qm0Var) {
        return new l9((AssetManager) this.h, this, 0);
    }

    public m91 t(int i) {
        RecyclerView recyclerView = (RecyclerView) this.h;
        int iK = recyclerView.l.k();
        int i2 = 0;
        m91 m91Var = null;
        while (true) {
            if (i2 >= iK) {
                break;
            }
            m91 m91VarQ = RecyclerView.Q(recyclerView.l.j(i2));
            if (m91VarQ != null && !m91VarQ.m() && m91VarQ.i == i) {
                if (!((ArrayList) recyclerView.l.e).contains(m91VarQ.g)) {
                    m91Var = m91VarQ;
                    break;
                }
                m91Var = m91VarQ;
            }
            i2++;
        }
        if (m91Var == null) {
            return null;
        }
        if (!((ArrayList) recyclerView.l.e).contains(m91Var.g)) {
            return m91Var;
        }
        boolean z = RecyclerView.G0;
        return null;
    }

    public void u(int i, int i2, Preference preference) {
        int i3;
        int i4;
        RecyclerView recyclerView = (RecyclerView) this.h;
        int iK = recyclerView.l.k();
        int i5 = i2 + i;
        for (int i6 = 0; i6 < iK; i6++) {
            View viewJ = recyclerView.l.j(i6);
            m91 m91VarQ = RecyclerView.Q(viewJ);
            if (m91VarQ != null && !m91VarQ.t() && (i4 = m91VarQ.i) >= i && i4 < i5) {
                m91VarQ.c(2);
                if (preference == null) {
                    m91VarQ.c(1024);
                } else if ((1024 & m91VarQ.p) == 0) {
                    if (m91VarQ.q == null) {
                        ArrayList arrayList = new ArrayList();
                        m91VarQ.q = arrayList;
                        m91VarQ.r = Collections.unmodifiableList(arrayList);
                    }
                    m91VarQ.q.add(preference);
                }
                ((v81) viewJ.getLayoutParams()).c = true;
            }
        }
        c91 c91Var = recyclerView.i;
        ArrayList arrayList2 = c91Var.c;
        for (int size = arrayList2.size() - 1; size >= 0; size--) {
            m91 m91Var = (m91) arrayList2.get(size);
            if (m91Var != null && (i3 = m91Var.i) >= i && i3 < i5) {
                m91Var.c(2);
                c91Var.g(size);
            }
        }
        recyclerView.r0 = true;
    }

    public void w(int i, int i2) {
        RecyclerView recyclerView = (RecyclerView) this.h;
        int iK = recyclerView.l.k();
        for (int i3 = 0; i3 < iK; i3++) {
            m91 m91VarQ = RecyclerView.Q(recyclerView.l.j(i3));
            if (m91VarQ != null && !m91VarQ.t() && m91VarQ.i >= i) {
                if (RecyclerView.H0) {
                    m91VarQ.toString();
                }
                m91VarQ.q(i2, false);
                recyclerView.n0.f = true;
            }
        }
        ArrayList arrayList = recyclerView.i.c;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            m91 m91Var = (m91) arrayList.get(i4);
            if (m91Var != null && m91Var.i >= i) {
                if (RecyclerView.H0) {
                    m91Var.toString();
                }
                m91Var.q(i2, false);
            }
        }
        recyclerView.requestLayout();
        recyclerView.q0 = true;
    }

    public void x(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        RecyclerView recyclerView = (RecyclerView) this.h;
        int iK = recyclerView.l.k();
        int i10 = -1;
        if (i < i2) {
            i4 = i;
            i3 = i2;
            i5 = -1;
        } else {
            i3 = i;
            i4 = i2;
            i5 = 1;
        }
        for (int i11 = 0; i11 < iK; i11++) {
            m91 m91VarQ = RecyclerView.Q(recyclerView.l.j(i11));
            if (m91VarQ != null && (i9 = m91VarQ.i) >= i4 && i9 <= i3) {
                if (RecyclerView.H0) {
                    m91VarQ.toString();
                }
                if (m91VarQ.i == i) {
                    m91VarQ.q(i2 - i, false);
                } else {
                    m91VarQ.q(i5, false);
                }
                recyclerView.n0.f = true;
            }
        }
        c91 c91Var = recyclerView.i;
        c91Var.getClass();
        if (i < i2) {
            i7 = i;
            i6 = i2;
        } else {
            i6 = i;
            i7 = i2;
            i10 = 1;
        }
        ArrayList arrayList = c91Var.c;
        int size = arrayList.size();
        for (int i12 = 0; i12 < size; i12++) {
            m91 m91Var = (m91) arrayList.get(i12);
            if (m91Var != null && (i8 = m91Var.i) >= i7 && i8 <= i6) {
                if (i8 == i) {
                    m91Var.q(i2 - i, false);
                } else {
                    m91Var.q(i10, false);
                }
                if (RecyclerView.H0) {
                    m91Var.toString();
                }
            }
        }
        recyclerView.requestLayout();
        recyclerView.q0 = true;
    }

    public nx0(int i) {
        this.g = i;
        switch (i) {
            case 25:
                break;
            default:
                c92 c92Var = new c92();
                this.h = c92Var;
                c92Var.d.add("B3EEABB8EE11C2BE770B684D95219ECB");
                break;
        }
    }

    public nx0(mc1 mc1Var) {
        this.g = 16;
        this.h = Collections.unmodifiableMap(new HashMap((HashMap) mc1Var.h));
    }

    public nx0(Context context) {
        this.g = 17;
        this.h = new wb(context, 2);
    }

    public nx0(Uri uri, Context context) {
        this.g = 14;
        this.h = context.getContentResolver().acquireUnstableContentProviderClient(uri);
    }

    private final void y() {
    }

    private final void z(Throwable th) {
    }
}
