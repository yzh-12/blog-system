package com.zeng.factory;

import com.zeng.constant.IdentityTypeConst;
import com.zeng.entities.vo.LoginVo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Component
public class IdentityFactory {

    private Map<IdentityTypeConst, BaseIdentity> identityMap;

    public IdentityFactory(List<BaseIdentity> identityList) {
        this.identityMap = identityList.stream().collect(Collectors.toMap(BaseIdentity::getIdentityType, e -> e));
    }

    public BaseIdentity productIdentity(LoginVo loginVo) {
        IdentityTypeConst type = loginVo.getIdentityType();
        BaseIdentity identity = identityMap.get(type);
        if (identity == null) {
            throw new IllegalArgumentException("error identity type.");
        }
        return identity;
    }
}
