package defpackage;

import android.animation.TypeEvaluator;

/* JADX INFO: loaded from: classes.dex */
public final class v8 implements TypeEvaluator {
    public static final v8 a = new v8();

    @Override // android.animation.TypeEvaluator
    public final Object evaluate(float f, Object obj, Object obj2) {
        int iIntValue = ((Integer) obj).intValue();
        float f2 = ((iIntValue >> 24) & 255) / 255.0f;
        int iIntValue2 = ((Integer) obj2).intValue();
        float f3 = ((iIntValue2 >> 24) & 255) / 255.0f;
        float fPow = (float) Math.pow(((iIntValue >> 16) & 255) / 255.0f, 2.2d);
        float fPow2 = (float) Math.pow(((iIntValue >> 8) & 255) / 255.0f, 2.2d);
        float fPow3 = (float) Math.pow((iIntValue & 255) / 255.0f, 2.2d);
        float fPow4 = (float) Math.pow(((iIntValue2 >> 16) & 255) / 255.0f, 2.2d);
        float fPow5 = (float) Math.pow(((iIntValue2 >> 8) & 255) / 255.0f, 2.2d);
        float fPow6 = (float) Math.pow((iIntValue2 & 255) / 255.0f, 2.2d);
        float fS = uo.s(f3, f2, f, f2);
        float fS2 = uo.s(fPow4, fPow, f, fPow);
        float fS3 = uo.s(fPow5, fPow2, f, fPow2);
        float fS4 = uo.s(fPow6, fPow3, f, fPow3);
        float fPow7 = ((float) Math.pow(fS2, 0.45454545454545453d)) * 255.0f;
        float fPow8 = ((float) Math.pow(fS3, 0.45454545454545453d)) * 255.0f;
        return Integer.valueOf(Math.round(((float) Math.pow(fS4, 0.45454545454545453d)) * 255.0f) | (Math.round(fPow7) << 16) | (Math.round(fS * 255.0f) << 24) | (Math.round(fPow8) << 8));
    }
}
