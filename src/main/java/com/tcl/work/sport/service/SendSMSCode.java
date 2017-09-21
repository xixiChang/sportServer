package com.tcl.work.sport.service;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import com.tcl.work.sport.constant.Constant;
import org.apache.log4j.Logger;


/**
 * Created by Emcc on 17-9-13.
 */
public class SendSMSCode {
    private Logger logger = Logger.getLogger(getClass().getName());
    private TaobaoClient client;

    public SendSMSCode() {
        this.client = new DefaultTaobaoClient(Constant.DAYU_SMS_URL,
                Constant.DAYU_APP_KEY, Constant.DAYU_APP_SECRET);
    }

    public void sendSms(String phoneNum, String code){
        logger.info(phoneNum + ":" + code);
        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
        req.setExtend("123456");
        req.setSmsType("normal");
        req.setSmsFreeSignName("爱运动");
        req.setSmsParamString("{\"number\":\"" +  code + "\"}");
        req.setRecNum(phoneNum);
        req.setSmsTemplateCode("SMS_8981318");
        AlibabaAliqinFcSmsNumSendResponse rsp = null;
        try {
            rsp = client.execute(req);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }


}
