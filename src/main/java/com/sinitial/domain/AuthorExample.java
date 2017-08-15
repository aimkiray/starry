package com.sinitial.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AuthorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AuthorExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andAuthorIdIsNull() {
            addCriterion("author_id is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIsNotNull() {
            addCriterion("author_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorIdEqualTo(Integer value) {
            addCriterion("author_id =", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotEqualTo(Integer value) {
            addCriterion("author_id <>", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdGreaterThan(Integer value) {
            addCriterion("author_id >", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("author_id >=", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdLessThan(Integer value) {
            addCriterion("author_id <", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdLessThanOrEqualTo(Integer value) {
            addCriterion("author_id <=", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIn(List<Integer> values) {
            addCriterion("author_id in", values, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotIn(List<Integer> values) {
            addCriterion("author_id not in", values, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdBetween(Integer value1, Integer value2) {
            addCriterion("author_id between", value1, value2, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("author_id not between", value1, value2, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorNameIsNull() {
            addCriterion("author_name is null");
            return (Criteria) this;
        }

        public Criteria andAuthorNameIsNotNull() {
            addCriterion("author_name is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorNameEqualTo(String value) {
            addCriterion("author_name =", value, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameNotEqualTo(String value) {
            addCriterion("author_name <>", value, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameGreaterThan(String value) {
            addCriterion("author_name >", value, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameGreaterThanOrEqualTo(String value) {
            addCriterion("author_name >=", value, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameLessThan(String value) {
            addCriterion("author_name <", value, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameLessThanOrEqualTo(String value) {
            addCriterion("author_name <=", value, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameLike(String value) {
            addCriterion("author_name like", value, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameNotLike(String value) {
            addCriterion("author_name not like", value, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameIn(List<String> values) {
            addCriterion("author_name in", values, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameNotIn(List<String> values) {
            addCriterion("author_name not in", values, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameBetween(String value1, String value2) {
            addCriterion("author_name between", value1, value2, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameNotBetween(String value1, String value2) {
            addCriterion("author_name not between", value1, value2, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorDateIsNull() {
            addCriterion("author_date is null");
            return (Criteria) this;
        }

        public Criteria andAuthorDateIsNotNull() {
            addCriterion("author_date is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorDateEqualTo(Date value) {
            addCriterion("author_date =", value, "authorDate");
            return (Criteria) this;
        }

        public Criteria andAuthorDateNotEqualTo(Date value) {
            addCriterion("author_date <>", value, "authorDate");
            return (Criteria) this;
        }

        public Criteria andAuthorDateGreaterThan(Date value) {
            addCriterion("author_date >", value, "authorDate");
            return (Criteria) this;
        }

        public Criteria andAuthorDateGreaterThanOrEqualTo(Date value) {
            addCriterion("author_date >=", value, "authorDate");
            return (Criteria) this;
        }

        public Criteria andAuthorDateLessThan(Date value) {
            addCriterion("author_date <", value, "authorDate");
            return (Criteria) this;
        }

        public Criteria andAuthorDateLessThanOrEqualTo(Date value) {
            addCriterion("author_date <=", value, "authorDate");
            return (Criteria) this;
        }

        public Criteria andAuthorDateIn(List<Date> values) {
            addCriterion("author_date in", values, "authorDate");
            return (Criteria) this;
        }

        public Criteria andAuthorDateNotIn(List<Date> values) {
            addCriterion("author_date not in", values, "authorDate");
            return (Criteria) this;
        }

        public Criteria andAuthorDateBetween(Date value1, Date value2) {
            addCriterion("author_date between", value1, value2, "authorDate");
            return (Criteria) this;
        }

        public Criteria andAuthorDateNotBetween(Date value1, Date value2) {
            addCriterion("author_date not between", value1, value2, "authorDate");
            return (Criteria) this;
        }

        public Criteria andAuthorInfoIsNull() {
            addCriterion("author_info is null");
            return (Criteria) this;
        }

        public Criteria andAuthorInfoIsNotNull() {
            addCriterion("author_info is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorInfoEqualTo(String value) {
            addCriterion("author_info =", value, "authorInfo");
            return (Criteria) this;
        }

        public Criteria andAuthorInfoNotEqualTo(String value) {
            addCriterion("author_info <>", value, "authorInfo");
            return (Criteria) this;
        }

        public Criteria andAuthorInfoGreaterThan(String value) {
            addCriterion("author_info >", value, "authorInfo");
            return (Criteria) this;
        }

        public Criteria andAuthorInfoGreaterThanOrEqualTo(String value) {
            addCriterion("author_info >=", value, "authorInfo");
            return (Criteria) this;
        }

        public Criteria andAuthorInfoLessThan(String value) {
            addCriterion("author_info <", value, "authorInfo");
            return (Criteria) this;
        }

        public Criteria andAuthorInfoLessThanOrEqualTo(String value) {
            addCriterion("author_info <=", value, "authorInfo");
            return (Criteria) this;
        }

        public Criteria andAuthorInfoLike(String value) {
            addCriterion("author_info like", value, "authorInfo");
            return (Criteria) this;
        }

        public Criteria andAuthorInfoNotLike(String value) {
            addCriterion("author_info not like", value, "authorInfo");
            return (Criteria) this;
        }

        public Criteria andAuthorInfoIn(List<String> values) {
            addCriterion("author_info in", values, "authorInfo");
            return (Criteria) this;
        }

        public Criteria andAuthorInfoNotIn(List<String> values) {
            addCriterion("author_info not in", values, "authorInfo");
            return (Criteria) this;
        }

        public Criteria andAuthorInfoBetween(String value1, String value2) {
            addCriterion("author_info between", value1, value2, "authorInfo");
            return (Criteria) this;
        }

        public Criteria andAuthorInfoNotBetween(String value1, String value2) {
            addCriterion("author_info not between", value1, value2, "authorInfo");
            return (Criteria) this;
        }

        public Criteria andAuthorPasswordIsNull() {
            addCriterion("author_password is null");
            return (Criteria) this;
        }

        public Criteria andAuthorPasswordIsNotNull() {
            addCriterion("author_password is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorPasswordEqualTo(String value) {
            addCriterion("author_password =", value, "authorPassword");
            return (Criteria) this;
        }

        public Criteria andAuthorPasswordNotEqualTo(String value) {
            addCriterion("author_password <>", value, "authorPassword");
            return (Criteria) this;
        }

        public Criteria andAuthorPasswordGreaterThan(String value) {
            addCriterion("author_password >", value, "authorPassword");
            return (Criteria) this;
        }

        public Criteria andAuthorPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("author_password >=", value, "authorPassword");
            return (Criteria) this;
        }

        public Criteria andAuthorPasswordLessThan(String value) {
            addCriterion("author_password <", value, "authorPassword");
            return (Criteria) this;
        }

        public Criteria andAuthorPasswordLessThanOrEqualTo(String value) {
            addCriterion("author_password <=", value, "authorPassword");
            return (Criteria) this;
        }

        public Criteria andAuthorPasswordLike(String value) {
            addCriterion("author_password like", value, "authorPassword");
            return (Criteria) this;
        }

        public Criteria andAuthorPasswordNotLike(String value) {
            addCriterion("author_password not like", value, "authorPassword");
            return (Criteria) this;
        }

        public Criteria andAuthorPasswordIn(List<String> values) {
            addCriterion("author_password in", values, "authorPassword");
            return (Criteria) this;
        }

        public Criteria andAuthorPasswordNotIn(List<String> values) {
            addCriterion("author_password not in", values, "authorPassword");
            return (Criteria) this;
        }

        public Criteria andAuthorPasswordBetween(String value1, String value2) {
            addCriterion("author_password between", value1, value2, "authorPassword");
            return (Criteria) this;
        }

        public Criteria andAuthorPasswordNotBetween(String value1, String value2) {
            addCriterion("author_password not between", value1, value2, "authorPassword");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNull() {
            addCriterion("nick_name is null");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNotNull() {
            addCriterion("nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andNickNameEqualTo(String value) {
            addCriterion("nick_name =", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotEqualTo(String value) {
            addCriterion("nick_name <>", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThan(String value) {
            addCriterion("nick_name >", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("nick_name >=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThan(String value) {
            addCriterion("nick_name <", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThanOrEqualTo(String value) {
            addCriterion("nick_name <=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLike(String value) {
            addCriterion("nick_name like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotLike(String value) {
            addCriterion("nick_name not like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameIn(List<String> values) {
            addCriterion("nick_name in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotIn(List<String> values) {
            addCriterion("nick_name not in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameBetween(String value1, String value2) {
            addCriterion("nick_name between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotBetween(String value1, String value2) {
            addCriterion("nick_name not between", value1, value2, "nickName");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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