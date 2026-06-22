package defpackage;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
public final class gb1 implements bj0 {
    public static final fq0 j = new fq0(50);
    public final cq0 b;
    public final bj0 c;
    public final bj0 d;
    public final int e;
    public final int f;
    public final Class g;
    public final g01 h;
    public final ro1 i;

    public gb1(cq0 cq0Var, bj0 bj0Var, bj0 bj0Var2, int i, int i2, ro1 ro1Var, Class cls, g01 g01Var) {
        this.b = cq0Var;
        this.c = bj0Var;
        this.d = bj0Var2;
        this.e = i;
        this.f = i2;
        this.i = ro1Var;
        this.g = cls;
        this.h = g01Var;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // defpackage.bj0
    public final void b(MessageDigest messageDigest) {
        Object objF;
        cq0 cq0Var = this.b;
        synchronized (cq0Var) {
            bq0 bq0Var = cq0Var.b;
            g21 g21VarD = (g21) ((ArrayDeque) bq0Var.g).poll();
            if (g21VarD == null) {
                g21VarD = bq0Var.d();
            }
            aq0 aq0Var = (aq0) g21VarD;
            aq0Var.b = 8;
            aq0Var.c = byte[].class;
            objF = cq0Var.f(aq0Var, byte[].class);
        }
        byte[] bArr = (byte[]) objF;
        ByteBuffer.wrap(bArr).putInt(this.e).putInt(this.f).array();
        this.d.b(messageDigest);
        this.c.b(messageDigest);
        messageDigest.update(bArr);
        ro1 ro1Var = this.i;
        if (ro1Var != null) {
            ro1Var.b(messageDigest);
        }
        this.h.b(messageDigest);
        fq0 fq0Var = j;
        Class cls = this.g;
        byte[] bytes = (byte[]) fq0Var.a(cls);
        if (bytes == null) {
            bytes = cls.getName().getBytes(bj0.a);
            fq0Var.d(cls, bytes);
        }
        messageDigest.update(bytes);
        this.b.h(bArr);
    }

    @Override // defpackage.bj0
    public final boolean equals(Object obj) {
        if (obj instanceof gb1) {
            gb1 gb1Var = (gb1) obj;
            if (this.f == gb1Var.f && this.e == gb1Var.e && vq1.b(this.i, gb1Var.i) && this.g.equals(gb1Var.g) && this.c.equals(gb1Var.c) && this.d.equals(gb1Var.d) && this.h.equals(gb1Var.h)) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.bj0
    public final int hashCode() {
        int iHashCode = ((((this.d.hashCode() + (this.c.hashCode() * 31)) * 31) + this.e) * 31) + this.f;
        ro1 ro1Var = this.i;
        if (ro1Var != null) {
            iHashCode = (iHashCode * 31) + ro1Var.hashCode();
        }
        return this.h.b.hashCode() + ((this.g.hashCode() + (iHashCode * 31)) * 31);
    }

    public final String toString() {
        return "ResourceCacheKey{sourceKey=" + this.c + ", signature=" + this.d + ", width=" + this.e + ", height=" + this.f + ", decodedResourceClass=" + this.g + ", transformation='" + this.i + "', options=" + this.h + '}';
    }
}
