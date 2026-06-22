package retrofit2;

import defpackage.b81;
import defpackage.d81;
import defpackage.fe;
import defpackage.hp1;
import defpackage.ia1;
import defpackage.iy0;
import defpackage.jy0;
import defpackage.ks0;
import defpackage.nf;
import defpackage.oe;
import defpackage.of;
import defpackage.rf;
import defpackage.s50;
import defpackage.sb1;
import defpackage.tb1;
import defpackage.vb1;
import defpackage.yn1;
import java.io.IOException;
import java.util.Objects;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
final class OkHttpCall<T> implements Call<T> {
    private final Object[] args;
    private final nf callFactory;
    private volatile boolean canceled;
    private Throwable creationFailure;
    private boolean executed;
    private of rawCall;
    private final RequestFactory requestFactory;
    private final Converter<vb1, T> responseConverter;

    public static final class ExceptionCatchingResponseBody extends vb1 {
        private final vb1 delegate;
        private final oe delegateSource;
        IOException thrownException;

        public ExceptionCatchingResponseBody(vb1 vb1Var) {
            this.delegate = vb1Var;
            s50 s50Var = new s50(vb1Var.source()) { // from class: retrofit2.OkHttpCall.ExceptionCatchingResponseBody.1
                @Override // defpackage.s50, defpackage.fi1
                public long read(fe feVar, long j) throws IOException {
                    try {
                        return super.read(feVar, j);
                    } catch (IOException e) {
                        ExceptionCatchingResponseBody.this.thrownException = e;
                        throw e;
                    }
                }
            };
            Logger logger = jy0.a;
            this.delegateSource = new b81(s50Var);
        }

        @Override // defpackage.vb1, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.delegate.close();
        }

        @Override // defpackage.vb1
        public long contentLength() {
            return this.delegate.contentLength();
        }

        @Override // defpackage.vb1
        public ks0 contentType() {
            return this.delegate.contentType();
        }

        @Override // defpackage.vb1
        public oe source() {
            return this.delegateSource;
        }

