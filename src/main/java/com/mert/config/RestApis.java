package com.mert.config;

public class RestApis {
    private static final String API = "/api";
    private static final String VERSION = "/v1";

    public static final String PRODUCT = API + VERSION + "/product";
    public static final String PRODUCT_FEATURE = API + VERSION + "/product-feature";
    public static final String BRAND = API + VERSION + "/brand";
    public static final String MODEL = API + VERSION + "/model";

    public static final String SAVE = "/save";
    public static final String UPDATE = "/update/{id}";
    public static final String DELETE = "/delete/{id}";
    public static final String GET_ALL = "/get-all";
    public static final String GET_BY_ID = "/get-by-id/{id}";
    public static final String FILTER = "/filter";
}
