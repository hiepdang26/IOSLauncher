package com.luutinhit.launcherios.searchview;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.luutinhit.launcher6.editscreen.CustomViewRound;
import com.luutinhit.launcher6.t;
import com.luutinhit.launcher6.util.TextViewCustomFont;
import com.luutinhit.launcher6.util.overscroll.OverScrollLayout;
import defpackage.be;
import defpackage.bo1;
import defpackage.cw;
import defpackage.ed;
import defpackage.fl0;
import defpackage.g6;
import defpackage.g71;
import defpackage.g9;
import defpackage.h8;
import defpackage.h90;
import defpackage.j8;
import defpackage.l51;
import defpackage.lt;
import defpackage.m61;
import defpackage.nm;
import defpackage.o5;
import defpackage.qo0;
import defpackage.r1;
import defpackage.ue1;
import defpackage.v3;
import defpackage.v51;
import defpackage.v6;
import defpackage.ve1;
import defpackage.w61;
import defpackage.we1;
import defpackage.xe1;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class SearchViewLayout extends ConstraintLayout implements View.OnClickListener, SharedPreferences.OnSharedPreferenceChangeListener, ed {
    public static final /* synthetic */ int C = 0;
    public cw A;
    public final j8 B;
    public xe1 g;
    public final Context h;
    public final t i;
    public final bo1 j;
    public boolean k;
    public String l;
    public final EditText m;
    public final ConstraintLayout n;
    public final CustomViewRound o;
    public final h90 p;
    public final TextViewCustomFont q;
    public final ArrayList r;
    public final AppCompatImageView s;
    public final AppCompatImageView t;
    public final RecyclerView u;
    public final LinearLayout v;
    public ue1 w;
    public we1 x;
    public final Handler y;
    public final InputMethodManager z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchViewLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i = 4;
        this.g = xe1.i;
        this.r = new ArrayList();
        this.B = new j8(this, 2);
        this.h = context;
        if (context instanceof t) {
            t tVar = (t) context;
            this.i = tVar;
            bo1 tinyDB = tVar.getTinyDB();
            this.j = tinyDB;
            tinyDB.j(this);
            this.z = (InputMethodManager) context.getSystemService("input_method");
        }
        this.y = new Handler(Looper.getMainLooper(), new h8(this, i));
        LayoutInflater.from(context).inflate(m61.search_view, (ViewGroup) this, true);
        this.q = (TextViewCustomFont) findViewById(v51.action_back);
        this.m = (EditText) findViewById(v51.et_search);
        this.s = (AppCompatImageView) findViewById(v51.action_voice);
        this.t = (AppCompatImageView) findViewById(v51.action_clear);
        this.n = (ConstraintLayout) findViewById(v51.search_box);
        this.o = (CustomViewRound) findViewById(v51.search_box_background);
        this.u = (RecyclerView) findViewById(v51.suggestion_list);
        this.v = (LinearLayout) findViewById(v51.other_search_layout);
        LinearLayout linearLayout = (LinearLayout) findViewById(v51.search_web);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(v51.search_store);
        LinearLayout linearLayout3 = (LinearLayout) findViewById(v51.search_maps);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(4);
        this.u.setNestedScrollingEnabled(false);
        this.u.setLayoutManager(gridLayoutManager);
        this.u.setItemAnimator(new lt());
        t tVar2 = this.i;
        if (tVar2 != null) {
            int i2 = tVar2.getDeviceProfile().C;
            ((nm) this.n.getLayoutParams()).setMarginStart(i2);
            ((nm) this.q.getLayoutParams()).setMarginEnd(i2);
            ((nm) ((OverScrollLayout) findViewById(v51.overscroll_layout)).getLayoutParams()).setMargins(i2, 0, i2, 0);
            this.u.setPadding(0, i2, 0, i2);
            this.v.setPadding(i2, 0, i2, 0);
            if (tVar2.isUseLiquidGlass && tVar2.isRuntimeRenderSupport && this.p == null) {
                if (tVar2.getBlurWallpaperProvider() != null) {
                    tVar2.getBlurWallpaperProvider().b(this);
                }
                setLayerType(2, null);
                h90 h90Var = new h90(tVar2, false);
                this.p = h90Var;
                h90Var.setLayerType(2, null);
                this.p.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 81));
                this.p.setCornerRadiusPercent(0.5f);
                CustomViewRound customViewRound = this.o;
                customViewRound.m = false;
                customViewRound.addView(this.p, 0);
            }
            setDarkMode(tVar2.isDarkMode);
        }
        findViewById(v51.result_layout).setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.s.setOnClickListener(this);
        this.t.setOnClickListener(this);
        linearLayout.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        linearLayout3.setOnClickListener(this);
        w(true);
        this.m.setOnEditorActionListener(new ve1(this));
        this.m.setOnFocusChangeListener(new v3(this, i));
        g9 g9Var = g6.g;
        VectorEnabledTintResources.setCompatVectorFromResourcesEnabled(true);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g71.SearchViewLayout, 0, 0);
        if (typedArrayObtainStyledAttributes.hasValue(g71.SearchViewLayout_voiceHintPrompt)) {
            setVoiceHintPrompt(typedArrayObtainStyledAttributes.getString(g71.SearchViewLayout_voiceHintPrompt));
        }
        setFitsSystemWindows(true);
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdapter(ArrayList<v6> arrayList) {
        ue1 ue1Var = new ue1(this.h, arrayList);
        this.w = ue1Var;
        ue1Var.m = new o5(this, 8);
        this.u.setAdapter(ue1Var);
    }

    public final void A() {
        if (this.g == xe1.h) {
            return;
        }
        setVisibility(0);
        this.g = xe1.g;
        setAlpha(0.0f);
        this.u.setVisibility(0);
        this.m.addTextChangedListener(this.B);
        we1 we1Var = this.x;
        if (we1Var != null) {
            we1Var.onSearchViewOpened();
        }
    }

    @Override // defpackage.ed
    public final void a() {
        post(new r1(this, 25));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void clearFocus() {
        this.k = true;
        InputMethodManager inputMethodManager = this.z;
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
        super.clearFocus();
        this.m.clearFocus();
        this.k = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        if (keyEvent == null || keyEvent.getKeyCode() != 4) {
            return super.dispatchKeyEventPreIme(keyEvent);
        }
        n();
        return true;
    }

    public xe1 getState() {
        return this.g;
    }

    public final void n() {
        LinearLayout linearLayout = this.v;
        EditText editText = this.m;
        int i = 1;
        xe1 xe1Var = this.g;
        xe1 xe1Var2 = xe1.i;
        if (xe1Var == xe1Var2) {
            return;
        }
        this.g = xe1Var2;
        Objects.toString(xe1Var2);
        editText.removeTextChangedListener(this.B);
        editText.setText("");
        u(false);
        w(true);
        if (linearLayout != null && editText.length() == 0) {
            linearLayout.setVisibility(8);
        }
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofFloat((Property<?, Float>) View.ALPHA, 0.0f));
        objectAnimatorOfPropertyValuesHolder.setDuration(368L);
        objectAnimatorOfPropertyValuesHolder.setInterpolator(new DecelerateInterpolator());
        objectAnimatorOfPropertyValuesHolder.addListener(new be(this, 15));
        objectAnimatorOfPropertyValuesHolder.addUpdateListener(new qo0(this, i));
        objectAnimatorOfPropertyValuesHolder.start();
        we1 we1Var = this.x;
        if (we1Var != null) {
            we1Var.onSearchViewClosed();
        }
    }

    public final void o() {
        xe1 xe1Var = this.g;
        xe1 xe1Var2 = xe1.i;
        if (xe1Var == xe1Var2) {
            return;
        }
        this.g = xe1Var2;
        this.m.removeTextChangedListener(this.B);
        this.m.setText("");
        u(false);
        w(true);
        postOnAnimationDelayed(new fl0(this, 12), 200L);
        if (this.v != null && this.m.length() == 0) {
            this.v.setVisibility(8);
        }
        setVisibility(8);
        ue1 ue1Var = this.w;
        if (ue1Var != null) {
            ue1Var.n.filter(null);
        }
        we1 we1Var = this.x;
        if (we1Var != null) {
            we1Var.onSearchViewClosed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        if (view != null) {
            int id = view.getId();
            int i = v51.search_web;
            Context context = this.h;
            if (id == i) {
                EditText editText2 = this.m;
                if (editText2 != null) {
                    String strValueOf = String.valueOf(editText2.getText());
                    if (TextUtils.isEmpty(strValueOf)) {
                        return;
                    }
                    try {
                        Intent intent = new Intent("android.intent.action.WEB_SEARCH");
                        intent.putExtra("query", strValueOf);
                        context.startActivity(intent);
                        return;
                    } catch (Throwable unused) {
                        Toast.makeText(context, w61.application_not_found, 0).show();
                        return;
                    }
                }
                return;
            }
            if (id == v51.search_store) {
                EditText editText3 = this.m;
                if (editText3 != null) {
                    String strValueOf2 = String.valueOf(editText3.getText());
                    if (TextUtils.isEmpty(strValueOf2)) {
                        return;
                    }
                    try {
                        try {
                            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://search").buildUpon().appendQueryParameter("c", "apps").appendQueryParameter("q", strValueOf2).build()));
                            return;
                        } catch (Throwable unused2) {
                            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/search?q=".concat(strValueOf2))));
                            Toast.makeText(context, w61.application_not_found, 0).show();
                            return;
                        }
                    } catch (Throwable th) {
                        th.getMessage();
                        Toast.makeText(context, w61.application_not_found, 0).show();
                        return;
                    }
                }
                return;
            }
            if (id == v51.search_maps) {
                EditText editText4 = this.m;
                if (editText4 != null) {
                    String strValueOf3 = String.valueOf(editText4.getText());
                    if (TextUtils.isEmpty(strValueOf3)) {
                        return;
                    }
                    try {
                        Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("geo:0,0?q=".concat(strValueOf3)));
                        intent2.setPackage("com.google.android.apps.maps");
                        context.startActivity(intent2);
                        return;
                    } catch (Throwable unused3) {
                        Toast.makeText(context, w61.application_not_found, 0).show();
                        return;
                    }
                }
                return;
            }
            if (id == v51.result_layout || id == v51.action_back) {
                n();
                return;
            }
            if (id != v51.action_voice) {
                if (id != v51.action_clear || (editText = this.m) == null) {
                    return;
                }
                editText.setText("");
                return;
            }
            Intent intent3 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
            intent3.putExtra("android.speech.extra.PROMPT", this.l);
            intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
            intent3.putExtra("android.speech.extra.MAX_RESULTS", 1);
            if (context instanceof Activity) {
                ((Activity) context).startActivityForResult(intent3, 42);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        cw cwVar = this.A;
        if (cwVar != null) {
            cwVar.b();
        }
        super.onDetachedFromWindow();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        h90 h90Var = this.p;
        if (h90Var != null) {
            h90Var.g();
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        bo1 bo1Var;
        if (str == null || !str.equals("dark_mode") || (bo1Var = this.j) == null) {
            return;
        }
        setDarkMode(bo1Var.a("dark_mode"));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean requestFocus(int i, Rect rect) {
        return !this.k && isFocusable() && this.m.requestFocus(i, rect);
    }

    @Override // android.view.View
    public void setAlpha(float f) {
        super.setAlpha(f);
        this.x.onSearchViewAlphaChanged(f);
    }

    public void setDarkMode(boolean z) {
        this.o.setDarkModeTransparentBackground(z);
        this.u.setBackgroundResource(z ? l51.round_rect_qsb_dark : l51.round_rect_qsb);
        this.v.setBackgroundResource(z ? l51.round_rect_qsb_dark : l51.round_rect_qsb);
    }

    public void setEditText(String str) {
        EditText editText = this.m;
        if (editText != null) {
            editText.setText(str);
        }
    }

    public void setSearchViewListener(we1 we1Var) {
        this.x = we1Var;
    }

    public void setState(boolean z) {
        this.g = z ? xe1.h : xe1.i;
    }

    public void setUseTransparency(boolean z) {
    }

    public void setVoiceHintPrompt(String str) {
        if (TextUtils.isEmpty(str)) {
            this.l = this.h.getString(w61.hint_prompt);
        } else {
            this.l = str;
        }
    }

    public final void u(boolean z) {
        this.t.setVisibility(z ? 0 : 8);
    }

    public final void w(boolean z) {
        if (!z || this.h.getPackageManager().queryIntentActivities(new Intent("android.speech.action.RECOGNIZE_SPEECH"), 0).size() <= 0) {
            this.s.setVisibility(4);
        } else {
            this.s.setVisibility(0);
        }
    }

    public final boolean x() {
        return this.g == xe1.h;
    }

    public final boolean y() {
        return this.g == xe1.g;
    }

    public final void z(ArrayList arrayList) {
        ArrayList arrayList2 = this.r;
        try {
            arrayList2.clear();
        } catch (Throwable th) {
            th.getMessage();
        }
        arrayList2.addAll(arrayList);
        setAdapter(arrayList);
    }

    @Override // defpackage.ed
    public final void g() {
    }
}
