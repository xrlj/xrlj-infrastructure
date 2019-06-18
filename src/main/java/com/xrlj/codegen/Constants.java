package com.xrlj.codegen;

public interface Constants {

    interface ServiceAuth {

        String projectName = "service-auth";
        String projectPackage = "com.xrlj.serviceauth";
        String apiModuleName = Constants.getModuleName(projectName, "api");
        String providerModuleName = getModuleName(projectName, "provider");
    }

    interface ServiceSysFilesystem {

        String projectName = "service-sys-filesystem";
        String projectPackage = "com.xrlj.servicesysfilesystem";
        String apiModuleName = Constants.getModuleName(projectName, "api");
        String entitiesModuleName = Constants.getModuleName(projectName, "entities");
        String providerModuleName = getModuleName(projectName, "provider");

        String DRIVER = "com.mysql.cj.jdbc.Driver";
        String URL = "jdbc:mysql://120.79.2.30:3910/service_usercentral?useUnicode=true&characterEncoding=utf8";
        String USERNAME = "root";
        String PASSWORD = "123456";
    }

    static String getModuleName(String p, String m) {
        return p.concat("-").concat(m);
    }
}
