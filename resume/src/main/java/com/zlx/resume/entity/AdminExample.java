package com.zlx.resume.entity;

import java.util.ArrayList;
import java.util.List;

public class AdminExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdminExample() {
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

        public Criteria andAIdIsNull() {
            addCriterion("a_id is null");
            return (Criteria) this;
        }

        public Criteria andAIdIsNotNull() {
            addCriterion("a_id is not null");
            return (Criteria) this;
        }

        public Criteria andAIdEqualTo(Integer value) {
            addCriterion("a_id =", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdNotEqualTo(Integer value) {
            addCriterion("a_id <>", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdGreaterThan(Integer value) {
            addCriterion("a_id >", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("a_id >=", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdLessThan(Integer value) {
            addCriterion("a_id <", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdLessThanOrEqualTo(Integer value) {
            addCriterion("a_id <=", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdIn(List<Integer> values) {
            addCriterion("a_id in", values, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdNotIn(List<Integer> values) {
            addCriterion("a_id not in", values, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdBetween(Integer value1, Integer value2) {
            addCriterion("a_id between", value1, value2, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdNotBetween(Integer value1, Integer value2) {
            addCriterion("a_id not between", value1, value2, "aId");
            return (Criteria) this;
        }

        public Criteria andAPasswordIsNull() {
            addCriterion("a_password is null");
            return (Criteria) this;
        }

        public Criteria andAPasswordIsNotNull() {
            addCriterion("a_password is not null");
            return (Criteria) this;
        }

        public Criteria andAPasswordEqualTo(String value) {
            addCriterion("a_password =", value, "aPassword");
            return (Criteria) this;
        }

        public Criteria andAPasswordNotEqualTo(String value) {
            addCriterion("a_password <>", value, "aPassword");
            return (Criteria) this;
        }

        public Criteria andAPasswordGreaterThan(String value) {
            addCriterion("a_password >", value, "aPassword");
            return (Criteria) this;
        }

        public Criteria andAPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("a_password >=", value, "aPassword");
            return (Criteria) this;
        }

        public Criteria andAPasswordLessThan(String value) {
            addCriterion("a_password <", value, "aPassword");
            return (Criteria) this;
        }

        public Criteria andAPasswordLessThanOrEqualTo(String value) {
            addCriterion("a_password <=", value, "aPassword");
            return (Criteria) this;
        }

        public Criteria andAPasswordLike(String value) {
            addCriterion("a_password like", value, "aPassword");
            return (Criteria) this;
        }

        public Criteria andAPasswordNotLike(String value) {
            addCriterion("a_password not like", value, "aPassword");
            return (Criteria) this;
        }

        public Criteria andAPasswordIn(List<String> values) {
            addCriterion("a_password in", values, "aPassword");
            return (Criteria) this;
        }

        public Criteria andAPasswordNotIn(List<String> values) {
            addCriterion("a_password not in", values, "aPassword");
            return (Criteria) this;
        }

        public Criteria andAPasswordBetween(String value1, String value2) {
            addCriterion("a_password between", value1, value2, "aPassword");
            return (Criteria) this;
        }

        public Criteria andAPasswordNotBetween(String value1, String value2) {
            addCriterion("a_password not between", value1, value2, "aPassword");
            return (Criteria) this;
        }

        public Criteria andATelIsNull() {
            addCriterion("a_tel is null");
            return (Criteria) this;
        }

        public Criteria andATelIsNotNull() {
            addCriterion("a_tel is not null");
            return (Criteria) this;
        }

        public Criteria andATelEqualTo(String value) {
            addCriterion("a_tel =", value, "aTel");
            return (Criteria) this;
        }

        public Criteria andATelNotEqualTo(String value) {
            addCriterion("a_tel <>", value, "aTel");
            return (Criteria) this;
        }

        public Criteria andATelGreaterThan(String value) {
            addCriterion("a_tel >", value, "aTel");
            return (Criteria) this;
        }

        public Criteria andATelGreaterThanOrEqualTo(String value) {
            addCriterion("a_tel >=", value, "aTel");
            return (Criteria) this;
        }

        public Criteria andATelLessThan(String value) {
            addCriterion("a_tel <", value, "aTel");
            return (Criteria) this;
        }

        public Criteria andATelLessThanOrEqualTo(String value) {
            addCriterion("a_tel <=", value, "aTel");
            return (Criteria) this;
        }

        public Criteria andATelLike(String value) {
            addCriterion("a_tel like", value, "aTel");
            return (Criteria) this;
        }

        public Criteria andATelNotLike(String value) {
            addCriterion("a_tel not like", value, "aTel");
            return (Criteria) this;
        }

        public Criteria andATelIn(List<String> values) {
            addCriterion("a_tel in", values, "aTel");
            return (Criteria) this;
        }

        public Criteria andATelNotIn(List<String> values) {
            addCriterion("a_tel not in", values, "aTel");
            return (Criteria) this;
        }

        public Criteria andATelBetween(String value1, String value2) {
            addCriterion("a_tel between", value1, value2, "aTel");
            return (Criteria) this;
        }

        public Criteria andATelNotBetween(String value1, String value2) {
            addCriterion("a_tel not between", value1, value2, "aTel");
            return (Criteria) this;
        }

        public Criteria andACardIsNull() {
            addCriterion("a_card is null");
            return (Criteria) this;
        }

        public Criteria andACardIsNotNull() {
            addCriterion("a_card is not null");
            return (Criteria) this;
        }

        public Criteria andACardEqualTo(String value) {
            addCriterion("a_card =", value, "aCard");
            return (Criteria) this;
        }

        public Criteria andACardNotEqualTo(String value) {
            addCriterion("a_card <>", value, "aCard");
            return (Criteria) this;
        }

        public Criteria andACardGreaterThan(String value) {
            addCriterion("a_card >", value, "aCard");
            return (Criteria) this;
        }

        public Criteria andACardGreaterThanOrEqualTo(String value) {
            addCriterion("a_card >=", value, "aCard");
            return (Criteria) this;
        }

        public Criteria andACardLessThan(String value) {
            addCriterion("a_card <", value, "aCard");
            return (Criteria) this;
        }

        public Criteria andACardLessThanOrEqualTo(String value) {
            addCriterion("a_card <=", value, "aCard");
            return (Criteria) this;
        }

        public Criteria andACardLike(String value) {
            addCriterion("a_card like", value, "aCard");
            return (Criteria) this;
        }

        public Criteria andACardNotLike(String value) {
            addCriterion("a_card not like", value, "aCard");
            return (Criteria) this;
        }

        public Criteria andACardIn(List<String> values) {
            addCriterion("a_card in", values, "aCard");
            return (Criteria) this;
        }

        public Criteria andACardNotIn(List<String> values) {
            addCriterion("a_card not in", values, "aCard");
            return (Criteria) this;
        }

        public Criteria andACardBetween(String value1, String value2) {
            addCriterion("a_card between", value1, value2, "aCard");
            return (Criteria) this;
        }

        public Criteria andACardNotBetween(String value1, String value2) {
            addCriterion("a_card not between", value1, value2, "aCard");
            return (Criteria) this;
        }

        public Criteria andAMailIsNull() {
            addCriterion("a_mail is null");
            return (Criteria) this;
        }

        public Criteria andAMailIsNotNull() {
            addCriterion("a_mail is not null");
            return (Criteria) this;
        }

        public Criteria andAMailEqualTo(String value) {
            addCriterion("a_mail =", value, "aMail");
            return (Criteria) this;
        }

        public Criteria andAMailNotEqualTo(String value) {
            addCriterion("a_mail <>", value, "aMail");
            return (Criteria) this;
        }

        public Criteria andAMailGreaterThan(String value) {
            addCriterion("a_mail >", value, "aMail");
            return (Criteria) this;
        }

        public Criteria andAMailGreaterThanOrEqualTo(String value) {
            addCriterion("a_mail >=", value, "aMail");
            return (Criteria) this;
        }

        public Criteria andAMailLessThan(String value) {
            addCriterion("a_mail <", value, "aMail");
            return (Criteria) this;
        }

        public Criteria andAMailLessThanOrEqualTo(String value) {
            addCriterion("a_mail <=", value, "aMail");
            return (Criteria) this;
        }

        public Criteria andAMailLike(String value) {
            addCriterion("a_mail like", value, "aMail");
            return (Criteria) this;
        }

        public Criteria andAMailNotLike(String value) {
            addCriterion("a_mail not like", value, "aMail");
            return (Criteria) this;
        }

        public Criteria andAMailIn(List<String> values) {
            addCriterion("a_mail in", values, "aMail");
            return (Criteria) this;
        }

        public Criteria andAMailNotIn(List<String> values) {
            addCriterion("a_mail not in", values, "aMail");
            return (Criteria) this;
        }

        public Criteria andAMailBetween(String value1, String value2) {
            addCriterion("a_mail between", value1, value2, "aMail");
            return (Criteria) this;
        }

        public Criteria andAMailNotBetween(String value1, String value2) {
            addCriterion("a_mail not between", value1, value2, "aMail");
            return (Criteria) this;
        }

        public Criteria andANameIsNull() {
            addCriterion("a_name is null");
            return (Criteria) this;
        }

        public Criteria andANameIsNotNull() {
            addCriterion("a_name is not null");
            return (Criteria) this;
        }

        public Criteria andANameEqualTo(String value) {
            addCriterion("a_name =", value, "aName");
            return (Criteria) this;
        }

        public Criteria andANameNotEqualTo(String value) {
            addCriterion("a_name <>", value, "aName");
            return (Criteria) this;
        }

        public Criteria andANameGreaterThan(String value) {
            addCriterion("a_name >", value, "aName");
            return (Criteria) this;
        }

        public Criteria andANameGreaterThanOrEqualTo(String value) {
            addCriterion("a_name >=", value, "aName");
            return (Criteria) this;
        }

        public Criteria andANameLessThan(String value) {
            addCriterion("a_name <", value, "aName");
            return (Criteria) this;
        }

        public Criteria andANameLessThanOrEqualTo(String value) {
            addCriterion("a_name <=", value, "aName");
            return (Criteria) this;
        }

        public Criteria andANameLike(String value) {
            addCriterion("a_name like", value, "aName");
            return (Criteria) this;
        }

        public Criteria andANameNotLike(String value) {
            addCriterion("a_name not like", value, "aName");
            return (Criteria) this;
        }

        public Criteria andANameIn(List<String> values) {
            addCriterion("a_name in", values, "aName");
            return (Criteria) this;
        }

        public Criteria andANameNotIn(List<String> values) {
            addCriterion("a_name not in", values, "aName");
            return (Criteria) this;
        }

        public Criteria andANameBetween(String value1, String value2) {
            addCriterion("a_name between", value1, value2, "aName");
            return (Criteria) this;
        }

        public Criteria andANameNotBetween(String value1, String value2) {
            addCriterion("a_name not between", value1, value2, "aName");
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