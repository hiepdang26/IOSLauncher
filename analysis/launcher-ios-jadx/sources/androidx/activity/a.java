package androidx.activity;

import android.app.Application;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Trace;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.SavedStateHandleAttacher;
import defpackage.al;
import defpackage.an0;
import defpackage.b21;
import defpackage.bl;
import defpackage.c61;
import defpackage.cd1;
import defpackage.cl;
import defpackage.ct1;
import defpackage.d61;
import defpackage.da1;
import defpackage.dt1;
import defpackage.e6;
import defpackage.en0;
import defpackage.f50;
import defpackage.f61;
import defpackage.fa1;
import defpackage.fb;
import defpackage.hb0;
import defpackage.hh1;
import defpackage.jd1;
import defpackage.jv0;
import defpackage.ka0;
import defpackage.lt0;
import defpackage.m90;
import defpackage.md1;
import defpackage.mp;
import defpackage.nd1;
import defpackage.o1;
import defpackage.od1;
import defpackage.p51;
import defpackage.qg0;
import defpackage.r1;
import defpackage.ry0;
import defpackage.um0;
import defpackage.uo;
import defpackage.vm0;
import defpackage.z71;
import defpackage.zn;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends cl implements dt1, hb0, od1 {
    public final zn h = new zn();
    public final lt0 i;
    public final androidx.lifecycle.a j;
    public final hh1 k;
    public ct1 l;
    public final b m;
    public final AtomicInteger n;
    public final al o;
    public final CopyOnWriteArrayList p;
    public final CopyOnWriteArrayList q;
    public final CopyOnWriteArrayList r;
    public final CopyOnWriteArrayList s;
    public final CopyOnWriteArrayList t;

    public a() {
        md1 md1Var;
        final e6 e6Var = (e6) this;
        this.i = new lt0(new r1(e6Var, 5));
        androidx.lifecycle.a aVar = new androidx.lifecycle.a(this);
        this.j = aVar;
        hh1 hh1Var = new hh1((od1) this);
        this.k = hh1Var;
        this.m = new b(new o1(e6Var, 13));
        this.n = new AtomicInteger();
        this.o = new al(e6Var);
        this.p = new CopyOnWriteArrayList();
        this.q = new CopyOnWriteArrayList();
        this.r = new CopyOnWriteArrayList();
        this.s = new CopyOnWriteArrayList();
        this.t = new CopyOnWriteArrayList();
        aVar.a(new an0() { // from class: androidx.activity.ComponentActivity$3
            @Override // defpackage.an0
            public final void a(en0 en0Var, um0 um0Var) {
                if (um0Var == um0.ON_STOP) {
                    Window window = e6Var.getWindow();
                    View viewPeekDecorView = window != null ? window.peekDecorView() : null;
                    if (viewPeekDecorView != null) {
                        viewPeekDecorView.cancelPendingInputEvents();
                    }
                }
            }
        });
        aVar.a(new an0() { // from class: androidx.activity.ComponentActivity$4
            @Override // defpackage.an0
            public final void a(en0 en0Var, um0 um0Var) {
                if (um0Var == um0.ON_DESTROY) {
                    e6Var.h.h = null;
                    if (e6Var.isChangingConfigurations()) {
                        return;
                    }
                    e6Var.j().a();
                }
            }
        });
        aVar.a(new an0() { // from class: androidx.activity.ComponentActivity$5
            @Override // defpackage.an0
            public final void a(en0 en0Var, um0 um0Var) {
                e6 e6Var2 = e6Var;
                if (e6Var2.l == null) {
                    bl blVar = (bl) e6Var2.getLastNonConfigurationInstance();
                    if (blVar != null) {
                        e6Var2.l = blVar.a;
                    }
                    if (e6Var2.l == null) {
                        e6Var2.l = new ct1();
                    }
                }
                e6Var2.j.f(this);
            }
        });
        hh1Var.c();
        vm0 vm0Var = aVar.c;
        if (vm0Var != vm0.h && vm0Var != vm0.i) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        nd1 nd1Var = (nd1) hh1Var.b;
        nd1Var.getClass();
        Iterator it = nd1Var.a.iterator();
        while (true) {
            cd1 cd1Var = (cd1) it;
            if (!cd1Var.hasNext()) {
                md1Var = null;
                break;
            }
            Map.Entry entry = (Map.Entry) cd1Var.next();
            qg0.k(entry, "components");
            String str = (String) entry.getKey();
            md1Var = (md1) entry.getValue();
            if (qg0.d(str, "androidx.lifecycle.internal.SavedStateHandlesProvider")) {
                break;
            }
        }
        if (md1Var == null) {
            jd1 jd1Var = new jd1((nd1) this.k.b, this);
            ((nd1) this.k.b).b("androidx.lifecycle.internal.SavedStateHandlesProvider", jd1Var);
            this.j.a(new SavedStateHandleAttacher(jd1Var));
        }
        if (Build.VERSION.SDK_INT <= 23) {
            androidx.lifecycle.a aVar2 = this.j;
            ImmLeaksCleaner immLeaksCleaner = new ImmLeaksCleaner();
            immLeaksCleaner.g = this;
            aVar2.a(immLeaksCleaner);
        }
        ((nd1) this.k.b).b("android:support:activity-result", new md1() { // from class: yk
            @Override // defpackage.md1
            public final Bundle a() {
                e6 e6Var2 = e6Var;
                Bundle bundle = new Bundle();
                al alVar = e6Var2.o;
                alVar.getClass();
                HashMap map = alVar.c;
                bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(map.values()));
                bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(map.keySet()));
                bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(alVar.e));
                bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) alVar.h.clone());
                bundle.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", alVar.a);
                return bundle;
            }
        });
        m(new ry0() { // from class: zk
            @Override // defpackage.ry0
            public final void a() {
                e6 e6Var2 = e6Var;
                Bundle bundleA = ((nd1) e6Var2.k.b).a("android:support:activity-result");
                if (bundleA != null) {
                    al alVar = e6Var2.o;
                    alVar.getClass();
                    ArrayList<Integer> integerArrayList = bundleA.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
                    ArrayList<String> stringArrayList = bundleA.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
                    if (stringArrayList == null || integerArrayList == null) {
                        return;
                    }
                    alVar.e = bundleA.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
                    alVar.a = (Random) bundleA.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT");
                    Bundle bundle = bundleA.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT");
                    Bundle bundle2 = alVar.h;
                    bundle2.putAll(bundle);
                    for (int i = 0; i < stringArrayList.size(); i++) {
                        String str2 = stringArrayList.get(i);
                        HashMap map = alVar.c;
                        boolean zContainsKey = map.containsKey(str2);
                        HashMap map2 = alVar.b;
                        if (zContainsKey) {
                            Integer num = (Integer) map.remove(str2);
                            if (!bundle2.containsKey(str2)) {
                                map2.remove(num);
                            }
                        }
                        Integer num2 = integerArrayList.get(i);
                        num2.intValue();
                        String str3 = stringArrayList.get(i);
                        map2.put(num2, str3);
                        map.put(str3, num2);
                    }
                }
            }
        });
    }

    @Override // defpackage.od1
    public final nd1 a() {
        return (nd1) this.k.b;
    }

    @Override // defpackage.hb0
    public final fb h() {
        jv0 jv0Var = new jv0(mp.h);
        Application application = getApplication();
        LinkedHashMap linkedHashMap = (LinkedHashMap) jv0Var.g;
        if (application != null) {
            linkedHashMap.put(ka0.o, getApplication());
        }
        linkedHashMap.put(m90.c, this);
        linkedHashMap.put(m90.d, this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            linkedHashMap.put(m90.e, getIntent().getExtras());
        }
        return jv0Var;
    }

    @Override // defpackage.dt1
    public final ct1 j() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        if (this.l == null) {
            bl blVar = (bl) getLastNonConfigurationInstance();
            if (blVar != null) {
                this.l = blVar.a;
            }
            if (this.l == null) {
                this.l = new ct1();
            }
        }
        return this.l;
    }

    @Override // defpackage.en0
    public final androidx.lifecycle.a l() {
        return this.j;
    }

    public final void m(ry0 ry0Var) {
        zn znVar = this.h;
        if (((a) znVar.h) != null) {
            ry0Var.a();
        }
        ((CopyOnWriteArraySet) znVar.g).add(ry0Var);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.o.a(i, i2, intent)) {
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.m.b();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator it = this.p.iterator();
        while (it.hasNext()) {
            ((f50) it.next()).a(configuration);
        }
    }

    @Override // defpackage.cl, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.k.d(bundle);
        zn znVar = this.h;
        znVar.h = this;
        Iterator it = ((CopyOnWriteArraySet) znVar.g).iterator();
        while (it.hasNext()) {
            ((ry0) it.next()).a();
        }
        super.onCreate(bundle);
        int i = fa1.h;
        da1.b(this);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return true;
        }
        super.onCreatePanelMenu(i, menu);
        getMenuInflater();
        Iterator it = this.i.b.iterator();
        if (it.hasNext()) {
            throw uo.c(it);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i != 0) {
            return false;
        }
        Iterator it = this.i.b.iterator();
        if (it.hasNext()) {
            throw uo.c(it);
        }
        return false;
    }

    @Override // android.app.Activity
    public final void onMultiWindowModeChanged(boolean z, Configuration configuration) {
        for (f50 f50Var : this.s) {
            qg0.l(configuration, "newConfig");
            f50Var.a(new ka0(28));
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Iterator it = this.r.iterator();
        while (it.hasNext()) {
            ((f50) it.next()).a(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        Iterator it = this.i.b.iterator();
        if (it.hasNext()) {
            throw uo.c(it);
        }
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public final void onPictureInPictureModeChanged(boolean z, Configuration configuration) {
        for (f50 f50Var : this.t) {
            qg0.l(configuration, "newConfig");
            f50Var.a(new b21(0));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0) {
            return true;
        }
        super.onPreparePanel(i, view, menu);
        Iterator it = this.i.b.iterator();
        if (it.hasNext()) {
            throw uo.c(it);
        }
        return true;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.o.a(i, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr)) || Build.VERSION.SDK_INT < 23) {
            return;
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        bl blVar;
        ct1 ct1Var = this.l;
        if (ct1Var == null && (blVar = (bl) getLastNonConfigurationInstance()) != null) {
            ct1Var = blVar.a;
        }
        if (ct1Var == null) {
            return null;
        }
        bl blVar2 = new bl();
        blVar2.a = ct1Var;
        return blVar2;
    }

    @Override // defpackage.cl, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        androidx.lifecycle.a aVar = this.j;
        if (aVar != null) {
            aVar.g();
        }
        super.onSaveInstanceState(bundle);
        this.k.e(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        super.onTrimMemory(i);
        Iterator it = this.q.iterator();
        while (it.hasNext()) {
            ((f50) it.next()).a(Integer.valueOf(i));
        }
    }

    @Override // android.app.Activity
    public final void reportFullyDrawn() {
        try {
            if (z71.j()) {
                z71.c("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            Trace.endSection();
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        View decorView = getWindow().getDecorView();
        qg0.l(decorView, "<this>");
        decorView.setTag(c61.view_tree_lifecycle_owner, this);
        View decorView2 = getWindow().getDecorView();
        qg0.l(decorView2, "<this>");
        decorView2.setTag(d61.view_tree_view_model_store_owner, this);
        View decorView3 = getWindow().getDecorView();
        qg0.l(decorView3, "<this>");
        decorView3.setTag(p51.view_tree_saved_state_registry_owner, this);
        View decorView4 = getWindow().getDecorView();
        qg0.l(decorView4, "<this>");
        decorView4.setTag(f61.view_tree_on_back_pressed_dispatcher_owner, this);
        super.setContentView(view);
    }
}
