package defpackage;

import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzbhd;
import com.google.android.gms.internal.ads.zzbsk;
import com.google.android.gms.internal.ads.zzbws;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class x32 {
    public static final x32 f = new x32();
    public final ka2 a;
    public final s32 b;
    public final String c;
    public final or1 d;
    public final Random e;

    public x32() {
        ka2 ka2Var = new ka2();
        ka2Var.a = -1.0f;
        mb2 mb2Var = new mb2("com.google.android.gms.ads.AdManagerCreatorImpl");
        y92 y92Var = new y92("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl", 1);
        y92 y92Var2 = new y92("com.google.android.gms.ads.MobileAdsSettingManagerCreatorImpl", 0);
        zzbhc zzbhcVar = new zzbhc();
        new zzbws();
        zzbsk zzbskVar = new zzbsk();
        new zzbhd();
        s32 s32Var = new s32(mb2Var, y92Var, y92Var2, zzbhcVar, zzbskVar);
        UUID uuidRandomUUID = UUID.randomUUID();
        byte[] byteArray = BigInteger.valueOf(uuidRandomUUID.getLeastSignificantBits()).toByteArray();
        byte[] byteArray2 = BigInteger.valueOf(uuidRandomUUID.getMostSignificantBits()).toByteArray();
        String string = new BigInteger(1, byteArray).toString();
        for (int i = 0; i < 2; i++) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(byteArray);
                messageDigest.update(byteArray2);
                byte[] bArr = new byte[8];
                System.arraycopy(messageDigest.digest(), 0, bArr, 0, 8);
                string = new BigInteger(1, bArr).toString();
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        or1 or1Var = new or1(0, 242402000, true, false);
        Random random = new Random();
        this.a = ka2Var;
        this.b = s32Var;
        this.c = string;
        this.d = or1Var;
        this.e = random;
    }
}
