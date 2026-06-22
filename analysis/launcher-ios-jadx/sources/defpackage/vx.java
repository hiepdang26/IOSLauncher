package defpackage;

import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public final class vx extends e42 {
    public final /* synthetic */ int h;

    public /* synthetic */ vx(int i) {
        this.h = i;
    }

    @Override // defpackage.e42
    public final float c(ViewGroup viewGroup) {
        switch (this.h) {
            case 0:
                return viewGroup.getAlpha();
            case 1:
                return viewGroup.getTranslationX();
            case 2:
                return viewGroup.getTranslationY();
            case 3:
                return viewGroup.getScaleX();
            case 4:
                return viewGroup.getScaleY();
            case 5:
                return viewGroup.getRotation();
            case 6:
                return viewGroup.getRotationX();
            default:
                return viewGroup.getRotationY();
        }
    }

    @Override // defpackage.e42
    public final void q(ViewGroup viewGroup, float f) {
        switch (this.h) {
            case 0:
                viewGroup.setAlpha(f);
                break;
            case 1:
                viewGroup.setTranslationX(f);
                break;
            case 2:
                viewGroup.setTranslationY(f);
                break;
            case 3:
                viewGroup.setScaleX(f);
                break;
            case 4:
                viewGroup.setScaleY(f);
                break;
            case 5:
                viewGroup.setRotation(f);
                break;
            case 6:
                viewGroup.setRotationX(f);
                break;
            default:
                viewGroup.setRotationY(f);
                break;
        }
    }
}
