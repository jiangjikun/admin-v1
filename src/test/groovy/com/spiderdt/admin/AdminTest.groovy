package com.spiderdt.admin

import com.spiderdt.admin.service.AdminService

/**
*  Created by kun on 2017/6/19.
*/
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring/applicationContext.xml")
@WebAppConfiguration
class AdminTest extends GroovyTestCase {
    @Autowired
    AdminService adminService

    @Test
    void queryInfo() {
        def table = "job_configuration"

         adminService.queryInfo(table).collect{
             println it.var_value
             println it.var_value.class
         }
    }

    @Test
    void queryHistoryInfo() {
        println adminService.queryHistoryInfo()
    }

    @Test
    void querySelector() {
        println adminService.querySelector()
    }

    @Test
    void queryDefaultValue() {
        def map = [default_project_name: "jupiter",
                   source_name         : "tutuanna",
                   default_job_type    : "ranking",
                   default_model_type  : "RandomForest"]
        println adminService.queryDefaultValue(map)
    }


    @Test
    void delete_data() {
        def table = "resources_meta"
        ArrayList ids = ['12']
        adminService.delete_data(table, ids)
    }

    @Test
    void insert_resources_meta() {
        def map = [resource_type    : "size_500k",
                   f_driver_memory  : "1G",
                   f_driver_cores   : "1",
                   f_executor_num   : "39",
                   f_executor_cores : "1",
                   f_executor_memory: "1G",
                   m_driver_memory  : "1G",
                   m_driver_cores   : "1G",
                   m_executor_num   : "4",
                   m_executor_cores : "4",
                   m_executor_memory: "8G",
                   create_time      : "2016-06-19",
                   modified_time    : "2016-06-19",
                   created_by       : "Jason",
                   modified_by      : "Jason",
                   status           : "1"]
        def a = new ArrayList()
        a.add(map)
        for (int i = 0; i < 50; i++) {
            adminService.insert_resources_meta(a)
        }
    }

    @Test
    void update_resources_meta() {
        def map = [
                id               : 2,
                resource_type    : "size_10m",
                f_driver_memory  : "1G",
                f_driver_cores   : "1",
                f_executor_num   : "39",
                f_executor_cores : "1",
                f_executor_memory: "1G",
                m_driver_memory  : "1G",
                m_driver_cores   : "1G",
                m_executor_num   : "4",
                m_executor_cores : "4",
                m_executor_memory: "8G",
                create_time      : "2016-06-19",
                modified_time    : "2016-06-19",
                created_by       : "Jason",
                modified_by      : "Jason"]
        def a = new ArrayList()
        a.add(map)
        adminService.update_resources_meta(a)
    }


}
