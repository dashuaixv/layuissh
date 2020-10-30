package com.gt.quartz;

import com.gt.model.*;
import com.gt.sys.service.*;
import com.gt.utils.*;
import org.quartz.*;
import org.springframework.beans.factory.annotation.*;

import javax.servlet.*;
import java.util.*;

/**
 * 基础Quartz
 *
 * @功能说明：
 * @作者： herun
 * @创建日期：2015-11-19
 * @版本号：V1.0
 */
public class BaseQuartz {

    @Autowired
    private IBaseService<Quarz> baseService;

    /**
     * 更改调度状态,且停止任务
     */
    public void updateQuartzState(Quarz quarz, ServletContext servletContext) {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("nid", quarz.getNid());
        baseService.executeHql("update Quarz t set t.state='2' where t. nid=:nid", params);

        try {
            QuarzUtils.pauseJob(quarz.getJobName(), quarz.getJobGroup());
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}
