package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import java.io.IOException;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class qa {
    public final pa a;
    public final pa b;
    public final float c;
    public final float d;
    public final float e;

    public qa(Context context) {
        AttributeSet attributeSetAsAttributeSet;
        int styleAttribute;
        Locale locale;
        int next;
        int i = oa.u;
        int i2 = oa.t;
        this.b = new pa();
        pa paVar = new pa();
        int i3 = paVar.g;
        if (i3 != 0) {
            try {
                XmlResourceParser xml = context.getResources().getXml(i3);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                if (!TextUtils.equals(xml.getName(), "badge")) {
                    throw new XmlPullParserException("Must have a <" + ((Object) "badge") + "> start tag");
                }
                attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                styleAttribute = attributeSetAsAttributeSet.getStyleAttribute();
            } catch (IOException | XmlPullParserException e) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load badge resource ID #0x" + Integer.toHexString(i3));
                notFoundException.initCause(e);
                throw notFoundException;
            }
        } else {
            attributeSetAsAttributeSet = null;
            styleAttribute = 0;
        }
        TypedArray typedArrayD = mn1.d(context, attributeSetAsAttributeSet, f71.Badge, i, styleAttribute == 0 ? i2 : styleAttribute, new int[0]);
        Resources resources = context.getResources();
        this.c = typedArrayD.getDimensionPixelSize(f71.Badge_badgeRadius, resources.getDimensionPixelSize(d51.mtrl_badge_radius));
        this.e = typedArrayD.getDimensionPixelSize(f71.Badge_badgeWidePadding, resources.getDimensionPixelSize(d51.mtrl_badge_long_text_horizontal_padding));
        this.d = typedArrayD.getDimensionPixelSize(f71.Badge_badgeWithTextRadius, resources.getDimensionPixelSize(d51.mtrl_badge_with_text_radius));
        pa paVar2 = this.b;
        int i4 = paVar.j;
        paVar2.j = i4 == -2 ? 255 : i4;
        CharSequence charSequence = paVar.n;
        paVar2.n = charSequence == null ? context.getString(v61.mtrl_badge_numberless_content_description) : charSequence;
        pa paVar3 = this.b;
        int i5 = paVar.o;
        paVar3.o = i5 == 0 ? p61.mtrl_badge_content_description : i5;
        int i6 = paVar.p;
        paVar3.p = i6 == 0 ? v61.mtrl_exceed_max_badge_number_content_description : i6;
        Boolean bool = paVar.r;
        paVar3.r = Boolean.valueOf(bool == null || bool.booleanValue());
        pa paVar4 = this.b;
        int i7 = paVar.l;
        paVar4.l = i7 == -2 ? typedArrayD.getInt(f71.Badge_maxCharacterCount, 4) : i7;
        int i8 = paVar.k;
        if (i8 != -2) {
            this.b.k = i8;
        } else if (typedArrayD.hasValue(f71.Badge_number)) {
            this.b.k = typedArrayD.getInt(f71.Badge_number, 0);
        } else {
            this.b.k = -1;
        }
        pa paVar5 = this.b;
        Integer num = paVar.h;
        paVar5.h = Integer.valueOf(num == null ? np1.l(context, typedArrayD, f71.Badge_backgroundColor).getDefaultColor() : num.intValue());
        Integer num2 = paVar.i;
        if (num2 != null) {
            this.b.i = num2;
        } else if (typedArrayD.hasValue(f71.Badge_badgeTextColor)) {
            this.b.i = Integer.valueOf(np1.l(context, typedArrayD, f71.Badge_badgeTextColor).getDefaultColor());
        } else {
            int i9 = b71.TextAppearance_MaterialComponents_Badge;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i9, f71.TextAppearance);
            typedArrayObtainStyledAttributes.getDimension(f71.TextAppearance_android_textSize, 0.0f);
            ColorStateList colorStateListL = np1.l(context, typedArrayObtainStyledAttributes, f71.TextAppearance_android_textColor);
            np1.l(context, typedArrayObtainStyledAttributes, f71.TextAppearance_android_textColorHint);
            np1.l(context, typedArrayObtainStyledAttributes, f71.TextAppearance_android_textColorLink);
            typedArrayObtainStyledAttributes.getInt(f71.TextAppearance_android_textStyle, 0);
            typedArrayObtainStyledAttributes.getInt(f71.TextAppearance_android_typeface, 1);
            int i10 = f71.TextAppearance_fontFamily;
            i10 = typedArrayObtainStyledAttributes.hasValue(i10) ? i10 : f71.TextAppearance_android_fontFamily;
            typedArrayObtainStyledAttributes.getResourceId(i10, 0);
            typedArrayObtainStyledAttributes.getString(i10);
            typedArrayObtainStyledAttributes.getBoolean(f71.TextAppearance_textAllCaps, false);
            np1.l(context, typedArrayObtainStyledAttributes, f71.TextAppearance_android_shadowColor);
            typedArrayObtainStyledAttributes.getFloat(f71.TextAppearance_android_shadowDx, 0.0f);
            typedArrayObtainStyledAttributes.getFloat(f71.TextAppearance_android_shadowDy, 0.0f);
            typedArrayObtainStyledAttributes.getFloat(f71.TextAppearance_android_shadowRadius, 0.0f);
            typedArrayObtainStyledAttributes.recycle();
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(i9, f71.MaterialTextAppearance);
            typedArrayObtainStyledAttributes2.hasValue(f71.MaterialTextAppearance_android_letterSpacing);
            typedArrayObtainStyledAttributes2.getFloat(f71.MaterialTextAppearance_android_letterSpacing, 0.0f);
            typedArrayObtainStyledAttributes2.recycle();
            this.b.i = Integer.valueOf(colorStateListL.getDefaultColor());
        }
        pa paVar6 = this.b;
        Integer num3 = paVar.q;
        paVar6.q = Integer.valueOf(num3 == null ? typedArrayD.getInt(f71.Badge_badgeGravity, 8388661) : num3.intValue());
        pa paVar7 = this.b;
        Integer num4 = paVar.s;
        paVar7.s = Integer.valueOf(num4 == null ? typedArrayD.getDimensionPixelOffset(f71.Badge_horizontalOffset, 0) : num4.intValue());
        this.b.t = Integer.valueOf(paVar.s == null ? typedArrayD.getDimensionPixelOffset(f71.Badge_verticalOffset, 0) : paVar.t.intValue());
        pa paVar8 = this.b;
        Integer num5 = paVar.u;
        paVar8.u = Integer.valueOf(num5 == null ? typedArrayD.getDimensionPixelOffset(f71.Badge_horizontalOffsetWithText, paVar8.s.intValue()) : num5.intValue());
        pa paVar9 = this.b;
        Integer num6 = paVar.v;
        paVar9.v = Integer.valueOf(num6 == null ? typedArrayD.getDimensionPixelOffset(f71.Badge_verticalOffsetWithText, paVar9.t.intValue()) : num6.intValue());
        pa paVar10 = this.b;
        Integer num7 = paVar.w;
        paVar10.w = Integer.valueOf(num7 == null ? 0 : num7.intValue());
        pa paVar11 = this.b;
        Integer num8 = paVar.x;
        paVar11.x = Integer.valueOf(num8 != null ? num8.intValue() : 0);
        typedArrayD.recycle();
        Locale locale2 = paVar.m;
        if (locale2 == null) {
            pa paVar12 = this.b;
            if (Build.VERSION.SDK_INT >= 24) {
                Locale.Category unused = Locale.Category.FORMAT;
                locale = Locale.getDefault(Locale.Category.FORMAT);
            } else {
                locale = Locale.getDefault();
            }
            paVar12.m = locale;
        } else {
            this.b.m = locale2;
        }
        this.a = paVar;
    }
}
