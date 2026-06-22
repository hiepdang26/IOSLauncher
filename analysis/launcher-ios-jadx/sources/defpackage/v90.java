package defpackage;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public final class v90 extends sa1 {
    @Override // defpackage.sa1
    public final na1 k(Class cls) {
        return new u90(this.g, this, cls, this.h);
    }

    @Override // defpackage.sa1
    public final na1 l() {
        return (u90) super.l();
    }

    @Override // defpackage.sa1
    public final na1 m() {
        return (u90) k(Drawable.class);
    }

    @Override // defpackage.sa1
    public final na1 p(Bitmap bitmap) {
        return (u90) super.p(bitmap);
    }

    @Override // defpackage.sa1
    public final na1 q(Uri uri) {
        return (u90) super.q(uri);
    }

    @Override // defpackage.sa1
    public final na1 r(Integer num) {
        return (u90) super.r(num);
    }

    @Override // defpackage.sa1
    public final na1 s(String str) {
        return (u90) super.s(str);
    }

    @Override // defpackage.sa1
    public final void v(xa1 xa1Var) {
        if (xa1Var instanceof t90) {
            super.v(xa1Var);
        } else {
            super.v(new t90().E(xa1Var));
        }
    }
}
