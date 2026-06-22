package retrofit2;

import defpackage.fe;
import defpackage.ga1;
import defpackage.gv0;
import defpackage.hv0;
import defpackage.iv0;
import defpackage.ks0;
import defpackage.la1;
import defpackage.nb0;
import defpackage.nd0;
import defpackage.ne;
import defpackage.ob0;
import defpackage.od0;
import defpackage.q50;
import defpackage.r50;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
final class RequestBuilder {
    private static final String PATH_SEGMENT_ALWAYS_ENCODE_SET = " \"<>^`{}|\\?#";
    private final od0 baseUrl;
    private la1 body;
    private ks0 contentType;
    private q50 formBuilder;
    private final boolean hasBody;
    private final nb0 headersBuilder;
    private final String method;
    private gv0 multipartBuilder;
    private String relativeUrl;
    private final ga1 requestBuilder = new ga1();
    private nd0 urlBuilder;
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final Pattern PATH_TRAVERSAL = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");

    public static class ContentTypeOverridingRequestBody extends la1 {
        private final ks0 contentType;
        private final la1 delegate;

        public ContentTypeOverridingRequestBody(la1 la1Var, ks0 ks0Var) {
            this.delegate = la1Var;
            this.contentType = ks0Var;
        }

        @Override // defpackage.la1
        public long contentLength() {
            return this.delegate.contentLength();
        }

        @Override // defpackage.la1
        public ks0 contentType() {
            return this.contentType;
        }

        @Override // defpackage.la1
        public void writeTo(ne neVar) {
            this.delegate.writeTo(neVar);
        }
    }

    public RequestBuilder(String str, od0 od0Var, String str2, ob0 ob0Var, ks0 ks0Var, boolean z, boolean z2, boolean z3) {
        this.method = str;
        this.baseUrl = od0Var;
        this.relativeUrl = str2;
        this.contentType = ks0Var;
        this.hasBody = z;
        if (ob0Var != null) {
            this.headersBuilder = ob0Var.e();
        } else {
            this.headersBuilder = new nb0();
        }
        if (z2) {
            this.formBuilder = new q50();
            return;
        }
        if (z3) {
            gv0 gv0Var = new gv0();
            this.multipartBuilder = gv0Var;
            ks0 ks0Var2 = iv0.f;
            if (ks0Var2 == null) {
                throw new NullPointerException("type == null");
            }
            if (ks0Var2.b.equals("multipart")) {
                gv0Var.b = ks0Var2;
            } else {
                throw new IllegalArgumentException("multipart != " + ks0Var2);
            }
        }
    }

    private static String canonicalizeForPath(String str, boolean z) {
        int length = str.length();
        int iCharCount = 0;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt < 32 || iCodePointAt >= 127 || PATH_SEGMENT_ALWAYS_ENCODE_SET.indexOf(iCodePointAt) != -1 || (!z && (iCodePointAt == 47 || iCodePointAt == 37))) {
                fe feVar = new fe();
                feVar.O(0, iCharCount, str);
                canonicalizeForPath(feVar, str, iCharCount, length, z);
                return feVar.E();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str;
    }

