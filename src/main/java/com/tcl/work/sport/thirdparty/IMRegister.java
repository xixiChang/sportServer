package com.tcl.work.sport.thirdparty;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.domain.Userinfos;
import com.taobao.api.request.OpenimUsersAddRequest;
import com.taobao.api.request.OpenimUsersUpdateRequest;
import com.taobao.api.response.OpenimUsersAddResponse;
import com.taobao.api.response.OpenimUsersUpdateResponse;
import com.tcl.work.sport.model.User;
import com.tcl.work.sport.utils.SHA1;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static com.tcl.work.sport.constant.Constant.*;

/**
 * Created by Emcc on 17-9-16.
 */
public class IMRegister {

    private TaobaoClient client = new DefaultTaobaoClient(BAICHUAN_URL,
            BAICHUAN_APP_KEY, BAICHUAN_APP_SECRET);
    private Logger logger = Logger.getLogger(getClass().getName());


    public void imUserRegister(User user){
        OpenimUsersAddRequest req = new OpenimUsersAddRequest();
        List<Userinfos> list = new ArrayList<Userinfos>();
        Userinfos obj = new Userinfos();
        obj.setName(user.getName());
        obj.setPassword(user.getSession());
        obj.setIconUrl(user.getImage_url());
        obj.setUserid(user.getIm_uid());
        obj.setNick(user.getName());
        list.add(obj);
        req.setUserinfos(list);
        try {
            OpenimUsersAddResponse rsp = client.execute(req);
            logger.debug(rsp);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    public void imUserUpdate(User user){
        OpenimUsersUpdateRequest  req = new OpenimUsersUpdateRequest();
        List<Userinfos> list = new ArrayList<Userinfos>();
        Userinfos obj = new Userinfos();
        obj.setName(user.getName());
        obj.setIconUrl(user.getImage_url());
        obj.setNick(user.getName());
        obj.setUserid(user.getIm_uid());
        list.add(obj);
        req.setUserinfos(list);
        try {
            OpenimUsersUpdateResponse rsp = client.execute(req);
            logger.debug(rsp);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }
}
