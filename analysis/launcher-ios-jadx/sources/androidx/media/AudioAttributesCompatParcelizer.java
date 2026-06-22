package androidx.media;

import defpackage.pr1;
import defpackage.rr1;

/* JADX INFO: loaded from: classes.dex */
public final class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(pr1 pr1Var) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        rr1 rr1VarH = audioAttributesCompat.a;
        if (pr1Var.e(1)) {
            rr1VarH = pr1Var.h();
        }
        audioAttributesCompat.a = (AudioAttributesImpl) rr1VarH;
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, pr1 pr1Var) {
        pr1Var.getClass();
        AudioAttributesImpl audioAttributesImpl = audioAttributesCompat.a;
        pr1Var.i(1);
        pr1Var.k(audioAttributesImpl);
    }
}
