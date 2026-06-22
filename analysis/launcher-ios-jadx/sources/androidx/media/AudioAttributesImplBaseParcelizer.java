package androidx.media;

import defpackage.pr1;

/* JADX INFO: loaded from: classes.dex */
public final class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(pr1 pr1Var) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.a = pr1Var.f(audioAttributesImplBase.a, 1);
        audioAttributesImplBase.b = pr1Var.f(audioAttributesImplBase.b, 2);
        audioAttributesImplBase.c = pr1Var.f(audioAttributesImplBase.c, 3);
        audioAttributesImplBase.d = pr1Var.f(audioAttributesImplBase.d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, pr1 pr1Var) {
        pr1Var.getClass();
        pr1Var.j(audioAttributesImplBase.a, 1);
        pr1Var.j(audioAttributesImplBase.b, 2);
        pr1Var.j(audioAttributesImplBase.c, 3);
        pr1Var.j(audioAttributesImplBase.d, 4);
    }
}
