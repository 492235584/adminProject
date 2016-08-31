package dao;

import model.po.Project;

import java.util.List;

public interface ProjectDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(Integer id);

    Project selectByName(String name);

    List<Project> selectBySearchAble(Project project);

    List<Project> selectAll();

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);
}