package com.basename.pattern.factory;

public interface NumberFactory {
    Number parse(String s);

    static NumberFactory getFactory(){
        return  impl;
    }

    static NumberFactory impl = new NumberFactoryImpl();
}
