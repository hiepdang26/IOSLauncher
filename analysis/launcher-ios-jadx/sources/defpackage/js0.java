package defpackage;

import android.content.Context;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public final class js0 implements lu0 {
    public final /* synthetic */ int a;
    public final Context b;

    public js0(Context context, int i) {
        this.a = i;
        switch (i) {
            case 1:
                this.b = context.getApplicationContext();
                break;
            case 2:
                this.b = context.getApplicationContext();
                break;
            default:
                this.b = context;
                break;
        }
    }

    @Override // defpackage.lu0
    public final boolean a(Object obj) {
        switch (this.a) {
            case 0:
                return e42.i((Uri) obj);
            case 1:
                Uri uri = (Uri) obj;
                return e42.i(uri) && !uri.getPathSegments().contains("video");
            default:
                Uri uri2 = (Uri) obj;
                return e42.i(uri2) && uri2.getPathSegments().contains("video");
        }
    }

    @Override // defpackage.lu0
    public final ku0 b(Object obj, int i, int i2, g01 g01Var) {
        Long l;
        switch (this.a) {
            case 0:
                Uri uri = (Uri) obj;
                return new ku0(new fy0(uri), new is0(this.b, uri, 0));
            case 1:
                Uri uri2 = (Uri) obj;
                if (i == Integer.MIN_VALUE || i2 == Integer.MIN_VALUE || i > 512 || i2 > 384) {
                    return null;
                }
                fy0 fy0Var = new fy0(uri2);
                Context context = this.b;
                return new ku0(fy0Var, js.e(context, uri2, new rn1(context.getContentResolver())));
            default:
                Uri uri3 = (Uri) obj;
                if (i == Integer.MIN_VALUE || i2 == Integer.MIN_VALUE || i > 512 || i2 > 384 || (l = (Long) g01Var.c(yr1.d)) == null || l.longValue() != -1) {
                    return null;
                }
                fy0 fy0Var2 = new fy0(uri3);
                Context context2 = this.b;
                return new ku0(fy0Var2, js.e(context2, uri3, new sn1(context2.getContentResolver())));
        }
    }
}
