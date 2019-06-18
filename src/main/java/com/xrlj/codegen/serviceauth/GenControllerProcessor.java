package com.xrlj.codegen.serviceauth;

import com.xrlj.framework.core.processor.AbstractGenApiImplProcessor;

public class GenControllerProcessor extends AbstractGenApiImplProcessor {

    @Override
    public String gencodeProjectName() {
        return "service-auth-api";
    }

    @Override
    public String javaFileOputProjectName() {
        return "service-auth-provider";
    }

    @Override
    public String packagePath() {
        return "com.xrlj.serviceauth.controller";
    }
}
