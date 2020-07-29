package com.clife.common.constants;

import java.io.Serializable;

/**
 * 项目结果状态类
 *
 * @author caohaiyang
 */
public class CtccResultStatus implements Serializable {

    private static final long serialVersionUID = -3158250774068382025L;

    /**
     * 状态码
     */
    private int code;

    /**
     * 状态消息
     */
    private String msg;

    /**
     * 构造方法
     * @param code 状态码
     * @param msg 状态消息
     */
    public CtccResultStatus(int code, String msg)
    {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 获得状态码
     * @return 状态码
     */
    public int getCode()
    {
        return code;
    }

    /**
     * 获得状态消息
     * @return 状态消息
     */
    public String getMsg()
    {
        return msg;
    }

    public CtccResultStatus format(Object... objects )
    {
        msg = String.format(msg, objects);
        return this;
    }
}