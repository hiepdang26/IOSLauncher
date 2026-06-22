package defpackage;

import android.content.pm.PackageManager;
import android.content.pm.Signature;

/* JADX INFO: loaded from: classes.dex */
public final class xs extends iy {
    @Override // defpackage.iy
    public final Signature[] p(PackageManager packageManager, String str) {
        return packageManager.getPackageInfo(str, 64).signatures;
    }
}
