package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.widget.ResourceManagerInternal;
import defpackage.f51;
import defpackage.hg0;
import defpackage.ik;
import defpackage.m51;
import defpackage.r41;
import defpackage.y41;

/* JADX INFO: loaded from: classes.dex */
public final class AppCompatDrawableManager {
    private static final boolean DEBUG = false;
    private static final PorterDuff.Mode DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
    private static AppCompatDrawableManager INSTANCE = null;
    private static final String TAG = "AppCompatDrawableManag";
    private ResourceManagerInternal mResourceManager;

    public static synchronized AppCompatDrawableManager get() {
        try {
            if (INSTANCE == null) {
                preload();
            }
        } catch (Throwable th) {
            throw th;
        }
        return INSTANCE;
    }

    public static synchronized PorterDuffColorFilter getPorterDuffColorFilter(int i, PorterDuff.Mode mode) {
        return ResourceManagerInternal.getPorterDuffColorFilter(i, mode);
    }

    public static synchronized void preload() {
        if (INSTANCE == null) {
            AppCompatDrawableManager appCompatDrawableManager = new AppCompatDrawableManager();
            INSTANCE = appCompatDrawableManager;
            appCompatDrawableManager.mResourceManager = ResourceManagerInternal.get();
            INSTANCE.mResourceManager.setHooks(new ResourceManagerInternal.ResourceManagerHooks() { // from class: androidx.appcompat.widget.AppCompatDrawableManager.1
                private final int[] COLORFILTER_TINT_COLOR_CONTROL_NORMAL = {m51.abc_textfield_search_default_mtrl_alpha, m51.abc_textfield_default_mtrl_alpha, m51.abc_ab_share_pack_mtrl_alpha};
                private final int[] TINT_COLOR_CONTROL_NORMAL = {m51.abc_ic_commit_search_api_mtrl_alpha, m51.abc_seekbar_tick_mark_material, m51.abc_ic_menu_share_mtrl_alpha, m51.abc_ic_menu_copy_mtrl_am_alpha, m51.abc_ic_menu_cut_mtrl_alpha, m51.abc_ic_menu_selectall_mtrl_alpha, m51.abc_ic_menu_paste_mtrl_am_alpha};
                private final int[] COLORFILTER_COLOR_CONTROL_ACTIVATED = {m51.abc_textfield_activated_mtrl_alpha, m51.abc_textfield_search_activated_mtrl_alpha, m51.abc_cab_background_top_mtrl_alpha, m51.abc_text_cursor_material, m51.abc_text_select_handle_left_mtrl, m51.abc_text_select_handle_middle_mtrl, m51.abc_text_select_handle_right_mtrl};
                private final int[] COLORFILTER_COLOR_BACKGROUND_MULTIPLY = {m51.abc_popup_background_mtrl_mult, m51.abc_cab_background_internal_bg, m51.abc_menu_hardkey_panel_mtrl_mult};
                private final int[] TINT_COLOR_CONTROL_STATE_LIST = {m51.abc_tab_indicator_material, m51.abc_textfield_search_material};
                private final int[] TINT_CHECKABLE_BUTTON_LIST = {m51.abc_btn_check_material, m51.abc_btn_radio_material, m51.abc_btn_check_material_anim, m51.abc_btn_radio_material_anim};

                private boolean arrayContains(int[] iArr, int i) {
                    for (int i2 : iArr) {
                        if (i2 == i) {
                            return true;
                        }
                    }
                    return false;
                }

                private ColorStateList createBorderlessButtonColorStateList(Context context) {
                    return createButtonColorStateList(context, 0);
                }

                private ColorStateList createButtonColorStateList(Context context, int i) {
                    int themeAttrColor = ThemeUtils.getThemeAttrColor(context, r41.colorControlHighlight);
                    return new ColorStateList(new int[][]{ThemeUtils.DISABLED_STATE_SET, ThemeUtils.PRESSED_STATE_SET, ThemeUtils.FOCUSED_STATE_SET, ThemeUtils.EMPTY_STATE_SET}, new int[]{ThemeUtils.getDisabledThemeAttrColor(context, r41.colorButtonNormal), ik.f(themeAttrColor, i), ik.f(themeAttrColor, i), i});
                }

                private ColorStateList createColoredButtonColorStateList(Context context) {
                    return createButtonColorStateList(context, ThemeUtils.getThemeAttrColor(context, r41.colorAccent));
                }

                private ColorStateList createDefaultButtonColorStateList(Context context) {
                    return createButtonColorStateList(context, ThemeUtils.getThemeAttrColor(context, r41.colorButtonNormal));
                }

                private ColorStateList createSwitchThumbColorStateList(Context context) {
                    int[][] iArr = new int[3][];
                    int[] iArr2 = new int[3];
                    ColorStateList themeAttrColorStateList = ThemeUtils.getThemeAttrColorStateList(context, r41.colorSwitchThumbNormal);
                    if (themeAttrColorStateList == null || !themeAttrColorStateList.isStateful()) {
                        iArr[0] = ThemeUtils.DISABLED_STATE_SET;
                        iArr2[0] = ThemeUtils.getDisabledThemeAttrColor(context, r41.colorSwitchThumbNormal);
                        iArr[1] = ThemeUtils.CHECKED_STATE_SET;
                        iArr2[1] = ThemeUtils.getThemeAttrColor(context, r41.colorControlActivated);
                        iArr[2] = ThemeUtils.EMPTY_STATE_SET;
                        iArr2[2] = ThemeUtils.getThemeAttrColor(context, r41.colorSwitchThumbNormal);
                    } else {
                        int[] iArr3 = ThemeUtils.DISABLED_STATE_SET;
                        iArr[0] = iArr3;
                        iArr2[0] = themeAttrColorStateList.getColorForState(iArr3, 0);
                        iArr[1] = ThemeUtils.CHECKED_STATE_SET;
                        iArr2[1] = ThemeUtils.getThemeAttrColor(context, r41.colorControlActivated);
                        iArr[2] = ThemeUtils.EMPTY_STATE_SET;
                        iArr2[2] = themeAttrColorStateList.getDefaultColor();
                    }
                    return new ColorStateList(iArr, iArr2);
                }

                private LayerDrawable getRatingBarLayerDrawable(ResourceManagerInternal resourceManagerInternal, Context context, int i) {
                    BitmapDrawable bitmapDrawable;
                    BitmapDrawable bitmapDrawable2;
                    BitmapDrawable bitmapDrawable3;
                    int dimensionPixelSize = context.getResources().getDimensionPixelSize(i);
                    Drawable drawable = resourceManagerInternal.getDrawable(context, m51.abc_star_black_48dp);
                    Drawable drawable2 = resourceManagerInternal.getDrawable(context, m51.abc_star_half_black_48dp);
                    if ((drawable instanceof BitmapDrawable) && drawable.getIntrinsicWidth() == dimensionPixelSize && drawable.getIntrinsicHeight() == dimensionPixelSize) {
                        bitmapDrawable = (BitmapDrawable) drawable;
                        bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
                    } else {
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                        Canvas canvas = new Canvas(bitmapCreateBitmap);
                        drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                        drawable.draw(canvas);
                        bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
                        bitmapDrawable2 = new BitmapDrawable(bitmapCreateBitmap);
                    }
                    bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
                    if ((drawable2 instanceof BitmapDrawable) && drawable2.getIntrinsicWidth() == dimensionPixelSize && drawable2.getIntrinsicHeight() == dimensionPixelSize) {
                        bitmapDrawable3 = (BitmapDrawable) drawable2;
                    } else {
                        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                        Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
                        drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                        drawable2.draw(canvas2);
                        bitmapDrawable3 = new BitmapDrawable(bitmapCreateBitmap2);
                    }
                    LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
                    layerDrawable.setId(0, R.id.background);
                    layerDrawable.setId(1, R.id.secondaryProgress);
                    layerDrawable.setId(2, R.id.progress);
                    return layerDrawable;
                }

                private void setPorterDuffColorFilter(Drawable drawable, int i, PorterDuff.Mode mode) {
                    if (DrawableUtils.canSafelyMutateDrawable(drawable)) {
                        drawable = drawable.mutate();
                    }
                    if (mode == null) {
                        mode = AppCompatDrawableManager.DEFAULT_MODE;
                    }
                    drawable.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(i, mode));
                }

                @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                public Drawable createDrawableFor(ResourceManagerInternal resourceManagerInternal, Context context, int i) {
                    if (i == m51.abc_cab_background_top_material) {
                        return new LayerDrawable(new Drawable[]{resourceManagerInternal.getDrawable(context, m51.abc_cab_background_internal_bg), resourceManagerInternal.getDrawable(context, m51.abc_cab_background_top_mtrl_alpha)});
                    }
                    if (i == m51.abc_ratingbar_material) {
                        return getRatingBarLayerDrawable(resourceManagerInternal, context, f51.abc_star_big);
                    }
                    if (i == m51.abc_ratingbar_indicator_material) {
                        return getRatingBarLayerDrawable(resourceManagerInternal, context, f51.abc_star_medium);
                    }
                    if (i == m51.abc_ratingbar_small_material) {
                        return getRatingBarLayerDrawable(resourceManagerInternal, context, f51.abc_star_small);
                    }
                    return null;
                }

                @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                public ColorStateList getTintListForDrawableRes(Context context, int i) {
                    if (i == m51.abc_edit_text_material) {
                        return hg0.m(context, y41.abc_tint_edittext);
                    }
                    if (i == m51.abc_switch_track_mtrl_alpha) {
                        return hg0.m(context, y41.abc_tint_switch_track);
                    }
                    if (i == m51.abc_switch_thumb_material) {
                        return createSwitchThumbColorStateList(context);
                    }
                    if (i == m51.abc_btn_default_mtrl_shape) {
                        return createDefaultButtonColorStateList(context);
                    }
                    if (i == m51.abc_btn_borderless_material) {
                        return createBorderlessButtonColorStateList(context);
                    }
                    if (i == m51.abc_btn_colored_material) {
                        return createColoredButtonColorStateList(context);
                    }
                    if (i == m51.abc_spinner_mtrl_am_alpha || i == m51.abc_spinner_textfield_background_material) {
                        return hg0.m(context, y41.abc_tint_spinner);
                    }
                    if (arrayContains(this.TINT_COLOR_CONTROL_NORMAL, i)) {
                        return ThemeUtils.getThemeAttrColorStateList(context, r41.colorControlNormal);
                    }
                    if (arrayContains(this.TINT_COLOR_CONTROL_STATE_LIST, i)) {
                        return hg0.m(context, y41.abc_tint_default);
                    }
                    if (arrayContains(this.TINT_CHECKABLE_BUTTON_LIST, i)) {
                        return hg0.m(context, y41.abc_tint_btn_checkable);
                    }
                    if (i == m51.abc_seekbar_thumb_material) {
                        return hg0.m(context, y41.abc_tint_seek_thumb);
                    }
                    return null;
                }

                @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                public PorterDuff.Mode getTintModeForDrawableRes(int i) {
                    if (i == m51.abc_switch_thumb_material) {
                        return PorterDuff.Mode.MULTIPLY;
                    }
                    return null;
                }

                @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                public boolean tintDrawable(Context context, int i, Drawable drawable) {
                    if (i == m51.abc_seekbar_track_material) {
                        LayerDrawable layerDrawable = (LayerDrawable) drawable;
                        setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(R.id.background), ThemeUtils.getThemeAttrColor(context, r41.colorControlNormal), AppCompatDrawableManager.DEFAULT_MODE);
                        setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(R.id.secondaryProgress), ThemeUtils.getThemeAttrColor(context, r41.colorControlNormal), AppCompatDrawableManager.DEFAULT_MODE);
                        setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(R.id.progress), ThemeUtils.getThemeAttrColor(context, r41.colorControlActivated), AppCompatDrawableManager.DEFAULT_MODE);
                        return true;
                    }
                    if (i != m51.abc_ratingbar_material && i != m51.abc_ratingbar_indicator_material && i != m51.abc_ratingbar_small_material) {
                        return false;
                    }
                    LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                    setPorterDuffColorFilter(layerDrawable2.findDrawableByLayerId(R.id.background), ThemeUtils.getDisabledThemeAttrColor(context, r41.colorControlNormal), AppCompatDrawableManager.DEFAULT_MODE);
                    setPorterDuffColorFilter(layerDrawable2.findDrawableByLayerId(R.id.secondaryProgress), ThemeUtils.getThemeAttrColor(context, r41.colorControlActivated), AppCompatDrawableManager.DEFAULT_MODE);
                    setPorterDuffColorFilter(layerDrawable2.findDrawableByLayerId(R.id.progress), ThemeUtils.getThemeAttrColor(context, r41.colorControlActivated), AppCompatDrawableManager.DEFAULT_MODE);
                    return true;
                }

