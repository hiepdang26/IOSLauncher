package defpackage;

import android.content.pm.PackageInfo;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class uw1 extends y5 {
    public final Pattern d;

    public uw1() {
        super("ALGORITHMIC_DARKENING", "ALGORITHMIC_DARKENING");
        this.d = Pattern.compile("\\A\\d+");
    }

    @Override // defpackage.y5
    public final boolean a() {
        return Build.VERSION.SDK_INT >= 33;
    }

    @Override // defpackage.y5
    public final boolean b() {
        int i;
        PackageInfo packageInfoA;
        boolean zB = super.b();
        if (!zB || (i = Build.VERSION.SDK_INT) >= 29) {
            return zB;
        }
        int i2 = tw1.a;
        if (i >= 26) {
            packageInfoA = z5.a();
        } else {
            try {
                packageInfoA = tw1.a();
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                packageInfoA = null;
            }
        }
        if (packageInfoA == null) {
            return false;
        }
        Matcher matcher = this.d.matcher(packageInfoA.versionName);
        return matcher.find() && Integer.parseInt(packageInfoA.versionName.substring(matcher.start(), matcher.end())) >= 105;
    }
}
