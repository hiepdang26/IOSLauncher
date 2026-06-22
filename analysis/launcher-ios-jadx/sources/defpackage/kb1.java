package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class kb1 implements ib1 {
    public static final e01 b = new e01("com.bumptech.glide.load.resource.bitmap.Downsampler.Theme", null, e01.e);
    public final Context a;

    public kb1(Context context) {
        this.a = context.getApplicationContext();
    }

    @Override // defpackage.ib1
    public final /* bridge */ /* synthetic */ eb1 a(Object obj, int i, int i2, g01 g01Var) {
        return c((Uri) obj, g01Var);
    }

    @Override // defpackage.ib1
    public final boolean b(Object obj, g01 g01Var) {
        String scheme = ((Uri) obj).getScheme();
        return scheme != null && scheme.equals("android.resource");
    }

    public final eb1 c(Uri uri, g01 g01Var) {
        Context contextCreatePackageContext;
        int identifier;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new IllegalStateException("Package name for " + uri + " is null or empty");
        }
        Context context = this.a;
        if (authority.equals(context.getPackageName())) {
            contextCreatePackageContext = context;
        } else {
            try {
                contextCreatePackageContext = context.createPackageContext(authority, 0);
            } catch (PackageManager.NameNotFoundException e) {
                if (!authority.contains(context.getPackageName())) {
                    throw new IllegalArgumentException(k31.l(uri, "Failed to obtain context or unrecognized Uri format for: "), e);
                }
                contextCreatePackageContext = context;
            }
        }
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            List<String> pathSegments2 = uri.getPathSegments();
            String authority2 = uri.getAuthority();
            String str = pathSegments2.get(0);
            String str2 = pathSegments2.get(1);
            identifier = contextCreatePackageContext.getResources().getIdentifier(str2, str, authority2);
            if (identifier == 0) {
                identifier = Resources.getSystem().getIdentifier(str2, str, "android");
            }
            if (identifier == 0) {
                throw new IllegalArgumentException(k31.l(uri, "Failed to find resource id for: "));
            }
        } else {
            if (pathSegments.size() != 1) {
                throw new IllegalArgumentException(k31.l(uri, "Unrecognized Uri format: "));
            }
            try {
                identifier = Integer.parseInt(uri.getPathSegments().get(0));
            } catch (NumberFormatException e2) {
                throw new IllegalArgumentException(k31.l(uri, "Unrecognized Uri format: "), e2);
            }
        }
        Resources.Theme theme = authority.equals(context.getPackageName()) ? (Resources.Theme) g01Var.c(b) : null;
        Drawable drawableK = theme == null ? p02.k(context, contextCreatePackageContext, identifier, null) : p02.k(context, context, identifier, theme);
        if (drawableK != null) {
            return new m80(drawableK, 1);
        }
        return null;
    }
}
