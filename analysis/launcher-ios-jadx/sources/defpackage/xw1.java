package defpackage;

import java.lang.reflect.InvocationTargetException;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;

/* JADX INFO: loaded from: classes.dex */
public abstract class xw1 {
    public static final yw1 a;

    static {
        yw1 jl1Var;
        try {
            jl1Var = new nx0((WebViewProviderFactoryBoundaryInterface) wd.e(WebViewProviderFactoryBoundaryInterface.class, az1.p()), 29);
        } catch (ClassNotFoundException unused) {
            jl1Var = new jl1(2);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
        a = jl1Var;
    }
}