                /* JADX WARN: Removed duplicated region for block: B:22:0x0052  */
                /* JADX WARN: Removed duplicated region for block: B:29:0x006d A[RETURN] */
                @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public boolean tintDrawableUsingColorFilter(android.content.Context r7, int r8, android.graphics.drawable.Drawable r9) {
                    /*
                        r6 = this;
                        android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.AppCompatDrawableManager.access$000()
                        int[] r1 = r6.COLORFILTER_TINT_COLOR_CONTROL_NORMAL
                        boolean r1 = r6.arrayContains(r1, r8)
                        r2 = 1
                        r3 = 0
                        r4 = -1
                        if (r1 == 0) goto L15
                        int r8 = defpackage.r41.colorControlNormal
                    L11:
                        r1 = r0
                    L12:
                        r0 = -1
                        r5 = 1
                        goto L50
                    L15:
                        int[] r1 = r6.COLORFILTER_COLOR_CONTROL_ACTIVATED
                        boolean r1 = r6.arrayContains(r1, r8)
                        if (r1 == 0) goto L20
                        int r8 = defpackage.r41.colorControlActivated
                        goto L11
                    L20:
                        int[] r1 = r6.COLORFILTER_COLOR_BACKGROUND_MULTIPLY
                        boolean r1 = r6.arrayContains(r1, r8)
                        r5 = 16842801(0x1010031, float:2.3693695E-38)
                        if (r1 == 0) goto L32
                        android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
                    L2d:
                        r1 = r0
                        r8 = 16842801(0x1010031, float:2.3693695E-38)
                        goto L12
                    L32:
                        int r1 = defpackage.m51.abc_list_divider_mtrl_alpha
                        if (r8 != r1) goto L47
                        r8 = 1109603123(0x42233333, float:40.8)
                        int r8 = java.lang.Math.round(r8)
                        r1 = 16842800(0x1010030, float:2.3693693E-38)
                        r1 = r0
                        r5 = 1
                        r0 = r8
                        r8 = 16842800(0x1010030, float:2.3693693E-38)
                        goto L50
                    L47:
                        int r1 = defpackage.m51.abc_dialog_material_background
                        if (r8 != r1) goto L4c
                        goto L2d
                    L4c:
                        r1 = r0
                        r8 = 0
                        r0 = -1
                        r5 = 0
                    L50:
                        if (r5 == 0) goto L6d
                        boolean r3 = androidx.appcompat.widget.DrawableUtils.canSafelyMutateDrawable(r9)
                        if (r3 == 0) goto L5c
                        android.graphics.drawable.Drawable r9 = r9.mutate()
                    L5c:
                        int r7 = androidx.appcompat.widget.ThemeUtils.getThemeAttrColor(r7, r8)
                        android.graphics.PorterDuffColorFilter r7 = androidx.appcompat.widget.AppCompatDrawableManager.getPorterDuffColorFilter(r7, r1)
                        r9.setColorFilter(r7)
                        if (r0 == r4) goto L6c
                        r9.setAlpha(r0)
                    L6c:
                        return r2
                    L6d:
                        return r3
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatDrawableManager.AnonymousClass1.tintDrawableUsingColorFilter(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
                }
            });
        }
    }

    public static void tintDrawable(Drawable drawable, TintInfo tintInfo, int[] iArr) {
        ResourceManagerInternal.tintDrawable(drawable, tintInfo, iArr);
    }

    public synchronized Drawable getDrawable(Context context, int i) {
        return this.mResourceManager.getDrawable(context, i);
    }

    public synchronized ColorStateList getTintList(Context context, int i) {
        return this.mResourceManager.getTintList(context, i);
    }

    public synchronized void onConfigurationChanged(Context context) {
        this.mResourceManager.onConfigurationChanged(context);
    }

    public synchronized Drawable onDrawableLoadedFromResources(Context context, VectorEnabledTintResources vectorEnabledTintResources, int i) {
        return this.mResourceManager.onDrawableLoadedFromResources(context, vectorEnabledTintResources, i);
    }

    public boolean tintDrawableUsingColorFilter(Context context, int i, Drawable drawable) {
        return this.mResourceManager.tintDrawableUsingColorFilter(context, i, drawable);
    }

    public synchronized Drawable getDrawable(Context context, int i, boolean z) {
        return this.mResourceManager.getDrawable(context, i, z);
    }
}
