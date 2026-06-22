package defpackage;

import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class cp1 {
    public static final ba a;
    public static final ThreadLocal b;
    public static final ArrayList c;

    static {
        ba baVar = new ba();
        baVar.C = new ArrayList();
        baVar.D = true;
        baVar.F = false;
        baVar.G = 0;
        baVar.D = false;
        baVar.F(new l20(2));
        baVar.F(new nh());
        baVar.F(new l20(1));
        a = baVar;
        b = new ThreadLocal();
        c = new ArrayList();
    }

    public static void a(ViewGroup viewGroup, xo1 xo1Var) {
        ArrayList arrayList = c;
        if (arrayList.contains(viewGroup)) {
            return;
        }
        WeakHashMap weakHashMap = qs1.a;
        if (viewGroup.isLaidOut()) {
            arrayList.add(viewGroup);
            if (xo1Var == null) {
                xo1Var = a;
            }
            xo1 xo1VarClone = xo1Var.clone();
            ArrayList arrayList2 = (ArrayList) b().get(viewGroup);
            if (arrayList2 != null && arrayList2.size() > 0) {
                int size = arrayList2.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList2.get(i);
                    i++;
                    ((xo1) obj).t(viewGroup);
                }
            }
            if (xo1VarClone != null) {
                xo1VarClone.g(viewGroup, true);
            }
            if (viewGroup.getTag(q51.transition_current_scene) != null) {
                throw new ClassCastException();
            }
            viewGroup.setTag(q51.transition_current_scene, null);
            if (xo1VarClone != null) {
                bp1 bp1Var = new bp1();
                bp1Var.g = xo1VarClone;
                bp1Var.h = viewGroup;
                viewGroup.addOnAttachStateChangeListener(bp1Var);
                viewGroup.getViewTreeObserver().addOnPreDrawListener(bp1Var);
            }
        }
    }

    public static e9 b() {
        e9 e9Var;
        ThreadLocal threadLocal = b;
        WeakReference weakReference = (WeakReference) threadLocal.get();
        if (weakReference != null && (e9Var = (e9) weakReference.get()) != null) {
            return e9Var;
        }
        e9 e9Var2 = new e9(0);
        threadLocal.set(new WeakReference(e9Var2));
        return e9Var2;
    }
}
