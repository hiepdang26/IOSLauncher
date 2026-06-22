package defpackage;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class ld {
    public boolean a;
    public int b;
    public Object c;
    public Object d;

    public ld(ViewGroup viewGroup) {
        this.b = 500;
        this.c = viewGroup;
    }

    public ld a() {
        if (!(((z91) this.c) != null)) {
            throw new IllegalArgumentException("execute parameter required");
        }
        v20[] v20VarArr = (v20[]) this.d;
        boolean z = this.a;
        int i = this.b;
        ld ldVar = new ld();
        ldVar.d = this;
        ldVar.c = v20VarArr;
        boolean z2 = false;
        if (v20VarArr != null && z) {
            z2 = true;
        }
        ldVar.a = z2;
        ldVar.b = i;
        return ldVar;
    }

    public void b() {
        this.a = false;
        o1 o1Var = (o1) this.d;
        if (o1Var != null) {
            ((ViewGroup) this.c).removeCallbacks(o1Var);
            this.d = null;
        }
    }

    public void c(int i) {
        BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.d;
        WeakReference weakReference = bottomSheetBehavior.R;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.b = i;
        if (this.a) {
            return;
        }
        View view = (View) bottomSheetBehavior.R.get();
        o1 o1Var = (o1) this.c;
        WeakHashMap weakHashMap = qs1.a;
        view.postOnAnimation(o1Var);
        this.a = true;
    }

    public void d() {
        this.a = false;
        if (((o1) this.d) == null) {
            this.d = new o1(this, 12);
        }
        ((ViewGroup) this.c).postDelayed((o1) this.d, this.b);
    }

    public ld(BottomSheetBehavior bottomSheetBehavior) {
        this.d = bottomSheetBehavior;
        this.c = new o1(this, 8);
    }
}
