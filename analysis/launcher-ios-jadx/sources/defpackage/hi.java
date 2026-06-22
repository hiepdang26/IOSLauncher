package defpackage;

import android.graphics.Outline;
import android.graphics.Path;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.chip.Chip;
import com.luutinhit.launcher6.editscreen.LinearLayoutRound;
import com.luutinhit.launcher6.util.RoundedImageView;

/* JADX INFO: loaded from: classes.dex */
public final class hi extends ViewOutlineProvider {
    public final /* synthetic */ int a;
    public final /* synthetic */ View b;

    public /* synthetic */ hi(int i, View view) {
        this.a = i;
        this.b = view;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        switch (this.a) {
            case 0:
                ki kiVar = ((Chip) this.b).g;
                if (kiVar == null) {
                    outline.setAlpha(0.0f);
                } else {
                    kiVar.getOutline(outline);
                }
                break;
            case 1:
                LinearLayoutRound linearLayoutRound = (LinearLayoutRound) this.b;
                Path pathA = linearLayoutRound.a(linearLayoutRound.g, linearLayoutRound.h, linearLayoutRound.i, linearLayoutRound.p, linearLayoutRound.q, linearLayoutRound.r, linearLayoutRound.s);
                if (!ar1.g) {
                    outline.setRoundRect(0, 0, (int) linearLayoutRound.g, (int) linearLayoutRound.h, linearLayoutRound.i);
                } else {
                    outline.setPath(pathA);
                }
                break;
            default:
                RoundedImageView roundedImageView = (RoundedImageView) this.b;
                float f = roundedImageView.j;
                float f2 = roundedImageView.k;
                Path path = new Path();
                float f3 = roundedImageView.g;
                if (f3 < 0.0f) {
                    f3 = 0.0f;
                }
                float f4 = f - 0.0f;
                float f5 = f2 - 0.0f;
                float f6 = f4 / 2.0f;
                float f7 = roundedImageView.h - f6;
                float f8 = f5 / 2.0f;
                float f9 = roundedImageView.i - f8;
                float fMin = ((double) (f3 / Math.min(f6, f8))) > 0.5d ? 1.0f - (Math.min(1.0f, ((f3 / Math.min(f6, f8)) - 0.5f) / 0.4f) * 0.13877845f) : 1.0f;
                float fMin2 = ((double) (f3 / Math.min(f6, f8))) > 0.6d ? 1.0f + (Math.min(1.0f, ((f3 / Math.min(f6, f8)) - 0.6f) / 0.3f) * 0.042454004f) : 1.0f;
                path.moveTo(f7 + f6, f9);
                float f10 = f3 / 100.0f;
                float f11 = 128.19f * f10 * fMin;
                float f12 = f4 - f11;
                path.lineTo(Math.max(f6, f12) + f7, f9);
                float f13 = f4 + f7;
                float f14 = fMin2 * 83.62f * f10;
                float f15 = f13 - f14;
                float f16 = f10 * 67.45f;
                float f17 = f13 - f16;
                float f18 = f10 * 4.64f;
                float f19 = f9 + f18;
                float f20 = 51.16f * f10;
                float f21 = f13 - f20;
                float f22 = 13.36f * f10;
                float f23 = f9 + f22;
                path.cubicTo(f15, f9, f17, f19, f21, f23);
                float f24 = f10 * 34.86f;
                float f25 = f13 - f24;
                float f26 = f10 * 22.07f;
                float f27 = f9 + f26;
                float f28 = f13 - f26;
                float f29 = f9 + f24;
                float f30 = f13 - f22;
                float f31 = f9 + f20;
                path.cubicTo(f25, f27, f28, f29, f30, f31);
                float f32 = f13 - f18;
                float f33 = f9 + f16;
                float f34 = f9 + f14;
                path.cubicTo(f32, f33, f13, f34, f13, Math.min(f8, f11) + f9);
                float f35 = f5 - f11;
                path.lineTo(f13, Math.max(f8, f35) + f9);
                float f36 = f9 + f5;
                float f37 = f36 - f14;
                float f38 = f36 - f16;
                float f39 = f36 - f20;
                path.cubicTo(f13, f37, f32, f38, f30, f39);
                float f40 = f36 - f24;
                float f41 = f36 - f26;
                float f42 = f36 - f22;
                path.cubicTo(f28, f40, f25, f41, f21, f42);
                float f43 = f36 - f18;
                path.cubicTo(f17, f43, f15, f36, Math.max(f6, f12) + f7, f36);
                path.lineTo(Math.min(f6, f11) + f7, f36);
                float f44 = f7 + f14;
                float f45 = f7 + f16;
                float f46 = f7 + f20;
                path.cubicTo(f44, f36, f45, f43, f46, f42);
                float f47 = f7 + f24;
                float f48 = f7 + f26;
                float f49 = f7 + f22;
                path.cubicTo(f47, f41, f48, f40, f49, f39);
                float f50 = f7 + f18;
                path.cubicTo(f50, f38, f7, f37, f7, Math.max(f8, f35) + f9);
                path.lineTo(f7, Math.min(f8, f11) + f9);
                path.cubicTo(f7, f34, f50, f33, f49, f31);
                path.cubicTo(f48, f29, f47, f27, f46, f23);
                path.cubicTo(f45, f19, f44, f9, Math.min(f6, f11) + f7, f9);
                path.close();
                if (!ar1.g) {
                    outline.setRoundRect(0, 0, (int) roundedImageView.j, (int) roundedImageView.k, roundedImageView.g);
                } else {
                    outline.setPath(path);
                }
                break;
        }
    }
}
