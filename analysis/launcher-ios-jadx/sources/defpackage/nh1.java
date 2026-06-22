package defpackage;

import android.view.animation.DecelerateInterpolator;
import com.luutinhit.launcher6.editscreen.SlidingUpCustomizeColorIconStyle;
import com.luutinhit.launcher6.t;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class nh1 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ SlidingUpCustomizeColorIconStyle h;

    public /* synthetic */ nh1(SlidingUpCustomizeColorIconStyle slidingUpCustomizeColorIconStyle, int i) {
        this.g = i;
        this.h = slidingUpCustomizeColorIconStyle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                SlidingUpCustomizeColorIconStyle slidingUpCustomizeColorIconStyle = this.h;
                slidingUpCustomizeColorIconStyle.T.animate().translationY(slidingUpCustomizeColorIconStyle.getResources().getDimensionPixelSize(e51.custom_style_color_seekbar_height)).setDuration(268L).setInterpolator(new DecelerateInterpolator()).start();
                t tVar = slidingUpCustomizeColorIconStyle.P;
                if (tVar != null && tVar.getWorkspace() != null) {
                    if (tVar.isOpeningFolder()) {
                        tVar.getWorkspace().getOpenFolder().G();
                    }
                    ArrayList<ng1> allShortcutAndWidgetContainers = tVar.getWorkspace().getAllShortcutAndWidgetContainers();
                    int size = allShortcutAndWidgetContainers.size();
                    int i = 0;
                    while (i < size) {
                        ng1 ng1Var = allShortcutAndWidgetContainers.get(i);
                        i++;
                        ng1Var.m(-1);
                    }
                    break;
                }
                break;
            case 1:
                SlidingUpCustomizeColorIconStyle slidingUpCustomizeColorIconStyle2 = this.h;
                int i2 = slidingUpCustomizeColorIconStyle2.U;
                t tVar2 = slidingUpCustomizeColorIconStyle2.P;
                if (tVar2 != null && tVar2.getWorkspace() != null) {
                    if (tVar2.isOpeningFolder()) {
                        tVar2.getWorkspace().getOpenFolder().G();
                    }
                    ArrayList<ng1> allShortcutAndWidgetContainers2 = tVar2.getWorkspace().getAllShortcutAndWidgetContainers();
                    int size2 = allShortcutAndWidgetContainers2.size();
                    int i3 = 0;
                    while (i3 < size2) {
                        ng1 ng1Var2 = allShortcutAndWidgetContainers2.get(i3);
                        i3++;
                        ng1Var2.m(i2);
                    }
                    break;
                }
                break;
            default:
                SlidingUpCustomizeColorIconStyle slidingUpCustomizeColorIconStyle3 = this.h;
                slidingUpCustomizeColorIconStyle3.T.setTranslationY(slidingUpCustomizeColorIconStyle3.getResources().getDimensionPixelSize(e51.custom_style_color_seekbar_height));
                slidingUpCustomizeColorIconStyle3.P.closeCustomizeColorAppStyle();
                break;
        }
    }
}
