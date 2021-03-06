package com.me2me.search.mapper;

import com.me2me.search.model.SearchUserDislike;
import com.me2me.search.model.SearchUserDislikeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SearchUserDislikeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table search_user_dislike
     *
     * @mbggenerated Sun Apr 23 16:38:25 CST 2017
     */
    int countByExample(SearchUserDislikeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table search_user_dislike
     *
     * @mbggenerated Sun Apr 23 16:38:25 CST 2017
     */
    int deleteByExample(SearchUserDislikeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table search_user_dislike
     *
     * @mbggenerated Sun Apr 23 16:38:25 CST 2017
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table search_user_dislike
     *
     * @mbggenerated Sun Apr 23 16:38:25 CST 2017
     */
    int insert(SearchUserDislike record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table search_user_dislike
     *
     * @mbggenerated Sun Apr 23 16:38:25 CST 2017
     */
    int insertSelective(SearchUserDislike record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table search_user_dislike
     *
     * @mbggenerated Sun Apr 23 16:38:25 CST 2017
     */
    List<SearchUserDislike> selectByExample(SearchUserDislikeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table search_user_dislike
     *
     * @mbggenerated Sun Apr 23 16:38:25 CST 2017
     */
    SearchUserDislike selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table search_user_dislike
     *
     * @mbggenerated Sun Apr 23 16:38:25 CST 2017
     */
    int updateByExampleSelective(@Param("record") SearchUserDislike record, @Param("example") SearchUserDislikeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table search_user_dislike
     *
     * @mbggenerated Sun Apr 23 16:38:25 CST 2017
     */
    int updateByExample(@Param("record") SearchUserDislike record, @Param("example") SearchUserDislikeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table search_user_dislike
     *
     * @mbggenerated Sun Apr 23 16:38:25 CST 2017
     */
    int updateByPrimaryKeySelective(SearchUserDislike record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table search_user_dislike
     *
     * @mbggenerated Sun Apr 23 16:38:25 CST 2017
     */
    int updateByPrimaryKey(SearchUserDislike record);
}