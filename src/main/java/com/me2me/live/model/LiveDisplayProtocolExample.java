package com.me2me.live.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LiveDisplayProtocolExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table live_display_protocol
     *
     * @mbggenerated Mon Sep 26 16:32:06 CST 2016
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table live_display_protocol
     *
     * @mbggenerated Mon Sep 26 16:32:06 CST 2016
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table live_display_protocol
     *
     * @mbggenerated Mon Sep 26 16:32:06 CST 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table live_display_protocol
     *
     * @mbggenerated Mon Sep 26 16:32:06 CST 2016
     */
    public LiveDisplayProtocolExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table live_display_protocol
     *
     * @mbggenerated Mon Sep 26 16:32:06 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table live_display_protocol
     *
     * @mbggenerated Mon Sep 26 16:32:06 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table live_display_protocol
     *
     * @mbggenerated Mon Sep 26 16:32:06 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table live_display_protocol
     *
     * @mbggenerated Mon Sep 26 16:32:06 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table live_display_protocol
     *
     * @mbggenerated Mon Sep 26 16:32:06 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table live_display_protocol
     *
     * @mbggenerated Mon Sep 26 16:32:06 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table live_display_protocol
     *
     * @mbggenerated Mon Sep 26 16:32:06 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table live_display_protocol
     *
     * @mbggenerated Mon Sep 26 16:32:06 CST 2016
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table live_display_protocol
     *
     * @mbggenerated Mon Sep 26 16:32:06 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table live_display_protocol
     *
     * @mbggenerated Mon Sep 26 16:32:06 CST 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table live_display_protocol
     *
     * @mbggenerated Mon Sep 26 16:32:06 CST 2016
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andVLvIsNull() {
            addCriterion("v_lv is null");
            return (Criteria) this;
        }

        public Criteria andVLvIsNotNull() {
            addCriterion("v_lv is not null");
            return (Criteria) this;
        }

        public Criteria andVLvEqualTo(Integer value) {
            addCriterion("v_lv =", value, "vLv");
            return (Criteria) this;
        }

        public Criteria andVLvNotEqualTo(Integer value) {
            addCriterion("v_lv <>", value, "vLv");
            return (Criteria) this;
        }

        public Criteria andVLvGreaterThan(Integer value) {
            addCriterion("v_lv >", value, "vLv");
            return (Criteria) this;
        }

        public Criteria andVLvGreaterThanOrEqualTo(Integer value) {
            addCriterion("v_lv >=", value, "vLv");
            return (Criteria) this;
        }

        public Criteria andVLvLessThan(Integer value) {
            addCriterion("v_lv <", value, "vLv");
            return (Criteria) this;
        }

        public Criteria andVLvLessThanOrEqualTo(Integer value) {
            addCriterion("v_lv <=", value, "vLv");
            return (Criteria) this;
        }

        public Criteria andVLvIn(List<Integer> values) {
            addCriterion("v_lv in", values, "vLv");
            return (Criteria) this;
        }

        public Criteria andVLvNotIn(List<Integer> values) {
            addCriterion("v_lv not in", values, "vLv");
            return (Criteria) this;
        }

        public Criteria andVLvBetween(Integer value1, Integer value2) {
            addCriterion("v_lv between", value1, value2, "vLv");
            return (Criteria) this;
        }

        public Criteria andVLvNotBetween(Integer value1, Integer value2) {
            addCriterion("v_lv not between", value1, value2, "vLv");
            return (Criteria) this;
        }

        public Criteria andCoreTypeIsNull() {
            addCriterion("core_type is null");
            return (Criteria) this;
        }

        public Criteria andCoreTypeIsNotNull() {
            addCriterion("core_type is not null");
            return (Criteria) this;
        }

        public Criteria andCoreTypeEqualTo(Integer value) {
            addCriterion("core_type =", value, "coreType");
            return (Criteria) this;
        }

        public Criteria andCoreTypeNotEqualTo(Integer value) {
            addCriterion("core_type <>", value, "coreType");
            return (Criteria) this;
        }

        public Criteria andCoreTypeGreaterThan(Integer value) {
            addCriterion("core_type >", value, "coreType");
            return (Criteria) this;
        }

        public Criteria andCoreTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("core_type >=", value, "coreType");
            return (Criteria) this;
        }

        public Criteria andCoreTypeLessThan(Integer value) {
            addCriterion("core_type <", value, "coreType");
            return (Criteria) this;
        }

        public Criteria andCoreTypeLessThanOrEqualTo(Integer value) {
            addCriterion("core_type <=", value, "coreType");
            return (Criteria) this;
        }

        public Criteria andCoreTypeIn(List<Integer> values) {
            addCriterion("core_type in", values, "coreType");
            return (Criteria) this;
        }

        public Criteria andCoreTypeNotIn(List<Integer> values) {
            addCriterion("core_type not in", values, "coreType");
            return (Criteria) this;
        }

        public Criteria andCoreTypeBetween(Integer value1, Integer value2) {
            addCriterion("core_type between", value1, value2, "coreType");
            return (Criteria) this;
        }

        public Criteria andCoreTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("core_type not between", value1, value2, "coreType");
            return (Criteria) this;
        }

        public Criteria andCoreAlignIsNull() {
            addCriterion("core_align is null");
            return (Criteria) this;
        }

        public Criteria andCoreAlignIsNotNull() {
            addCriterion("core_align is not null");
            return (Criteria) this;
        }

        public Criteria andCoreAlignEqualTo(String value) {
            addCriterion("core_align =", value, "coreAlign");
            return (Criteria) this;
        }

        public Criteria andCoreAlignNotEqualTo(String value) {
            addCriterion("core_align <>", value, "coreAlign");
            return (Criteria) this;
        }

        public Criteria andCoreAlignGreaterThan(String value) {
            addCriterion("core_align >", value, "coreAlign");
            return (Criteria) this;
        }

        public Criteria andCoreAlignGreaterThanOrEqualTo(String value) {
            addCriterion("core_align >=", value, "coreAlign");
            return (Criteria) this;
        }

        public Criteria andCoreAlignLessThan(String value) {
            addCriterion("core_align <", value, "coreAlign");
            return (Criteria) this;
        }

        public Criteria andCoreAlignLessThanOrEqualTo(String value) {
            addCriterion("core_align <=", value, "coreAlign");
            return (Criteria) this;
        }

        public Criteria andCoreAlignLike(String value) {
            addCriterion("core_align like", value, "coreAlign");
            return (Criteria) this;
        }

        public Criteria andCoreAlignNotLike(String value) {
            addCriterion("core_align not like", value, "coreAlign");
            return (Criteria) this;
        }

        public Criteria andCoreAlignIn(List<String> values) {
            addCriterion("core_align in", values, "coreAlign");
            return (Criteria) this;
        }

        public Criteria andCoreAlignNotIn(List<String> values) {
            addCriterion("core_align not in", values, "coreAlign");
            return (Criteria) this;
        }

        public Criteria andCoreAlignBetween(String value1, String value2) {
            addCriterion("core_align between", value1, value2, "coreAlign");
            return (Criteria) this;
        }

        public Criteria andCoreAlignNotBetween(String value1, String value2) {
            addCriterion("core_align not between", value1, value2, "coreAlign");
            return (Criteria) this;
        }

        public Criteria andInTypeIsNull() {
            addCriterion("in_type is null");
            return (Criteria) this;
        }

        public Criteria andInTypeIsNotNull() {
            addCriterion("in_type is not null");
            return (Criteria) this;
        }

        public Criteria andInTypeEqualTo(Integer value) {
            addCriterion("in_type =", value, "inType");
            return (Criteria) this;
        }

        public Criteria andInTypeNotEqualTo(Integer value) {
            addCriterion("in_type <>", value, "inType");
            return (Criteria) this;
        }

        public Criteria andInTypeGreaterThan(Integer value) {
            addCriterion("in_type >", value, "inType");
            return (Criteria) this;
        }

        public Criteria andInTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("in_type >=", value, "inType");
            return (Criteria) this;
        }

        public Criteria andInTypeLessThan(Integer value) {
            addCriterion("in_type <", value, "inType");
            return (Criteria) this;
        }

        public Criteria andInTypeLessThanOrEqualTo(Integer value) {
            addCriterion("in_type <=", value, "inType");
            return (Criteria) this;
        }

        public Criteria andInTypeIn(List<Integer> values) {
            addCriterion("in_type in", values, "inType");
            return (Criteria) this;
        }

        public Criteria andInTypeNotIn(List<Integer> values) {
            addCriterion("in_type not in", values, "inType");
            return (Criteria) this;
        }

        public Criteria andInTypeBetween(Integer value1, Integer value2) {
            addCriterion("in_type between", value1, value2, "inType");
            return (Criteria) this;
        }

        public Criteria andInTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("in_type not between", value1, value2, "inType");
            return (Criteria) this;
        }

        public Criteria andInAlignIsNull() {
            addCriterion("in_align is null");
            return (Criteria) this;
        }

        public Criteria andInAlignIsNotNull() {
            addCriterion("in_align is not null");
            return (Criteria) this;
        }

        public Criteria andInAlignEqualTo(String value) {
            addCriterion("in_align =", value, "inAlign");
            return (Criteria) this;
        }

        public Criteria andInAlignNotEqualTo(String value) {
            addCriterion("in_align <>", value, "inAlign");
            return (Criteria) this;
        }

        public Criteria andInAlignGreaterThan(String value) {
            addCriterion("in_align >", value, "inAlign");
            return (Criteria) this;
        }

        public Criteria andInAlignGreaterThanOrEqualTo(String value) {
            addCriterion("in_align >=", value, "inAlign");
            return (Criteria) this;
        }

        public Criteria andInAlignLessThan(String value) {
            addCriterion("in_align <", value, "inAlign");
            return (Criteria) this;
        }

        public Criteria andInAlignLessThanOrEqualTo(String value) {
            addCriterion("in_align <=", value, "inAlign");
            return (Criteria) this;
        }

        public Criteria andInAlignLike(String value) {
            addCriterion("in_align like", value, "inAlign");
            return (Criteria) this;
        }

        public Criteria andInAlignNotLike(String value) {
            addCriterion("in_align not like", value, "inAlign");
            return (Criteria) this;
        }

        public Criteria andInAlignIn(List<String> values) {
            addCriterion("in_align in", values, "inAlign");
            return (Criteria) this;
        }

        public Criteria andInAlignNotIn(List<String> values) {
            addCriterion("in_align not in", values, "inAlign");
            return (Criteria) this;
        }

        public Criteria andInAlignBetween(String value1, String value2) {
            addCriterion("in_align between", value1, value2, "inAlign");
            return (Criteria) this;
        }

        public Criteria andInAlignNotBetween(String value1, String value2) {
            addCriterion("in_align not between", value1, value2, "inAlign");
            return (Criteria) this;
        }

        public Criteria andInRangeIsNull() {
            addCriterion("in_range is null");
            return (Criteria) this;
        }

        public Criteria andInRangeIsNotNull() {
            addCriterion("in_range is not null");
            return (Criteria) this;
        }

        public Criteria andInRangeEqualTo(Integer value) {
            addCriterion("in_range =", value, "inRange");
            return (Criteria) this;
        }

        public Criteria andInRangeNotEqualTo(Integer value) {
            addCriterion("in_range <>", value, "inRange");
            return (Criteria) this;
        }

        public Criteria andInRangeGreaterThan(Integer value) {
            addCriterion("in_range >", value, "inRange");
            return (Criteria) this;
        }

        public Criteria andInRangeGreaterThanOrEqualTo(Integer value) {
            addCriterion("in_range >=", value, "inRange");
            return (Criteria) this;
        }

        public Criteria andInRangeLessThan(Integer value) {
            addCriterion("in_range <", value, "inRange");
            return (Criteria) this;
        }

        public Criteria andInRangeLessThanOrEqualTo(Integer value) {
            addCriterion("in_range <=", value, "inRange");
            return (Criteria) this;
        }

        public Criteria andInRangeIn(List<Integer> values) {
            addCriterion("in_range in", values, "inRange");
            return (Criteria) this;
        }

        public Criteria andInRangeNotIn(List<Integer> values) {
            addCriterion("in_range not in", values, "inRange");
            return (Criteria) this;
        }

        public Criteria andInRangeBetween(Integer value1, Integer value2) {
            addCriterion("in_range between", value1, value2, "inRange");
            return (Criteria) this;
        }

        public Criteria andInRangeNotBetween(Integer value1, Integer value2) {
            addCriterion("in_range not between", value1, value2, "inRange");
            return (Criteria) this;
        }

        public Criteria andOutTypeIsNull() {
            addCriterion("out_type is null");
            return (Criteria) this;
        }

        public Criteria andOutTypeIsNotNull() {
            addCriterion("out_type is not null");
            return (Criteria) this;
        }

        public Criteria andOutTypeEqualTo(Integer value) {
            addCriterion("out_type =", value, "outType");
            return (Criteria) this;
        }

        public Criteria andOutTypeNotEqualTo(Integer value) {
            addCriterion("out_type <>", value, "outType");
            return (Criteria) this;
        }

        public Criteria andOutTypeGreaterThan(Integer value) {
            addCriterion("out_type >", value, "outType");
            return (Criteria) this;
        }

        public Criteria andOutTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("out_type >=", value, "outType");
            return (Criteria) this;
        }

        public Criteria andOutTypeLessThan(Integer value) {
            addCriterion("out_type <", value, "outType");
            return (Criteria) this;
        }

        public Criteria andOutTypeLessThanOrEqualTo(Integer value) {
            addCriterion("out_type <=", value, "outType");
            return (Criteria) this;
        }

        public Criteria andOutTypeIn(List<Integer> values) {
            addCriterion("out_type in", values, "outType");
            return (Criteria) this;
        }

        public Criteria andOutTypeNotIn(List<Integer> values) {
            addCriterion("out_type not in", values, "outType");
            return (Criteria) this;
        }

        public Criteria andOutTypeBetween(Integer value1, Integer value2) {
            addCriterion("out_type between", value1, value2, "outType");
            return (Criteria) this;
        }

        public Criteria andOutTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("out_type not between", value1, value2, "outType");
            return (Criteria) this;
        }

        public Criteria andOutAlignIsNull() {
            addCriterion("out_align is null");
            return (Criteria) this;
        }

        public Criteria andOutAlignIsNotNull() {
            addCriterion("out_align is not null");
            return (Criteria) this;
        }

        public Criteria andOutAlignEqualTo(String value) {
            addCriterion("out_align =", value, "outAlign");
            return (Criteria) this;
        }

        public Criteria andOutAlignNotEqualTo(String value) {
            addCriterion("out_align <>", value, "outAlign");
            return (Criteria) this;
        }

        public Criteria andOutAlignGreaterThan(String value) {
            addCriterion("out_align >", value, "outAlign");
            return (Criteria) this;
        }

        public Criteria andOutAlignGreaterThanOrEqualTo(String value) {
            addCriterion("out_align >=", value, "outAlign");
            return (Criteria) this;
        }

        public Criteria andOutAlignLessThan(String value) {
            addCriterion("out_align <", value, "outAlign");
            return (Criteria) this;
        }

        public Criteria andOutAlignLessThanOrEqualTo(String value) {
            addCriterion("out_align <=", value, "outAlign");
            return (Criteria) this;
        }

        public Criteria andOutAlignLike(String value) {
            addCriterion("out_align like", value, "outAlign");
            return (Criteria) this;
        }

        public Criteria andOutAlignNotLike(String value) {
            addCriterion("out_align not like", value, "outAlign");
            return (Criteria) this;
        }

        public Criteria andOutAlignIn(List<String> values) {
            addCriterion("out_align in", values, "outAlign");
            return (Criteria) this;
        }

        public Criteria andOutAlignNotIn(List<String> values) {
            addCriterion("out_align not in", values, "outAlign");
            return (Criteria) this;
        }

        public Criteria andOutAlignBetween(String value1, String value2) {
            addCriterion("out_align between", value1, value2, "outAlign");
            return (Criteria) this;
        }

        public Criteria andOutAlignNotBetween(String value1, String value2) {
            addCriterion("out_align not between", value1, value2, "outAlign");
            return (Criteria) this;
        }

        public Criteria andOutRangeIsNull() {
            addCriterion("out_range is null");
            return (Criteria) this;
        }

        public Criteria andOutRangeIsNotNull() {
            addCriterion("out_range is not null");
            return (Criteria) this;
        }

        public Criteria andOutRangeEqualTo(Integer value) {
            addCriterion("out_range =", value, "outRange");
            return (Criteria) this;
        }

        public Criteria andOutRangeNotEqualTo(Integer value) {
            addCriterion("out_range <>", value, "outRange");
            return (Criteria) this;
        }

        public Criteria andOutRangeGreaterThan(Integer value) {
            addCriterion("out_range >", value, "outRange");
            return (Criteria) this;
        }

        public Criteria andOutRangeGreaterThanOrEqualTo(Integer value) {
            addCriterion("out_range >=", value, "outRange");
            return (Criteria) this;
        }

        public Criteria andOutRangeLessThan(Integer value) {
            addCriterion("out_range <", value, "outRange");
            return (Criteria) this;
        }

        public Criteria andOutRangeLessThanOrEqualTo(Integer value) {
            addCriterion("out_range <=", value, "outRange");
            return (Criteria) this;
        }

        public Criteria andOutRangeIn(List<Integer> values) {
            addCriterion("out_range in", values, "outRange");
            return (Criteria) this;
        }

        public Criteria andOutRangeNotIn(List<Integer> values) {
            addCriterion("out_range not in", values, "outRange");
            return (Criteria) this;
        }

        public Criteria andOutRangeBetween(Integer value1, Integer value2) {
            addCriterion("out_range between", value1, value2, "outRange");
            return (Criteria) this;
        }

        public Criteria andOutRangeNotBetween(Integer value1, Integer value2) {
            addCriterion("out_range not between", value1, value2, "outRange");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Long value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Long value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Long value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Long value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Long value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Long value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Long> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Long> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Long value1, Long value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Long value1, Long value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table live_display_protocol
     *
     * @mbggenerated do_not_delete_during_merge Mon Sep 26 16:32:06 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table live_display_protocol
     *
     * @mbggenerated Mon Sep 26 16:32:06 CST 2016
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}