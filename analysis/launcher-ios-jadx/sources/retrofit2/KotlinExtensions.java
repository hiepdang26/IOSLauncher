package retrofit2;

import androidx.appcompat.widget.RtlSpacingHelper;
import defpackage.e42;
import defpackage.eo;
import defpackage.gg;
import defpackage.gj0;
import defpackage.go;
import defpackage.np1;
import defpackage.ns;
import defpackage.qg0;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class KotlinExtensions {

    /* JADX INFO: renamed from: retrofit2.KotlinExtensions$suspendAndThrow$1, reason: invalid class name */
    @ns(c = "retrofit2.KotlinExtensions", f = "KotlinExtensions.kt", l = {113}, m = "suspendAndThrow")
    public static final class AnonymousClass1 extends go {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(eo eoVar) {
            super(eoVar);
        }

        @Override // defpackage.za
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return KotlinExtensions.suspendAndThrow(null, this);
        }
    }

    public static final <T> Object await(Call<T> call, eo eoVar) throws IllegalAccessException, InvocationTargetException {
        final gg ggVar = new gg(1, e42.d(eoVar));
        ggVar.q(new KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$1(call));
        call.enqueue(new Callback<T>() { // from class: retrofit2.KotlinExtensions$await$2$2
            @Override // retrofit2.Callback
            public void onFailure(Call<T> call2, Throwable th) {
                qg0.m(call2, "call");
                qg0.m(th, "t");
                ((gg) ggVar).resumeWith(np1.e(th));
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<T> call2, Response<T> response) {
                qg0.m(call2, "call");
                qg0.m(response, "response");
                if (!response.isSuccessful()) {
                    ((gg) ggVar).resumeWith(np1.e(new HttpException(response)));
                    return;
                }
                T tBody = response.body();
                if (tBody != null) {
                    ((gg) ggVar).resumeWith(tBody);
                    return;
                }
                Object objCast = Invocation.class.cast(call2.request().e.get(Invocation.class));
                if (objCast == null) {
                    gj0 gj0Var = new gj0();
                    qg0.G(gj0Var, qg0.class.getName());
                    throw gj0Var;
                }
                Method method = ((Invocation) objCast).method();
                StringBuilder sb = new StringBuilder("Response from ");
                qg0.g(method, "method");
                Class<?> declaringClass = method.getDeclaringClass();
                qg0.g(declaringClass, "method.declaringClass");
                sb.append(declaringClass.getName());
                sb.append('.');
                sb.append(method.getName());
                sb.append(" was null but response body type was declared as non-null");
                gj0 gj0Var2 = new gj0(sb.toString());
                ((gg) ggVar).resumeWith(np1.e(gj0Var2));
            }
        });
        return ggVar.n();
    }

    public static final <T> Object awaitNullable(Call<T> call, eo eoVar) throws IllegalAccessException, InvocationTargetException {
        final gg ggVar = new gg(1, e42.d(eoVar));
        ggVar.q(new KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2(call));
        call.enqueue(new Callback<T>() { // from class: retrofit2.KotlinExtensions$await$4$2
            @Override // retrofit2.Callback
            public void onFailure(Call<T> call2, Throwable th) {
                qg0.m(call2, "call");
                qg0.m(th, "t");
                ((gg) ggVar).resumeWith(np1.e(th));
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<T> call2, Response<T> response) {
                qg0.m(call2, "call");
                qg0.m(response, "response");
                if (response.isSuccessful()) {
                    ((gg) ggVar).resumeWith(response.body());
                } else {
                    ((gg) ggVar).resumeWith(np1.e(new HttpException(response)));
                }
            }
        });
        return ggVar.n();
    }

    public static final <T> Object awaitResponse(Call<T> call, eo eoVar) throws IllegalAccessException, InvocationTargetException {
        final gg ggVar = new gg(1, e42.d(eoVar));
        ggVar.q(new KotlinExtensions$awaitResponse$$inlined$suspendCancellableCoroutine$lambda$1(call));
        call.enqueue(new Callback<T>() { // from class: retrofit2.KotlinExtensions$awaitResponse$2$2
            @Override // retrofit2.Callback
            public void onFailure(Call<T> call2, Throwable th) {
                qg0.m(call2, "call");
                qg0.m(th, "t");
                ((gg) ggVar).resumeWith(np1.e(th));
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<T> call2, Response<T> response) {
                qg0.m(call2, "call");
                qg0.m(response, "response");
                ggVar.resumeWith(response);
            }
        });
        return ggVar.n();
    }

    public static final <T> T create(Retrofit retrofit) {
        qg0.m(retrofit, "$this$create");
        throw new UnsupportedOperationException("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object suspendAndThrow(final java.lang.Exception r4, defpackage.eo r5) {
        /*
            boolean r0 = r5 instanceof retrofit2.KotlinExtensions.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r5
            retrofit2.KotlinExtensions$suspendAndThrow$1 r0 = (retrofit2.KotlinExtensions.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            retrofit2.KotlinExtensions$suspendAndThrow$1 r0 = new retrofit2.KotlinExtensions$suspendAndThrow$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            hp r1 = defpackage.hp.g
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            java.lang.Exception r4 = (java.lang.Exception) r4
            defpackage.np1.I(r5)
            zp1 r4 = defpackage.zp1.a
            return r4
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            defpackage.np1.I(r5)
            r0.L$0 = r4
            r0.label = r3
            xt r5 = defpackage.aw.a
            yo r2 = r0.getContext()
            retrofit2.KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1 r3 = new retrofit2.KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1
            r3.<init>()
            r5.z(r2, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit2.KotlinExtensions.suspendAndThrow(java.lang.Exception, eo):java.lang.Object");
    }
}
