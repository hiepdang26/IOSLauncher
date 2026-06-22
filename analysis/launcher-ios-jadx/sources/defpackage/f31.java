package defpackage;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public final class f31 extends o91 {
    public final RecyclerView l;
    public final n91 m;
    public final yh n;

    public f31(RecyclerView recyclerView) {
        super(recyclerView);
        this.m = this.k;
        this.n = new yh(this, 4);
        this.l = recyclerView;
    }

    @Override // defpackage.o91
    public final e0 j() {
        return this.n;
    }
}
