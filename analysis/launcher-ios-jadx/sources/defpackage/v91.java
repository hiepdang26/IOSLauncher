package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class v91 {
    public static String a(z70 z70Var) {
        String string = z70Var.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring(21) : string;
    }
}
