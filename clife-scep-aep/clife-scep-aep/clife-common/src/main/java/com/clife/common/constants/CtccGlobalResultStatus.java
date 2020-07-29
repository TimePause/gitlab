package com.clife.common.constants;

/**
 * 项目错误码的枚举类
 *
 * @author caohaiyang
 */
public class CtccGlobalResultStatus {

    public static final CtccResultStatus SUCCESS = new CtccResultStatus(200, "请求正常");
    public static final CtccResultStatus BAD_REQUEST = new CtccResultStatus(400, "请求数据缺失或格式错误");
    public static final CtccResultStatus UNAUTHORIZED = new CtccResultStatus(401, "请求缺少权限");
    public static final CtccResultStatus FORBIDDEN_REQUEST = new CtccResultStatus(403, "请求禁止");
    public static final CtccResultStatus NOT_FOUND = new CtccResultStatus(404, "请求资源不存在");
    public static final CtccResultStatus INTERNAL_ERROR = new CtccResultStatus(500, "服务器异常");
    public static final CtccResultStatus SERVICE_UNAVAILABLE = new CtccResultStatus(503, "服务不可用");
    public static final CtccResultStatus ASYNC_SERVICE = new CtccResultStatus(504, "异步通讯");
    public static final CtccResultStatus OPERATE_PRODUCT_LIST_FAILURE = new CtccResultStatus(1001, "操作产品信息表失败");
    public static final CtccResultStatus PRODUCT_NOT_EXIST = new CtccResultStatus(1002, "不存在此产品 id 对应的产品信息");
    public static final CtccResultStatus GET_TOKEN_FAILURE = new CtccResultStatus(1005, "获取设备token 失败");
    public static final CtccResultStatus DEVICE_NUMBER_EXIST = new CtccResultStatus(1101, "设备编号已存在");
    public static final CtccResultStatus OPERATE_DATABASE_FAILURE = new CtccResultStatus(1102, "操作数据库失败");
    public static final CtccResultStatus DEVICE_NOT_EXIST = new CtccResultStatus(1104, "此设备不存在");
    public static final CtccResultStatus DEVICE_PRODUCT_NOT_EXIST = new CtccResultStatus(1114, "此设备所属产品不存在");
    public static final CtccResultStatus QUERY_DATABASE_FAILURE = new CtccResultStatus(8800, "数据库查询失败");
    public static final CtccResultStatus PARAM_ANALYSIS_FAILURE = new CtccResultStatus(8802, "参数解析失败");
    public static final CtccResultStatus PARAM_VERIFY_FAILURE = new CtccResultStatus(8803, "参数验证失败");



}