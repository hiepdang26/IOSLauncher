package retrofit2;

import defpackage.jj0;
import defpackage.o70;
import defpackage.zp1;

/* JADX INFO: loaded from: classes.dex */
public final class KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$1 extends jj0 implements o70 {
    final /* synthetic */ Call $this_await$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$1(Call call) {
        super(1);
        this.$this_await$inlined = call;
    }

    @Override // defpackage.o70
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return zp1.a;
    }

    public final void invoke(Throwable th) {
        this.$this_await$inlined.cancel();
    }
}
