package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class jf extends e9 {
    public int m;

    @Override // defpackage.ug1, java.util.Map
    public final void clear() {
        this.m = 0;
        super.clear();
    }

    @Override // defpackage.ug1
    public final void g(ug1 ug1Var) {
        this.m = 0;
        super.g(ug1Var);
    }

    @Override // defpackage.ug1
    public final Object h(int i) {
        this.m = 0;
        return super.h(i);
    }

    @Override // defpackage.ug1, java.util.Map
    public final int hashCode() {
        if (this.m == 0) {
            this.m = super.hashCode();
        }
        return this.m;
    }

    @Override // defpackage.ug1
    public final Object i(int i, Object obj) {
        this.m = 0;
        return super.i(i, obj);
    }

    @Override // defpackage.ug1, java.util.Map
    public final Object put(Object obj, Object obj2) {
        this.m = 0;
        return super.put(obj, obj2);
    }
}
