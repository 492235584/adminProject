package api.photo;

import api.enmu.CodeEnmu;
import model.dto.ResultMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.UUID;

/**
 * Created by xiejiahao on 2016/9/4.
 */
@Controller("photo")
public class PhotoApi {

    @Value("#{configProperties['project.iamge.path']}")
    private String webPath;

    /**
     * <pre>
     *
     * @api {post} http://23.105.192.196:8080/project-admin/photo/upload 文件上传
     * @apiName 文件上传
     * @apiGroup UPLOAD
     * @apiVersion 0.1.0
     * @apiDescription 文件上传接口，传递multipart/*类型
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
     * @apiError 0000010 文件io错误
     * @apiError 0000003 数据已存在
     * @apiErrorExample {json} Error-Response:
     * HTTP/1.1 200 OK
     * {
     *  "code": "0000010",
     *  "msg": "文件io错误",
     *  "error": true,
     *  "succ": false
     * }
     * </pre>
     */
    @RequestMapping("/upload")
    @ResponseBody
    public ResultMap upload(HttpServletRequest request, HttpServletResponse response) {
        //创建一个通用的多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        //判断 request 是否有文件上传,即多部分请求
        if (multipartResolver.isMultipart(request)) {
            //转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            //取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                //取得上传文件
                MultipartFile file = multiRequest.getFile(iter.next());
                if (file != null) {
                    //取得当前上传文件的文件名称
                    String fileName = file.getOriginalFilename();
                    //如果名称不为“”,说明该文件存在，否则说明该文件不存在
                    if (fileName.trim() != "") {
                        //重命名上传后的文件名
                        String uuidFileName = UUID.randomUUID().toString();
                        //定义上传路径
                        String path = webPath + uuidFileName;
                        File localFile = new File(path);
                        try {
                            file.transferTo(localFile);
                        } catch (IOException e) {
                            return ResultMap.errorResult(CodeEnmu.file_io_error);
                        }
                    }
                }
            }

        }
        return ResultMap.succResult("上传成功","0000000");
    }
}
