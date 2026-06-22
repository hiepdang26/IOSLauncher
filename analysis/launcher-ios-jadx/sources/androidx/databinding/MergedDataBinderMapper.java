package androidx.databinding;

import android.view.View;
import defpackage.lh0;
import defpackage.xr;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class MergedDataBinderMapper extends xr {
    public final HashSet a = new HashSet();
    public final CopyOnWriteArrayList b = new CopyOnWriteArrayList();
    public final CopyOnWriteArrayList c = new CopyOnWriteArrayList();

    @Override // defpackage.xr
    public final lh0 b(int i, View view) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            lh0 lh0VarB = ((xr) it.next()).b(i, view);
            if (lh0VarB != null) {
                return lh0VarB;
            }
        }
        CopyOnWriteArrayList<String> copyOnWriteArrayList = this.c;
        boolean z = false;
        for (String str : copyOnWriteArrayList) {
            try {
                Class<?> cls = Class.forName(str);
                if (xr.class.isAssignableFrom(cls)) {
                    c((xr) cls.newInstance());
                    copyOnWriteArrayList.remove(str);
                    z = true;
                }
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
            }
        }
        if (z) {
            return b(i, view);
        }
        return null;
    }

    public final void c(xr xrVar) {
        if (this.a.add(xrVar.getClass())) {
            this.b.add(xrVar);
            Iterator it = xrVar.a().iterator();
            while (it.hasNext()) {
                c((xr) it.next());
            }
        }
    }
}
