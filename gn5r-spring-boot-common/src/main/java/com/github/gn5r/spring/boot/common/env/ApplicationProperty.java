package com.github.gn5r.spring.boot.common.env;

/**
 * アプリケーションに関するプロパティクラス
 *
 * @author gn5r
 */
public class ApplicationProperty {
    public static final String PREFIX = "application";

    /**
     * アプリケーションベースパッケージ
     */
    private String basePackage;

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public String getBasePackage() {
        return this.basePackage;
    }
}
