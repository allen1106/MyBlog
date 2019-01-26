package cn.allen.dreamsanreal.dao.mapper;

import cn.allen.dreamsanreal.model.ReadRecord;

public interface ReadRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReadRecord record);

    int insertSelective(ReadRecord record);

    ReadRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReadRecord record);

    int updateByPrimaryKey(ReadRecord record);
}