package com.gt.sys.dao;

import com.gt.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.*;
import org.springframework.data.repository.query.*;

import java.util.*;

/**
 * @Auther:herun
 * @Date: 2018/8/16 16:52
 * @Description:
 */
public interface ISysLogDao extends PagingAndSortingRepository<TSysLog, Integer>, JpaSpecificationExecutor {


    @Query("select t from TSysLog t ")
    public List<Map> getTSysLogAll(@Param("uuid") String uuid);

    @Query("select  new map(t.uuid ,t.compareInf) from TSysLog t ")
    public List<Map> getTSysLogAll();

    public long countByOperUsrId(String operUsrId);


}
