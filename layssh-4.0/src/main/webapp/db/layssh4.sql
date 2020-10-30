/*
Navicat MySQL Data Transfer

Source Server         : 116.62.213.179(我的测试)
Source Server Version : 50716
Source Host           : 116.62.213.179:3306
Source Database       : layssh4

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2018-09-26 19:02:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_app_student`
-- ----------------------------
DROP TABLE IF EXISTS `t_app_student`;
CREATE TABLE `t_app_student` (
  `UUID` varchar(36) NOT NULL DEFAULT '' COMMENT '主键',
  `NAME` varchar(50) NOT NULL COMMENT '名字',
  `SEX` varchar(1) NOT NULL COMMENT '性别',
  `STATE` varchar(1) NOT NULL COMMENT '状态',
  `NOTE` varchar(200) DEFAULT NULL COMMENT '备注',
  `DATE_BIRTH` varchar(10) NOT NULL COMMENT '出生年月',
  `ARCHIVES` varchar(500) NOT NULL COMMENT '档案',
  `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`UUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生表';

-- ----------------------------
-- Records of t_app_student
-- ----------------------------
INSERT INTO `t_app_student` VALUES ('bb591344-a00f-4b7c-85bd-9834cf21846f', '1', '0', '0', '1', '1986-01-01', '新建 WinRAR ZIP 压缩文件.zip', '2018-09-20 16:14:21', null);

-- ----------------------------
-- Table structure for `t_app_test`
-- ----------------------------
DROP TABLE IF EXISTS `t_app_test`;
CREATE TABLE `t_app_test` (
  `myuuid` varchar(36) NOT NULL DEFAULT '' COMMENT '主键',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(1) DEFAULT NULL COMMENT '性别',
  `age` varchar(1) DEFAULT NULL COMMENT '年纪',
  PRIMARY KEY (`myuuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='测试表';

-- ----------------------------
-- Records of t_app_test
-- ----------------------------
INSERT INTO `t_app_test` VALUES ('0', '11', '1', '1');
INSERT INTO `t_app_test` VALUES ('1', '11', '1', '1');
INSERT INTO `t_app_test` VALUES ('11', '11', '1', '1');
INSERT INTO `t_app_test` VALUES ('12', '11', '1', '1');
INSERT INTO `t_app_test` VALUES ('13', '11', '1', '1');
INSERT INTO `t_app_test` VALUES ('14', '11', '1', '1');
INSERT INTO `t_app_test` VALUES ('15', '11', '1', '1');
INSERT INTO `t_app_test` VALUES ('16', '11', '1', '1');
INSERT INTO `t_app_test` VALUES ('17', '11', '1', '1');
INSERT INTO `t_app_test` VALUES ('18', '11', '1', '1');
INSERT INTO `t_app_test` VALUES ('19', '11', '1', '1');
INSERT INTO `t_app_test` VALUES ('2', '11', '1', '1');
INSERT INTO `t_app_test` VALUES ('20', '11', '1', '1');
INSERT INTO `t_app_test` VALUES ('21', '11', '1', '1');
INSERT INTO `t_app_test` VALUES ('22', '11', '1', '1');
INSERT INTO `t_app_test` VALUES ('23', '11', '1', '1');
INSERT INTO `t_app_test` VALUES ('24', '11', '1', '1');
INSERT INTO `t_app_test` VALUES ('25', '11', '1', '1');
INSERT INTO `t_app_test` VALUES ('26', '11', '1', '1');
INSERT INTO `t_app_test` VALUES ('27', '11', '1', '1');
INSERT INTO `t_app_test` VALUES ('28', '11', '1', '1');
INSERT INTO `t_app_test` VALUES ('29', '11', '1', '1');
INSERT INTO `t_app_test` VALUES ('3', '11', '1', '1');
INSERT INTO `t_app_test` VALUES ('31', '11', '1', '1');
INSERT INTO `t_app_test` VALUES ('32', '11', '1', '1');
INSERT INTO `t_app_test` VALUES ('33', '11', '1', '1');
INSERT INTO `t_app_test` VALUES ('34', '11', '1', '1');
INSERT INTO `t_app_test` VALUES ('35', '11', '1', '1');
INSERT INTO `t_app_test` VALUES ('36', '11', '1', '1');

-- ----------------------------
-- Table structure for `t_sys_dict_cd`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_dict_cd`;
CREATE TABLE `t_sys_dict_cd` (
  `UUID` varchar(36) NOT NULL COMMENT 'UUID',
  `DICT_CD` varchar(36) NOT NULL COMMENT '字典代码',
  `DICT_NM` varchar(100) DEFAULT NULL COMMENT '字典名称',
  `DICT_TYPE_CD` varchar(36) NOT NULL COMMENT '字典类型',
  PRIMARY KEY (`UUID`),
  KEY `FK_Reference_1` (`DICT_TYPE_CD`) USING BTREE,
  CONSTRAINT `t_sys_dict_cd_ibfk_1` FOREIGN KEY (`DICT_TYPE_CD`) REFERENCES `t_sys_dict_tp` (`DICT_TYPE_CD`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据字典表';

-- ----------------------------
-- Records of t_sys_dict_cd
-- ----------------------------
INSERT INTO `t_sys_dict_cd` VALUES ('0013d932-ca44-4df6-bdc4-bdcb1f667947', '0', '运行中', 'quarz_state');
INSERT INTO `t_sys_dict_cd` VALUES ('01949f81-cfb8-4a0a-a455-b36a0e719fdf', 'quarz/add', 'true', 'adminOper');
INSERT INTO `t_sys_dict_cd` VALUES ('01ad3289-a03d-47e0-8dd1-99e3f288b38a', '2', '注销', 'oper_st');
INSERT INTO `t_sys_dict_cd` VALUES ('030f558d-d097-47d0-91b2-5ed63216fc8b', '0', '系统管理员', 'job_tp');
INSERT INTO `t_sys_dict_cd` VALUES ('03183bc4-6ae5-4fff-871e-efc097ecfbfa', 'menuInf/add', 'true', 'adminOper');
INSERT INTO `t_sys_dict_cd` VALUES ('06448028-911f-4f05-91f7-69a84f0e25a1', '2', '市公司', 'ins_lvl');
INSERT INTO `t_sys_dict_cd` VALUES ('081531fe-fd4a-45dc-bf50-beb228b3e0c5', '0', '男', 't_test_sex');
INSERT INTO `t_sys_dict_cd` VALUES ('08e3e5e7-4204-4376-98d3-0a4cb8deba93', 'menuInf/remove', 'true', 'adminOper');
INSERT INTO `t_sys_dict_cd` VALUES ('0cae7414-9e80-465a-b150-e04869be1e54', 'sysFunctionInf/add', 'true', 'adminOper');
INSERT INTO `t_sys_dict_cd` VALUES ('0ead7704-ebdb-4883-b2ea-b03a20f0fcc9', 'menuInf/modify', 'true', 'adminOper');
INSERT INTO `t_sys_dict_cd` VALUES ('0ffed251-96e9-4a8a-919e-a98cb48b814d', 'dictTp/remove.do', 'true', 'adminOper');
INSERT INTO `t_sys_dict_cd` VALUES ('1447e7af-970b-4b00-bf17-76afccf230d8', 'dictTp/modify.do', 'true', 'adminOper');
INSERT INTO `t_sys_dict_cd` VALUES ('17a314b1-7470-4eaf-a3ef-4110f7599564', 'quarz/remove.do', 'true', 'adminOper');
INSERT INTO `t_sys_dict_cd` VALUES ('17fee7dd-2ad4-43b4-b8fb-912e821bb44d', 'dictCd/modify.do', 'true', 'adminOper');
INSERT INTO `t_sys_dict_cd` VALUES ('1a24e3b9-8eb6-479e-82e0-83bedcb529e5', '1', '关闭', 'timer_star_closed');
INSERT INTO `t_sys_dict_cd` VALUES ('1dd03710-66c6-4c33-a94d-2a61ace43e9c', 'insInf/remove.do', 'true', 'adminOper');
INSERT INTO `t_sys_dict_cd` VALUES ('298dda6e-3216-410f-b0b0-fe7f5fc2e932', '1', '定时执行', 'timer_type');
INSERT INTO `t_sys_dict_cd` VALUES ('2e924c5a-800d-43ae-a71a-ed710ef78fc0', '0', '在读', 'student_state');
INSERT INTO `t_sys_dict_cd` VALUES ('311b283a-d7d2-4655-b555-52818ee37652', '0', '正常', 'oper_st');
INSERT INTO `t_sys_dict_cd` VALUES ('31b816c6-7a13-44cf-9a54-1535dd71b325', '0', '开启', 'timer_star_closed');
INSERT INTO `t_sys_dict_cd` VALUES ('34a31c51-7760-49f3-85da-37496b84aa87', '1', '女', 't_test_sex');
INSERT INTO `t_sys_dict_cd` VALUES ('4163a2f9-5b3f-4502-a94d-1fc9e464bc3a', '1', '省公司', 'ins_lvl');
INSERT INTO `t_sys_dict_cd` VALUES ('45145bec-903b-4d6f-92c0-367addc5875c', '2', '异常', 'timer_state');
INSERT INTO `t_sys_dict_cd` VALUES ('5a8e7226-6755-4c9b-a5a5-fe6db4a8d7a9', 'dictTp/add.do', 'true', 'adminOper');
INSERT INTO `t_sys_dict_cd` VALUES ('5d915556-10fc-4a25-be73-0886be2d8299', '0', '男', 'student_sex');
INSERT INTO `t_sys_dict_cd` VALUES ('5fad9f38-487a-4143-b1ac-feaec636b29d', 'codeGenerator/createCode.do', 'true', 'adminOper');
INSERT INTO `t_sys_dict_cd` VALUES ('66607068-9d6a-4d57-ad35-0bb5fbed653d', 'dictCd/remove.do', 'true', 'adminOper');
INSERT INTO `t_sys_dict_cd` VALUES ('6a870049-2b9c-47b2-9e8e-8ff892439cc0', '0', '运行中', 'timer_state');
INSERT INTO `t_sys_dict_cd` VALUES ('6b2913a8-3e89-48f4-a1db-2722ec1e2b59', '0', '管理机构', 'ins_tp');
INSERT INTO `t_sys_dict_cd` VALUES ('6c2b3b11-c737-4892-92a2-6e397c714546', 'sysFunctionInf/remove.do', 'true', 'adminOper');
INSERT INTO `t_sys_dict_cd` VALUES ('6ecde32b-5dea-43c3-ac66-580e7c5283c1', '1', '仓库管理员', 'job_tp');
INSERT INTO `t_sys_dict_cd` VALUES ('6faa52a5-d85b-4182-8379-da5f75c6c8cd', '0', '集团公司', 'ins_lvl');
INSERT INTO `t_sys_dict_cd` VALUES ('72d513c4-5fcb-42b6-b915-05787b350894', 'sysFunctionInf/modify.do', 'true', 'adminOper');
INSERT INTO `t_sys_dict_cd` VALUES ('752d5f6c-b982-4a17-b6c1-f4b746df5fe5', '1', '女', 'student_sex');
INSERT INTO `t_sys_dict_cd` VALUES ('75e69cfd-0f13-4732-9907-844da202a030', '1', '销售', 'ins_tp');
INSERT INTO `t_sys_dict_cd` VALUES ('7922456b-e6b2-49b6-983e-013f37b7a668', '3', '县区', 'ins_lvl');
INSERT INTO `t_sys_dict_cd` VALUES ('7c326bfd-3ddf-4407-a5b1-d3160705a2c2', '2', '其他', 'ins_tp');
INSERT INTO `t_sys_dict_cd` VALUES ('8ee64ac2-f708-403b-9b84-8d3a3ba2d461', 'noInterceptor/modify.do', 'true', 'adminOper');
INSERT INTO `t_sys_dict_cd` VALUES ('8fbbd735-3422-4411-9033-57276508a1a8', '2', '定时执行+重复执行', 'timer_type');
INSERT INTO `t_sys_dict_cd` VALUES ('941c494c-4c88-48e7-abf9-104254fa77d1', 'quarz/modify.do', 'true', 'adminOper');
INSERT INTO `t_sys_dict_cd` VALUES ('94c8a285-14c3-4a8b-8f6b-dd59b7b48c0b', 'noInterceptor/add.do', 'true', 'adminOper');
INSERT INTO `t_sys_dict_cd` VALUES ('ba1f2e47-02e8-487d-9ad3-da3be7c5f123', '1', '暂停', 'timer_state');
INSERT INTO `t_sys_dict_cd` VALUES ('cb95b367-6f52-4b1a-821f-16ef7928e0d6', '1', '毕业', 'student_state');
INSERT INTO `t_sys_dict_cd` VALUES ('cba6590a-549a-4ab2-8443-72f8c239f540', 'dictCd/add.do', 'true', 'adminOper');
INSERT INTO `t_sys_dict_cd` VALUES ('cf681fff-180a-47ae-9758-22373b80556c', '0', '重复执行', 'timer_type');
INSERT INTO `t_sys_dict_cd` VALUES ('d2f640cc-be8a-407f-8304-344e1218cf33', '1', '第二组', 'quarz_job_group');
INSERT INTO `t_sys_dict_cd` VALUES ('d65959a6-8d48-4c01-8fc4-b7acaa6bbe65', 'insInf/modify.do', 'true', 'adminOper');
INSERT INTO `t_sys_dict_cd` VALUES ('dec87293-85b2-4b14-be12-9ca723cbbe35', '0', '第一组', 'quarz_job_group');
INSERT INTO `t_sys_dict_cd` VALUES ('e4db4b0f-1996-461c-aa16-22f3ed04d8ba', 'noInterceptor/remove', 'true', 'adminOper');
INSERT INTO `t_sys_dict_cd` VALUES ('fcbea470-7cef-4dc4-8cf9-da7b9fea2592', '1', '暂停', 'quarz_state');
INSERT INTO `t_sys_dict_cd` VALUES ('fdb404d3-b5f3-4060-9ce0-e770132251b9', '0', '后台管理系统', 'sys_nm');
INSERT INTO `t_sys_dict_cd` VALUES ('fde25881-0f1f-4e70-870f-15257135d94b', '2', '异常', 'quarz_state');

-- ----------------------------
-- Table structure for `t_sys_dict_tp`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_dict_tp`;
CREATE TABLE `t_sys_dict_tp` (
  `DICT_TYPE_CD` varchar(36) NOT NULL COMMENT '字典类型编号',
  `DICT_TYPE_NM` varchar(100) NOT NULL COMMENT '字典类型名称',
  PRIMARY KEY (`DICT_TYPE_CD`),
  KEY `DICT_TYPE_CD` (`DICT_TYPE_CD`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典类型表';

-- ----------------------------
-- Records of t_sys_dict_tp
-- ----------------------------
INSERT INTO `t_sys_dict_tp` VALUES ('adminOper', '超级管理员才能操作的模块');
INSERT INTO `t_sys_dict_tp` VALUES ('ins_lvl', '机构级别');
INSERT INTO `t_sys_dict_tp` VALUES ('ins_tp', '机构类型');
INSERT INTO `t_sys_dict_tp` VALUES ('job_tp', '岗位类型');
INSERT INTO `t_sys_dict_tp` VALUES ('oper_st', '用户状态');
INSERT INTO `t_sys_dict_tp` VALUES ('quarz_job_group', '调度任务组');
INSERT INTO `t_sys_dict_tp` VALUES ('quarz_state', '调度器状态');
INSERT INTO `t_sys_dict_tp` VALUES ('student_sex', '学生表-性别');
INSERT INTO `t_sys_dict_tp` VALUES ('student_state', '学生-状态');
INSERT INTO `t_sys_dict_tp` VALUES ('sys_nm', '系统名称');
INSERT INTO `t_sys_dict_tp` VALUES ('sys_url', '跳转后台');
INSERT INTO `t_sys_dict_tp` VALUES ('timer_star_closed', '定时器开关');
INSERT INTO `t_sys_dict_tp` VALUES ('timer_state', '定时器状态');
INSERT INTO `t_sys_dict_tp` VALUES ('timer_type', '定时器类型');
INSERT INTO `t_sys_dict_tp` VALUES ('t_test_sex', '性别');

-- ----------------------------
-- Table structure for `t_sys_function_inf`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_function_inf`;
CREATE TABLE `t_sys_function_inf` (
  `FUNCTION_CD` varchar(36) NOT NULL COMMENT '主键',
  `FUNCTION_NM` varchar(50) NOT NULL COMMENT '菜单名称',
  `FUNCTION_URL` varchar(200) DEFAULT NULL COMMENT '请求地址',
  `MENU_ID` varchar(36) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`FUNCTION_CD`),
  KEY `FK_Reference_3` (`MENU_ID`) USING BTREE,
  CONSTRAINT `t_sys_function_inf_ibfk_1` FOREIGN KEY (`MENU_ID`) REFERENCES `t_sys_menu_inf` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统功能表';

-- ----------------------------
-- Records of t_sys_function_inf
-- ----------------------------
INSERT INTO `t_sys_function_inf` VALUES ('0393d871-052f-4913-bc53-503944c48b29', '修改', 'menuInf/modify', '6b0783ec-1a19-40cb-8ee7-15d5bcb0b422');
INSERT INTO `t_sys_function_inf` VALUES ('0469f9ec-7c1e-4eca-9181-5e503cce32d4', '增加', 'menuInf/add', '6b0783ec-1a19-40cb-8ee7-15d5bcb0b422');
INSERT INTO `t_sys_function_inf` VALUES ('073dbafb-a910-429e-9d95-bd1b7f5bef60', '增加', 'roleInf/add', 'ddd9ee7c-0518-4465-a42e-db795159a5b5');
INSERT INTO `t_sys_function_inf` VALUES ('096a5b8f-b162-47e5-a23c-2f2cece5cb27', '查询', 'sysFunctionInf/datagrid', '724df8a4-db6e-410f-b712-58a57c3fe1d9');
INSERT INTO `t_sys_function_inf` VALUES ('153dd4f4-ff5c-4759-a002-7115c574a76b', '增加', 'dictTp/add', '720f5f7f-f3d8-4881-ba30-d07a29029aac');
INSERT INTO `t_sys_function_inf` VALUES ('1763c122-ad6b-43e4-9500-e7095979f176', '查询', 'dictCd/datagrid', 'ed4794fa-5e27-442e-84c1-11d373ef83b5');
INSERT INTO `t_sys_function_inf` VALUES ('17f64087-0737-4681-ba9e-5ef8775c4adb', '查询', 'insInf/datagrid', '37d317f7-6417-4ea7-81e1-cf9f499ee273');
INSERT INTO `t_sys_function_inf` VALUES ('1b74c033-fce9-4a25-9d17-d08956925677', '增加', 'insInf/add', '37d317f7-6417-4ea7-81e1-cf9f499ee273');
INSERT INTO `t_sys_function_inf` VALUES ('1db71f80-e76f-4508-b7d0-c00771ef3ce6', '删除', 'tAppTest/remove', '7e566aaf-3eea-4998-8b2b-49f5b204a50c');
INSERT INTO `t_sys_function_inf` VALUES ('1f4b7f46-eb67-4738-ab87-5e82f282f962', '修改', 'operInf/modify', 'd307c58f-37c6-498a-aa33-b343e2370290');
INSERT INTO `t_sys_function_inf` VALUES ('239efc32-4791-47a9-a5ab-129ddf8705dd', '修改', 'roleInf/modify', 'ddd9ee7c-0518-4465-a42e-db795159a5b5');
INSERT INTO `t_sys_function_inf` VALUES ('267df9fc-5e46-4dd0-b434-c92affb54e86', '删除', 'sysFunctionInf/remove', '724df8a4-db6e-410f-b712-58a57c3fe1d9');
INSERT INTO `t_sys_function_inf` VALUES ('2a763fe4-e1f1-4cba-9b83-01af20bbf18e', '新增', 'quarz/add', 'e4be5554-96ae-4d5b-ae52-ed8154627796');
INSERT INTO `t_sys_function_inf` VALUES ('2ae5e576-22ec-47c3-9816-c6b4d45888ba', '修改', 'dictCd/modify', 'ed4794fa-5e27-442e-84c1-11d373ef83b5');
INSERT INTO `t_sys_function_inf` VALUES ('2cdd63c7-3558-42e7-841d-2f563ff69ca8', '查询', 'operInf/datagrid', 'd307c58f-37c6-498a-aa33-b343e2370290');
INSERT INTO `t_sys_function_inf` VALUES ('37b286ee-d841-4be1-bf15-ac379b64c256', '新增', 'sysFunctionInf/add', '724df8a4-db6e-410f-b712-58a57c3fe1d9');
INSERT INTO `t_sys_function_inf` VALUES ('3bbb800f-2097-420e-a00b-08d480ff4996', '修改', 'student/modify', 'bf64165c-65ae-49ad-a530-77b9593cf96e');
INSERT INTO `t_sys_function_inf` VALUES ('3d5d5be3-5080-49ea-a439-86a091e3acc6', '删除', 'insInf/remove', '37d317f7-6417-4ea7-81e1-cf9f499ee273');
INSERT INTO `t_sys_function_inf` VALUES ('48df6106-d3d2-4ed3-8cc4-d5716fa8f18f', '删除', 'student/remove', 'bf64165c-65ae-49ad-a530-77b9593cf96e');
INSERT INTO `t_sys_function_inf` VALUES ('4d91aafc-366e-471c-855f-e4637c9dfdb8', '修改', 'sysFunctionInf/modify', '724df8a4-db6e-410f-b712-58a57c3fe1d9');
INSERT INTO `t_sys_function_inf` VALUES ('55dce07d-6069-4d7f-85e9-30788ac4e568', '删除', 'menuInf/remove', '6b0783ec-1a19-40cb-8ee7-15d5bcb0b422');
INSERT INTO `t_sys_function_inf` VALUES ('587fc6a6-9836-47fb-ac7b-ebdf80369765', '新增', 'noInterceptor/add', '7420eb7d-fa91-4e3c-b732-425740b583ea');
INSERT INTO `t_sys_function_inf` VALUES ('6239127e-9be1-4d74-ab14-f0c0afaecd80', '查询', 'noInterceptor/datagrid', '7420eb7d-fa91-4e3c-b732-425740b583ea');
INSERT INTO `t_sys_function_inf` VALUES ('69bcfc3e-286c-4ede-9799-2548ea520921', '授权', 'roleFunction/add', 'ddd9ee7c-0518-4465-a42e-db795159a5b5');
INSERT INTO `t_sys_function_inf` VALUES ('6a4a4fac-9887-4423-be16-d0c36cb1d5d3', '修改', 'quarz/modify', 'e4be5554-96ae-4d5b-ae52-ed8154627796');
INSERT INTO `t_sys_function_inf` VALUES ('7342eac9-5a8d-46a6-9b14-a3567ba41c45', '删除', 'dictTp/remove', '720f5f7f-f3d8-4881-ba30-d07a29029aac');
INSERT INTO `t_sys_function_inf` VALUES ('796a830e-0677-42e3-8f67-1379f90cd6a4', '修改', 'noInterceptor/modify', '7420eb7d-fa91-4e3c-b732-425740b583ea');
INSERT INTO `t_sys_function_inf` VALUES ('81361182-d73a-4548-a4f0-0582f42ae999', '查询', 'quarz/datagrid', 'e4be5554-96ae-4d5b-ae52-ed8154627796');
INSERT INTO `t_sys_function_inf` VALUES ('81a09fef-8b00-45dc-b284-142c6e869765', '查询', 'menuInf/datagrid', '6b0783ec-1a19-40cb-8ee7-15d5bcb0b422');
INSERT INTO `t_sys_function_inf` VALUES ('844e1ce9-7f9e-459d-81cc-978ae39265dc', '查询', 'tAppTest/datagrid', '7e566aaf-3eea-4998-8b2b-49f5b204a50c');
INSERT INTO `t_sys_function_inf` VALUES ('8462f40f-38e7-43ad-9804-bad5bbe513f4', '代码生成', 'codeGenerator/createCode', '6ea54859-479c-4eac-8bf2-daa6bfca6aa4');
INSERT INTO `t_sys_function_inf` VALUES ('85bb6d0a-d43b-4f15-a437-e2ffd5857ff8', '修改', 'insInf/modify', '37d317f7-6417-4ea7-81e1-cf9f499ee273');
INSERT INTO `t_sys_function_inf` VALUES ('88b64c61-d1f7-4015-b548-9cdda3a9e1fa', '删除', 'operInf/remove', 'd307c58f-37c6-498a-aa33-b343e2370290');
INSERT INTO `t_sys_function_inf` VALUES ('9dc107be-ac92-42f7-8ba0-5123b8af6e30', '删除', 'noInterceptor/remove', '7420eb7d-fa91-4e3c-b732-425740b583ea');
INSERT INTO `t_sys_function_inf` VALUES ('a10b43cf-c9dd-4f4d-8ea3-d2dd472855e7', '查询', 'student/datagrid', 'bf64165c-65ae-49ad-a530-77b9593cf96e');
INSERT INTO `t_sys_function_inf` VALUES ('a1c5fc1c-848c-4fda-97b5-675949e07ef1', '增加', 'operInf/add', 'd307c58f-37c6-498a-aa33-b343e2370290');
INSERT INTO `t_sys_function_inf` VALUES ('c06c6158-9664-45ff-afcb-b588bb12a6f0', '查询', 'dictTp/datagrid', '720f5f7f-f3d8-4881-ba30-d07a29029aac');
INSERT INTO `t_sys_function_inf` VALUES ('c3fe0bbd-b799-47c9-8406-810a04fc6d36', '修改', 'dictTp/modify', '720f5f7f-f3d8-4881-ba30-d07a29029aac');
INSERT INTO `t_sys_function_inf` VALUES ('c48ad87e-097e-4936-98e2-a1959c277cd0', '查询', 'roleInf/datagrid', 'ddd9ee7c-0518-4465-a42e-db795159a5b5');
INSERT INTO `t_sys_function_inf` VALUES ('c5946918-dad5-4088-9cc4-c5eca71f8fdc', '查询', 'sysLog/datagrid', '3df4bb66-3e06-4f81-a020-7bc98e4bc5ac');
INSERT INTO `t_sys_function_inf` VALUES ('cff79ae9-f8f0-406d-8a6e-be0099df3df2', '删除', 'roleInf/remove', 'ddd9ee7c-0518-4465-a42e-db795159a5b5');
INSERT INTO `t_sys_function_inf` VALUES ('d8c2edd7-d5d8-4cba-82e1-ba2a3c3cdc80', '删除', 'quarz/remove', 'e4be5554-96ae-4d5b-ae52-ed8154627796');
INSERT INTO `t_sys_function_inf` VALUES ('dd966007-afad-4afa-bcbd-7c071ed3cb73', '删除', 'dictCd/remove', 'ed4794fa-5e27-442e-84c1-11d373ef83b5');
INSERT INTO `t_sys_function_inf` VALUES ('e0d38e1f-cdd3-4a0e-b7ea-3c525ac52101', '新增', 'student/add', 'bf64165c-65ae-49ad-a530-77b9593cf96e');
INSERT INTO `t_sys_function_inf` VALUES ('e29d1323-1ea4-4298-9ce8-9df239424023', '密码重置', 'operInf/redoPwd', 'd307c58f-37c6-498a-aa33-b343e2370290');
INSERT INTO `t_sys_function_inf` VALUES ('e91b055d-4332-4b36-9a46-8a8ad9079162', '增加', 'dictCd/add', 'ed4794fa-5e27-442e-84c1-11d373ef83b5');
INSERT INTO `t_sys_function_inf` VALUES ('f03fadc4-d5e2-4911-8df7-4dca3bc29a5c', '修改', 'tAppTest/modify', '7e566aaf-3eea-4998-8b2b-49f5b204a50c');
INSERT INTO `t_sys_function_inf` VALUES ('f1cb6d84-2c10-49d8-ba0e-82f9690df4ec', '新增', 'tAppTest/add', '7e566aaf-3eea-4998-8b2b-49f5b204a50c');
INSERT INTO `t_sys_function_inf` VALUES ('f6de33f5-be5b-4e8d-8363-9c157c70d8d0', '查询', 'codeGenerator/getFieldList', '6ea54859-479c-4eac-8bf2-daa6bfca6aa4');

-- ----------------------------
-- Table structure for `t_sys_ins_inf`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_ins_inf`;
CREATE TABLE `t_sys_ins_inf` (
  `UUID` varchar(36) NOT NULL COMMENT '主键',
  `INS_CD` varchar(10) NOT NULL COMMENT '机构编号',
  `INS_DETAIL` text COMMENT '机构详情',
  `INS_DETAIL_NOT_MY` text COMMENT '机构详情',
  `INS_LVL` varchar(1) DEFAULT NULL COMMENT '机构级别',
  `INS_NM` varchar(50) DEFAULT NULL COMMENT '机构名称',
  `PARENT_INS_CD` varchar(36) DEFAULT NULL COMMENT '上一级机构编号',
  `UP_TWO_INS` varchar(36) DEFAULT NULL COMMENT '上二级机构编号',
  `UP_THREE_INS` varchar(36) DEFAULT NULL COMMENT '上三级机构编号',
  `INS_TP` varchar(2) DEFAULT NULL COMMENT '机构类型',
  `INS_OPER` varchar(50) DEFAULT NULL COMMENT '机构负责人姓名',
  `INS_ADDRES` varchar(100) DEFAULT NULL COMMENT '机构地址',
  `INS_PHONE` varchar(20) DEFAULT NULL COMMENT '机构联系电话',
  `MARK` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`UUID`),
  KEY `FK_Reference_4` (`PARENT_INS_CD`) USING BTREE,
  CONSTRAINT `t_sys_ins_inf_ibfk_1` FOREIGN KEY (`PARENT_INS_CD`) REFERENCES `t_sys_ins_inf` (`UUID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='机构信息表';

-- ----------------------------
-- Records of t_sys_ins_inf
-- ----------------------------
INSERT INTO `t_sys_ins_inf` VALUES ('1', '01', ',1,', '', '0', '总公司', null, null, null, '0', 'admin', '福州', '13599097196', '备注');
INSERT INTO `t_sys_ins_inf` VALUES ('f17d76ba-b4e4-4256-bfeb-49ef1d6d115e', '0101', ',f17d76ba-b4e4-4256-bfeb-49ef1d6d115e,1,', ',1,', '', '分公司', '1', null, null, '0', '', '', '', '');

-- ----------------------------
-- Table structure for `t_sys_log`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_log`;
CREATE TABLE `t_sys_log` (
  `UUID` varchar(72) NOT NULL,
  `COMPARE_INF` varchar(4000) DEFAULT NULL,
  `OPER_DESC` varchar(4000) DEFAULT NULL,
  `OPER_DT` varchar(28) DEFAULT NULL,
  `OPER_IP` varchar(200) DEFAULT NULL,
  `OPER_METHOD` varchar(120) DEFAULT NULL,
  `OPER_MODULE` varchar(120) DEFAULT NULL,
  `OPER_USR_ID` varchar(60) DEFAULT NULL,
  `RESULT_MSG` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`UUID`),
  UNIQUE KEY `UUID` (`UUID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_log
-- ----------------------------

-- ----------------------------
-- Table structure for `t_sys_menu_inf`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_menu_inf`;
CREATE TABLE `t_sys_menu_inf` (
  `ID` varchar(36) NOT NULL COMMENT 'ID',
  `ICON_CLS` varchar(20) DEFAULT NULL COMMENT 'ICO图标',
  `MENU_SORT` varchar(10) NOT NULL COMMENT '排序',
  `MENU_URL` varchar(200) DEFAULT NULL COMMENT 'URL',
  `TEXT` varchar(100) NOT NULL COMMENT '菜单名称',
  `PRAENT_ID` varchar(36) DEFAULT NULL COMMENT '上一级菜单id',
  PRIMARY KEY (`ID`),
  KEY `FK_Reference_2` (`PRAENT_ID`) USING BTREE,
  CONSTRAINT `t_sys_menu_inf_ibfk_1` FOREIGN KEY (`PRAENT_ID`) REFERENCES `t_sys_menu_inf` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统菜单表';

-- ----------------------------
-- Records of t_sys_menu_inf
-- ----------------------------
INSERT INTO `t_sys_menu_inf` VALUES ('0928b643-2953-4223-96ad-ef796841849f', 'fa-cubes', '001', '', '首页', null);
INSERT INTO `t_sys_menu_inf` VALUES ('0cc33715-9084-4d12-902c-6964fdefc268', 'fa-cubes', '001', '', '业务管理', '0928b643-2953-4223-96ad-ef796841849f');
INSERT INTO `t_sys_menu_inf` VALUES ('24a407ae-3440-492b-a990-8d3b6db6f94e', 'fa-cubes', '013', '', '系统管理', '0928b643-2953-4223-96ad-ef796841849f');
INSERT INTO `t_sys_menu_inf` VALUES ('37d317f7-6417-4ea7-81e1-cf9f499ee273', 'fa-cubes', '006', 'sys/InsInf/InsInfList.jsp', '机构信息', '24a407ae-3440-492b-a990-8d3b6db6f94e');
INSERT INTO `t_sys_menu_inf` VALUES ('3df4bb66-3e06-4f81-a020-7bc98e4bc5ac', 'fa-cubes', '009', 'sys/SysLog/SysLogList.jsp', '日志管理', '24a407ae-3440-492b-a990-8d3b6db6f94e');
INSERT INTO `t_sys_menu_inf` VALUES ('6b0783ec-1a19-40cb-8ee7-15d5bcb0b422', 'fa-cubes', '001', 'sys/MenuInfo/MenuInfoList.jsp', '菜单管理', '24a407ae-3440-492b-a990-8d3b6db6f94e');
INSERT INTO `t_sys_menu_inf` VALUES ('6ea54859-479c-4eac-8bf2-daa6bfca6aa4', 'fa-cubes', '010', 'sys/CodeGenerator/CodeGenerator.jsp', '', '24a407ae-3440-492b-a990-8d3b6db6f94e');
INSERT INTO `t_sys_menu_inf` VALUES ('720f5f7f-f3d8-4881-ba30-d07a29029aac', 'fa-cubes', '004', 'sys/DictTp/DictTpList.jsp', '字典类型', '24a407ae-3440-492b-a990-8d3b6db6f94e');
INSERT INTO `t_sys_menu_inf` VALUES ('724df8a4-db6e-410f-b712-58a57c3fe1d9', 'fa-cubes', '003', 'sys/SysFn/SysFunctionInfList.jsp', '系统功能', '24a407ae-3440-492b-a990-8d3b6db6f94e');
INSERT INTO `t_sys_menu_inf` VALUES ('7420eb7d-fa91-4e3c-b732-425740b583ea', 'fa-cubes', '007', 'sys/NoInterceptor/NoInterceptorList.jsp', 'URL拦截', '24a407ae-3440-492b-a990-8d3b6db6f94e');
INSERT INTO `t_sys_menu_inf` VALUES ('7e566aaf-3eea-4998-8b2b-49f5b204a50c', 'fa-cubes', '001', 'app/TAppTest/TAppTestList.jsp', '测试管理', '0cc33715-9084-4d12-902c-6964fdefc268');
INSERT INTO `t_sys_menu_inf` VALUES ('bf64165c-65ae-49ad-a530-77b9593cf96e', 'fa-cubes', '001', 'app/Student/StudentList.jsp', '学生管理', '0cc33715-9084-4d12-902c-6964fdefc268');
INSERT INTO `t_sys_menu_inf` VALUES ('d307c58f-37c6-498a-aa33-b343e2370290', 'fa-cubes', '008', 'sys/OperInf/OperInfList.jsp', '用户管理', '24a407ae-3440-492b-a990-8d3b6db6f94e');
INSERT INTO `t_sys_menu_inf` VALUES ('ddd9ee7c-0518-4465-a42e-db795159a5b5', 'fa-cubes', '002', 'sys/RoleInf/RoleInfList.jsp', '角色管理', '24a407ae-3440-492b-a990-8d3b6db6f94e');
INSERT INTO `t_sys_menu_inf` VALUES ('e4be5554-96ae-4d5b-ae52-ed8154627796', 'fa-cubes', '012', 'sys/Quarz/QuarzList.jsp', '定时任务', '24a407ae-3440-492b-a990-8d3b6db6f94e');
INSERT INTO `t_sys_menu_inf` VALUES ('ed4794fa-5e27-442e-84c1-11d373ef83b5', 'fa-cubes', '005', 'sys/DictCd/DictCdList.jsp', '数据字典', '24a407ae-3440-492b-a990-8d3b6db6f94e');

-- ----------------------------
-- Table structure for `t_sys_nointerceptor`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_nointerceptor`;
CREATE TABLE `t_sys_nointerceptor` (
  `UUID` varchar(36) NOT NULL COMMENT 'UUID',
  `FUNCTION_URL` varchar(200) NOT NULL COMMENT '不需要拦截的URL',
  `NOTE` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`UUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='不需要拦截的URL配置表';

-- ----------------------------
-- Records of t_sys_nointerceptor
-- ----------------------------
INSERT INTO `t_sys_nointerceptor` VALUES ('50d2551a-4add-4d78-b0c9-b05a284129ce', 'operInf/logout', '用户退出不需要拦截');
INSERT INTO `t_sys_nointerceptor` VALUES ('83385c35-8cb3-4a6a-9eb1-74761fbf5e71', 'operInf/login', '返回到用户登录界面不需要拦截');

-- ----------------------------
-- Table structure for `t_sys_oper_inf`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_oper_inf`;
CREATE TABLE `t_sys_oper_inf` (
  `OPER_CD` varchar(30) NOT NULL COMMENT '用户名',
  `EMAIL` varchar(100) DEFAULT NULL COMMENT 'EMAIL',
  `OPER_NM` varchar(30) NOT NULL COMMENT '用户真实姓名',
  `OPER_PWD` varchar(100) NOT NULL COMMENT '用户密码',
  `OPER_ST` varchar(1) NOT NULL COMMENT '用户状态',
  `REC_CRT_TS` varchar(14) DEFAULT NULL COMMENT '创建时间',
  `REC_UPD_TS` varchar(14) DEFAULT NULL COMMENT '修改时间',
  `TELEPHONE` varchar(12) DEFAULT NULL COMMENT '手机号',
  `INS_CD` varchar(36) DEFAULT NULL COMMENT '所属机构',
  `JOB` varchar(2) NOT NULL COMMENT '岗位',
  PRIMARY KEY (`OPER_CD`),
  KEY `FK_Reference_5` (`INS_CD`) USING BTREE,
  CONSTRAINT `t_sys_oper_inf_ibfk_1` FOREIGN KEY (`INS_CD`) REFERENCES `t_sys_ins_inf` (`UUID`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户表';

-- ----------------------------
-- Records of t_sys_oper_inf
-- ----------------------------
INSERT INTO `t_sys_oper_inf` VALUES ('admin', '123@qq.com', 'admin', 'E00CF25AD42683B3DF678C61F42C6BDA', '0', '20150314221336', '20180926120245', '', '1', '1');
INSERT INTO `t_sys_oper_inf` VALUES ('test', '', 'test', 'CC0E06322B8BB0BA483C8EC0295237E3', '0', '20180919102618', '20180920093345', '', 'f17d76ba-b4e4-4256-bfeb-49ef1d6d115e', '1');

-- ----------------------------
-- Table structure for `t_sys_quarz`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_quarz`;
CREATE TABLE `t_sys_quarz` (
  `NID` varchar(36) NOT NULL COMMENT '主键',
  `JOB_NAME` varchar(50) DEFAULT NULL COMMENT '定时器名称',
  `JOB_GROUP` varchar(50) DEFAULT NULL COMMENT '所属组',
  `CLASS_PATH` varchar(50) DEFAULT NULL COMMENT '类路径',
  `CRON_STR` varchar(50) DEFAULT NULL COMMENT '执行方法名称',
  `STATE` varchar(1) DEFAULT NULL COMMENT '状态',
  `MARK` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`NID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='调度任务表';

-- ----------------------------
-- Records of t_sys_quarz
-- ----------------------------
INSERT INTO `t_sys_quarz` VALUES ('f69e9705-4260-4799-8c77-4d56f58253db', '测试定时器', '1', 'com.gt.quartz.TestQuartz', '0 0/5 * * * ?', '0', '每隔5分运行一次');

-- ----------------------------
-- Table structure for `t_sys_role_function`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role_function`;
CREATE TABLE `t_sys_role_function` (
  `UUID` varchar(36) NOT NULL COMMENT 'UUID',
  `ROLE_CD` varchar(36) NOT NULL COMMENT '角色ID',
  `FUNCTION_CD` varchar(36) NOT NULL COMMENT '功能代码ID',
  PRIMARY KEY (`UUID`),
  KEY `FK_Reference_7` (`FUNCTION_CD`) USING BTREE,
  KEY `FK_Reference_8` (`ROLE_CD`) USING BTREE,
  CONSTRAINT `t_sys_role_function_ibfk_1` FOREIGN KEY (`FUNCTION_CD`) REFERENCES `t_sys_function_inf` (`FUNCTION_CD`) ON DELETE CASCADE,
  CONSTRAINT `t_sys_role_function_ibfk_2` FOREIGN KEY (`ROLE_CD`) REFERENCES `t_sys_role_inf` (`ROLE_CD`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色功能表';

-- ----------------------------
-- Records of t_sys_role_function
-- ----------------------------
INSERT INTO `t_sys_role_function` VALUES ('08305ff8-f90c-491a-9e11-20aff8e40955', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', '096a5b8f-b162-47e5-a23c-2f2cece5cb27');
INSERT INTO `t_sys_role_function` VALUES ('09d86ae7-c8c4-406c-a5f1-4b5dc95dcfaa', '50377ab8-b78b-4a2a-b0b1-cedf658ab945', '17f64087-0737-4681-ba9e-5ef8775c4adb');
INSERT INTO `t_sys_role_function` VALUES ('0e16bcd0-ff2c-47e3-873d-6b7d0623d02a', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', 'e0d38e1f-cdd3-4a0e-b7ea-3c525ac52101');
INSERT INTO `t_sys_role_function` VALUES ('0e418b48-dd2f-4572-bed7-8d77736dcde2', '50377ab8-b78b-4a2a-b0b1-cedf658ab945', '6239127e-9be1-4d74-ab14-f0c0afaecd80');
INSERT INTO `t_sys_role_function` VALUES ('119dcb53-fc69-49c4-a2e4-50e626646f8d', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', '587fc6a6-9836-47fb-ac7b-ebdf80369765');
INSERT INTO `t_sys_role_function` VALUES ('13f7ac11-5210-420a-9b18-282051f34b26', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', '239efc32-4791-47a9-a5ab-129ddf8705dd');
INSERT INTO `t_sys_role_function` VALUES ('1b9c880a-e3c2-49d7-8f8f-ba5e3fbe5a31', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', 'a10b43cf-c9dd-4f4d-8ea3-d2dd472855e7');
INSERT INTO `t_sys_role_function` VALUES ('1c1c497d-2404-4211-88cc-71e7a8e569c8', '50377ab8-b78b-4a2a-b0b1-cedf658ab945', '844e1ce9-7f9e-459d-81cc-978ae39265dc');
INSERT INTO `t_sys_role_function` VALUES ('1ee73e8c-ccf3-48c3-a55f-cd6d7679aca8', '50377ab8-b78b-4a2a-b0b1-cedf658ab945', 'e0d38e1f-cdd3-4a0e-b7ea-3c525ac52101');
INSERT INTO `t_sys_role_function` VALUES ('22702d50-b887-422c-98b5-af932b1b2d47', '50377ab8-b78b-4a2a-b0b1-cedf658ab945', 'c48ad87e-097e-4936-98e2-a1959c277cd0');
INSERT INTO `t_sys_role_function` VALUES ('24ebce9a-6f2b-4fbf-93c7-14c76bdab2c4', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', 'a1c5fc1c-848c-4fda-97b5-675949e07ef1');
INSERT INTO `t_sys_role_function` VALUES ('2771f61a-e949-4bad-8c82-c9fab6b1f11c', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', '0393d871-052f-4913-bc53-503944c48b29');
INSERT INTO `t_sys_role_function` VALUES ('28f64915-1d65-4ea0-93af-303da8d7721d', '50377ab8-b78b-4a2a-b0b1-cedf658ab945', '48df6106-d3d2-4ed3-8cc4-d5716fa8f18f');
INSERT INTO `t_sys_role_function` VALUES ('2ad3e774-21f2-4ac9-9ee0-158154912f0e', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', '1b74c033-fce9-4a25-9d17-d08956925677');
INSERT INTO `t_sys_role_function` VALUES ('2db5192d-9331-4186-a2a4-12d19da97bf2', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', '153dd4f4-ff5c-4759-a002-7115c574a76b');
INSERT INTO `t_sys_role_function` VALUES ('3224fda2-c747-4cf7-86a3-f52dde291a13', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', 'f03fadc4-d5e2-4911-8df7-4dca3bc29a5c');
INSERT INTO `t_sys_role_function` VALUES ('325582d3-7b3a-4a2b-b30a-7a4d87a60c5f', '50377ab8-b78b-4a2a-b0b1-cedf658ab945', '3bbb800f-2097-420e-a00b-08d480ff4996');
INSERT INTO `t_sys_role_function` VALUES ('35b0ee86-bb8c-4d56-ad30-2f1fa12dfb6f', '50377ab8-b78b-4a2a-b0b1-cedf658ab945', '81a09fef-8b00-45dc-b284-142c6e869765');
INSERT INTO `t_sys_role_function` VALUES ('384a0196-b6cf-4608-be5d-57923671fb41', '50377ab8-b78b-4a2a-b0b1-cedf658ab945', '2cdd63c7-3558-42e7-841d-2f563ff69ca8');
INSERT INTO `t_sys_role_function` VALUES ('3c729f06-8aec-4776-bba2-960743f0dc22', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', '6a4a4fac-9887-4423-be16-d0c36cb1d5d3');
INSERT INTO `t_sys_role_function` VALUES ('3ed69cd4-141a-4ec0-97fa-631c10e5bd24', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', '0469f9ec-7c1e-4eca-9181-5e503cce32d4');
INSERT INTO `t_sys_role_function` VALUES ('4022a82c-b427-4dcd-bb2a-43f14d16003b', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', '267df9fc-5e46-4dd0-b434-c92affb54e86');
INSERT INTO `t_sys_role_function` VALUES ('4f47416e-f0d7-472b-94d3-08d3ecf6e1fa', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', '3bbb800f-2097-420e-a00b-08d480ff4996');
INSERT INTO `t_sys_role_function` VALUES ('57c49c9b-ef0f-4283-8621-a64c4de38983', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', 'c06c6158-9664-45ff-afcb-b588bb12a6f0');
INSERT INTO `t_sys_role_function` VALUES ('5b7c4368-05fe-4ba4-b8e8-54891cbc8464', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', '8462f40f-38e7-43ad-9804-bad5bbe513f4');
INSERT INTO `t_sys_role_function` VALUES ('5ee01797-5dc4-4b2a-9f2a-d25481f09943', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', '6239127e-9be1-4d74-ab14-f0c0afaecd80');
INSERT INTO `t_sys_role_function` VALUES ('6421fcaa-65b4-4063-ac9d-89aae64a0717', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', '9dc107be-ac92-42f7-8ba0-5123b8af6e30');
INSERT INTO `t_sys_role_function` VALUES ('72c6c04c-4353-473d-96ce-8795cf749b86', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', 'd8c2edd7-d5d8-4cba-82e1-ba2a3c3cdc80');
INSERT INTO `t_sys_role_function` VALUES ('7901ac62-4ab2-451f-a977-9f9af0001f62', '50377ab8-b78b-4a2a-b0b1-cedf658ab945', 'c5946918-dad5-4088-9cc4-c5eca71f8fdc');
INSERT INTO `t_sys_role_function` VALUES ('79cd2cb5-4463-4df9-abb8-02d8cf8d8c9a', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', '844e1ce9-7f9e-459d-81cc-978ae39265dc');
INSERT INTO `t_sys_role_function` VALUES ('79f1342a-ac83-414a-821d-88b5efef77a9', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', 'c5946918-dad5-4088-9cc4-c5eca71f8fdc');
INSERT INTO `t_sys_role_function` VALUES ('7c8de66d-a96a-41c5-a4e2-178dad4d55da', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', '2ae5e576-22ec-47c3-9816-c6b4d45888ba');
INSERT INTO `t_sys_role_function` VALUES ('81a806e2-3c66-4900-9ee3-cc65967ae52c', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', '3d5d5be3-5080-49ea-a439-86a091e3acc6');
INSERT INTO `t_sys_role_function` VALUES ('82a2f4ee-175b-41f6-8ea5-a45e3e0d8d8e', '50377ab8-b78b-4a2a-b0b1-cedf658ab945', 'f6de33f5-be5b-4e8d-8363-9c157c70d8d0');
INSERT INTO `t_sys_role_function` VALUES ('83746a3b-df8e-4ff0-b996-db119938453f', '50377ab8-b78b-4a2a-b0b1-cedf658ab945', '81361182-d73a-4548-a4f0-0582f42ae999');
INSERT INTO `t_sys_role_function` VALUES ('84a0e079-75c7-466e-b844-768dd2cfb830', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', '073dbafb-a910-429e-9d95-bd1b7f5bef60');
INSERT INTO `t_sys_role_function` VALUES ('a0389f67-9d1d-4253-812b-6b136e3b28e5', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', 'e91b055d-4332-4b36-9a46-8a8ad9079162');
INSERT INTO `t_sys_role_function` VALUES ('a1504591-4b9a-4deb-99d6-3f093746bc1b', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', 'e29d1323-1ea4-4298-9ce8-9df239424023');
INSERT INTO `t_sys_role_function` VALUES ('a5721daa-d533-4b44-aa9b-ec422231907b', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', '1f4b7f46-eb67-4738-ab87-5e82f282f962');
INSERT INTO `t_sys_role_function` VALUES ('a5e5e61e-3fed-44c0-9b2b-7cc83841ec1a', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', '55dce07d-6069-4d7f-85e9-30788ac4e568');
INSERT INTO `t_sys_role_function` VALUES ('a7f195fe-792f-4f09-a7f2-0306b00c53be', '50377ab8-b78b-4a2a-b0b1-cedf658ab945', 'c06c6158-9664-45ff-afcb-b588bb12a6f0');
INSERT INTO `t_sys_role_function` VALUES ('a82fd7d3-584a-4098-bb48-cb53228369ba', '50377ab8-b78b-4a2a-b0b1-cedf658ab945', '1db71f80-e76f-4508-b7d0-c00771ef3ce6');
INSERT INTO `t_sys_role_function` VALUES ('aaabab73-8bb7-4f71-92b6-5c7d14a6d3e2', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', '1db71f80-e76f-4508-b7d0-c00771ef3ce6');
INSERT INTO `t_sys_role_function` VALUES ('aad5f450-dd60-48f3-8161-2d718fdccd3b', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', '37b286ee-d841-4be1-bf15-ac379b64c256');
INSERT INTO `t_sys_role_function` VALUES ('b035e6af-43b8-43c1-89c4-3559208cf56f', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', '81a09fef-8b00-45dc-b284-142c6e869765');
INSERT INTO `t_sys_role_function` VALUES ('b048726b-af88-471f-b4c0-f7ae07b2ff98', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', '69bcfc3e-286c-4ede-9799-2548ea520921');
INSERT INTO `t_sys_role_function` VALUES ('b080dcdb-0d2a-4ed6-afad-4416518d4917', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', 'f1cb6d84-2c10-49d8-ba0e-82f9690df4ec');
INSERT INTO `t_sys_role_function` VALUES ('b16b7e29-badf-4d93-8011-1022d743efe8', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', '81361182-d73a-4548-a4f0-0582f42ae999');
INSERT INTO `t_sys_role_function` VALUES ('bd887cce-941e-484b-943c-7ce41db4a2e1', '50377ab8-b78b-4a2a-b0b1-cedf658ab945', 'f03fadc4-d5e2-4911-8df7-4dca3bc29a5c');
INSERT INTO `t_sys_role_function` VALUES ('be01c9aa-c687-4eca-a90e-2bf90eed38b1', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', '85bb6d0a-d43b-4f15-a437-e2ffd5857ff8');
INSERT INTO `t_sys_role_function` VALUES ('c09a8280-f2da-48d4-b8a4-d9b223cc367e', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', '4d91aafc-366e-471c-855f-e4637c9dfdb8');
INSERT INTO `t_sys_role_function` VALUES ('cd954fac-1d5e-41ca-81a1-027df561b290', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', 'c48ad87e-097e-4936-98e2-a1959c277cd0');
INSERT INTO `t_sys_role_function` VALUES ('d12ceaf4-f746-4735-a038-b9a000619c56', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', '88b64c61-d1f7-4015-b548-9cdda3a9e1fa');
INSERT INTO `t_sys_role_function` VALUES ('d59a9ed3-e29a-4fb5-8f2d-dbfe990df6c2', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', 'c3fe0bbd-b799-47c9-8406-810a04fc6d36');
INSERT INTO `t_sys_role_function` VALUES ('d853621b-f7ae-4700-aca3-55d1ad77e24b', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', '2cdd63c7-3558-42e7-841d-2f563ff69ca8');
INSERT INTO `t_sys_role_function` VALUES ('e491d30f-53b5-4679-826c-c7c53242c35d', '50377ab8-b78b-4a2a-b0b1-cedf658ab945', 'a10b43cf-c9dd-4f4d-8ea3-d2dd472855e7');
INSERT INTO `t_sys_role_function` VALUES ('e50988ca-7373-45d0-9f01-69fde7685699', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', '2a763fe4-e1f1-4cba-9b83-01af20bbf18e');
INSERT INTO `t_sys_role_function` VALUES ('eb396ba9-1a9b-4e4c-b959-f4ed15ff2d7b', '50377ab8-b78b-4a2a-b0b1-cedf658ab945', '096a5b8f-b162-47e5-a23c-2f2cece5cb27');
INSERT INTO `t_sys_role_function` VALUES ('ebada94c-ffde-4e16-9548-738ff9553296', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', '17f64087-0737-4681-ba9e-5ef8775c4adb');
INSERT INTO `t_sys_role_function` VALUES ('ecdd8128-e7f6-4abc-b770-7f3ae87518e0', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', 'dd966007-afad-4afa-bcbd-7c071ed3cb73');
INSERT INTO `t_sys_role_function` VALUES ('edeb04b5-6cb2-4ee6-8efa-e72a2cd6aca2', '50377ab8-b78b-4a2a-b0b1-cedf658ab945', 'f1cb6d84-2c10-49d8-ba0e-82f9690df4ec');
INSERT INTO `t_sys_role_function` VALUES ('f19f6f64-5682-4ba3-8c38-74996873fa6b', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', '48df6106-d3d2-4ed3-8cc4-d5716fa8f18f');
INSERT INTO `t_sys_role_function` VALUES ('f30d0d49-e5c0-4e82-938a-d51f591b5514', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', '7342eac9-5a8d-46a6-9b14-a3567ba41c45');
INSERT INTO `t_sys_role_function` VALUES ('f48cb93f-a92d-44c5-846a-05d253765ad3', '50377ab8-b78b-4a2a-b0b1-cedf658ab945', '1763c122-ad6b-43e4-9500-e7095979f176');
INSERT INTO `t_sys_role_function` VALUES ('f9518ac7-ebfd-4eb2-83c8-6719187689b0', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', 'cff79ae9-f8f0-406d-8a6e-be0099df3df2');
INSERT INTO `t_sys_role_function` VALUES ('fcf303d6-4661-4a01-9c07-4e3aee48c331', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', '1763c122-ad6b-43e4-9500-e7095979f176');
INSERT INTO `t_sys_role_function` VALUES ('fd288f50-223f-4e1a-8129-6d8d5cfbdd12', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', '796a830e-0677-42e3-8f67-1379f90cd6a4');

-- ----------------------------
-- Table structure for `t_sys_role_inf`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role_inf`;
CREATE TABLE `t_sys_role_inf` (
  `ROLE_CD` varchar(36) NOT NULL COMMENT '主键',
  `REMARK` varchar(200) DEFAULT NULL COMMENT '描述',
  `ROLE_NM` varchar(30) NOT NULL COMMENT '角色名称',
  `JUMP_URL` varchar(200) DEFAULT NULL COMMENT '页面跳转',
  `URL_NM` varchar(50) DEFAULT NULL COMMENT '页面名称',
  `WRITE_OPER_CD` varchar(36) DEFAULT NULL COMMENT '录入人',
  PRIMARY KEY (`ROLE_CD`),
  KEY `FK398ACBD5F2B39A73` (`WRITE_OPER_CD`) USING BTREE,
  CONSTRAINT `t_sys_role_inf_ibfk_1` FOREIGN KEY (`WRITE_OPER_CD`) REFERENCES `t_sys_oper_inf` (`OPER_CD`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';

-- ----------------------------
-- Records of t_sys_role_inf
-- ----------------------------
INSERT INTO `t_sys_role_inf` VALUES ('50377ab8-b78b-4a2a-b0b1-cedf658ab945', '', '测试员', null, null, 'admin');
INSERT INTO `t_sys_role_inf` VALUES ('e61ce89f-3e0e-4d33-acb8-16e623d86966', '只能超级管理使用', '超级管理员', null, null, 'admin');

-- ----------------------------
-- Table structure for `t_sys_role_oper`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role_oper`;
CREATE TABLE `t_sys_role_oper` (
  `UUID` varchar(36) NOT NULL COMMENT 'UUID',
  `ROLE_CD` varchar(36) DEFAULT NULL COMMENT '人员编号',
  `OPER_CD` varchar(36) DEFAULT NULL COMMENT '角色编号',
  PRIMARY KEY (`UUID`),
  KEY `FK_Reference_10` (`OPER_CD`) USING BTREE,
  KEY `FK_Reference_9` (`ROLE_CD`) USING BTREE,
  CONSTRAINT `FK15msu9t549ttmjhxwsexoxutu` FOREIGN KEY (`ROLE_CD`) REFERENCES `t_sys_role_inf` (`ROLE_CD`) ON DELETE CASCADE,
  CONSTRAINT `FK322i38oica14sbmsgeptlgej2` FOREIGN KEY (`OPER_CD`) REFERENCES `t_sys_oper_inf` (`OPER_CD`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色人员表';

-- ----------------------------
-- Records of t_sys_role_oper
-- ----------------------------
INSERT INTO `t_sys_role_oper` VALUES ('6b855a35-b9e4-4563-aece-7de4da5d2d36', 'e61ce89f-3e0e-4d33-acb8-16e623d86966', 'admin');
INSERT INTO `t_sys_role_oper` VALUES ('9f7474e9-7045-462d-a924-c0ee2d539f8f', '50377ab8-b78b-4a2a-b0b1-cedf658ab945', 'test');
INSERT INTO `t_sys_role_oper` VALUES ('d1d4f8aa-c22d-4d84-8658-fb67abe067da', '50377ab8-b78b-4a2a-b0b1-cedf658ab945', 'admin');

-- ----------------------------
-- Table structure for `t_sys_timer`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_timer`;
CREATE TABLE `t_sys_timer` (
  `NID` decimal(8,0) NOT NULL COMMENT '主键',
  `TYPE` varchar(1) DEFAULT NULL COMMENT '定时器类型',
  `TIMER_NM` varchar(50) DEFAULT NULL COMMENT '定时器名称',
  `STAR_CLOSED` varchar(1) DEFAULT NULL COMMENT '是否开启',
  `CLASS_PATH` varchar(50) DEFAULT NULL COMMENT '类路径',
  `METHOD_NM` varchar(50) DEFAULT NULL COMMENT '执行方法名称',
  `DELAY` varchar(10) DEFAULT NULL COMMENT '延迟时间',
  `TASK_TIME` varchar(50) DEFAULT NULL COMMENT '执行时间',
  `PERIOD` varchar(10) DEFAULT NULL COMMENT '执行间隔时间',
  `STATE` varchar(1) DEFAULT NULL COMMENT '状态',
  `MARK` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`NID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='定时器表';

-- ----------------------------
-- Records of t_sys_timer
-- ----------------------------
