package com.zlx.resume.entity;

import java.util.ArrayList;
import java.util.List;

public class User3Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public User3Example() {
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

        public Criteria andUIdIsNull() {
            addCriterion("u_id is null");
            return (Criteria) this;
        }

        public Criteria andUIdIsNotNull() {
            addCriterion("u_id is not null");
            return (Criteria) this;
        }

        public Criteria andUIdEqualTo(Integer value) {
            addCriterion("u_id =", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotEqualTo(Integer value) {
            addCriterion("u_id <>", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThan(Integer value) {
            addCriterion("u_id >", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("u_id >=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThan(Integer value) {
            addCriterion("u_id <", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThanOrEqualTo(Integer value) {
            addCriterion("u_id <=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdIn(List<Integer> values) {
            addCriterion("u_id in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotIn(List<Integer> values) {
            addCriterion("u_id not in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdBetween(Integer value1, Integer value2) {
            addCriterion("u_id between", value1, value2, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotBetween(Integer value1, Integer value2) {
            addCriterion("u_id not between", value1, value2, "uId");
            return (Criteria) this;
        }

        public Criteria andUNameIsNull() {
            addCriterion("u_name is null");
            return (Criteria) this;
        }

        public Criteria andUNameIsNotNull() {
            addCriterion("u_name is not null");
            return (Criteria) this;
        }

        public Criteria andUNameEqualTo(String value) {
            addCriterion("u_name =", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameNotEqualTo(String value) {
            addCriterion("u_name <>", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameGreaterThan(String value) {
            addCriterion("u_name >", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameGreaterThanOrEqualTo(String value) {
            addCriterion("u_name >=", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameLessThan(String value) {
            addCriterion("u_name <", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameLessThanOrEqualTo(String value) {
            addCriterion("u_name <=", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameLike(String value) {
            addCriterion("u_name like", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameNotLike(String value) {
            addCriterion("u_name not like", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameIn(List<String> values) {
            addCriterion("u_name in", values, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameNotIn(List<String> values) {
            addCriterion("u_name not in", values, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameBetween(String value1, String value2) {
            addCriterion("u_name between", value1, value2, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameNotBetween(String value1, String value2) {
            addCriterion("u_name not between", value1, value2, "uName");
            return (Criteria) this;
        }

        public Criteria andUPasswordIsNull() {
            addCriterion("u_password is null");
            return (Criteria) this;
        }

        public Criteria andUPasswordIsNotNull() {
            addCriterion("u_password is not null");
            return (Criteria) this;
        }

        public Criteria andUPasswordEqualTo(String value) {
            addCriterion("u_password =", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordNotEqualTo(String value) {
            addCriterion("u_password <>", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordGreaterThan(String value) {
            addCriterion("u_password >", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("u_password >=", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordLessThan(String value) {
            addCriterion("u_password <", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordLessThanOrEqualTo(String value) {
            addCriterion("u_password <=", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordLike(String value) {
            addCriterion("u_password like", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordNotLike(String value) {
            addCriterion("u_password not like", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordIn(List<String> values) {
            addCriterion("u_password in", values, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordNotIn(List<String> values) {
            addCriterion("u_password not in", values, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordBetween(String value1, String value2) {
            addCriterion("u_password between", value1, value2, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordNotBetween(String value1, String value2) {
            addCriterion("u_password not between", value1, value2, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUGenderIsNull() {
            addCriterion("u_gender is null");
            return (Criteria) this;
        }

        public Criteria andUGenderIsNotNull() {
            addCriterion("u_gender is not null");
            return (Criteria) this;
        }

        public Criteria andUGenderEqualTo(Boolean value) {
            addCriterion("u_gender =", value, "uGender");
            return (Criteria) this;
        }

        public Criteria andUGenderNotEqualTo(Boolean value) {
            addCriterion("u_gender <>", value, "uGender");
            return (Criteria) this;
        }

        public Criteria andUGenderGreaterThan(Boolean value) {
            addCriterion("u_gender >", value, "uGender");
            return (Criteria) this;
        }

        public Criteria andUGenderGreaterThanOrEqualTo(Boolean value) {
            addCriterion("u_gender >=", value, "uGender");
            return (Criteria) this;
        }

        public Criteria andUGenderLessThan(Boolean value) {
            addCriterion("u_gender <", value, "uGender");
            return (Criteria) this;
        }

        public Criteria andUGenderLessThanOrEqualTo(Boolean value) {
            addCriterion("u_gender <=", value, "uGender");
            return (Criteria) this;
        }

        public Criteria andUGenderIn(List<Boolean> values) {
            addCriterion("u_gender in", values, "uGender");
            return (Criteria) this;
        }

        public Criteria andUGenderNotIn(List<Boolean> values) {
            addCriterion("u_gender not in", values, "uGender");
            return (Criteria) this;
        }

        public Criteria andUGenderBetween(Boolean value1, Boolean value2) {
            addCriterion("u_gender between", value1, value2, "uGender");
            return (Criteria) this;
        }

        public Criteria andUGenderNotBetween(Boolean value1, Boolean value2) {
            addCriterion("u_gender not between", value1, value2, "uGender");
            return (Criteria) this;
        }

        public Criteria andUBirthIsNull() {
            addCriterion("u_birth is null");
            return (Criteria) this;
        }

        public Criteria andUBirthIsNotNull() {
            addCriterion("u_birth is not null");
            return (Criteria) this;
        }

        public Criteria andUBirthEqualTo(String value) {
            addCriterion("u_birth =", value, "uBirth");
            return (Criteria) this;
        }

        public Criteria andUBirthNotEqualTo(String value) {
            addCriterion("u_birth <>", value, "uBirth");
            return (Criteria) this;
        }

        public Criteria andUBirthGreaterThan(String value) {
            addCriterion("u_birth >", value, "uBirth");
            return (Criteria) this;
        }

        public Criteria andUBirthGreaterThanOrEqualTo(String value) {
            addCriterion("u_birth >=", value, "uBirth");
            return (Criteria) this;
        }

        public Criteria andUBirthLessThan(String value) {
            addCriterion("u_birth <", value, "uBirth");
            return (Criteria) this;
        }

        public Criteria andUBirthLessThanOrEqualTo(String value) {
            addCriterion("u_birth <=", value, "uBirth");
            return (Criteria) this;
        }

        public Criteria andUBirthLike(String value) {
            addCriterion("u_birth like", value, "uBirth");
            return (Criteria) this;
        }

        public Criteria andUBirthNotLike(String value) {
            addCriterion("u_birth not like", value, "uBirth");
            return (Criteria) this;
        }

        public Criteria andUBirthIn(List<String> values) {
            addCriterion("u_birth in", values, "uBirth");
            return (Criteria) this;
        }

        public Criteria andUBirthNotIn(List<String> values) {
            addCriterion("u_birth not in", values, "uBirth");
            return (Criteria) this;
        }

        public Criteria andUBirthBetween(String value1, String value2) {
            addCriterion("u_birth between", value1, value2, "uBirth");
            return (Criteria) this;
        }

        public Criteria andUBirthNotBetween(String value1, String value2) {
            addCriterion("u_birth not between", value1, value2, "uBirth");
            return (Criteria) this;
        }

        public Criteria andUCardIsNull() {
            addCriterion("u_card is null");
            return (Criteria) this;
        }

        public Criteria andUCardIsNotNull() {
            addCriterion("u_card is not null");
            return (Criteria) this;
        }

        public Criteria andUCardEqualTo(String value) {
            addCriterion("u_card =", value, "uCard");
            return (Criteria) this;
        }

        public Criteria andUCardNotEqualTo(String value) {
            addCriterion("u_card <>", value, "uCard");
            return (Criteria) this;
        }

        public Criteria andUCardGreaterThan(String value) {
            addCriterion("u_card >", value, "uCard");
            return (Criteria) this;
        }

        public Criteria andUCardGreaterThanOrEqualTo(String value) {
            addCriterion("u_card >=", value, "uCard");
            return (Criteria) this;
        }

        public Criteria andUCardLessThan(String value) {
            addCriterion("u_card <", value, "uCard");
            return (Criteria) this;
        }

        public Criteria andUCardLessThanOrEqualTo(String value) {
            addCriterion("u_card <=", value, "uCard");
            return (Criteria) this;
        }

        public Criteria andUCardLike(String value) {
            addCriterion("u_card like", value, "uCard");
            return (Criteria) this;
        }

        public Criteria andUCardNotLike(String value) {
            addCriterion("u_card not like", value, "uCard");
            return (Criteria) this;
        }

        public Criteria andUCardIn(List<String> values) {
            addCriterion("u_card in", values, "uCard");
            return (Criteria) this;
        }

        public Criteria andUCardNotIn(List<String> values) {
            addCriterion("u_card not in", values, "uCard");
            return (Criteria) this;
        }

        public Criteria andUCardBetween(String value1, String value2) {
            addCriterion("u_card between", value1, value2, "uCard");
            return (Criteria) this;
        }

        public Criteria andUCardNotBetween(String value1, String value2) {
            addCriterion("u_card not between", value1, value2, "uCard");
            return (Criteria) this;
        }

        public Criteria andUEmailIsNull() {
            addCriterion("u_email is null");
            return (Criteria) this;
        }

        public Criteria andUEmailIsNotNull() {
            addCriterion("u_email is not null");
            return (Criteria) this;
        }

        public Criteria andUEmailEqualTo(String value) {
            addCriterion("u_email =", value, "uEmail");
            return (Criteria) this;
        }

        public Criteria andUEmailNotEqualTo(String value) {
            addCriterion("u_email <>", value, "uEmail");
            return (Criteria) this;
        }

        public Criteria andUEmailGreaterThan(String value) {
            addCriterion("u_email >", value, "uEmail");
            return (Criteria) this;
        }

        public Criteria andUEmailGreaterThanOrEqualTo(String value) {
            addCriterion("u_email >=", value, "uEmail");
            return (Criteria) this;
        }

        public Criteria andUEmailLessThan(String value) {
            addCriterion("u_email <", value, "uEmail");
            return (Criteria) this;
        }

        public Criteria andUEmailLessThanOrEqualTo(String value) {
            addCriterion("u_email <=", value, "uEmail");
            return (Criteria) this;
        }

        public Criteria andUEmailLike(String value) {
            addCriterion("u_email like", value, "uEmail");
            return (Criteria) this;
        }

        public Criteria andUEmailNotLike(String value) {
            addCriterion("u_email not like", value, "uEmail");
            return (Criteria) this;
        }

        public Criteria andUEmailIn(List<String> values) {
            addCriterion("u_email in", values, "uEmail");
            return (Criteria) this;
        }

        public Criteria andUEmailNotIn(List<String> values) {
            addCriterion("u_email not in", values, "uEmail");
            return (Criteria) this;
        }

        public Criteria andUEmailBetween(String value1, String value2) {
            addCriterion("u_email between", value1, value2, "uEmail");
            return (Criteria) this;
        }

        public Criteria andUEmailNotBetween(String value1, String value2) {
            addCriterion("u_email not between", value1, value2, "uEmail");
            return (Criteria) this;
        }

        public Criteria andUTelIsNull() {
            addCriterion("u_tel is null");
            return (Criteria) this;
        }

        public Criteria andUTelIsNotNull() {
            addCriterion("u_tel is not null");
            return (Criteria) this;
        }

        public Criteria andUTelEqualTo(String value) {
            addCriterion("u_tel =", value, "uTel");
            return (Criteria) this;
        }

        public Criteria andUTelNotEqualTo(String value) {
            addCriterion("u_tel <>", value, "uTel");
            return (Criteria) this;
        }

        public Criteria andUTelGreaterThan(String value) {
            addCriterion("u_tel >", value, "uTel");
            return (Criteria) this;
        }

        public Criteria andUTelGreaterThanOrEqualTo(String value) {
            addCriterion("u_tel >=", value, "uTel");
            return (Criteria) this;
        }

        public Criteria andUTelLessThan(String value) {
            addCriterion("u_tel <", value, "uTel");
            return (Criteria) this;
        }

        public Criteria andUTelLessThanOrEqualTo(String value) {
            addCriterion("u_tel <=", value, "uTel");
            return (Criteria) this;
        }

        public Criteria andUTelLike(String value) {
            addCriterion("u_tel like", value, "uTel");
            return (Criteria) this;
        }

        public Criteria andUTelNotLike(String value) {
            addCriterion("u_tel not like", value, "uTel");
            return (Criteria) this;
        }

        public Criteria andUTelIn(List<String> values) {
            addCriterion("u_tel in", values, "uTel");
            return (Criteria) this;
        }

        public Criteria andUTelNotIn(List<String> values) {
            addCriterion("u_tel not in", values, "uTel");
            return (Criteria) this;
        }

        public Criteria andUTelBetween(String value1, String value2) {
            addCriterion("u_tel between", value1, value2, "uTel");
            return (Criteria) this;
        }

        public Criteria andUTelNotBetween(String value1, String value2) {
            addCriterion("u_tel not between", value1, value2, "uTel");
            return (Criteria) this;
        }

        public Criteria andUSchoolIsNull() {
            addCriterion("u_school is null");
            return (Criteria) this;
        }

        public Criteria andUSchoolIsNotNull() {
            addCriterion("u_school is not null");
            return (Criteria) this;
        }

        public Criteria andUSchoolEqualTo(String value) {
            addCriterion("u_school =", value, "uSchool");
            return (Criteria) this;
        }

        public Criteria andUSchoolNotEqualTo(String value) {
            addCriterion("u_school <>", value, "uSchool");
            return (Criteria) this;
        }

        public Criteria andUSchoolGreaterThan(String value) {
            addCriterion("u_school >", value, "uSchool");
            return (Criteria) this;
        }

        public Criteria andUSchoolGreaterThanOrEqualTo(String value) {
            addCriterion("u_school >=", value, "uSchool");
            return (Criteria) this;
        }

        public Criteria andUSchoolLessThan(String value) {
            addCriterion("u_school <", value, "uSchool");
            return (Criteria) this;
        }

        public Criteria andUSchoolLessThanOrEqualTo(String value) {
            addCriterion("u_school <=", value, "uSchool");
            return (Criteria) this;
        }

        public Criteria andUSchoolLike(String value) {
            addCriterion("u_school like", value, "uSchool");
            return (Criteria) this;
        }

        public Criteria andUSchoolNotLike(String value) {
            addCriterion("u_school not like", value, "uSchool");
            return (Criteria) this;
        }

        public Criteria andUSchoolIn(List<String> values) {
            addCriterion("u_school in", values, "uSchool");
            return (Criteria) this;
        }

        public Criteria andUSchoolNotIn(List<String> values) {
            addCriterion("u_school not in", values, "uSchool");
            return (Criteria) this;
        }

        public Criteria andUSchoolBetween(String value1, String value2) {
            addCriterion("u_school between", value1, value2, "uSchool");
            return (Criteria) this;
        }

        public Criteria andUSchoolNotBetween(String value1, String value2) {
            addCriterion("u_school not between", value1, value2, "uSchool");
            return (Criteria) this;
        }

        public Criteria andULocationIsNull() {
            addCriterion("u_location is null");
            return (Criteria) this;
        }

        public Criteria andULocationIsNotNull() {
            addCriterion("u_location is not null");
            return (Criteria) this;
        }

        public Criteria andULocationEqualTo(String value) {
            addCriterion("u_location =", value, "uLocation");
            return (Criteria) this;
        }

        public Criteria andULocationNotEqualTo(String value) {
            addCriterion("u_location <>", value, "uLocation");
            return (Criteria) this;
        }

        public Criteria andULocationGreaterThan(String value) {
            addCriterion("u_location >", value, "uLocation");
            return (Criteria) this;
        }

        public Criteria andULocationGreaterThanOrEqualTo(String value) {
            addCriterion("u_location >=", value, "uLocation");
            return (Criteria) this;
        }

        public Criteria andULocationLessThan(String value) {
            addCriterion("u_location <", value, "uLocation");
            return (Criteria) this;
        }

        public Criteria andULocationLessThanOrEqualTo(String value) {
            addCriterion("u_location <=", value, "uLocation");
            return (Criteria) this;
        }

        public Criteria andULocationLike(String value) {
            addCriterion("u_location like", value, "uLocation");
            return (Criteria) this;
        }

        public Criteria andULocationNotLike(String value) {
            addCriterion("u_location not like", value, "uLocation");
            return (Criteria) this;
        }

        public Criteria andULocationIn(List<String> values) {
            addCriterion("u_location in", values, "uLocation");
            return (Criteria) this;
        }

        public Criteria andULocationNotIn(List<String> values) {
            addCriterion("u_location not in", values, "uLocation");
            return (Criteria) this;
        }

        public Criteria andULocationBetween(String value1, String value2) {
            addCriterion("u_location between", value1, value2, "uLocation");
            return (Criteria) this;
        }

        public Criteria andULocationNotBetween(String value1, String value2) {
            addCriterion("u_location not between", value1, value2, "uLocation");
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