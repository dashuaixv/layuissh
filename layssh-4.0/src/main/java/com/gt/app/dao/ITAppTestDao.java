package com.gt.app.dao;

import com.gt.model.*;
import org.springframework.data.jpa.repository.*;

/**
 *
 * @功能说明：测试管理自定义JPA-DAO接口
 * @作者：herun
 * @创建日期：2018-09-20
 * @版本号：V1.0
 */
public interface ITAppTestDao extends JpaRepository<TAppTest, Integer> {

}
