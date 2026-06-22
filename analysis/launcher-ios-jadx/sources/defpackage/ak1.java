package defpackage;

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public final class ak1 implements lu0 {
    public final /* synthetic */ int a;
    public final lu0 b;

    public /* synthetic */ ak1(lu0 lu0Var, int i) {
        this.a = i;
        this.b = lu0Var;
    }

    @Override // defpackage.lu0
    public final /* bridge */ /* synthetic */ boolean a(Object obj) {
        switch (this.a) {
            case 0:
                break;
            default:
                break;
        }
        return true;
    }

    @Override // defpackage.lu0
    public final ku0 b(Object obj, int i, int i2, g01 g01Var) {
        Uri uriFromFile;
        switch (this.a) {
            case 0:
                String str = (String) obj;
                if (TextUtils.isEmpty(str)) {
                    uriFromFile = null;
                } else if (str.charAt(0) == '/') {
                    uriFromFile = Uri.fromFile(new File(str));
                } else {
                    Uri uri = Uri.parse(str);
                    uriFromFile = uri.getScheme() == null ? Uri.fromFile(new File(str)) : uri;
                }
                if (uriFromFile == null) {
                    return null;
                }
                lu0 lu0Var = this.b;
                if (lu0Var.a(uriFromFile)) {
                    return lu0Var.b(uriFromFile, i, i2, g01Var);
                }
                return null;
            default:
                return this.b.b(new x90((URL) obj), i, i2, g01Var);
        }
    }
}
