package defpackage;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class x5 extends y5 {
    public final /* synthetic */ int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ x5(int i, String str, String str2) {
        super(str, str2);
        this.d = i;
    }

    @Override // defpackage.y5
    public final boolean a() {
        switch (this.d) {
            case 0:
                if (Build.VERSION.SDK_INT >= 23) {
                }
                break;
            case 1:
                if (Build.VERSION.SDK_INT >= 24) {
                }
                break;
            case 2:
                break;
            case 3:
                if (Build.VERSION.SDK_INT >= 26) {
                }
                break;
            case 4:
                if (Build.VERSION.SDK_INT >= 27) {
                }
                break;
            case 5:
                if (Build.VERSION.SDK_INT >= 28) {
                }
                break;
            default:
                if (Build.VERSION.SDK_INT >= 29) {
                }
                break;
        }
        return false;
    }
}
