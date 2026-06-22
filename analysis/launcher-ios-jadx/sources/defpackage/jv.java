package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class jv implements mu0, lv {
    public final /* synthetic */ int g;
    public final Context h;

    public /* synthetic */ jv(Context context, int i) {
        this.g = i;
        this.h = context;
    }

    @Override // defpackage.lv
    public Class a() {
        return Drawable.class;
    }

    @Override // defpackage.lv
    public /* bridge */ /* synthetic */ void b(Object obj) {
    }

    @Override // defpackage.lv
    public Object c(int i, Resources.Theme theme, Resources resources) {
        Context context = this.h;
        return p02.k(context, context, i, theme);
    }

    @Override // defpackage.mu0
    public final lu0 s(qm0 qm0Var) {
        switch (this.g) {
            case 0:
                return new l9(this.h, this);
            case 1:
                return new js0(this.h, 1);
            default:
                return new l9(this.h, qm0Var.b(Integer.class, InputStream.class));
        }
    }
}
