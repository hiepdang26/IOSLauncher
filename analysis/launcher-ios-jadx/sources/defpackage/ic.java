package defpackage;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public final class ic implements nb1, mu0 {
    public final Resources g;

    public /* synthetic */ ic(Resources resources) {
        this.g = resources;
    }

    @Override // defpackage.nb1
    public eb1 l(eb1 eb1Var, g01 g01Var) {
        if (eb1Var == null) {
            return null;
        }
        return new pc(this.g, eb1Var);
    }

    @Override // defpackage.mu0
    public lu0 s(qm0 qm0Var) {
        return new l9(this.g, qm0Var.b(Uri.class, AssetFileDescriptor.class));
    }
}
