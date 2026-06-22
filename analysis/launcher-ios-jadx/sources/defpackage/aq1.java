package defpackage;

import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class aq1 implements lu0 {
    public static final aq1 b = new aq1(0);
    public final /* synthetic */ int a;

    public /* synthetic */ aq1(int i) {
        this.a = i;
    }

    @Override // defpackage.lu0
    public final boolean a(Object obj) {
        switch (this.a) {
            case 0:
                return true;
            case 1:
                return true;
            default:
                return false;
        }
    }

    @Override // defpackage.lu0
    public final ku0 b(Object obj, int i, int i2, g01 g01Var) {
        switch (this.a) {
            case 0:
                return new ku0(new fy0(obj), new ve(obj, 1));
            case 1:
                File file = (File) obj;
                return new ku0(new fy0(file), new ve(file, 0));
            default:
                return null;
        }
    }
}
