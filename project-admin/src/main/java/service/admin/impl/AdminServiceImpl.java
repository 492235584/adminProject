package service.admin.impl;

import api.enmu.CodeEnmu;
import dao.ProjectDao;
import model.dto.ResultMap;
import model.po.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.admin.AdminService;

import java.util.List;

/**
 * Created by xiejiahao on 2016/8/30.
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private ProjectDao projectDao;

    public ResultMap save(Project project) {
        Project projectDb = projectDao.selectByName(project.getName());
        if (null != projectDb) {
            return ResultMap.errorResult(CodeEnmu.dataExist);
        }
        projectDao.insertSelective(project);
        return ResultMap.succResult("保存成功", project.getId());
    }

    public List<Project> findBySearchAble(Project project) {
        List<Project> listData = projectDao.selectBySearchAble(project);
        if (0 == listData.size()) {
            return null;
        }
        return listData;
    }

    public void updateProjectById(Project project) {
        projectDao.updateByPrimaryKeySelective(project);
    }

    public void deleteProjectById(Integer id) {
        projectDao.deleteByPrimaryKey(id);
    }
}
