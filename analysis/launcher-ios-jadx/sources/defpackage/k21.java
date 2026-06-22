package defpackage;

import androidx.constraintlayout.motion.widget.MotionScene;

/* JADX INFO: loaded from: classes.dex */
public class k21 {
    public final Object[] a;
    public int b;

    public k21(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.a = new Object[i];
    }

    public Object a() {
        int i = this.b;
        if (i <= 0) {
            return null;
        }
        int i2 = i - 1;
        Object[] objArr = this.a;
        Object obj = objArr[i2];
        qg0.i(obj, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
        objArr[i2] = null;
        this.b--;
        return obj;
    }

    public void b(f9 f9Var) {
        int i = this.b;
        Object[] objArr = this.a;
        if (i < objArr.length) {
            objArr[i] = f9Var;
            this.b = i + 1;
        }
    }

    public boolean c(Object obj) {
        Object[] objArr;
        boolean z;
        qg0.l(obj, "instance");
        int i = this.b;
        int i2 = 0;
        while (true) {
            objArr = this.a;
            if (i2 >= i) {
                z = false;
                break;
            }
            if (objArr[i2] == obj) {
                z = true;
                break;
            }
            i2++;
        }
        if (z) {
            throw new IllegalStateException("Already in the pool!");
        }
        int i3 = this.b;
        if (i3 >= objArr.length) {
            return false;
        }
        objArr[i3] = obj;
        this.b = i3 + 1;
        return true;
    }

    public k21() {
        this.a = new Object[MotionScene.Transition.TransitionOnClick.JUMP_TO_END];
    }
}
