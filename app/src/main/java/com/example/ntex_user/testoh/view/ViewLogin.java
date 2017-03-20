package com.example.ntex_user.testoh.view;

import com.example.ntex_user.testoh.model.OneObject;

import java.util.List;

/**
 * Created by NTex-User on 3/13/2017.
 */

public interface ViewLogin {
    void succes(String token);

    void failed();

    void verifySucces();

    void succsesTask(List<OneObject> objectList);
}
