package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class lk extends zk1 implements s70 {
    public ph h;
    public byte[] i;
    public int j;
    public int k;
    public int l;
    public /* synthetic */ Object m;
    public final /* synthetic */ a40[] n;
    public final /* synthetic */ w60 o;
    public final /* synthetic */ ry1 p;
    public final /* synthetic */ c40 q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lk(a40[] a40VarArr, w60 w60Var, ry1 ry1Var, c40 c40Var, eo eoVar) {
        super(2, eoVar);
        this.n = a40VarArr;
        this.o = w60Var;
        this.p = ry1Var;
        this.q = c40Var;
    }

    @Override // defpackage.za
    public final eo create(Object obj, eo eoVar) {
        ry1 ry1Var = this.p;
        c40 c40Var = this.q;
        lk lkVar = new lk(this.n, this.o, ry1Var, c40Var, eoVar);
        lkVar.m = obj;
        return lkVar;
    }

    @Override // defpackage.s70
    public final Object d(Object obj, Object obj2) {
        return ((lk) create((gp) obj, (eo) obj2)).invokeSuspend(zp1.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0078, code lost:
    
        if (r8 != 0) goto L20;
     */
    /* JADX WARN: Path cross not found for [B:41:0x00ba, B:35:0x00a9], limit reached: 44 */
    /* JADX WARN: Path cross not found for [B:42:0x00bc, B:20:0x0078], limit reached: 44 */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0099 A[LOOP:0: B:30:0x0099->B:47:?, LOOP_START, PHI: r8 r12
  0x0099: PHI (r8v3 int) = (r8v2 int), (r8v4 int) binds: [B:28:0x0096, B:47:?] A[DONT_GENERATE, DONT_INLINE]
  0x0099: PHI (r12v4 ff0) = (r12v3 ff0), (r12v10 ff0) binds: [B:28:0x0096, B:47:?] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00e4 -> B:20:0x0078). Please report as a decompilation issue!!! */
    @Override // defpackage.za
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            Method dump skipped, instruction units count: 231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.lk.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
