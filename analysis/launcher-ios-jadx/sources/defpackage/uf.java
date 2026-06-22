package defpackage;

import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class uf implements a40 {
    public final /* synthetic */ int a;
    public final Serializable b;

    public /* synthetic */ uf(Serializable serializable, int i) {
        this.a = i;
        this.b = serializable;
    }

    @Override // defpackage.a40
    public final Object a(c40 c40Var, zk1 zk1Var) throws Throwable {
        switch (this.a) {
            case 0:
                Object objG = m90.g(new qh(c40Var, this, null), zk1Var);
                return objG == hp.g ? objG : zp1.a;
            default:
                a40[] a40VarArr = (a40[]) this.b;
                lk lkVar = new lk(a40VarArr, new w60(a40VarArr, 3), new ry1(3, null), c40Var, null);
                d40 d40Var = new d40(zk1Var.getContext(), zk1Var);
                Object objS = os.s(d40Var, d40Var, lkVar);
                hp hpVar = hp.g;
                zp1 zp1Var = zp1.a;
                if (objS != hpVar) {
                    objS = zp1Var;
                }
                return objS == hpVar ? objS : zp1Var;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(defpackage.v31 r6, defpackage.go r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof defpackage.tf
            if (r0 == 0) goto L13
            r0 = r7
            tf r0 = (defpackage.tf) r0
            int r1 = r0.j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.j = r1
            goto L18
        L13:
            tf r0 = new tf
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.h
            hp r1 = defpackage.hp.g
            int r2 = r0.j
            zp1 r3 = defpackage.zp1.a
            r4 = 1
            if (r2 == 0) goto L33
            if (r2 != r4) goto L2b
            v31 r6 = r0.g
            defpackage.np1.I(r7)
            goto L49
        L2b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L33:
            defpackage.np1.I(r7)
            r0.g = r6
            r0.j = r4
            java.io.Serializable r7 = r5.b
            km r7 = (defpackage.km) r7
            java.lang.Object r7 = r7.d(r6, r0)
            if (r7 != r1) goto L45
            goto L46
        L45:
            r7 = r3
        L46:
            if (r7 != r1) goto L49
            return r1
        L49:
            u31 r6 = (defpackage.u31) r6
            je r6 = r6.j
            boolean r6 = r6.t()
            if (r6 == 0) goto L54
            return r3
        L54:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details."
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.uf.b(v31, go):java.lang.Object");
    }

    public String c() {
        ArrayList arrayList = new ArrayList(4);
        arrayList.add("capacity=-2");
        return getClass().getSimpleName() + '[' + wj.y(arrayList, ", ", null, 62) + ']';
    }

    public String toString() {
        switch (this.a) {
            case 0:
                return "block[" + ((km) this.b) + "] -> " + c();
            default:
                return super.toString();
        }
    }
}
