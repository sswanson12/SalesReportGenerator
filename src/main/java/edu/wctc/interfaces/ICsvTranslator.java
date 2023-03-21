package edu.wctc.interfaces;

import org.springframework.stereotype.Component;

@Component
public interface ICsvTranslator<T> {
    T FromCsv(String csvLine);

    String ToCsv(T item);
}
