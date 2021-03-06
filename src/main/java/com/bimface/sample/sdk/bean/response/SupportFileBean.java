package com.bimface.sample.sdk.bean.response;
import java.io.Serializable;
import java.util.Arrays;

/**
 * app支持的文件格式和大小上限
 * 
 * @author bimface, 2016-09-01.
 */
public class SupportFileBean implements Serializable {

    private static final long serialVersionUID = 2079630061626099307L;
    private Long              length;                                 // 文件大小的上限
    private String[]          types;                                  // 支持的文件格式

    public SupportFileBean() {
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public String[] getTypes() {
        return types;
    }

    public void setTypes(String[] types) {
        this.types = types;
    }

    @Override
    public String toString() {
        return "SupportFileBean [length=" + length + ", types=" + Arrays.toString(types) + "]";
    }
}
