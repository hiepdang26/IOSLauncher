package defpackage;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public final class g31 extends m91 {
    public final Drawable A;
    public final ColorStateList B;
    public final SparseArray C;
    public boolean D;
    public boolean E;

    public g31(View view) {
        super(view);
        SparseArray sparseArray = new SparseArray(4);
        this.C = sparseArray;
        TextView textView = (TextView) view.findViewById(R.id.title);
        sparseArray.put(R.id.title, textView);
        sparseArray.put(R.id.summary, view.findViewById(R.id.summary));
        sparseArray.put(R.id.icon, view.findViewById(R.id.icon));
        int i = e61.icon_frame;
        sparseArray.put(i, view.findViewById(i));
        sparseArray.put(R.id.icon_frame, view.findViewById(R.id.icon_frame));
        this.A = view.getBackground();
        if (textView != null) {
            this.B = textView.getTextColors();
        }
    }

    public final View v(int i) {
        SparseArray sparseArray = this.C;
        View view = (View) sparseArray.get(i);
        if (view != null) {
            return view;
        }
        View viewFindViewById = this.g.findViewById(i);
        if (viewFindViewById != null) {
            sparseArray.put(i, viewFindViewById);
        }
        return viewFindViewById;
    }
}
