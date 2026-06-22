package defpackage;

import android.R;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.a;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.VectorEnabledTintResources;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class e6 extends a implements f6, u1, v1 {
    public VectorEnabledTintResources A;
    public boolean w;
    public boolean x;
    public q6 z;
    public final ow1 u = new ow1(new x50(this), 15);
    public final androidx.lifecycle.a v = new androidx.lifecycle.a(this);
    public boolean y = true;

    public e6() {
        ((nd1) this.k.b).b("android:support:fragments", new c6(this, 1));
        m(new d6(this, 1));
        ((nd1) this.k.b).b("androidx:appcompat", new c6(this, 0));
        m(new d6(this, 0));
    }

    public static boolean q(h60 h60Var) {
        boolean zQ = false;
        for (w50 w50Var : h60Var.c.t()) {
            if (w50Var != null) {
                x50 x50Var = w50Var.z;
                if ((x50Var == null ? null : x50Var.F) != null) {
                    zQ |= q(w50Var.o());
                }
                o60 o60Var = w50Var.U;
                vm0 vm0Var = vm0.j;
                if (o60Var != null) {
                    o60Var.c();
                    if (o60Var.h.c.compareTo(vm0Var) >= 0) {
                        w50Var.U.h.g();
                        zQ = true;
                    }
                }
                if (w50Var.T.c.compareTo(vm0Var) >= 0) {
                    w50Var.T.g();
                    zQ = true;
                }
            }
        }
        return zQ;
    }

    @Override // android.app.Activity
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        p();
        q6 q6Var = (q6) n();
        q6Var.p();
        ((ViewGroup) q6Var.z.findViewById(R.id.content)).addView(view, layoutParams);
        q6Var.l.g.onContentChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0043  */
    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void attachBaseContext(android.content.Context r10) {
        /*
            Method dump skipped, instruction units count: 503
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.e6.attachBaseContext(android.content.Context):void");
    }

    @Override // android.app.Activity
    public final void closeOptionsMenu() {
        ((q6) n()).t();
        if (getWindow().hasFeature(0)) {
            super.closeOptionsMenu();
        }
    }

    @Override // defpackage.cl, android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        keyEvent.getKeyCode();
        ((q6) n()).t();
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.w);
        printWriter.print(" mResumed=");
        printWriter.print(this.x);
        printWriter.print(" mStopped=");
        printWriter.print(this.y);
        if (getApplication() != null) {
            new v21(this, j()).d(str2, printWriter);
        }
        ((x50) this.u.h).E.u(str, fileDescriptor, printWriter, strArr);
    }

    @Override // android.app.Activity
    public final View findViewById(int i) {
        q6 q6Var = (q6) n();
        q6Var.p();
        return q6Var.k.findViewById(i);
    }

    @Override // android.app.Activity
    public final MenuInflater getMenuInflater() {
        q6 q6Var = (q6) n();
        if (q6Var.o == null) {
            q6Var.t();
            ux1 ux1Var = q6Var.n;
            q6Var.o = new tk1(ux1Var != null ? ux1Var.F() : q6Var.j);
        }
        return q6Var.o;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        if (this.A == null && VectorEnabledTintResources.shouldBeUsed()) {
            this.A = new VectorEnabledTintResources(this, super.getResources());
        }
        VectorEnabledTintResources vectorEnabledTintResources = this.A;
        return vectorEnabledTintResources == null ? super.getResources() : vectorEnabledTintResources;
    }

    @Override // android.app.Activity
    public final void invalidateOptionsMenu() {
        n().a();
    }

    public final g6 n() {
        if (this.z == null) {
            g9 g9Var = g6.g;
            this.z = new q6(this, null, this, this);
        }
        return this.z;
    }

    public final h60 o() {
        return ((x50) this.u.h).E;
    }

    @Override // androidx.activity.a, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        this.u.j();
        super.onActivityResult(i, i2, intent);
    }

    @Override // androidx.activity.a, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        r(configuration);
        if (this.A != null) {
            this.A.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
        q6 q6Var = (q6) n();
        if (q6Var.E && q6Var.y) {
            q6Var.t();
            ux1 ux1Var = q6Var.n;
            if (ux1Var != null) {
                ux1Var.I(f1.d(ux1Var.v).h.getResources().getBoolean(u41.abc_action_bar_embed_tabs));
            }
        }
        AppCompatDrawableManager appCompatDrawableManager = AppCompatDrawableManager.get();
        Context context = q6Var.j;
        appCompatDrawableManager.onConfigurationChanged(context);
        q6Var.Q = new Configuration(context.getResources().getConfiguration());
        q6Var.h(false);
    }

    @Override // androidx.activity.a, defpackage.cl, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.v.d(um0.ON_CREATE);
        h60 h60Var = ((x50) this.u.h).E;
        h60Var.A = false;
        h60Var.B = false;
        h60Var.H.h = false;
        h60Var.s(1);
    }

    @Override // androidx.activity.a, android.app.Activity, android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            super.onCreatePanelMenu(i, menu);
            return true;
        }
        super.onCreatePanelMenu(i, menu);
        getMenuInflater();
        ((x50) this.u.h).E.j();
        return true;
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View viewOnCreateView = ((x50) this.u.h).E.f.onCreateView(view, str, context, attributeSet);
        return viewOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : viewOnCreateView;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        s();
        n().c();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        Window window;
        if (Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public final void onLowMemory() {
        super.onLowMemory();
        ((x50) this.u.h).E.l();
    }

    @Override // androidx.activity.a, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        Intent intentP;
        if (!t(i, menuItem)) {
            q6 q6Var = (q6) n();
            q6Var.t();
            ux1 ux1Var = q6Var.n;
            if (menuItem.getItemId() != 16908332 || ux1Var == null || (ux1Var.z.getDisplayOptions() & 4) == 0 || (intentP = hg0.p(this)) == null) {
                return false;
            }
            if (!shouldUpRecreateTask(intentP)) {
                navigateUpTo(intentP);
                return true;
            }
            ArrayList arrayList = new ArrayList();
            Intent intentP2 = hg0.p(this);
            if (intentP2 == null) {
                intentP2 = hg0.p(this);
            }
            if (intentP2 != null) {
                ComponentName component = intentP2.getComponent();
                if (component == null) {
                    component = intentP2.resolveActivity(getPackageManager());
                }
                int size = arrayList.size();
                try {
                    Intent intentQ = hg0.q(this, component);
                    while (intentQ != null) {
                        arrayList.add(size, intentQ);
                        intentQ = hg0.q(this, intentQ.getComponent());
                    }
                    arrayList.add(intentP2);
                } catch (PackageManager.NameNotFoundException e) {
                    throw new IllegalArgumentException(e);
                }
            }
            if (arrayList.isEmpty()) {
                throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
            }
            Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[0]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            startActivities(intentArr, null);
            try {
                finishAffinity();
            } catch (IllegalStateException unused) {
                finish();
            }
        }
        return true;
    }

    @Override // android.app.Activity
    public final void onMultiWindowModeChanged(boolean z) {
        ((x50) this.u.h).E.m();
    }

    @Override // androidx.activity.a, android.app.Activity
    public final void onNewIntent(Intent intent) {
        this.u.j();
        super.onNewIntent(intent);
    }

    @Override // androidx.activity.a, android.app.Activity, android.view.Window.Callback
    public final void onPanelClosed(int i, Menu menu) {
        u(i, menu);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.x = false;
        ((x50) this.u.h).E.s(5);
        this.v.d(um0.ON_PAUSE);
    }

    @Override // android.app.Activity
    public final void onPictureInPictureModeChanged(boolean z) {
        ((x50) this.u.h).E.q();
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ((q6) n()).p();
    }

    @Override // android.app.Activity
    public final void onPostResume() {
        v();
        q6 q6Var = (q6) n();
        q6Var.t();
        ux1 ux1Var = q6Var.n;
        if (ux1Var != null) {
            ux1Var.P = true;
        }
    }

    @Override // androidx.activity.a, android.app.Activity, android.view.Window.Callback
    public final boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0) {
            super.onPreparePanel(i, view, menu);
            return true;
        }
        super.onPreparePanel(0, view, menu);
        ((x50) this.u.h).E.r();
        return true;
    }

    @Override // androidx.activity.a, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.u.j();
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        ow1 ow1Var = this.u;
        ow1Var.j();
        super.onResume();
        this.x = true;
        ((x50) ow1Var.h).E.x(true);
    }

    @Override // android.app.Activity
    public void onStart() {
        w();
        ((q6) n()).h(true);
    }

    @Override // android.app.Activity
    public final void onStateNotSaved() {
        this.u.j();
    }

    @Override // android.app.Activity
    public void onStop() {
        x();
        q6 q6Var = (q6) n();
        q6Var.t();
        ux1 ux1Var = q6Var.n;
        if (ux1Var != null) {
            ux1Var.P = false;
            bu1 bu1Var = ux1Var.O;
            if (bu1Var != null) {
                bu1Var.a();
            }
        }
    }

    @Override // android.app.Activity
    public final void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        n().g(charSequence);
    }

    @Override // android.app.Activity
    public final void openOptionsMenu() {
        ((q6) n()).t();
        if (getWindow().hasFeature(0)) {
            super.openOptionsMenu();
        }
    }

    public final void p() {
        View decorView = getWindow().getDecorView();
        qg0.l(decorView, "<this>");
        decorView.setTag(c61.view_tree_lifecycle_owner, this);
        View decorView2 = getWindow().getDecorView();
        qg0.l(decorView2, "<this>");
        decorView2.setTag(d61.view_tree_view_model_store_owner, this);
        View decorView3 = getWindow().getDecorView();
        qg0.l(decorView3, "<this>");
        decorView3.setTag(p51.view_tree_saved_state_registry_owner, this);
    }

    public final void r(Configuration configuration) {
        ow1 ow1Var = this.u;
        ow1Var.j();
        super.onConfigurationChanged(configuration);
        ((x50) ow1Var.h).E.h();
    }

    public final void s() {
        super.onDestroy();
        ((x50) this.u.h).E.k();
        this.v.d(um0.ON_DESTROY);
    }

    @Override // android.app.Activity
    public final void setContentView(int i) {
        p();
        n().f(i);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i) {
        super.setTheme(i);
        ((q6) n()).S = i;
    }

    public final boolean t(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        ow1 ow1Var = this.u;
        if (i == 0) {
            return ((x50) ow1Var.h).E.n();
        }
        if (i != 6) {
            return false;
        }
        return ((x50) ow1Var.h).E.i();
    }

    public final void u(int i, Menu menu) {
        if (i == 0) {
            ((x50) this.u.h).E.o();
        }
        super.onPanelClosed(i, menu);
    }

    public final void v() {
        super.onPostResume();
        this.v.d(um0.ON_RESUME);
        h60 h60Var = ((x50) this.u.h).E;
        h60Var.A = false;
        h60Var.B = false;
        h60Var.H.h = false;
        h60Var.s(7);
    }

    public final void w() {
        ow1 ow1Var = this.u;
        ow1Var.j();
        super.onStart();
        this.y = false;
        boolean z = this.w;
        x50 x50Var = (x50) ow1Var.h;
        if (!z) {
            this.w = true;
            h60 h60Var = x50Var.E;
            h60Var.A = false;
            h60Var.B = false;
            h60Var.H.h = false;
            h60Var.s(4);
        }
        x50Var.E.x(true);
        this.v.d(um0.ON_START);
        h60 h60Var2 = x50Var.E;
        h60Var2.A = false;
        h60Var2.B = false;
        h60Var2.H.h = false;
        h60Var2.s(5);
    }

    public final void x() {
        super.onStop();
        this.y = true;
        while (q(o())) {
        }
        h60 h60Var = ((x50) this.u.h).E;
        h60Var.B = true;
        h60Var.H.h = true;
        h60Var.s(4);
        this.v.d(um0.ON_STOP);
    }

    @Override // androidx.activity.a, android.app.Activity
    public void setContentView(View view) {
        p();
        q6 q6Var = (q6) n();
        q6Var.p();
        ViewGroup viewGroup = (ViewGroup) q6Var.z.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        q6Var.l.g.onContentChanged();
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View viewOnCreateView = ((x50) this.u.h).E.f.onCreateView(null, str, context, attributeSet);
        return viewOnCreateView == null ? super.onCreateView(str, context, attributeSet) : viewOnCreateView;
    }

    @Override // android.app.Activity
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        p();
        q6 q6Var = (q6) n();
        q6Var.p();
        ViewGroup viewGroup = (ViewGroup) q6Var.z.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        q6Var.l.g.onContentChanged();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onContentChanged() {
    }
}
