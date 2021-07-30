package com.xrlj.infrastructure.enums;

import javax.persistence.AttributeConverter;

/**
 * 账号类型。注意和会员服务中的一致。
 * @author zmt
 */
public enum UserType {

    ADMIN(0, "总后台"),
    FACTOR(1, "保理商"),
    CORE(2, "核心企业"),
    MEMBER(3, "成员单位"),
    SUPPLIER(4, "供应商"),
    DEBTOR(5, "债务加入方"),
    LAW(6, "律所"),
    SPV(7, "计划管理人"),
    BUYER(8, "买方"),
    INDIVIDUAL(9, "普通会员");

    private final int type;
    private final String typeName;

    UserType(int type, String typeName) {
        this.type = type;
        this.typeName = typeName;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public static String getTypeName(String name) {
        for (UserType userType : userTypes) {
            if (userType.name().equals(name)) {
                return userType.typeName;
            }
        }
        return null;
    }

    public int getType() {
        return this.type;
    }

    public static final UserType[] userTypes = UserType.values();

    public static UserType getInstance(int type) {
        for (UserType userType : userTypes) {
            if (userType.getType() == type) {
                return userType;
            }
        }
        return null;
    }

    public static class Converter implements AttributeConverter<UserType, Integer> {

        @Override
        public Integer convertToDatabaseColumn(UserType userType) {
            return userType == null ? 0 : userType.getType();
        }

        @Override
        public UserType convertToEntityAttribute(Integer dbData) {
            if (dbData != null) {
                for (UserType userType : UserType.userTypes) {
                    if (userType.getType() == dbData.intValue()) {
                        return userType;
                    }
                }
            }
            return null;
        }
    }
}
