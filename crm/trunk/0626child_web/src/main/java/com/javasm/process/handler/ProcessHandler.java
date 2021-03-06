package com.javasm.process.handler;

import com.javasm.entity.ResponseBean;
import com.javasm.entity.TableResponseBean;
import com.javasm.process.entity.ProcessInfo;
import com.javasm.process.service.ProcessService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class ProcessHandler {
   /* @Autowired
    ProcessService processService;

    @Autowired
    @Qualifier(value = "processEngine")
    ProcessEngineFactoryBean factory;
    @Autowired
    RepositoryService repositoryService;

    @GetMapping("/process/queryAll")
    @ResponseBody
    public TableResponseBean queryProcess() {
        TableResponseBean tableResponseBean = new TableResponseBean();
        try {
            ProcessEngine engine = factory.getObject();
           // System.out.println(engine);


            List<ProcessInfo> list = processService.queryAll();
            tableResponseBean.setMs("查询成功");
            tableResponseBean.setStatus(200);
            tableResponseBean.setTotal(list.size());
            tableResponseBean.setRows(list);
        } catch (Exception e) {
            e.printStackTrace();
            tableResponseBean.setStatus(500);

        }
        return tableResponseBean;
    }

    //上传流程文件
    @PostMapping("/process/upload")
    @ResponseBody
    public ResponseBean upload(HttpServletRequest request,String  plevel,String  prole,String pname) {
        ResponseBean responseBean = new ResponseBean();
        System.out.println("=============="+plevel);
        System.out.println("================="+prole);
        System.out.println("============="+pname);
        System.out.println("进入流程");
        try {
            MultipartHttpServletRequest mrequest = (MultipartHttpServletRequest) request;
            MultipartFile file = mrequest.getFile("procDefFile");

            //部署
            Deployment deploy = repositoryService.createDeployment().addInputStream(file.getOriginalFilename(), file.getInputStream()).deploy();
            ProcessDefinition pd = repositoryService.createProcessDefinitionQuery().deploymentId(deploy.getId()).singleResult();
           //插入记录

            ProcessInfo processInfo=new ProcessInfo();
            processInfo.setPid(pd.getId());
            processInfo.setDeploymentid(deploy.getId());
            processInfo.setPcreatedate(LocalDateTime.now().toString());
            processInfo.setPlevel(Integer.valueOf(plevel));
            processInfo.setProle(prole);
            processInfo.setPstatus(1);
           // processInfo.setPname(pd.getName());
            processInfo.setPname(pname);
            processService.insert(processInfo);


            responseBean.setMs("上传成功");
            responseBean.setStatus(200);


        } catch (Exception e) {
            responseBean.setStatus(500);
            responseBean.setMs("请上传xxx.bpmn文件..");
            e.printStackTrace();
        }
        return responseBean;
    }

    //查看流程定义图
    @GetMapping("/process/showProcFile")

    public void lookProd(String deploymentid, HttpServletRequest request, HttpServletResponse response) {
        try {
            ProcessDefinition pd = repositoryService.createProcessDefinitionQuery().deploymentId(deploymentid).singleResult();

            if (pd==null){
                return;
            }

            System.out.println(pd);
            InputStream in = repositoryService.getResourceAsStream(pd.getDeploymentId(), pd.getDiagramResourceName());


            ServletOutputStream out = response.getOutputStream();
            //将流程定义图片输出给客户端
            int i = -1;
            while ((i = in.read()) != -1) {
                out.write(i);
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }*/


}