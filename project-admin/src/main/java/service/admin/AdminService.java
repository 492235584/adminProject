package service.admin;

import model.dto.ResultMap;
import model.po.Project;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiejiahao on 2016/8/30.
 */
@Service
public interface AdminService {

    /**
     * 保存项目记录
     *
     * @param project 项目
     * @return
     */
    ResultMap save(Project project);

    /**
     * 通过可选择的参数查询
     *
     * @param
     * @return
     */
    List<Project> findBySearchAble(Project project);

    /**
     * 通过id更新
     *
     */
    void updateProjectById(Project project);

    /**
     * 通过id删除
     *
     */
    void deleteProjectById(Integer id);
}
