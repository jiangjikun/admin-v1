package com.spiderdt.admin.service

import com.spiderdt.admin.dao.AdminDao
import com.spiderdt.admin.util.Slog
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Created by kun on 2017/4/6.
 */
@Service
class AdminService {
    @Autowired
    AdminDao adminDao

    @Autowired
    Slog slog;

//    查询表信息
    def queryInfo(table) {
        adminDao.queryInfo(table)
    }

    def queryHistoryInfo() {
        adminDao.queryHistoryInfo()
    }

    def querySelector() {
        def selectorList = ['default_project_name', 'source_name', 'default_job_type', 'default_model_type']
        selectorList.collect {
            adminDao.querySelector(it)
        }
    }

    def queryDefaultValue(map) {
        def resources_info = adminDao.queryResourcesDefault(map.default_project_name, map.source_name, map.default_job_type, map.default_model_type)[0]
        def keySet = resources_info.keySet()
        def default_value = keySet.collect {
            def info = new ArrayList()
            info.add(it)
            info.add(resources_info.get(it))
            info
        }
        def feature_info = adminDao.queryFeatureDefault(map.default_job_type).collect {
            def info = new ArrayList()
            info.add(it.default_feature_name)
            info.add(it.default_feature_value)
            info
        }
        def model_info = adminDao.queryModelDefault(map.default_model_type).collect {
            def info = new ArrayList()
            info.add(it.default_model_name)
            info.add(it.default_model_value)
            info
        }
        default_value = default_value + feature_info + model_info
        slog.info "----------总个数为" + default_value.size()
        default_value

    }

//    删除数据
    void delete_data(table, list) {
        def map = [table: table,
                   list : list]
        adminDao.delete_data(map)
    }

//    添加数据
//    多条插入
    @Transactional
    void insert_feature_meta(list) {
        list.collect {
            adminDao.insert_feature_meta(it.job_type, it.default_feature_name, it.default_feature_value, it.create_time, it.modified_time, it.created_by, it.modified_by, "1")
        }
    }

//    多条插入
    @Transactional
    void insert_job_configuration(list) {
        list.collect {
            adminDao.insert_job_configuration(it.project_name, it.source_name, it.job_type, it.model_type, it.var_name, it.var_value, it.create_time, it.modified_time, it.created_by, it.modified_by, "1")
        }
    }

//    多条插入
    @Transactional
    void insert_model_meta(list) {
        list.collect {
            adminDao.insert_model_meta(it.model_type, it.default_model_name, it.default_model_value, it.create_time, it.modified_time, it.created_by, it.modified_by, "1")
        }
    }

//    单条插入
    @Transactional
    void insert_resources_meta(list) {
        list.collect {
            adminDao.insert_resources_meta(it.resource_type, it.f_driver_memory, it.f_driver_cores, it.f_executor_num, it.f_executor_cores, it.f_executor_memory, it.m_driver_memory, it.m_driver_cores,
                    it.m_executor_num, it.m_executor_cores, it.m_executor_memory, it.create_time, it.modified_time, it.created_by, it.modified_by, "1")
        }
    }

//    单条插入
    @Transactional
    void insert_source_meta(list) {
        list.collect {
            adminDao.insert_source_meta(it.source_name, it.default_model_type, it.default_model_script, it.default_run_model_script, it.default_feature_retries, it.default_job_type, it.default_feature_script,
                    it.default_run_feature_script, it.default_model_retries, it.default_project_name, it.default_resource_type, it.create_time, it.modified_time, it.created_by, it.modified_by, "1")
        }
    }

//    单条插入
    @Transactional
    void insert_project_meta(list) {
        list.collect {
            adminDao.insert_project_meta(it.project_name, it.create_time, it.modified_time, it.created_by, it.modified_by, "1")
        }
    }

//    更新数据
//    多条更新
    @Transactional
    void update_feature_meta(list) {
        list.collect {
            adminDao.update_feature_meta(it.id, it.job_type, it.default_feature_name, it.default_feature_value, it.create_time, it.modified_time, it.created_by, it.modified_by, "1")
        }
    }

//    多条更新
    @Transactional
    void update_job_configuration(list) {
        list.collect {
            adminDao.update_job_configuration(it.id, it.project_name, it.source_name, it.job_type, it.model_type, it.var_name, it.var_value, it.create_time, it.modified_time, it.created_by, it.modified_by, "1")
        }
    }

//    多条更新
    @Transactional
    void update_model_meta(list) {
        list.collect {
            adminDao.update_model_meta(it.id, it.model_type, it.default_model_name, it.default_model_value, it.create_time, it.modified_time, it.created_by, it.modified_by, "1")
        }
    }

//    单条更新
    @Transactional
    void update_resources_meta(list) {
        list.collect {
            adminDao.update_resources_meta(it.id, it.resource_type, it.f_driver_memory, it.f_driver_cores, it.f_executor_num, it.f_executor_cores, it.f_executor_memory, it.m_driver_memory, it.m_driver_cores,
                    it.m_executor_num, it.m_executor_cores, it.m_executor_memory, it.create_time, it.modified_time, it.created_by, it.modified_by, "1")
        }
    }

//    单条更新
    @Transactional
    void update_source_meta(list) {
        list.collect {
            adminDao.update_source_meta(it.id, it.source_name, it.default_model_type, it.default_model_script, it.default_run_model_script, it.default_feature_retries, it.default_job_type, it.default_feature_script,
                    it.default_run_feature_script, it.default_model_retries, it.default_project_name, it.default_resource_type, it.create_time, it.modified_time, it.created_by, it.modified_by, "1")
        }
    }

//    单条更新
    @Transactional
    void update_project_meta(list) {
        list.collect {
            adminDao.update_project_meta(it.id, it.project_name, it.create_time, it.modified_time, it.created_by, it.modified_by, "1")
        }
    }


}
