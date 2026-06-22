package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import defpackage.b0;
import defpackage.os;
import defpackage.zb1;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class GoogleSignInAccount extends b0 implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new zb1(8);
    public final int g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final Uri l;
    public String m;
    public final long n;
    public final String o;
    public final ArrayList p;
    public final String q;
    public final String r;
    public final HashSet s = new HashSet();

    public GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, ArrayList arrayList, String str7, String str8) {
        this.g = i;
        this.h = str;
        this.i = str2;
        this.j = str3;
        this.k = str4;
        this.l = uri;
        this.m = str5;
        this.n = j;
        this.o = str6;
        this.p = arrayList;
        this.q = str7;
        this.r = str8;
    }

    public static GoogleSignInAccount a(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String strOptString = jSONObject.optString("photoUrl");
        Uri uri = !TextUtils.isEmpty(strOptString) ? Uri.parse(strOptString) : null;
        long j = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(1, jSONArray.getString(i)));
        }
        String strOptString2 = jSONObject.optString("id");
        String strOptString3 = jSONObject.has("tokenId") ? jSONObject.optString("tokenId") : null;
        String strOptString4 = jSONObject.has("email") ? jSONObject.optString("email") : null;
        String strOptString5 = jSONObject.has("displayName") ? jSONObject.optString("displayName") : null;
        String strOptString6 = jSONObject.has("givenName") ? jSONObject.optString("givenName") : null;
        String strOptString7 = jSONObject.has("familyName") ? jSONObject.optString("familyName") : null;
        String string = jSONObject.getString("obfuscatedIdentifier");
        if (TextUtils.isEmpty(string)) {
            throw new IllegalArgumentException("Given String is empty or null");
        }
        GoogleSignInAccount googleSignInAccount = new GoogleSignInAccount(3, strOptString2, strOptString3, strOptString4, strOptString5, uri, null, j, string, new ArrayList(hashSet), strOptString6, strOptString7);
        googleSignInAccount.m = jSONObject.has("serverAuthCode") ? jSONObject.optString("serverAuthCode") : null;
        return googleSignInAccount;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        if (!googleSignInAccount.o.equals(this.o)) {
            return false;
        }
        HashSet hashSet = new HashSet(googleSignInAccount.p);
        hashSet.addAll(googleSignInAccount.s);
        HashSet hashSet2 = new HashSet(this.p);
        hashSet2.addAll(this.s);
        return hashSet.equals(hashSet2);
    }

    public final int hashCode() {
        int iHashCode = (this.o.hashCode() + 527) * 31;
        HashSet hashSet = new HashSet(this.p);
        hashSet.addAll(this.s);
        return hashSet.hashCode() + iHashCode;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = os.E(20293, parcel);
        os.G(parcel, 1, 4);
        parcel.writeInt(this.g);
        os.z(parcel, 2, this.h);
        os.z(parcel, 3, this.i);
        os.z(parcel, 4, this.j);
        os.z(parcel, 5, this.k);
        os.y(parcel, 6, this.l, i);
        os.z(parcel, 7, this.m);
        os.G(parcel, 8, 8);
        parcel.writeLong(this.n);
        os.z(parcel, 9, this.o);
        os.D(parcel, 10, this.p);
        os.z(parcel, 11, this.q);
        os.z(parcel, 12, this.r);
        os.F(iE, parcel);
    }
}
