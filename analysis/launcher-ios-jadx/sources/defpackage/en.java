package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.constraintlayout.widget.a;
import androidx.profileinstaller.ProfileVersion;
import com.google.android.gms.internal.ads.zzbbc;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class en {
    public static final int[] h = {0, 4, 8};
    public static final SparseIntArray i;
    public static final SparseIntArray j;
    public String a;
    public String b = "";
    public String[] c = new String[0];
    public int d = 0;
    public final HashMap e = new HashMap();
    public boolean f = true;
    public final HashMap g = new HashMap();

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        i = sparseIntArray;
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        j = sparseIntArray2;
        sparseIntArray.append(j71.Constraint_layout_constraintLeft_toLeftOf, 25);
        sparseIntArray.append(j71.Constraint_layout_constraintLeft_toRightOf, 26);
        sparseIntArray.append(j71.Constraint_layout_constraintRight_toLeftOf, 29);
        sparseIntArray.append(j71.Constraint_layout_constraintRight_toRightOf, 30);
        sparseIntArray.append(j71.Constraint_layout_constraintTop_toTopOf, 36);
        sparseIntArray.append(j71.Constraint_layout_constraintTop_toBottomOf, 35);
        sparseIntArray.append(j71.Constraint_layout_constraintBottom_toTopOf, 4);
        sparseIntArray.append(j71.Constraint_layout_constraintBottom_toBottomOf, 3);
        sparseIntArray.append(j71.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        sparseIntArray.append(j71.Constraint_layout_constraintBaseline_toTopOf, 91);
        sparseIntArray.append(j71.Constraint_layout_constraintBaseline_toBottomOf, 92);
        sparseIntArray.append(j71.Constraint_layout_editor_absoluteX, 6);
        sparseIntArray.append(j71.Constraint_layout_editor_absoluteY, 7);
        sparseIntArray.append(j71.Constraint_layout_constraintGuide_begin, 17);
        sparseIntArray.append(j71.Constraint_layout_constraintGuide_end, 18);
        sparseIntArray.append(j71.Constraint_layout_constraintGuide_percent, 19);
        sparseIntArray.append(j71.Constraint_guidelineUseRtl, 99);
        sparseIntArray.append(j71.Constraint_android_orientation, 27);
        sparseIntArray.append(j71.Constraint_layout_constraintStart_toEndOf, 32);
        sparseIntArray.append(j71.Constraint_layout_constraintStart_toStartOf, 33);
        sparseIntArray.append(j71.Constraint_layout_constraintEnd_toStartOf, 10);
        sparseIntArray.append(j71.Constraint_layout_constraintEnd_toEndOf, 9);
        sparseIntArray.append(j71.Constraint_layout_goneMarginLeft, 13);
        sparseIntArray.append(j71.Constraint_layout_goneMarginTop, 16);
        sparseIntArray.append(j71.Constraint_layout_goneMarginRight, 14);
        sparseIntArray.append(j71.Constraint_layout_goneMarginBottom, 11);
        sparseIntArray.append(j71.Constraint_layout_goneMarginStart, 15);
        sparseIntArray.append(j71.Constraint_layout_goneMarginEnd, 12);
        sparseIntArray.append(j71.Constraint_layout_constraintVertical_weight, 40);
        sparseIntArray.append(j71.Constraint_layout_constraintHorizontal_weight, 39);
        sparseIntArray.append(j71.Constraint_layout_constraintHorizontal_chainStyle, 41);
        sparseIntArray.append(j71.Constraint_layout_constraintVertical_chainStyle, 42);
        sparseIntArray.append(j71.Constraint_layout_constraintHorizontal_bias, 20);
        sparseIntArray.append(j71.Constraint_layout_constraintVertical_bias, 37);
        sparseIntArray.append(j71.Constraint_layout_constraintDimensionRatio, 5);
        sparseIntArray.append(j71.Constraint_layout_constraintLeft_creator, 87);
        sparseIntArray.append(j71.Constraint_layout_constraintTop_creator, 87);
        sparseIntArray.append(j71.Constraint_layout_constraintRight_creator, 87);
        sparseIntArray.append(j71.Constraint_layout_constraintBottom_creator, 87);
        sparseIntArray.append(j71.Constraint_layout_constraintBaseline_creator, 87);
        sparseIntArray.append(j71.Constraint_android_layout_marginLeft, 24);
        sparseIntArray.append(j71.Constraint_android_layout_marginRight, 28);
        sparseIntArray.append(j71.Constraint_android_layout_marginStart, 31);
        sparseIntArray.append(j71.Constraint_android_layout_marginEnd, 8);
        sparseIntArray.append(j71.Constraint_android_layout_marginTop, 34);
        sparseIntArray.append(j71.Constraint_android_layout_marginBottom, 2);
        sparseIntArray.append(j71.Constraint_android_layout_width, 23);
        sparseIntArray.append(j71.Constraint_android_layout_height, 21);
        sparseIntArray.append(j71.Constraint_layout_constraintWidth, 95);
        sparseIntArray.append(j71.Constraint_layout_constraintHeight, 96);
        sparseIntArray.append(j71.Constraint_android_visibility, 22);
        sparseIntArray.append(j71.Constraint_android_alpha, 43);
        sparseIntArray.append(j71.Constraint_android_elevation, 44);
        sparseIntArray.append(j71.Constraint_android_rotationX, 45);
        sparseIntArray.append(j71.Constraint_android_rotationY, 46);
        sparseIntArray.append(j71.Constraint_android_rotation, 60);
        sparseIntArray.append(j71.Constraint_android_scaleX, 47);
        sparseIntArray.append(j71.Constraint_android_scaleY, 48);
        sparseIntArray.append(j71.Constraint_android_transformPivotX, 49);
        sparseIntArray.append(j71.Constraint_android_transformPivotY, 50);
        sparseIntArray.append(j71.Constraint_android_translationX, 51);
        sparseIntArray.append(j71.Constraint_android_translationY, 52);
        sparseIntArray.append(j71.Constraint_android_translationZ, 53);
        sparseIntArray.append(j71.Constraint_layout_constraintWidth_default, 54);
        sparseIntArray.append(j71.Constraint_layout_constraintHeight_default, 55);
        sparseIntArray.append(j71.Constraint_layout_constraintWidth_max, 56);
        sparseIntArray.append(j71.Constraint_layout_constraintHeight_max, 57);
        sparseIntArray.append(j71.Constraint_layout_constraintWidth_min, 58);
        sparseIntArray.append(j71.Constraint_layout_constraintHeight_min, 59);
        sparseIntArray.append(j71.Constraint_layout_constraintCircle, 61);
        sparseIntArray.append(j71.Constraint_layout_constraintCircleRadius, 62);
        sparseIntArray.append(j71.Constraint_layout_constraintCircleAngle, 63);
        sparseIntArray.append(j71.Constraint_animateRelativeTo, 64);
        sparseIntArray.append(j71.Constraint_transitionEasing, 65);
        sparseIntArray.append(j71.Constraint_drawPath, 66);
        sparseIntArray.append(j71.Constraint_transitionPathRotate, 67);
        sparseIntArray.append(j71.Constraint_motionStagger, 79);
        sparseIntArray.append(j71.Constraint_android_id, 38);
        sparseIntArray.append(j71.Constraint_motionProgress, 68);
        sparseIntArray.append(j71.Constraint_layout_constraintWidth_percent, 69);
        sparseIntArray.append(j71.Constraint_layout_constraintHeight_percent, 70);
        sparseIntArray.append(j71.Constraint_layout_wrapBehaviorInParent, 97);
        sparseIntArray.append(j71.Constraint_chainUseRtl, 71);
        sparseIntArray.append(j71.Constraint_barrierDirection, 72);
        sparseIntArray.append(j71.Constraint_barrierMargin, 73);
        sparseIntArray.append(j71.Constraint_constraint_referenced_ids, 74);
        sparseIntArray.append(j71.Constraint_barrierAllowsGoneWidgets, 75);
        sparseIntArray.append(j71.Constraint_pathMotionArc, 76);
        sparseIntArray.append(j71.Constraint_layout_constraintTag, 77);
        sparseIntArray.append(j71.Constraint_visibilityMode, 78);
        sparseIntArray.append(j71.Constraint_layout_constrainedWidth, 80);
        sparseIntArray.append(j71.Constraint_layout_constrainedHeight, 81);
        sparseIntArray.append(j71.Constraint_polarRelativeTo, 82);
        sparseIntArray.append(j71.Constraint_transformPivotTarget, 83);
        sparseIntArray.append(j71.Constraint_quantizeMotionSteps, 84);
        sparseIntArray.append(j71.Constraint_quantizeMotionPhase, 85);
        sparseIntArray.append(j71.Constraint_quantizeMotionInterpolator, 86);
        sparseIntArray2.append(j71.ConstraintOverride_layout_editor_absoluteY, 6);
        sparseIntArray2.append(j71.ConstraintOverride_layout_editor_absoluteY, 7);
        sparseIntArray2.append(j71.ConstraintOverride_android_orientation, 27);
        sparseIntArray2.append(j71.ConstraintOverride_layout_goneMarginLeft, 13);
        sparseIntArray2.append(j71.ConstraintOverride_layout_goneMarginTop, 16);
        sparseIntArray2.append(j71.ConstraintOverride_layout_goneMarginRight, 14);
        sparseIntArray2.append(j71.ConstraintOverride_layout_goneMarginBottom, 11);
        sparseIntArray2.append(j71.ConstraintOverride_layout_goneMarginStart, 15);
        sparseIntArray2.append(j71.ConstraintOverride_layout_goneMarginEnd, 12);
        sparseIntArray2.append(j71.ConstraintOverride_layout_constraintVertical_weight, 40);
        sparseIntArray2.append(j71.ConstraintOverride_layout_constraintHorizontal_weight, 39);
        sparseIntArray2.append(j71.ConstraintOverride_layout_constraintHorizontal_chainStyle, 41);
        sparseIntArray2.append(j71.ConstraintOverride_layout_constraintVertical_chainStyle, 42);
        sparseIntArray2.append(j71.ConstraintOverride_layout_constraintHorizontal_bias, 20);
        sparseIntArray2.append(j71.ConstraintOverride_layout_constraintVertical_bias, 37);
        sparseIntArray2.append(j71.ConstraintOverride_layout_constraintDimensionRatio, 5);
        sparseIntArray2.append(j71.ConstraintOverride_layout_constraintLeft_creator, 87);
        sparseIntArray2.append(j71.ConstraintOverride_layout_constraintTop_creator, 87);
        sparseIntArray2.append(j71.ConstraintOverride_layout_constraintRight_creator, 87);
        sparseIntArray2.append(j71.ConstraintOverride_layout_constraintBottom_creator, 87);
        sparseIntArray2.append(j71.ConstraintOverride_layout_constraintBaseline_creator, 87);
        sparseIntArray2.append(j71.ConstraintOverride_android_layout_marginLeft, 24);
        sparseIntArray2.append(j71.ConstraintOverride_android_layout_marginRight, 28);
        sparseIntArray2.append(j71.ConstraintOverride_android_layout_marginStart, 31);
        sparseIntArray2.append(j71.ConstraintOverride_android_layout_marginEnd, 8);
        sparseIntArray2.append(j71.ConstraintOverride_android_layout_marginTop, 34);
        sparseIntArray2.append(j71.ConstraintOverride_android_layout_marginBottom, 2);
        sparseIntArray2.append(j71.ConstraintOverride_android_layout_width, 23);
        sparseIntArray2.append(j71.ConstraintOverride_android_layout_height, 21);
        sparseIntArray2.append(j71.ConstraintOverride_layout_constraintWidth, 95);
        sparseIntArray2.append(j71.ConstraintOverride_layout_constraintHeight, 96);
        sparseIntArray2.append(j71.ConstraintOverride_android_visibility, 22);
        sparseIntArray2.append(j71.ConstraintOverride_android_alpha, 43);
        sparseIntArray2.append(j71.ConstraintOverride_android_elevation, 44);
        sparseIntArray2.append(j71.ConstraintOverride_android_rotationX, 45);
        sparseIntArray2.append(j71.ConstraintOverride_android_rotationY, 46);
        sparseIntArray2.append(j71.ConstraintOverride_android_rotation, 60);
        sparseIntArray2.append(j71.ConstraintOverride_android_scaleX, 47);
        sparseIntArray2.append(j71.ConstraintOverride_android_scaleY, 48);
        sparseIntArray2.append(j71.ConstraintOverride_android_transformPivotX, 49);
        sparseIntArray2.append(j71.ConstraintOverride_android_transformPivotY, 50);
        sparseIntArray2.append(j71.ConstraintOverride_android_translationX, 51);
        sparseIntArray2.append(j71.ConstraintOverride_android_translationY, 52);
        sparseIntArray2.append(j71.ConstraintOverride_android_translationZ, 53);
        sparseIntArray2.append(j71.ConstraintOverride_layout_constraintWidth_default, 54);
        sparseIntArray2.append(j71.ConstraintOverride_layout_constraintHeight_default, 55);
        sparseIntArray2.append(j71.ConstraintOverride_layout_constraintWidth_max, 56);
        sparseIntArray2.append(j71.ConstraintOverride_layout_constraintHeight_max, 57);
        sparseIntArray2.append(j71.ConstraintOverride_layout_constraintWidth_min, 58);
        sparseIntArray2.append(j71.ConstraintOverride_layout_constraintHeight_min, 59);
        sparseIntArray2.append(j71.ConstraintOverride_layout_constraintCircleRadius, 62);
        sparseIntArray2.append(j71.ConstraintOverride_layout_constraintCircleAngle, 63);
        sparseIntArray2.append(j71.ConstraintOverride_animateRelativeTo, 64);
        sparseIntArray2.append(j71.ConstraintOverride_transitionEasing, 65);
        sparseIntArray2.append(j71.ConstraintOverride_drawPath, 66);
        sparseIntArray2.append(j71.ConstraintOverride_transitionPathRotate, 67);
        sparseIntArray2.append(j71.ConstraintOverride_motionStagger, 79);
        sparseIntArray2.append(j71.ConstraintOverride_android_id, 38);
        sparseIntArray2.append(j71.ConstraintOverride_motionTarget, 98);
        sparseIntArray2.append(j71.ConstraintOverride_motionProgress, 68);
        sparseIntArray2.append(j71.ConstraintOverride_layout_constraintWidth_percent, 69);
        sparseIntArray2.append(j71.ConstraintOverride_layout_constraintHeight_percent, 70);
        sparseIntArray2.append(j71.ConstraintOverride_chainUseRtl, 71);
        sparseIntArray2.append(j71.ConstraintOverride_barrierDirection, 72);
        sparseIntArray2.append(j71.ConstraintOverride_barrierMargin, 73);
        sparseIntArray2.append(j71.ConstraintOverride_constraint_referenced_ids, 74);
        sparseIntArray2.append(j71.ConstraintOverride_barrierAllowsGoneWidgets, 75);
        sparseIntArray2.append(j71.ConstraintOverride_pathMotionArc, 76);
        sparseIntArray2.append(j71.ConstraintOverride_layout_constraintTag, 77);
        sparseIntArray2.append(j71.ConstraintOverride_visibilityMode, 78);
        sparseIntArray2.append(j71.ConstraintOverride_layout_constrainedWidth, 80);
        sparseIntArray2.append(j71.ConstraintOverride_layout_constrainedHeight, 81);
        sparseIntArray2.append(j71.ConstraintOverride_polarRelativeTo, 82);
        sparseIntArray2.append(j71.ConstraintOverride_transformPivotTarget, 83);
        sparseIntArray2.append(j71.ConstraintOverride_quantizeMotionSteps, 84);
        sparseIntArray2.append(j71.ConstraintOverride_quantizeMotionPhase, 85);
        sparseIntArray2.append(j71.ConstraintOverride_quantizeMotionInterpolator, 86);
        sparseIntArray2.append(j71.ConstraintOverride_layout_wrapBehaviorInParent, 97);
    }

    public static zm d(Context context, XmlPullParser xmlPullParser) {
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlPullParser);
        zm zmVar = new zm();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSetAsAttributeSet, j71.ConstraintOverride);
        r(zmVar, typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
        return zmVar;
    }

    public static int[] h(Barrier barrier, String str) {
        int iIntValue;
        Object designInformation;
        String[] strArrSplit = str.split(",");
        Context context = barrier.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i2 = 0;
        int i3 = 0;
        while (i2 < strArrSplit.length) {
            String strTrim = strArrSplit[i2].trim();
            try {
                iIntValue = x51.class.getField(strTrim).getInt(null);
            } catch (Exception unused) {
                iIntValue = 0;
            }
            if (iIntValue == 0) {
                iIntValue = context.getResources().getIdentifier(strTrim, "id", context.getPackageName());
            }
            if (iIntValue == 0 && barrier.isInEditMode() && (barrier.getParent() instanceof ConstraintLayout) && (designInformation = ((ConstraintLayout) barrier.getParent()).getDesignInformation(0, strTrim)) != null && (designInformation instanceof Integer)) {
                iIntValue = ((Integer) designInformation).intValue();
            }
            iArr[i3] = iIntValue;
            i2++;
            i3++;
        }
        return i3 != strArrSplit.length ? Arrays.copyOf(iArr, i3) : iArr;
    }

    public static zm j(Context context, AttributeSet attributeSet, boolean z) {
        zm zmVar = new zm();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z ? j71.ConstraintOverride : j71.Constraint);
        if (z) {
            r(zmVar, typedArrayObtainStyledAttributes);
        } else {
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            int i2 = 0;
            while (true) {
                an anVar = zmVar.e;
                if (i2 < indexCount) {
                    int index = typedArrayObtainStyledAttributes.getIndex(i2);
                    int i3 = j71.Constraint_android_id;
                    cn cnVar = zmVar.c;
                    dn dnVar = zmVar.f;
                    bn bnVar = zmVar.d;
                    if (index != i3 && j71.Constraint_android_layout_marginStart != index && j71.Constraint_android_layout_marginEnd != index) {
                        bnVar.a = true;
                        anVar.b = true;
                        cnVar.a = true;
                        dnVar.a = true;
                    }
                    SparseIntArray sparseIntArray = i;
                    switch (sparseIntArray.get(index)) {
                        case 1:
                            anVar.q = o(typedArrayObtainStyledAttributes, index, anVar.q);
                            break;
                        case 2:
                            anVar.J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, anVar.J);
                            break;
                        case 3:
                            anVar.p = o(typedArrayObtainStyledAttributes, index, anVar.p);
                            break;
                        case 4:
                            anVar.o = o(typedArrayObtainStyledAttributes, index, anVar.o);
                            break;
                        case 5:
                            anVar.z = typedArrayObtainStyledAttributes.getString(index);
                            break;
                        case 6:
                            anVar.D = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, anVar.D);
                            break;
                        case 7:
                            anVar.E = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, anVar.E);
                            break;
                        case 8:
                            anVar.K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, anVar.K);
                            break;
                        case 9:
                            anVar.w = o(typedArrayObtainStyledAttributes, index, anVar.w);
                            break;
                        case 10:
                            anVar.v = o(typedArrayObtainStyledAttributes, index, anVar.v);
                            break;
                        case 11:
                            anVar.Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, anVar.Q);
                            break;
                        case 12:
                            anVar.R = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, anVar.R);
                            break;
                        case 13:
                            anVar.N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, anVar.N);
                            break;
                        case 14:
                            anVar.P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, anVar.P);
                            break;
                        case 15:
                            anVar.S = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, anVar.S);
                            break;
                        case 16:
                            anVar.O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, anVar.O);
                            break;
                        case 17:
                            anVar.e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, anVar.e);
                            break;
                        case 18:
                            anVar.f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, anVar.f);
                            break;
                        case 19:
                            anVar.g = typedArrayObtainStyledAttributes.getFloat(index, anVar.g);
                            break;
                        case 20:
                            anVar.x = typedArrayObtainStyledAttributes.getFloat(index, anVar.x);
                            break;
                        case zzbbc.zzt.zzm /* 21 */:
                            anVar.d = typedArrayObtainStyledAttributes.getLayoutDimension(index, anVar.d);
                            break;
                        case 22:
                            int i4 = typedArrayObtainStyledAttributes.getInt(index, cnVar.b);
                            cnVar.b = i4;
                            cnVar.b = h[i4];
                            break;
                        case 23:
                            anVar.c = typedArrayObtainStyledAttributes.getLayoutDimension(index, anVar.c);
                            break;
                        case ProfileVersion.MIN_SUPPORTED_SDK /* 24 */:
                            anVar.G = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, anVar.G);
                            break;
                        case 25:
                            anVar.i = o(typedArrayObtainStyledAttributes, index, anVar.i);
                            break;
                        case 26:
                            anVar.j = o(typedArrayObtainStyledAttributes, index, anVar.j);
                            break;
                        case 27:
                            anVar.F = typedArrayObtainStyledAttributes.getInt(index, anVar.F);
                            break;
                        case 28:
                            anVar.H = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, anVar.H);
                            break;
                        case 29:
                            anVar.k = o(typedArrayObtainStyledAttributes, index, anVar.k);
                            break;
                        case 30:
                            anVar.l = o(typedArrayObtainStyledAttributes, index, anVar.l);
                            break;
                        case 31:
                            anVar.L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, anVar.L);
                            break;
                        case 32:
                            anVar.t = o(typedArrayObtainStyledAttributes, index, anVar.t);
                            break;
                        case 33:
                            anVar.u = o(typedArrayObtainStyledAttributes, index, anVar.u);
                            break;
                        case 34:
                            anVar.I = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, anVar.I);
                            break;
                        case 35:
                            anVar.n = o(typedArrayObtainStyledAttributes, index, anVar.n);
                            break;
                        case 36:
                            anVar.m = o(typedArrayObtainStyledAttributes, index, anVar.m);
                            break;
                        case 37:
                            anVar.y = typedArrayObtainStyledAttributes.getFloat(index, anVar.y);
                            break;
                        case 38:
                            zmVar.a = typedArrayObtainStyledAttributes.getResourceId(index, zmVar.a);
                            break;
                        case 39:
                            anVar.V = typedArrayObtainStyledAttributes.getFloat(index, anVar.V);
                            break;
                        case 40:
                            anVar.U = typedArrayObtainStyledAttributes.getFloat(index, anVar.U);
                            break;
                        case 41:
                            anVar.W = typedArrayObtainStyledAttributes.getInt(index, anVar.W);
                            break;
                        case 42:
                            anVar.X = typedArrayObtainStyledAttributes.getInt(index, anVar.X);
                            break;
                        case 43:
                            cnVar.d = typedArrayObtainStyledAttributes.getFloat(index, cnVar.d);
                            break;
                        case 44:
                            dnVar.m = true;
                            dnVar.n = typedArrayObtainStyledAttributes.getDimension(index, dnVar.n);
                            break;
                        case 45:
                            dnVar.c = typedArrayObtainStyledAttributes.getFloat(index, dnVar.c);
                            break;
                        case 46:
                            dnVar.d = typedArrayObtainStyledAttributes.getFloat(index, dnVar.d);
                            break;
                        case 47:
                            dnVar.e = typedArrayObtainStyledAttributes.getFloat(index, dnVar.e);
                            break;
                        case 48:
                            dnVar.f = typedArrayObtainStyledAttributes.getFloat(index, dnVar.f);
                            break;
                        case 49:
                            dnVar.g = typedArrayObtainStyledAttributes.getDimension(index, dnVar.g);
                            break;
                        case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH /* 50 */:
                            dnVar.h = typedArrayObtainStyledAttributes.getDimension(index, dnVar.h);
                            break;
                        case 51:
                            dnVar.j = typedArrayObtainStyledAttributes.getDimension(index, dnVar.j);
                            break;
                        case 52:
                            dnVar.k = typedArrayObtainStyledAttributes.getDimension(index, dnVar.k);
                            break;
                        case 53:
                            dnVar.l = typedArrayObtainStyledAttributes.getDimension(index, dnVar.l);
                            break;
                        case 54:
                            anVar.Y = typedArrayObtainStyledAttributes.getInt(index, anVar.Y);
                            break;
                        case 55:
                            anVar.Z = typedArrayObtainStyledAttributes.getInt(index, anVar.Z);
                            break;
                        case 56:
                            anVar.a0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, anVar.a0);
                            break;
                        case 57:
                            anVar.b0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, anVar.b0);
                            break;
                        case 58:
                            anVar.c0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, anVar.c0);
                            break;
                        case 59:
                            anVar.d0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, anVar.d0);
                            break;
                        case 60:
                            dnVar.b = typedArrayObtainStyledAttributes.getFloat(index, dnVar.b);
                            break;
                        case 61:
                            anVar.A = o(typedArrayObtainStyledAttributes, index, anVar.A);
                            break;
                        case 62:
                            anVar.B = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, anVar.B);
                            break;
                        case 63:
                            anVar.C = typedArrayObtainStyledAttributes.getFloat(index, anVar.C);
                            break;
                        case 64:
                            bnVar.b = o(typedArrayObtainStyledAttributes, index, bnVar.b);
                            break;
                        case 65:
                            if (typedArrayObtainStyledAttributes.peekValue(index).type != 3) {
                                bnVar.d = fy.c[typedArrayObtainStyledAttributes.getInteger(index, 0)];
                            } else {
                                bnVar.d = typedArrayObtainStyledAttributes.getString(index);
                            }
                            break;
                        case 66:
                            bnVar.f = typedArrayObtainStyledAttributes.getInt(index, 0);
                            break;
                        case 67:
                            bnVar.h = typedArrayObtainStyledAttributes.getFloat(index, bnVar.h);
                            break;
                        case 68:
                            cnVar.e = typedArrayObtainStyledAttributes.getFloat(index, cnVar.e);
                            break;
                        case 69:
                            anVar.e0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                            break;
                        case 70:
                            anVar.f0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                            break;
                        case 71:
                            break;
                        case 72:
                            anVar.g0 = typedArrayObtainStyledAttributes.getInt(index, anVar.g0);
                            break;
                        case 73:
                            anVar.h0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, anVar.h0);
                            break;
                        case 74:
                            anVar.k0 = typedArrayObtainStyledAttributes.getString(index);
                            break;
                        case 75:
                            anVar.o0 = typedArrayObtainStyledAttributes.getBoolean(index, anVar.o0);
                            break;
                        case 76:
                            bnVar.e = typedArrayObtainStyledAttributes.getInt(index, bnVar.e);
                            break;
                        case 77:
                            anVar.l0 = typedArrayObtainStyledAttributes.getString(index);
                            break;
                        case 78:
                            cnVar.c = typedArrayObtainStyledAttributes.getInt(index, cnVar.c);
                            break;
                        case 79:
                            bnVar.g = typedArrayObtainStyledAttributes.getFloat(index, bnVar.g);
                            break;
                        case 80:
                            anVar.m0 = typedArrayObtainStyledAttributes.getBoolean(index, anVar.m0);
                            break;
                        case 81:
                            anVar.n0 = typedArrayObtainStyledAttributes.getBoolean(index, anVar.n0);
                            break;
                        case 82:
                            bnVar.c = typedArrayObtainStyledAttributes.getInteger(index, bnVar.c);
                            break;
                        case 83:
                            dnVar.i = o(typedArrayObtainStyledAttributes, index, dnVar.i);
                            break;
                        case 84:
                            bnVar.j = typedArrayObtainStyledAttributes.getInteger(index, bnVar.j);
                            break;
                        case 85:
                            bnVar.i = typedArrayObtainStyledAttributes.getFloat(index, bnVar.i);
                            break;
                        case 86:
                            int i5 = typedArrayObtainStyledAttributes.peekValue(index).type;
                            if (i5 == 1) {
                                int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                                bnVar.m = resourceId;
                                if (resourceId != -1) {
                                    bnVar.l = -2;
                                }
                            } else if (i5 != 3) {
                                bnVar.l = typedArrayObtainStyledAttributes.getInteger(index, bnVar.m);
                            } else {
                                String string = typedArrayObtainStyledAttributes.getString(index);
                                bnVar.k = string;
                                if (string.indexOf("/") <= 0) {
                                    bnVar.l = -1;
                                } else {
                                    bnVar.m = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                                    bnVar.l = -2;
                                }
                            }
                            break;
                        case 87:
                            Integer.toHexString(index);
                            sparseIntArray.get(index);
                            break;
                        case 88:
                        case 89:
                        case 90:
                        default:
                            Integer.toHexString(index);
                            sparseIntArray.get(index);
                            break;
                        case 91:
                            anVar.r = o(typedArrayObtainStyledAttributes, index, anVar.r);
                            break;
                        case 92:
                            anVar.s = o(typedArrayObtainStyledAttributes, index, anVar.s);
                            break;
                        case 93:
                            anVar.M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, anVar.M);
                            break;
                        case 94:
                            anVar.T = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, anVar.T);
                            break;
                        case 95:
                            p(anVar, typedArrayObtainStyledAttributes, index, 0);
                            break;
                        case 96:
                            p(anVar, typedArrayObtainStyledAttributes, index, 1);
                            break;
                        case 97:
                            anVar.p0 = typedArrayObtainStyledAttributes.getInt(index, anVar.p0);
                            break;
                    }
                    i2++;
                } else if (anVar.k0 != null) {
                    anVar.j0 = null;
                }
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return zmVar;
    }

    public static int o(TypedArray typedArray, int i2, int i3) {
        int resourceId = typedArray.getResourceId(i2, i3);
        return resourceId == -1 ? typedArray.getInt(i2, -1) : resourceId;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void p(java.lang.Object r7, android.content.res.TypedArray r8, int r9, int r10) {
        /*
            Method dump skipped, instruction units count: 369
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.en.p(java.lang.Object, android.content.res.TypedArray, int, int):void");
    }

    public static void q(String str, nm nmVar) {
        if (str != null) {
            int length = str.length();
            int iIndexOf = str.indexOf(44);
            byte b = -1;
            int i2 = 0;
            if (iIndexOf > 0 && iIndexOf < length - 1) {
                String strSubstring = str.substring(0, iIndexOf);
                if (strSubstring.equalsIgnoreCase("W")) {
                    b = 0;
                } else if (strSubstring.equalsIgnoreCase("H")) {
                    b = 1;
                }
                i2 = iIndexOf + 1;
            }
            int iIndexOf2 = str.indexOf(58);
            try {
                if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                    String strSubstring2 = str.substring(i2);
                    if (strSubstring2.length() > 0) {
                        Float.parseFloat(strSubstring2);
                    }
                } else {
                    String strSubstring3 = str.substring(i2, iIndexOf2);
                    String strSubstring4 = str.substring(iIndexOf2 + 1);
                    if (strSubstring3.length() > 0 && strSubstring4.length() > 0) {
                        float f = Float.parseFloat(strSubstring3);
                        float f2 = Float.parseFloat(strSubstring4);
                        if (f > 0.0f && f2 > 0.0f) {
                            if (b == 1) {
                                Math.abs(f2 / f);
                            } else {
                                Math.abs(f / f2);
                            }
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        nmVar.G = str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void r(zm zmVar, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        ym ymVar = new ym();
        ymVar.a = new int[10];
        ymVar.b = new int[10];
        int i2 = 0;
        ymVar.c = 0;
        ymVar.d = new int[10];
        ymVar.e = new float[10];
        ymVar.f = 0;
        ymVar.g = new int[5];
        ymVar.h = new String[5];
        ymVar.i = 0;
        ymVar.j = new int[4];
        ymVar.k = new boolean[4];
        ymVar.l = 0;
        zmVar.h = ymVar;
        bn bnVar = zmVar.d;
        bnVar.a = false;
        an anVar = zmVar.e;
        anVar.b = false;
        cn cnVar = zmVar.c;
        cnVar.a = false;
        dn dnVar = zmVar.f;
        dnVar.a = false;
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = typedArray.getIndex(i3);
            int i4 = j.get(index);
            SparseIntArray sparseIntArray = i;
            switch (i4) {
                case 2:
                    ymVar.b(2, typedArray.getDimensionPixelSize(index, anVar.J));
                    break;
                case 3:
                case 4:
                case 9:
                case 10:
                case 25:
                case 26:
                case 29:
                case 30:
                case 32:
                case 33:
                case 35:
                case 36:
                case 61:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                default:
                    Integer.toHexString(index);
                    sparseIntArray.get(index);
                    break;
                case 5:
                    ymVar.c(5, typedArray.getString(index));
                    break;
                case 6:
                    ymVar.b(6, typedArray.getDimensionPixelOffset(index, anVar.D));
                    break;
                case 7:
                    ymVar.b(7, typedArray.getDimensionPixelOffset(index, anVar.E));
                    break;
                case 8:
                    ymVar.b(8, typedArray.getDimensionPixelSize(index, anVar.K));
                    break;
                case 11:
                    ymVar.b(11, typedArray.getDimensionPixelSize(index, anVar.Q));
                    break;
                case 12:
                    ymVar.b(12, typedArray.getDimensionPixelSize(index, anVar.R));
                    break;
                case 13:
                    ymVar.b(13, typedArray.getDimensionPixelSize(index, anVar.N));
                    break;
                case 14:
                    ymVar.b(14, typedArray.getDimensionPixelSize(index, anVar.P));
                    break;
                case 15:
                    ymVar.b(15, typedArray.getDimensionPixelSize(index, anVar.S));
                    break;
                case 16:
                    ymVar.b(16, typedArray.getDimensionPixelSize(index, anVar.O));
                    break;
                case 17:
                    ymVar.b(17, typedArray.getDimensionPixelOffset(index, anVar.e));
                    break;
                case 18:
                    ymVar.b(18, typedArray.getDimensionPixelOffset(index, anVar.f));
                    break;
                case 19:
                    ymVar.a(typedArray.getFloat(index, anVar.g), 19);
                    break;
                case 20:
                    ymVar.a(typedArray.getFloat(index, anVar.x), 20);
                    break;
                case zzbbc.zzt.zzm /* 21 */:
                    ymVar.b(21, typedArray.getLayoutDimension(index, anVar.d));
                    break;
                case 22:
                    ymVar.b(22, h[typedArray.getInt(index, cnVar.b)]);
                    break;
                case 23:
                    ymVar.b(23, typedArray.getLayoutDimension(index, anVar.c));
                    break;
                case ProfileVersion.MIN_SUPPORTED_SDK /* 24 */:
                    ymVar.b(24, typedArray.getDimensionPixelSize(index, anVar.G));
                    break;
                case 27:
                    ymVar.b(27, typedArray.getInt(index, anVar.F));
                    break;
                case 28:
                    ymVar.b(28, typedArray.getDimensionPixelSize(index, anVar.H));
                    break;
                case 31:
                    ymVar.b(31, typedArray.getDimensionPixelSize(index, anVar.L));
                    break;
                case 34:
                    ymVar.b(34, typedArray.getDimensionPixelSize(index, anVar.I));
                    break;
                case 37:
                    ymVar.a(typedArray.getFloat(index, anVar.y), 37);
                    break;
                case 38:
                    int resourceId = typedArray.getResourceId(index, zmVar.a);
                    zmVar.a = resourceId;
                    ymVar.b(38, resourceId);
                    break;
                case 39:
                    ymVar.a(typedArray.getFloat(index, anVar.V), 39);
                    break;
                case 40:
                    ymVar.a(typedArray.getFloat(index, anVar.U), 40);
                    break;
                case 41:
                    ymVar.b(41, typedArray.getInt(index, anVar.W));
                    break;
                case 42:
                    ymVar.b(42, typedArray.getInt(index, anVar.X));
                    break;
                case 43:
                    ymVar.a(typedArray.getFloat(index, cnVar.d), 43);
                    break;
                case 44:
                    ymVar.d(44, true);
                    ymVar.a(typedArray.getDimension(index, dnVar.n), 44);
                    break;
                case 45:
                    ymVar.a(typedArray.getFloat(index, dnVar.c), 45);
                    break;
                case 46:
                    ymVar.a(typedArray.getFloat(index, dnVar.d), 46);
                    break;
                case 47:
                    ymVar.a(typedArray.getFloat(index, dnVar.e), 47);
                    break;
                case 48:
                    ymVar.a(typedArray.getFloat(index, dnVar.f), 48);
                    break;
                case 49:
                    ymVar.a(typedArray.getDimension(index, dnVar.g), 49);
                    break;
                case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH /* 50 */:
                    ymVar.a(typedArray.getDimension(index, dnVar.h), 50);
                    break;
                case 51:
                    ymVar.a(typedArray.getDimension(index, dnVar.j), 51);
                    break;
                case 52:
                    ymVar.a(typedArray.getDimension(index, dnVar.k), 52);
                    break;
                case 53:
                    ymVar.a(typedArray.getDimension(index, dnVar.l), 53);
                    break;
                case 54:
                    ymVar.b(54, typedArray.getInt(index, anVar.Y));
                    break;
                case 55:
                    ymVar.b(55, typedArray.getInt(index, anVar.Z));
                    break;
                case 56:
                    ymVar.b(56, typedArray.getDimensionPixelSize(index, anVar.a0));
                    break;
                case 57:
                    ymVar.b(57, typedArray.getDimensionPixelSize(index, anVar.b0));
                    break;
                case 58:
                    ymVar.b(58, typedArray.getDimensionPixelSize(index, anVar.c0));
                    break;
                case 59:
                    ymVar.b(59, typedArray.getDimensionPixelSize(index, anVar.d0));
                    break;
                case 60:
                    ymVar.a(typedArray.getFloat(index, dnVar.b), 60);
                    break;
                case 62:
                    ymVar.b(62, typedArray.getDimensionPixelSize(index, anVar.B));
                    break;
                case 63:
                    ymVar.a(typedArray.getFloat(index, anVar.C), 63);
                    break;
                case 64:
                    ymVar.b(64, o(typedArray, index, bnVar.b));
                    break;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        ymVar.c(65, typedArray.getString(index));
                    } else {
                        ymVar.c(65, fy.c[typedArray.getInteger(index, i2)]);
                    }
                    break;
                case 66:
                    i2 = 0;
                    ymVar.b(66, typedArray.getInt(index, 0));
                    break;
                case 67:
                    ymVar.a(typedArray.getFloat(index, bnVar.h), 67);
                    i2 = 0;
                    break;
                case 68:
                    ymVar.a(typedArray.getFloat(index, cnVar.e), 68);
                    i2 = 0;
                    break;
                case 69:
                    ymVar.a(typedArray.getFloat(index, 1.0f), 69);
                    i2 = 0;
                    break;
                case 70:
                    ymVar.a(typedArray.getFloat(index, 1.0f), 70);
                    i2 = 0;
                    break;
                case 71:
                    break;
                case 72:
                    ymVar.b(72, typedArray.getInt(index, anVar.g0));
                    i2 = 0;
                    break;
                case 73:
                    ymVar.b(73, typedArray.getDimensionPixelSize(index, anVar.h0));
                    i2 = 0;
                    break;
                case 74:
                    ymVar.c(74, typedArray.getString(index));
                    i2 = 0;
                    break;
                case 75:
                    ymVar.d(75, typedArray.getBoolean(index, anVar.o0));
                    i2 = 0;
                    break;
                case 76:
                    ymVar.b(76, typedArray.getInt(index, bnVar.e));
                    i2 = 0;
                    break;
                case 77:
                    ymVar.c(77, typedArray.getString(index));
                    i2 = 0;
                    break;
                case 78:
                    ymVar.b(78, typedArray.getInt(index, cnVar.c));
                    i2 = 0;
                    break;
                case 79:
                    ymVar.a(typedArray.getFloat(index, bnVar.g), 79);
                    i2 = 0;
                    break;
                case 80:
                    ymVar.d(80, typedArray.getBoolean(index, anVar.m0));
                    i2 = 0;
                    break;
                case 81:
                    ymVar.d(81, typedArray.getBoolean(index, anVar.n0));
                    i2 = 0;
                    break;
                case 82:
                    ymVar.b(82, typedArray.getInteger(index, bnVar.c));
                    i2 = 0;
                    break;
                case 83:
                    ymVar.b(83, o(typedArray, index, dnVar.i));
                    i2 = 0;
                    break;
                case 84:
                    ymVar.b(84, typedArray.getInteger(index, bnVar.j));
                    i2 = 0;
                    break;
                case 85:
                    ymVar.a(typedArray.getFloat(index, bnVar.i), 85);
                    i2 = 0;
                    break;
                case 86:
                    int i5 = typedArray.peekValue(index).type;
                    if (i5 == 1) {
                        int resourceId2 = typedArray.getResourceId(index, -1);
                        bnVar.m = resourceId2;
                        ymVar.b(89, resourceId2);
                        if (bnVar.m != -1) {
                            bnVar.l = -2;
                            ymVar.b(88, -2);
                        }
                    } else if (i5 == 3) {
                        String string = typedArray.getString(index);
                        bnVar.k = string;
                        ymVar.c(90, string);
                        if (bnVar.k.indexOf("/") > 0) {
                            int resourceId3 = typedArray.getResourceId(index, -1);
                            bnVar.m = resourceId3;
                            ymVar.b(89, resourceId3);
                            bnVar.l = -2;
                            ymVar.b(88, -2);
                        } else {
                            bnVar.l = -1;
                            ymVar.b(88, -1);
                        }
                    } else {
                        int integer = typedArray.getInteger(index, bnVar.m);
                        bnVar.l = integer;
                        ymVar.b(88, integer);
                    }
                    i2 = 0;
                    break;
                case 87:
                    Integer.toHexString(index);
                    sparseIntArray.get(index);
                    break;
                case 93:
                    ymVar.b(93, typedArray.getDimensionPixelSize(index, anVar.M));
                    break;
                case 94:
                    ymVar.b(94, typedArray.getDimensionPixelSize(index, anVar.T));
                    break;
                case 95:
                    p(ymVar, typedArray, index, i2);
                    break;
                case 96:
                    p(ymVar, typedArray, index, 1);
                    break;
                case 97:
                    ymVar.b(97, typedArray.getInt(index, anVar.p0));
                    break;
                case 98:
                    if (MotionLayout.IS_IN_EDIT_MODE) {
                        int resourceId4 = typedArray.getResourceId(index, zmVar.a);
                        zmVar.a = resourceId4;
                        if (resourceId4 == -1) {
                            zmVar.b = typedArray.getString(index);
                        }
                    } else if (typedArray.peekValue(index).type == 3) {
                        zmVar.b = typedArray.getString(index);
                    } else {
                        zmVar.a = typedArray.getResourceId(index, zmVar.a);
                    }
                    break;
                case 99:
                    ymVar.d(99, typedArray.getBoolean(index, anVar.h));
                    break;
            }
        }
    }

    public static String t(int i2) {
        switch (i2) {
            case 1:
                return "left";
            case 2:
                return "right";
            case 3:
                return "top";
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return "start";
            case 7:
                return "end";
            default:
                return "undefined";
        }
    }

    public final void a(MotionLayout motionLayout) {
        zm zmVar;
        int childCount = motionLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = motionLayout.getChildAt(i2);
            int id = childAt.getId();
            HashMap map = this.g;
            if (!map.containsKey(Integer.valueOf(id))) {
                Debug.getName(childAt);
            } else {
                if (this.f && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (map.containsKey(Integer.valueOf(id)) && (zmVar = (zm) map.get(Integer.valueOf(id))) != null) {
                    hm.e(childAt, zmVar.g);
                }
            }
        }
    }

    public final void b(ConstraintLayout constraintLayout) {
        c(constraintLayout);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    public final void c(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        HashMap map = this.g;
        HashSet<Integer> hashSet = new HashSet(map.keySet());
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            int id = childAt.getId();
            if (!map.containsKey(Integer.valueOf(id))) {
                Debug.getName(childAt);
            } else {
                if (this.f && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id != -1 && map.containsKey(Integer.valueOf(id))) {
                    hashSet.remove(Integer.valueOf(id));
                    zm zmVar = (zm) map.get(Integer.valueOf(id));
                    if (zmVar != null) {
                        if (childAt instanceof Barrier) {
                            an anVar = zmVar.e;
                            anVar.i0 = 1;
                            Barrier barrier = (Barrier) childAt;
                            barrier.setId(id);
                            barrier.setType(anVar.g0);
                            barrier.setMargin(anVar.h0);
                            barrier.setAllowsGoneWidget(anVar.o0);
                            int[] iArr = anVar.j0;
                            if (iArr != null) {
                                barrier.setReferencedIds(iArr);
                            } else {
                                String str = anVar.k0;
                                if (str != null) {
                                    int[] iArrH = h(barrier, str);
                                    anVar.j0 = iArrH;
                                    barrier.setReferencedIds(iArrH);
                                }
                            }
                        }
                        nm nmVar = (nm) childAt.getLayoutParams();
                        nmVar.a();
                        zmVar.b(nmVar);
                        hm.e(childAt, zmVar.g);
                        childAt.setLayoutParams(nmVar);
                        cn cnVar = zmVar.c;
                        if (cnVar.c == 0) {
                            childAt.setVisibility(cnVar.b);
                        }
                        childAt.setAlpha(cnVar.d);
                        dn dnVar = zmVar.f;
                        childAt.setRotation(dnVar.b);
                        childAt.setRotationX(dnVar.c);
                        childAt.setRotationY(dnVar.d);
                        childAt.setScaleX(dnVar.e);
                        childAt.setScaleY(dnVar.f);
                        if (dnVar.i != -1) {
                            if (((View) childAt.getParent()).findViewById(dnVar.i) != null) {
                                float bottom = (r7.getBottom() + r7.getTop()) / 2.0f;
                                float right = (r7.getRight() + r7.getLeft()) / 2.0f;
                                if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                    childAt.setPivotX(right - childAt.getLeft());
                                    childAt.setPivotY(bottom - childAt.getTop());
                                }
                            }
                        } else {
                            if (!Float.isNaN(dnVar.g)) {
                                childAt.setPivotX(dnVar.g);
                            }
                            if (!Float.isNaN(dnVar.h)) {
                                childAt.setPivotY(dnVar.h);
                            }
                        }
                        childAt.setTranslationX(dnVar.j);
                        childAt.setTranslationY(dnVar.k);
                        childAt.setTranslationZ(dnVar.l);
                        if (dnVar.m) {
                            childAt.setElevation(dnVar.n);
                        }
                    }
                }
            }
        }
        for (Integer num : hashSet) {
            zm zmVar2 = (zm) map.get(num);
            if (zmVar2 != null) {
                an anVar2 = zmVar2.e;
                if (anVar2.i0 == 1) {
                    Barrier barrier2 = new Barrier(constraintLayout.getContext());
                    barrier2.setId(num.intValue());
                    int[] iArr2 = anVar2.j0;
                    if (iArr2 != null) {
                        barrier2.setReferencedIds(iArr2);
                    } else {
                        String str2 = anVar2.k0;
                        if (str2 != null) {
                            int[] iArrH2 = h(barrier2, str2);
                            anVar2.j0 = iArrH2;
                            barrier2.setReferencedIds(iArrH2);
                        }
                    }
                    barrier2.setType(anVar2.g0);
                    barrier2.setMargin(anVar2.h0);
                    nm nmVarGenerateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                    barrier2.validateParams();
                    zmVar2.b(nmVarGenerateDefaultLayoutParams);
                    constraintLayout.addView(barrier2, nmVarGenerateDefaultLayoutParams);
                }
                if (anVar2.a) {
                    View guideline = new Guideline(constraintLayout.getContext());
                    guideline.setId(num.intValue());
                    nm nmVarGenerateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                    zmVar2.b(nmVarGenerateDefaultLayoutParams2);
                    constraintLayout.addView(guideline, nmVarGenerateDefaultLayoutParams2);
                }
            }
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt2 = constraintLayout.getChildAt(i3);
            if (childAt2 instanceof a) {
                ((a) childAt2).applyLayoutFeaturesInConstraintSet(constraintLayout);
            }
        }
    }

    public final void e(en enVar) {
        HashMap map = this.g;
        map.clear();
        for (Integer num : enVar.g.keySet()) {
            zm zmVar = (zm) enVar.g.get(num);
            if (zmVar != null) {
                map.put(num, zmVar.clone());
            }
        }
    }

    public final void f(ConstraintLayout constraintLayout) {
        en enVar = this;
        int childCount = constraintLayout.getChildCount();
        HashMap map = enVar.g;
        map.clear();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = constraintLayout.getChildAt(i2);
            nm nmVar = (nm) childAt.getLayoutParams();
            int id = childAt.getId();
            if (enVar.f && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!map.containsKey(Integer.valueOf(id))) {
                map.put(Integer.valueOf(id), new zm());
            }
            zm zmVar = (zm) map.get(Integer.valueOf(id));
            if (zmVar != null) {
                HashMap map2 = enVar.e;
                HashMap map3 = new HashMap();
                Class<?> cls = childAt.getClass();
                for (String str : map2.keySet()) {
                    hm hmVar = (hm) map2.get(str);
                    try {
                        if (str.equals("BackgroundColor")) {
                            map3.put(str, new hm(hmVar, Integer.valueOf(((ColorDrawable) childAt.getBackground()).getColor())));
                        } else {
                            map3.put(str, new hm(hmVar, cls.getMethod("getMap" + str, null).invoke(childAt, null)));
                        }
                    } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                    }
                }
                zmVar.g = map3;
                zm.a(zmVar, id, nmVar);
                int visibility = childAt.getVisibility();
                cn cnVar = zmVar.c;
                cnVar.b = visibility;
                cnVar.d = childAt.getAlpha();
                float rotation = childAt.getRotation();
                dn dnVar = zmVar.f;
                dnVar.b = rotation;
                dnVar.c = childAt.getRotationX();
                dnVar.d = childAt.getRotationY();
                dnVar.e = childAt.getScaleX();
                dnVar.f = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != 0.0d || pivotY != 0.0d) {
                    dnVar.g = pivotX;
                    dnVar.h = pivotY;
                }
                dnVar.j = childAt.getTranslationX();
                dnVar.k = childAt.getTranslationY();
                dnVar.l = childAt.getTranslationZ();
                if (dnVar.m) {
                    dnVar.n = childAt.getElevation();
                }
                if (childAt instanceof Barrier) {
                    Barrier barrier = (Barrier) childAt;
                    boolean allowsGoneWidget = barrier.getAllowsGoneWidget();
                    an anVar = zmVar.e;
                    anVar.o0 = allowsGoneWidget;
                    anVar.j0 = barrier.getReferencedIds();
                    anVar.g0 = barrier.getType();
                    anVar.h0 = barrier.getMargin();
                }
            }
            i2++;
            enVar = this;
        }
    }

    public final void g(int i2, int i3, int i4, int i5, int i6) {
        HashMap map = this.g;
        if (!map.containsKey(Integer.valueOf(i2))) {
            map.put(Integer.valueOf(i2), new zm());
        }
        zm zmVar = (zm) map.get(Integer.valueOf(i2));
        if (zmVar == null) {
            return;
        }
        an anVar = zmVar.e;
        switch (i3) {
            case 1:
                if (i5 == 1) {
                    anVar.i = i4;
                    anVar.j = -1;
                } else {
                    if (i5 != 2) {
                        throw new IllegalArgumentException("Left to " + t(i5) + " undefined");
                    }
                    anVar.j = i4;
                    anVar.i = -1;
                }
                anVar.G = i6;
                return;
            case 2:
                if (i5 == 1) {
                    anVar.k = i4;
                    anVar.l = -1;
                } else {
                    if (i5 != 2) {
                        throw new IllegalArgumentException("right to " + t(i5) + " undefined");
                    }
                    anVar.l = i4;
                    anVar.k = -1;
                }
                anVar.H = i6;
                return;
            case 3:
                if (i5 == 3) {
                    anVar.m = i4;
                    anVar.n = -1;
                    anVar.q = -1;
                    anVar.r = -1;
                    anVar.s = -1;
                } else {
                    if (i5 != 4) {
                        throw new IllegalArgumentException("right to " + t(i5) + " undefined");
                    }
                    anVar.n = i4;
                    anVar.m = -1;
                    anVar.q = -1;
                    anVar.r = -1;
                    anVar.s = -1;
                }
                anVar.I = i6;
                return;
            case 4:
                if (i5 == 4) {
                    anVar.p = i4;
                    anVar.o = -1;
                    anVar.q = -1;
                    anVar.r = -1;
                    anVar.s = -1;
                } else {
                    if (i5 != 3) {
                        throw new IllegalArgumentException("right to " + t(i5) + " undefined");
                    }
                    anVar.o = i4;
                    anVar.p = -1;
                    anVar.q = -1;
                    anVar.r = -1;
                    anVar.s = -1;
                }
                anVar.J = i6;
                return;
            case 5:
                if (i5 == 5) {
                    anVar.q = i4;
                    anVar.p = -1;
                    anVar.o = -1;
                    anVar.m = -1;
                    anVar.n = -1;
                    return;
                }
                if (i5 == 3) {
                    anVar.r = i4;
                    anVar.p = -1;
                    anVar.o = -1;
                    anVar.m = -1;
                    anVar.n = -1;
                    return;
                }
                if (i5 != 4) {
                    throw new IllegalArgumentException("right to " + t(i5) + " undefined");
                }
                anVar.s = i4;
                anVar.p = -1;
                anVar.o = -1;
                anVar.m = -1;
                anVar.n = -1;
                return;
            case 6:
                if (i5 == 6) {
                    anVar.u = i4;
                    anVar.t = -1;
                } else {
                    if (i5 != 7) {
                        throw new IllegalArgumentException("right to " + t(i5) + " undefined");
                    }
                    anVar.t = i4;
                    anVar.u = -1;
                }
                anVar.L = i6;
                return;
            case 7:
                if (i5 == 7) {
                    anVar.w = i4;
                    anVar.v = -1;
                } else {
                    if (i5 != 6) {
                        throw new IllegalArgumentException("right to " + t(i5) + " undefined");
                    }
                    anVar.v = i4;
                    anVar.w = -1;
                }
                anVar.K = i6;
                return;
            default:
                throw new IllegalArgumentException(t(i3) + " to " + t(i5) + " unknown");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(androidx.constraintlayout.motion.widget.MotionScene r17, int... r18) {
        /*
            Method dump skipped, instruction units count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.en.i(androidx.constraintlayout.motion.widget.MotionScene, int[]):void");
    }

    public final zm k(int i2) {
        HashMap map = this.g;
        if (!map.containsKey(Integer.valueOf(i2))) {
            map.put(Integer.valueOf(i2), new zm());
        }
        return (zm) map.get(Integer.valueOf(i2));
    }

    public final zm l(int i2) {
        HashMap map = this.g;
        if (map.containsKey(Integer.valueOf(i2))) {
            return (zm) map.get(Integer.valueOf(i2));
        }
        return null;
    }

    public final void m(Context context, int i2) {
        XmlResourceParser xml = context.getResources().getXml(i2);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 2) {
                    String name = xml.getName();
                    zm zmVarJ = j(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        zmVarJ.e.a = true;
                    }
                    this.g.put(Integer.valueOf(zmVarJ.a), zmVarJ);
                }
            }
        } catch (IOException | XmlPullParserException unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:117:0x01c8, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n(android.content.Context r10, org.xmlpull.v1.XmlPullParser r11) {
        /*
            Method dump skipped, instruction units count: 548
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.en.n(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public final void s(int i2, int i3, int i4) {
        zm zmVarK = k(i2);
        switch (i3) {
            case 1:
                zmVarK.e.G = i4;
                return;
            case 2:
                zmVarK.e.H = i4;
                return;
            case 3:
                zmVarK.e.I = i4;
                return;
            case 4:
                zmVarK.e.J = i4;
                return;
            case 5:
                zmVarK.e.M = i4;
                return;
            case 6:
                zmVarK.e.L = i4;
                return;
            case 7:
                zmVarK.e.K = i4;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }
}
