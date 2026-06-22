package androidx.media;

import android.media.AudioAttributes;
import defpackage.pr1;
import defpackage.qr1;

/* JADX INFO: loaded from: classes.dex */
public final class AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(pr1 pr1Var) {
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21();
        audioAttributesImplApi21.a = (AudioAttributes) pr1Var.g(audioAttributesImplApi21.a, 1);
        audioAttributesImplApi21.b = pr1Var.f(audioAttributesImplApi21.b, 2);
        return audioAttributesImplApi21;
    }

    public static void write(AudioAttributesImplApi21 audioAttributesImplApi21, pr1 pr1Var) {
        pr1Var.getClass();
        AudioAttributes audioAttributes = audioAttributesImplApi21.a;
        pr1Var.i(1);
        ((qr1) pr1Var).e.writeParcelable(audioAttributes, 0);
        pr1Var.j(audioAttributesImplApi21.b, 2);
    }
}
