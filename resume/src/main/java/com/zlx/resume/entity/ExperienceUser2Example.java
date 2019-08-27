package com.zlx.resume.entity;

import java.util.ArrayList;
import java.util.List;

public class ExperienceUser2Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExperienceUser2Example() {
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

        public Criteria andEIdIsNull() {
            addCriterion("e_id is null");
            return (Criteria) this;
        }

        public Criteria andEIdIsNotNull() {
            addCriterion("e_id is not null");
            return (Criteria) this;
        }

        public Criteria andEIdEqualTo(Integer value) {
            addCriterion("e_id =", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdNotEqualTo(Integer value) {
            addCriterion("e_id <>", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdGreaterThan(Integer value) {
            addCriterion("e_id >", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("e_id >=", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdLessThan(Integer value) {
            addCriterion("e_id <", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdLessThanOrEqualTo(Integer value) {
            addCriterion("e_id <=", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdIn(List<Integer> values) {
            addCriterion("e_id in", values, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdNotIn(List<Integer> values) {
            addCriterion("e_id not in", values, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdBetween(Integer value1, Integer value2) {
            addCriterion("e_id between", value1, value2, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdNotBetween(Integer value1, Integer value2) {
            addCriterion("e_id not between", value1, value2, "eId");
            return (Criteria) this;
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

        public Criteria andCIdIsNull() {
            addCriterion("c_id is null");
            return (Criteria) this;
        }

        public Criteria andCIdIsNotNull() {
            addCriterion("c_id is not null");
            return (Criteria) this;
        }

        public Criteria andCIdEqualTo(Integer value) {
            addCriterion("c_id =", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotEqualTo(Integer value) {
            addCriterion("c_id <>", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdGreaterThan(Integer value) {
            addCriterion("c_id >", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("c_id >=", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdLessThan(Integer value) {
            addCriterion("c_id <", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdLessThanOrEqualTo(Integer value) {
            addCriterion("c_id <=", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdIn(List<Integer> values) {
            addCriterion("c_id in", values, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotIn(List<Integer> values) {
            addCriterion("c_id not in", values, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdBetween(Integer value1, Integer value2) {
            addCriterion("c_id between", value1, value2, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotBetween(Integer value1, Integer value2) {
            addCriterion("c_id not between", value1, value2, "cId");
            return (Criteria) this;
        }

        public Criteria andEStartIsNull() {
            addCriterion("e_start is null");
            return (Criteria) this;
        }

        public Criteria andEStartIsNotNull() {
            addCriterion("e_start is not null");
            return (Criteria) this;
        }

        public Criteria andEStartEqualTo(String value) {
            addCriterion("e_start =", value, "eStart");
            return (Criteria) this;
        }

        public Criteria andEStartNotEqualTo(String value) {
            addCriterion("e_start <>", value, "eStart");
            return (Criteria) this;
        }

        public Criteria andEStartGreaterThan(String value) {
            addCriterion("e_start >", value, "eStart");
            return (Criteria) this;
        }

        public Criteria andEStartGreaterThanOrEqualTo(String value) {
            addCriterion("e_start >=", value, "eStart");
            return (Criteria) this;
        }

        public Criteria andEStartLessThan(String value) {
            addCriterion("e_start <", value, "eStart");
            return (Criteria) this;
        }

        public Criteria andEStartLessThanOrEqualTo(String value) {
            addCriterion("e_start <=", value, "eStart");
            return (Criteria) this;
        }

        public Criteria andEStartLike(String value) {
            addCriterion("e_start like", value, "eStart");
            return (Criteria) this;
        }

        public Criteria andEStartNotLike(String value) {
            addCriterion("e_start not like", value, "eStart");
            return (Criteria) this;
        }

        public Criteria andEStartIn(List<String> values) {
            addCriterion("e_start in", values, "eStart");
            return (Criteria) this;
        }

        public Criteria andEStartNotIn(List<String> values) {
            addCriterion("e_start not in", values, "eStart");
            return (Criteria) this;
        }

        public Criteria andEStartBetween(String value1, String value2) {
            addCriterion("e_start between", value1, value2, "eStart");
            return (Criteria) this;
        }

        public Criteria andEStartNotBetween(String value1, String value2) {
            addCriterion("e_start not between", value1, value2, "eStart");
            return (Criteria) this;
        }

        public Criteria andEEndIsNull() {
            addCriterion("e_end is null");
            return (Criteria) this;
        }

        public Criteria andEEndIsNotNull() {
            addCriterion("e_end is not null");
            return (Criteria) this;
        }

        public Criteria andEEndEqualTo(String value) {
            addCriterion("e_end =", value, "eEnd");
            return (Criteria) this;
        }

        public Criteria andEEndNotEqualTo(String value) {
            addCriterion("e_end <>", value, "eEnd");
            return (Criteria) this;
        }

        public Criteria andEEndGreaterThan(String value) {
            addCriterion("e_end >", value, "eEnd");
            return (Criteria) this;
        }

        public Criteria andEEndGreaterThanOrEqualTo(String value) {
            addCriterion("e_end >=", value, "eEnd");
            return (Criteria) this;
        }

        public Criteria andEEndLessThan(String value) {
            addCriterion("e_end <", value, "eEnd");
            return (Criteria) this;
        }

        public Criteria andEEndLessThanOrEqualTo(String value) {
            addCriterion("e_end <=", value, "eEnd");
            return (Criteria) this;
        }

        public Criteria andEEndLike(String value) {
            addCriterion("e_end like", value, "eEnd");
            return (Criteria) this;
        }

        public Criteria andEEndNotLike(String value) {
            addCriterion("e_end not like", value, "eEnd");
            return (Criteria) this;
        }

        public Criteria andEEndIn(List<String> values) {
            addCriterion("e_end in", values, "eEnd");
            return (Criteria) this;
        }

        public Criteria andEEndNotIn(List<String> values) {
            addCriterion("e_end not in", values, "eEnd");
            return (Criteria) this;
        }

        public Criteria andEEndBetween(String value1, String value2) {
            addCriterion("e_end between", value1, value2, "eEnd");
            return (Criteria) this;
        }

        public Criteria andEEndNotBetween(String value1, String value2) {
            addCriterion("e_end not between", value1, value2, "eEnd");
            return (Criteria) this;
        }

        public Criteria andERoleIsNull() {
            addCriterion("e_role is null");
            return (Criteria) this;
        }

        public Criteria andERoleIsNotNull() {
            addCriterion("e_role is not null");
            return (Criteria) this;
        }

        public Criteria andERoleEqualTo(String value) {
            addCriterion("e_role =", value, "eRole");
            return (Criteria) this;
        }

        public Criteria andERoleNotEqualTo(String value) {
            addCriterion("e_role <>", value, "eRole");
            return (Criteria) this;
        }

        public Criteria andERoleGreaterThan(String value) {
            addCriterion("e_role >", value, "eRole");
            return (Criteria) this;
        }

        public Criteria andERoleGreaterThanOrEqualTo(String value) {
            addCriterion("e_role >=", value, "eRole");
            return (Criteria) this;
        }

        public Criteria andERoleLessThan(String value) {
            addCriterion("e_role <", value, "eRole");
            return (Criteria) this;
        }

        public Criteria andERoleLessThanOrEqualTo(String value) {
            addCriterion("e_role <=", value, "eRole");
            return (Criteria) this;
        }

        public Criteria andERoleLike(String value) {
            addCriterion("e_role like", value, "eRole");
            return (Criteria) this;
        }

        public Criteria andERoleNotLike(String value) {
            addCriterion("e_role not like", value, "eRole");
            return (Criteria) this;
        }

        public Criteria andERoleIn(List<String> values) {
            addCriterion("e_role in", values, "eRole");
            return (Criteria) this;
        }

        public Criteria andERoleNotIn(List<String> values) {
            addCriterion("e_role not in", values, "eRole");
            return (Criteria) this;
        }

        public Criteria andERoleBetween(String value1, String value2) {
            addCriterion("e_role between", value1, value2, "eRole");
            return (Criteria) this;
        }

        public Criteria andERoleNotBetween(String value1, String value2) {
            addCriterion("e_role not between", value1, value2, "eRole");
            return (Criteria) this;
        }

        public Criteria andEBehaviourIsNull() {
            addCriterion("e_behaviour is null");
            return (Criteria) this;
        }

        public Criteria andEBehaviourIsNotNull() {
            addCriterion("e_behaviour is not null");
            return (Criteria) this;
        }

        public Criteria andEBehaviourEqualTo(String value) {
            addCriterion("e_behaviour =", value, "eBehaviour");
            return (Criteria) this;
        }

        public Criteria andEBehaviourNotEqualTo(String value) {
            addCriterion("e_behaviour <>", value, "eBehaviour");
            return (Criteria) this;
        }

        public Criteria andEBehaviourGreaterThan(String value) {
            addCriterion("e_behaviour >", value, "eBehaviour");
            return (Criteria) this;
        }

        public Criteria andEBehaviourGreaterThanOrEqualTo(String value) {
            addCriterion("e_behaviour >=", value, "eBehaviour");
            return (Criteria) this;
        }

        public Criteria andEBehaviourLessThan(String value) {
            addCriterion("e_behaviour <", value, "eBehaviour");
            return (Criteria) this;
        }

        public Criteria andEBehaviourLessThanOrEqualTo(String value) {
            addCriterion("e_behaviour <=", value, "eBehaviour");
            return (Criteria) this;
        }

        public Criteria andEBehaviourLike(String value) {
            addCriterion("e_behaviour like", value, "eBehaviour");
            return (Criteria) this;
        }

        public Criteria andEBehaviourNotLike(String value) {
            addCriterion("e_behaviour not like", value, "eBehaviour");
            return (Criteria) this;
        }

        public Criteria andEBehaviourIn(List<String> values) {
            addCriterion("e_behaviour in", values, "eBehaviour");
            return (Criteria) this;
        }

        public Criteria andEBehaviourNotIn(List<String> values) {
            addCriterion("e_behaviour not in", values, "eBehaviour");
            return (Criteria) this;
        }

        public Criteria andEBehaviourBetween(String value1, String value2) {
            addCriterion("e_behaviour between", value1, value2, "eBehaviour");
            return (Criteria) this;
        }

        public Criteria andEBehaviourNotBetween(String value1, String value2) {
            addCriterion("e_behaviour not between", value1, value2, "eBehaviour");
            return (Criteria) this;
        }

        public Criteria andEReasonIsNull() {
            addCriterion("e_reason is null");
            return (Criteria) this;
        }

        public Criteria andEReasonIsNotNull() {
            addCriterion("e_reason is not null");
            return (Criteria) this;
        }

        public Criteria andEReasonEqualTo(String value) {
            addCriterion("e_reason =", value, "eReason");
            return (Criteria) this;
        }

        public Criteria andEReasonNotEqualTo(String value) {
            addCriterion("e_reason <>", value, "eReason");
            return (Criteria) this;
        }

        public Criteria andEReasonGreaterThan(String value) {
            addCriterion("e_reason >", value, "eReason");
            return (Criteria) this;
        }

        public Criteria andEReasonGreaterThanOrEqualTo(String value) {
            addCriterion("e_reason >=", value, "eReason");
            return (Criteria) this;
        }

        public Criteria andEReasonLessThan(String value) {
            addCriterion("e_reason <", value, "eReason");
            return (Criteria) this;
        }

        public Criteria andEReasonLessThanOrEqualTo(String value) {
            addCriterion("e_reason <=", value, "eReason");
            return (Criteria) this;
        }

        public Criteria andEReasonLike(String value) {
            addCriterion("e_reason like", value, "eReason");
            return (Criteria) this;
        }

        public Criteria andEReasonNotLike(String value) {
            addCriterion("e_reason not like", value, "eReason");
            return (Criteria) this;
        }

        public Criteria andEReasonIn(List<String> values) {
            addCriterion("e_reason in", values, "eReason");
            return (Criteria) this;
        }

        public Criteria andEReasonNotIn(List<String> values) {
            addCriterion("e_reason not in", values, "eReason");
            return (Criteria) this;
        }

        public Criteria andEReasonBetween(String value1, String value2) {
            addCriterion("e_reason between", value1, value2, "eReason");
            return (Criteria) this;
        }

        public Criteria andEReasonNotBetween(String value1, String value2) {
            addCriterion("e_reason not between", value1, value2, "eReason");
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