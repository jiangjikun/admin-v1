package com.spiderdt.admin.controller

import com.spiderdt.admin.service.AdminService
import com.spiderdt.admin.util.Slog
import net.sf.json.JSONObject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import groovy.json.JsonOutput

@Controller
class AdminController {

    @Autowired
    AdminService adminService

    @Autowired
    Slog slog;

    @RequestMapping(value = "/select/{table_name}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> queryInfo(@PathVariable("table_name") String table) {
        def info = null
        if (table.equals("job_history")) {
            info = adminService.queryHistoryInfo()
        } else {
            info = adminService.queryInfo(table)
        }
        ResponseEntity.status(HttpStatus.OK).body(JsonOutput.toJson(info))
    }

    @RequestMapping(value = "/selector/source_meta", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> querySelector() {
        def info = adminService.querySelector()

        ResponseEntity.status(HttpStatus.OK).body(JsonOutput.toJson(info))
    }

    @RequestMapping(value = "/selector/default_value", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> queryDefaultValue(@RequestBody Object map) {
        def json = new JSONObject()
        try {
            def info = adminService.queryDefaultValue(map)
            json.put("status","success")
            json.put("info", info)
        } catch (Exception e) {
            json.put("status","falure")
        }
        ResponseEntity.status(HttpStatus.OK).body(json.toString())
    }


    @RequestMapping(value = "/add_data/{table_name}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> addData(
            @PathVariable("table_name") String table, @RequestBody ArrayList<Object> list) {
        slog.info("--------------Object is -----------" + list)
        switch (table) {
            case "feature_meta": adminService.insert_feature_meta(list); break
            case "job_configuration": adminService.insert_job_configuration(list); break
            case "project_meta": adminService.insert_project_meta(list); break
            case "model_meta": adminService.insert_model_meta(list); break
            case "resources_meta": adminService.insert_resources_meta(list); break
            case "source_meta": adminService.insert_source_meta(list); break
        }

        ResponseEntity.status(HttpStatus.OK).body(JsonOutput.toJson([status: "success"]))
    }

    @RequestMapping(value = "/delete_data/{table_name}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> deleteData(
            @PathVariable("table_name") String table, @RequestBody ArrayList<Object> list) {
        slog.info("--------------Object is -----------" + list)
        adminService.delete_data(table, list)

        ResponseEntity.status(HttpStatus.OK).body(JsonOutput.toJson([status: "success"]))
    }

    @RequestMapping(value = "/update_data/{table_name}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<String> updateData(
            @PathVariable("table_name") String table, @RequestBody ArrayList<Object> list) {
        slog.info("--------------Object is -----------" + list)
        switch (table) {
            case "feature_meta": adminService.update_feature_meta(list); break
            case "job_configuration": adminService.update_job_configuration(list); break
            case "project_meta": adminService.update_project_meta(list); break
            case "model_meta": adminService.update_model_meta(list); break
            case "resources_meta": adminService.update_resources_meta(list); break
            case "source_meta": adminService.update_source_meta(list); break
        }
        ResponseEntity.status(HttpStatus.OK).body(JsonOutput.toJson([status: "success"]))
    }


}
