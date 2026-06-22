package defpackage;

import android.view.View;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class m91 {
    public static final List z = Collections.EMPTY_LIST;
    public final View g;
    public WeakReference h;
    public int p;
    public RecyclerView x;
    public m81 y;
    public int i = -1;
    public int j = -1;
    public long k = -1;
    public int l = -1;
    public int m = -1;
    public m91 n = null;
    public m91 o = null;
    public ArrayList q = null;
    public List r = null;
    public int s = 0;
    public c91 t = null;
    public boolean u = false;
    public int v = 0;
    public int w = -1;

    public m91(View view) {
        if (view == null) {
            throw new IllegalArgumentException("itemView may not be null");
        }
        this.g = view;
    }

    public final void c(int i) {
        this.p = i | this.p;
    }

    public final int d() {
        RecyclerView recyclerView = this.x;
        if (recyclerView == null) {
            return -1;
        }
        return recyclerView.M(this);
    }

    public final int e() {
        RecyclerView recyclerView;
        m81 adapter;
        int iM;
        if (this.y == null || (recyclerView = this.x) == null || (adapter = recyclerView.getAdapter()) == null || (iM = this.x.M(this)) == -1 || this.y != adapter) {
            return -1;
        }
        return iM;
    }

    public final int f() {
        int i = this.m;
        return i == -1 ? this.i : i;
    }

    public final int g() {
        int i = this.m;
        return i == -1 ? this.i : i;
    }

    public final List h() {
        ArrayList arrayList;
        return ((this.p & 1024) != 0 || (arrayList = this.q) == null || arrayList.size() == 0) ? z : this.r;
    }

    public final boolean i() {
        View view = this.g;
        return (view.getParent() == null || view.getParent() == this.x) ? false : true;
    }

    public final boolean j() {
        return (this.p & 1) != 0;
    }

    public final boolean k() {
        return (this.p & 4) != 0;
    }

    public final boolean l() {
        if ((this.p & 16) != 0) {
            return false;
        }
        WeakHashMap weakHashMap = qs1.a;
        return !this.g.hasTransientState();
    }

    public final boolean m() {
        return (this.p & 8) != 0;
    }

    public final boolean n() {
        return this.t != null;
    }

    public final boolean o() {
        return (this.p & MotionScene.Transition.TransitionOnClick.JUMP_TO_END) != 0;
    }

    public final boolean p() {
        return (this.p & 2) != 0;
    }

    public final void q(int i, boolean z2) {
        if (this.j == -1) {
            this.j = this.i;
        }
        if (this.m == -1) {
            this.m = this.i;
        }
        if (z2) {
            this.m += i;
        }
        this.i += i;
        View view = this.g;
        if (view.getLayoutParams() != null) {
            ((v81) view.getLayoutParams()).c = true;
        }
    }

    public final void r() {
        if (RecyclerView.G0 && o()) {
            throw new IllegalStateException("Attempting to reset temp-detached ViewHolder: " + this + ". ViewHolders should be fully detached before resetting.");
        }
        this.p = 0;
        this.i = -1;
        this.j = -1;
        this.k = -1L;
        this.m = -1;
        this.s = 0;
        this.n = null;
        this.o = null;
        ArrayList arrayList = this.q;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.p &= -1025;
        this.v = 0;
        this.w = -1;
        RecyclerView.n(this);
    }

    public final void s(boolean z2) {
        int i = this.s;
        int i2 = z2 ? i - 1 : i + 1;
        this.s = i2;
        if (i2 < 0) {
            this.s = 0;
            if (RecyclerView.G0) {
                throw new RuntimeException("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            }
            toString();
        } else if (!z2 && i2 == 1) {
            this.p |= 16;
        } else if (z2 && i2 == 0) {
            this.p &= -17;
        }
        if (RecyclerView.H0) {
            toString();
        }
    }

    public final boolean t() {
        return (this.p & 128) != 0;
    }

    public final String toString() {
        StringBuilder sbM = k31.m(getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName(), "{");
        sbM.append(Integer.toHexString(hashCode()));
        sbM.append(" position=");
        sbM.append(this.i);
        sbM.append(" id=");
        sbM.append(this.k);
        sbM.append(", oldPos=");
        sbM.append(this.j);
        sbM.append(", pLpos:");
        sbM.append(this.m);
        StringBuilder sb = new StringBuilder(sbM.toString());
        if (n()) {
            sb.append(" scrap ");
            sb.append(this.u ? "[changeScrap]" : "[attachedScrap]");
        }
        if (k()) {
            sb.append(" invalid");
        }
        if (!j()) {
            sb.append(" unbound");
        }
        if ((this.p & 2) != 0) {
            sb.append(" update");
        }
        if (m()) {
            sb.append(" removed");
        }
        if (t()) {
            sb.append(" ignored");
        }
        if (o()) {
            sb.append(" tmpDetached");
        }
        if (!l()) {
            sb.append(" not recyclable(" + this.s + ")");
        }
        if ((this.p & 512) != 0 || k()) {
            sb.append(" undefined adapter position");
        }
        if (this.g.getParent() == null) {
            sb.append(" no parent");
        }
        sb.append("}");
        return sb.toString();
    }

    public final boolean u() {
        return (this.p & 32) != 0;
    }
}
