package xin.cuichaojiang.tubercle.system.user.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import xin.cuichaojiang.tubercle.system.user.model.SysUser;
import xin.cuichaojiang.tubercle.system.user.model.SysUserExample;

public interface SysUserMapper {
    long countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    List<SysUser> selectByExample(SysUserExample example);

    SysUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
}