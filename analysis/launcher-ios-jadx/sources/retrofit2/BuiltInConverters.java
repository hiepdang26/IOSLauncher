package retrofit2;

import defpackage.la1;
import defpackage.vb1;
import defpackage.zp1;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import retrofit2.Converter;
import retrofit2.http.Streaming;

/* JADX INFO: loaded from: classes.dex */
final class BuiltInConverters extends Converter.Factory {
    private boolean checkForKotlinUnit = true;

    public static final class BufferingResponseBodyConverter implements Converter<vb1, vb1> {
        static final BufferingResponseBodyConverter INSTANCE = new BufferingResponseBodyConverter();

        @Override // retrofit2.Converter
        public vb1 convert(vb1 vb1Var) {
            try {
                return Utils.buffer(vb1Var);
            } finally {
                vb1Var.close();
            }
        }
    }

    public static final class RequestBodyConverter implements Converter<la1, la1> {
        static final RequestBodyConverter INSTANCE = new RequestBodyConverter();

        @Override // retrofit2.Converter
        public la1 convert(la1 la1Var) {
            return la1Var;
        }
    }

    public static final class StreamingResponseBodyConverter implements Converter<vb1, vb1> {
        static final StreamingResponseBodyConverter INSTANCE = new StreamingResponseBodyConverter();

        @Override // retrofit2.Converter
        public vb1 convert(vb1 vb1Var) {
            return vb1Var;
        }
    }

    public static final class ToStringConverter implements Converter<Object, String> {
        static final ToStringConverter INSTANCE = new ToStringConverter();

        @Override // retrofit2.Converter
        public String convert(Object obj) {
            return obj.toString();
        }
    }

    public static final class UnitResponseBodyConverter implements Converter<vb1, zp1> {
        static final UnitResponseBodyConverter INSTANCE = new UnitResponseBodyConverter();

        @Override // retrofit2.Converter
        public zp1 convert(vb1 vb1Var) {
            vb1Var.close();
            return zp1.a;
        }
    }

    public static final class VoidResponseBodyConverter implements Converter<vb1, Void> {
        static final VoidResponseBodyConverter INSTANCE = new VoidResponseBodyConverter();

        @Override // retrofit2.Converter
        public Void convert(vb1 vb1Var) {
            vb1Var.close();
            return null;
        }
    }

    @Override // retrofit2.Converter.Factory
    public Converter<?, la1> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        if (la1.class.isAssignableFrom(Utils.getRawType(type))) {
            return RequestBodyConverter.INSTANCE;
        }
        return null;
    }

    @Override // retrofit2.Converter.Factory
    public Converter<vb1, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (type == vb1.class) {
            return Utils.isAnnotationPresent(annotationArr, Streaming.class) ? StreamingResponseBodyConverter.INSTANCE : BufferingResponseBodyConverter.INSTANCE;
        }
        if (type == Void.class) {
            return VoidResponseBodyConverter.INSTANCE;
        }
        if (!this.checkForKotlinUnit || type != zp1.class) {
            return null;
        }
        try {
            return UnitResponseBodyConverter.INSTANCE;
        } catch (NoClassDefFoundError unused) {
            this.checkForKotlinUnit = false;
            return null;
        }
    }
}
