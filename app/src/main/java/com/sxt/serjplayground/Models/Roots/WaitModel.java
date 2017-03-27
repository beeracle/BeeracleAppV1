package com.sxt.serjplayground.Models.Roots;

import com.sxt.serjplayground.Listeners.SimpleListener;
import com.sxt.serjplayground.Listeners.WaitListener;
import com.sxt.serjplayground.Models.Bases.BaseModel;

/**
 * Created by Serj on 07/03/2017.
 */

public class WaitModel extends BaseModel {

    public com.sxt.serjplayground.Listeners.WaitListener waitListener;

    public void Initialize()
    {

    }

    public void ShowWaitDialog()
    {
        if (waitListener != null)
        {
            waitListener.onEvent(true);
        }
    }

    public void HideWaitDialog()
    {
        if (waitListener != null)
        {
            waitListener.onEvent(false);
        }
    }
}
