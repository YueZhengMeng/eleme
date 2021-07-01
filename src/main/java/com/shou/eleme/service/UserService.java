package com.shou.eleme.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    public String getLoginUserId()
    {
        return "pwb";
    }
}
