package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Binder;
import android.os.Process;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class f1 implements mu0, lv {
    public final /* synthetic */ int g;
    public Context h;

    public /* synthetic */ f1() {
        this.g = 0;
    }

    public static f1 d(Context context) {
        f1 f1Var = new f1();
        f1Var.h = context;
        return f1Var;
    }

    @Override // defpackage.lv
    public Class a() {
        return InputStream.class;
    }

    @Override // defpackage.lv
    public void b(Object obj) throws IOException {
        ((InputStream) obj).close();
    }

    @Override // defpackage.lv
    public Object c(int i, Resources.Theme theme, Resources resources) {
        return resources.openRawResource(i);
    }

    public ApplicationInfo e(int i, String str) {
        return this.h.getPackageManager().getApplicationInfo(str, i);
    }

    public int f() {
        Configuration configuration = this.h.getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i2 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i > 600) {
            return 5;
        }
        if (i > 960 && i2 > 720) {
            return 5;
        }
        if (i > 720 && i2 > 960) {
            return 5;
        }
        if (i >= 500) {
            return 4;
        }
        if (i > 640 && i2 > 480) {
            return 4;
        }
        if (i <= 480 || i2 <= 640) {
            return i >= 360 ? 3 : 2;
        }
        return 4;
    }

    public PackageInfo g(int i, String str) {
        return this.h.getPackageManager().getPackageInfo(str, i);
    }

    public int h() {
        int[] iArr = q71.ActionBar;
        int i = r41.actionBarStyle;
        Context context = this.h;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, iArr, i, 0);
        int layoutDimension = typedArrayObtainStyledAttributes.getLayoutDimension(q71.ActionBar_height, 0);
        Resources resources = context.getResources();
        if (!this.h.getResources().getBoolean(u41.abc_action_bar_embed_tabs)) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(f51.abc_action_bar_stacked_max_height));
        }
        typedArrayObtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean i() {
        String nameForUid;
        int callingUid = Binder.getCallingUid();
        int iMyUid = Process.myUid();
        Context context = this.h;
        if (callingUid == iMyUid) {
            return hg0.s(context);
        }
        if (!os.j() || (nameForUid = context.getPackageManager().getNameForUid(Binder.getCallingUid())) == null) {
            return false;
        }
        return context.getPackageManager().isInstantApp(nameForUid);
    }

    @Override // defpackage.mu0
    public lu0 s(qm0 qm0Var) {
        switch (this.g) {
            case 1:
                return new l9(this.h, this);
            default:
                return new js0(this.h, 2);
        }
    }

    public /* synthetic */ f1(Context context, int i) {
        this.g = i;
        this.h = context;
    }
}
