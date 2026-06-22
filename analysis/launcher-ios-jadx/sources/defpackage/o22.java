package defpackage;

import android.app.Activity;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class o22 extends yb2 {
    public final /* synthetic */ int D;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o22(Activity activity, int i) {
        super(activity);
        this.D = i;
    }

    @Override // defpackage.yb2, com.google.android.gms.internal.ads.zzbsn
    public void zzl(Bundle bundle) {
        switch (this.D) {
            case 4:
                k92.a("AdOverlayParcel is null or does not contain valid overlay type.");
                this.B = 4;
                this.g.finish();
                break;
            default:
                super.zzl(bundle);
                break;
        }
    }
}
