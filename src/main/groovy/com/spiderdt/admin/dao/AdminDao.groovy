package com.spiderdt.admin.dao

import org.apache.ibatis.annotations.Param
import org.springframework.stereotype.Repository


@Repository
interface AdminDao {

    ArrayList<Object> queryInfo(@Param("table") table)

    ArrayList<Object> queryHistoryInfo()

    ArrayList<Object> querySelector(@Param("selector") selector)

    ArrayList<Object> queryResourcesDefault(
            @Param("project_name") project_name,
            @Param("source_name") source_name, @Param("job_type") job_type, @Param("model_type") model_type)

    ArrayList<Object> queryFeatureDefault(@Param("job_type") job_type)

    ArrayList<Object> queryModelDefault(@Param("model_type") model_type)

    void delete_data(map)

//    插入数据
    void insert_feature_meta(
            @Param("job_type") job_type,
            @Param("default_feature_name") default_feature_name,
            @Param("default_feature_value") default_feature_value,
            @Param("create_time") create_time,
            @Param("modified_time") modified_time,
            @Param("created_by") created_by,
            @Param("modified_by") modified_by,
            @Param("status") status
    )

    void insert_job_configuration(
            @Param("project_name") a,
            @Param("source_name") c,
            @Param("job_type") d,
            @Param("model_type") e,
            @Param("var_name") f,
            @Param("var_value") g,
            @Param("create_time") h,
            @Param("modified_time") i,
            @Param("created_by") j,
            @Param("modified_by") k,
            @Param("status") l
    )

//    void insert_job_history(
//            @Param("job_id") a,
//            @Param("project_name") b,
//            @Param("source_id") c,
//            @Param("source_name") d,
//            @Param("job_type") e,
//            @Param("model_type") f,
//            @Param("var_name") g,
//            @Param("var_value") h,
//            @Param("create_time") i,
//            @Param("modified_time") j,
//            @Param("created_by") k,
//            @Param("modified_by") l,
//            @Param("status") m
//    )

    void insert_project_meta(
            @Param("project_name") a,
            @Param("create_time") b,
            @Param("modified_time") c,
            @Param("created_by") d,
            @Param("modified_by") e,
            @Param("status") f
    )

    void insert_model_meta(
            @Param("model_type") a,
            @Param("default_model_name") b,
            @Param("default_model_value") c,
            @Param("create_time") d,
            @Param("modified_time") e,
            @Param("created_by") f,
            @Param("modified_by") g,
            @Param("status") h
    )

    void insert_resources_meta(
            @Param("resource_type") a,
            @Param("f_driver_memory") b,
            @Param("f_driver_cores") c,
            @Param("f_executor_num") d,
            @Param("f_executor_cores") e,
            @Param("f_executor_memory") k,
            @Param("m_driver_memory") f,
            @Param("m_driver_cores") p,
            @Param("m_executor_num") g,
            @Param("m_executor_cores") h,
            @Param("m_executor_memory") i,
            @Param("create_time") j,
            @Param("modified_time") l,
            @Param("created_by") m,
            @Param("modified_by") n,
            @Param("status") o
    )

    void insert_source_meta(
            @Param("source_name") a,
            @Param("default_model_type") b,
            @Param("default_model_script") c,
            @Param("default_run_model_script") d,
            @Param("default_feature_retries") e,
            @Param("default_job_type") f,
            @Param("default_feature_script") g,
            @Param("default_run_feature_script") h,
            @Param("default_model_retries") i,
            @Param("default_project_name") j,
            @Param("default_resource_type") k,
            @Param("create_time") l,
            @Param("modified_time") m,
            @Param("created_by") n,
            @Param("modified_by") o,
            @Param("status") p
    )

//    更新数据

    void update_feature_meta(
            @Param("id") id,
            @Param("job_type") job_type,
            @Param("default_feature_name") default_feature_name,
            @Param("default_feature_value") default_feature_value,
            @Param("create_time") create_time,
            @Param("modified_time") modified_time,
            @Param("created_by") created_by,
            @Param("modified_by") modified_by,
            @Param("status") status

    )

    void update_job_configuration(
            @Param("id") id,
            @Param("project_name") a,
            @Param("source_name") c,
            @Param("job_type") d,
            @Param("model_type") e,
            @Param("var_name") f,
            @Param("var_value") g,
            @Param("create_time") h,
            @Param("modified_time") i,
            @Param("created_by") j,
            @Param("modified_by") k,
            @Param("status") l
    )

//    void update_job_history(
//            @Param("id") id,
//            @Param("job_id") a,
//            @Param("project_name") b,
//            @Param("source_id") c,
//            @Param("source_name") d,
//            @Param("job_type") e,
//            @Param("model_type") f,
//            @Param("var_name") g,
//            @Param("var_value") h,
//            @Param("create_time") i,
//            @Param("modified_time") j,
//            @Param("created_by") k,
//            @Param("modified_by") l,
//            @Param("status") m
//    )

    void update_project_meta(
            @Param("id") id,
            @Param("project_name") a,
            @Param("create_time") b,
            @Param("modified_time") c,
            @Param("created_by") d,
            @Param("modified_by") e,
            @Param("status") f
    )

    void update_model_meta(
            @Param("id") id,
            @Param("model_type") a,
            @Param("default_model_name") b,
            @Param("default_model_value") c,
            @Param("create_time") d,
            @Param("modified_time") e,
            @Param("created_by") f,
            @Param("modified_by") g,
            @Param("status") h
    )

    void update_resources_meta(
            @Param("id") id,
            @Param("resource_type") a,
            @Param("f_driver_memory") b,
            @Param("f_driver_cores") c,
            @Param("f_executor_num") d,
            @Param("f_executor_cores") e,
            @Param("f_executor_memory") k,
            @Param("m_driver_memory") f,
            @Param("m_driver_cores") p,
            @Param("m_executor_num") g,
            @Param("m_executor_cores") h,
            @Param("m_executor_memory") i,
            @Param("create_time") j,
            @Param("modified_time") l,
            @Param("created_by") m,
            @Param("modified_by") n,
            @Param("status") o
    )

    void update_source_meta(
            @Param("id") id,
            @Param("source_name") a,
            @Param("default_model_type") b,
            @Param("default_model_script") c,
            @Param("default_run_model_script") d,
            @Param("default_feature_retries") e,
            @Param("default_job_type") f,
            @Param("default_feature_script") g,
            @Param("default_run_feature_script") h,
            @Param("default_model_retries") i,
            @Param("default_project_name") j,
            @Param("default_resource_type") k,
            @Param("create_time") l,
            @Param("modified_time") m,
            @Param("created_by") n,
            @Param("modified_by") o,
            @Param("status") p
    )

}
