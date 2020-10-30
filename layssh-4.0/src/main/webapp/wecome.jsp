<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<head>
    <meta charset="utf-8">
    <title>LaySSH开发框架</title>
    <jsp:include page="inc.jsp"></jsp:include>
</head>

<body>
<html>
<H1>LaySSH开发框架4.0</H1><br>
<fieldset class="layui-elem-field layui-field-title alone-title" style="width: 300px;">
    <legend>历史版本事件</legend>
</fieldset>
<ul class="layui-timeline" style="margin-left:50px">
    <li class="layui-timeline-item"><i class="layui-icon layui-timeline-axis">&#xe63f;</i>
        <div class="layui-timeline-content layui-text">
            <h3 class="layui-timeline-title">2018年09月29日</h3>
            <p>
                优化了删除模块的代码生成功能
            </p>
        </div>
    </li>
    <li class="layui-timeline-item"><i class="layui-icon layui-timeline-axis">&#xe63f;</i>
        <div class="layui-timeline-content layui-text">
            <h3 class="layui-timeline-title">2018年09月25日</h3>
            <p>
               优化了用户管理查询功能
            </p>
        </div>
    </li>
    <li class="layui-timeline-item"><i class="layui-icon layui-timeline-axis">&#xe63f;</i>
        <div class="layui-timeline-content layui-text">
            <h3 class="layui-timeline-title">2018年09月21日</h3>
            <p>
                诞生4.0版本 <br>技术框架:Spring boot+JPA(Hibernate实现)+SpringMVC+Spring+LayUI+Freemark+Quartz <br>数据库：&nbsp;mysql+Redies
                <br>编译器：&nbsp;IDEA <br>JDK：&nbsp;1.8+ <br>容器：&nbsp;tomcate1.8+
            </p>
        </div>
    </li>
    <li class="layui-timeline-item"><i class="layui-icon layui-timeline-axis">&#xe63f;</i>
        <div class="layui-timeline-content layui-text">
            <div class="layui-timeline-title">过去</div>
        </div>
    </li>
    <li class="layui-timeline-item"><i class="layui-icon layui-timeline-axis">&#xe63f;</i>
        <div class="layui-timeline-content layui-text">
            <div class="layui-timeline-title">20191112到此一游</div>
        </div>
    </li>
</ul>
</body>

</html>
<script type="text/javascript">
    layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload',
        'element'], function () {

    });
</script>
