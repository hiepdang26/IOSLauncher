package defpackage;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class iv implements mu0, lv, w90 {
    public final /* synthetic */ int g;
    public final Context h;

    public /* synthetic */ iv(Context context, int i) {
        this.g = i;
        this.h = context;
    }

    @Override // defpackage.lv
    public Class a() {
        return AssetFileDescriptor.class;
    }

    @Override // defpackage.lv
    public void b(Object obj) throws IOException {
        ((AssetFileDescriptor) obj).close();
    }

    @Override // defpackage.lv
    public Object c(int i, Resources.Theme theme, Resources resources) {
        return resources.openRawResourceFd(i);
    }

    @Override // defpackage.w90
    public Object get() {
        return (ConnectivityManager) this.h.getSystemService("connectivity");
    }

    @Override // defpackage.mu0
    public lu0 s(qm0 qm0Var) {
        switch (this.g) {
            case 0:
                return new l9(this.h, this);
            case 1:
                return new js0(this.h, 0);
            default:
                return new l9(this.h, qm0Var.b(Integer.class, AssetFileDescriptor.class));
        }
    }
}
