package retrofit2;

import retrofit2.DefaultCallAdapterFactory;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 h;
    public final /* synthetic */ Callback i;
    public final /* synthetic */ Object j;

    public /* synthetic */ a(DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 anonymousClass1, Callback callback, Object obj, int i) {
        this.g = i;
        this.h = anonymousClass1;
        this.i = callback;
        this.j = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                this.h.lambda$onResponse$0(this.i, (Response) this.j);
                break;
            default:
                this.h.lambda$onFailure$1(this.i, (Throwable) this.j);
                break;
        }
    }
}
