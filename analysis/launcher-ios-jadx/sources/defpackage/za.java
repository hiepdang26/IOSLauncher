package defpackage;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class za implements eo, ip, Serializable {
    private final eo completion;

    public za(eo eoVar) {
        this.completion = eoVar;
    }

    public eo create(eo eoVar) {
        qg0.l(eoVar, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // defpackage.ip
    public ip getCallerFrame() {
        eo eoVar = this.completion;
        if (eoVar instanceof ip) {
            return (ip) eoVar;
        }
        return null;
    }

    public final eo getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() {
        int iIntValue;
        String strC;
        Method method;
        Object objInvoke;
        Method method2;
        Object objInvoke2;
        ns nsVar = (ns) getClass().getAnnotation(ns.class);
        String str = null;
        if (nsVar == null) {
            return null;
        }
        int iV = nsVar.v();
        if (iV > 1) {
            throw new IllegalStateException(("Debug metadata version mismatch. Expected: 1, got " + iV + ". Please update the Kotlin standard library.").toString());
        }
        try {
            Field declaredField = getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            iIntValue = (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            iIntValue = -1;
        }
        int i = iIntValue >= 0 ? nsVar.l()[iIntValue] : -1;
        s4 s4Var = bf1.e;
        s4 s4Var2 = bf1.d;
        if (s4Var == null) {
            try {
                s4 s4Var3 = new s4(Class.class.getDeclaredMethod("getModule", null), getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null));
                bf1.e = s4Var3;
                s4Var = s4Var3;
            } catch (Exception unused2) {
                bf1.e = s4Var2;
                s4Var = s4Var2;
            }
        }
        if (s4Var != s4Var2 && (method = s4Var.a) != null && (objInvoke = method.invoke(getClass(), null)) != null && (method2 = s4Var.b) != null && (objInvoke2 = method2.invoke(objInvoke, null)) != null) {
            Method method3 = s4Var.c;
            Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, null) : null;
            if (objInvoke3 instanceof String) {
                str = (String) objInvoke3;
            }
        }
        if (str == null) {
            strC = nsVar.c();
        } else {
            strC = str + '/' + nsVar.c();
        }
        return new StackTraceElement(strC, nsVar.m(), nsVar.f(), i);
    }

    public abstract Object invokeSuspend(Object obj);

    @Override // defpackage.eo
    public final void resumeWith(Object obj) {
        eo eoVar = this;
        while (true) {
            za zaVar = (za) eoVar;
            eo eoVar2 = zaVar.completion;
            qg0.h(eoVar2);
            try {
                obj = zaVar.invokeSuspend(obj);
                if (obj == hp.g) {
                    return;
                }
            } catch (Throwable th) {
                obj = np1.e(th);
            }
            zaVar.releaseIntercepted();
            if (!(eoVar2 instanceof za)) {
                eoVar2.resumeWith(obj);
                return;
            }
            eoVar = eoVar2;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    public eo create(Object obj, eo eoVar) {
        qg0.l(eoVar, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public void releaseIntercepted() {
    }
}
