package defpackage;

import android.graphics.drawable.Icon;
import android.net.Uri;
import android.view.View;
import android.view.Window;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import androidx.constraintlayout.motion.widget.MotionScene;

/* JADX INFO: loaded from: classes.dex */
public abstract class o0 {
    public static Icon a(Uri uri) {
        return Icon.createWithAdaptiveBitmapContentUri(uri);
    }

    public static CharSequence b(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getStateDescription();
    }

    public static void c(Window window, boolean z) {
        View decorView = window.getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        decorView.setSystemUiVisibility(z ? systemUiVisibility & (-257) : systemUiVisibility | MotionScene.Transition.TransitionOnClick.JUMP_TO_END);
        window.setDecorFitsSystemWindows(z);
    }

    public static void d(Window window, boolean z) {
        window.setDecorFitsSystemWindows(z);
    }

    public static void e(EditorInfo editorInfo, CharSequence charSequence) {
        editorInfo.setInitialSurroundingSubText(charSequence, 0);
    }

    public static void f(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
        accessibilityNodeInfo.setStateDescription(charSequence);
    }
}
