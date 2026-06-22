package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class kg0 extends ig0 {
    static {
        new kg0(1, 0, 1);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof kg0)) {
            return false;
        }
        if (isEmpty() && ((kg0) obj).isEmpty()) {
            return true;
        }
        kg0 kg0Var = (kg0) obj;
        if (this.g == kg0Var.g) {
            return this.h == kg0Var.h;
        }
        return false;
    }

    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.g * 31) + this.h;
    }

    public final boolean isEmpty() {
        return this.g > this.h;
    }

    public final String toString() {
        return this.g + ".." + this.h;
    }
}
