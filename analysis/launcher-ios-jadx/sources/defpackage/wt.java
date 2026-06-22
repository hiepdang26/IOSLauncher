package defpackage;

import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.util.Log;
import android.util.Size;

/* JADX INFO: loaded from: classes.dex */
public final class wt implements ImageDecoder.OnHeaderDecodedListener {
    public final gb0 a = gb0.a();
    public final int b;
    public final int c;
    public final ps d;
    public final hw e;
    public final boolean f;
    public final h31 g;

    public wt(int i, int i2, g01 g01Var) {
        this.b = i;
        this.c = i2;
        this.d = (ps) g01Var.c(jw.f);
        this.e = (hw) g01Var.c(hw.g);
        e01 e01Var = jw.i;
        this.f = g01Var.c(e01Var) != null && ((Boolean) g01Var.c(e01Var)).booleanValue();
        this.g = (h31) g01Var.c(jw.g);
    }

    @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
    public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        if (this.a.c(this.b, this.c, this.f, false)) {
            imageDecoder.setAllocator(3);
        } else {
            imageDecoder.setAllocator(1);
        }
        if (this.d == ps.h) {
            imageDecoder.setMemorySizePolicy(0);
        }
        imageDecoder.setOnPartialImageListener(new vt());
        Size size = imageInfo.getSize();
        int width = this.b;
        if (width == Integer.MIN_VALUE) {
            width = size.getWidth();
        }
        int height = this.c;
        if (height == Integer.MIN_VALUE) {
            height = size.getHeight();
        }
        float fB = this.e.b(size.getWidth(), size.getHeight(), width, height);
        int iRound = Math.round(size.getWidth() * fB);
        int iRound2 = Math.round(fB * size.getHeight());
        if (Log.isLoggable("ImageDecoder", 2)) {
            size.getWidth();
            size.getHeight();
        }
        imageDecoder.setTargetSize(iRound, iRound2);
        h31 h31Var = this.g;
        if (h31Var != null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 28) {
                imageDecoder.setTargetColorSpace(ColorSpace.get((h31Var == h31.g && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB));
            } else if (i >= 26) {
                ColorSpace.Named unused = ColorSpace.Named.SRGB;
                imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
            }
        }
    }
}
