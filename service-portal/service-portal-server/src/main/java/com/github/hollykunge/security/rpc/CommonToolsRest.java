package com.github.hollykunge.security.rpc;

import com.alibaba.fastjson.JSON;
import com.github.hollykunge.security.common.msg.ObjectRestResponse;
import com.github.hollykunge.security.common.msg.TableResultResponse;
import com.github.hollykunge.security.common.rest.BaseController;
import com.github.hollykunge.security.common.util.Query;
import com.github.hollykunge.security.common.util.UUIDUtils;
import com.github.hollykunge.security.constants.Constants;
import com.github.hollykunge.security.entity.CommonTools;
import com.github.hollykunge.security.entity.User;
import com.github.hollykunge.security.entity.UserCommonTools;
import com.github.hollykunge.security.mapper.UserCommonToolsMapper;
import com.github.hollykunge.security.service.CommonToolsService;
import com.github.hollykunge.security.service.UserCommonToolsService;
import com.github.hollykunge.security.utils.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 对外提供常用工具增删改接口
 * @author zhhongyu
 */
@RestController
@RequestMapping("/api/commonTools")
public class CommonToolsRest{
    @Autowired
    private CommonToolsService commonToolsService;

    @Resource
    private UserCommonToolsService userCommonToolsService;

    @Resource
    private UserCommonToolsMapper userCommonToolsMapper;


    /**
     * fansq 19-12-11
     * 添加常用链接添加接口  更新用户与常用链接关系表
     * @param
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ObjectRestResponse<CommonTools> add(@RequestBody HashMap<String,Object> hashMap) {
        CommonTools tools = JSON.parseObject(JSON.toJSONString(hashMap.get("tools")),CommonTools.class);
        String uuid = UUIDUtils.generateShortUuid();
        tools.setId(uuid);
        if(commonToolsService.selectCount(tools)>0){
            return new ObjectRestResponse<>().rel(false).msg("error,this commonTool is exist");
        };
        commonToolsService.insertSelective(tools);
        if(Constants.PORTALORGUSERSTATUSONE.equals(tools.getPortalOrgUserStatus())){
            List<User> userList = JSON.parseArray(JSON.toJSONString(hashMap.get("user")),User.class);
            List<UserCommonTools> userCommonToolsList = new ArrayList<>();
            for (User user:userList) {
                UserCommonTools userCommonTools = new UserCommonTools();
                userCommonTools .setToolId(uuid);
                userCommonTools.setUserId(user.getId());
                userCommonTools.setId(UUIDUtils.generateShortUuid());
                userCommonToolsList.add(userCommonTools);
            }
                userCommonToolsService.insertCommonTools(userCommonToolsList);
        }
        return new ObjectRestResponse<>().rel(true);
    }

    /**
     * fansq
     * 19-12-12
     * 修改参数类型为map
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public ObjectRestResponse<CommonTools> update(@RequestBody HashMap<String,Object> hashMap) {
        CommonTools tools = JSON.parseObject(JSON.toJSONString(hashMap.get("tools")),CommonTools.class);
        CommonTools commonTools = commonToolsService.selectById(tools.getId());
        commonToolsService.updateSelectiveById(tools);
        if(!commonTools.getPortalOrgUserStatus().equals(tools.getPortalOrgUserStatus())&&
                Constants.PORTALORGUSERSTATUSONE.equals(tools.getPortalOrgUserStatus())){
            List<User> userList = JSON.parseArray(JSON.toJSONString(hashMap.get("user")),User.class);
            List<UserCommonTools> userCommonToolsList = new ArrayList<>();
            for (User user:userList) {
                UserCommonTools userCommonTools = new UserCommonTools();
                userCommonTools .setToolId(tools.getId());
                userCommonTools.setUserId(user.getId());
                userCommonTools.setId(UUIDUtils.generateShortUuid());
                userCommonToolsList.add(userCommonTools);
            }
//            //在插入数据之前先查询数据库中是否存在 指定人员对应的常用链接
//            List<UserCommonTools> userCommonTools = userCommonToolsService.selectUserCommonTools(tools.getId(),userCommonToolsList);
//            if(userCommonTools.size()>0){
//                List<UserCommonTools> cs = userCommonToolsList.stream().filter(uct -> userCommonTools.stream()
//                        .noneMatch(ucts -> uct.getUserId().equals(ucts.getUserId()))
//                ).collect(Collectors.toList());
//                userCommonToolsService.insertCommonTools(cs);
//            }
            userCommonToolsService.deleteCommonTools(tools.getId(),userCommonToolsList);
            userCommonToolsService.insertCommonTools(userCommonToolsList);
        }
        return new ObjectRestResponse<CommonTools>().rel(true);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public ObjectRestResponse<CommonTools> remove(@RequestParam String id) {
        Object deletingObject = commonToolsService.selectById(id);
        commonToolsService.deleteById(id);
        UserCommonTools userCommonTools = new UserCommonTools();
        userCommonTools.setToolId(id);
        userCommonToolsMapper.delete(userCommonTools);
        return new ObjectRestResponse<CommonTools>().rel(true).data(deletingObject);
    }

    @RequestMapping(value = "/page", method = RequestMethod.POST)
    @ResponseBody
    public TableResultResponse<CommonTools> page(@RequestBody Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        return commonToolsService.selectByQuery(query);
    }
}
