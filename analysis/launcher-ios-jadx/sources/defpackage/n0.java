package defpackage;

import android.R;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.profileinstaller.ProfileVerifier;

/* JADX INFO: loaded from: classes.dex */
public final class n0 {
    public static final n0 e = new n0(1);
    public static final n0 f = new n0(2);
    public static final n0 g;
    public static final n0 h;
    public static final n0 i;
    public static final n0 j;
    public static final n0 k;
    public static final n0 l;
    public static final n0 m;
    public static final n0 n;
    public final Object a;
    public final int b;
    public final Class c;
    public final b1 d;

    static {
        new n0(4);
        new n0(8);
        g = new n0(16);
        new n0(32);
        new n0(64);
        new n0(128);
        new n0(MotionScene.Transition.TransitionOnClick.JUMP_TO_END, u0.class);
        new n0(512, u0.class);
        new n0(1024, v0.class);
        new n0(2048, v0.class);
        h = new n0(MotionScene.Transition.TransitionOnClick.JUMP_TO_START);
        i = new n0(8192);
        new n0(16384);
        new n0(32768);
        new n0(ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST);
        new n0(ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CACHE_FILE_EXISTS_BUT_CANNOT_BE_READ, z0.class);
        j = new n0(ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_UNSUPPORTED_API_VERSION);
        k = new n0(524288);
        l = new n0(1048576);
        new n0(2097152, a1.class);
        int i2 = Build.VERSION.SDK_INT;
        new n0(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN : null, R.id.accessibilityActionShowOnScreen, null, null, null);
        new n0(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION : null, R.id.accessibilityActionScrollToPosition, null, null, x0.class);
        m = new n0(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null, R.id.accessibilityActionScrollUp, null, null, null);
        new n0(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null, R.id.accessibilityActionScrollLeft, null, null, null);
        n = new n0(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null, R.id.accessibilityActionScrollDown, null, null, null);
        new n0(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null, R.id.accessibilityActionScrollRight, null, null, null);
        new n0(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, R.id.accessibilityActionPageUp, null, null, null);
        new n0(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, R.id.accessibilityActionPageDown, null, null, null);
        new n0(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, R.id.accessibilityActionPageLeft, null, null, null);
        new n0(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, R.id.accessibilityActionPageRight, null, null, null);
        new n0(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK : null, R.id.accessibilityActionContextClick, null, null, null);
        new n0(i2 >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null, R.id.accessibilityActionSetProgress, null, null, y0.class);
        new n0(i2 >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, R.id.accessibilityActionMoveWindow, null, null, w0.class);
        new n0(i2 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, R.id.accessibilityActionShowTooltip, null, null, null);
        new n0(i2 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, R.id.accessibilityActionHideTooltip, null, null, null);
        new n0(i2 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, R.id.accessibilityActionPressAndHold, null, null, null);
        new n0(i2 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, R.id.accessibilityActionImeEnter, null, null, null);
        new n0(i2 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START : null, R.id.accessibilityActionDragStart, null, null, null);
        new n0(i2 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP : null, R.id.accessibilityActionDragDrop, null, null, null);
        new n0(i2 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL : null, R.id.accessibilityActionDragCancel, null, null, null);
        new n0(i2 >= 33 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS : null, R.id.accessibilityActionShowTextSuggestions, null, null, null);
        new n0(i2 >= 34 ? q0.a() : null, R.id.accessibilityActionScrollInDirection, null, null, null);
    }

    public n0(int i2) {
        this(null, i2, null, null, null);
    }

    public final int a() {
        return ((AccessibilityNodeInfo.AccessibilityAction) this.a).getId();
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof n0)) {
            return false;
        }
        Object obj2 = ((n0) obj).a;
        Object obj3 = this.a;
        return obj3 == null ? obj2 == null : obj3.equals(obj2);
    }

    public final int hashCode() {
        Object obj = this.a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AccessibilityActionCompat: ");
        String strD = r0.d(this.b);
        if (strD.equals("ACTION_UNKNOWN")) {
            Object obj = this.a;
            if (((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel() != null) {
                strD = ((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel().toString();
            }
        }
        sb.append(strD);
        return sb.toString();
    }

    public n0(int i2, Class cls) {
        this(null, i2, null, null, cls);
    }

    public n0(Object obj, int i2, String str, b1 b1Var, Class cls) {
        this.b = i2;
        this.d = b1Var;
        if (obj == null) {
            this.a = new AccessibilityNodeInfo.AccessibilityAction(i2, str);
        } else {
            this.a = obj;
        }
        this.c = cls;
    }
}
