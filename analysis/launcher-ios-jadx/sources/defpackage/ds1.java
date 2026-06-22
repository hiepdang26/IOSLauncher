package defpackage;

import android.text.TextUtils;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class ds1 extends qq0 {
    public final /* synthetic */ int k;

    public ds1(int i, Class cls, int i2, int i3, int i4) {
        this.k = i4;
        this.g = i;
        this.j = cls;
        this.i = i2;
        this.h = i3;
    }

    @Override // defpackage.qq0
    public final Object c(View view) {
        switch (this.k) {
            case 0:
                return Boolean.valueOf(ls1.c(view));
            case 1:
                return ls1.a(view);
            case 2:
                return ns1.b(view);
            default:
                return Boolean.valueOf(ls1.b(view));
        }
    }

    @Override // defpackage.qq0
    public final void d(View view, Object obj) {
        switch (this.k) {
            case 0:
                ls1.f(view, ((Boolean) obj).booleanValue());
                break;
            case 1:
                ls1.e(view, (CharSequence) obj);
                break;
            case 2:
                ns1.c(view, (CharSequence) obj);
                break;
            default:
                ls1.d(view, ((Boolean) obj).booleanValue());
                break;
        }
    }

    @Override // defpackage.qq0
    public final boolean g(Object obj, Object obj2) {
        switch (this.k) {
            case 0:
                Boolean bool = (Boolean) obj;
                Boolean bool2 = (Boolean) obj2;
                return !((bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue()));
            case 1:
                return !TextUtils.equals((CharSequence) obj, (CharSequence) obj2);
            case 2:
                return !TextUtils.equals((CharSequence) obj, (CharSequence) obj2);
            default:
                Boolean bool3 = (Boolean) obj;
                Boolean bool4 = (Boolean) obj2;
                return !((bool3 != null && bool3.booleanValue()) == (bool4 != null && bool4.booleanValue()));
        }
    }
}
