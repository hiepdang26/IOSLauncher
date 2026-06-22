package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class u91 {
    public static final v91 a;

    static {
        v91 v91Var = null;
        try {
            v91Var = (v91) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (v91Var == null) {
            v91Var = new v91();
        }
        a = v91Var;
    }
}
