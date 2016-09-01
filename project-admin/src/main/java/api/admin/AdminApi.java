package api.admin;

import api.enmu.CodeEnmu;
import model.dto.ResultMap;
import model.po.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.admin.AdminService;

import java.util.List;

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
     * @apiDescription 不可保存name相同的项目，感叹号为必传参数
     * @apiParam {String} name ！！！项目名
     * @apiParam {String} imagePath 图片路径
     * @apiParam {Integer} type ！！！类型1.android，2.ios，3.weixin，4.web，5.soft
     * @apiParam {Integer} field ！！！领域
     * @apiParam {String} link 项目连接
     * @apiSuccess {String} errorCode 结果码
     * @apiSuccess {String} errorMessage 消息说明
     * @apiSuccess {Object} data 数据
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * {
     *  "code": "0000000",
     *  "msg": "保存成功",
     *  "data": 插入的主键id,
     *  "error": false,
     *  "succ": true
     * }
     * @apiError 0000002 参数不足
     * @apiError 0000003 数据已存在
     * @apiErrorExample {json} Error-Response:
     * HTTP/1.1 200 OK
     * {
     *  "code": "0000002",
     *  "msg": "参数不足",
     *  "error": true,
     *  "succ": false
     * }
     * </pre>
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResultMap save(@RequestBody Project project) {
        if (null == project.getName() || null == project.getType() || null == project.getField()) {
            return ResultMap.errorResult(CodeEnmu.paramLack);
        }
        project.setId(null);//防止传入id
        ResultMap res = adminService.save(project);
        return res;
    }

    /**
     * <pre>
     *
     * @api {post} http://23.105.192.196:8080/project-admin/admin/find 项目查询接口
     * @apiName 项目查询接口
     * @apiGroup ADMIN
     * @apiVersion 0.1.0
     * @apiDescription 可传参数：name/type/field 根据传递的参数查询，如果不传参数则查询所有
     * @apiParam {Integer} id 项目id
     * @apiParam {String} name 项目名
     * @apiParam {Integer} type 类型1.android，2.ios，3.weixin，4.web，5.soft
     * @apiParam {Integer} field 领域
     * @apiSuccess {String} errorCode 结果码
     * @apiSuccess {String} errorMessage 消息说明
     * @apiSuccess {Object} data 数据
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * {
     *  "code": "0000000",
     *  "msg": "保存成功",
     *  "data":[
     *      {
     *          id:主键id
     *          name:项目名
     *          imagePath:图片路径
     *          type:类型1.android，2.ios，3.weixin，4.web，5.soft
     *          field:领域
     *          link:项目链接
     *      }
     *  ]
     *  "error": false,
     *  "succ": true
     * }
     * @apiError 0000002 参数不足
     * @apiError 0000003 数据已存在
     * @apiErrorExample {json} Error-Response:
     * HTTP/1.1 200 OK
     * {
     *  "code": "0000002",
     *  "msg": "参数不足",
     *  "error": true,
     *  "succ": false
     * }
     * </pre>
     */
    @ResponseBody
    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public ResultMap find(@RequestBody Project project) {
        List<Project> res = adminService.findBySearchAble(project);
        return ResultMap.succResult("查询成功", res);
    }

    /**
     * <pre>
     *
     * @api {post} http://23.105.192.196:8080/project-admin/admin/update 项目更新z
     * @apiName 项目更新z
     * @apiGroup ADMIN
     * @apiVersion 0.1.0
     * @apiDescription 必传参数:id,可传参数：imagePath/name/type/field.根据id更新传入的字段。
     * @apiParam {String} id ！！！项目id
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
     *  "code": "000000",
     *  "msg": "更新成功",
     *  "error": false,
     *  "succ": true
     * }
     * @apiError 0000002 参数不足
     * @apiError 0000003 数据已存在
     * @apiErrorExample {json} Error-Response:
     * HTTP/1.1 200 OK
     * {
     *  "code": "0000002",
     *  "msg": "参数不足",
     *  "error": true,
     *  "succ": false
     * }
     * </pre>
     */
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResultMap updateById(@RequestBody Project project) {
        if (null == project.getId()) {
            return ResultMap.errorResult(CodeEnmu.paramLack);
        }
        adminService.updateProjectById(project);
        return ResultMap.succResult("更新成功", null);
    }

    /**
     * <pre>
     *
     * @api {post} http://23.105.192.196:8080/project-admin/admin/delete 项目删除x
     * @apiName 项目删除x
     * @apiGroup ADMIN
     * @apiVersion 0.1.0
     * @apiDescription 必传参数:id
     * @apiParam {String} id ！！！项目id
     * @apiSuccess {String} errorCode 结果码
     * @apiSuccess {String} errorMessage 消息说明
     * @apiSuccess {Object} data 数据
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * {
     *  "code": "000000",
     *  "msg": "删除成功",
     *  "error": false,
     *  "succ": true
     * }
     * @apiError 0000002 参数不足
     * @apiError 0000003 数据已存在
     * @apiErrorExample {json} Error-Response:
     * HTTP/1.1 200 OK
     * {
     *  "code": "0000002",
     *  "msg": "参数不足",
     *  "error": true,
     *  "succ": false
     * }
     * </pre>
     */
    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResultMap deleteById(@RequestBody Project project) {
        if (null == project.getId() || 0 == project.getId()) {
            return ResultMap.errorResult(CodeEnmu.paramLack);
        }
        adminService.deleteProjectById(project.getId());
        return ResultMap.succResult("删除成功", null);
    }
}
