package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class pi1 {
    public static final /* synthetic */ int a = 0;

    static {
        Object objE;
        Object objE2;
        Exception exc = new Exception();
        String simpleName = p02.class.getSimpleName();
        StackTraceElement stackTraceElement = exc.getStackTrace()[0];
        new StackTraceElement("_COROUTINE.".concat(simpleName), "_", stackTraceElement.getFileName(), stackTraceElement.getLineNumber());
        try {
            objE = za.class.getCanonicalName();
        } catch (Throwable th) {
            objE = np1.e(th);
        }
        if (yb1.a(objE) != null) {
            objE = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        try {
            objE2 = pi1.class.getCanonicalName();
        } catch (Throwable th2) {
            objE2 = np1.e(th2);
        }
        if (yb1.a(objE2) != null) {
            objE2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
    }
}
