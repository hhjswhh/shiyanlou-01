package shiyanlou.mybatis.onetomany.mapper;

import shiyanlou.mybatis.onetomany.model.Classes;

public interface ClassesMapper {

    /*
     * ?? id ???? Classes ?????
     * @param id
     * @return
     * @throws Exception
     */
    public Classes selectClassAndStudentsById(Integer id) throws Exception;

}
