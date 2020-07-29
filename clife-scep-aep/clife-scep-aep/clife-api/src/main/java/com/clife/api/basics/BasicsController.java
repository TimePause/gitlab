package com.clife.api.basics;


import com.clife.common.constants.CtccGlobalResultStatus;
import com.clife.common.constants.CtccResultStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.clife.service.basics.*;


@RestController
public class BasicsController {

    //AEP获取产品列表接口地址
    @Value("${AEP_GET_PRODUCT_LIST}")
    private String getProductListUrl;

    //AEP获取设备列表接口地址
    @Value("${AEP_GET_DEVICE_LIST}")
    private String getDeviceListUrl;

    //AEP增加设备接口地址
    @Value("${AEP_POST_ADD_DEVICE}")
    private String addDeviceInfoUrl;

    //AEP更新设备接口地址
    @Value("${AEP_PUT_UPDATE_DEVICE}")
    private String updateDeviceInfoUrl;

    //AEP删除设备接口地址
    @Value("${AEP_DELETE_DELETE_DEVICE}")
    private String deleteDeviceInfoUrl;

    //AEP查询设备接口地址
    @Value("${AEP_GET_EQUIPMENT_DETAILS}")
    private String getDeviceInfoUrl;

    @Autowired
    private BasicsServiceImpl basicsServiceImpl;


    /**
     * 获取产品列表接口
     * @return
     */
    @GetMapping("/basics/getProductList")
    public String getProductList(@RequestParam String appId, @RequestParam String appSecret, String searchValue,
                              int pageNow, int pageSize){
        System.out.print(appId+":"+appSecret);
        String result = basicsServiceImpl.getProductList(getProductListUrl,appId,appSecret,searchValue,pageNow,pageSize);
        return result;
    }

    /**
     * 获取设备列表接口
     * @return
     */
    @GetMapping("/basics/getDeviceList")
    public String getDeviceList(String appId, String appSecret , String masterKey, String productId, @RequestParam(required = false) String searchValue,
                                @RequestParam(required = false) int pageNow,@RequestParam(required = false) int pageSize){
        try {
            return basicsServiceImpl.getDeviceList(getDeviceListUrl, appId, appSecret, masterKey, productId, searchValue, pageNow, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
            return "调用AEP获取设备列表接口异常";
        }
    }

    /**
     * 查询设备接口
     * @return
     */
    @GetMapping("/basics/getDevice")
    public String getDevice(String appId, String appSecret , String masterKey, String productId, String deviceId){
        try{
            return basicsServiceImpl.getDevice(getDeviceInfoUrl, appId, appSecret, masterKey, productId, deviceId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "调用AEP查询接口异常";
    }

    /**
     * 删除设备接口
     * @return
     */
    @PostMapping("/basics/deleteDevice")
    public String deleteDevice(String appId, String appSecret, String masterKey, String productId ,String deviceId){
        try{
            return basicsServiceImpl.deleteDevice(deleteDeviceInfoUrl, appId, appSecret, masterKey, productId, deviceId);
        }catch (Exception e){
            e.printStackTrace();
            return "调用AEP删除接口异常";
        }
    }


    /**
     * 新增设备接口
     * @param appId
     * @param appSecret
     * @param MasterKey
     * @param data
     * @return
     */
    @PostMapping("/basics/createDevice")
    public String createDevice(String appId,String appSecret,String MasterKey, String data){
        return basicsServiceImpl.createDevice(addDeviceInfoUrl,appId,appSecret,MasterKey,data);
    }

    /**
     * 修改设备接口
     * @return
     */
    @PostMapping("/basics/updateDevice")
    public String updateDevice(String appId,String appSecret,String MasterKey, String deviceId){

        return basicsServiceImpl.updateDevice(updateDeviceInfoUrl,appId,appSecret,MasterKey,deviceId);
    }

}
