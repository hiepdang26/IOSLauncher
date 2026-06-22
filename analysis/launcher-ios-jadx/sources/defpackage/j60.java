package defpackage;

import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class j60 extends at1 {
    public final boolean f;
    public final HashMap c = new HashMap();
    public final HashMap d = new HashMap();
    public final HashMap e = new HashMap();
    public boolean g = false;
    public boolean h = false;

    public j60(boolean z) {
        this.f = z;
    }

    @Override // defpackage.at1
    public final void a() {
        if (h60.E(3)) {
            toString();
        }
        this.g = true;
    }

    public final void b(w50 w50Var) {
        if (this.h) {
            h60.E(2);
        } else {
            if (this.c.remove(w50Var.l) == null || !h60.E(2)) {
                return;
            }
            w50Var.toString();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && j60.class == obj.getClass()) {
            j60 j60Var = (j60) obj;
            if (this.c.equals(j60Var.c) && this.d.equals(j60Var.d) && this.e.equals(j60Var.e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.e.hashCode() + ((this.d.hashCode() + (this.c.hashCode() * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator it = this.c.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator it2 = this.d.keySet().iterator();
        while (it2.hasNext()) {
            sb.append((String) it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator it3 = this.e.keySet().iterator();
        while (it3.hasNext()) {
            sb.append((String) it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
