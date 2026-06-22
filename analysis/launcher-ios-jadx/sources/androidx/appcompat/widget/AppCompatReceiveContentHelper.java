package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.text.Selection;
import android.text.Spannable;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;
import defpackage.fz1;
import defpackage.qs1;
import defpackage.un;
import defpackage.vn;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class AppCompatReceiveContentHelper {
    private static final String LOG_TAG = "ReceiveContent";

    public static final class OnDropApi24Impl {
        private OnDropApi24Impl() {
        }

        public static boolean onDropForTextView(DragEvent dragEvent, TextView textView, Activity activity) {
            un fz1Var;
            activity.requestDragAndDropPermissions(dragEvent);
            int offsetForPosition = textView.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
            textView.beginBatchEdit();
            try {
                Selection.setSelection((Spannable) textView.getText(), offsetForPosition);
                ClipData clipData = dragEvent.getClipData();
                if (Build.VERSION.SDK_INT >= 31) {
                    fz1Var = new fz1(clipData, 3);
                } else {
                    vn vnVar = new vn();
                    vnVar.h = clipData;
                    vnVar.i = 3;
                    fz1Var = vnVar;
                }
                qs1.l(textView, fz1Var.g());
                textView.endBatchEdit();
                return true;
            } catch (Throwable th) {
                textView.endBatchEdit();
                throw th;
            }
        }

        public static boolean onDropForView(DragEvent dragEvent, View view, Activity activity) {
            un fz1Var;
            activity.requestDragAndDropPermissions(dragEvent);
            ClipData clipData = dragEvent.getClipData();
            if (Build.VERSION.SDK_INT >= 31) {
                fz1Var = new fz1(clipData, 3);
            } else {
                vn vnVar = new vn();
                vnVar.h = clipData;
                vnVar.i = 3;
                fz1Var = vnVar;
            }
            qs1.l(view, fz1Var.g());
            return true;
        }
    }

    private AppCompatReceiveContentHelper() {
    }

    public static boolean maybeHandleDragEventViaPerformReceiveContent(View view, DragEvent dragEvent) {
        int i = Build.VERSION.SDK_INT;
        if (i < 31 && i >= 24 && dragEvent.getLocalState() == null && qs1.g(view) != null) {
            Activity activityTryGetActivity = tryGetActivity(view);
            if (activityTryGetActivity == null) {
                Objects.toString(view);
                return false;
            }
            if (dragEvent.getAction() == 1) {
                return !(view instanceof TextView);
            }
            if (dragEvent.getAction() == 3) {
                return view instanceof TextView ? OnDropApi24Impl.onDropForTextView(dragEvent, (TextView) view, activityTryGetActivity) : OnDropApi24Impl.onDropForView(dragEvent, view, activityTryGetActivity);
            }
        }
        return false;
    }

    public static boolean maybeHandleMenuActionViaPerformReceiveContent(TextView textView, int i) {
        un fz1Var;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 31 || qs1.g(textView) == null || !(i == 16908322 || i == 16908337)) {
            return false;
        }
        ClipboardManager clipboardManager = (ClipboardManager) textView.getContext().getSystemService("clipboard");
        ClipData primaryClip = clipboardManager == null ? null : clipboardManager.getPrimaryClip();
        if (primaryClip != null && primaryClip.getItemCount() > 0) {
            if (i2 >= 31) {
                fz1Var = new fz1(primaryClip, 1);
            } else {
                vn vnVar = new vn();
                vnVar.h = primaryClip;
                vnVar.i = 1;
                fz1Var = vnVar;
            }
            fz1Var.y(i != 16908322 ? 1 : 0);
            qs1.l(textView, fz1Var.g());
        }
        return true;
    }

    public static Activity tryGetActivity(View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }
}
