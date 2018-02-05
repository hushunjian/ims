package com.me2me.user.mapper;

import com.me2me.user.model.EntryPageConfig;
import com.me2me.user.model.EntryPageConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EntryPageConfigMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table entry_page_config
     *
     * @mbggenerated Tue Nov 08 09:26:53 CST 2016
     */
    int countByExample(EntryPageConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table entry_page_config
     *
     * @mbggenerated Tue Nov 08 09:26:53 CST 2016
     */
    int deleteByExample(EntryPageConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table entry_page_config
     *
     * @mbggenerated Tue Nov 08 09:26:53 CST 2016
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table entry_page_config
     *
     * @mbggenerated Tue Nov 08 09:26:53 CST 2016
     */
    int insert(EntryPageConfig record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table entry_page_config
     *
     * @mbggenerated Tue Nov 08 09:26:53 CST 2016
     */
    int insertSelective(EntryPageConfig record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table entry_page_config
     *
     * @mbggenerated Tue Nov 08 09:26:53 CST 2016
     */
    List<EntryPageConfig> selectByExample(EntryPageConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table entry_page_config
     *
     * @mbggenerated Tue Nov 08 09:26:53 CST 2016
     */
    EntryPageConfig selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table entry_page_config
     *
     * @mbggenerated Tue Nov 08 09:26:53 CST 2016
     */
    int updateByExampleSelective(@Param("record") EntryPageConfig record, @Param("example") EntryPageConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table entry_page_config
     *
     * @mbggenerated Tue Nov 08 09:26:53 CST 2016
     */
    int updateByExample(@Param("record") EntryPageConfig record, @Param("example") EntryPageConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table entry_page_config
     *
     * @mbggenerated Tue Nov 08 09:26:53 CST 2016
     */
    int updateByPrimaryKeySelective(EntryPageConfig record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table entry_page_config
     *
     * @mbggenerated Tue Nov 08 09:26:53 CST 2016
     */
    int updateByPrimaryKey(EntryPageConfig record);
}