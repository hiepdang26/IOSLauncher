package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.util.Pair;
import android.view.View;
import android.widget.EditText;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;
import com.bumptech.glide.a;
import com.google.android.gms.internal.ads.zzbbc;
import com.google.gson.Gson;
import com.luutinhit.launcher6.Folder;
import com.luutinhit.launcher6.FolderIcon;
import com.luutinhit.launcher6.leftpage.widgets.PhotoWidget_2x2;
import com.luutinhit.launcher6.widget.widgetprovider.service.WeatherUpdateWorker;
import com.luutinhit.weather.model.openweathermodel.DailyResponse;
import com.luutinhit.weather.model.openweathermodel.Hourly;
import com.luutinhit.weather.model.openweathermodel.HourlyResponse;
import com.luutinhit.weather.model.visualcrossing.VisualCrossingWeatherResponse;
import com.luutinhit.weather.network.visualcrossing.VisualCrossingWeather;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
public final class q11 implements my0, jl0, wr0, bs, ny0, hw1, c02, py0 {
    public static boolean j = false;
    public static q11 k;
    public final /* synthetic */ int g;
    public Object h;
    public Object i;

    public /* synthetic */ q11(int i, boolean z) {
        this.g = i;
    }

    public static synchronized q11 E(PackageManager packageManager) {
        try {
            if (!j) {
                Pair pairM = ar1.m(packageManager, "com.luutinhit.launcher6.action.PARTNER_CUSTOMIZATION");
                if (pairM != null) {
                    k = new q11((String) pairM.first, (Resources) pairM.second, 0);
                }
                j = true;
            }
        } catch (Throwable th) {
            throw th;
        }
        return k;
    }

