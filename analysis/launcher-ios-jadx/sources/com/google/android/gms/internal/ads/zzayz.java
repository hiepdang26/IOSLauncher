package com.google.android.gms.internal.ads;

import android.util.Base64OutputStream;
import androidx.constraintlayout.motion.widget.MotionScene;
import defpackage.k92;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
final class zzayz {
    ByteArrayOutputStream zza = new ByteArrayOutputStream(MotionScene.Transition.TransitionOnClick.JUMP_TO_START);
    Base64OutputStream zzb = new Base64OutputStream(this.zza, 10);

    /* JADX WARN: Multi-variable type inference failed */
    public final String toString() {
        String string;
        try {
            this.zzb.close();
        } catch (IOException unused) {
            k92.f();
        }
        try {
            try {
                this.zza.close();
                string = this.zza.toString();
            } catch (IOException unused2) {
                k92.f();
                string = "";
            }
            return string;
        } finally {
            this.zza = null;
            this.zzb = null;
        }
    }
}
