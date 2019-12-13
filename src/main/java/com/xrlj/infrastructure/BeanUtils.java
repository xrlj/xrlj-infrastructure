package com.xrlj.infrastructure;

import com.xrlj.framework.vo.VBaseResp;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

public final class BeanUtils<V extends VBaseResp> {

    /**
     * 把实体列表转成vo列表。
     * @param beanList  bean列表
     * @param modelMapper
     * @return
     */
    public List<V> conversionBeanListToVOList(List beanList, ModelMapper modelMapper) {
        java.lang.reflect.Type targetListType = new TypeToken<List<V>>() {}.getType();
        List<V> voList = modelMapper.map(beanList, targetListType);
        return voList;
    }

    /**
     * 把实体转成vo。
     * @param bean 实体对象。
     * @param tClass vo类型。
     * @param <T>
     * @return
     */
    protected <T extends VBaseResp> T conversionBeanToVO(Object bean, Class<T> tClass, ModelMapper modelMapper) {
        T t = modelMapper.map(bean, tClass);
        return t;
    }
}
