package com.wyp.hospital.mapper;

import com.wyp.hospital.model.Schedule;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface ScheduleMapper extends BaseMapper<Schedule> {

}
