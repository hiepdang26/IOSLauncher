package defpackage;

import androidx.lifecycle.a;

/* JADX INFO: loaded from: classes.dex */
public final class gn0 implements cn0 {
    public final /* synthetic */ a g;
    public final /* synthetic */ com.bumptech.glide.manager.a h;

    public gn0(com.bumptech.glide.manager.a aVar, a aVar2) {
        this.h = aVar;
        this.g = aVar2;
    }

    @Override // defpackage.cn0
    public final void onDestroy() {
        this.h.a.remove(this.g);
    }

    @Override // defpackage.cn0
    public final void b() {
    }

    @Override // defpackage.cn0
    public final void j() {
    }
}
