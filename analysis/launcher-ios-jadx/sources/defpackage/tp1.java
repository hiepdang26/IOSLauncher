package defpackage;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.ParcelFileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class tp1 extends az1 {
    public static Font N(FontFamily fontFamily, int i) {
        FontStyle fontStyle = new FontStyle((i & 1) != 0 ? 700 : 400, (i & 2) != 0 ? 1 : 0);
        Font font = fontFamily.getFont(0);
        int iP = P(fontStyle, font.getStyle());
        for (int i2 = 1; i2 < fontFamily.getSize(); i2++) {
            Font font2 = fontFamily.getFont(i2);
            int iP2 = P(fontStyle, font2.getStyle());
            if (iP2 < iP) {
                font = font2;
                iP = iP2;
            }
        }
        return font;
    }

    public static FontFamily O(m50[] m50VarArr, ContentResolver contentResolver) {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        FontFamily.Builder builder = null;
        for (m50 m50Var : m50VarArr) {
            try {
                parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(m50Var.a, "r", null);
            } catch (IOException unused) {
                continue;
            }
            if (parcelFileDescriptorOpenFileDescriptor == null) {
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                }
            } else {
                try {
                    Font fontBuild = new Font.Builder(parcelFileDescriptorOpenFileDescriptor).setWeight(m50Var.c).setSlant(m50Var.d ? 1 : 0).setTtcIndex(m50Var.b).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(fontBuild);
                    } else {
                        builder.addFont(fontBuild);
                    }
                } catch (Throwable th) {
                    try {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
            parcelFileDescriptorOpenFileDescriptor.close();
        }
        if (builder == null) {
            return null;
        }
        return builder.build();
    }

    public static int P(FontStyle fontStyle, FontStyle fontStyle2) {
        return (Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100) + (fontStyle.getSlant() == fontStyle2.getSlant() ? 0 : 2);
    }

    @Override // defpackage.az1
    public final Typeface g(Context context, j50 j50Var, Resources resources, int i) {
        try {
            FontFamily.Builder builder = null;
            for (k50 k50Var : j50Var.a) {
                try {
                    Font fontBuild = new Font.Builder(resources, k50Var.f).setWeight(k50Var.b).setSlant(k50Var.c ? 1 : 0).setTtcIndex(k50Var.e).setFontVariationSettings(k50Var.d).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(fontBuild);
                    } else {
                        builder.addFont(fontBuild);
                    }
                } catch (IOException unused) {
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily fontFamilyBuild = builder.build();
            return new Typeface.CustomFallbackBuilder(fontFamilyBuild).setStyle(N(fontFamilyBuild, i).getStyle()).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // defpackage.az1
    public final Typeface h(Context context, m50[] m50VarArr, int i) {
        try {
            FontFamily fontFamilyO = O(m50VarArr, context.getContentResolver());
            if (fontFamilyO == null) {
                return null;
            }
            return new Typeface.CustomFallbackBuilder(fontFamilyO).setStyle(N(fontFamilyO, i).getStyle()).build();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // defpackage.az1
    public final Typeface i(Context context, List list, int i) {
        ContentResolver contentResolver = context.getContentResolver();
        try {
            FontFamily fontFamilyO = O((m50[]) list.get(0), contentResolver);
            if (fontFamilyO == null) {
                return null;
            }
            Typeface.CustomFallbackBuilder customFallbackBuilder = new Typeface.CustomFallbackBuilder(fontFamilyO);
            for (int i2 = 1; i2 < list.size(); i2++) {
                FontFamily fontFamilyO2 = O((m50[]) list.get(i2), contentResolver);
                if (fontFamilyO2 != null) {
                    customFallbackBuilder.addCustomFallback(fontFamilyO2);
                }
            }
            return customFallbackBuilder.setStyle(N(fontFamilyO, i).getStyle()).build();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // defpackage.az1
    public final Typeface j(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // defpackage.az1
    public final Typeface k(Context context, Resources resources, int i, String str, int i2) {
        try {
            Font fontBuild = new Font.Builder(resources, i).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(fontBuild).build()).setStyle(fontBuild.getStyle()).build();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // defpackage.az1
    public final m50 q(m50[] m50VarArr, int i) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }
}
