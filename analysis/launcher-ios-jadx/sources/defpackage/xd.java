package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class xd implements mg0 {
    public final /* synthetic */ int a;
    public final Object b;

    public /* synthetic */ xd(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:149:0x0245, code lost:
    
        return r13;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0222 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0102 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x013d  */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3, types: [g10, java.io.IOException] */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r20v1, types: [javax.net.ssl.SSLSocketFactory] */
    /* JADX WARN: Type inference failed for: r20v2 */
    /* JADX WARN: Type inference failed for: r20v3 */
    /* JADX WARN: Type inference failed for: r21v0 */
    /* JADX WARN: Type inference failed for: r21v1, types: [hy0] */
    /* JADX WARN: Type inference failed for: r21v2 */
    /* JADX WARN: Type inference failed for: r21v3 */
    /* JADX WARN: Type inference failed for: r22v0 */
    /* JADX WARN: Type inference failed for: r22v1, types: [fh] */
    /* JADX WARN: Type inference failed for: r22v2 */
    /* JADX WARN: Type inference failed for: r28v0, types: [xd] */
    /* JADX WARN: Type inference failed for: r29v0, types: [g81] */
    /* JADX WARN: Type inference failed for: r6v10, types: [hp1] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // defpackage.mg0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.tb1 a(defpackage.g81 r29) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1032
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xd.a(g81):tb1");
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0042 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean b(java.io.IOException r3, defpackage.hp1 r4, boolean r5, defpackage.ia1 r6) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.b
            iy0 r0 = (defpackage.iy0) r0
            boolean r0 = r0.z
            r1 = 0
            if (r0 != 0) goto La
            goto L51
        La:
            if (r5 == 0) goto L1b
            la1 r6 = r6.d
            if (r6 == 0) goto L16
            boolean r6 = r6.isOneShot()
            if (r6 != 0) goto L51
        L16:
            boolean r6 = r3 instanceof java.io.FileNotFoundException
            if (r6 == 0) goto L1b
            return r1
        L1b:
            boolean r6 = r3 instanceof java.net.ProtocolException
            if (r6 == 0) goto L20
            return r1
        L20:
            boolean r6 = r3 instanceof java.io.InterruptedIOException
            if (r6 == 0) goto L2b
            boolean r3 = r3 instanceof java.net.SocketTimeoutException
            if (r3 == 0) goto L51
            if (r5 != 0) goto L51
            goto L3d
        L2b:
            boolean r5 = r3 instanceof javax.net.ssl.SSLHandshakeException
            if (r5 == 0) goto L38
            java.lang.Throwable r5 = r3.getCause()
            boolean r5 = r5 instanceof java.security.cert.CertificateException
            if (r5 == 0) goto L38
            goto L51
        L38:
            boolean r3 = r3 instanceof javax.net.ssl.SSLPeerUnverifiedException
            if (r3 == 0) goto L3d
            return r1
        L3d:
            g10 r3 = r4.h
            f81 r5 = r3.c
            monitor-enter(r5)
            boolean r3 = r3.h     // Catch: java.lang.Throwable -> L52
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L52
            if (r3 == 0) goto L51
            g10 r3 = r4.h
            boolean r3 = r3.c()
            if (r3 == 0) goto L51
            r3 = 1
            return r3
        L51:
            return r1
        L52:
            r3 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L52
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xd.b(java.io.IOException, hp1, boolean, ia1):boolean");
    }
}
