package com.zeng.factory;

import com.zeng.constant.IdentityTypeConst;
import com.zeng.entities.vo.LoginVo;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class IdentityFactory {

    List<BaseIdentity> identityList;

    public IdentityFactory(List<BaseIdentity> identityList) {
        this.identityList = identityList;
    }

    public BaseIdentity productIdentity(LoginVo loginVo) {
        BaseIdentity identity = null;
        for (BaseIdentity baseIdentity : identityList) {
            IdentityTypeConst identityType = baseIdentity.getIdentityType();
            if (loginVo.getIdentityType().equals(identityType)) {
                identity = baseIdentity;
            }
        }
        return identity;
    }
}
