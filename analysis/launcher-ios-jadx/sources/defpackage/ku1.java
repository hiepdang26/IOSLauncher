package defpackage;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class ku1 extends ou1 {
    public final /* synthetic */ int k;

    @Override // defpackage.ou1
    public final boolean d(View view, float f, long j, cj0 cj0Var) {
        switch (this.k) {
            case 0:
                view.setAlpha(b(view, f, j, cj0Var));
                break;
            case 1:
                view.setElevation(b(view, f, j, cj0Var));
                break;
            case 2:
                view.setRotation(b(view, f, j, cj0Var));
                break;
            case 3:
                view.setRotationX(b(view, f, j, cj0Var));
                break;
            case 4:
                view.setRotationY(b(view, f, j, cj0Var));
                break;
            case 5:
                view.setScaleX(b(view, f, j, cj0Var));
                break;
            case 6:
                view.setScaleY(b(view, f, j, cj0Var));
                break;
            case 7:
                view.setTranslationX(b(view, f, j, cj0Var));
                break;
            case 8:
                view.setTranslationY(b(view, f, j, cj0Var));
                break;
            default:
                view.setTranslationZ(b(view, f, j, cj0Var));
                break;
        }
        return this.h;
    }
}