    public void A(boolean z) {
        w50 w50Var = ((h60) this.i).r;
        if (w50Var != null) {
            w50Var.r().m.A(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.h).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void B(boolean z) {
        w50 w50Var = ((h60) this.i).r;
        if (w50Var != null) {
            w50Var.r().m.B(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.h).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public View C(int i, int i2, int i3, int i4) {
        bs1 bs1Var = (bs1) this.h;
        int iU = bs1Var.u();
        int iJ = bs1Var.j();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View viewT = bs1Var.t(i);
            int iM = bs1Var.m(viewT);
            int iW = bs1Var.w(viewT);
            as1 as1Var = (as1) this.i;
            as1Var.b = iU;
            as1Var.c = iJ;
            as1Var.d = iM;
            as1Var.e = iW;
            if (i3 != 0) {
                as1Var.a = i3;
                if (as1Var.a()) {
                    return viewT;
                }
            }
            if (i4 != 0) {
                as1Var.a = i4;
                if (as1Var.a()) {
                    view = viewT;
                }
            }
            i += i5;
        }
        return view;
    }

    public void D() {
        LinkedList linkedList = new LinkedList();
        synchronized (((LinkedList) this.h)) {
            linkedList.addAll((LinkedList) this.h);
            ((LinkedList) this.h).clear();
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }

    public synchronized ArrayList F(Class cls) {
        return ((qm0) this.h).f(cls);
    }

    public synchronized List G(String str) {
        List arrayList;
        if (!((ArrayList) this.h).contains(str)) {
            ((ArrayList) this.h).add(str);
        }
        arrayList = (List) ((HashMap) this.i).get(str);
        if (arrayList == null) {
            arrayList = new ArrayList();
            ((HashMap) this.i).put(str, arrayList);
        }
        return arrayList;
    }

    public synchronized ArrayList H(Class cls, Class cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        ArrayList arrayList2 = (ArrayList) this.h;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            List<jb1> list = (List) ((HashMap) this.i).get((String) obj);
            if (list != null) {
                for (jb1 jb1Var : list) {
                    if ((jb1Var.a.isAssignableFrom(cls) && cls2.isAssignableFrom(jb1Var.b)) && !arrayList.contains(jb1Var.b)) {
                        arrayList.add(jb1Var.b);
                    }
                }
            }
        }
        return arrayList;
    }

    public boolean I(View view) {
        bs1 bs1Var = (bs1) this.h;
        int iU = bs1Var.u();
        int iJ = bs1Var.j();
        int iM = bs1Var.m(view);
        int iW = bs1Var.w(view);
        as1 as1Var = (as1) this.i;
        as1Var.b = iU;
        as1Var.c = iJ;
        as1Var.d = iM;
        as1Var.e = iW;
        as1Var.a = 24579;
        return as1Var.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01b0 A[LOOP:0: B:3:0x000c->B:100:0x01b0, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01cc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public defpackage.uv J(defpackage.yi0 r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 515
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.q11.J(yi0):uv");
    }

    public void K(Runnable runnable) {
        synchronized (((LinkedList) this.h)) {
            ((LinkedList) this.h).add(runnable);
            if (((LinkedList) this.h).size() == 1) {
                LinkedList linkedList = (LinkedList) this.h;
                if (linkedList.size() > 0) {
                    ((iu) this.i).sendEmptyMessage(1);
                }
            }
        }
    }

    public void L(String str) {
        rv rvVar;
        synchronized (this) {
            try {
                Object obj = ((HashMap) this.h).get(str);
                n90.h(obj, "Argument must not be null");
                rvVar = (rv) obj;
                int i = rvVar.b;
                if (i < 1) {
                    throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + rvVar.b);
                }
                int i2 = i - 1;
                rvVar.b = i2;
                if (i2 == 0) {
                    rv rvVar2 = (rv) ((HashMap) this.h).remove(str);
                    if (!rvVar2.equals(rvVar)) {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + rvVar + ", but actually removed: " + rvVar2 + ", safeKey: " + str);
                    }
                    ((we) this.i).b(rvVar2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        rvVar.a.unlock();
    }

    public bj1 M(zy1 zy1Var) {
        bj1 bj1Var;
        synchronized (this.h) {
            bj1Var = (bj1) ((LinkedHashMap) this.i).remove(zy1Var);
        }
        return bj1Var;
    }

    public List N(String str) {
        List listA;
        qg0.l(str, "workSpecId");
        synchronized (this.h) {
            try {
                LinkedHashMap linkedHashMap = (LinkedHashMap) this.i;
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    if (qg0.d(((zy1) entry.getKey()).a, str)) {
                        linkedHashMap2.put(entry.getKey(), entry.getValue());
                    }
                }
                Iterator it = linkedHashMap2.keySet().iterator();
                while (it.hasNext()) {
                    ((LinkedHashMap) this.i).remove((zy1) it.next());
                }
                listA = wj.A(linkedHashMap2.values());
            } catch (Throwable th) {
                throw th;
            }
        }
        return listA;
    }

    public void O(int i, int i2, int i3, int i4) {
        CardView cardView = (CardView) this.i;
        cardView.j.set(i, i2, i3, i4);
        Rect rect = cardView.i;
        super/*android.widget.FrameLayout*/.setPadding(i + rect.left, i2 + rect.top, i3 + rect.right, i4 + rect.bottom);
    }

    public void P(bj1 bj1Var, int i) {
        qg0.l(bj1Var, "workSpecId");
        ((qm0) ((rm1) this.i)).e(new qj1((s31) this.h, bj1Var, false, i));
    }

    public bj1 Q(zy1 zy1Var) {
        bj1 bj1Var;
        synchronized (this.h) {
            try {
                LinkedHashMap linkedHashMap = (LinkedHashMap) this.i;
                Object bj1Var2 = linkedHashMap.get(zy1Var);
                if (bj1Var2 == null) {
                    bj1Var2 = new bj1(zy1Var);
                    linkedHashMap.put(zy1Var, bj1Var2);
                }
                bj1Var = (bj1) bj1Var2;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bj1Var;
    }

    @Override // defpackage.wr0
    public void a(Object obj) {
        int i = 1;
        int i2 = 0;
        Uri uri = (Uri) obj;
        Context context = (Context) this.h;
        PhotoWidget_2x2 photoWidget_2x2 = (PhotoWidget_2x2) this.i;
        if (uri != null) {
            try {
                uri.toString();
                ((na1) ((na1) a.f(photoWidget_2x2.l).q(uri).V(fx.b(268)).C(new dh(), new sc1(context.getResources().getDimensionPixelSize(e51.widget_round_corner)))).h(l51.sample_photo_widget)).L(photoWidget_2x2.l);
                photoWidget_2x2.postOnAnimationDelayed(new z11(this, i2), 268L);
            } catch (Throwable th) {
                th.getMessage();
                ((na1) ((na1) a.f(photoWidget_2x2.l).r(Integer.valueOf(l51.sample_photo_widget)).V(fx.b(268)).C(new dh(), new sc1(context.getResources().getDimensionPixelSize(e51.widget_round_corner)))).h(l51.sample_photo_widget)).L(photoWidget_2x2.l);
                photoWidget_2x2.postOnAnimationDelayed(new z11(this, i), 268L);
            }
        }
    }

    public void b() {
        synchronized (((LinkedList) this.h)) {
            ((LinkedList) this.h).clear();
        }
    }

    @Override // defpackage.wr0
    public void c(cw cwVar) {
        ((PhotoWidget_2x2) this.i).n = cwVar;
    }

    @Override // defpackage.wr0
    public void d() {
        PhotoWidget_2x2 photoWidget_2x2 = (PhotoWidget_2x2) this.i;
        try {
            ((na1) ((na1) a.f(photoWidget_2x2.l).r(Integer.valueOf(l51.sample_photo_widget)).V(fx.b(268)).C(new dh(), new sc1(((Context) this.h).getResources().getDimensionPixelSize(e51.widget_round_corner)))).h(l51.sample_photo_widget)).L(photoWidget_2x2.l);
            photoWidget_2x2.postOnAnimationDelayed(new z11(this, 3), 268L);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // defpackage.bs
    public void e(Exception exc) {
        gi1 gi1Var = (gi1) this.i;
        ku0 ku0Var = (ku0) this.h;
        ku0 ku0Var2 = gi1Var.l;
        if (ku0Var2 == null || ku0Var2 != ku0Var) {
            return;
        }
        gi1 gi1Var2 = (gi1) this.i;
        ku0 ku0Var3 = (ku0) this.h;
        ss ssVar = gi1Var2.h;
        as asVar = gi1Var2.m;
        cs csVar = ku0Var3.c;
        ssVar.a(asVar, exc, csVar, csVar.d());
    }

    @Override // defpackage.jl0
    public boolean f(w40 w40Var, qh0 qh0Var, ComponentName componentName) {
        jq1 jq1Var = qh0Var.w;
        ComponentName componentName2 = (ComponentName) this.h;
        return jq1Var == null ? componentName.equals(componentName2) : componentName.equals(componentName2) && qh0Var.w.equals((jq1) this.i);
    }

    @Override // defpackage.bs
    public void g(Object obj) {
        gi1 gi1Var = (gi1) this.i;
        ku0 ku0Var = (ku0) this.h;
        ku0 ku0Var2 = gi1Var.l;
        if (ku0Var2 == null || ku0Var2 != ku0Var) {
            return;
        }
        gi1 gi1Var2 = (gi1) this.i;
        ku0 ku0Var3 = (ku0) this.h;
        qv qvVar = gi1Var2.g.p;
        if (obj != null && qvVar.a(ku0Var3.c.d())) {
            gi1Var2.k = obj;
            gi1Var2.h.n(2);
        } else {
            ss ssVar = gi1Var2.h;
            bj0 bj0Var = ku0Var3.a;
            cs csVar = ku0Var3.c;
            ssVar.c(bj0Var, obj, csVar, csVar.d(), gi1Var2.m);
        }
    }

    @Override // defpackage.c02
    public boolean h(qh0 qh0Var, View view, FolderIcon folderIcon) {
        if (!((c02) this.h).h(qh0Var, view, folderIcon)) {
            return false;
        }
        ((View[]) this.i)[0] = view;
        return true;
    }

    @Override // defpackage.hw1
    public void i(HourlyResponse hourlyResponse) {
        CountDownLatch countDownLatch = (CountDownLatch) this.h;
        if (hourlyResponse != null) {
            try {
                List<Hourly> list = hourlyResponse.getList();
                if (list != null && !list.isEmpty()) {
                    WeatherUpdateWorker.a((WeatherUpdateWorker) this.i, list);
                }
            } catch (Exception e) {
                e.getMessage();
            } finally {
                countDownLatch.countDown();
            }
        }
    }

    public boolean j(zy1 zy1Var) {
        boolean zContainsKey;
        synchronized (this.h) {
            zContainsKey = ((LinkedHashMap) this.i).containsKey(zy1Var);
        }
        return zContainsKey;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00ed A[Catch: all -> 0x001b, Exception -> 0x001e, TRY_LEAVE, TryCatch #0 {Exception -> 0x001e, blocks: (B:5:0x000c, B:7:0x0010, B:9:0x0016, B:14:0x0021, B:15:0x00ed), top: B:23:0x000c, outer: #1 }] */
    @Override // defpackage.hw1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void k(java.lang.String r7, com.luutinhit.weather.model.openweathermodel.CurrentResponse r8, java.lang.Throwable r9) {
        /*
            Method dump skipped, instruction units count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.q11.k(java.lang.String, com.luutinhit.weather.model.openweathermodel.CurrentResponse, java.lang.Throwable):void");
    }

    public void l(boolean z) {
        w50 w50Var = ((h60) this.i).r;
        if (w50Var != null) {
            w50Var.r().m.l(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.h).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    @Override // defpackage.ny0
    public ly1 n(View view, ly1 ly1Var) {
        ly1 ly1VarK = qs1.k(view, ly1Var);
        if (ly1VarK.a.m()) {
            return ly1VarK;
        }
        int iB = ly1VarK.b();
        Rect rect = (Rect) this.h;
        rect.left = iB;
        rect.top = ly1VarK.d();
        rect.right = ly1VarK.c();
        rect.bottom = ly1VarK.a();
        ViewPager viewPager = (ViewPager) this.i;
        int childCount = viewPager.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ly1 ly1VarB = qs1.b(viewPager.getChildAt(i), ly1VarK);
            rect.left = Math.min(ly1VarB.b(), rect.left);
            rect.top = Math.min(ly1VarB.d(), rect.top);
            rect.right = Math.min(ly1VarB.c(), rect.right);
            rect.bottom = Math.min(ly1VarB.a(), rect.bottom);
        }
        return ly1VarK.f(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void o(boolean z) {
        h60 h60Var = (h60) this.i;
        e6 e6Var = h60Var.p.C;
        w50 w50Var = h60Var.r;
        if (w50Var != null) {
            w50Var.r().m.o(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.h).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    @Override // defpackage.py0
    public void onComplete(pm1 pm1Var) {
        ((Map) ((oz1) this.i).i).remove((qm1) this.h);
    }

    @Override // defpackage.wr0
    public void onError(Throwable th) {
        int i = 2;
        switch (this.g) {
            case 17:
                PhotoWidget_2x2 photoWidget_2x2 = (PhotoWidget_2x2) this.i;
                th.getMessage();
                try {
                    ((na1) ((na1) a.f(photoWidget_2x2.l).r(Integer.valueOf(l51.sample_photo_widget)).V(fx.b(268)).C(new dh(), new sc1(((Context) this.h).getResources().getDimensionPixelSize(e51.widget_round_corner)))).h(l51.sample_photo_widget)).L(photoWidget_2x2.l);
                    photoWidget_2x2.postOnAnimationDelayed(new z11(this, i), 268L);
                } catch (Throwable th2) {
                    th2.getMessage();
                    return;
                }
                break;
            default:
                th.getMessage();
                VisualCrossingWeather visualCrossingWeather = (VisualCrossingWeather) this.i;
                if (visualCrossingWeather.isFilePresent(visualCrossingWeather.mContext, "current_visual_crossing_weather.json")) {
                    ((fw1) visualCrossingWeather.mWeatherInfoResult).V((String) this.h, (VisualCrossingWeatherResponse) new Gson().fromJson(VisualCrossingWeather.read(visualCrossingWeather.mContext, "current_visual_crossing_weather.json"), VisualCrossingWeatherResponse.class), null);
                }
                break;
        }
    }

    @Override // defpackage.my0
    public void p(g3 g3Var) {
        Folder folder = (Folder) this.i;
        int i = folder.a0;
        if (i == 0) {
            folder.r.V();
            folder.W = -1;
        } else {
            if (i != 1) {
                return;
            }
            folder.r.W();
            folder.W = -1;
        }
        folder.a0 = -1;
        oz1 oz1Var = new oz1(folder, (nx) this.h);
        g3 g3Var2 = folder.j;
        g3Var2.j = oz1Var;
        g3Var2.b(900L);
    }

    public void q(boolean z) {
        w50 w50Var = ((h60) this.i).r;
        if (w50Var != null) {
            w50Var.r().m.q(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.h).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void r(boolean z) {
        w50 w50Var = ((h60) this.i).r;
        if (w50Var != null) {
            w50Var.r().m.r(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.h).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void s(boolean z) {
        w50 w50Var = ((h60) this.i).r;
        if (w50Var != null) {
            w50Var.r().m.s(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.h).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void t(boolean z) {
        w50 w50Var = ((h60) this.i).r;
        if (w50Var != null) {
            w50Var.r().m.t(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.h).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void u(boolean z) {
        h60 h60Var = (h60) this.i;
        e6 e6Var = h60Var.p.C;
        w50 w50Var = h60Var.r;
        if (w50Var != null) {
            w50Var.r().m.u(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.h).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void v(boolean z) {
        w50 w50Var = ((h60) this.i).r;
        if (w50Var != null) {
            w50Var.r().m.v(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.h).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void w(boolean z) {
        w50 w50Var = ((h60) this.i).r;
        if (w50Var != null) {
            w50Var.r().m.w(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.h).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void x(boolean z) {
        w50 w50Var = ((h60) this.i).r;
        if (w50Var != null) {
            w50Var.r().m.x(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.h).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void y(boolean z) {
        w50 w50Var = ((h60) this.i).r;
        if (w50Var != null) {
            w50Var.r().m.y(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.h).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void z(boolean z) {
        w50 w50Var = ((h60) this.i).r;
        if (w50Var != null) {
            w50Var.r().m.z(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.h).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public /* synthetic */ q11(Object obj, Object obj2, int i) {
        this.g = i;
        this.h = obj;
        this.i = obj2;
    }

    public /* synthetic */ q11(Object obj, Object obj2, int i, boolean z) {
        this.g = i;
        this.i = obj;
        this.h = obj2;
    }

    public q11(String str, n90 n90Var, jl1 jl1Var) {
        this.g = 3;
        this.h = str;
        this.i = n90Var;
    }

    public q11(Context context) {
        this.g = 2;
        iy g4Var = null;
        try {
            if (ar1.f) {
                g4Var = new h4(context);
            }
        } catch (Exception unused) {
        }
        if (g4Var == null) {
            try {
                g4Var = new g4(context);
            } catch (Exception unused2) {
            }
        }
        this.i = g4Var == null ? new iy() : g4Var;
        if (context.getResources().getConfiguration().locale.getLanguage().equals(Locale.JAPANESE.getLanguage())) {
            this.h = "他";
        } else {
            this.h = "∙";
        }
    }

    public q11(int i) {
        this.g = i;
        switch (i) {
            case 19:
                this.h = new ArrayList();
                this.i = new HashMap();
                break;
            case 20:
            default:
                this.h = new HashMap();
                this.i = new we(1);
                break;
            case zzbbc.zzt.zzm /* 21 */:
                this.h = new Object();
                this.i = new LinkedHashMap();
                break;
        }
    }

    public q11(wb2 wb2Var) {
        this.g = 15;
        qm0 qm0Var = new qm0(wb2Var);
        this.i = new fz1(22);
        this.h = qm0Var;
    }

    @Override // defpackage.hw1
    public void m(DailyResponse dailyResponse) {
    }

    public q11(h60 h60Var) {
        this.g = 11;
        this.h = new CopyOnWriteArrayList();
        this.i = h60Var;
    }

    public q11(s31 s31Var, rm1 rm1Var) {
        this.g = 26;
        qg0.l(s31Var, "processor");
        qg0.l(rm1Var, "workTaskExecutor");
        this.h = s31Var;
        this.i = rm1Var;
    }

    public q11(jl1 jl1Var) {
        this.g = 4;
        se seVar = new se();
        this.h = jl1Var;
        this.i = seVar;
    }

    public q11(bs1 bs1Var) {
        this.g = 22;
        this.h = bs1Var;
        as1 as1Var = new as1();
        as1Var.a = 0;
        this.i = as1Var;
    }

    public q11(ArrayList arrayList, ArrayList arrayList2) {
        this.g = 12;
        int size = arrayList.size();
        this.h = new int[size];
        this.i = new float[size];
        for (int i = 0; i < size; i++) {
            ((int[]) this.h)[i] = ((Integer) arrayList.get(i)).intValue();
            ((float[]) this.i)[i] = ((Float) arrayList2.get(i)).floatValue();
        }
    }

    public q11(int i, int i2) {
        this.g = 12;
        this.h = new int[]{i, i2};
        this.i = new float[]{0.0f, 1.0f};
    }

    public q11(EditText editText) {
        this.g = 1;
        this.h = editText;
        oz ozVar = new oz(editText);
        this.i = ozVar;
        editText.addTextChangedListener(ozVar);
        if (cz.b == null) {
            synchronized (cz.a) {
                try {
                    if (cz.b == null) {
                        cz czVar = new cz();
                        try {
                            cz.c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, cz.class.getClassLoader());
                        } catch (Throwable unused) {
                        }
                        cz.b = czVar;
                    }
                } finally {
                }
            }
        }
        editText.setEditableFactory(cz.b);
    }

    public q11(int i, int i2, int i3) {
        this.g = 12;
        this.h = new int[]{i, i2, i3};
        this.i = new float[]{0.0f, 0.5f, 1.0f};
    }

    public q11(ViewPager viewPager) {
        this.g = 23;
        this.i = viewPager;
        this.h = new Rect();
    }

    public q11(CardView cardView) {
        this.g = 6;
        this.i = cardView;
    }
}
