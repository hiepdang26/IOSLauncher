package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandleController;
import androidx.lifecycle.a;
import defpackage.an0;
import defpackage.at1;
import defpackage.c6;
import defpackage.ct1;
import defpackage.dt1;
import defpackage.en0;
import defpackage.ld1;
import defpackage.nd1;
import defpackage.od1;
import defpackage.qg0;
import defpackage.rm0;
import defpackage.um0;
import defpackage.uo;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes.dex */
public final class Recreator implements an0 {
    public final Object g;

    public Recreator(od1 od1Var) {
        this.g = od1Var;
    }

    /* JADX WARN: Type inference failed for: r13v3, types: [java.lang.Object, od1] */
    /* JADX WARN: Type inference failed for: r2v2, types: [en0, java.lang.Object, od1] */
    @Override // defpackage.an0
    public final void a(en0 en0Var, um0 um0Var) {
        Object obj;
        boolean z;
        if (um0Var != um0.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        en0Var.l().f(this);
        Bundle bundleA = this.g.a().a("androidx.savedstate.Restarter");
        if (bundleA == null) {
            return;
        }
        ArrayList<String> stringArrayList = bundleA.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        int size = stringArrayList.size();
        int i = 0;
        while (i < size) {
            String str = stringArrayList.get(i);
            i++;
            String str2 = str;
            try {
                Class<? extends U> clsAsSubclass = Class.forName(str2, false, Recreator.class.getClassLoader()).asSubclass(ld1.class);
                qg0.k(clsAsSubclass, "{\n                Class.…class.java)\n            }");
                try {
                    Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(null);
                    declaredConstructor.setAccessible(true);
                    try {
                        Object objNewInstance = declaredConstructor.newInstance(null);
                        qg0.k(objNewInstance, "{\n                constr…wInstance()\n            }");
                        ?? r2 = this.g;
                        ct1 ct1VarJ = ((dt1) r2).j();
                        nd1 nd1VarA = r2.a();
                        ct1VarJ.getClass();
                        for (String str3 : new HashSet(ct1VarJ.a.keySet())) {
                            qg0.l(str3, "key");
                            at1 at1Var = (at1) ct1VarJ.a.get(str3);
                            qg0.h(at1Var);
                            a aVarL = r2.l();
                            qg0.l(nd1VarA, "registry");
                            qg0.l(aVarL, "lifecycle");
                            HashMap map = at1Var.a;
                            if (map == null) {
                                obj = null;
                            } else {
                                synchronized (map) {
                                    obj = at1Var.a.get("androidx.lifecycle.savedstate.vm.tag");
                                }
                            }
                            SavedStateHandleController savedStateHandleController = (SavedStateHandleController) obj;
                            if (savedStateHandleController != null && !(z = savedStateHandleController.g)) {
                                if (z) {
                                    throw new IllegalStateException("Already attached to lifecycleOwner");
                                }
                                savedStateHandleController.g = true;
                                aVarL.a(savedStateHandleController);
                                throw null;
                            }
                        }
                        if (!new HashSet(ct1VarJ.a.keySet()).isEmpty()) {
                            if (!nd1VarA.f) {
                                throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
                            }
                            c6 c6Var = nd1VarA.e;
                            if (c6Var == null) {
                                c6Var = new c6(nd1VarA);
                            }
                            nd1VarA.e = c6Var;
                            try {
                                rm0.class.getDeclaredConstructor(null);
                                c6 c6Var2 = nd1VarA.e;
                                if (c6Var2 != null) {
                                    ((LinkedHashSet) c6Var2.b).add(rm0.class.getName());
                                }
                            } catch (NoSuchMethodException e) {
                                throw new IllegalArgumentException("Class " + rm0.class.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
                            }
                        }
                    } catch (Exception e2) {
                        throw new RuntimeException("Failed to instantiate " + str2, e2);
                    }
                } catch (NoSuchMethodException e3) {
                    throw new IllegalStateException("Class " + clsAsSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e3);
                }
            } catch (ClassNotFoundException e4) {
                throw new RuntimeException(uo.t("Class ", str2, " wasn't found"), e4);
            }
        }
    }
}
