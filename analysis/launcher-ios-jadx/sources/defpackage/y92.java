package defpackage;

import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: classes.dex */
public final class y92 extends ba1 {
    public final /* synthetic */ int a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ y92(String str, int i) {
        super(str);
        this.a = i;
    }

    @Override // defpackage.ba1
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        switch (this.a) {
            case 0:
                if (iBinder == null) {
                    return null;
                }
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
                return iInterfaceQueryLocalInterface instanceof n72 ? (n72) iInterfaceQueryLocalInterface : new n72(iBinder);
            default:
                if (iBinder == null) {
                    return null;
                }
                IInterface iInterfaceQueryLocalInterface2 = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
                return iInterfaceQueryLocalInterface2 instanceof s52 ? (s52) iInterfaceQueryLocalInterface2 : new s52(iBinder);
        }
    }
}
