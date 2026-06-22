package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertController$RecycleListView;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class s3 {
    public final int A;
    public final int B;
    public final int C;
    public final int D;
    public final boolean E;
    public final q3 F;
    public final Context a;
    public final u3 b;
    public final Window c;
    public CharSequence d;
    public CharSequence e;
    public AlertController$RecycleListView f;
    public View g;
    public Button i;
    public CharSequence j;
    public Message k;
    public Button l;
    public CharSequence m;
    public Message n;
    public Button o;
    public CharSequence p;
    public Message q;
    public NestedScrollView r;
    public Drawable s;
    public ImageView t;
    public TextView u;
    public TextView v;
    public View w;
    public ListAdapter x;
    public final int z;
    public boolean h = false;
    public int y = -1;
    public final j3 G = new j3(this);

    public s3(Context context, u3 u3Var, Window window) {
        this.a = context;
        this.b = u3Var;
        this.c = window;
        q3 q3Var = new q3();
        q3Var.b = new WeakReference(u3Var);
        this.F = q3Var;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, q71.AlertDialog, r41.alertDialogStyle, 0);
        this.z = typedArrayObtainStyledAttributes.getResourceId(q71.AlertDialog_android_layout, 0);
        typedArrayObtainStyledAttributes.getResourceId(q71.AlertDialog_buttonPanelSideLayout, 0);
        this.A = typedArrayObtainStyledAttributes.getResourceId(q71.AlertDialog_listLayout, 0);
        this.B = typedArrayObtainStyledAttributes.getResourceId(q71.AlertDialog_multiChoiceItemLayout, 0);
        this.C = typedArrayObtainStyledAttributes.getResourceId(q71.AlertDialog_singleChoiceItemLayout, 0);
        this.D = typedArrayObtainStyledAttributes.getResourceId(q71.AlertDialog_listItemLayout, 0);
        this.E = typedArrayObtainStyledAttributes.getBoolean(q71.AlertDialog_showTitle, true);
        typedArrayObtainStyledAttributes.getDimensionPixelSize(q71.AlertDialog_buttonIconDimen, 0);
        typedArrayObtainStyledAttributes.recycle();
        u3Var.a().e(1);
    }

    public static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public static void b(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    public static ViewGroup c(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    public final void d(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        Message messageObtainMessage = onClickListener != null ? this.F.obtainMessage(i, onClickListener) : null;
        if (i == -3) {
            this.p = charSequence;
            this.q = messageObtainMessage;
        } else if (i == -2) {
            this.m = charSequence;
            this.n = messageObtainMessage;
        } else {
            if (i != -1) {
                throw new IllegalArgumentException("Button does not exist");
            }
            this.j = charSequence;
            this.k = messageObtainMessage;
        }
    }
}