    public void addFormField(String str, String str2, boolean z) {
        if (z) {
            q50 q50Var = this.formBuilder;
            q50Var.getClass();
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (str2 == null) {
                throw new NullPointerException("value == null");
            }
            q50Var.a.add(od0.a(str, 0, str.length(), " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
            q50Var.b.add(od0.a(str2, 0, str2.length(), " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
            return;
        }
        q50 q50Var2 = this.formBuilder;
        q50Var2.getClass();
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (str2 == null) {
            throw new NullPointerException("value == null");
        }
        q50Var2.a.add(od0.a(str, 0, str.length(), " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
        q50Var2.b.add(od0.a(str2, 0, str2.length(), " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
    }

    public void addHeader(String str, String str2) {
        if ("Content-Type".equalsIgnoreCase(str)) {
            try {
                this.contentType = ks0.a(str2);
                return;
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Malformed content type: " + str2, e);
            }
        }
        nb0 nb0Var = this.headersBuilder;
        nb0Var.getClass();
        ob0.a(str);
        ob0.b(str2, str);
        nb0Var.a(str, str2);
    }

    public void addHeaders(ob0 ob0Var) {
        nb0 nb0Var = this.headersBuilder;
        nb0Var.getClass();
        int iG = ob0Var.g();
        for (int i = 0; i < iG; i++) {
            nb0Var.a(ob0Var.d(i), ob0Var.h(i));
        }
    }

    public void addPart(ob0 ob0Var, la1 la1Var) {
        gv0 gv0Var = this.multipartBuilder;
        gv0Var.getClass();
        if (la1Var == null) {
            throw new NullPointerException("body == null");
        }
        if (ob0Var != null && ob0Var.c("Content-Type") != null) {
            throw new IllegalArgumentException("Unexpected header: Content-Type");
        }
        if (ob0Var != null && ob0Var.c("Content-Length") != null) {
            throw new IllegalArgumentException("Unexpected header: Content-Length");
        }
        gv0Var.c.add(new hv0(ob0Var, la1Var));
    }

    public void addPathParam(String str, String str2, boolean z) {
        if (this.relativeUrl == null) {
            throw new AssertionError();
        }
        String strCanonicalizeForPath = canonicalizeForPath(str2, z);
        String strReplace = this.relativeUrl.replace("{" + str + "}", strCanonicalizeForPath);
        if (!PATH_TRAVERSAL.matcher(strReplace).matches()) {
            this.relativeUrl = strReplace;
        } else {
            throw new IllegalArgumentException("@Path parameters shouldn't perform path traversal ('.' or '..'): " + str2);
        }
    }

    public void addQueryParam(String str, String str2, boolean z) {
        nd0 nd0Var;
        String str3 = this.relativeUrl;
        if (str3 != null) {
            od0 od0Var = this.baseUrl;
            od0Var.getClass();
            try {
                nd0Var = new nd0();
                nd0Var.b(od0Var, str3);
            } catch (IllegalArgumentException unused) {
                nd0Var = null;
            }
            this.urlBuilder = nd0Var;
            if (nd0Var == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.baseUrl + ", Relative: " + this.relativeUrl);
            }
            this.relativeUrl = null;
        }
        if (z) {
            nd0 nd0Var2 = this.urlBuilder;
            if (str == null) {
                nd0Var2.getClass();
                throw new NullPointerException("encodedName == null");
            }
            if (nd0Var2.g == null) {
                nd0Var2.g = new ArrayList();
            }
            nd0Var2.g.add(od0.a(str, 0, str.length(), " \"'<>#&=", true, false, true, true));
            nd0Var2.g.add(str2 != null ? od0.a(str2, 0, str2.length(), " \"'<>#&=", true, false, true, true) : null);
            return;
        }
        nd0 nd0Var3 = this.urlBuilder;
        if (str == null) {
            nd0Var3.getClass();
            throw new NullPointerException("name == null");
        }
        if (nd0Var3.g == null) {
            nd0Var3.g = new ArrayList();
        }
        nd0Var3.g.add(od0.a(str, 0, str.length(), " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true));
        nd0Var3.g.add(str2 != null ? od0.a(str2, 0, str2.length(), " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true) : null);
    }

    public <T> void addTag(Class<T> cls, T t) {
        this.requestBuilder.d(cls, t);
    }

    public ga1 get() {
        nd0 nd0Var;
        od0 od0VarA;
        nd0 nd0Var2 = this.urlBuilder;
        if (nd0Var2 != null) {
            od0VarA = nd0Var2.a();
        } else {
            od0 od0Var = this.baseUrl;
            String str = this.relativeUrl;
            od0Var.getClass();
            try {
                nd0Var = new nd0();
                nd0Var.b(od0Var, str);
            } catch (IllegalArgumentException unused) {
                nd0Var = null;
            }
            od0VarA = nd0Var != null ? nd0Var.a() : null;
            if (od0VarA == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.baseUrl + ", Relative: " + this.relativeUrl);
            }
        }
        la1 contentTypeOverridingRequestBody = this.body;
        if (contentTypeOverridingRequestBody == null) {
            q50 q50Var = this.formBuilder;
            if (q50Var != null) {
                contentTypeOverridingRequestBody = new r50(q50Var.a, q50Var.b);
            } else {
                gv0 gv0Var = this.multipartBuilder;
                if (gv0Var != null) {
                    ArrayList arrayList = gv0Var.c;
                    if (arrayList.isEmpty()) {
                        throw new IllegalStateException("Multipart body must have at least one part.");
                    }
                    contentTypeOverridingRequestBody = new iv0(gv0Var.a, gv0Var.b, arrayList);
                } else if (this.hasBody) {
                    contentTypeOverridingRequestBody = la1.create((ks0) null, new byte[0]);
                }
            }
        }
        ks0 ks0Var = this.contentType;
        if (ks0Var != null) {
            if (contentTypeOverridingRequestBody != null) {
                contentTypeOverridingRequestBody = new ContentTypeOverridingRequestBody(contentTypeOverridingRequestBody, ks0Var);
            } else {
                nb0 nb0Var = this.headersBuilder;
                nb0Var.getClass();
                ob0.a("Content-Type");
                String str2 = ks0Var.a;
                ob0.b(str2, "Content-Type");
                nb0Var.a("Content-Type", str2);
            }
        }
        ga1 ga1Var = this.requestBuilder;
        ga1Var.a = od0VarA;
        nb0 nb0Var2 = this.headersBuilder;
        nb0Var2.getClass();
        ArrayList arrayList2 = nb0Var2.a;
        String[] strArr = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
        nb0 nb0Var3 = new nb0();
        Collections.addAll(nb0Var3.a, strArr);
        ga1Var.c = nb0Var3;
        ga1Var.b(this.method, contentTypeOverridingRequestBody);
        return ga1Var;
    }

    public void setBody(la1 la1Var) {
        this.body = la1Var;
    }

    public void setRelativeUrl(Object obj) {
        this.relativeUrl = obj.toString();
    }

    public void addPart(hv0 hv0Var) {
        gv0 gv0Var = this.multipartBuilder;
        if (hv0Var != null) {
            gv0Var.c.add(hv0Var);
        } else {
            gv0Var.getClass();
            throw new NullPointerException("part == null");
        }
    }

    private static void canonicalizeForPath(fe feVar, String str, int i, int i2, boolean z) {
        fe feVar2 = null;
        while (i < i2) {
            int iCodePointAt = str.codePointAt(i);
            if (!z || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt >= 32 && iCodePointAt < 127 && PATH_SEGMENT_ALWAYS_ENCODE_SET.indexOf(iCodePointAt) == -1 && (z || (iCodePointAt != 47 && iCodePointAt != 37))) {
                    feVar.P(iCodePointAt);
                } else {
                    if (feVar2 == null) {
                        feVar2 = new fe();
                    }
                    feVar2.P(iCodePointAt);
                    while (!feVar2.h()) {
                        byte bR = feVar2.r();
                        feVar.K(37);
                        char[] cArr = HEX_DIGITS;
                        feVar.K(cArr[((bR & 255) >> 4) & 15]);
                        feVar.K(cArr[bR & 15]);
                    }
                }
            }
            i += Character.charCount(iCodePointAt);
        }
    }
}
