package defpackage;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public final class kz extends m90 {
    public final TextView l;
    public final fz m;
    public boolean n = true;

    public kz(TextView textView) {
        this.l = textView;
        this.m = new fz(textView);
    }

    @Override // defpackage.m90
    public final InputFilter[] j(InputFilter[] inputFilterArr) {
        if (!this.n) {
            SparseArray sparseArray = new SparseArray(1);
            for (int i = 0; i < inputFilterArr.length; i++) {
                InputFilter inputFilter = inputFilterArr[i];
                if (inputFilter instanceof fz) {
                    sparseArray.put(i, inputFilter);
                }
            }
            if (sparseArray.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - sparseArray.size()];
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                if (sparseArray.indexOfKey(i3) < 0) {
                    inputFilterArr2[i2] = inputFilterArr[i3];
                    i2++;
                }
            }
            return inputFilterArr2;
        }
        int length2 = inputFilterArr.length;
        int i4 = 0;
        while (true) {
            fz fzVar = this.m;
            if (i4 >= length2) {
                InputFilter[] inputFilterArr3 = new InputFilter[inputFilterArr.length + 1];
                System.arraycopy(inputFilterArr, 0, inputFilterArr3, 0, length2);
                inputFilterArr3[length2] = fzVar;
                return inputFilterArr3;
            }
            if (inputFilterArr[i4] == fzVar) {
                return inputFilterArr;
            }
            i4++;
        }
    }

    @Override // defpackage.m90
    public final boolean l() {
        return this.n;
    }

    @Override // defpackage.m90
    public final void p(boolean z) {
        if (z) {
            TextView textView = this.l;
            textView.setTransformationMethod(t(textView.getTransformationMethod()));
        }
    }

    @Override // defpackage.m90
    public final void q(boolean z) {
        this.n = z;
        TextView textView = this.l;
        textView.setTransformationMethod(t(textView.getTransformationMethod()));
        textView.setFilters(j(textView.getFilters()));
    }

    @Override // defpackage.m90
    public final TransformationMethod t(TransformationMethod transformationMethod) {
        return this.n ? ((transformationMethod instanceof pz) || (transformationMethod instanceof PasswordTransformationMethod)) ? transformationMethod : new pz(transformationMethod) : transformationMethod instanceof pz ? ((pz) transformationMethod).a : transformationMethod;
    }
}
