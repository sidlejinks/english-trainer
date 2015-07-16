package com.dtorianik.english.trainer.converters;

/**
 * Created by dtorianik on 7/16/2015.
 */
public interface Converter<T,R> {
    R convert(T from);
}
