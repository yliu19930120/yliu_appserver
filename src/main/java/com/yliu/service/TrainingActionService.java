package com.yliu.service;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.yliu.bean.PageResult;
import com.yliu.bean.TrainingAction;
import com.yliu.controller.ActionController;
import com.yliu.dao.TrainingActionDao;
import com.yliu.enums.ActionType;
import com.yliu.vo.ActionVo;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TrainingActionService extends BaseService<TrainingAction,String,ActionVo,TrainingActionDao>{

    private final static Logger log = LoggerFactory.getLogger(TrainingActionService.class);

    private static final Map<String,String> ACTIONS_ALIAS = new HashMap<>();
    static {
        ACTIONS_ALIAS.put("动作名字","actionName");
        ACTIONS_ALIAS.put("一级动作分类","typeL1");
        ACTIONS_ALIAS.put("二级动作分类","typeL2");
        ACTIONS_ALIAS.put("重量","weight");
        ACTIONS_ALIAS.put("次数","nums");
        ACTIONS_ALIAS.put("组间休息","groupsTimes");
        ACTIONS_ALIAS.put("是否为单边","unilateral");
        ACTIONS_ALIAS.put("训练日期","traningDate");
        ACTIONS_ALIAS.put("速度","speed");
        ACTIONS_ALIAS.put("持续时长","times");
    }
    public void exporTemplate(HttpServletResponse response) throws IOException {

            String fileName = "动作模板.xlsx";
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.setHeader("Connection","close");
            response.setHeader("Content-Disposition", "attachment;fileName=\"" +   URLEncoder.encode(fileName,"UTF-8")+"\"");

            List<String> headers = ACTIONS_ALIAS.keySet().stream().sorted().collect(Collectors.toList());
            ExcelWriter excelWriter = ExcelUtil.getWriter();
            excelWriter.writeHeadRow(headers);
            OutputStream outputStream = response.getOutputStream();
            excelWriter.flush(outputStream);
    }


    public void importActions(MultipartFile file,String userId) throws IOException {
        InputStream inputStream = file.getInputStream();
        ExcelReader excelReader = ExcelUtil.getReader(inputStream);
        excelReader.setHeaderAlias(ACTIONS_ALIAS);
        List<ActionVo> actionVos = excelReader.readAll(ActionVo.class);
        actionVos.forEach(t->{
            t.setUserId(userId);
            if(StringUtils.isBlank(t.getUnilateral())){
                t.setUnilateral("0");
            }else if("是".equals(t.getUnilateral())){
                t.setUnilateral("1");
            }else {
                t.setUnilateral("0");
            }
        });
        save(actionVos);
        excelReader.close();
    }
}
