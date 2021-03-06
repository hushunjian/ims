package com.me2me.content.mapper;

import com.me2me.content.model.ArticleTagsDetails;
import com.me2me.content.model.ArticleTagsDetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleTagsDetailsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article_tags_details
     *
     * @mbggenerated Wed Jun 15 17:28:59 CST 2016
     */
    int countByExample(ArticleTagsDetailsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article_tags_details
     *
     * @mbggenerated Wed Jun 15 17:28:59 CST 2016
     */
    int deleteByExample(ArticleTagsDetailsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article_tags_details
     *
     * @mbggenerated Wed Jun 15 17:28:59 CST 2016
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article_tags_details
     *
     * @mbggenerated Wed Jun 15 17:28:59 CST 2016
     */
    int insert(ArticleTagsDetails record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article_tags_details
     *
     * @mbggenerated Wed Jun 15 17:28:59 CST 2016
     */
    int insertSelective(ArticleTagsDetails record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article_tags_details
     *
     * @mbggenerated Wed Jun 15 17:28:59 CST 2016
     */
    List<ArticleTagsDetails> selectByExample(ArticleTagsDetailsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article_tags_details
     *
     * @mbggenerated Wed Jun 15 17:28:59 CST 2016
     */
    ArticleTagsDetails selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article_tags_details
     *
     * @mbggenerated Wed Jun 15 17:28:59 CST 2016
     */
    int updateByExampleSelective(@Param("record") ArticleTagsDetails record, @Param("example") ArticleTagsDetailsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article_tags_details
     *
     * @mbggenerated Wed Jun 15 17:28:59 CST 2016
     */
    int updateByExample(@Param("record") ArticleTagsDetails record, @Param("example") ArticleTagsDetailsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article_tags_details
     *
     * @mbggenerated Wed Jun 15 17:28:59 CST 2016
     */
    int updateByPrimaryKeySelective(ArticleTagsDetails record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article_tags_details
     *
     * @mbggenerated Wed Jun 15 17:28:59 CST 2016
     */
    int updateByPrimaryKey(ArticleTagsDetails record);


}