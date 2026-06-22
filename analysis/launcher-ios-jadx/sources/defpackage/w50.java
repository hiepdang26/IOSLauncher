package defpackage;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.a;
import androidx.lifecycle.b;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class w50 implements ComponentCallbacks, View.OnCreateContextMenuListener, en0, dt1, hb0, od1 {
    public static final Object Y = new Object();
    public w50 B;
    public int C;
    public int D;
    public String E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean J;
    public ViewGroup K;
    public View L;
    public boolean M;
    public v50 O;
    public boolean P;
    public LayoutInflater Q;
    public boolean R;
    public a T;
    public o60 U;
    public hh1 W;
    public final ArrayList X;
    public Bundle h;
    public SparseArray i;
    public Bundle j;
    public Boolean k;
    public Bundle m;
    public w50 n;
    public int p;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public int x;
    public h60 y;
    public x50 z;
    public int g = -1;
    public String l = UUID.randomUUID().toString();
    public String o = null;
    public Boolean q = null;
    public h60 A = new h60();
    public boolean I = true;
    public boolean N = true;
    public vm0 S = vm0.k;
    public final b V = new b();

    public w50() {
        new AtomicInteger();
        this.X = new ArrayList();
        this.T = new a(this);
        this.W = new hh1(this);
    }

    public void A() {
        this.J = true;
    }

    public void B() {
        this.J = true;
    }

    public void C() {
        this.J = true;
    }

    public LayoutInflater D(Bundle bundle) {
        x50 x50Var = this.z;
        if (x50Var == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        e6 e6Var = x50Var.F;
        LayoutInflater layoutInflaterCloneInContext = e6Var.getLayoutInflater().cloneInContext(e6Var);
        layoutInflaterCloneInContext.setFactory2(this.A.f);
        return layoutInflaterCloneInContext;
    }

    public void E() {
        this.J = true;
    }

    public void F() {
        this.J = true;
    }

    public void H() {
        this.J = true;
    }

    public void I() {
        this.J = true;
    }

    public void K(Bundle bundle) {
        this.J = true;
    }

    public void L(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.A.J();
        this.w = true;
        this.U = new o60(j());
        View viewZ = z(layoutInflater, viewGroup, bundle);
        this.L = viewZ;
        if (viewZ == null) {
            if (this.U.h != null) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.U = null;
            return;
        }
        this.U.c();
        View view = this.L;
        o60 o60Var = this.U;
        qg0.l(view, "<this>");
        view.setTag(c61.view_tree_lifecycle_owner, o60Var);
        View view2 = this.L;
        o60 o60Var2 = this.U;
        qg0.l(view2, "<this>");
        view2.setTag(d61.view_tree_view_model_store_owner, o60Var2);
        View view3 = this.L;
        o60 o60Var3 = this.U;
        qg0.l(view3, "<this>");
        view3.setTag(p51.view_tree_saved_state_registry_owner, o60Var3);
        this.V.e(this.U);
    }

    public final e6 M() {
        e6 e6VarD = d();
        if (e6VarD != null) {
            return e6VarD;
        }
        throw new IllegalStateException(uo.g("Fragment ", this, " not attached to an activity."));
    }

    public final Context N() {
        Context contextP = p();
        if (contextP != null) {
            return contextP;
        }
        throw new IllegalStateException(uo.g("Fragment ", this, " not attached to a context."));
    }

    public final View O() {
        View view = this.L;
        if (view != null) {
            return view;
        }
        throw new IllegalStateException(uo.g("Fragment ", this, " did not return a View from onCreateView() or this was called before onCreateView()."));
    }

    public final void P(int i, int i2, int i3, int i4) {
        if (this.O == null && i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            return;
        }
        g().b = i;
        g().c = i2;
        g().d = i3;
        g().e = i4;
    }

    public final void Q(Bundle bundle) {
        h60 h60Var = this.y;
        if (h60Var != null && (h60Var.A || h60Var.B)) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.m = bundle;
    }

    public final void R(z21 z21Var) {
        h60 h60Var = this.y;
        h60 h60Var2 = z21Var != null ? z21Var.y : null;
        if (h60Var != null && h60Var2 != null && h60Var != h60Var2) {
            throw new IllegalArgumentException("Fragment " + z21Var + " must share the same FragmentManager to be set as a target fragment");
        }
        for (w50 w50VarU = z21Var; w50VarU != null; w50VarU = w50VarU.u()) {
            if (super.equals(this)) {
                throw new IllegalArgumentException("Setting " + z21Var + " as the target of " + this + " would create a target cycle");
            }
        }
        if (z21Var == null) {
            this.o = null;
            this.n = null;
        } else if (this.y == null || z21Var.y == null) {
            this.o = null;
            this.n = z21Var;
        } else {
            this.o = z21Var.l;
            this.n = null;
        }
        this.p = 0;
    }

    public final void S(boolean z) {
        h60 h60Var;
        boolean z2 = false;
        if (!this.N && z && this.g < 5 && (h60Var = this.y) != null && this.z != null && this.r && this.R) {
            androidx.fragment.app.a aVarF = h60Var.f(this);
            w50 w50Var = aVarF.c;
            if (w50Var.M) {
                if (h60Var.b) {
                    h60Var.D = true;
                } else {
                    w50Var.M = false;
                    aVarF.k();
                }
            }
        }
        this.N = z;
        if (this.g < 5 && !z) {
            z2 = true;
        }
        this.M = z2;
        if (this.h != null) {
            this.k = Boolean.valueOf(z);
        }
    }

    public final void T(Intent intent) {
        x50 x50Var = this.z;
        if (x50Var == null) {
            throw new IllegalStateException(uo.g("Fragment ", this, " not attached to Activity"));
        }
        x50Var.C.startActivity(intent, null);
    }

    @Override // defpackage.od1
    public final nd1 a() {
        return (nd1) this.W.b;
    }

    public wd e() {
        return new u50(this);
    }

    public void f(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.C));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.D));
        printWriter.print(" mTag=");
        printWriter.println(this.E);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.g);
        printWriter.print(" mWho=");
        printWriter.print(this.l);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.x);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.r);
        printWriter.print(" mRemoving=");
        printWriter.print(this.s);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.t);
        printWriter.print(" mInLayout=");
        printWriter.println(this.u);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.F);
        printWriter.print(" mDetached=");
        printWriter.print(this.G);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.I);
        printWriter.print(" mHasMenu=");
        printWriter.println(false);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.H);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.N);
        if (this.y != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.y);
        }
        if (this.z != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.z);
        }
        if (this.B != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.B);
        }
        if (this.m != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.m);
        }
        if (this.h != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.h);
        }
        if (this.i != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.i);
        }
        if (this.j != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.j);
        }
        w50 w50VarU = u();
        if (w50VarU != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(w50VarU);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.p);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        v50 v50Var = this.O;
        printWriter.println(v50Var == null ? false : v50Var.a);
        v50 v50Var2 = this.O;
        if ((v50Var2 == null ? 0 : v50Var2.b) != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            v50 v50Var3 = this.O;
            printWriter.println(v50Var3 == null ? 0 : v50Var3.b);
        }
        v50 v50Var4 = this.O;
        if ((v50Var4 == null ? 0 : v50Var4.c) != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            v50 v50Var5 = this.O;
            printWriter.println(v50Var5 == null ? 0 : v50Var5.c);
        }
        v50 v50Var6 = this.O;
        if ((v50Var6 == null ? 0 : v50Var6.d) != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            v50 v50Var7 = this.O;
            printWriter.println(v50Var7 == null ? 0 : v50Var7.d);
        }
        v50 v50Var8 = this.O;
        if ((v50Var8 == null ? 0 : v50Var8.e) != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            v50 v50Var9 = this.O;
            printWriter.println(v50Var9 != null ? v50Var9.e : 0);
        }
        if (this.K != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.K);
        }
        if (this.L != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.L);
        }
        if (p() != null) {
            new v21(this, j()).d(str, printWriter);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.A + ":");
        this.A.u(uo.h(str, "  "), fileDescriptor, printWriter, strArr);
    }

    public final v50 g() {
        if (this.O == null) {
            v50 v50Var = new v50();
            Object obj = Y;
            v50Var.g = obj;
            v50Var.h = obj;
            v50Var.i = obj;
            v50Var.j = 1.0f;
            v50Var.k = null;
            this.O = v50Var;
        }
        return this.O;
    }

    @Override // defpackage.hb0
    public final fb h() {
        return mp.h;
    }

    @Override // defpackage.dt1
    public final ct1 j() {
        if (this.y == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (q() == 1) {
            throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
        }
        HashMap map = this.y.H.e;
        ct1 ct1Var = (ct1) map.get(this.l);
        if (ct1Var != null) {
            return ct1Var;
        }
        ct1 ct1Var2 = new ct1();
        map.put(this.l, ct1Var2);
        return ct1Var2;
    }

    @Override // defpackage.en0
    public final a l() {
        return this.T;
    }

    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public final e6 d() {
        x50 x50Var = this.z;
        if (x50Var == null) {
            return null;
        }
        return x50Var.B;
    }

    public final h60 o() {
        if (this.z != null) {
            return this.A;
        }
        throw new IllegalStateException(uo.g("Fragment ", this, " has not been attached yet."));
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        this.J = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        M().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        this.J = true;
    }

    public final Context p() {
        x50 x50Var = this.z;
        if (x50Var == null) {
            return null;
        }
        return x50Var.C;
    }

    public final int q() {
        vm0 vm0Var = this.S;
        return (vm0Var == vm0.h || this.B == null) ? vm0Var.ordinal() : Math.min(vm0Var.ordinal(), this.B.q());
    }

    public final h60 r() {
        h60 h60Var = this.y;
        if (h60Var != null) {
            return h60Var;
        }
        throw new IllegalStateException(uo.g("Fragment ", this, " not associated with a fragment manager."));
    }

    public final Resources s() {
        return N().getResources();
    }

    public final void startActivityForResult(Intent intent, int i) {
        if (this.z == null) {
            throw new IllegalStateException(uo.g("Fragment ", this, " not attached to Activity"));
        }
        h60 h60VarR = r();
        if (h60VarR.v == null) {
            x50 x50Var = h60VarR.p;
            if (i == -1) {
                x50Var.C.startActivity(intent, null);
                return;
            } else {
                x50Var.getClass();
                throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
            }
        }
        String str = this.l;
        e60 e60Var = new e60();
        e60Var.g = str;
        e60Var.h = i;
        h60VarR.y.addLast(e60Var);
        h60VarR.v.F(intent);
    }

    public final String t(int i) {
        return s().getString(i);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} (");
        sb.append(this.l);
        if (this.C != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.C));
        }
        if (this.E != null) {
            sb.append(" tag=");
            sb.append(this.E);
        }
        sb.append(")");
        return sb.toString();
    }

    public final w50 u() {
        String str;
        w50 w50Var = this.n;
        if (w50Var != null) {
            return w50Var;
        }
        h60 h60Var = this.y;
        if (h60Var == null || (str = this.o) == null) {
            return null;
        }
        return h60Var.c.q(str);
    }

    public void v() {
        this.J = true;
    }

    public void w(int i, int i2, Intent intent) {
        if (h60.E(2)) {
            toString();
            Objects.toString(intent);
        }
    }

    public void x(e6 e6Var) {
        this.J = true;
        x50 x50Var = this.z;
        if ((x50Var == null ? null : x50Var.B) != null) {
            this.J = true;
        }
    }

    public void y(Bundle bundle) {
        Parcelable parcelable;
        this.J = true;
        if (bundle != null && (parcelable = bundle.getParcelable("android:support:fragments")) != null) {
            this.A.O(parcelable);
            h60 h60Var = this.A;
            h60Var.A = false;
            h60Var.B = false;
            h60Var.H.h = false;
            h60Var.s(1);
        }
        h60 h60Var2 = this.A;
        if (h60Var2.o >= 1) {
            return;
        }
        h60Var2.A = false;
        h60Var2.B = false;
        h60Var2.H.h = false;
        h60Var2.s(1);
    }

    public View z(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public void G(Bundle bundle) {
    }

    public void J(View view, Bundle bundle) {
    }
}