        public void throwIfCaught() throws IOException {
            IOException iOException = this.thrownException;
            if (iOException != null) {
                throw iOException;
            }
        }
    }

    public static final class NoContentResponseBody extends vb1 {
        private final long contentLength;
        private final ks0 contentType;

        public NoContentResponseBody(ks0 ks0Var, long j) {
            this.contentType = ks0Var;
            this.contentLength = j;
        }

        @Override // defpackage.vb1
        public long contentLength() {
            return this.contentLength;
        }

        @Override // defpackage.vb1
        public ks0 contentType() {
            return this.contentType;
        }

        @Override // defpackage.vb1
        public oe source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    public OkHttpCall(RequestFactory requestFactory, Object[] objArr, nf nfVar, Converter<vb1, T> converter) {
        this.requestFactory = requestFactory;
        this.args = objArr;
        this.callFactory = nfVar;
        this.responseConverter = converter;
    }

    private of createRawCall() {
        nf nfVar = this.callFactory;
        ia1 ia1VarCreate = this.requestFactory.create(this.args);
        iy0 iy0Var = (iy0) nfVar;
        iy0Var.getClass();
        d81 d81Var = new d81(iy0Var, ia1VarCreate);
        d81Var.h = new hp1(iy0Var, d81Var);
        return d81Var;
    }

    private of getRawCall() throws IOException {
        of ofVar = this.rawCall;
        if (ofVar != null) {
            return ofVar;
        }
        Throwable th = this.creationFailure;
        if (th != null) {
            if (th instanceof IOException) {
                throw ((IOException) th);
            }
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            throw ((Error) th);
        }
        try {
            of ofVarCreateRawCall = createRawCall();
            this.rawCall = ofVarCreateRawCall;
            return ofVarCreateRawCall;
        } catch (IOException | Error | RuntimeException e) {
            Utils.throwIfFatal(e);
            this.creationFailure = e;
            throw e;
        }
    }

    @Override // retrofit2.Call
    public void cancel() {
        of ofVar;
        this.canceled = true;
        synchronized (this) {
            ofVar = this.rawCall;
        }
        if (ofVar != null) {
            ((d81) ofVar).h.a();
        }
    }

    @Override // retrofit2.Call
    public void enqueue(final Callback<T> callback) {
        of ofVar;
        Throwable th;
        Objects.requireNonNull(callback, "callback == null");
        synchronized (this) {
            try {
                if (this.executed) {
                    throw new IllegalStateException("Already executed.");
                }
                this.executed = true;
                ofVar = this.rawCall;
                th = this.creationFailure;
                if (ofVar == null && th == null) {
                    try {
                        of ofVarCreateRawCall = createRawCall();
                        this.rawCall = ofVarCreateRawCall;
                        ofVar = ofVarCreateRawCall;
                    } catch (Throwable th2) {
                        th = th2;
                        Utils.throwIfFatal(th);
                        this.creationFailure = th;
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        if (th != null) {
            callback.onFailure(this, th);
            return;
        }
        if (this.canceled) {
            ((d81) ofVar).h.a();
        }
        ((d81) ofVar).a(new rf() { // from class: retrofit2.OkHttpCall.1
            private void callFailure(Throwable th4) {
                try {
                    callback.onFailure(OkHttpCall.this, th4);
                } catch (Throwable th5) {
                    Utils.throwIfFatal(th5);
                    th5.printStackTrace();
                }
            }

            @Override // defpackage.rf
            public void onFailure(of ofVar2, IOException iOException) {
                callFailure(iOException);
            }

            @Override // defpackage.rf
            public void onResponse(of ofVar2, tb1 tb1Var) {
                try {
                    try {
                        callback.onResponse(OkHttpCall.this, OkHttpCall.this.parseResponse(tb1Var));
                    } catch (Throwable th4) {
                        Utils.throwIfFatal(th4);
                        th4.printStackTrace();
                    }
                } catch (Throwable th5) {
                    Utils.throwIfFatal(th5);
                    callFailure(th5);
                }
            }
        });
    }

    @Override // retrofit2.Call
    public Response<T> execute() {
        of rawCall;
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already executed.");
            }
            this.executed = true;
            rawCall = getRawCall();
        }
        if (this.canceled) {
            ((d81) rawCall).h.a();
        }
        return parseResponse(((d81) rawCall).b());
    }

    @Override // retrofit2.Call
    public boolean isCanceled() {
        boolean z = true;
        if (this.canceled) {
            return true;
        }
        synchronized (this) {
            of ofVar = this.rawCall;
            if (ofVar == null || !((d81) ofVar).h.d()) {
                z = false;
            }
        }
        return z;
    }

    @Override // retrofit2.Call
    public synchronized boolean isExecuted() {
        return this.executed;
    }

    public Response<T> parseResponse(tb1 tb1Var) throws IOException {
        vb1 vb1Var = tb1Var.m;
        sb1 sb1VarB = tb1Var.b();
        sb1VarB.g = new NoContentResponseBody(vb1Var.contentType(), vb1Var.contentLength());
        tb1 tb1VarA = sb1VarB.a();
        int i = tb1VarA.i;
        if (i < 200 || i >= 300) {
            try {
                return Response.error(Utils.buffer(vb1Var), tb1VarA);
            } finally {
                vb1Var.close();
            }
        }
        if (i == 204 || i == 205) {
            vb1Var.close();
            return Response.success((Object) null, tb1VarA);
        }
        ExceptionCatchingResponseBody exceptionCatchingResponseBody = new ExceptionCatchingResponseBody(vb1Var);
        try {
            return Response.success(this.responseConverter.convert(exceptionCatchingResponseBody), tb1VarA);
        } catch (RuntimeException e) {
            exceptionCatchingResponseBody.throwIfCaught();
            throw e;
        }
    }

    @Override // retrofit2.Call
    public synchronized ia1 request() {
        try {
        } catch (IOException e) {
            throw new RuntimeException("Unable to create request.", e);
        }
        return ((d81) getRawCall()).i;
    }

    @Override // retrofit2.Call
    public synchronized yn1 timeout() {
        try {
        } catch (IOException e) {
            throw new RuntimeException("Unable to create call.", e);
        }
        return ((d81) getRawCall()).h.e;
    }

    @Override // retrofit2.Call
    public OkHttpCall<T> clone() {
        return new OkHttpCall<>(this.requestFactory, this.args, this.callFactory, this.responseConverter);
    }
}
