package defpackage;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.luutinhit.launcher6.BlurScreenLayout;

/* JADX INFO: loaded from: classes.dex */
public final class yc implements Handler.Callback {
    public final /* synthetic */ int g;
    public final /* synthetic */ BlurScreenLayout h;

    public /* synthetic */ yc(BlurScreenLayout blurScreenLayout, int i) {
        this.g = i;
        this.h = blurScreenLayout;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        Bitmap bitmapB;
        switch (this.g) {
            case 0:
                if (message != null) {
                    try {
                        if (message.what == 2) {
                            try {
                                Object obj = message.obj;
                                boolean z = obj instanceof View;
                                BlurScreenLayout blurScreenLayout = this.h;
                                if (z) {
                                    Bitmap bitmapB2 = BlurScreenLayout.b(blurScreenLayout, (View) obj);
                                    if (bitmapB2 != null) {
                                        blurScreenLayout.o = new BitmapDrawable(blurScreenLayout.getResources(), blurScreenLayout.f(bitmapB2, (View) message.obj));
                                    }
                                } else if (obj instanceof Boolean) {
                                    Bitmap appsLibraryBlurBackground = blurScreenLayout.getAppsLibraryBlurBackground();
                                    if (appsLibraryBlurBackground != null) {
                                        blurScreenLayout.o = new BitmapDrawable(blurScreenLayout.getResources(), appsLibraryBlurBackground);
                                    }
                                } else if (blurScreenLayout.o == null && (bitmapB = BlurScreenLayout.b(blurScreenLayout, null)) != null) {
                                    blurScreenLayout.o = new BitmapDrawable(blurScreenLayout.getResources(), bitmapB);
                                }
                                blurScreenLayout.n.obtainMessage(message.what).sendToTarget();
                            } catch (Throwable th) {
                                th.getMessage();
                            }
                        }
                    } catch (Throwable th2) {
                        th2.getMessage();
                        return false;
                    }
                    break;
                }
                return true;
            default:
                BlurScreenLayout blurScreenLayout2 = this.h;
                if (message == null) {
                    return true;
                }
                try {
                    if (message.what == 2) {
                        blurScreenLayout2.l.isOpeningAppsLibrary();
                        blurScreenLayout2.l.isOpeningLeftPage();
                        if (blurScreenLayout2.o != null && blurScreenLayout2.l.isOpeningFloatingMenu()) {
                            blurScreenLayout2.setAlpha(0.0f);
                            blurScreenLayout2.setBackground(blurScreenLayout2.o);
                            blurScreenLayout2.animate().withLayer().alpha(1.0f).setDuration(268L).setInterpolator(new DecelerateInterpolator()).start();
                        } else if (blurScreenLayout2.o != null && blurScreenLayout2.l.isOpeningFolder()) {
                            blurScreenLayout2.setAlpha(0.0f);
                            blurScreenLayout2.setBackground(blurScreenLayout2.o);
                            blurScreenLayout2.animate().withLayer().alpha(1.0f).setDuration(268L).setInterpolator(new DecelerateInterpolator()).start();
                        } else if (blurScreenLayout2.o != null && (blurScreenLayout2.l.isOpeningLeftPage() || blurScreenLayout2.l.isOpeningAppsLibrary() || blurScreenLayout2.l.isOpeningSearchView())) {
                            float alpha = blurScreenLayout2.getAlpha();
                            blurScreenLayout2.setBackground(blurScreenLayout2.o);
                            blurScreenLayout2.animate().withLayer().alpha(alpha).setDuration((long) (255.0f * alpha)).setInterpolator(new DecelerateInterpolator()).start();
                        }
                    }
                    return true;
                } catch (Throwable th3) {
                    th3.getMessage();
                    return true;
                }
        }
    }
}
