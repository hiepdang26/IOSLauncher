package defpackage;

import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public final class az extends os {
    public final /* synthetic */ os f;
    public final /* synthetic */ ThreadPoolExecutor g;

    public az(os osVar, ThreadPoolExecutor threadPoolExecutor) {
        this.f = osVar;
        this.g = threadPoolExecutor;
    }

    @Override // defpackage.os
    public final void n(Throwable th) {
        ThreadPoolExecutor threadPoolExecutor = this.g;
        try {
            this.f.n(th);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }

    @Override // defpackage.os
    public final void o(hz1 hz1Var) {
        ThreadPoolExecutor threadPoolExecutor = this.g;
        try {
            this.f.o(hz1Var);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
