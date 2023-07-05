package com.zaidathar.builder;

// This will be available only project lombok jar is present
@Builder
@Data
public class GenericClassUsingLombokBuilder<T,G>{
    private T value;
    private G alternate;
}
