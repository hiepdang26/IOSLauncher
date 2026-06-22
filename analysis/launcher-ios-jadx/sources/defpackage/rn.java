package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class rn extends sn {
    public final int a;

    public rn(int i) {
        this.a = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof rn) && this.a == ((rn) obj).a;
    }

    public final int hashCode() {
        return this.a;
    }

    public final String toString() {
        return "ConstraintsNotMet(reason=" + this.a + ')';
    }
}
