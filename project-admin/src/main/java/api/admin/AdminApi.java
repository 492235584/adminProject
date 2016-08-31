package api.admin;

import api.enmu.CodeEnmu;
import model.dto.ResultMap;
import model.po.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.admin.AdminService;

/**
 * Created by xiejiahao on 2016/8/30.
 */
@Controller
@RequestMapping("/admin")
public class AdminApi {

    @Autowired
    private AdminService adminService;

    /**
     * <pre>
     *
     * @api {post} http://23.105.192.196:8080/project-admin/admin/save 项目保存
     * @apiName 项目保存
     * @apiGroup ADMIN
     * @apiVersion 0.1.0
     * @apiDescription 详细描述
     * @apiParam {String} name 项目名
     * @apiParam {String} imagePath 图片路径
     * @apiParam {Integer} type 类型1.android，2.ios，3.weixin，4.web，5.soft
     * @apiParam {Integer} field 领域
     * @apiParam {String} link 项目连接
     * @apiSuccess {String} errorCode 结果码
     * @apiSuccess {String} errorMessage 消息说明
     * @apiSuccess {Object} data 数据
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * {
     * errorCode:0000000,
     * errorMessage:“保存成功”
     * data:主键id
     * }
     * @apiError 0000002 参数不足
     * @apiError 0000003 数据已存在
     * @apiErrorExample {json} Error-Response:
     * HTTP/1.1 200 OK
     * {
     * errorCode:0000002,
     * errorMessage:“参数不足”
     * data:{
     * <p>
     * }
     * }
     * </pre>
     */
    @ResponseBody
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ResultMap save(@RequestBody Project project) {
        if (null == project.getName() || null == project.getType() || null == project.getField()) {
            return ResultMap.errorResult(CodeEnmu.paramLack);
        }
        ResultMap res = adminService.save(project);
        return res;
    }
}
