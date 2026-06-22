package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class vw1 extends x5 {
    @Override // defpackage.y5
    public final boolean b() {
        if (!super.b() || !np1.z("MULTI_PROCESS")) {
            return false;
        }
        int i = tw1.a;
        if (ww1.b.b()) {
            return xw1.a.getStatics().isMultiProcessEnabled();
        }
        throw new UnsupportedOperationException("This method is not supported by the current version of the framework and the current WebView APK");
    }
}
