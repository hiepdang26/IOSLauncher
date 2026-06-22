package retrofit2;

import defpackage.la1;
import defpackage.vb1;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public interface Converter<F, T> {

    public static abstract class Factory {
        public static Type getParameterUpperBound(int i, ParameterizedType parameterizedType) {
            return Utils.getParameterUpperBound(i, parameterizedType);
        }

        public static Class<?> getRawType(Type type) {
            return Utils.getRawType(type);
        }

        public Converter<?, la1> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
            return null;
        }

        public Converter<vb1, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
            return null;
        }

        public Converter<?, String> stringConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
            return null;
        }
    }

    T convert(F f);
}
