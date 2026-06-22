package defpackage;

import android.os.Build;
import android.os.ParcelFileDescriptor;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class te implements ib1 {
    public final /* synthetic */ int a;
    public final jw b;

    public /* synthetic */ te(jw jwVar, int i) {
        this.a = i;
        this.b = jwVar;
    }

    @Override // defpackage.ib1
    public final eb1 a(Object obj, int i, int i2, g01 g01Var) {
        switch (this.a) {
            case 0:
                jw jwVar = this.b;
                return jwVar.a(new wb2((ByteBuffer) obj, jwVar.d, jwVar.c, 15), i, i2, g01Var, jw.k);
            default:
                jw jwVar2 = this.b;
                return jwVar2.a(new wb2((ParcelFileDescriptor) obj, jwVar2.d, jwVar2.c), i, i2, g01Var, jw.k);
        }
    }

    @Override // defpackage.ib1
    public final boolean b(Object obj, g01 g01Var) {
        switch (this.a) {
            case 0:
                this.b.getClass();
                return true;
            default:
                ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) obj;
                String str = Build.MANUFACTURER;
                return (!("HUAWEI".equalsIgnoreCase(str) || "HONOR".equalsIgnoreCase(str)) || parcelFileDescriptor.getStatSize() <= 536870912) && !"robolectric".equals(Build.FINGERPRINT);
        }
    }
}
