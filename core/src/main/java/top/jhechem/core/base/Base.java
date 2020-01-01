package top.jhechem.core.base;

import cn.devonkey.util.GsonUtil;

import java.io.Serializable;

/**
 * @author hugo
 */
public abstract class Base implements Serializable {

    @Override
    public String toString() {
        return GsonUtil.GSON.toJson(this);
    }
}
