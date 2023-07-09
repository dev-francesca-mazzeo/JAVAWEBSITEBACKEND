package com.appweb.devfm.demo.constants;

public class EndPoint {
    public final static String DEFAULT = "/";

    //ENTITY
    public final static String USER = "/user";
    public final static String CART = "/cart";
    public final static String PRODUCT = "/product";
    public final static String CATEGORY = "/category";
    public final static String FILEUPLOAD = "/fileUpload";
    public final static String ORDER = "/order";


    //CRUD
    public final static String CREATE = "/create";
    public final static String INSERT = "/insert";
    public static final String ADD = "/add";
    public static final String DELETE = "/delete";
    public static final String UPDATE = "/update";
    public static final String WISHLIST = "/wishlist";

    //GET
    public static final String GET = "/get";
    public static final String ALL = "-all";

    //FILES
    public static final String FILES = "/files";
    public final static String FILENAME = "/{filename:.+}";

    //ID
    public static final String ID = "/{id}";
    public static final String CARTITEMID = "/{cartItemId}";
    public static final String CATEGORYID = "/{categoryID}";
    public static final String PRODUCTID = "/{productID}";

    //SESSION
    public static final String CREATECHECKOUTSESSION= "/create-checkout-session";

    //LOG
    public static final String SIGNIN = "/signIn";
    public static final String SIGNUP = "/signUp";

    //TOKEN
    public static final String TOKEN = "/{token}";
}
