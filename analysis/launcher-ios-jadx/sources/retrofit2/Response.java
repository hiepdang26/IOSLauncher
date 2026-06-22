package retrofit2;

import defpackage.ga1;
import defpackage.k31;
import defpackage.ob0;
import defpackage.sb1;
import defpackage.tb1;
import defpackage.vb1;
import defpackage.z31;
import java.util.Objects;
import retrofit2.OkHttpCall;

/* JADX INFO: loaded from: classes.dex */
public final class Response<T> {
    private final T body;
    private final vb1 errorBody;
    private final tb1 rawResponse;

    private Response(tb1 tb1Var, T t, vb1 vb1Var) {
        this.rawResponse = tb1Var;
        this.body = t;
        this.errorBody = vb1Var;
    }

    public static <T> Response<T> error(int i, vb1 vb1Var) {
        Objects.requireNonNull(vb1Var, "body == null");
        if (i < 400) {
            throw new IllegalArgumentException(k31.k(i, "code < 400: "));
        }
        sb1 sb1Var = new sb1();
        sb1Var.g = new OkHttpCall.NoContentResponseBody(vb1Var.contentType(), vb1Var.contentLength());
        sb1Var.c = i;
        sb1Var.d = "Response.error()";
        sb1Var.b = z31.HTTP_1_1;
        ga1 ga1Var = new ga1();
        ga1Var.e();
        sb1Var.a = ga1Var.a();
        return error(vb1Var, sb1Var.a());
    }

    public static <T> Response<T> success(T t) {
        sb1 sb1Var = new sb1();
        sb1Var.c = 200;
        sb1Var.d = "OK";
        sb1Var.b = z31.HTTP_1_1;
        ga1 ga1Var = new ga1();
        ga1Var.e();
        sb1Var.a = ga1Var.a();
        return success(t, sb1Var.a());
    }

    public T body() {
        return this.body;
    }

    public int code() {
        return this.rawResponse.i;
    }

    public vb1 errorBody() {
        return this.errorBody;
    }

    public ob0 headers() {
        return this.rawResponse.l;
    }

    public boolean isSuccessful() {
        int i = this.rawResponse.i;
        return i >= 200 && i < 300;
    }

    public String message() {
        return this.rawResponse.j;
    }

    public tb1 raw() {
        return this.rawResponse;
    }

    public String toString() {
        return this.rawResponse.toString();
    }

    public static <T> Response<T> success(int i, T t) {
        if (i >= 200 && i < 300) {
            sb1 sb1Var = new sb1();
            sb1Var.c = i;
            sb1Var.d = "Response.success()";
            sb1Var.b = z31.HTTP_1_1;
            ga1 ga1Var = new ga1();
            ga1Var.e();
            sb1Var.a = ga1Var.a();
            return success(t, sb1Var.a());
        }
        throw new IllegalArgumentException(k31.k(i, "code < 200 or >= 300: "));
    }

    public static <T> Response<T> error(vb1 vb1Var, tb1 tb1Var) {
        Objects.requireNonNull(vb1Var, "body == null");
        Objects.requireNonNull(tb1Var, "rawResponse == null");
        int i = tb1Var.i;
        if (i >= 200 && i < 300) {
            throw new IllegalArgumentException("rawResponse should not be successful response");
        }
        return new Response<>(tb1Var, null, vb1Var);
    }

    public static <T> Response<T> success(T t, ob0 ob0Var) {
        Objects.requireNonNull(ob0Var, "headers == null");
        sb1 sb1Var = new sb1();
        sb1Var.c = 200;
        sb1Var.d = "OK";
        sb1Var.b = z31.HTTP_1_1;
        sb1Var.f = ob0Var.e();
        ga1 ga1Var = new ga1();
        ga1Var.e();
        sb1Var.a = ga1Var.a();
        return success(t, sb1Var.a());
    }

    public static <T> Response<T> success(T t, tb1 tb1Var) {
        Objects.requireNonNull(tb1Var, "rawResponse == null");
        int i = tb1Var.i;
        if (i >= 200 && i < 300) {
            return new Response<>(tb1Var, t, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }
}
