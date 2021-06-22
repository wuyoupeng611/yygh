package com.wyp.yygh.cmn.controller;


import com.wyp.yygh.cmn.service.DictService;
import com.wyp.yygh.common.result.Result;
import com.wyp.yygh.model.cmn.Dict;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Api(tags = "数据字典接口")
@RestController
@RequestMapping("/admin/cmn/dict")
//@CrossOrigin
public class DictController {

    @Autowired
    private DictService dictService;

    //根据数据id查询子数据列表
    @ApiOperation(value = "根据数据id查询子数据列表")
    @GetMapping("getChildData/{id}")
    public Result getChildData(@PathVariable Long id) {
        List<Dict> dictList = dictService.getChildData(id);
        return Result.ok(dictList);
    }

    //导出数据字典接口
    @ApiOperation(value = "导出数据字典接口")
    @GetMapping("exportDictData")
    public void exportDictData(HttpServletResponse response) {
        dictService.exportDictData(response);
    }


    //导入数据字典接口
    @ApiOperation(value = "导入数据字典接口")
    @PostMapping("importDictData")
    public Result importDictData(MultipartFile file) {
        dictService.importDictData(file);
        return Result.ok();
    }

    //根据dictcode和value查询（openFeign）
    @ApiOperation(value = "根据dictcode和value查询")
    @GetMapping("getName/{dictCode}/{value}")
    public String getName(@PathVariable String dictCode,
                          @PathVariable String value) {
        String dictName = dictService.getDictName(dictCode,value);
        return dictName;
    }

    //根据value查询（openFeign）
    @ApiOperation(value = "根据value查询")
    @GetMapping("getName/{value}")
    public String getName(@PathVariable String value) {
        return dictService.getDictName("",value);
    }

    //根据dictCode获取下级节点列表
    @ApiOperation(value = "根据dictCode获取下级节点")
    @GetMapping("findByDictCode/{dictCode}")
    public Result getByDictCode(@PathVariable String dictCode) {
        List<Dict> list = dictService.findByDictCode(dictCode);
        return Result.ok(list);
    }
}
