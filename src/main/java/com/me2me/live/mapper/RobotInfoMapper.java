package com.me2me.live.mapper;

import com.me2me.live.model.RobotInfo;
import com.me2me.live.model.RobotInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RobotInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table robot_info
     *
     * @mbggenerated Mon Jul 31 17:54:25 CST 2017
     */
    int countByExample(RobotInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table robot_info
     *
     * @mbggenerated Mon Jul 31 17:54:25 CST 2017
     */
    int deleteByExample(RobotInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table robot_info
     *
     * @mbggenerated Mon Jul 31 17:54:25 CST 2017
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table robot_info
     *
     * @mbggenerated Mon Jul 31 17:54:25 CST 2017
     */
    int insert(RobotInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table robot_info
     *
     * @mbggenerated Mon Jul 31 17:54:25 CST 2017
     */
    int insertSelective(RobotInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table robot_info
     *
     * @mbggenerated Mon Jul 31 17:54:25 CST 2017
     */
    List<RobotInfo> selectByExample(RobotInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table robot_info
     *
     * @mbggenerated Mon Jul 31 17:54:25 CST 2017
     */
    RobotInfo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table robot_info
     *
     * @mbggenerated Mon Jul 31 17:54:25 CST 2017
     */
    int updateByExampleSelective(@Param("record") RobotInfo record, @Param("example") RobotInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table robot_info
     *
     * @mbggenerated Mon Jul 31 17:54:25 CST 2017
     */
    int updateByExample(@Param("record") RobotInfo record, @Param("example") RobotInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table robot_info
     *
     * @mbggenerated Mon Jul 31 17:54:25 CST 2017
     */
    int updateByPrimaryKeySelective(RobotInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table robot_info
     *
     * @mbggenerated Mon Jul 31 17:54:25 CST 2017
     */
    int updateByPrimaryKey(RobotInfo record);
    
    RobotInfo getRandomRobotInfo();
}